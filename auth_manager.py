#!/usr/bin/env python3
"""
🏰 Disneyland Paris - Unified Authentication & Session Keeper Manager (OneID JGC v8)
====================================================================================
Maintains a 100% autonomous, high-trust session (AUTHZ_GUEST_SECURED_SESSION) for
Disneyland Paris APIs (DRS Dining Reservation Service, GraphQL, WaitTimes).

Architecture:
  - Tier 1: Silent REST Token Refresh (~200ms) via 180-day refresh_token.
  - Tier 2: Headless Playwright Browser with Persistent Profile (.disney_browser_profile).
            Once device trust is established, logins with password bypass OTP.
  - Tier 3: Automated OTP resolution (via IMAP if configured, or interactive/file fallback).
"""

import os
import sys
import json
import time
import re
import ssl
import logging
import argparse
import urllib.request
import urllib.error
from datetime import datetime, timezone
from typing import Optional, Dict, Any, List

# Ensure safe output on Windows console
if hasattr(sys.stdout, "reconfigure"):
    try:
        sys.stdout.reconfigure(encoding="utf-8")
    except Exception:
        pass
if hasattr(sys.stderr, "reconfigure"):
    try:
        sys.stderr.reconfigure(encoding="utf-8")
    except Exception:
        pass

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S"
)
logger = logging.getLogger("DisneylandAuth")

BASE_DIR = os.path.dirname(os.path.abspath(__file__))


def load_env(env_path: Optional[str] = None) -> Dict[str, str]:
    """Lightweight .env file loader without external dependencies."""
    if not env_path:
        env_path = os.path.join(BASE_DIR, ".env")
    env_vars: Dict[str, str] = {}
    if os.path.exists(env_path):
        with open(env_path, "r", encoding="utf-8") as f:
            for line in f:
                line = line.strip()
                if not line or line.startswith("#") or "=" not in line:
                    continue
                k, v = line.split("=", 1)
                k = k.strip()
                v = v.strip().strip("'\"")
                env_vars[k] = v
                if k not in os.environ:
                    os.environ[k] = v
    return env_vars


# Preload environment variables
_ENV = load_env()


