#!/usr/bin/env python3
"""
🍽️ Disneyland Paris - Dining & Restaurant Availability Scanner
================================================================
Queries Disneyland Paris dining data:
  1. Public Mode (Zero Bearer Token):
     Uses official GraphQL endpoints on api.disneylandparis.com to scan
     operating schedules, lunch/dinner service hours, and refurbishments.
  2. Secured Mode (DRS Microservice with High-Trust Session):
     Integrates with DisneylandAuthManager to fetch real-time table booking
     slots (slotList) from AWS WDPRApps DRS microservice.
"""

import os
import sys
import json
import time
import ssl
import argparse
import urllib.request
import urllib.error
from datetime import datetime
from typing import Optional, Dict, Any, List

# Ensure safe output on Windows console
if hasattr(sys.stdout, "reconfigure"):
    try:
        sys.stdout.reconfigure(encoding="utf-8")
    except Exception:
        pass

# Optional import of DisneylandAuthManager
try:
    from auth_manager import DisneylandAuthManager
except ImportError:
    DisneylandAuthManager = None

# Curated reference table of popular Disneyland Paris restaurants
POPULAR_RESTAURANTS = {
    "P1AR00": {"name": "Captain Jack's - Restaurant des Pirates", "park": "Parc Disneyland", "land": "Adventureland", "type": "Service à table"},
    "P2TR02": {"name": "Bistrot Chez Rémy", "park": "Disney Adventure World", "land": "Worlds of Pixar", "type": "Service à table"},
    "P1AR06": {"name": "Agrabah Café Restaurant", "park": "Parc Disneyland", "land": "Adventureland", "type": "Buffet"},
    "P1MR08": {"name": "Plaza Gardens Restaurant", "park": "Parc Disneyland", "land": "Main Street, U.S.A.", "type": "Buffet avec Personnages"},
    "P1NR01": {"name": "Auberge de Cendrillon", "park": "Parc Disneyland", "land": "Fantasyland", "type": "Service à table Princier"},
    "P1MR09": {"name": "Walt's - an American Restaurant", "park": "Parc Disneyland", "land": "Main Street, U.S.A.", "type": "Service à table"},
    "P1FR01": {"name": "Silver Spur Steakhouse", "park": "Parc Disneyland", "land": "Frontierland", "type": "Service à table"},
    "P2TR05": {"name": "PYM Kitchen", "park": "Disney Adventure World", "land": "Marvel Avengers Campus", "type": "Buffet"},
    "P1HR00": {"name": "La Table de Lumière", "park": "Disneyland Hotel", "land": "Hôtel", "type": "Gastronomique Princier"},
}

GRAPHQL_URL = "https://api.disneylandparis.com/query"
DRS_BASE_URL = "https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod"
DRS_API_KEY = "AaQHDoRgDa66dl2PQuTEe9DjyBlH8ylV4LxnldFY"

SCHEDULE_QUERY = """
query restaurantAvailabilities($market: String!, $types: [ActivityScheduleStatusInput]!, $date: String!) {
  activitySchedules(market: $market, date: $date, types: $types) {
    id
    name
    subType
    location {
      value
    }
    subLocation {
      value
    }
    schedules(date: $date, types: $types) {
      startTime
      endTime
      date
      status
      closed
    }
  }
}
"""


