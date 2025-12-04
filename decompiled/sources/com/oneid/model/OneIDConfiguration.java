package com.oneid.model;

import com.allegion.accesssdk.BuildConfig;
import com.disney.id.android.OneID;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/oneid/model/OneIDConfiguration;", "", "clientId", "", "cssOverrideUrl", "environment", "Lcom/disney/id/android/OneID$Environment;", Constants.LOCALE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/disney/id/android/OneID$Environment;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getCssOverrideUrl", "getEnvironment", "()Lcom/disney/id/android/OneID$Environment;", "getLocale", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OneIDConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String clientId;
    private final String cssOverrideUrl;
    private final OneID.Environment environment;
    private final String locale;

    public static /* synthetic */ OneIDConfiguration copy$default(OneIDConfiguration oneIDConfiguration, String str, String str2, OneID.Environment environment, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oneIDConfiguration.clientId;
        }
        if ((i & 2) != 0) {
            str2 = oneIDConfiguration.cssOverrideUrl;
        }
        if ((i & 4) != 0) {
            environment = oneIDConfiguration.environment;
        }
        if ((i & 8) != 0) {
            str3 = oneIDConfiguration.locale;
        }
        return oneIDConfiguration.copy(str, str2, environment, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCssOverrideUrl() {
        return this.cssOverrideUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final OneID.Environment getEnvironment() {
        return this.environment;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    @NotNull
    public final OneIDConfiguration copy(@NotNull String clientId, @Nullable String cssOverrideUrl, @NotNull OneID.Environment environment, @NotNull String locale) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new OneIDConfiguration(clientId, cssOverrideUrl, environment, locale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OneIDConfiguration)) {
            return false;
        }
        OneIDConfiguration oneIDConfiguration = (OneIDConfiguration) other;
        return Intrinsics.areEqual(this.clientId, oneIDConfiguration.clientId) && Intrinsics.areEqual(this.cssOverrideUrl, oneIDConfiguration.cssOverrideUrl) && this.environment == oneIDConfiguration.environment && Intrinsics.areEqual(this.locale, oneIDConfiguration.locale);
    }

    public int hashCode() {
        int iHashCode = this.clientId.hashCode() * 31;
        String str = this.cssOverrideUrl;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.environment.hashCode()) * 31) + this.locale.hashCode();
    }

    @NotNull
    public String toString() {
        return "OneIDConfiguration(clientId=" + this.clientId + ", cssOverrideUrl=" + this.cssOverrideUrl + ", environment=" + this.environment + ", locale=" + this.locale + ")";
    }

    public OneIDConfiguration(@NotNull String clientId, @Nullable String str, @NotNull OneID.Environment environment, @NotNull String locale) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.clientId = clientId;
        this.cssOverrideUrl = str;
        this.environment = environment;
        this.locale = locale;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final String getCssOverrideUrl() {
        return this.cssOverrideUrl;
    }

    @NotNull
    public final OneID.Environment getEnvironment() {
        return this.environment;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/oneid/model/OneIDConfiguration$Companion;", "", "<init>", "()V", "fromArguments", "Lcom/oneid/model/OneIDConfiguration;", "clientId", "", "environment", Constants.LOCALE, "overrideCssUrl", "getEnvironment", "Lcom/disney/id/android/OneID$Environment;", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final OneIDConfiguration fromArguments(@NotNull String clientId, @NotNull String environment, @NotNull String locale, @Nullable String overrideCssUrl) throws Exception {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(locale, "locale");
            if (clientId.length() == 0) {
                throw new Exception("Missing clientId");
            }
            return new OneIDConfiguration(clientId, overrideCssUrl, getEnvironment(environment), locale);
        }

        private final OneID.Environment getEnvironment(String environment) throws Exception {
            String lowerCase = environment.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 3600) {
                if (iHashCode != 114214) {
                    if (iHashCode == 3449687 && lowerCase.equals("prod")) {
                        return OneID.Environment.PROD;
                    }
                } else if (lowerCase.equals("stg")) {
                    return OneID.Environment.STG;
                }
            } else if (lowerCase.equals(BuildConfig.FLAVOR)) {
                return OneID.Environment.QA;
            }
            throw new Exception("Missing environment");
        }
    }
}
