package com.urbanairship.push;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public interface PushProvider {

    @NonNull
    public static final String ADM_DELIVERY_TYPE = "adm";

    @NonNull
    public static final String FCM_DELIVERY_TYPE = "fcm";

    @NonNull
    public static final String HMS_DELIVERY_TYPE = "hms";

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeliveryType {
    }

    @NonNull
    String getDeliveryType();

    int getPlatform();

    @Nullable
    String getRegistrationToken(@NonNull Context context) throws RegistrationException;

    boolean isAvailable(@NonNull Context context);

    boolean isSupported(@NonNull Context context);

    public static class PushProviderUnavailableException extends RegistrationException {
        public PushProviderUnavailableException(@NonNull String str, @Nullable Throwable th) {
            super(str, true, th);
        }

        public PushProviderUnavailableException(@NonNull String str) {
            super(str, true);
        }
    }

    public static class RegistrationException extends Exception {
        private final boolean isRecoverable;

        public RegistrationException(@NonNull String str, boolean z, @Nullable Throwable th) {
            super(str, th);
            this.isRecoverable = z;
        }

        public RegistrationException(@NonNull String str, boolean z) {
            super(str);
            this.isRecoverable = z;
        }

        public boolean isRecoverable() {
            return this.isRecoverable;
        }
    }
}
