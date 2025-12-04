package androidx.ads.identifier;

import androidx.ads.identifier.AutoValue_AdvertisingIdInfo;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class AdvertisingIdInfo {
    @NonNull
    public abstract String getId();

    @NonNull
    public abstract String getProviderPackageName();

    public abstract boolean isLimitAdTrackingEnabled();

    AdvertisingIdInfo() {
    }

    static Builder builder() {
        return new AutoValue_AdvertisingIdInfo.Builder();
    }

    static abstract class Builder {
        abstract AdvertisingIdInfo build();

        abstract Builder setId(String str);

        abstract Builder setLimitAdTrackingEnabled(boolean z);

        abstract Builder setProviderPackageName(String str);

        Builder() {
        }
    }
}
