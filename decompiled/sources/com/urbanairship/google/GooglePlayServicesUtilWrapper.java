package com.urbanairship.google;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes5.dex */
public class GooglePlayServicesUtilWrapper {
    public static boolean isUserRecoverableError(int i) {
        return GoogleApiAvailability.getInstance().isUserResolvableError(i);
    }

    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }
}
