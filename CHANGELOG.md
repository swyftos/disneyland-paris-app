# Changelog

Historique des différences observées entre les versions analysées de l'application Disneyland Paris (`fr.disneylandparis.android`).

## v7.17.2 — 2026-11-27 (`versionCode 1017172292`)

Diff complet depuis `7.16.0` :

| Catégorie | Changement observé dans la `v7.17.2` |
| :--- | :--- |
| **Build & SDK** | `version: 7.17.2` (`versionCode 1017172292`), packaging **Split APKs**, `minSdkVersion` relevé à **29 (Android 10)**, `targetSdkVersion: 36`. |
| **GraphQL `activities`** | Ajout du champ `medias { type media { url } }` sur les entités retournées par `query activities`. |
| **GraphQL `page`** | Ajout du champ `borderColor` dans `StandardGlobal.keyReasons`. |
| **Pass & Réservations** | Ajout de `AP_RESERVATIONS_QUERY_KEY` (*Disneyland Pass*) ; retrait de `getMagicPassSummaryQuery`, `FEATURE_TICKET_LINKING` et `RNPassKitHelper`. |
| **Cartographie** | `tilesConfig714.json` → `tilesConfig717.json` (+2 307 tuiles zoom 17) ; ajout de `ORION_PREMIER_ACCESS_ICON`, `REFURBISHMENT_POI_ICON`, `PIN_TEARDROP_PATH_D`. |
| **Sécurité / Logs** | Ajout de masquage PII (`********`) sur `/bookings/`, `/orders/`, `/pass/apple/`, `/pass/id/`, `/payment/`, `/reservations/`, `/ticket/`, `/unlink/`. Suppression de `/guest/profile/consent` et `OLCI_NOTIFICATIONS_CONSENT_SECTION`. |
| **Stack Technique** | Migration réseau vers `ExpoNetwork` (remplace `RNCNetInfo` / `generate_204`), `ExpoLinearGradient`, support Android Edge-to-Edge (`IS_ANDROID_EDGE_TO_EDGE`), bandeau *Pull-to-refresh* sur `virtualQueue`. |

## v7.16.0 — 2026-09-14

Première version analysée (archivée sur la branche [`archive/v7.16`](../../tree/archive/v7.16)).
