package com.urbanairship.google;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* loaded from: classes5.dex */
abstract class ProviderInstallerWrapper {
    static int installIfNeeded(Context context) {
        try {
            ProviderInstaller.installIfNeeded(context);
            return 0;
        } catch (GooglePlayServicesNotAvailableException unused) {
            return 2;
        } catch (GooglePlayServicesRepairableException unused2) {
            return 1;
        }
    }
}
