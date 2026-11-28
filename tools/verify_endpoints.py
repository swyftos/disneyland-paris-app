#!/usr/bin/env python3
"""
Vérifie que les endpoints PUBLICS documentés répondent toujours avec le schéma attendu.

- Aucun compte ni jeton requis (WaitTimes, GraphQL public, CDN). Les endpoints DRS / OneID ne sont pas testés.
- Dépendances : bibliothèque standard uniquement.
- Une seule requête par endpoint : à lancer au plus une fois par jour (voir spec §6).

Usage :
    python tools/verify_endpoints.py            # rapport lisible
    python tools/verify_endpoints.py --json     # rapport JSON (pour la CI)
    python tools/verify_endpoints.py --dump DIR # sauvegarde les réponses brutes dans DIR

Code de sortie : 0 si tout est OK, 1 si au moins un endpoint a changé ou échoue.
"""
import argparse
import json
import os
import sys
import urllib.error
import urllib.request
from datetime import date, datetime, timezone
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
QUERIES = ROOT / "queries"

WAIT_TIMES_KEY = "3jPT5qMimN3kR2kxqd1ez9iF1C68CrBf7zw5ICo4"
UA_APP = "okhttp/4.12.0"


def http(method, url, headers=None, body=None, timeout=20):
    data = json.dumps(body).encode() if body is not None else None
    req = urllib.request.Request(url, data=data, method=method, headers=headers or {})
    try:
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return r.status, json.loads(r.read().decode("utf-8") or "null")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")[:300]


def graphql(name, variables):
    query = (QUERIES / f"{name}.graphql").read_text(encoding="utf-8")
    return http(
        "POST",
        "https://api.disneylandparis.com/query",
        {"x-application-id": "mobile-app", "Content-Type": "application/json",
         "Accept": "application/json", "User-Agent": UA_APP},
        {"query": query, "variables": variables},
    )


def load_vars(name):
    p = QUERIES / f"{name}.variables.json"
    v = json.loads(p.read_text(encoding="utf-8"))
    return v


def require(obj, keys, where):
    missing = [k for k in keys if k not in obj]
    return [f"{where}: champ(s) manquant(s) {missing}"] if missing else []


# --- Checks : chacun renvoie (status_http, liste_problèmes, résumé, payload) ---

def check_wait_times():
    st, data = http("GET", "https://dlp-wt.wdprapps.disney.com/prod/v1/waitTimes",
                    {"x-api-key": WAIT_TIMES_KEY, "User-Agent": UA_APP, "Accept": "application/json"})
    if st != 200:
        return st, [f"HTTP {st}"], "", data
    if not isinstance(data, list):
        return st, ["réponse n'est pas un tableau"], "", data
    if not data:
        return st, [], "0 entrée (normal hors horaires d'ouverture)", data
    probs = require(data[0], ["id", "status"], "waitTimes[0]")
    statuses = sorted({str(x.get("status")) for x in data})
    return st, probs, f"{len(data)} entrées, status={statuses}", data


def check_graphql(name, root_field):
    st, data = graphql(name, load_vars(name))
    if st != 200:
        return st, [f"HTTP {st}"], "", data
    if not isinstance(data, dict) or data.get("errors"):
        return st, [f"erreurs GraphQL : {str(data.get('errors'))[:200]}"], "", data
    items = (data.get("data") or {}).get(root_field)
    if not isinstance(items, list):
        return st, [f"data.{root_field} absent"], "", data
    probs = require(items[0], ["id", "name"], f"{root_field}[0]") if items else []
    return st, probs, f"{len(items)} éléments", data


def check_tiles():
    st, data = http("GET", "https://media.disneylandparis.com/mapTilesMobile/images/tilesConfig717.json",
                    {"User-Agent": UA_APP})
    probs = [] if st == 200 else [f"HTTP {st}"]
    keys = sorted(data.keys())[:8] if isinstance(data, dict) else type(data).__name__
    return st, probs, f"clés : {keys}", data


CHECKS = [
    ("waitTimes", check_wait_times),
    ("graphql.activitySchedules", lambda: check_graphql("activitySchedules", "activitySchedules")),
    ("graphql.themeParks", lambda: check_graphql("themeParks", "activities")),
    ("graphql.attraction", lambda: check_graphql("attraction", "activities")),
    ("graphql.restaurants", lambda: check_graphql("restaurants", "activities")),
    ("graphql.entertainment", lambda: check_graphql("entertainment", "activities")),
    ("cdn.tilesConfig717", check_tiles),
]


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--json", action="store_true")
    ap.add_argument("--dump", metavar="DIR")
    args = ap.parse_args()

    results, ok = [], True
    for name, fn in CHECKS:
        try:
            st, probs, summary, payload = fn()
        except Exception as e:  # réseau, JSON invalide…
            st, probs, summary, payload = None, [f"{type(e).__name__}: {e}"], "", None
        ok &= not probs
        results.append({"endpoint": name, "http": st, "ok": not probs, "summary": summary, "problems": probs})
        if args.dump and payload is not None:
            os.makedirs(args.dump, exist_ok=True)
            Path(args.dump, f"{name}.json").write_text(json.dumps(payload, ensure_ascii=False, indent=2), encoding="utf-8")

    report = {"checked_at": datetime.now(timezone.utc).isoformat(timespec="seconds"), "ok": ok, "results": results}
    if args.json:
        print(json.dumps(report, ensure_ascii=False, indent=2))
    else:
        for r in results:
            mark = "OK  " if r["ok"] else "FAIL"
            print(f"[{mark}] {r['endpoint']:<34} HTTP {r['http']}  {r['summary']}")
            for p in r["problems"]:
                print(f"        - {p}")
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
