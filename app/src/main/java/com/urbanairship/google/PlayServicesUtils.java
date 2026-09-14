package com.urbanairship.google;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.urbanairship.UALog;

/* JADX INFO: loaded from: classes5.dex */
public class PlayServicesUtils {
    public static final int MISSING_PLAY_SERVICE_DEPENDENCY = -1;
    private static Boolean isFusedLocationDependencyAvailable;
    private static Boolean isGoogleAdsDependencyAvailable;
    private static Boolean isGooglePlayServicesDependencyAvailable;
    private static Boolean isGooglePlayStoreAvailable;

    public static void handleAnyPlayServicesError(@NonNull Context context) {
        if (isGooglePlayServicesDependencyAvailable()) {
            try {
                int iIsGooglePlayServicesAvailable = GooglePlayServicesUtilWrapper.isGooglePlayServicesAvailable(context);
                if (iIsGooglePlayServicesAvailable == 0) {
                    return;
                }
                if (GooglePlayServicesUtilWrapper.isUserRecoverableError(iIsGooglePlayServicesAvailable)) {
                    UALog.m1741d("Launching Play Services Activity to resolve error.", new Object[0]);
                    try {
                        context.startActivity(new Intent(context, (Class<?>) PlayServicesErrorActivity.class));
                        return;
                    } catch (ActivityNotFoundException e) {
                        UALog.m1745e(e);
                        return;
                    }
                }
                UALog.m1748i("Error %s is not user recoverable.", Integer.valueOf(iIsGooglePlayServicesAvailable));
            } catch (IllegalStateException e2) {
                UALog.m1746e(e2, "Google Play services developer error.", new Object[0]);
            }
        }
    }

    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        if (isGooglePlayServicesDependencyAvailable()) {
            return GooglePlayServicesUtilWrapper.isGooglePlayServicesAvailable(context);
        }
        return -1;
    }

    public static boolean isGooglePlayServicesDependencyAvailable() {
        if (isGooglePlayServicesDependencyAvailable == null) {
            try {
                String str = GooglePlayServicesUtil.GMS_ERROR_DIALOG;
                isGooglePlayServicesDependencyAvailable = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                isGooglePlayServicesDependencyAvailable = Boolean.FALSE;
            }
        }
        return isGooglePlayServicesDependencyAvailable.booleanValue();
    }

    public static boolean isFusedLocationDependencyAvailable() {
        if (isFusedLocationDependencyAvailable == null) {
            if (!isGooglePlayServicesDependencyAvailable()) {
                isFusedLocationDependencyAvailable = Boolean.FALSE;
            } else {
                try {
                    isFusedLocationDependencyAvailable = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    isFusedLocationDependencyAvailable = Boolean.FALSE;
                }
            }
        }
        return isFusedLocationDependencyAvailable.booleanValue();
    }

    public static boolean isGoogleAdsDependencyAvailable() {
        if (isGoogleAdsDependencyAvailable == null) {
            if (!isGooglePlayServicesDependencyAvailable()) {
                isGoogleAdsDependencyAvailable = Boolean.FALSE;
            } else {
                try {
                    Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                    isGoogleAdsDependencyAvailable = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    isGoogleAdsDependencyAvailable = Boolean.FALSE;
                }
            }
        }
        return isGoogleAdsDependencyAvailable.booleanValue();
    }

    public static boolean isGooglePlayStoreAvailable(@NonNull Context context) {
        if (isGooglePlayStoreAvailable == null) {
            isGooglePlayStoreAvailable = Boolean.valueOf(isPackageAvailable(context, "com.android.vending") || isPackageAvailable(context, "com.google.market"));
        }
        return isGooglePlayStoreAvailable.booleanValue();
    }

    private static boolean isPackageAvailable(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
