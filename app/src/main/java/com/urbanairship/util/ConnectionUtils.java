package com.urbanairship.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.urbanairship.UALog;
import com.urbanairship.google.NetworkProviderInstaller;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConnectionUtils {
    private static boolean isInstalled = false;
    private static boolean skipInstall = false;

    @NonNull
    @WorkerThread
    public static URLConnection openSecureConnection(@NonNull Context context, @NonNull URL url) throws IOException {
        installProvider(context);
        return url.openConnection();
    }

    private static synchronized boolean installProvider(Context context) {
        if (skipInstall) {
            return isInstalled;
        }
        if (!ManifestUtils.shouldInstallNetworkSecurityProvider()) {
            skipInstall = true;
            return isInstalled;
        }
        int iInstallSecurityProvider = NetworkProviderInstaller.installSecurityProvider(context);
        if (iInstallSecurityProvider == 0) {
            UALog.m1748i("Network Security Provider installed.", new Object[0]);
            skipInstall = true;
            isInstalled = true;
        } else if (iInstallSecurityProvider == 1) {
            UALog.m1748i("Network Security Provider failed to install with a recoverable error.", new Object[0]);
        } else if (iInstallSecurityProvider == 2) {
            UALog.m1748i("Network Security Provider failed to install.", new Object[0]);
            skipInstall = true;
        }
        return isInstalled;
    }
}
