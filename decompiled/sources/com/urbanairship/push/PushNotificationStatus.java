package com.urbanairship.push;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/push/PushNotificationStatus;", "", "isUserNotificationsEnabled", "", "areNotificationsAllowed", "isPushPrivacyFeatureEnabled", "isPushTokenRegistered", "(ZZZZ)V", "getAreNotificationsAllowed", "()Z", "isOptIn", "isUserOptedIn", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushNotificationStatus {

    /* renamed from: areNotificationsAllowed, reason: from kotlin metadata and from toString */
    private final boolean isPushPermissionGranted;
    private final boolean isPushPrivacyFeatureEnabled;
    private final boolean isPushTokenRegistered;
    private final boolean isUserNotificationsEnabled;

    public PushNotificationStatus(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isUserNotificationsEnabled = z;
        this.isPushPermissionGranted = z2;
        this.isPushPrivacyFeatureEnabled = z3;
        this.isPushTokenRegistered = z4;
    }

    /* renamed from: isUserNotificationsEnabled, reason: from getter */
    public final boolean getIsUserNotificationsEnabled() {
        return this.isUserNotificationsEnabled;
    }

    /* renamed from: getAreNotificationsAllowed, reason: from getter */
    public final boolean getIsPushPermissionGranted() {
        return this.isPushPermissionGranted;
    }

    /* renamed from: isPushPrivacyFeatureEnabled, reason: from getter */
    public final boolean getIsPushPrivacyFeatureEnabled() {
        return this.isPushPrivacyFeatureEnabled;
    }

    /* renamed from: isPushTokenRegistered, reason: from getter */
    public final boolean getIsPushTokenRegistered() {
        return this.isPushTokenRegistered;
    }

    public final boolean isUserOptedIn() {
        return this.isUserNotificationsEnabled && this.isPushPermissionGranted && this.isPushPrivacyFeatureEnabled;
    }

    public final boolean isOptIn() {
        return isUserOptedIn() && this.isPushTokenRegistered;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(this.isUserNotificationsEnabled), Boolean.valueOf(this.isPushPermissionGranted), Boolean.valueOf(this.isPushPrivacyFeatureEnabled), Boolean.valueOf(this.isPushTokenRegistered));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(PushNotificationStatus.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.push.PushNotificationStatus");
        PushNotificationStatus pushNotificationStatus = (PushNotificationStatus) other;
        return this.isUserNotificationsEnabled == pushNotificationStatus.isUserNotificationsEnabled && this.isPushPermissionGranted == pushNotificationStatus.isPushPermissionGranted && this.isPushPrivacyFeatureEnabled == pushNotificationStatus.isPushPrivacyFeatureEnabled && this.isPushTokenRegistered == pushNotificationStatus.isPushTokenRegistered;
    }

    @NotNull
    public String toString() {
        return "PushNotificationStatus(isUserNotificationsEnabled=" + this.isUserNotificationsEnabled + ", isPushPermissionGranted=" + this.isPushPermissionGranted + ", isPushPrivacyFeatureEnabled=" + this.isPushPrivacyFeatureEnabled + ", isPushTokenRegistered=" + this.isPushTokenRegistered + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
