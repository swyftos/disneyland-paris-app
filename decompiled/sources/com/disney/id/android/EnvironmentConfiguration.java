package com.disney.id.android;

import androidx.annotation.Keep;
import com.disney.id.android.OneID;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/EnvironmentConfiguration;", "", "clientIDEnvKey", "", "logGoURL", "guestControllerURL", "bundlerURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBundlerURL", "()Ljava/lang/String;", "getClientIDEnvKey", "getGuestControllerURL", "getLogGoURL", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EnvironmentConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final EnvironmentConfiguration PROD;

    @NotNull
    private static final EnvironmentConfiguration QA;

    @NotNull
    private static final EnvironmentConfiguration STG;

    @NotNull
    private static final EnvironmentConfiguration VAL;

    @NotNull
    private static final Map<OneID.Environment, EnvironmentConfiguration> data;

    @NotNull
    private final String bundlerURL;

    @NotNull
    private final String clientIDEnvKey;

    @NotNull
    private final String guestControllerURL;

    @NotNull
    private final String logGoURL;

    public static /* synthetic */ EnvironmentConfiguration copy$default(EnvironmentConfiguration environmentConfiguration, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = environmentConfiguration.clientIDEnvKey;
        }
        if ((i & 2) != 0) {
            str2 = environmentConfiguration.logGoURL;
        }
        if ((i & 4) != 0) {
            str3 = environmentConfiguration.guestControllerURL;
        }
        if ((i & 8) != 0) {
            str4 = environmentConfiguration.bundlerURL;
        }
        return environmentConfiguration.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getClientIDEnvKey() {
        return this.clientIDEnvKey;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getLogGoURL() {
        return this.logGoURL;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getGuestControllerURL() {
        return this.guestControllerURL;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    @NotNull
    public final EnvironmentConfiguration copy(@NotNull String clientIDEnvKey, @NotNull String logGoURL, @NotNull String guestControllerURL, @NotNull String bundlerURL) {
        Intrinsics.checkNotNullParameter(clientIDEnvKey, "clientIDEnvKey");
        Intrinsics.checkNotNullParameter(logGoURL, "logGoURL");
        Intrinsics.checkNotNullParameter(guestControllerURL, "guestControllerURL");
        Intrinsics.checkNotNullParameter(bundlerURL, "bundlerURL");
        return new EnvironmentConfiguration(clientIDEnvKey, logGoURL, guestControllerURL, bundlerURL);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnvironmentConfiguration)) {
            return false;
        }
        EnvironmentConfiguration environmentConfiguration = (EnvironmentConfiguration) other;
        return Intrinsics.areEqual(this.clientIDEnvKey, environmentConfiguration.clientIDEnvKey) && Intrinsics.areEqual(this.logGoURL, environmentConfiguration.logGoURL) && Intrinsics.areEqual(this.guestControllerURL, environmentConfiguration.guestControllerURL) && Intrinsics.areEqual(this.bundlerURL, environmentConfiguration.bundlerURL);
    }

    public int hashCode() {
        return (((((this.clientIDEnvKey.hashCode() * 31) + this.logGoURL.hashCode()) * 31) + this.guestControllerURL.hashCode()) * 31) + this.bundlerURL.hashCode();
    }

    @NotNull
    public String toString() {
        return "EnvironmentConfiguration(clientIDEnvKey=" + this.clientIDEnvKey + ", logGoURL=" + this.logGoURL + ", guestControllerURL=" + this.guestControllerURL + ", bundlerURL=" + this.bundlerURL + ")";
    }

    public EnvironmentConfiguration(@NotNull String clientIDEnvKey, @NotNull String logGoURL, @NotNull String guestControllerURL, @NotNull String bundlerURL) {
        Intrinsics.checkNotNullParameter(clientIDEnvKey, "clientIDEnvKey");
        Intrinsics.checkNotNullParameter(logGoURL, "logGoURL");
        Intrinsics.checkNotNullParameter(guestControllerURL, "guestControllerURL");
        Intrinsics.checkNotNullParameter(bundlerURL, "bundlerURL");
        this.clientIDEnvKey = clientIDEnvKey;
        this.logGoURL = logGoURL;
        this.guestControllerURL = guestControllerURL;
        this.bundlerURL = bundlerURL;
    }

    @NotNull
    public final String getClientIDEnvKey() {
        return this.clientIDEnvKey;
    }

    @NotNull
    public final String getLogGoURL() {
        return this.logGoURL;
    }

    @NotNull
    public final String getGuestControllerURL() {
        return this.guestControllerURL;
    }

    @NotNull
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/EnvironmentConfiguration$Companion;", "", "()V", "PROD", "Lcom/disney/id/android/EnvironmentConfiguration;", "getPROD", "()Lcom/disney/id/android/EnvironmentConfiguration;", "QA", "getQA", "STG", "getSTG", "VAL", "getVAL", "data", "", "Lcom/disney/id/android/OneID$Environment;", "getData", "()Ljava/util/Map;", "configurationFor", "environment", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EnvironmentConfiguration getQA() {
            return EnvironmentConfiguration.QA;
        }

        @NotNull
        public final EnvironmentConfiguration getSTG() {
            return EnvironmentConfiguration.STG;
        }

        @NotNull
        public final EnvironmentConfiguration getVAL() {
            return EnvironmentConfiguration.VAL;
        }

        @NotNull
        public final EnvironmentConfiguration getPROD() {
            return EnvironmentConfiguration.PROD;
        }

        @NotNull
        public final Map<OneID.Environment, EnvironmentConfiguration> getData() {
            return EnvironmentConfiguration.data;
        }

        @NotNull
        public final EnvironmentConfiguration configurationFor(@NotNull OneID.Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            EnvironmentConfiguration environmentConfiguration = getData().get(environment);
            return environmentConfiguration == null ? getPROD() : environmentConfiguration;
        }
    }

    static {
        EnvironmentConfiguration environmentConfiguration = new EnvironmentConfiguration("QA", "https://feet-qa.segds.engsvc.go.com/", "https://qa.registerdisney.go.com/jgc/v8/client/", "https://qa.cdn.registerdisney.go.com");
        QA = environmentConfiguration;
        EnvironmentConfiguration environmentConfiguration2 = new EnvironmentConfiguration("STAGE", "https://feet-stg.segds.engsvc.go.com/", "https://stg.registerdisney.go.com/jgc/v8/client/", "https://stg.cdn.registerdisney.go.com");
        STG = environmentConfiguration2;
        EnvironmentConfiguration environmentConfiguration3 = new EnvironmentConfiguration("VAL", "https://feet-qa.segds.engsvc.go.com/", "https://val.registerdisney.go.com/jgc/v8/client/", "https://val.cdn.registerdisney.go.com");
        VAL = environmentConfiguration3;
        EnvironmentConfiguration environmentConfiguration4 = new EnvironmentConfiguration("PROD", "https://log.go.com/", "https://registerdisney.go.com/jgc/v8/client/", "https://cdn.registerdisney.go.com");
        PROD = environmentConfiguration4;
        data = MapsKt.mapOf(TuplesKt.to(OneID.Environment.QA, environmentConfiguration), TuplesKt.to(OneID.Environment.STG, environmentConfiguration2), TuplesKt.to(OneID.Environment.VAL, environmentConfiguration3), TuplesKt.to(OneID.Environment.PROD, environmentConfiguration4));
    }
}
