[🇫🇷 Français](README.md) | [🇬🇧 English](README.en.md) | [🇪🇸 Español](README.es.md)

# 🏰 Disneyland Paris — Ingeniería Inversa y Documentación API (v7.17.2)

[![Disney API](https://img.shields.io/badge/Disney_API-Official_Direct-blue.svg)](https://api.disneylandparis.com)
[![Version](https://img.shields.io/badge/App_Version-7.17.2_(Build_1017172292)-purple.svg)](../../releases)
[![Architecture](https://img.shields.io/badge/Stack-Expo_SDK_53_+_Hermes_v96-61dafb.svg)](https://reactnative.dev)
[![Python](https://img.shields.io/badge/Python-3.10%2B-green.svg)](https://python.org)
[![Auth](https://img.shields.io/badge/Auth-Disney_OneID_JGC_v8-red.svg)](https://registerdisney.go.com)

Especificación técnica completa, ingeniería inversa e integración directa de las APIs oficiales de la aplicación móvil **Disneyland Paris (`fr.disneylandparis.android`, v7.17.2, `versionCode 1017172292`, `minSdkVersion 29` / Android 10+)**.

> 📦 **Código fuente descompilado y Archivos:**
> * **v7.17.2 (última versión)**: El paquete descompilado completo está disponible en [**GitHub Releases**](../../releases).
> * **v7.16 (versión anterior)**: Archivada en la rama [`archive/v7.16`](../../tree/archive/v7.16) y el tag [`V7.16-archive`](../../releases/tag/V7.16-archive).

---

## 📑 Índice
1. [Novedades v7.16 → v7.17.2](#-novedades-v716--v7172)
2. [Arquitectura y Mapa de APIs](#-arquitectura-y-mapa-de-apis)
3. [Esquemas JSON Explicados](#-esquemas-json-explicados)
4. [Autenticación Disney OneID y Device Trust](#-autenticación-disney-oneid-y-device-trust)
5. [Herramientas CLI Incluidas](#-herramientas-cli-incluidas)
6. [Inicio Rápido (Python)](#-inicio-rápido-python)
7. [Estructura del Repositorio](#-estructura-del-repositorio)

---

## 🆕 Novedades v7.16 → v7.17.2

* **Android y Compilación**: Cambio a **Split APKs**, `minSdkVersion` subido a **29 (Android 10+)** y `targetSdkVersion: 36`.
* **GraphQL (`api.disneylandparis.com/query`)**:
  * `query activities`: añadido el campo `medias { type media { url } }`.
  * `query page`: añadido `borderColor` en `StandardGlobal.keyReasons`.
* **Pases y Reservas**: Añadido `AP_RESERVATIONS_QUERY_KEY` (*Disneyland Pass*); eliminados `getMagicPassSummaryQuery`, `FEATURE_TICKET_LINKING` y `RNPassKitHelper`.
* **Mapas**: Actualización `tilesConfig714.json` → `tilesConfig717.json` (+2 307 teselas zoom 17) y nuevos iconos `ORION_PREMIER_ACCESS_ICON` / `REFURBISHMENT_POI_ICON`.
* **Seguridad y Stack**: Enmascaramiento PII (`********`) en logs para `/bookings/`, `/orders/`, `/pass/`, `/payment/`, `/reservations/`, `/ticket/`, `/unlink/`. Eliminación de `/guest/profile/consent` y migración a `ExpoNetwork`, `ExpoLinearGradient` y Android Edge-to-Edge.

---

## 🛰 Arquitectura y Mapa de APIs

| Servicio | Protocolo | Endpoint | Autenticación |
| :--- | :--- | :--- | :--- |
| **Tiempos de Espera (`waitTimes`)** | REST / JSON | `https://dlp-wt.wdprapps.disney.com/prod/v1/waitTimes` | `x-api-key` estática |
| **Horarios y Catálogo** | GraphQL | `https://api.disneylandparis.com/query` | `x-application-id: mobile-app` |
| **Fechas Restaurante (`availableDates`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/availableDates/{market}` | `x-api-key` + Bearer High-Trust |
| **Horarios de Mesa (`availabilities`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/availabilities/{market}` | `x-api-key` + Bearer High-Trust |
| **Mis Reservas (`retrieve`)** | REST / JSON | `https://dlp-is-sales-drs-book-dine.wdprapps.disney.com/prod/v4/book-dine/retrieve/{market}` | `x-api-key` + Bearer High-Trust |
| **Perfil Privado (`guest`)** | REST / JSON | `https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/{swid}` | Bearer Estándar |
| **Refresco de Token (`refresh-auth`)** | REST / JSON | `https://registerdisney.go.com/jgc/v8/client/TPR-DLP.WEB-PROD/guest/refresh-auth` | `refreshToken` (180 días) |

---

## 📊 Esquemas JSON Explicados

1. **`authenticated_session.json`**: Guarda cookies (`SWID`, `TPR-DLP.WEB-PROD.api`), `access_token` (24h), `refresh_token` (180 días) y `high_trust_expires_in` (30 minutos / 1799s requeridos por DRS; si caduca, devuelve `403 FORBIDDEN_SCOPE`).
2. **DRS `slotList`**: Devuelto por `POST /v4/book-dine/availabilities/{market}?scope=Restaurant` con `mealPeriods` y franjas cada 15 minutos (`time`, `available`: `"true"` / `"false"`).
3. **GraphQL `activitySchedules`**: Endpoint público con estados `OPERATING`, `REFURBISHMENT` y `CLOSED`.
4. **REST `waitTimes`**: Estado en directo, `postedWaitMinutes`, `singleRider`, `standby`, `virtualQueue` y precios de `premierAccess`.

---

## 🔐 Autenticación Disney OneID y Device Trust

* **Nivel 1 — Refresco Silencioso (~200 ms)**: Usa el `refresh_token` de 180 días sin abrir navegador.
* **Nivel 2 — Perfil Persistente Playwright (Device Trust)**: `.disney_browser_profile/` conserva la confianza del dispositivo (`OneID_device`) para renovar High-Trust **sin pedir OTP**.
* **Nivel 3 — Resolución OTP y Anti-Flag**: Soporte IMAP automático, escritura con ritmo humano y bloqueo de enfriamiento (`rate_limit_until`).

---

## 🛠️ Herramientas CLI Incluidas

```bash
# Autenticación y Sesión
python auth_manager.py status
python auth_manager.py login
python auth_manager.py refresh
python auth_manager.py profile
python auth_manager.py daemon --interval 1800

# Escáner de Restaurantes y Mesas DRS
python dining_scanner.py 2026-11-27 --popular
python dining_scanner.py -r P1AR00 --dates
python dining_scanner.py 2026-11-27 -r P1AR00 --drs --covers 2
python dining_scanner.py --bookings
python dining_scanner.py --restricted
```

---

## 🚀 Inicio Rápido (Python)

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

## 📂 Estructura del Repositorio

* [**`DISNEYLAND_PARIS_API_SPEC.md`**](./DISNEYLAND_PARIS_API_SPEC.md): Especificación técnica completa y delta v7.17.2.
* [**`auth_manager.py`**](./auth_manager.py) y [**`dining_scanner.py`**](./dining_scanner.py): Herramientas CLI listas para usar.
* [**`assets/`**](./assets): Configuración extraída (`app.config` v7.17.2).
* [**`app/`**](./app): Árbol descompilado de referencia (la versión completa descompilada v7.17.2 se publica en [**GitHub Releases**](../../releases)).

---

## ⚖️ Aviso Legal
Proyecto técnico y de interoperabilidad con fines educativos. Todas las marcas pertenecen a **The Walt Disney Company** y **Euro Disney Associés S.C.A.**.
