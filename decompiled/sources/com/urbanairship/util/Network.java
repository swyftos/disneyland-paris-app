package com.urbanairship.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class Network {
    private static Network SHARED = new Network();

    public static Network shared() {
        return SHARED;
    }

    public boolean isConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        UALog.e("Error fetching network info.", new Object[0]);
        return false;
    }

    @Nullable
    public static String getCarrier() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) UAirship.getApplicationContext().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            UALog.w("Unable to get network operator name", e);
            return null;
        }
    }
}
