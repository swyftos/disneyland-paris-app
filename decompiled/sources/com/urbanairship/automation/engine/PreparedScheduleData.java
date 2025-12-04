package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.PreparedInAppMessageData;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedScheduleData;", "", "()V", JsonDocumentFields.ACTION, "InAppMessage", "Lcom/urbanairship/automation/engine/PreparedScheduleData$Action;", "Lcom/urbanairship/automation/engine/PreparedScheduleData$InAppMessage;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class PreparedScheduleData {
    public /* synthetic */ PreparedScheduleData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PreparedScheduleData() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedScheduleData$InAppMessage;", "Lcom/urbanairship/automation/engine/PreparedScheduleData;", "message", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "(Lcom/urbanairship/iam/PreparedInAppMessageData;)V", "getMessage", "()Lcom/urbanairship/iam/PreparedInAppMessageData;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InAppMessage extends PreparedScheduleData {
        private final PreparedInAppMessageData message;

        public static /* synthetic */ InAppMessage copy$default(InAppMessage inAppMessage, PreparedInAppMessageData preparedInAppMessageData, int i, Object obj) {
            if ((i & 1) != 0) {
                preparedInAppMessageData = inAppMessage.message;
            }
            return inAppMessage.copy(preparedInAppMessageData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PreparedInAppMessageData getMessage() {
            return this.message;
        }

        @NotNull
        public final InAppMessage copy(@NotNull PreparedInAppMessageData message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new InAppMessage(message);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InAppMessage) && Intrinsics.areEqual(this.message, ((InAppMessage) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            return "InAppMessage(message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InAppMessage(@NotNull PreparedInAppMessageData message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final PreparedInAppMessageData getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedScheduleData$Action;", "Lcom/urbanairship/automation/engine/PreparedScheduleData;", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "getJson", "()Lcom/urbanairship/json/JsonValue;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Action extends PreparedScheduleData {
        private final JsonValue json;

        public static /* synthetic */ Action copy$default(Action action, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonValue = action.json;
            }
            return action.copy(jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final JsonValue getJson() {
            return this.json;
        }

        @NotNull
        public final Action copy(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new Action(json);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Action) && Intrinsics.areEqual(this.json, ((Action) other).json);
        }

        public int hashCode() {
            return this.json.hashCode();
        }

        @NotNull
        public String toString() {
            return "Action(json=" + this.json + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(@NotNull JsonValue json) {
            super(null);
            Intrinsics.checkNotNullParameter(json, "json");
            this.json = json;
        }

        @NotNull
        public final JsonValue getJson() {
            return this.json;
        }
    }
}
