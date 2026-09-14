package androidx.ads.identifier;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AdvertisingIdUtils {
    public static final String GET_AD_ID_ACTION = "androidx.ads.identifier.provider.GET_AD_ID";

    @NonNull
    public static List<ResolveInfo> getAdvertisingIdProviderServices(@NonNull PackageManager packageManager) {
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(new Intent(GET_AD_ID_ACTION), 1048576);
        return listQueryIntentServices != null ? listQueryIntentServices : Collections.emptyList();
    }

    @Nullable
    public static ServiceInfo selectServiceByPriority(@Nullable List<ResolveInfo> list, @NonNull PackageManager packageManager) {
        ServiceInfo serviceInfo = null;
        if (list != null && !list.isEmpty()) {
            Iterator<ResolveInfo> it = list.iterator();
            PackageInfo packageInfo = null;
            while (it.hasNext()) {
                ServiceInfo serviceInfo2 = it.next().serviceInfo;
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(serviceInfo2.packageName, 4096);
                    if (packageInfo == null || hasHigherPriority(packageInfo2, packageInfo)) {
                        serviceInfo = serviceInfo2;
                        packageInfo = packageInfo2;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return serviceInfo;
    }

    private static boolean hasHigherPriority(PackageInfo packageInfo, PackageInfo packageInfo2) {
        boolean zIsRequestHighPriority = isRequestHighPriority(packageInfo);
        if (zIsRequestHighPriority != isRequestHighPriority(packageInfo2)) {
            return zIsRequestHighPriority;
        }
        long j = packageInfo.firstInstallTime;
        long j2 = packageInfo2.firstInstallTime;
        if (j != j2) {
            return j < j2;
        }
        return packageInfo.packageName.compareTo(packageInfo2.packageName) < 0;
    }

    private static boolean isRequestHighPriority(PackageInfo packageInfo) {
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if ("androidx.ads.identifier.provider.HIGH_PRIORITY".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
