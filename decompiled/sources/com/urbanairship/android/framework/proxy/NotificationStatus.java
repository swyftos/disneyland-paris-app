package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.push.PushNotificationStatus;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB?\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\t\u0010\u0016\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/urbanairship/android/framework/proxy/NotificationStatus;", "Lcom/urbanairship/json/JsonSerializable;", "value", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "status", "Lcom/urbanairship/push/PushNotificationStatus;", "notificationPermissionStatus", "", "(Lcom/urbanairship/push/PushNotificationStatus;Ljava/lang/String;)V", "isUserNotificationsEnabled", "", "areNotificationsAllowed", "isPushPrivacyFeatureEnabled", "isPushTokenRegistered", "isUserOptedIn", "isOptedIn", "(ZZZZZZLjava/lang/String;)V", "getAreNotificationsAllowed", "()Z", "getNotificationPermissionStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNotificationStatus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationStatus.kt\ncom/urbanairship/android/framework/proxy/NotificationStatus\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,50:1\n44#2,15:51\n44#2,15:66\n44#2,15:81\n44#2,15:96\n44#2,15:111\n44#2,15:126\n79#2,16:141\n*S KotlinDebug\n*F\n+ 1 NotificationStatus.kt\ncom/urbanairship/android/framework/proxy/NotificationStatus\n*L\n21#1:51,15\n22#1:66,15\n23#1:81,15\n24#1:96,15\n25#1:111,15\n26#1:126,15\n27#1:141,16\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class NotificationStatus implements JsonSerializable {
    private final boolean areNotificationsAllowed;
    private final boolean isOptedIn;
    private final boolean isPushPrivacyFeatureEnabled;
    private final boolean isPushTokenRegistered;
    private final boolean isUserNotificationsEnabled;
    private final boolean isUserOptedIn;
    private final String notificationPermissionStatus;

    public static /* synthetic */ NotificationStatus copy$default(NotificationStatus notificationStatus, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = notificationStatus.isUserNotificationsEnabled;
        }
        if ((i & 2) != 0) {
            z2 = notificationStatus.areNotificationsAllowed;
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = notificationStatus.isPushPrivacyFeatureEnabled;
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            z4 = notificationStatus.isPushTokenRegistered;
        }
        boolean z9 = z4;
        if ((i & 16) != 0) {
            z5 = notificationStatus.isUserOptedIn;
        }
        boolean z10 = z5;
        if ((i & 32) != 0) {
            z6 = notificationStatus.isOptedIn;
        }
        boolean z11 = z6;
        if ((i & 64) != 0) {
            str = notificationStatus.notificationPermissionStatus;
        }
        return notificationStatus.copy(z, z7, z8, z9, z10, z11, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsUserNotificationsEnabled() {
        return this.isUserNotificationsEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAreNotificationsAllowed() {
        return this.areNotificationsAllowed;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPushPrivacyFeatureEnabled() {
        return this.isPushPrivacyFeatureEnabled;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsPushTokenRegistered() {
        return this.isPushTokenRegistered;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsUserOptedIn() {
        return this.isUserOptedIn;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsOptedIn() {
        return this.isOptedIn;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getNotificationPermissionStatus() {
        return this.notificationPermissionStatus;
    }

    @NotNull
    public final NotificationStatus copy(boolean isUserNotificationsEnabled, boolean areNotificationsAllowed, boolean isPushPrivacyFeatureEnabled, boolean isPushTokenRegistered, boolean isUserOptedIn, boolean isOptedIn, @Nullable String notificationPermissionStatus) {
        return new NotificationStatus(isUserNotificationsEnabled, areNotificationsAllowed, isPushPrivacyFeatureEnabled, isPushTokenRegistered, isUserOptedIn, isOptedIn, notificationPermissionStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationStatus)) {
            return false;
        }
        NotificationStatus notificationStatus = (NotificationStatus) other;
        return this.isUserNotificationsEnabled == notificationStatus.isUserNotificationsEnabled && this.areNotificationsAllowed == notificationStatus.areNotificationsAllowed && this.isPushPrivacyFeatureEnabled == notificationStatus.isPushPrivacyFeatureEnabled && this.isPushTokenRegistered == notificationStatus.isPushTokenRegistered && this.isUserOptedIn == notificationStatus.isUserOptedIn && this.isOptedIn == notificationStatus.isOptedIn && Intrinsics.areEqual(this.notificationPermissionStatus, notificationStatus.notificationPermissionStatus);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Boolean.hashCode(this.isUserNotificationsEnabled) * 31) + Boolean.hashCode(this.areNotificationsAllowed)) * 31) + Boolean.hashCode(this.isPushPrivacyFeatureEnabled)) * 31) + Boolean.hashCode(this.isPushTokenRegistered)) * 31) + Boolean.hashCode(this.isUserOptedIn)) * 31) + Boolean.hashCode(this.isOptedIn)) * 31;
        String str = this.notificationPermissionStatus;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "NotificationStatus(isUserNotificationsEnabled=" + this.isUserNotificationsEnabled + ", areNotificationsAllowed=" + this.areNotificationsAllowed + ", isPushPrivacyFeatureEnabled=" + this.isPushPrivacyFeatureEnabled + ", isPushTokenRegistered=" + this.isPushTokenRegistered + ", isUserOptedIn=" + this.isUserOptedIn + ", isOptedIn=" + this.isOptedIn + ", notificationPermissionStatus=" + this.notificationPermissionStatus + ")";
    }

    public NotificationStatus(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str) {
        this.isUserNotificationsEnabled = z;
        this.areNotificationsAllowed = z2;
        this.isPushPrivacyFeatureEnabled = z3;
        this.isPushTokenRegistered = z4;
        this.isUserOptedIn = z5;
        this.isOptedIn = z6;
        this.notificationPermissionStatus = str;
    }

    public final boolean isUserNotificationsEnabled() {
        return this.isUserNotificationsEnabled;
    }

    public final boolean getAreNotificationsAllowed() {
        return this.areNotificationsAllowed;
    }

    public final boolean isPushPrivacyFeatureEnabled() {
        return this.isPushPrivacyFeatureEnabled;
    }

    public final boolean isPushTokenRegistered() {
        return this.isPushTokenRegistered;
    }

    public final boolean isUserOptedIn() {
        return this.isUserOptedIn;
    }

    public final boolean isOptedIn() {
        return this.isOptedIn;
    }

    @Nullable
    public final String getNotificationPermissionStatus() {
        return this.notificationPermissionStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NotificationStatus(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r31) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 2712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.NotificationStatus.<init>(com.urbanairship.json.JsonValue):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NotificationStatus(@NotNull PushNotificationStatus status, @Nullable String str) {
        this(status.getIsUserNotificationsEnabled(), status.getIsPushPermissionGranted(), status.getIsPushPrivacyFeatureEnabled(), status.getIsPushTokenRegistered(), status.isUserOptedIn(), status.isOptIn(), str);
        Intrinsics.checkNotNullParameter(status, "status");
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("isUserNotificationsEnabled", Boolean.valueOf(this.isUserNotificationsEnabled)), TuplesKt.to("areNotificationsAllowed", Boolean.valueOf(this.areNotificationsAllowed)), TuplesKt.to("isPushPrivacyFeatureEnabled", Boolean.valueOf(this.isPushPrivacyFeatureEnabled)), TuplesKt.to("isPushTokenRegistered", Boolean.valueOf(this.isPushTokenRegistered)), TuplesKt.to("isUserOptedIn", Boolean.valueOf(this.isUserOptedIn)), TuplesKt.to("isOptedIn", Boolean.valueOf(this.isOptedIn)), TuplesKt.to("notificationPermissionStatus", this.notificationPermissionStatus)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
