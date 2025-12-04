package com.urbanairship.google;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.google.android.gms.security.ProviderInstaller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NetworkProviderInstaller {
    public static final int PROVIDER_ERROR = 2;
    public static final int PROVIDER_INSTALLED = 0;
    public static final int PROVIDER_RECOVERABLE_ERROR = 1;
    private static Boolean isProviderInstallerDependencyAvailable;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    private static boolean isProviderInstallerDependencyAvailable() {
        if (isProviderInstallerDependencyAvailable == null) {
            if (!PlayServicesUtils.isGooglePlayServicesDependencyAvailable()) {
                isProviderInstallerDependencyAvailable = Boolean.FALSE;
            } else {
                try {
                    String str = ProviderInstaller.PROVIDER_NAME;
                    isProviderInstallerDependencyAvailable = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    isProviderInstallerDependencyAvailable = Boolean.FALSE;
                }
            }
        }
        return isProviderInstallerDependencyAvailable.booleanValue();
    }

    @WorkerThread
    public static int installSecurityProvider(@NonNull Context context) {
        if (isProviderInstallerDependencyAvailable()) {
            return ProviderInstallerWrapper.installIfNeeded(context);
        }
        return 2;
    }
}
