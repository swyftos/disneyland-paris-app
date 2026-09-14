package expo.modules.application;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0002¨\u0006\n"}, m1836d2 = {"getPackageInfoCompat", "Landroid/content/pm/PackageInfo;", "Landroid/content/pm/PackageManager;", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "flags", "", "getLongVersionCode", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "expo-application_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ApplicationModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageInfo getPackageInfoCompat(PackageManager packageManager, String str, int i) throws ApplicationPackageNameNotFoundException {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                return packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
            }
            return packageManager.getPackageInfo(str, i);
        } catch (PackageManager.NameNotFoundException e) {
            throw new ApplicationPackageNameNotFoundException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }
}
