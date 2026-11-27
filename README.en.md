[🇫🇷 Français](README.md) | [🇬🇧 English](README.en.md) | [🇪🇸 Español](README.es.md)

# 🏰 Disneyland Paris — Reverse Engineering & API Documentation (v7.17.2)

[![Disney API](https://img.shields.io/badge/Disney_API-Official_Direct-blue.svg)](https://api.disneylandparis.com)
[![Version](https://img.shields.io/badge/App_Version-7.17.2_(Build_1017172292)-purple.svg)](../../releases)
[![Architecture](https://img.shields.io/badge/Stack-Expo_SDK_53_+_Hermes_v96-61dafb.svg)](https://reactnative.dev)
[![Python](https://img.shields.io/badge/Python-3.10%2B-green.svg)](https://python.org)
[![Auth](https://img.shields.io/badge/Auth-Disney_OneID_JGC_v8-red.svg)](https://registerdisney.go.com)

Full technical specification, reverse engineering, and direct integration for the official **Disneyland Paris** mobile app APIs (**`fr.disneylandparis.android`, v7.17.2, `versionCode 1017172292`, `minSdkVersion 29` / Android 10+**).

> 📦 **Decompiled Source & Archives:**
> * **v7.17.2 (latest)**: The full decompiled package is available in [**GitHub Releases**](../../releases).
> * **v7.16 (previous)**: Archived on the [`archive/v7.16`](../../tree/archive/v7.16) branch and [`V7.16-archive`](../../releases/tag/V7.16-archive) tag.

---

## 📑 Table of Contents
1. [What's New in v7.16 → v7.17.2](#-whats-new-in-v716--v7172)
2. [API Architecture & Mapping](#-api-architecture--mapping)
3. [JSON Schemas Explained](#-json-schemas-explained)
4. [Disney OneID Auth & Device Trust](#-disney-oneid-auth--device-trust)
5. [Included CLI Tools](#-included-cli-tools)
6. [Quick Start (Python)](#-quick-start-python)
7. [Repository Structure](#-repository-structure)

---

## 🆕 What's New in v7.16 → v7.17.2

* **Android & Build**: Switched to **Split APKs**, `minSdkVersion` bumped to **29 (Android 10+)**, `targetSdkVersion: 36`.
* **GraphQL (`api.disneylandparis.com/query`)**:
  * `query activities`: added `medias { type media { url } }`.
  * `query page`: added `borderColor` inside `StandardGlobal.keyReasons`.
* **Passes & Reservations**: Added `AP_RESERVATIONS_QUERY_KEY` (*Disneyland Pass*); removed `getMagicPassSummaryQuery`, `FEATURE_TICKET_LINKING`, and `RNPassKitHelper`.
* **Maps**: Updated `tilesConfig714.json` → `tilesConfig717.json` (+2,307 zoom-17 tiles) and added `ORION_PREMIER_ACCESS_ICON` / `REFURBISHMENT_POI_ICON`.
* **Security & Stack**: Added PII log redaction (`********`) for `/bookings/`, `/orders/`, `/pass/`, `/payment/`, `/reservations/`, `/ticket/`, `/unlink/`. Removed `/guest/profile/consent` and `OLCI_NOTIFICATIONS_CONSENT_SECTION`. Migrated to `ExpoNetwork`, `ExpoLinearGradient`, and Android Edge-to-Edge.

---

## 🛰 API Architecture & Mapping

| Service | Protocol | Endpoint | Auth Required |
| :--- | :--- | :--- | :--- |
| **Live Wait Times (`waitTimes`)** | REST / JSON | `https://dlp-wt.wdprapps.disney.com/prod/v1/waitTimes` | Static `x-api-key` |
| **Schedules & Catalog** | GraphQL | `https://api.disneylandparis.com/query` | `x-application-id: mobile-app` |
| **Dining Calendar (`availableDates`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/availableDates/{market}` | `x-api-key` + High-Trust Bearer |
| **Table Slots (`availabilities`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/availabilities/{market}` | `x-api-key` + High-Trust Bearer |
| **User Bookings (`retrieve`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/retrieve/{market}` | `x-api-key` + High-Trust Bearer |
| **Guest Profile (`guest`)** | REST / JSON | `https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/{swid}` | Standard Bearer |
| **Token Refresh (`refresh-auth`)** | REST / JSON | `https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/refresh-auth` | `refreshToken` (180 days) |

---

## 📊 JSON Schemas Explained

1. **`authenticated_session.json`**: Stores session cookies (`SWID`, `TPR-DLP.WEB-PROD.api`), `access_token` (24h TTL), `refresh_token` (180-day TTL), and `high_trust_expires_in` (30-min / 1799s window required for DRS `AUTHZ_GUEST_SECURED_SESSION`; expired high-trust returns `403 FORBIDDEN_SCOPE`).
2. **DRS `slotList`**: Returned by `POST /v4/book-dine/availabilities/{market}?scope=Restaurant` with `mealPeriods` (`Lunch`, `Dinner`) and 15-minute `slotList` intervals (`time`, `available`: `"true"` / `"false"`).
3. **GraphQL `activitySchedules`**: Public endpoint returning `OPERATING`, `REFURBISHMENT`, or `CLOSED` schedules.
4. **REST `waitTimes`**: Live ride status, `postedWaitMinutes`, `singleRider`, `standby`, `virtualQueue`, and `premierAccess` pricing.

---

## 🔐 Disney OneID Auth & Device Trust

* **Tier 1 — Silent REST Refresh (~200 ms)**: Uses the 180-day `refresh_token` with zero browser overhead.
* **Tier 2 — Persistent Playwright Context (Device Trust)**: `.disney_browser_profile/` preserves trusted device cookies (`OneID_device`) so password re-auth restores High-Trust **without triggering OTP prompts**.
* **Tier 3 — Automated OTP & Anti-Flag**: Supports IMAP OTP extraction, human-like typing delays, and rate-limit cooldown locks (`rate_limit_until`).

---

## 🛠️ Included CLI Tools

```bash
# Auth & Session Keeper
python auth_manager.py status
python auth_manager.py login
python auth_manager.py refresh
python auth_manager.py profile
python auth_manager.py daemon --interval 1800

# Dining Schedules & DRS Scanner
python dining_scanner.py 2026-11-27 --popular
python dining_scanner.py -r P1AR00 --dates
python dining_scanner.py 2026-11-27 -r P1AR00 --drs --covers 2
python dining_scanner.py --bookings
python dining_scanner.py --restricted
```

---

## 🚀 Quick Start (Python)

```python
import httpx

url = "https://dlp-wt.wdprapps.disney.com/prod/v1/waitTimes"
headers = {
    "x-api-key": "3jPT5qMimN3kR2kxqd1ez9iF1C68CrBf7zw5ICo4",
    "User-Agent": "okhttp/4.12.0",
}
for ride in httpx.get(url, headers=headers).json()[:5]:
    print(f"{ride['name']}: {ride.get('postedWaitMinutes', 0)} min")
```

---

## 📂 Repository Structure

* [**`DISNEYLAND_PARIS_API_SPEC.md`**](./DISNEYLAND_PARIS_API_SPEC.md): Full technical API specification & v7.17.2 delta.
* [**`auth_manager.py`**](./auth_manager.py) & [**`dining_scanner.py`**](./dining_scanner.py): Ready-to-use CLI tools.
* [**`assets/`**](./assets): Extracted build config (`app.config` v7.17.2).
* [**`app/`**](./app): Decompiled reference tree (full v7.17.2 decompiled archive published in [**GitHub Releases**](../../releases)).

---

## ⚖️ Disclaimer
Educational technical & interoperability research only. All trademarks belong to **The Walt Disney Company** and **Euro Disney Associés S.C.A.**.