class DisneylandDiningScanner:
    """Scanner for dining schedules and real-time reservation availability."""

    def __init__(self, market: str = "fr-fr"):
        self.market = market
        self.ssl_ctx = ssl.create_default_context()
        self.auth_manager = DisneylandAuthManager() if DisneylandAuthManager else None

    # -------------------------------------------------------------------------
    # Public GraphQL Schedule API (Zero Authentication Required)
    # -------------------------------------------------------------------------
    def scan_schedules(self, date_str: str) -> List[Dict[str, Any]]:
        """
        Fetches operating schedules and status for all restaurants on a given date.
        Date format: YYYY-MM-DD.
        Requires NO token or credentials.
        """
        payload = {
            "query": SCHEDULE_QUERY,
            "variables": {
                "market": self.market,
                "types": [{"type": "Restaurant", "status": ["OPERATING", "REFURBISHMENT", "CLOSED"]}],
                "date": date_str
            }
        }
        headers = {
            "Content-Type": "application/json",
            "User-Agent": "okhttp/4.12.0",
            "Accept": "application/json",
            "x-application-id": "mobile-app"
        }

        req = urllib.request.Request(
            GRAPHQL_URL,
            data=json.dumps(payload).encode("utf-8"),
            headers=headers,
            method="POST"
        )

        try:
            with urllib.request.urlopen(req, context=self.ssl_ctx, timeout=15) as res:
                data = json.loads(res.read().decode("utf-8"))
                return data.get("data", {}).get("activitySchedules", [])
        except urllib.error.HTTPError as e:
            print(f"[ERROR] GraphQL HTTP {e.code}: {e.read().decode('utf-8', errors='ignore')[:200]}")
            return []
        except Exception as e:
            print(f"[ERROR] GraphQL Request failed: {e}")
            return []

    # -------------------------------------------------------------------------
    # Private DRS Dining Reservation Microservice (Requires High-Trust Token)
    # -------------------------------------------------------------------------
    def get_table_slots(
        self,
        restaurant_id: str,
        date_str: str,
        party_mix: int = 2,
        token: Optional[str] = None
    ) -> Optional[List[Dict[str, Any]]]:
        """
        Queries DRS table booking microservice for specific slot availability.
        Requires active High-Trust Bearer Token.
        """
        bearer_token = token
        if not bearer_token and self.auth_manager:
            try:
                bearer_token = self.auth_manager.get_valid_token(require_high_trust=True)
            except Exception as e:
                print(f"[WARN] Could not retrieve active High-Trust token from AuthManager: {e}")
                bearer_token = None

        if not bearer_token:
            print("[INFO] No active High-Trust Bearer Token available. Run 'python auth_manager.py login' first.")
            return None

        url = f"{DRS_BASE_URL}/v4/book-dine/availabilities/{self.market}?scope=Restaurant"
        payload = {
            "restaurantId": restaurant_id,
            "date": date_str,
            "partyMix": party_mix,
            "session": 0,
            "sourceSite": "web"
        }
        headers = {
            "x-api-key": DRS_API_KEY,
            "Authorization": f"Bearer {bearer_token}",
            "Content-Type": "application/json",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
        }

        req = urllib.request.Request(
            url,
            data=json.dumps(payload).encode("utf-8"),
            headers=headers,
            method="POST"
        )

        try:
            with urllib.request.urlopen(req, context=self.ssl_ctx, timeout=15) as res:
                data = json.loads(res.read().decode("utf-8"))
                return data
        except urllib.error.HTTPError as e:
            err_msg = e.read().decode("utf-8", errors="ignore")
            print(f"[ERROR] DRS HTTP {e.code}: {err_msg[:200]}")
            return None
        except Exception as e:
            print(f"[ERROR] DRS Call failed: {e}")
            return None

    # -------------------------------------------------------------------------
    # Display & Formatting Utilities
    # -------------------------------------------------------------------------
    def print_overview(self, date_str: str, restaurant_ids: Optional[List[str]] = None) -> None:
        """Displays formatted schedule overview for given date."""
        scheds = self.scan_schedules(date_str)
        if not scheds:
            print(f"[-] No schedule data returned for {date_str}.")
            return

        print("\n" + "=" * 80)
        print(f"🏰 Disneyland Paris Dining Schedules — {date_str}")
        print("=" * 80)
        print(f"{'ID':<8} | {'Restaurant':<35} | {'Statut':<14} | {'Horaires Service'}")
        print("-" * 80)

        filter_ids = set(restaurant_ids) if restaurant_ids else None

        for s in sorted(scheds, key=lambda x: x.get("name", "")):
            rid = s.get("id", "")
            if filter_ids and rid not in filter_ids:
                continue

            name = s.get("name", "")
            if len(name) > 35:
                name = name[:32] + "..."

            schedules_list = s.get("schedules", [])
            if not schedules_list:
                print(f"{rid:<8} | {name:<35} | {'N/A':<14} | Aucune plage")
                continue

            for sc in schedules_list:
                status = sc.get("status", "")
                closed = sc.get("closed", False)
                start = sc.get("startTime", "")[:5]
                end = sc.get("endTime", "")[:5]

                if closed or status == "REFURBISHMENT":
                    badge = "[FERMÉ/TRAVAUX]"
                    hours = "Fermé pour réhabilitation"
                elif status == "OPERATING":
                    badge = "[OUVERT]"
                    hours = f"{start} -> {end}"
                else:
                    badge = f"[{status}]"
                    hours = f"{start} -> {end}"

                print(f"{rid:<8} | {name:<35} | {badge:<14} | {hours}")

        print("=" * 80 + "\n")


def main():
    parser = argparse.ArgumentParser(description="Disneyland Paris Dining Availability & Table Scanner")
    parser.add_argument("date", nargs="?", default=datetime.now().strftime("%Y-%m-%d"), help="Date to check (YYYY-MM-DD)")
    parser.add_argument("--restaurant", "-r", help="Specific restaurant ID (e.g. P1AR00 for Captain Jack's)")
    parser.add_argument("--popular", "-p", action="store_true", help="Filter by popular table-service and buffet restaurants")
    parser.add_argument("--drs", action="store_true", help="Query real-time DRS booking table slots (requires active token)")
    parser.add_argument("--covers", "-c", type=int, default=2, help="Number of guests for table booking (default: 2)")

    args = parser.parse_args()
    scanner = DisneylandDiningScanner()

    target_ids = None
    if args.restaurant:
        target_ids = [args.restaurant.upper()]
    elif args.popular:
        target_ids = list(POPULAR_RESTAURANTS.keys())

    print(f"[*] Scanning dining availability for {args.date}...")
    scanner.print_overview(args.date, restaurant_ids=target_ids)

    if args.drs:
        rid = args.restaurant.upper() if args.restaurant else "P1AR00"
        print(f"[*] Checking DRS real-time reservation slots for {rid} on {args.date} ({args.covers} guests)...")
        slots = scanner.get_table_slots(rid, args.date, party_mix=args.covers)
        if slots:
            print(json.dumps(slots, indent=2))


if __name__ == "__main__":
    main()
