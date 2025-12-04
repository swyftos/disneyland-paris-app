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

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
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
            UALog.w("No push providers found!. Make sure to install either `urbanairship-fcm` or `urbanairship-adm`.", new Object[0]);
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
                UALog.e("Provider: %s version %s does not match the SDK version %s. Make sure all Airship dependencies are the same version.", pushProvider, airshipVersionInfo.getAirshipVersion(), UAirship.getVersion());
                return false;
            }
        }
        String deliveryType = pushProvider.getDeliveryType();
        deliveryType.hashCode();
        switch (deliveryType) {
            case "adm":
                if (pushProvider.getPlatform() != 1) {
                    UALog.e("Invalid Provider: %s. ADM delivery is only available for Amazon platforms.", pushProvider);
                    return false;
                }
                return true;
            case "fcm":
            case "hms":
                if (pushProvider.getPlatform() != 2) {
                    UALog.e("Invalid Provider: %s. %s delivery is only available for Android platforms.", pushProvider.getDeliveryType(), pushProvider);
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0018 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List createProviders() {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to create provider %s"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.urbanairship.AirshipConfigOptions r2 = r7.airshipConfigOptions
            com.urbanairship.push.PushProvider r2 = r2.customPushProvider
            if (r2 == 0) goto L10
            r1.add(r2)
        L10:
            java.util.List r7 = r7.createAllowedProviderClassList()
            java.util.Iterator r7 = r7.iterator()
        L18:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L5d
            java.lang.Object r2 = r7.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            java.lang.Class r4 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L18 java.lang.IllegalAccessException -> L3d java.lang.InstantiationException -> L42
            java.lang.Object r4 = r4.newInstance()     // Catch: java.lang.ClassNotFoundException -> L18 java.lang.IllegalAccessException -> L3d java.lang.InstantiationException -> L42
            com.urbanairship.push.PushProvider r4 = (com.urbanairship.push.PushProvider) r4     // Catch: java.lang.ClassNotFoundException -> L18 java.lang.IllegalAccessException -> L3d java.lang.InstantiationException -> L42
            java.lang.String r3 = "Found provider: %s"
            java.lang.Object[] r5 = new java.lang.Object[]{r4}     // Catch: java.lang.ClassNotFoundException -> L18 java.lang.IllegalAccessException -> L39 java.lang.InstantiationException -> L3b
            com.urbanairship.UALog.v(r3, r5)     // Catch: java.lang.ClassNotFoundException -> L18 java.lang.IllegalAccessException -> L39 java.lang.InstantiationException -> L3b
            goto L56
        L39:
            r3 = move-exception
            goto L47
        L3b:
            r3 = move-exception
            goto L4f
        L3d:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L47
        L42:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L4f
        L47:
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            com.urbanairship.UALog.e(r3, r0, r2)
            goto L56
        L4f:
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            com.urbanairship.UALog.e(r3, r0, r2)
        L56:
            if (r4 != 0) goto L59
            goto L18
        L59:
            r1.add(r4)
            goto L18
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.PushProviders.createProviders():java.util.List");
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
