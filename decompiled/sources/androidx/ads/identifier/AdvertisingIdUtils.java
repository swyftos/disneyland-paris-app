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

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AdvertisingIdUtils {
    public static final String GET_AD_ID_ACTION = "androidx.ads.identifier.provider.GET_AD_ID";

    @NonNull
    public static List<ResolveInfo> getAdvertisingIdProviderServices(@NonNull PackageManager packageManager) {
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(new Intent(GET_AD_ID_ACTION), 1048576);
        return listQueryIntentServices != null ? listQueryIntentServices : Collections.emptyList();
    }

    @Nullable
    public static ServiceInfo selectServiceByPriority(@Nullable List<ResolveInfo> list, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        ServiceInfo serviceInfo = null;
        if (list != null && !list.isEmpty()) {
            Iterator<ResolveInfo> it = list.iterator();
            PackageInfo packageInfo2 = null;
            while (it.hasNext()) {
                ServiceInfo serviceInfo2 = it.next().serviceInfo;
                try {
                    packageInfo = packageManager.getPackageInfo(serviceInfo2.packageName, 4096);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo2 == null || hasHigherPriority(packageInfo, packageInfo2)) {
                    serviceInfo = serviceInfo2;
                    packageInfo2 = packageInfo;
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
        return j != j2 ? j < j2 : packageInfo.packageName.compareTo(packageInfo2.packageName) < 0;
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
