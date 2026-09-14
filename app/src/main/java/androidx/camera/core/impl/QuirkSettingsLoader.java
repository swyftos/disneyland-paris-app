package androidx.camera.core.impl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class QuirkSettingsLoader implements Function<Context, QuirkSettings> {
    public static final String KEY_DEFAULT_QUIRK_ENABLED = "androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED";
    public static final String KEY_QUIRK_FORCE_DISABLED = "androidx.camera.core.quirks.FORCE_DISABLED";
    public static final String KEY_QUIRK_FORCE_ENABLED = "androidx.camera.core.quirks.FORCE_ENABLED";

    @Override // androidx.arch.core.util.Function
    @Nullable
    public QuirkSettings apply(@NonNull Context context) {
        try {
            Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) MetadataHolderService.class), 640).metaData;
            if (bundle == null) {
                Logger.m34w("QuirkSettingsLoader", "No metadata in MetadataHolderService.");
                return null;
            }
            return buildQuirkSettings(context, bundle);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m28d("QuirkSettingsLoader", "QuirkSettings$MetadataHolderService is not found.");
            return null;
        }
    }

    private static QuirkSettings buildQuirkSettings(Context context, Bundle bundle) {
        boolean z = bundle.getBoolean(KEY_DEFAULT_QUIRK_ENABLED, true);
        String[] strArrLoadQuirks = loadQuirks(context, bundle, KEY_QUIRK_FORCE_ENABLED);
        String[] strArrLoadQuirks2 = loadQuirks(context, bundle, KEY_QUIRK_FORCE_DISABLED);
        Logger.m28d("QuirkSettingsLoader", "Loaded quirk settings from metadata:");
        Logger.m28d("QuirkSettingsLoader", "  KEY_DEFAULT_QUIRK_ENABLED = " + z);
        Logger.m28d("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(strArrLoadQuirks));
        Logger.m28d("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(strArrLoadQuirks2));
        return new QuirkSettings.Builder().setEnabledWhenDeviceHasQuirk(z).forceEnableQuirks(resolveQuirkNames(strArrLoadQuirks)).forceDisableQuirks(resolveQuirkNames(strArrLoadQuirks2)).build();
    }

    private static String[] loadQuirks(Context context, Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            return new String[0];
        }
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            Logger.m34w("QuirkSettingsLoader", "Resource ID not found for key: " + str);
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(i);
        } catch (Resources.NotFoundException e) {
            Logger.m35w("QuirkSettingsLoader", "Quirk class names resource not found: " + i, e);
            return new String[0];
        }
    }

    private static Set resolveQuirkNames(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            Class clsResolveQuirkName = resolveQuirkName(str);
            if (clsResolveQuirkName != null) {
                hashSet.add(clsResolveQuirkName);
            }
        }
        return hashSet;
    }

    private static Class resolveQuirkName(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (Quirk.class.isAssignableFrom(cls)) {
                return cls;
            }
            Logger.m34w("QuirkSettingsLoader", str + " does not implement the Quirk interface.");
            return null;
        } catch (ClassNotFoundException e) {
            Logger.m35w("QuirkSettingsLoader", "Class not found: " + str, e);
            return null;
        }
    }

    public static class MetadataHolderService extends Service {
        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            throw new UnsupportedOperationException();
        }
    }
}
