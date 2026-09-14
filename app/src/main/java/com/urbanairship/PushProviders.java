package com.urbanairship;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.urbanairship.base.Supplier;
import com.urbanairship.push.PushProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PushProviders {
    private final AirshipConfigOptions airshipConfigOptions;
    private final List supportedProviders = new ArrayList();
    private final List availableProviders = new ArrayList();

    @VisibleForTesting
    protected PushProviders(@NonNull AirshipConfigOptions airshipConfigOptions) {
        this.airshipConfigOptions = airshipConfigOptions;
    }

    static PushProviders load(Context context, AirshipConfigOptions airshipConfigOptions) {
        PushProviders pushProviders = new PushProviders(airshipConfigOptions);
        pushProviders.init(context);
        return pushProviders;
    }

    static Supplier lazyLoader(Context context, AirshipConfigOptions airshipConfigOptions) {
        return new LazyLoader(context, airshipConfigOptions);
    }

    private void init(Context context) {
        List<PushProvider> listCreateProviders = createProviders();
        if (listCreateProviders.isEmpty()) {
            UALog.m1754w("No push providers found!. Make sure to install either `urbanairship-fcm` or `urbanairship-adm`.", new Object[0]);
            return;
        }
        for (PushProvider pushProvider : listCreateProviders) {
            if (isValid(pushProvider) && pushProvider.isSupported(context)) {
                this.supportedProviders.add(pushProvider);
                if (pushProvider.isAvailable(context)) {
                    this.availableProviders.add(pushProvider);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean isValid(PushProvider pushProvider) {
        if (pushProvider instanceof AirshipVersionInfo) {
            AirshipVersionInfo airshipVersionInfo = (AirshipVersionInfo) pushProvider;
            if (!UAirship.getVersion().equals(airshipVersionInfo.getAirshipVersion())) {
                UALog.m1744e("Provider: %s version %s does not match the SDK version %s. Make sure all Airship dependencies are the same version.", pushProvider, airshipVersionInfo.getAirshipVersion(), UAirship.getVersion());
                return false;
            }
        }
        String deliveryType = pushProvider.getDeliveryType();
        deliveryType.hashCode();
        switch (deliveryType) {
            case "adm":
                if (pushProvider.getPlatform() != 1) {
                    UALog.m1744e("Invalid Provider: %s. ADM delivery is only available for Amazon platforms.", pushProvider);
                    return false;
                }
                return true;
            case "fcm":
            case "hms":
                if (pushProvider.getPlatform() != 2) {
                    UALog.m1744e("Invalid Provider: %s. %s delivery is only available for Android platforms.", pushProvider.getDeliveryType(), pushProvider);
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private List createProviders() {
        PushProvider pushProvider;
        InstantiationException e;
        IllegalAccessException e2;
        ArrayList arrayList = new ArrayList();
        PushProvider pushProvider2 = this.airshipConfigOptions.customPushProvider;
        if (pushProvider2 != null) {
            arrayList.add(pushProvider2);
        }
        for (String str : createAllowedProviderClassList()) {
            try {
                try {
                    pushProvider = (PushProvider) Class.forName(str).newInstance();
                    try {
                        UALog.m1751v("Found provider: %s", pushProvider);
                    } catch (IllegalAccessException e3) {
                        e2 = e3;
                        UALog.m1746e(e2, "Unable to create provider %s", str);
                    } catch (InstantiationException e4) {
                        e = e4;
                        UALog.m1746e(e, "Unable to create provider %s", str);
                    }
                } catch (IllegalAccessException e5) {
                    pushProvider = null;
                    e2 = e5;
                } catch (InstantiationException e6) {
                    pushProvider = null;
                    e = e6;
                }
                if (pushProvider != null) {
                    arrayList.add(pushProvider);
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return arrayList;
    }

    @NonNull
    public List<PushProvider> getAvailableProviders() {
        return Collections.unmodifiableList(this.availableProviders);
    }

    @Nullable
    public PushProvider getBestProvider(int i) {
        for (PushProvider pushProvider : this.availableProviders) {
            if (pushProvider.getPlatform() == i) {
                return pushProvider;
            }
        }
        for (PushProvider pushProvider2 : this.supportedProviders) {
            if (pushProvider2.getPlatform() == i) {
                return pushProvider2;
            }
        }
        return null;
    }

    PushProvider getBestProvider() {
        if (!this.availableProviders.isEmpty()) {
            return (PushProvider) this.availableProviders.get(0);
        }
        if (this.supportedProviders.isEmpty()) {
            return null;
        }
        return (PushProvider) this.supportedProviders.get(0);
    }

    @Nullable
    public PushProvider getProvider(int i, @NonNull String str) {
        for (PushProvider pushProvider : this.supportedProviders) {
            if (i == pushProvider.getPlatform() && str.equals(pushProvider.getClass().toString())) {
                return pushProvider;
            }
        }
        return null;
    }

    private List createAllowedProviderClassList() {
        ArrayList arrayList = new ArrayList();
        if (this.airshipConfigOptions.allowedTransports.contains("FCM")) {
            arrayList.add("com.urbanairship.push.fcm.FcmPushProvider");
        }
        if (this.airshipConfigOptions.allowedTransports.contains(AirshipConfigOptions.ADM_TRANSPORT)) {
            arrayList.add("com.urbanairship.push.adm.AdmPushProvider");
        }
        if (this.airshipConfigOptions.allowedTransports.contains(AirshipConfigOptions.HMS_TRANSPORT)) {
            arrayList.add("com.urbanairship.push.hms.HmsPushProvider");
        }
        return arrayList;
    }

    private static class LazyLoader implements Supplier {
        private final AirshipConfigOptions config;
        private final Context context;
        PushProviders pushProviders = null;

        public LazyLoader(Context context, AirshipConfigOptions airshipConfigOptions) {
            this.context = context;
            this.config = airshipConfigOptions;
        }

        @Override // com.urbanairship.base.Supplier
        public synchronized PushProviders get() {
            try {
                if (this.pushProviders == null) {
                    this.pushProviders = PushProviders.load(this.context, this.config);
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.pushProviders;
        }
    }
}
