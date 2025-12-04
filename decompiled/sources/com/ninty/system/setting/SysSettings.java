package com.ninty.system.setting;

/* loaded from: classes4.dex */
public enum SysSettings {
    UNKNOW("", 0),
    WIFI("android.settings.WIFI_SETTINGS", 1),
    LOCATION("android.settings.LOCATION_SOURCE_SETTINGS", 2),
    BLUETOOTH("android.settings.BLUETOOTH_SETTINGS", 3),
    WRITESETTINGS("android.settings.action.MANAGE_WRITE_SETTINGS", 4),
    AIRPLANE("android.settings.AIRPLANE_MODE_SETTINGS", 5);

    public String action;
    public int requestCode;

    SysSettings(String str, int i) {
        this.action = str;
        this.requestCode = i;
    }

    public static SysSettings get(int i) {
        for (SysSettings sysSettings : values()) {
            if (sysSettings.requestCode == i) {
                return sysSettings;
            }
        }
        return UNKNOW;
    }
}
