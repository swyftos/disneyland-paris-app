package com.urbanairship.util;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.UAirship;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ManifestUtils {

    @NonNull
    public static final String ENABLE_LOCAL_STORAGE = "com.urbanairship.webview.ENABLE_LOCAL_STORAGE";

    @NonNull
    public static final String LOCAL_STORAGE_DATABASE_DIRECTORY = "com.urbanairship.webview.localstorage";

    public static boolean isPermissionGranted(@NonNull String str) {
        return UAirship.getPackageManager().checkPermission(str, UAirship.getPackageName()) == 0;
    }

    @Nullable
    public static ActivityInfo getActivityInfo(@NonNull Class cls) {
        if (cls.getCanonicalName() == null) {
            return null;
        }
        try {
            return UAirship.getPackageManager().getActivityInfo(new ComponentName(UAirship.getPackageName(), cls.getCanonicalName()), 128);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static ApplicationInfo getApplicationInfo() {
        try {
            return UAirship.getPackageManager().getApplicationInfo(UAirship.getPackageName(), 128);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean shouldEnableLocalStorage() {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo();
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.getBoolean(ENABLE_LOCAL_STORAGE, false)) ? false : true;
    }

    public static boolean shouldInstallNetworkSecurityProvider() {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo();
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.getBoolean("com.urbanairship.INSTALL_NETWORK_SECURITY_PROVIDER", false)) ? false : true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isWebViewSafeBrowsingEnabled() {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo();
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("android.webkit.WebView.EnableSafeBrowsing")) {
            return true;
        }
        return applicationInfo.metaData.getBoolean("android.webkit.WebView.EnableSafeBrowsing", true);
    }
}
