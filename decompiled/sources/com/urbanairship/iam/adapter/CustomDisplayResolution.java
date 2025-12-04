package com.urbanairship.iam.adapter;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "", "()V", "ButtonTap", "MessageTap", "TimedOut", "UserDismissed", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution$ButtonTap;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution$MessageTap;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution$TimedOut;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution$UserDismissed;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CustomDisplayResolution {
    public /* synthetic */ CustomDisplayResolution(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomDisplayResolution() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayResolution$ButtonTap;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "(Lcom/urbanairship/iam/info/InAppMessageButtonInfo;)V", "getInfo", "()Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ButtonTap extends CustomDisplayResolution {
        private final InAppMessageButtonInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ButtonTap(@NotNull InAppMessageButtonInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        public final InAppMessageButtonInfo getInfo() {
            return this.info;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(ButtonTap.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.adapter.CustomDisplayResolution.ButtonTap");
            return Intrinsics.areEqual(this.info, ((ButtonTap) other).info);
        }

        public int hashCode() {
            return this.info.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayResolution$MessageTap;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MessageTap extends CustomDisplayResolution {

        @NotNull
        public static final MessageTap INSTANCE = new MessageTap();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof MessageTap);
        }

        public int hashCode() {
            return -914941486;
        }

        @NotNull
        public String toString() {
            return "MessageTap";
        }

        private MessageTap() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayResolution$UserDismissed;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UserDismissed extends CustomDisplayResolution {

        @NotNull
        public static final UserDismissed INSTANCE = new UserDismissed();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof UserDismissed);
        }

        public int hashCode() {
            return -1784691288;
        }

        @NotNull
        public String toString() {
            return "UserDismissed";
        }

        private UserDismissed() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayResolution$TimedOut;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TimedOut extends CustomDisplayResolution {

        @NotNull
        public static final TimedOut INSTANCE = new TimedOut();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof TimedOut);
        }

        public int hashCode() {
            return -1647056435;
        }

        @NotNull
        public String toString() {
            return "TimedOut";
        }

        private TimedOut() {
            super(null);
        }
    }
}
