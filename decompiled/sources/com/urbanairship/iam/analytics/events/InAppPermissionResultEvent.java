package com.urbanairship.iam.analytics.events;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.EventType;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppPermissionResultEvent;", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "permission", "Lcom/urbanairship/permission/Permission;", "startingStatus", "Lcom/urbanairship/permission/PermissionStatus;", "endingStatus", "(Lcom/urbanairship/permission/Permission;Lcom/urbanairship/permission/PermissionStatus;Lcom/urbanairship/permission/PermissionStatus;)V", "data", "Lcom/urbanairship/json/JsonSerializable;", "getData", "()Lcom/urbanairship/json/JsonSerializable;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "reportData", "Lcom/urbanairship/iam/analytics/events/InAppPermissionResultEvent$PermissionResultData;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "PermissionResultData", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppPermissionResultEvent implements InAppEvent {
    private final JsonSerializable data;
    private final EventType eventType;
    private final PermissionResultData reportData;

    public InAppPermissionResultEvent(@NotNull Permission permission, @NotNull PermissionStatus startingStatus, @NotNull PermissionStatus endingStatus) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(startingStatus, "startingStatus");
        Intrinsics.checkNotNullParameter(endingStatus, "endingStatus");
        String value = permission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        String value2 = startingStatus.getValue();
        Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
        String value3 = endingStatus.getValue();
        Intrinsics.checkNotNullExpressionValue(value3, "getValue(...)");
        PermissionResultData permissionResultData = new PermissionResultData(value, value2, value3);
        this.reportData = permissionResultData;
        this.eventType = EventType.IN_APP_PERMISSION_RESULT;
        this.data = permissionResultData;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public EventType getEventType() {
        return this.eventType;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public JsonSerializable getData() {
        return this.data;
    }

    private static final class PermissionResultData implements JsonSerializable {
        public static final Companion Companion = new Companion(null);
        private final String endingStatus;
        private final String permission;
        private final String startingStatus;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionResultData)) {
                return false;
            }
            PermissionResultData permissionResultData = (PermissionResultData) obj;
            return Intrinsics.areEqual(this.permission, permissionResultData.permission) && Intrinsics.areEqual(this.startingStatus, permissionResultData.startingStatus) && Intrinsics.areEqual(this.endingStatus, permissionResultData.endingStatus);
        }

        public int hashCode() {
            return (((this.permission.hashCode() * 31) + this.startingStatus.hashCode()) * 31) + this.endingStatus.hashCode();
        }

        public String toString() {
            return "PermissionResultData(permission=" + this.permission + ", startingStatus=" + this.startingStatus + ", endingStatus=" + this.endingStatus + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PermissionResultData(String permission, String startingStatus, String endingStatus) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            Intrinsics.checkNotNullParameter(startingStatus, "startingStatus");
            Intrinsics.checkNotNullParameter(endingStatus, "endingStatus");
            this.permission = permission;
            this.startingStatus = startingStatus;
            this.endingStatus = endingStatus;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppPermissionResultEvent$PermissionResultData$Companion;", "", "()V", "ENDING_STATUS", "", "PERMISSION", "STARTING_STATUS", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("permission", this.permission), TuplesKt.to("starting_permission_status", this.startingStatus), TuplesKt.to("ending_permission_status", this.endingStatus)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(InAppPermissionResultEvent.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.analytics.events.InAppPermissionResultEvent");
        InAppPermissionResultEvent inAppPermissionResultEvent = (InAppPermissionResultEvent) other;
        return Intrinsics.areEqual(this.reportData, inAppPermissionResultEvent.reportData) && getEventType() == inAppPermissionResultEvent.getEventType() && Intrinsics.areEqual(getData(), inAppPermissionResultEvent.getData());
    }

    public int hashCode() {
        return ObjectsCompat.hash(getEventType(), getData());
    }
}
