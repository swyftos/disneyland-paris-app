package com.allegion.accesssdk;

import com.allegion.accesssdk.enums.AlSdkEnvironment;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class BuildConfig {
    public static final String ACCESS_TOKEN = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI3Q0JBODMwMC1GRjc5LTQ1MjAtODQxNi02Mzc1QTlENEYwMTMiLCJuYmYiOjE1NTY3MjUxOTgsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTU2NzI1MTk4LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.vrXDIxOcg8s6OIzJxgyu9yJ6yLDSA9X2yUJtyHHZL82WtbyOfHmSk608CQjBluGhRc_r9Yo90QM1Kp1PE92AmA";
    public static final String ACCESS_TOKEN_FOR_INVALID_CRED = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJmMjViZmY3YS05OTMyLTRjZGQtOWQyMS0zNGM5MjI1ZGJhMjciLCJuYmYiOjE1NjY1MDMxMDQsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTY2NTAzMTA0LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.I62sHN2skJFnaDqacv77vD7qgGFDZyvc4YhTqmQDOSF5YTwlAxkAm8-nDBMUADG-sljVstT6KyagN7NVn4dhMQ";
    public static final String ACCESS_TOKEN_NFC = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJmNGI3YTEwZi1jY2UxLTRkMGUtOWM1Zi0wOTY4NzVmMGFkMDYiLCJuYmYiOjE1ODY5Njc0NDQsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg2OTY3NDQ0LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.ML2To4LexIbT7wFCu7TNMJO5o9r5qRsDioUYxKc3lRl-jPsTRAUGB39j85TpY86khDJe6JifKs6U5L-4Jg1qwg";
    public static final String ACCESS_TOKEN_NFC_40X = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI0NTBiYTc2ZS1mMDIzLTQyMGMtODhjYS03MmFkYjQ4N2QzM2YiLCJuYmYiOjE1ODgxODk4MzAsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTg5ODMwLCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.hbz_-O4BFlYG3e8RnohD-dpRite4mieRFmYDNZLLkzLMK7jKp4blgwhIdgztGL14UUcXRY3FvHQRn8JptNaI8g";
    public static final String ACCESS_TOKEN_NFC_EXT = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2YzVjNzI5OS1mMTZhLTQ5NzYtODNiMi1hMjBiNjkyNjliNTgiLCJuYmYiOjE1ODgxODk0NzEsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTg5NDcxLCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.ATa1pmNheX6lKpi9p4UvBVAkPQ2W5HyIGQkJrCdbK4PIzL0ld14kDTenbqHpFeyfVYqz-5PJ3rlNCBhy0-O4Tw";
    public static final String ACCESS_TOKEN_NFC_ONLY = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1M2RkM2FmOS0xNjA0LTQ5ZGQtYTA3Mi05Y2I3YTU4NjY2NjYiLCJuYmYiOjE1ODgxMDk4OTcsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTA5ODk3LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6ImFsbGVnaW9uIn0.GLEfGh6fxLGNDfxUEhY5DGZA1YAP3-yUxV_xLUJHkXw078Jl6UpDvGS9a5322ePxx1kuN1pPb6Q60sJ_QrFA0g";
    public static final String ACCESS_TOKEN_NoTour = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlYmEyYjlkYi0xOTc2LTRhNmItYWY2ZC05MDQ1ZDBhZGRkZWUiLCJuYmYiOjE2MTQzNTY5NTksImV4cCI6MTYyMzc4OTUxMiwiaWF0IjoxNjE0MzU2OTU5LCJpc3MiOiJBbGxlZ2lvbiIsImF1ZCI6ImFsbGVnaW9uIn0.Ffo2DNIK7A3ItlBXpVCR61XxjUPlLtNiAyUDzQ6LfquQZr_KZsureoMP5D2dwv_Syfhy0lYZmLU8E3rdoa_lgg";
    public static final String BUILD_TYPE = "release";
    public static final String CONTROL_DEVICE_SERIAL_NUMBER = "0000000000000000E20000000004D7FC";
    public static final String CTE_DEVICE_SERIAL_NUMBER = "0000000000000000A20000000F15158D";
    public static final boolean DEBUG = false;
    public static final String DEVICE_KEY = "LE/NoTour";
    public static final String DEVICE_KEY_REFERENCE = "device";
    public static final String DEVICE_SIGNATURE = "3044022004bc27bce57dacfd0ee6abf036679d737c34f9ad5dcaf1182328d63be50990c002204c56def805cb2cdac37bf9dc966cf509f1f972257132cd825271d4be1e966204";
    public static final String DIVERSIFIED_KEY_INPUT_REFERENCE = "diversified_key";
    public static final String DIVERSIFIED_KEY_REFERENCE = "diversified";
    public static final String FLAVOR = "qa";
    public static final String ID_TOKEN = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI3Q0JBODMwMC1GRjc5LTQ1MjAtODQxNi02Mzc1QTlENEYwMTMiLCJuYmYiOjE1NTY1NzI5NjEsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTU2NTcyOTYxLCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.1bmTQyv2X8POkKn39TuoQUtHrgxcGmwWgDDw3SxJmPWariUHYOzSAf8GmlZ6BgOVfoes2Ad69E12pcbHsiKDwg";
    public static final String ID_TOKEN_FOR_INVALID_CRED = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJmMjViZmY3YS05OTMyLTRjZGQtOWQyMS0zNGM5MjI1ZGJhMjciLCJuYmYiOjE1NjY1MDMxMDQsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTY2NTAzMTA0LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.0hmTFb-viPtyxLPJM2Fcjd9owMCeJtFARUmp1jLwU-Xu2xwZUV7IjLsNimSFz9FVwnrk4oqgnHxKYxM5u3k_mg";
    public static final String ID_TOKEN_NFC = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJmNGI3YTEwZi1jY2UxLTRkMGUtOWM1Zi0wOTY4NzVmMGFkMDYiLCJuYmYiOjE1ODY5Njc0NDQsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg2OTY3NDQ0LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.Daxg3ooqNC8neYoSpokuvjdSQg1uOCDlIVAQCf64t53guBbSLs90lxrzGJ1azcXQL9zaZaDJEE2AnWWVcoOvBA";
    public static final String ID_TOKEN_NFC_40X = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI0NTBiYTc2ZS1mMDIzLTQyMGMtODhjYS03MmFkYjQ4N2QzM2YiLCJuYmYiOjE1ODgxODk4MzAsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTg5ODMwLCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.XbfNKzkkTiehUQ3a7bxi2-C0aJ1Jmlr-3YzG1ty25KfN2-t_9RuBIyipooTsVNzo092qnws35Iz9rqSr2VkxUg";
    public static final String ID_TOKEN_NFC_EXT = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2YzVjNzI5OS1mMTZhLTQ5NzYtODNiMi1hMjBiNjkyNjliNTgiLCJuYmYiOjE1ODgxODk0NzEsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTg5NDcxLCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.SL0qdPwrUxuXX5uyBK373ZwuJn3zT3Q5u2ikurHfmoyLFg_JNHjB8NrEE8Q2teSJ6fGPiP-NgHXhoOSDUVIj8w";
    public static final String ID_TOKEN_NFC_ONLY = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1M2RkM2FmOS0xNjA0LTQ5ZGQtYTA3Mi05Y2I3YTU4NjY2NjYiLCJuYmYiOjE1ODgxMDk4OTcsImV4cCI6MjE0NTk0MjAwMCwiaWF0IjoxNTg4MTA5ODk3LCJpc3MiOiJzcGVjZmxvdyIsImF1ZCI6InRlc3QtYXVkaWVuY2UifQ.-wtkkbUwTuR26L_wxWS0LN8v1vGnl1frluWhcStLH0EGNmdmZCbjImkdo93lQBhbcRpZKTGSh964X_R8ymq5gQ";
    public static final String ID_TOKEN_NoTour = "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlYmEyYjlkYi0xOTc2LTRhNmItYWY2ZC05MDQ1ZDBhZGRkZWUiLCJuYmYiOjE2MTQzNTY5NTksImV4cCI6MTYyMzc4OTUxMiwiaWF0IjoxNjE0MzU2OTU5LCJpc3MiOiJBbGxlZ2lvbiIsImF1ZCI6IkFsbGVnaW9uQWNjZXNzSHViIn0.QoAorMJuNTHclih7kdgHdUdUFVqSkHjmyC0d8GX7sC3p_aOOxPzeyHpojgj_jTRXe00pJI9gjVPePp0qtKaAUg";
    public static final String INTEGRATION_ID = "9595819f-c655-e911-b49e-000d3a1027a1";
    public static final String INTEGRATION_ID_NFC = "2dd14b28-dc68-ea11-a94c-281878b96465";
    public static final String INTEGRATION_ID_NFC_40X = "87683abc-dd68-ea11-a94c-2818783a6c90";
    public static final String INTEGRATION_ID_NFC_EXT = "ae201c10-dc68-ea11-a94c-281878b96465";
    public static final String INTEGRATION_ID_NFC_ONLY = "d07c4022-dc68-ea11-a94c-281878b96465";
    public static final String INTEGRATION_ID_NoTour = "8cce7c31-5c42-ea11-a1cc-281878b96465";
    public static final String LE_DEVICE_SERIAL_NUMBER = "0000000000000000F20000000F15160D";
    public static final String LIBRARY_PACKAGE_NAME = "com.allegion.accesssdk";
    public static final String MAA_TOKEN = "Maa ZTBhYjA5ZTQtOTM0Zi1lYjExLTk4ODktMDA1MGYyZTY4Zjc1XzIwMjEtMDEtNVQyMToyMzo0MS45MzRaOjMwNDUwMjIwNzEyNzdjNmUzYWMzMWIwZmNjODFlNjMyNjJhMTAwMDYyNGFhNzRhMzkxMWRkOGExMTY4ZDJhN2Y2MzMxMWI0ODAyMjEwMGRmNzcwMWEyY2M3NDE1YmI4OTk3Mjc0NWM5NmM1NGFmNGIyYzhmNGUwOTgwZWZlNWNkNWQ3NmFjM2QyY2Q1ZTc=";
    public static final String MAH_BASE_URL = "https://api.securewebserv.com/test/mobileaccess/provider";
    public static final String NDE_DEVICE_SERIAL_NUMBER = "0000000000000000A20000000F15158D";
    public static final String PINSET = "sha256/3dmwy492PJdvEXGyeg0t+FIXTP9NESboDD6KnS4pquo=";
    public static final String PINSETKEY = "api.securewebserv.com";
    public static final String RIGHT_ID_FOR_INVALID_CRED = "698a3358-15c5-e911-bcd0-000d3a12a1c2";
    public static final String SESSION_KEY_REFERENCE = "session";
    public static final String SUBSCRIPTION_KEY = "356776b0-c005-4a5e-901a-b3d4d4a4c181";
    public static final String SUB_KEY_INVITEAPI = "0B393C7C4A1D449DBCAE1C125CB1C9BC";
    public static final Map<String, String> DEVICE_SERIAL_NUMBERS = new HashMap<String, String>() { // from class: com.allegion.accesssdk.BuildConfig.1
        {
            put("Control/Dev", "0000000000000000A0E200000004D827");
            put("Control/Prod", "");
            put("NDE", "0000000000000000A20000000F15158D");
            put("CTE", "");
            put("LE", "0000000000000000A0F2000000000357");
            put(BuildConfig.DEVICE_KEY, BuildConfig.LE_DEVICE_SERIAL_NUMBER);
            put("NDE/NoTour", "");
            put("Control/NoTour", "");
            put("CTE/NoTour", "0000000000000000A20000000F15158D");
        }
    };
    public static final AlSdkEnvironment ENV = AlSdkEnvironment.PRODUCTION;

    public static final class Beta {
        public static final String APPCENTERAPPID = "fceae2c7-ff7c-46f3-926d-8c569eefd023";
        public static final String BASEACCESSHUBURL = "https://api.securewebserv.com/mobileaccess/";
        public static final String BASEAPIMANAGEMENTURL = "https://api.securewebserv.com";
        public static final String NAME = "Beta";
        public static final Boolean TRACKCRASHES = Boolean.TRUE;
    }

    public static final class Dev {
        public static final String APPCENTERAPPID = "2c3cc2c1-f595-47fc-a9c9-b363ecce2277";
        public static final String BASEACCESSHUBURL = "https://api.securewebserv.com/dev/mobileaccess/";
        public static final String BASEAPIMANAGEMENTURL = "https://api.securewebserv.com";
        public static final String NAME = "Dev";
        public static final Boolean TRACKCRASHES = Boolean.TRUE;
    }

    public static final class Library {
        public static final String CONNECTEDTESTSUITE = "medium";
        public static final String FEATURE = "AUTO-ENROLL";
        public static final String NAME = "Library";
        public static final String VERSIONCODE = "4000045";
        public static final String VERSIONNAME = "4.0.45-auto-enroll";
    }

    public static final class Pilot {
        public static final String APPCENTERAPPID = "57cbd1b5-a29d-47fb-b2ca-32e403bc0158";
        public static final String BASEACCESSHUBURL = "https://api.allegion.com/pilot/mobileaccess/";
        public static final String BASEAPIMANAGEMENTURL = "https://api.allegion.com/";
        public static final String NAME = "Pilot";
        public static final Boolean TRACKCRASHES = Boolean.TRUE;
    }

    public static final class Production {
        public static final String APPCENTERAPPID = "950dca8e-074c-422e-9803-c23054b336e6";
        public static final String BASEACCESSHUBURL = "https://api.allegion.com/mobileaccess/";
        public static final String BASEAPIMANAGEMENTURL = "https://api.allegion.com/";
        public static final String NAME = "Production";
        public static final Boolean TRACKCRASHES = Boolean.FALSE;
    }

    public static final class Qa {
        public static final String APPCENTERAPPID = "0c794fd5-412e-432a-8353-1f5c1bb0e692";
        public static final String BASEACCESSHUBURL = "https://api.securewebserv.com/test/mobileaccess/";
        public static final String BASEAPIMANAGEMENTURL = "https://api.securewebserv.com";
        public static final String NAME = "Qa";
        public static final Boolean TRACKCRASHES = Boolean.TRUE;
    }
}