class DisneylandAuthManager:
    """Centralized manager for Disney OneID authentication and session lifecycle."""

    JGC_REFRESH_URL = "https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/refresh-auth"
    JGC_LOGIN_URL = "https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/login"
    ONEID_LOGIN_PAGE = "https://www.disneylandparis.com/fr-fr/my-disneyland/login"
    API_KEY_DRS = "AaQHDoRgDa66dl2PQuTEe9DjyBlH8ylV4LxnldFY"

    def __init__(
        self,
        session_file: Optional[str] = None,
        profile_dir: Optional[str] = None,
        email: Optional[str] = None,
        password: Optional[str] = None
    ):
        self.session_file = session_file or os.getenv("DISNEY_SESSION_FILE", os.path.join(BASE_DIR, "authenticated_session.json"))
        if not os.path.isabs(self.session_file):
            self.session_file = os.path.join(BASE_DIR, self.session_file)

        self.profile_dir = profile_dir or os.getenv("DISNEY_BROWSER_PROFILE", os.path.join(BASE_DIR, ".disney_browser_profile"))
        if not os.path.isabs(self.profile_dir):
            self.profile_dir = os.path.join(BASE_DIR, self.profile_dir)

        self.email = email or os.getenv("DISNEY_EMAIL", "")
        self.password = password or os.getenv("DISNEY_PASSWORD", "")

        self.imap_host = os.getenv("IMAP_HOST", "")
        self.imap_port = int(os.getenv("IMAP_PORT", "993"))
        self.imap_user = os.getenv("IMAP_USER", "")
        self.imap_password = os.getenv("IMAP_PASSWORD", "")
        self.imap_use_ssl = os.getenv("IMAP_USE_SSL", "true").lower() in ("true", "1", "yes")

    # -------------------------------------------------------------------------
    # Session Loading & Inspection
    # -------------------------------------------------------------------------
    def load_session(self) -> Dict[str, Any]:
        """Loads and returns current authenticated_session.json."""
        if not os.path.exists(self.session_file):
            return {}
        try:
            with open(self.session_file, "r", encoding="utf-8") as f:
                return json.load(f)
        except Exception as e:
            logger.warning(f"Failed to read session file: {e}")
            return {}

    def save_session(self, data: Dict[str, Any]) -> None:
        """Saves data into authenticated_session.json atomically."""
        tmp_file = f"{self.session_file}.tmp"
        try:
            with open(tmp_file, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=2)
            if os.path.exists(self.session_file):
                os.remove(self.session_file)
            os.rename(tmp_file, self.session_file)
            logger.info(f"Session successfully saved to {self.session_file}")
        except Exception as e:
            logger.error(f"Error saving session: {e}")
            if os.path.exists(tmp_file):
                os.remove(tmp_file)

    def get_token_info(self) -> Dict[str, Any]:
        """Extracts token dictionary from session."""
        session = self.load_session()
        # Direct token object
        if "token" in session and isinstance(session["token"], dict):
            return session["token"]
        # Nested inside guest
        if "guest" in session and isinstance(session["guest"], dict):
            t = session["guest"].get("token")
            if isinstance(t, dict):
                return t
        # Fallback to top-level fields
        if "access_token" in session:
            return {
                "access_token": session.get("access_token"),
                "refresh_token": session.get("refresh_token"),
                "swid": session.get("swid"),
                "scope": session.get("scope"),
                "exp": session.get("exp"),
                "high_trust_exp": session.get("high_trust_exp")
            }
        return {}

    def is_token_valid(self, require_high_trust: bool = True, buffer_seconds: int = 60) -> bool:
        """Checks if current access_token is alive and meets trust requirements."""
        token_info = self.get_token_info()
        access_token = token_info.get("access_token")
        if not access_token:
            return False

        now_ms = int(time.time() * 1000)
        # exp check
        exp = token_info.get("exp")
        if exp:
            # exp might be in seconds or ms
            exp_ms = exp if exp > 10_000_000_000 else exp * 1000
            if exp_ms - (buffer_seconds * 1000) <= now_ms:
                logger.debug("Token exp is expired or within buffer.")
                return False

        # high trust check
        if require_high_trust:
            scope = str(token_info.get("scope") or "")
            ht_exp = token_info.get("high_trust_exp")
            if not ht_exp and "AUTHZ_GUEST_SECURED_SESSION" not in scope:
                logger.debug("Token scope is not AUTHZ_GUEST_SECURED_SESSION and no high_trust_exp.")
                return False

            if ht_exp:
                ht_exp_ms = ht_exp if ht_exp > 10_000_000_000 else ht_exp * 1000
                if ht_exp_ms - (buffer_seconds * 1000) <= now_ms:
                    logger.debug("High trust session has expired.")
                    return False

        return True

    # -------------------------------------------------------------------------
    # Tier 1: Silent REST Refresh (No Browser)
    # -------------------------------------------------------------------------
    def refresh_session(self) -> bool:
        """
        Calls JGC v8 refresh-auth endpoint using refresh_token.
        Fast (~200ms), zero headless browser, zero bot detection risk.
        """
        token_info = self.get_token_info()
        refresh_token = token_info.get("refresh_token")
        if not refresh_token:
            logger.info("No refresh_token found in session.")
            return False

        logger.info("Attempting silent REST token refresh (Tier 1)...")
        headers = {
            "Content-Type": "application/json",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
            "Accept": "application/json"
        }
        payload = {"refreshToken": refresh_token}
        data_bytes = json.dumps(payload).encode("utf-8")

        req = urllib.request.Request(self.JGC_REFRESH_URL, data=data_bytes, headers=headers, method="POST")
        ctx = ssl.create_default_context()

        try:
            with urllib.request.urlopen(req, context=ctx, timeout=10) as res:
                if res.status == 200:
                    resp_data = json.loads(res.read().decode("utf-8"))
                    new_token = resp_data.get("data", {}).get("token", {})
                    if new_token and new_token.get("access_token"):
                        logger.info("Silent token refresh succeeded!")
                        # Merge into session
                        session = self.load_session()
                        session["token"] = new_token
                        if "guest" in session and isinstance(session["guest"], dict):
                            session["guest"]["token"] = new_token
                        session["access_token"] = new_token.get("access_token")
                        session["refresh_token"] = new_token.get("refresh_token")
                        session["scope"] = new_token.get("scope")
                        session["swid"] = new_token.get("swid")
                        session["exp"] = new_token.get("exp")
                        session["high_trust_exp"] = new_token.get("high_trust_exp")
                        session["last_refresh"] = time.time()
                        self.save_session(session)
                        return True
        except urllib.error.HTTPError as e:
            err_body = e.read().decode("utf-8", errors="ignore")
            logger.warning(f"Refresh HTTP {e.code}: {err_body[:200]}")
        except Exception as e:
            logger.warning(f"Silent refresh error: {e}")

        return False

    # -------------------------------------------------------------------------
    # Tier 2 & 3: Playwright Browser Persistent Login + Automated OTP
    # -------------------------------------------------------------------------
    def full_browser_login(self, headless: bool = True, timeout_sec: int = 120) -> bool:
        """
        Launches Playwright with a persistent browser profile.
        Once verified, device trust prevents repeated 2FA/OTP prompts.
        """
        try:
            from playwright.sync_api import sync_playwright
        except ImportError:
            logger.error("Playwright is not installed. Install via: pip install playwright && playwright install msedge")
            return False

        if not self.email or not self.password:
            logger.error("DISNEY_EMAIL and DISNEY_PASSWORD must be configured in .env or arguments.")
            return False

        os.makedirs(self.profile_dir, exist_ok=True)
        logger.info(f"Launching persistent browser context (Tier 2) in: {self.profile_dir}")

        # Check if currently flagged by rate-limit
        session = self.load_session()
        rl_until = session.get("rate_limit_until", 0)
        if time.time() < rl_until:
            rem_min = int((rl_until - time.time()) / 60)
            logger.warning(f"Anti-flag protection active: Account is under Disney cooldown ({rem_min} min remaining).")
            logger.warning("Aborting browser launch to prevent severe account lockout.")
            return False

        with sync_playwright() as p:
            import random

            def _human_type(elem, text: str, pg):
                """Simulates natural human typing with randomized delays to bypass Arkose/Palomino bot detection."""
                elem.focus()
                time.sleep(random.uniform(0.15, 0.35))
                for char in text:
                    pg.keyboard.press(char)
                    time.sleep(random.uniform(0.04, 0.11))
                time.sleep(random.uniform(0.2, 0.4))

            context = p.chromium.launch_persistent_context(
                user_data_dir=self.profile_dir,
                channel="msedge",
                headless=headless,
                viewport={"width": 1280, "height": 900},
                user_agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0",
                locale="fr-FR"
            )

            page = context.new_page()
            captured_tokens: List[Dict[str, Any]] = []

            def on_res(r):
                if any(k in r.url for k in ["login", "token", "refresh", "guest", "otp", "auth", "jgc"]):
                    try:
                        ct = r.headers.get("content-type", "")
                        if "json" in ct:
                            text = r.text()
                            if "access_token" in text:
                                parsed = json.loads(text)
                                captured_tokens.append(parsed)
                                logger.info(f"Captured token response from {r.url[:70]}")
                    except Exception:
                        pass

            page.on("response", on_res)

            logger.info(f"Navigating to {self.ONEID_LOGIN_PAGE}...")
            page.goto(self.ONEID_LOGIN_PAGE, wait_until="domcontentloaded")
            page.wait_for_timeout(3000)

            # 1. Handle OneTrust cookie banner
            for _ in range(5):
                try:
                    c = page.locator("#onetrust-accept-btn-handler")
                    if c.count() > 0 and c.is_visible():
                        c.click()
                        logger.info("Accepted OneTrust cookies.")
                        page.wait_for_timeout(1000)
                        break
                except Exception:
                    pass
                page.wait_for_timeout(500)

            # 2. Hook window.didInit and session listeners
            try:
                page.wait_for_function("() => window.didInit === true", timeout=25000)
                logger.info("OneID window.didInit is active.")
            except Exception:
                logger.warning("Timed out waiting for window.didInit.")

            page.evaluate("""() => {
                window.__did_guest = null;
                if (window.did) {
                    window.did.on('login', (g) => { window.__did_guest = g; });
                    window.did.on('refresh', (g) => { window.__did_guest = g; });
                }
            }""")

            # Check if persistent context is already logged in
            try:
                is_logged = page.evaluate("() => window.did && window.did.getLoggedInStatus && window.did.getLoggedInStatus()")
                if is_logged:
                    logger.info("Browser session is already logged in! Extracting guest profile...")
                    guest = page.evaluate("() => window.did.getGuest()")
                    if guest:
                        self._process_successful_login(context, guest, captured_tokens)
                        context.close()
                        return True
            except Exception:
                pass

            # 3. Launch login modal if not already open
            try:
                page.evaluate("() => window.did && window.did.launchLogin && window.did.launchLogin()")
                page.wait_for_timeout(3500)
            except Exception:
                pass

            # 4. Find OneID iframe
            iframe = None
            for _ in range(15):
                for f in page.frames:
                    if "registerdisney" in f.url or "oneid" in f.name:
                        iframe = f
                        break
                if iframe:
                    break
                page.wait_for_timeout(1000)

            if iframe:
                page.wait_for_timeout(2000)
                # Check for rate-limiting message (flag detection)
                frame_text = iframe.evaluate("() => document.body ? document.body.innerText : ''")
                if "d'autres codes pour le moment" in frame_text:
                    logger.error("Disney Flag Detected: Rate limit triggered. Saving cooldown timer (20 min).")
                    s = self.load_session()
                    s["rate_limit_until"] = time.time() + 1200
                    self.save_session(s)
                    context.close()
                    return False

                # Submit Email if field is present (with human typing)
                email_in = iframe.locator("input[type='email'], input[name='email'], #InputIdentityFlowValue, #email")
                if email_in.count() > 0 and email_in.first.is_visible():
                    logger.info(f"Filling email: {self.email}")
                    _human_type(email_in.first, self.email, page)
                    btn = iframe.locator("button[type='submit'], #BtnSubmit, button:has-text('Continuer')").first
                    btn.click()
                    page.wait_for_timeout(3500)

                # Submit Password if field is present (with human typing)
                pwd_in = iframe.locator("input[type='password'], input[name='password'], #InputPassword, #password")
                if pwd_in.count() > 0 and pwd_in.first.is_visible():
                    logger.info("Filling password with stealth typing...")
                    _human_type(pwd_in.first, self.password, page)
                    btn = iframe.locator("button[type='submit'], #BtnSubmit, button:has-text('Continuer'), button:has-text(\"S'identifier\")").first
                    btn.click()
                    logger.info("Submitted password.")
                    page.wait_for_timeout(5000)

                # Check if rate-limited after password submission
                frame_text = iframe.evaluate("() => document.body ? document.body.innerText : ''")
                if "d'autres codes pour le moment" in frame_text:
                    logger.error("Disney Flag Detected: Rate limit triggered. Saving cooldown timer (20 min).")
                    s = self.load_session()
                    s["rate_limit_until"] = time.time() + 1200
                    self.save_session(s)
                    context.close()
                    return False

                # Check if OTP screen appeared
                otp_heading = iframe.locator("text='Consultez vos e-mails', text='code à 6 chiffres'")
                if otp_heading.count() > 0 or iframe.locator("input[type='tel'], input[maxlength='1']").count() > 0:
                    logger.warning("Step-up 2FA triggered! Invoking OTP resolver (Tier 3)...")
                    self._resolve_otp(page, iframe)

            # Wait for redirect and settling
            page.wait_for_timeout(6000)

            # Extract guest from page event or did.getGuest()
            guest = page.evaluate("() => window.__did_guest")
            if not guest:
                try:
                    guest = page.evaluate("() => window.did && window.did.getGuest && window.did.getGuest()")
                except Exception:
                    pass

            # Process login results from context cookies and captured responses
            self._process_successful_login(context, guest, captured_tokens)
            context.close()

            if self.is_token_valid(require_high_trust=False):
                logger.info("Full browser login completed and verified active!")
                return True

            logger.warning("Browser login finished but token could not be verified.")
            return False

    def _resolve_otp(self, page, iframe) -> bool:
        """Resolves 6-digit OTP via IMAP if configured, or console/file prompt."""
        code: Optional[str] = None

        # 1. Try automated IMAP retrieval
        if self.imap_host and self.imap_user and self.imap_password:
            logger.info(f"Querying IMAP inbox ({self.imap_user}@{self.imap_host}) for Disney OTP code...")
            for attempt in range(12):  # Poll for up to 60 seconds
                code = self._fetch_otp_from_imap()
                if code:
                    logger.info(f"Extracted Disney OTP code via IMAP: {code}")
                    break
                time.sleep(5)

        # 2. Fallback to file or console prompt
        if not code:
            code_file = os.path.join(BASE_DIR, "code.txt")
            logger.info("=" * 60)
            logger.info(f"DISNEY 2FA OTP REQUIRED: Please check {self.email}")
            logger.info(f"Enter the 6 digits in file: {code_file}")
            logger.info("=" * 60)

            if os.path.exists(code_file):
                os.remove(code_file)

            for _ in range(600):  # Wait up to 10 minutes
                if os.path.exists(code_file):
                    with open(code_file, "r", encoding="utf-8") as cf:
                        val = cf.read().strip()
                        if len(val) == 6 and val.isdigit():
                            code = val
                            logger.info(f"Found OTP code in {code_file}: {code}")
                            break
                time.sleep(1)

        if not code:
            logger.error("No valid 6-digit OTP code provided within timeout.")
            return False

        # Type the OTP into the OneID input boxes sequentially using real keystrokes
        logger.info(f"Typing OTP code {code} into OneID iframe...")
        inputs = iframe.locator("input[type='tel'], input[type='number'], input[maxlength='1']")
        if inputs.count() == 6:
            for i in range(6):
                box = inputs.nth(i)
                box.click()
                box.fill(code[i])
                page.wait_for_timeout(100)
        else:
            first_in = iframe.locator("input").first
            if first_in.count() > 0:
                first_in.focus()
                for char in code:
                    page.keyboard.press(char)
                    page.wait_for_timeout(100)

        page.wait_for_timeout(800)
        submit_btn = iframe.locator("button[type='submit'], #BtnSubmit, button:has-text('Continuer')").first
        if submit_btn.count() > 0:
            submit_btn.click()
            logger.info("Clicked Continuer on OTP screen.")

        page.wait_for_timeout(6000)

        # Check for error message in iframe
        try:
            err_elem = iframe.locator("text='Il semble y avoir une erreur', text='Code non valide', text='expiré'")
            if err_elem.count() > 0 and err_elem.first.is_visible():
                logger.error("OTP code was rejected or expired by Disney OneID.")
                return False
        except Exception:
            pass

        return True

    def _fetch_otp_from_imap(self) -> Optional[str]:
        """Connects to IMAP mailbox and extracts latest 6-digit code from Disney."""
        try:
            import imaplib
            import email

            if self.imap_use_ssl:
                mail = imaplib.IMAP4_SSL(self.imap_host, self.imap_port)
            else:
                mail = imaplib.IMAP4(self.imap_host, self.imap_port)

            mail.login(self.imap_user, self.imap_password)
            mail.select("inbox")

            status, search_data = mail.search(None, '(FROM "Disney" UNSEEN)')
            if status != "OK" or not search_data[0]:
                status, search_data = mail.search(None, '(FROM "Disney")')

            if status == "OK" and search_data[0]:
                msg_ids = search_data[0].split()
                latest_id = msg_ids[-1]
                _, msg_data = mail.fetch(latest_id, "(RFC822)")
                msg = email.message_from_bytes(msg_data[0][1])

                body = ""
                if msg.is_multipart():
                    for part in msg.walk():
                        if part.get_content_type() in ("text/plain", "text/html"):
                            body += part.get_payload(decode=True).decode("utf-8", errors="ignore")
                else:
                    body = msg.get_payload(decode=True).decode("utf-8", errors="ignore")

                mail.logout()
                # Find 6 digits code
                matches = re.findall(r"\b\d{6}\b", body)
                if matches:
                    return matches[0]
        except Exception as e:
            logger.debug(f"IMAP fetch attempt failed: {e}")
        return None

    def _process_successful_login(self, context, guest: Any, captured_tokens: List[Dict[str, Any]]) -> None:
        """Consolidates cookies and token data into authenticated_session.json."""
        import base64
        cookies = context.cookies()
        session_data = self.load_session()
        session_data["cookies"] = cookies
        session_data["last_login"] = time.time()

        # 1. Process OneID guest object
        if guest and isinstance(guest, dict):
            session_data["guest"] = guest
            tok = guest.get("token")
            if isinstance(tok, dict):
                session_data["token"] = tok
                session_data["access_token"] = tok.get("access_token")
                session_data["refresh_token"] = tok.get("refresh_token")
                session_data["swid"] = tok.get("swid") or guest.get("profile", {}).get("swid")
                session_data["scope"] = tok.get("scope")
                session_data["exp"] = tok.get("exp")
                session_data["high_trust_exp"] = tok.get("high_trust_exp")
                logger.info("Successfully extracted token and scope from OneID guest object!")

        # 2. Process captured network tokens
        if not session_data.get("access_token") and captured_tokens:
            for item in captured_tokens:
                data = item.get("data", {}) if isinstance(item, dict) else item
                tok = data.get("data", {}).get("token") or data.get("token")
                if tok and isinstance(tok, dict) and tok.get("access_token"):
                    session_data["token"] = tok
                    session_data["access_token"] = tok.get("access_token")
                    session_data["refresh_token"] = tok.get("refresh_token")
                    session_data["swid"] = tok.get("swid")
                    session_data["scope"] = tok.get("scope", "AUTHZ_GUEST_SECURED_SESSION")
                    session_data["exp"] = tok.get("exp")
                    session_data["high_trust_exp"] = tok.get("high_trust_exp")
                    logger.info("Successfully extracted token from captured JGC network response!")
                    break

        # 3. Check cookies for TPR-DLP.WEB-PROD.token (contains complete token object + JWT)
        if not session_data.get("access_token"):
            for c in cookies:
                if c.get("name") == "TPR-DLP.WEB-PROD.token":
                    try:
                        val = c.get("value", "")
                        parts = val.split("|")
                        b64_token = parts[0].split("=", 1)[1]
                        b64_token += "=" * (-len(b64_token) % 4)
                        tok_data = json.loads(base64.b64decode(b64_token).decode("utf-8"))

                        scopes = []
                        if len(parts) > 1:
                            jwt_part = parts[1].split(".")[1]
                            jwt_part += "=" * (-len(jwt_part) % 4)
                            jwt_data = json.loads(base64.b64decode(jwt_part).decode("utf-8"))
                            scopes = jwt_data.get("scopes", [])

                        scope_str = " ".join(scopes) if isinstance(scopes, list) else str(scopes)

                        session_data["access_token"] = tok_data.get("access_token")
                        session_data["refresh_token"] = tok_data.get("refresh_token")
                        session_data["swid"] = tok_data.get("swid") or jwt_data.get("sub")
                        session_data["scope"] = scope_str or "AUTHZ_GUEST_SECURED_SESSION"
                        session_data["exp"] = tok_data.get("exp") or jwt_data.get("exp")
                        session_data["high_trust_exp"] = tok_data.get("high_trust_exp")
                        session_data["token"] = {**tok_data, "scope": session_data["scope"]}
                        logger.info("Successfully extracted complete token data and High-Trust scope from cookie!")
                        break
                    except Exception as e:
                        logger.warning(f"Error parsing TPR-DLP.WEB-PROD.token cookie: {e}")

        # 4. Check SWID cookie if swid still missing
        if not session_data.get("swid"):
            for c in cookies:
                if c.get("name") == "SWID" and c.get("value"):
                    session_data["swid"] = c["value"]
                    break

        self.save_session(session_data)
        logger.info("Authentication session fully consolidated and saved.")

    # -------------------------------------------------------------------------
    # Main Public Token Getter
    # -------------------------------------------------------------------------
    def get_valid_token(self, require_high_trust: bool = True, force_refresh: bool = False) -> str:
        """
        Returns a guaranteed valid access_token.
        Refreshes silently or logs in automatically if required.
        """
        if not force_refresh and self.is_token_valid(require_high_trust=require_high_trust):
            token = self.get_token_info().get("access_token", "")
            return token

        # Step 1: Silent REST refresh
        if self.refresh_session():
            token = self.get_token_info().get("access_token", "")
            if token and (not require_high_trust or self.is_token_valid(require_high_trust=require_high_trust)):
                return token

        # Step 2: Full browser persistent login
        logger.info("Silent refresh insufficient. Performing automated persistent browser login...")
        if self.full_browser_login(headless=True):
            token = self.get_token_info().get("access_token", "")
            if token:
                return token

        raise RuntimeError("Failed to obtain a valid Disneyland Paris access token.")

    # -------------------------------------------------------------------------
    # CLI Status & Daemon
    # -------------------------------------------------------------------------
    def print_status(self) -> None:
        """Prints a human-readable summary of session health."""
        session = self.load_session()
        token = self.get_token_info()

        print("\n" + "=" * 65)
        print("[*] Disneyland Paris OneID Session Status")
        print("=" * 65)
        print(f"Session File      : {self.session_file}")
        print(f"Browser Profile   : {self.profile_dir}")
        print(f"Configured Email  : {self.email or '(None)'}")

        swid = token.get("swid") or session.get("swid") or "(None)"
        print(f"SWID              : {swid}")

        access_token = token.get("access_token")
        if access_token:
            masked = f"{access_token[:6]}...{access_token[-6:]}" if len(access_token) > 12 else access_token
            print(f"Access Token      : {masked} [ACTIVE]")
        else:
            print(f"Access Token      : None [EXPIRED / MISSING]")

        scope = str(token.get("scope") or session.get("scope") or "")
        print(f"Scope             : {scope or '(None)'}")

        ht_exp = token.get("high_trust_exp") or session.get("high_trust_exp")
        now_ts = time.time()
        is_high_trust = ("AUTHZ_GUEST_SECURED_SESSION" in scope) or bool(ht_exp and (ht_exp / 1000 if ht_exp > 10_000_000_000 else ht_exp) > now_ts)
        print(f"High-Trust State  : {'[SECURED - DRS Enabled]' if is_high_trust else '[UNSECURED - Refreshed Only]'}")

        if ht_exp:
            ht_ts = ht_exp / 1000 if ht_exp > 10_000_000_000 else ht_exp
            ht_rem = int((ht_ts - now_ts) / 60)
            print(f"High-Trust Expiry : {ht_rem} min remaining ({'VALID' if ht_rem > 0 else 'EXPIRED'})")

        exp = token.get("exp")
        if exp:
            exp_ts = exp / 1000 if exp > 10_000_000_000 else exp
            dt = datetime.fromtimestamp(exp_ts, tz=timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
            diff_min = int((exp_ts - time.time()) / 60)
            print(f"Token Expiry      : {dt} ({diff_min} min remaining)")

        refresh_token = token.get("refresh_token")
        if refresh_token:
            masked_rt = f"{refresh_token[:6]}...{refresh_token[-6:]}"
            print(f"Refresh Token     : {masked_rt} (Valid up to 180 days)")
        else:
            print(f"Refresh Token     : None")

        cookies_count = len(session.get("cookies", []))
        print(f"Cookies Count     : {cookies_count}")
        print("=" * 65 + "\n")

    def get_profile(self) -> Dict[str, Any]:
        """
        Fetches the authenticated Disney OneID guest profile via JGC v8.
        Endpoint: GET https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/{swid}
        """
        token = self.get_valid_token(require_high_trust=False)
        if not token:
            logger.error("Cannot fetch profile: No valid token.")
            return {}
        swid = self.get_token_info().get("swid")
        if not swid:
            logger.error("Cannot fetch profile: SWID not found in token.")
            return {}

        url = f"https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/{swid}"
        headers = {
            "Authorization": f"BEARER {token}",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
        }
        req = urllib.request.Request(url, headers=headers)
        ctx = ssl.create_default_context()
        try:
            with urllib.request.urlopen(req, context=ctx, timeout=10) as res:
                if res.status == 200:
                    data = json.loads(res.read().decode("utf-8"))
                    profile = data.get("data", {}).get("profile", {})
                    return profile
        except Exception as e:
            logger.warning(f"Failed to fetch profile: {e}")
        return {}

    def run_daemon(self, interval_sec: int = 1800) -> None:
        """Keeps the token permanently alive in the background."""
        logger.info(f"Starting Disneyland Paris Auth Daemon (Refresh interval: {interval_sec}s)...")
        while True:
            try:
                if not self.is_token_valid(require_high_trust=True, buffer_seconds=300):
                    logger.info("Token needs renewal. Refreshing...")
                    self.get_valid_token(require_high_trust=True)
                else:
                    logger.info("Token is healthy and high-trust. Sleeping...")
            except Exception as e:
                logger.error(f"Daemon refresh error: {e}")
            time.sleep(interval_sec)


def main():
    parser = argparse.ArgumentParser(description="Disneyland Paris Autonomous Auth & Session Keeper")
    parser.add_argument("command", choices=["status", "get-token", "refresh", "login", "profile", "daemon"],
                        nargs="?", default="status", help="Command to execute")
    parser.add_argument("--interval", type=int, default=1800, help="Interval for daemon mode (seconds)")
    parser.add_argument("--headful", action="store_true", help="Run browser in headful mode for debugging")
    args = parser.parse_args()

    manager = DisneylandAuthManager()

    if args.command == "status":
        manager.print_status()
    elif args.command == "get-token":
        try:
            tok = manager.get_valid_token()
            print(tok)
        except Exception as e:
            sys.exit(f"Error: {e}")
    elif args.command == "refresh":
        success = manager.refresh_session()
        manager.print_status()
        sys.exit(0 if success else 1)
    elif args.command == "login":
        success = manager.full_browser_login(headless=not args.headful)
        manager.print_status()
        sys.exit(0 if success else 1)
    elif args.command == "profile":
        prof = manager.get_profile()
        if prof:
            print(json.dumps(prof, indent=2))
        else:
            sys.exit("Failed to retrieve profile.")
    elif args.command == "daemon":
        manager.run_daemon(interval_sec=args.interval)


if __name__ == "__main__":
    main()
