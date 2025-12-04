package androidx.test.core.content.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public final class PackageInfoBuilder {
    private ApplicationInfo applicationInfo;
    private String packageName;

    private PackageInfoBuilder() {
    }

    public static PackageInfoBuilder newBuilder() {
        return new PackageInfoBuilder();
    }

    public PackageInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public PackageInfoBuilder setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }

    public PackageInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = this.packageName;
        if (this.applicationInfo == null) {
            this.applicationInfo = ApplicationInfoBuilder.newBuilder().setPackageName(this.packageName).build();
        }
        ApplicationInfo applicationInfo = this.applicationInfo;
        packageInfo.applicationInfo = applicationInfo;
        Checks.checkState(packageInfo.packageName.equals(applicationInfo.packageName), "Field 'packageName' must match field 'applicationInfo.packageName'");
        return packageInfo;
    }
}
