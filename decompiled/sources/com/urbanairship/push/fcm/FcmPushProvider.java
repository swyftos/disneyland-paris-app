package com.urbanairship.push.fcm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.google.PlayServicesUtils;
import com.urbanairship.push.PushProvider;
import com.urbanairship.util.UAStringUtil;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class FcmPushProvider implements PushProvider, AirshipVersionInfo {
    @Override // com.urbanairship.push.PushProvider
    public int getPlatform() {
        return 2;
    }

    @Override // com.urbanairship.push.PushProvider
    @NonNull
    public String getDeliveryType() {
        return "fcm";
    }

    @Override // com.urbanairship.push.PushProvider
    @Nullable
    public String getRegistrationToken(@NonNull Context context) throws PushProvider.RegistrationException {
        try {
            try {
                return (String) Tasks.await(getFirebaseMessaging().getToken());
            } catch (Exception e) {
                throw new PushProvider.RegistrationException("FCM error " + e.getMessage(), true, e);
            }
        } catch (Exception e2) {
            throw new PushProvider.PushProviderUnavailableException("Firebase messaging unavailable: " + e2.getMessage(), e2);
        }
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isAvailable(@NonNull Context context) {
        try {
            if (PlayServicesUtils.isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
            UALog.i("Google Play services is currently unavailable.", new Object[0]);
            return false;
        } catch (Exception e) {
            UALog.e(e, "Unable to register with FCM.", new Object[0]);
            return false;
        }
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isSupported(@NonNull Context context) {
        return PlayServicesUtils.isGooglePlayStoreAvailable(context);
    }

    @NonNull
    public String toString() {
        return "FCM Push Provider " + getAirshipVersion();
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NonNull
    public String getAirshipVersion() {
        return "19.9.1";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NonNull
    public String getPackageVersion() {
        return com.urbanairship.BuildConfig.SDK_VERSION;
    }

    private static FirebaseMessaging getFirebaseMessaging() {
        AirshipConfigOptions airshipConfigOptions = UAirship.shared().getAirshipConfigOptions();
        if (UAStringUtil.isEmpty(airshipConfigOptions.fcmFirebaseAppName)) {
            return FirebaseMessaging.getInstance();
        }
        return (FirebaseMessaging) FirebaseApp.getInstance(airshipConfigOptions.fcmFirebaseAppName).get(FirebaseMessaging.class);
    }
}
