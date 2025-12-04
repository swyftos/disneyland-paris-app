package com.urbanairship.iam.legacy;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.push.PushManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate;", "", "()V", "Companion", "DirectOpen", "NewMessage", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate$DirectOpen;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate$NewMessage;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class LegacyInAppMessageUpdate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ LegacyInAppMessageUpdate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate$NewMessage;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate;", "message", "Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "(Lcom/urbanairship/iam/legacy/LegacyInAppMessage;)V", "getMessage", "()Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NewMessage extends LegacyInAppMessageUpdate {
        private final LegacyInAppMessage message;

        public static /* synthetic */ NewMessage copy$default(NewMessage newMessage, LegacyInAppMessage legacyInAppMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                legacyInAppMessage = newMessage.message;
            }
            return newMessage.copy(legacyInAppMessage);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final LegacyInAppMessage getMessage() {
            return this.message;
        }

        @NotNull
        public final NewMessage copy(@NotNull LegacyInAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NewMessage(message);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NewMessage) && Intrinsics.areEqual(this.message, ((NewMessage) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            return "NewMessage(message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewMessage(@NotNull LegacyInAppMessage message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final LegacyInAppMessage getMessage() {
            return this.message;
        }
    }

    private LegacyInAppMessageUpdate() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate$DirectOpen;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate;", "sendId", "", "(Ljava/lang/String;)V", "getSendId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DirectOpen extends LegacyInAppMessageUpdate {
        private final String sendId;

        public static /* synthetic */ DirectOpen copy$default(DirectOpen directOpen, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = directOpen.sendId;
            }
            return directOpen.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getSendId() {
            return this.sendId;
        }

        @NotNull
        public final DirectOpen copy(@NotNull String sendId) {
            Intrinsics.checkNotNullParameter(sendId, "sendId");
            return new DirectOpen(sendId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DirectOpen) && Intrinsics.areEqual(this.sendId, ((DirectOpen) other).sendId);
        }

        public int hashCode() {
            return this.sendId.hashCode();
        }

        @NotNull
        public String toString() {
            return "DirectOpen(sendId=" + this.sendId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectOpen(@NotNull String sendId) {
            super(null);
            Intrinsics.checkNotNullParameter(sendId, "sendId");
            this.sendId = sendId;
        }

        @NotNull
        public final String getSendId() {
            return this.sendId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate$Companion;", "", "()V", "updates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate;", "pushManager", "Lcom/urbanairship/push/PushManager;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Flow<LegacyInAppMessageUpdate> updates(@NotNull PushManager pushManager) {
            Intrinsics.checkNotNullParameter(pushManager, "pushManager");
            return FlowKt.callbackFlow(new LegacyInAppMessageUpdate$Companion$updates$1(pushManager, null));
        }
    }
}
