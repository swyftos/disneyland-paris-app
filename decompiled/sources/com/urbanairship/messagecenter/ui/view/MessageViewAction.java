package com.urbanairship.messagecenter.ui.view;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageViewAction;", "", "()V", "ErrorRetryClicked", "Lcom/urbanairship/messagecenter/ui/view/MessageViewAction$ErrorRetryClicked;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MessageViewAction {
    public /* synthetic */ MessageViewAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MessageViewAction() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageViewAction$ErrorRetryClicked;", "Lcom/urbanairship/messagecenter/ui/view/MessageViewAction;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ErrorRetryClicked extends MessageViewAction {

        @NotNull
        public static final ErrorRetryClicked INSTANCE = new ErrorRetryClicked();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof ErrorRetryClicked);
        }

        public int hashCode() {
            return -615017203;
        }

        @NotNull
        public String toString() {
            return "ErrorRetryClicked";
        }

        private ErrorRetryClicked() {
            super(null);
        }
    }
}
