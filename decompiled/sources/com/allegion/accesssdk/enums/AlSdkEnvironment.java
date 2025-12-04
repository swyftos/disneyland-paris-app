package com.allegion.accesssdk.enums;

import com.allegion.accesssdk.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DEV' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0080\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/allegion/accesssdk/enums/AlSdkEnvironment;", "", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "", "trackCrashes", "Z", "getTrackCrashes", "()Z", "", "baseApiManagementUrl", "Ljava/lang/String;", "getBaseApiManagementUrl", "()Ljava/lang/String;", "baseAccessHubUrl", "getBaseAccessHubUrl", "appCenterAppId", "getAppCenterAppId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Companion", "DEV", "QA", "BETA", "PILOT", "PRODUCTION", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlSdkEnvironment implements IAlSdkEnvironment {
    private static final /* synthetic */ AlSdkEnvironment[] $VALUES;
    public static final AlSdkEnvironment BETA;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AlSdkEnvironment DEV;
    public static final AlSdkEnvironment PILOT;
    public static final AlSdkEnvironment PRODUCTION;
    public static final AlSdkEnvironment QA;

    @NotNull
    private static final IAlSdkEnvironment current;

    @NotNull
    private final String appCenterAppId;

    @NotNull
    private final String baseAccessHubUrl;

    @NotNull
    private final String baseApiManagementUrl;
    private final boolean trackCrashes;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/enums/AlSdkEnvironment$Companion;", "", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "current", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "getCurrent", "()Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "current$annotations", "()V", "<init>", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void current$annotations() {
        }

        @NotNull
        public final IAlSdkEnvironment getCurrent() {
            return AlSdkEnvironment.current;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Boolean bool = BuildConfig.Dev.TRACKCRASHES;
        Intrinsics.checkExpressionValueIsNotNull(bool, "BuildConfig.Dev.TRACKCRASHES");
        AlSdkEnvironment alSdkEnvironment = new AlSdkEnvironment("DEV", 0, "https://api.securewebserv.com/dev/mobileaccess/", "https://api.securewebserv.com", bool.booleanValue(), BuildConfig.Dev.APPCENTERAPPID);
        DEV = alSdkEnvironment;
        Boolean bool2 = BuildConfig.Qa.TRACKCRASHES;
        Intrinsics.checkExpressionValueIsNotNull(bool2, "BuildConfig.Qa.TRACKCRASHES");
        AlSdkEnvironment alSdkEnvironment2 = new AlSdkEnvironment("QA", 1, "https://api.securewebserv.com/test/mobileaccess/", "https://api.securewebserv.com", bool2.booleanValue(), BuildConfig.Qa.APPCENTERAPPID);
        QA = alSdkEnvironment2;
        Boolean bool3 = BuildConfig.Beta.TRACKCRASHES;
        Intrinsics.checkExpressionValueIsNotNull(bool3, "BuildConfig.Beta.TRACKCRASHES");
        AlSdkEnvironment alSdkEnvironment3 = new AlSdkEnvironment("BETA", 2, "https://api.securewebserv.com/mobileaccess/", "https://api.securewebserv.com", bool3.booleanValue(), BuildConfig.Beta.APPCENTERAPPID);
        BETA = alSdkEnvironment3;
        Boolean bool4 = BuildConfig.Pilot.TRACKCRASHES;
        Intrinsics.checkExpressionValueIsNotNull(bool4, "BuildConfig.Pilot.TRACKCRASHES");
        AlSdkEnvironment alSdkEnvironment4 = new AlSdkEnvironment("PILOT", 3, "https://api.allegion.com/pilot/mobileaccess/", "https://api.allegion.com/", bool4.booleanValue(), BuildConfig.Pilot.APPCENTERAPPID);
        PILOT = alSdkEnvironment4;
        Boolean bool5 = BuildConfig.Production.TRACKCRASHES;
        Intrinsics.checkExpressionValueIsNotNull(bool5, "BuildConfig.Production.TRACKCRASHES");
        AlSdkEnvironment alSdkEnvironment5 = new AlSdkEnvironment("PRODUCTION", 4, "https://api.allegion.com/mobileaccess/", "https://api.allegion.com/", bool5.booleanValue(), BuildConfig.Production.APPCENTERAPPID);
        PRODUCTION = alSdkEnvironment5;
        $VALUES = new AlSdkEnvironment[]{alSdkEnvironment, alSdkEnvironment2, alSdkEnvironment3, alSdkEnvironment4, alSdkEnvironment5};
        INSTANCE = new Companion(null);
        AlSdkEnvironment alSdkEnvironment6 = BuildConfig.ENV;
        Intrinsics.checkExpressionValueIsNotNull(alSdkEnvironment6, "BuildConfig.ENV");
        current = alSdkEnvironment6;
    }

    private AlSdkEnvironment(String str, int i, String str2, String str3, boolean z, String str4) {
        this.baseAccessHubUrl = str2;
        this.baseApiManagementUrl = str3;
        this.trackCrashes = z;
        this.appCenterAppId = str4;
    }

    @NotNull
    public static final IAlSdkEnvironment getCurrent() {
        return current;
    }

    public static AlSdkEnvironment valueOf(String str) {
        return (AlSdkEnvironment) Enum.valueOf(AlSdkEnvironment.class, str);
    }

    public static AlSdkEnvironment[] values() {
        return (AlSdkEnvironment[]) $VALUES.clone();
    }

    @Override // com.allegion.accesssdk.enums.IAlSdkEnvironment
    @NotNull
    public String getAppCenterAppId() {
        return this.appCenterAppId;
    }

    @Override // com.allegion.accesshub.interfaces.IAlMAHEnvironment
    @NotNull
    public String getBaseAccessHubUrl() {
        return this.baseAccessHubUrl;
    }

    @Override // com.allegion.accesshub.interfaces.IAlMAHEnvironment
    @NotNull
    public String getBaseApiManagementUrl() {
        return this.baseApiManagementUrl;
    }

    @Override // com.allegion.accesssdk.enums.IAlSdkEnvironment
    public boolean getTrackCrashes() {
        return this.trackCrashes;
    }
}
