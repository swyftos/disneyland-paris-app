package com.contentsquare.android.core.features.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration;", "", "()V", "logDebug", "", "message", "", "logError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logInfo", "migrateCsAppPrefs", "context", "Landroid/content/Context;", "prefStoreEditor", "Landroid/content/SharedPreferences$Editor;", "migrateCsPrefs", "migrateIfNeeded", "prefStoreSharedPref", "Landroid/content/SharedPreferences;", "migrateValue", "oldPrefsName", "oldPrefs", "oldKey", "Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "AppPrefsHelper", "Companion", "OldKey", "PrefType", "PrefsHelper", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldPrefsMigration {

    @NotNull
    private static final String TAG = "CSLIB|OldPrefsMigration";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$AppPrefsHelper;", "", "()V", "CS_APP_PREFS_NAME", "", "IS_HIDE_EVENT_PENDING_KEY", "Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "getIS_HIDE_EVENT_PENDING_KEY", "()Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "LAST_EVENT_TIMESTAMP_KEY", "getLAST_EVENT_TIMESTAMP_KEY", "OPTOUT_DATA", "getOPTOUT_DATA", "SCHEDULED_APP_HIDE_EVENT_KEY", "getSCHEDULED_APP_HIDE_EVENT_KEY", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppPrefsHelper {

        @NotNull
        public static final String CS_APP_PREFS_NAME = "cs_app";

        @NotNull
        public static final AppPrefsHelper INSTANCE = new AppPrefsHelper();

        @NotNull
        private static final OldKey IS_HIDE_EVENT_PENDING_KEY;

        @NotNull
        private static final OldKey LAST_EVENT_TIMESTAMP_KEY;

        @NotNull
        private static final OldKey OPTOUT_DATA;

        @NotNull
        private static final OldKey SCHEDULED_APP_HIDE_EVENT_KEY;

        static {
            PrefType prefType = PrefType.BOOLEAN;
            OPTOUT_DATA = new OldKey(prefType, "optout_data_collection", "dacf8be919a342da6b9726a3c3e6ab27", PreferencesKey.IS_OPT_OUT);
            LAST_EVENT_TIMESTAMP_KEY = new OldKey(PrefType.LONG, "last_event_timestamp", "b979faa093058ea41897894dc2cfbb42", PreferencesKey.LAST_EVENT_TIMESTAMP);
            IS_HIDE_EVENT_PENDING_KEY = new OldKey(prefType, "is_hide_event_pending", "53ad207c8331f3770f3c39fc16eabf90", PreferencesKey.IS_HIDE_EVENT_PENDING);
            SCHEDULED_APP_HIDE_EVENT_KEY = new OldKey(PrefType.STRING, "scheduled_app_hide_event", "9034f57360cfc17846093bfbb15f84d3", PreferencesKey.SCHEDULED_APP_HIDE_EVENT);
        }

        private AppPrefsHelper() {
        }

        @NotNull
        public final OldKey getIS_HIDE_EVENT_PENDING_KEY() {
            return IS_HIDE_EVENT_PENDING_KEY;
        }

        @NotNull
        public final OldKey getLAST_EVENT_TIMESTAMP_KEY() {
            return LAST_EVENT_TIMESTAMP_KEY;
        }

        @NotNull
        public final OldKey getOPTOUT_DATA() {
            return OPTOUT_DATA;
        }

        @NotNull
        public final OldKey getSCHEDULED_APP_HIDE_EVENT_KEY() {
            return SCHEDULED_APP_HIDE_EVENT_KEY;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "", "prefType", "Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$PrefType;", "name", "", "md5hash", "newKey", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "(Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$PrefType;Ljava/lang/String;Ljava/lang/String;Lcom/contentsquare/android/core/features/preferences/PreferencesKey;)V", "getMd5hash", "()Ljava/lang/String;", "getName", "getNewKey", "()Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "getPrefType", "()Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$PrefType;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OldKey {

        @NotNull
        private final String md5hash;

        @NotNull
        private final String name;

        @NotNull
        private final PreferencesKey newKey;

        @NotNull
        private final PrefType prefType;

        public OldKey(PrefType prefType, String name, String md5hash, PreferencesKey newKey) {
            Intrinsics.checkNotNullParameter(prefType, "prefType");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(md5hash, "md5hash");
            Intrinsics.checkNotNullParameter(newKey, "newKey");
            this.prefType = prefType;
            this.name = name;
            this.md5hash = md5hash;
            this.newKey = newKey;
        }

        @NotNull
        public final String getMd5hash() {
            return this.md5hash;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final PreferencesKey getNewKey() {
            return this.newKey;
        }

        @NotNull
        public final PrefType getPrefType() {
            return this.prefType;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$PrefType;", "", "(Ljava/lang/String;I)V", "BOOLEAN", "INT", "LONG", "STRING", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum PrefType {
        BOOLEAN,
        INT,
        LONG,
        STRING
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$PrefsHelper;", "", "()V", "CS_CONFIG_PREFS_NAME", "", "LAST_SEGMENT", "Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "getLAST_SEGMENT", "()Lcom/contentsquare/android/core/features/preferences/OldPrefsMigration$OldKey;", "TRACKABLE", "getTRACKABLE", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PrefsHelper {

        @NotNull
        public static final String CS_CONFIG_PREFS_NAME = "cs";

        @NotNull
        public static final PrefsHelper INSTANCE = new PrefsHelper();

        @NotNull
        private static final OldKey LAST_SEGMENT = new OldKey(PrefType.INT, "last_segment", "d1cd941e9361399f0433d63e6f7d7c76", PreferencesKey.LAST_SEGMENT);

        @NotNull
        private static final OldKey TRACKABLE = new OldKey(PrefType.BOOLEAN, "trackable", "41acbd06dbc9316d28c0db48b144aaf8", PreferencesKey.IS_TRACKABLE);

        private PrefsHelper() {
        }

        @NotNull
        public final OldKey getLAST_SEGMENT() {
            return LAST_SEGMENT;
        }

        @NotNull
        public final OldKey getTRACKABLE() {
            return TRACKABLE;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrefType.values().length];
            try {
                iArr[PrefType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrefType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrefType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrefType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void logDebug(String message) {
    }

    private final void logError(String message, Exception e) {
        Log.e(TAG, message, e);
    }

    private final void logInfo(String message) {
        Log.i(TAG, message);
    }

    private final void migrateCsAppPrefs(Context context, SharedPreferences.Editor prefStoreEditor) {
        SharedPreferences oldPrefs = context.getSharedPreferences(AppPrefsHelper.CS_APP_PREFS_NAME, 0);
        Map<String, ?> all = oldPrefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "oldPrefs.all");
        if (all.isEmpty()) {
            return;
        }
        logDebug("Migrating cs_app");
        AppPrefsHelper appPrefsHelper = AppPrefsHelper.INSTANCE;
        for (OldKey oldKey : CollectionsKt.listOf((Object[]) new OldKey[]{appPrefsHelper.getOPTOUT_DATA(), appPrefsHelper.getLAST_EVENT_TIMESTAMP_KEY(), appPrefsHelper.getIS_HIDE_EVENT_PENDING_KEY(), appPrefsHelper.getSCHEDULED_APP_HIDE_EVENT_KEY()})) {
            Intrinsics.checkNotNullExpressionValue(oldPrefs, "oldPrefs");
            migrateValue(AppPrefsHelper.CS_APP_PREFS_NAME, oldPrefs, oldKey, prefStoreEditor);
        }
        oldPrefs.edit().clear().apply();
        logDebug("Old prefs cs_app cleared.");
    }

    private final void migrateCsPrefs(Context context, SharedPreferences.Editor prefStoreEditor) {
        SharedPreferences oldPrefs = context.getSharedPreferences("cs", 0);
        Map<String, ?> all = oldPrefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "oldPrefs.all");
        if (all.isEmpty()) {
            return;
        }
        logDebug("Migrating cs");
        PrefsHelper prefsHelper = PrefsHelper.INSTANCE;
        for (OldKey oldKey : CollectionsKt.listOf((Object[]) new OldKey[]{prefsHelper.getTRACKABLE(), prefsHelper.getLAST_SEGMENT()})) {
            Intrinsics.checkNotNullExpressionValue(oldPrefs, "oldPrefs");
            migrateValue("cs", oldPrefs, oldKey, prefStoreEditor);
        }
        oldPrefs.edit().clear().apply();
        logDebug("Old prefs cs cleared.");
    }

    private final void migrateValue(String oldPrefsName, SharedPreferences oldPrefs, OldKey oldKey, SharedPreferences.Editor prefStoreEditor) {
        PreferencesKey newKey = oldKey.getNewKey();
        try {
            if (oldPrefs.contains(oldKey.getMd5hash())) {
                int i = WhenMappings.$EnumSwitchMapping$0[oldKey.getPrefType().ordinal()];
                if (i == 1) {
                    boolean z = oldPrefs.getBoolean(oldKey.getMd5hash(), false);
                    logDebug("Migrating " + oldPrefsName + ' ' + oldKey.getName() + " -> " + newKey + ": " + z);
                    prefStoreEditor.putBoolean(newKey.name(), z);
                } else if (i == 2) {
                    int i2 = oldPrefs.getInt(oldKey.getMd5hash(), 0);
                    logDebug("Migrating " + oldPrefsName + ' ' + oldKey.getName() + " -> " + newKey + ": " + i2);
                    prefStoreEditor.putInt(newKey.name(), i2);
                } else if (i == 3) {
                    long j = oldPrefs.getLong(oldKey.getMd5hash(), 0L);
                    logDebug("Migrating " + oldPrefsName + ' ' + oldKey.getName() + " -> " + newKey + ": " + j);
                    prefStoreEditor.putLong(newKey.name(), j);
                } else if (i == 4) {
                    String string = oldPrefs.getString(oldKey.getMd5hash(), "");
                    logDebug("Migrating " + oldPrefsName + ' ' + oldKey.getName() + " -> " + newKey + ": " + string);
                    prefStoreEditor.putString(newKey.name(), string);
                }
            }
        } catch (Exception e) {
            logError("Migrating " + oldPrefsName + ' ' + oldKey.getName() + " -> " + newKey, e);
        }
    }

    public final void migrateIfNeeded(Context context, SharedPreferences prefStoreSharedPref) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefStoreSharedPref, "prefStoreSharedPref");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (prefStoreSharedPref.getBoolean("IS_MIGRATED_FROM_PREFS_HELPER", false)) {
            return;
        }
        logDebug("Checking for old preferences migration ...");
        SharedPreferences.Editor editor = prefStoreSharedPref.edit();
        editor.putBoolean("IS_MIGRATED_FROM_PREFS_HELPER", true);
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        migrateCsPrefs(context, editor);
        migrateCsAppPrefs(context, editor);
        editor.apply();
        logInfo("Migration done in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
    }
}
