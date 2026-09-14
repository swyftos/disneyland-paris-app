package androidx.ads.identifier;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AdvertisingIdInfo extends AdvertisingIdInfo {

    /* JADX INFO: renamed from: id */
    private final String f0id;
    private final boolean limitAdTrackingEnabled;
    private final String providerPackageName;

    private AutoValue_AdvertisingIdInfo(String str, String str2, boolean z) {
        this.f0id = str;
        this.providerPackageName = str2;
        this.limitAdTrackingEnabled = z;
    }

    @Override // androidx.ads.identifier.AdvertisingIdInfo
    public String getId() {
        return this.f0id;
    }

    @Override // androidx.ads.identifier.AdvertisingIdInfo
    public String getProviderPackageName() {
        return this.providerPackageName;
    }

    @Override // androidx.ads.identifier.AdvertisingIdInfo
    public boolean isLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }

    public String toString() {
        return "AdvertisingIdInfo{id=" + this.f0id + ", providerPackageName=" + this.providerPackageName + ", limitAdTrackingEnabled=" + this.limitAdTrackingEnabled + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertisingIdInfo)) {
            return false;
        }
        AdvertisingIdInfo advertisingIdInfo = (AdvertisingIdInfo) obj;
        return this.f0id.equals(advertisingIdInfo.getId()) && this.providerPackageName.equals(advertisingIdInfo.getProviderPackageName()) && this.limitAdTrackingEnabled == advertisingIdInfo.isLimitAdTrackingEnabled();
    }

    public int hashCode() {
        return (this.limitAdTrackingEnabled ? 1231 : 1237) ^ ((((this.f0id.hashCode() ^ 1000003) * 1000003) ^ this.providerPackageName.hashCode()) * 1000003);
    }

    static final class Builder extends AdvertisingIdInfo.Builder {

        /* JADX INFO: renamed from: id */
        private String f1id;
        private Boolean limitAdTrackingEnabled;
        private String providerPackageName;

        Builder() {
        }

        @Override // androidx.ads.identifier.AdvertisingIdInfo.Builder
        AdvertisingIdInfo.Builder setId(String str) {
            if (str == null) {
                throw new NullPointerException("Null id");
            }
            this.f1id = str;
            return this;
        }

        @Override // androidx.ads.identifier.AdvertisingIdInfo.Builder
        AdvertisingIdInfo.Builder setProviderPackageName(String str) {
            if (str == null) {
                throw new NullPointerException("Null providerPackageName");
            }
            this.providerPackageName = str;
            return this;
        }

        @Override // androidx.ads.identifier.AdvertisingIdInfo.Builder
        AdvertisingIdInfo.Builder setLimitAdTrackingEnabled(boolean z) {
            this.limitAdTrackingEnabled = Boolean.valueOf(z);
            return this;
        }

        @Override // androidx.ads.identifier.AdvertisingIdInfo.Builder
        AdvertisingIdInfo build() {
            String str = "";
            if (this.f1id == null) {
                str = " id";
            }
            if (this.providerPackageName == null) {
                str = str + " providerPackageName";
            }
            if (this.limitAdTrackingEnabled == null) {
                str = str + " limitAdTrackingEnabled";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_AdvertisingIdInfo(this.f1id, this.providerPackageName, this.limitAdTrackingEnabled.booleanValue());
        }
    }
}
