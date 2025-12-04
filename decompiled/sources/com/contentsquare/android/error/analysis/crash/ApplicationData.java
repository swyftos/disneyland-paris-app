package com.contentsquare.android.error.analysis.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/ApplicationData;", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "versionName", "versionCode", "", "nativeMappingVersion", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getNativeMappingVersion", "()Ljava/lang/String;", "getPackageName", "getVersionCode", "()J", "getVersionName", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ApplicationData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String MAPPING_ID_RESOURCE_IDENTIFIER = "contentsquare_mapping_id";

    @NotNull
    private final String nativeMappingVersion;

    @NotNull
    private final String packageName;
    private final long versionCode;

    @NotNull
    private final String versionName;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/ApplicationData$Companion;", "", "()V", "MAPPING_ID_RESOURCE_IDENTIFIER", "", "fromContext", "Lcom/contentsquare/android/error/analysis/crash/ApplicationData;", "context", "Landroid/content/Context;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ApplicationData fromContext(Context context) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…ckageInfo(packageName, 0)");
            int identifier = context.getResources().getIdentifier(ApplicationData.MAPPING_ID_RESOURCE_IDENTIFIER, "string", packageName);
            if (identifier == 0) {
                str = "";
            } else {
                String string = context.getResources().getString(identifier);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                contex…ppingIdRes)\n            }");
                str = string;
            }
            String str2 = packageName == null ? "" : packageName;
            String str3 = packageInfo.versionName;
            return new ApplicationData(str2, str3 == null ? "" : str3, packageInfo.versionCode, str);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ApplicationData(String packageName, String versionName, long j, String nativeMappingVersion) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(nativeMappingVersion, "nativeMappingVersion");
        this.packageName = packageName;
        this.versionName = versionName;
        this.versionCode = j;
        this.nativeMappingVersion = nativeMappingVersion;
    }

    public static /* synthetic */ ApplicationData copy$default(ApplicationData applicationData, String str, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicationData.packageName;
        }
        if ((i & 2) != 0) {
            str2 = applicationData.versionName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = applicationData.versionCode;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = applicationData.nativeMappingVersion;
        }
        return applicationData.copy(str, str4, j2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component3, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getNativeMappingVersion() {
        return this.nativeMappingVersion;
    }

    @NotNull
    public final ApplicationData copy(String packageName, String versionName, long versionCode, String nativeMappingVersion) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(nativeMappingVersion, "nativeMappingVersion");
        return new ApplicationData(packageName, versionName, versionCode, nativeMappingVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationData)) {
            return false;
        }
        ApplicationData applicationData = (ApplicationData) other;
        return Intrinsics.areEqual(this.packageName, applicationData.packageName) && Intrinsics.areEqual(this.versionName, applicationData.versionName) && this.versionCode == applicationData.versionCode && Intrinsics.areEqual(this.nativeMappingVersion, applicationData.nativeMappingVersion);
    }

    @NotNull
    public final String getNativeMappingVersion() {
        return this.nativeMappingVersion;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return this.nativeMappingVersion.hashCode() + ((Long.hashCode(this.versionCode) + ((this.versionName.hashCode() + (this.packageName.hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "ApplicationData(packageName=" + this.packageName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", nativeMappingVersion=" + this.nativeMappingVersion + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
