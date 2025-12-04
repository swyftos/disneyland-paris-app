package com.contentsquare.android.core.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0017\u0010\u0005\u001a\u00020\u00068F¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0011\u0010!\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018¨\u0006%"}, d2 = {"Lcom/contentsquare/android/core/utils/BuildInformation;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "appKotlinVersion", "", "getAppKotlinVersion$annotations", "()V", "getAppKotlinVersion", "()Ljava/lang/String;", "applicationId", "getApplicationId", "applicationName", "getApplicationName", "applicationVersion", "getApplicationVersion", "applicationVersionCode", "", "getApplicationVersionCode", "()J", "compileSdkVersion", "", "getCompileSdkVersion", "()I", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "minSdkVersion", "getMinSdkVersion", "sdkBuild", "getSdkBuild", "sdkVersion", "getSdkVersion", "targetSdkVersion", "getTargetSdkVersion", "readPackageInfo", "Landroid/content/pm/PackageInfo;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BuildInformation {

    @NotNull
    private final Application application;

    @NotNull
    private final Logger logger;

    public BuildInformation(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = new Logger("BuildInformation");
    }

    public static /* synthetic */ void getAppKotlinVersion$annotations() {
    }

    private final PackageInfo readPackageInfo(Application application) {
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            this.logger.e(e, "Failed to getPackageInfo from the application");
            return null;
        }
    }

    @NotNull
    public final String getAppKotlinVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (Exception unused) {
            return "Kotlin not present";
        }
    }

    @NotNull
    public final String getApplicationId() {
        String packageName = this.application.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "application.packageName");
        return packageName;
    }

    @NotNull
    public final String getApplicationName() {
        return this.application.getApplicationInfo().loadLabel(this.application.getPackageManager()).toString();
    }

    @NotNull
    public final String getApplicationVersion() {
        String versionName;
        PackageInfo packageInfo = readPackageInfo(this.application);
        if (packageInfo == null || (versionName = packageInfo.versionName) == null || versionName.length() == 0) {
            return "unknown";
        }
        Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
        return versionName;
    }

    public final long getApplicationVersionCode() {
        PackageInfo packageInfo = readPackageInfo(this.application);
        if (packageInfo == null) {
            return 0L;
        }
        packageInfo.getLongVersionCode();
        return packageInfo.getLongVersionCode();
    }

    public final int getCompileSdkVersion() {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = readPackageInfo(this.application);
        if (packageInfo == null || Build.VERSION.SDK_INT < 31 || (applicationInfo = packageInfo.applicationInfo) == null) {
            return 0;
        }
        return applicationInfo.compileSdkVersion;
    }

    public final int getMinSdkVersion() {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = readPackageInfo(this.application);
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return 0;
        }
        return applicationInfo.minSdkVersion;
    }

    public final int getSdkBuild() {
        return 1043600;
    }

    @NotNull
    public final String getSdkVersion() {
        return "4.36.0";
    }

    public final int getTargetSdkVersion() {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = readPackageInfo(this.application);
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }
}
