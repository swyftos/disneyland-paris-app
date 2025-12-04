package com.urbanairship.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.google.PlayServicesUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AppStoreUtils {
    @NonNull
    public static Intent getAppStoreIntent(@NonNull Context context, int i, @NonNull AirshipConfigOptions airshipConfigOptions) {
        if (airshipConfigOptions.appStoreUri != null) {
            Intent intent = new Intent("android.intent.action.VIEW", airshipConfigOptions.appStoreUri);
            if (airshipConfigOptions.appStoreUri.toString().startsWith("https://play.google.com/store") && isPlayStoreAvailable(context)) {
                intent.setPackage("com.android.vending");
            }
            return intent;
        }
        String packageName = context.getPackageName();
        if (i == 1) {
            return new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/android?p=" + packageName));
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
        if (isPlayStoreAvailable(context)) {
            intent2.setPackage("com.android.vending");
        }
        return intent2;
    }

    private static boolean isPlayStoreAvailable(Context context) {
        return PlayServicesUtils.isGooglePlayStoreAvailable(context.getApplicationContext());
    }
}
