package com.urbanairship.messagecenter.ui.view;

import ch.qos.logback.core.CoreConstants;
import com.google.common.net.HttpHeaders;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListAction;", "", "()V", "DeleteMessages", "MarkMessagesRead", HttpHeaders.REFRESH, "Lcom/urbanairship/messagecenter/ui/view/MessageListAction$DeleteMessages;", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction$MarkMessagesRead;", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction$Refresh;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MessageListAction {
    public /* synthetic */ MessageListAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MessageListAction() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListAction$MarkMessagesRead;", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction;", "messages", "", "Lcom/urbanairship/messagecenter/Message;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MarkMessagesRead extends MessageListAction {
        private final List messages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MarkMessagesRead copy$default(MarkMessagesRead markMessagesRead, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = markMessagesRead.messages;
            }
            return markMessagesRead.copy(list);
        }

        @NotNull
        public final List<Message> component1() {
            return this.messages;
        }

        @NotNull
        public final MarkMessagesRead copy(@NotNull List<Message> messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            return new MarkMessagesRead(messages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MarkMessagesRead) && Intrinsics.areEqual(this.messages, ((MarkMessagesRead) other).messages);
        }

        public int hashCode() {
            return this.messages.hashCode();
        }

        @NotNull
        public String toString() {
            return "MarkMessagesRead(messages=" + this.messages + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MarkMessagesRead(@NotNull List<Message> messages) {
            super(null);
            Intrinsics.checkNotNullParameter(messages, "messages");
            this.messages = messages;
        }

        @NotNull
        public final List<Message> getMessages() {
            return this.messages;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListAction$DeleteMessages;", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction;", "messages", "", "Lcom/urbanairship/messagecenter/Message;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DeleteMessages extends MessageListAction {
        private final List messages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteMessages copy$default(DeleteMessages deleteMessages, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = deleteMessages.messages;
            }
            return deleteMessages.copy(list);
        }

        @NotNull
        public final List<Message> component1() {
            return this.messages;
        }

        @NotNull
        public final DeleteMessages copy(@NotNull List<Message> messages) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            return new DeleteMessages(messages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeleteMessages) && Intrinsics.areEqual(this.messages, ((DeleteMessages) other).messages);
        }

        public int hashCode() {
            return this.messages.hashCode();
        }

        @NotNull
        public String toString() {
            return "DeleteMessages(messages=" + this.messages + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteMessages(@NotNull List<Message> messages) {
            super(null);
            Intrinsics.checkNotNullParameter(messages, "messages");
            this.messages = messages;
        }

        @NotNull
        public final List<Message> getMessages() {
            return this.messages;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListAction$Refresh;", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction;", "onRefreshed", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnRefreshed", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Refresh extends MessageListAction {
        private final Function0 onRefreshed;

        public Refresh() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Refresh copy$default(Refresh refresh, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = refresh.onRefreshed;
            }
            return refresh.copy(function0);
        }

        @NotNull
        public final Function0<Unit> component1() {
            return this.onRefreshed;
        }

        @NotNull
        public final Refresh copy(@NotNull Function0<Unit> onRefreshed) {
            Intrinsics.checkNotNullParameter(onRefreshed, "onRefreshed");
            return new Refresh(onRefreshed);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Refresh) && Intrinsics.areEqual(this.onRefreshed, ((Refresh) other).onRefreshed);
        }

        public int hashCode() {
            return this.onRefreshed.hashCode();
        }

        @NotNull
        public String toString() {
            return "Refresh(onRefreshed=" + this.onRefreshed + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refresh(@NotNull Function0<Unit> onRefreshed) {
            super(null);
            Intrinsics.checkNotNullParameter(onRefreshed, "onRefreshed");
            this.onRefreshed = onRefreshed;
        }

        public /* synthetic */ Refresh(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListAction.Refresh.1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2917invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2917invoke();
                    return Unit.INSTANCE;
                }
            } : function0);
        }

        @NotNull
        public final Function0<Unit> getOnRefreshed() {
            return this.onRefreshed;
        }
    }
}
