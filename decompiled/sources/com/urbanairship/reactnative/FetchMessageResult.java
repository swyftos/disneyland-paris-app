package com.urbanairship.reactnative;

import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/reactnative/FetchMessageResult;", "", "<init>", "()V", "Success", "Error", "Lcom/urbanairship/reactnative/FetchMessageResult$Error;", "Lcom/urbanairship/reactnative/FetchMessageResult$Success;", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FetchMessageResult {
    public /* synthetic */ FetchMessageResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/reactnative/FetchMessageResult$Success;", "Lcom/urbanairship/reactnative/FetchMessageResult;", "message", "Lcom/urbanairship/messagecenter/Message;", "<init>", "(Lcom/urbanairship/messagecenter/Message;)V", "getMessage", "()Lcom/urbanairship/messagecenter/Message;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success extends FetchMessageResult {
        private final Message message;

        public static /* synthetic */ Success copy$default(Success success, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = success.message;
            }
            return success.copy(message);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        @NotNull
        public final Success copy(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Success(message);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.message, ((Success) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            return "Success(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(@NotNull Message message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final Message getMessage() {
            return this.message;
        }
    }

    private FetchMessageResult() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/reactnative/FetchMessageResult$Error;", "Lcom/urbanairship/reactnative/FetchMessageResult;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "isRetryable", "", "<init>", "(Ljava/lang/String;Z)V", "getError", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Error extends FetchMessageResult {
        private final String error;
        private final boolean isRetryable;

        public static /* synthetic */ Error copy$default(Error error, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.error;
            }
            if ((i & 2) != 0) {
                z = error.isRetryable;
            }
            return error.copy(str, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsRetryable() {
            return this.isRetryable;
        }

        @NotNull
        public final Error copy(@NotNull String error, boolean isRetryable) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error, isRetryable);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.error, error.error) && this.isRetryable == error.isRetryable;
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + Boolean.hashCode(this.isRetryable);
        }

        @NotNull
        public String toString() {
            return "Error(error=" + this.error + ", isRetryable=" + this.isRetryable + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String error, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
            this.isRetryable = z;
        }

        @NotNull
        public final String getError() {
            return this.error;
        }

        public final boolean isRetryable() {
            return this.isRetryable;
        }
    }
}
