package com.urbanairship.messagecenter.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.animator.AnimatorExtensionsKt;
import com.urbanairship.messagecenter.ui.view.MessageListAction;
import com.urbanairship.messagecenter.ui.view.MessageListState;
import com.urbanairship.messagecenter.ui.view.MessageListView;
import com.urbanairship.messagecenter.ui.widget.EditableRecyclerView;
import com.urbanairship.messagecenter.ui.widget.MessageRecyclerAdapter;
import com.urbanairship.messagecenter.ui.widget.MessageRecyclerView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002()B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010!H\u0007J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "isEditing", "()Z", "setEditing", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/view/MessageListView$Listener;", "getListener", "()Lcom/urbanairship/messagecenter/ui/view/MessageListView$Listener;", "setListener", "(Lcom/urbanairship/messagecenter/ui/view/MessageListView$Listener;)V", "views", "Lcom/urbanairship/messagecenter/ui/view/MessageListView$Views;", "getViews", "()Lcom/urbanairship/messagecenter/ui/view/MessageListView$Views;", "views$delegate", "Lkotlin/Lazy;", "clearHighlightedMessage", "", "refresh", "animateSwipeRefresh", "onRefreshed", "Lkotlin/Function0;", "render", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "setHighlightedMessage", "message", "Lcom/urbanairship/messagecenter/Message;", "Listener", "Views", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageListView extends FrameLayout {
    private Listener listener;

    /* renamed from: views$delegate, reason: from kotlin metadata */
    private final Lazy views;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListView$Listener;", "", "onAction", "", "action", "Lcom/urbanairship/messagecenter/ui/view/MessageListAction;", "onEditModeChanged", "isEditing", "", "onShowMessage", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onAction(@NotNull MessageListAction action);

        void onEditModeChanged(boolean isEditing);

        void onShowMessage(@NotNull Message message);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmOverloads
    public final void refresh() {
        refresh$default(this, false, null, 3, null);
    }

    @JvmOverloads
    public final void refresh(boolean z) {
        refresh$default(this, z, null, 2, null);
    }

    public /* synthetic */ MessageListView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.views = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$views$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MessageListView.Views invoke() {
                return new MessageListView.Views(this.this$0, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
            }
        });
        View.inflate(context, R.layout.ua_view_message_list, this);
        final Views views = getViews();
        InstrumentationCallbacks.setOnClickListenerCalled(views.getErrorRetryButton(), new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageListView.lambda$5$lambda$0(this.f$0, view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(views.getListEditSelectAll(), new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageListView.lambda$5$lambda$1(views, view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(views.getListEditDelete(), new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageListView.lambda$5$lambda$2(this.f$0, views, view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(views.getListEditMarkRead(), new View.OnClickListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageListView.lambda$5$lambda$3(this.f$0, views, view);
            }
        });
        views.getList().setListener(new EditableRecyclerView.Listener<Message, MessageRecyclerAdapter.AccessibilityAction>() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$1$5

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MessageRecyclerAdapter.AccessibilityAction.values().length];
                    try {
                        iArr[MessageRecyclerAdapter.AccessibilityAction.MARK_READ.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MessageRecyclerAdapter.AccessibilityAction.DELETE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableRecyclerView.Listener
            public void onEditModeChanged(boolean isEditing) {
                MessageListView.Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onEditModeChanged(isEditing);
                }
                this.this$0.getViews().updateEditing(isEditing);
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableRecyclerView.Listener
            public void onItemClicked(@NotNull Message item) {
                Unit unit;
                Intrinsics.checkNotNullParameter(item, "item");
                MessageListView.Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onShowMessage(item);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UALog.e$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$1$5$onItemClicked$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "No listener set for onShowMessage!";
                        }
                    }, 1, null);
                }
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableRecyclerView.Listener
            public void onSelectionChanged(@NotNull List<? extends Message> selectedItems, boolean isAllSelected) {
                Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
                views.updateSelectionCount(selectedItems.size(), isAllSelected);
            }

            @Override // com.urbanairship.messagecenter.ui.widget.EditableRecyclerView.Listener
            public void onAction(@NotNull MessageRecyclerAdapter.AccessibilityAction action, @NotNull Message item) {
                MessageListAction markMessagesRead;
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(item, "item");
                int i3 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
                if (i3 == 1) {
                    markMessagesRead = new MessageListAction.MarkMessagesRead(CollectionsKt.listOf(item));
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    markMessagesRead = new MessageListAction.DeleteMessages(CollectionsKt.listOf(item));
                }
                MessageListView.Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onAction(markMessagesRead);
                }
            }
        });
        views.getListRefresh().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$$ExternalSyntheticLambda4
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                MessageListView.lambda$5$lambda$4(this.f$0, views);
            }
        });
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    public final void setEditing(boolean z) {
        getViews().setEditing(z);
    }

    public final boolean isEditing() {
        return getViews().getList().getIsEditing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Views getViews() {
        return (Views) this.views.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$5$lambda$0(MessageListView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Listener listener = this$0.listener;
        if (listener != null) {
            listener.onAction(new MessageListAction.Refresh(null, 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$5$lambda$1(Views this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (this_with.getList().isAllSelected()) {
            this_with.getList().clearSelected();
        } else {
            this_with.getList().selectAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$5$lambda$2(MessageListView this$0, Views this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Listener listener = this$0.listener;
        if (listener != null) {
            listener.onAction(new MessageListAction.DeleteMessages(this_with.getList().getSelectedItems()));
        }
        this$0.setEditing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$5$lambda$3(MessageListView this$0, Views this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Listener listener = this$0.listener;
        if (listener != null) {
            listener.onAction(new MessageListAction.MarkMessagesRead(this_with.getList().getSelectedItems()));
        }
        this$0.setEditing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$5$lambda$4(MessageListView this$0, final Views this_with) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        refresh$default(this$0, false, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView$1$6$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2919invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2919invoke() {
                this_with.getListRefresh().setRefreshing(false);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(MessageListView messageListView, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        messageListView.refresh(z, function0);
    }

    @JvmOverloads
    public final void refresh(final boolean animateSwipeRefresh, @Nullable final Function0<Unit> onRefreshed) {
        if (animateSwipeRefresh) {
            getViews().getListRefresh().setRefreshing(true);
        }
        Listener listener = this.listener;
        if (listener != null) {
            listener.onAction(new MessageListAction.Refresh(new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListView.refresh.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2920invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2920invoke() {
                    if (animateSwipeRefresh) {
                        this.getViews().getListRefresh().setRefreshing(false);
                    }
                    Function0 function0 = onRefreshed;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            }));
        }
    }

    public final void setHighlightedMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        getViews().getList().setHighlightedMessageId(message.getId());
    }

    public final void clearHighlightedMessage() {
        getViews().getList().setHighlightedMessageId(null);
    }

    public final void render(@NotNull MessageListState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MessageListState.Loading) {
            getViews().showLoading();
            return;
        }
        if (state instanceof MessageListState.Error) {
            getViews().showError();
            return;
        }
        if (state instanceof MessageListState.Content) {
            MessageListState.Content content = (MessageListState.Content) state;
            getViews().getList().submitList(content.getMessages());
            getViews().getListRefresh().setRefreshing(content.isRefreshing());
            getViews().getList().setHighlightedMessageId(content.getHighlightedMessageId());
            getViews().showContent(content.getMessages().isEmpty());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Views {
        private final Context context;
        private final View empty;
        private final ViewGroup error;
        private final TextView errorMessage;
        private final Button errorRetryButton;
        private final MessageRecyclerView list;
        private final ViewGroup listContainer;
        private final Button listEditDelete;
        private final Button listEditMarkRead;
        private final Button listEditSelectAll;
        private final ViewGroup listEditingToolbar;
        private final SwipeRefreshLayout listRefresh;
        private final ViewGroup loading;
        private final View view;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Views)) {
                return false;
            }
            Views views = (Views) obj;
            return Intrinsics.areEqual(this.view, views.view) && Intrinsics.areEqual(this.listContainer, views.listContainer) && Intrinsics.areEqual(this.list, views.list) && Intrinsics.areEqual(this.listRefresh, views.listRefresh) && Intrinsics.areEqual(this.listEditingToolbar, views.listEditingToolbar) && Intrinsics.areEqual(this.listEditSelectAll, views.listEditSelectAll) && Intrinsics.areEqual(this.listEditMarkRead, views.listEditMarkRead) && Intrinsics.areEqual(this.listEditDelete, views.listEditDelete) && Intrinsics.areEqual(this.loading, views.loading) && Intrinsics.areEqual(this.error, views.error) && Intrinsics.areEqual(this.errorMessage, views.errorMessage) && Intrinsics.areEqual(this.errorRetryButton, views.errorRetryButton) && Intrinsics.areEqual(this.empty, views.empty);
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.view.hashCode() * 31) + this.listContainer.hashCode()) * 31) + this.list.hashCode()) * 31) + this.listRefresh.hashCode()) * 31) + this.listEditingToolbar.hashCode()) * 31) + this.listEditSelectAll.hashCode()) * 31) + this.listEditMarkRead.hashCode()) * 31) + this.listEditDelete.hashCode()) * 31) + this.loading.hashCode()) * 31) + this.error.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + this.errorRetryButton.hashCode()) * 31) + this.empty.hashCode();
        }

        public String toString() {
            return "Views(view=" + this.view + ", listContainer=" + this.listContainer + ", list=" + this.list + ", listRefresh=" + this.listRefresh + ", listEditingToolbar=" + this.listEditingToolbar + ", listEditSelectAll=" + this.listEditSelectAll + ", listEditMarkRead=" + this.listEditMarkRead + ", listEditDelete=" + this.listEditDelete + ", loading=" + this.loading + ", error=" + this.error + ", errorMessage=" + this.errorMessage + ", errorRetryButton=" + this.errorRetryButton + ", empty=" + this.empty + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Views(View view, ViewGroup listContainer, MessageRecyclerView list, SwipeRefreshLayout listRefresh, ViewGroup listEditingToolbar, Button listEditSelectAll, Button listEditMarkRead, Button listEditDelete, ViewGroup loading, ViewGroup error, TextView errorMessage, Button errorRetryButton, View empty) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(listContainer, "listContainer");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(listRefresh, "listRefresh");
            Intrinsics.checkNotNullParameter(listEditingToolbar, "listEditingToolbar");
            Intrinsics.checkNotNullParameter(listEditSelectAll, "listEditSelectAll");
            Intrinsics.checkNotNullParameter(listEditMarkRead, "listEditMarkRead");
            Intrinsics.checkNotNullParameter(listEditDelete, "listEditDelete");
            Intrinsics.checkNotNullParameter(loading, "loading");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(errorRetryButton, "errorRetryButton");
            Intrinsics.checkNotNullParameter(empty, "empty");
            this.view = view;
            this.listContainer = listContainer;
            this.list = list;
            this.listRefresh = listRefresh;
            this.listEditingToolbar = listEditingToolbar;
            this.listEditSelectAll = listEditSelectAll;
            this.listEditMarkRead = listEditMarkRead;
            this.listEditDelete = listEditDelete;
            this.loading = loading;
            this.error = error;
            this.errorMessage = errorMessage;
            this.errorRetryButton = errorRetryButton;
            this.empty = empty;
            this.context = view.getContext();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Views(View view, ViewGroup viewGroup, MessageRecyclerView messageRecyclerView, SwipeRefreshLayout swipeRefreshLayout, ViewGroup viewGroup2, Button button, Button button2, Button button3, ViewGroup viewGroup3, ViewGroup viewGroup4, TextView textView, Button button4, View view2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            ViewGroup viewGroup5;
            MessageRecyclerView messageRecyclerView2;
            SwipeRefreshLayout swipeRefreshLayout2;
            ViewGroup viewGroup6;
            Button button5;
            Button button6;
            Button button7;
            ViewGroup viewGroup7;
            ViewGroup viewGroup8;
            TextView textView2;
            Button button8;
            View viewFindViewById;
            if ((i & 2) != 0) {
                View viewFindViewById2 = view.findViewById(R.id.list_container);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                viewGroup5 = (ViewGroup) viewFindViewById2;
            } else {
                viewGroup5 = viewGroup;
            }
            if ((i & 4) != 0) {
                View viewFindViewById3 = view.findViewById(R.id.list);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                messageRecyclerView2 = (MessageRecyclerView) viewFindViewById3;
            } else {
                messageRecyclerView2 = messageRecyclerView;
            }
            if ((i & 8) != 0) {
                View viewFindViewById4 = view.findViewById(R.id.list_refresh);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                swipeRefreshLayout2 = (SwipeRefreshLayout) viewFindViewById4;
            } else {
                swipeRefreshLayout2 = swipeRefreshLayout;
            }
            if ((i & 16) != 0) {
                View viewFindViewById5 = view.findViewById(R.id.edit_mode_controls);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                viewGroup6 = (ViewGroup) viewFindViewById5;
            } else {
                viewGroup6 = viewGroup2;
            }
            if ((i & 32) != 0) {
                View viewFindViewById6 = viewGroup6.findViewById(R.id.select_all_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                button5 = (Button) viewFindViewById6;
            } else {
                button5 = button;
            }
            if ((i & 64) != 0) {
                View viewFindViewById7 = viewGroup6.findViewById(R.id.mark_read_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
                button6 = (Button) viewFindViewById7;
            } else {
                button6 = button2;
            }
            if ((i & 128) != 0) {
                View viewFindViewById8 = viewGroup6.findViewById(R.id.delete_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
                button7 = (Button) viewFindViewById8;
            } else {
                button7 = button3;
            }
            if ((i & 256) != 0) {
                View viewFindViewById9 = view.findViewById(R.id.loading);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
                viewGroup7 = (ViewGroup) viewFindViewById9;
            } else {
                viewGroup7 = viewGroup3;
            }
            if ((i & 512) != 0) {
                View viewFindViewById10 = view.findViewById(R.id.error);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
                viewGroup8 = (ViewGroup) viewFindViewById10;
            } else {
                viewGroup8 = viewGroup4;
            }
            if ((i & 1024) != 0) {
                View viewFindViewById11 = viewGroup8.findViewById(R.id.error_text);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
                textView2 = (TextView) viewFindViewById11;
            } else {
                textView2 = textView;
            }
            if ((i & 2048) != 0) {
                View viewFindViewById12 = viewGroup8.findViewById(R.id.error_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
                button8 = (Button) viewFindViewById12;
            } else {
                button8 = button4;
            }
            if ((i & 4096) != 0) {
                viewFindViewById = view.findViewById(R.id.list_empty);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            } else {
                viewFindViewById = view2;
            }
            this(view, viewGroup5, messageRecyclerView2, swipeRefreshLayout2, viewGroup6, button5, button6, button7, viewGroup7, viewGroup8, textView2, button8, viewFindViewById);
        }

        public final MessageRecyclerView getList() {
            return this.list;
        }

        public final SwipeRefreshLayout getListRefresh() {
            return this.listRefresh;
        }

        public final Button getListEditSelectAll() {
            return this.listEditSelectAll;
        }

        public final Button getListEditMarkRead() {
            return this.listEditMarkRead;
        }

        public final Button getListEditDelete() {
            return this.listEditDelete;
        }

        public final Button getErrorRetryButton() {
            return this.errorRetryButton;
        }

        public final void showContent(boolean z) {
            this.error.setVisibility(8);
            this.loading.setVisibility(8);
            this.empty.setVisibility(z ? 0 : 8);
            this.listContainer.setVisibility(0);
            this.listRefresh.setRefreshing(false);
        }

        public final void showError() {
            this.listContainer.setVisibility(8);
            this.loading.setVisibility(8);
            this.error.setVisibility(0);
        }

        public final void showLoading() {
            if (this.listContainer.getVisibility() == 0) {
                this.listRefresh.setRefreshing(true);
                return;
            }
            this.loading.setVisibility(0);
            this.listContainer.setVisibility(8);
            this.error.setVisibility(8);
        }

        public final void setEditing(boolean z) {
            this.list.setEditing(z);
            updateEditing(z);
        }

        public final void updateEditing(boolean z) {
            if (z) {
                AnimatorExtensionsKt.animateFadeIn$default(this.listEditingToolbar, 0L, 1, null).start();
                AnimatorExtensionsKt.getSlideInBottomAnimator(this.listEditingToolbar).start();
            } else {
                AnimatorExtensionsKt.animateFadeOut$default(this.listEditingToolbar, 0L, 1, null).start();
                AnimatorExtensionsKt.getSlideOutBottomAnimator(this.listEditingToolbar).start();
            }
        }

        public final void updateSelectionCount(int i, boolean z) {
            String string;
            Button button = this.listEditSelectAll;
            if (z) {
                string = this.context.getString(com.urbanairship.R.string.ua_select_none);
            } else {
                string = this.context.getString(com.urbanairship.R.string.ua_select_all);
            }
            button.setText(string);
            this.listEditMarkRead.setText(getItemLabelString(com.urbanairship.R.string.ua_mark_read, i));
            this.listEditDelete.setText(getItemLabelString(com.urbanairship.R.string.ua_delete, i));
        }

        private final String getItemLabelString(int i, int i2) {
            if (i2 == 0) {
                String string = this.context.getString(i);
                Intrinsics.checkNotNull(string);
                return string;
            }
            Context context = this.context;
            String string2 = context.getString(R.string.ua_edit_toolbar_item_title_with_count, context.getString(i), Integer.valueOf(i2));
            Intrinsics.checkNotNull(string2);
            return string2;
        }
    }
}
