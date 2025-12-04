package com.urbanairship.deferred;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\""}, d2 = {"Lcom/urbanairship/deferred/StateOverrides;", "Lcom/urbanairship/json/JsonSerializable;", "request", "Lcom/urbanairship/deferred/DeferredRequest;", "(Lcom/urbanairship/deferred/DeferredRequest;)V", "appVersionName", "", "sdkVersion", "notificationOptIn", "", Constants.LOCALE, "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Locale;)V", "getAppVersionName", "()Ljava/lang/String;", "getLocale", "()Ljava/util/Locale;", "getNotificationOptIn", "()Z", "getSdkVersion", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StateOverrides implements JsonSerializable {
    private final String appVersionName;
    private final Locale locale;
    private final boolean notificationOptIn;
    private final String sdkVersion;

    public static /* synthetic */ StateOverrides copy$default(StateOverrides stateOverrides, String str, String str2, boolean z, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stateOverrides.appVersionName;
        }
        if ((i & 2) != 0) {
            str2 = stateOverrides.sdkVersion;
        }
        if ((i & 4) != 0) {
            z = stateOverrides.notificationOptIn;
        }
        if ((i & 8) != 0) {
            locale = stateOverrides.locale;
        }
        return stateOverrides.copy(str, str2, z, locale);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNotificationOptIn() {
        return this.notificationOptIn;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Locale getLocale() {
        return this.locale;
    }

    @NotNull
    public final StateOverrides copy(@NotNull String appVersionName, @NotNull String sdkVersion, boolean notificationOptIn, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        return new StateOverrides(appVersionName, sdkVersion, notificationOptIn, locale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StateOverrides)) {
            return false;
        }
        StateOverrides stateOverrides = (StateOverrides) other;
        return Intrinsics.areEqual(this.appVersionName, stateOverrides.appVersionName) && Intrinsics.areEqual(this.sdkVersion, stateOverrides.sdkVersion) && this.notificationOptIn == stateOverrides.notificationOptIn && Intrinsics.areEqual(this.locale, stateOverrides.locale);
    }

    public int hashCode() {
        int iHashCode = ((((this.appVersionName.hashCode() * 31) + this.sdkVersion.hashCode()) * 31) + Boolean.hashCode(this.notificationOptIn)) * 31;
        Locale locale = this.locale;
        return iHashCode + (locale == null ? 0 : locale.hashCode());
    }

    @NotNull
    public String toString() {
        return "StateOverrides(appVersionName=" + this.appVersionName + ", sdkVersion=" + this.sdkVersion + ", notificationOptIn=" + this.notificationOptIn + ", locale=" + this.locale + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public StateOverrides(@NotNull String appVersionName, @NotNull String sdkVersion, boolean z, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.appVersionName = appVersionName;
        this.sdkVersion = sdkVersion;
        this.notificationOptIn = z;
        this.locale = locale;
    }

    @NotNull
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getNotificationOptIn() {
        return this.notificationOptIn;
    }

    @Nullable
    public final Locale getLocale() {
        return this.locale;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateOverrides(@NotNull DeferredRequest request) {
        this(request.getAppVersionName(), request.getSdkVersion(), request.getNotificationOptIn(), request.getLocale());
        Intrinsics.checkNotNullParameter(request, "request");
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        Pair pair = TuplesKt.to("app_version", this.appVersionName);
        Pair pair2 = TuplesKt.to(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION, this.sdkVersion);
        Pair pair3 = TuplesKt.to("notification_opt_in", Boolean.valueOf(this.notificationOptIn));
        Locale locale = this.locale;
        Pair pair4 = TuplesKt.to("locale_country", locale != null ? locale.getCountry() : null);
        Locale locale2 = this.locale;
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, TuplesKt.to("locale_language", locale2 != null ? locale2.getLanguage() : null)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
