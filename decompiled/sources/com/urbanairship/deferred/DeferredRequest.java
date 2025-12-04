package com.urbanairship.deferred;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UAirship;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/urbanairship/deferred/DeferredRequest;", "", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "channelId", "", "contactId", "triggerContext", "Lcom/urbanairship/deferred/DeferredTriggerContext;", Constants.LOCALE, "Ljava/util/Locale;", "notificationOptIn", "", "appVersionName", "sdkVersion", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/deferred/DeferredTriggerContext;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;)V", "getAppVersionName", "()Ljava/lang/String;", "getChannelId", "getContactId", "getLocale", "()Ljava/util/Locale;", "getNotificationOptIn", "()Z", "getSdkVersion", "getTriggerContext", "()Lcom/urbanairship/deferred/DeferredTriggerContext;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class DeferredRequest {
    private final String appVersionName;
    private final String channelId;
    private final String contactId;
    private final Locale locale;
    private final boolean notificationOptIn;
    private final String sdkVersion;
    private final DeferredTriggerContext triggerContext;
    private final Uri uri;

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final DeferredTriggerContext getTriggerContext() {
        return this.triggerContext;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final Locale getLocale() {
        return this.locale;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getNotificationOptIn() {
        return this.notificationOptIn;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    public final DeferredRequest copy(@NotNull Uri uri, @NotNull String channelId, @Nullable String contactId, @Nullable DeferredTriggerContext triggerContext, @NotNull Locale locale, boolean notificationOptIn, @NotNull String appVersionName, @NotNull String sdkVersion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        return new DeferredRequest(uri, channelId, contactId, triggerContext, locale, notificationOptIn, appVersionName, sdkVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeferredRequest)) {
            return false;
        }
        DeferredRequest deferredRequest = (DeferredRequest) other;
        return Intrinsics.areEqual(this.uri, deferredRequest.uri) && Intrinsics.areEqual(this.channelId, deferredRequest.channelId) && Intrinsics.areEqual(this.contactId, deferredRequest.contactId) && Intrinsics.areEqual(this.triggerContext, deferredRequest.triggerContext) && Intrinsics.areEqual(this.locale, deferredRequest.locale) && this.notificationOptIn == deferredRequest.notificationOptIn && Intrinsics.areEqual(this.appVersionName, deferredRequest.appVersionName) && Intrinsics.areEqual(this.sdkVersion, deferredRequest.sdkVersion);
    }

    public int hashCode() {
        int iHashCode = ((this.uri.hashCode() * 31) + this.channelId.hashCode()) * 31;
        String str = this.contactId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DeferredTriggerContext deferredTriggerContext = this.triggerContext;
        return ((((((((iHashCode2 + (deferredTriggerContext != null ? deferredTriggerContext.hashCode() : 0)) * 31) + this.locale.hashCode()) * 31) + Boolean.hashCode(this.notificationOptIn)) * 31) + this.appVersionName.hashCode()) * 31) + this.sdkVersion.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeferredRequest(uri=" + this.uri + ", channelId=" + this.channelId + ", contactId=" + this.contactId + ", triggerContext=" + this.triggerContext + ", locale=" + this.locale + ", notificationOptIn=" + this.notificationOptIn + ", appVersionName=" + this.appVersionName + ", sdkVersion=" + this.sdkVersion + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DeferredRequest(@NotNull Uri uri, @NotNull String channelId, @Nullable String str, @Nullable DeferredTriggerContext deferredTriggerContext, @NotNull Locale locale, boolean z, @NotNull String appVersionName, @NotNull String sdkVersion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.uri = uri;
        this.channelId = channelId;
        this.contactId = str;
        this.triggerContext = deferredTriggerContext;
        this.locale = locale;
        this.notificationOptIn = z;
        this.appVersionName = appVersionName;
        this.sdkVersion = sdkVersion;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final DeferredTriggerContext getTriggerContext() {
        return this.triggerContext;
    }

    @NotNull
    public final Locale getLocale() {
        return this.locale;
    }

    public final boolean getNotificationOptIn() {
        return this.notificationOptIn;
    }

    @NotNull
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeferredRequest(Uri uri, String str, String str2, DeferredTriggerContext deferredTriggerContext, Locale locale, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        String str6 = (i & 4) != 0 ? null : str2;
        DeferredTriggerContext deferredTriggerContext2 = (i & 8) != 0 ? null : deferredTriggerContext;
        if ((i & 128) != 0) {
            String version = UAirship.getVersion();
            Intrinsics.checkNotNullExpressionValue(version, "getVersion(...)");
            str5 = version;
        } else {
            str5 = str4;
        }
        this(uri, str, str6, deferredTriggerContext2, locale, z, str3, str5);
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }
}
