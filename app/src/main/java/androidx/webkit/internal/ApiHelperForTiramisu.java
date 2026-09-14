package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
public class ApiHelperForTiramisu {
    @DoNotInline
    /* JADX INFO: renamed from: of */
    static PackageManager.ComponentInfoFlags m402of(long j) {
        return PackageManager.ComponentInfoFlags.of(j);
    }

    @DoNotInline
    static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }
}
