package com.urbanairship.messagecenter.ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.firebase.messaging.Constants;
import com.urbanairship.Predicate;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.view.MessageListAction;
import com.urbanairship.messagecenter.ui.view.MessageListState;
import com.urbanairship.messagecenter.ui.view.MessageListView;
import com.urbanairship.messagecenter.ui.view.MessageListViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002:;B\u0011\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0010\u0010.\u001a\u00020+2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u001a\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0017J\u0016\u00104\u001a\u00020+2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020+06J\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209R&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR4\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageListFragment;", "Landroidx/fragment/app/Fragment;", "contentLayoutId", "", "(I)V", "value", "", "isEditing", "()Z", "setEditing", "(Z)V", "messageListView", "Lcom/urbanairship/messagecenter/ui/view/MessageListView;", "getMessageListView", "()Lcom/urbanairship/messagecenter/ui/view/MessageListView;", "setMessageListView", "(Lcom/urbanairship/messagecenter/ui/view/MessageListView;)V", "onEditListener", "Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnEditListener;", "getOnEditListener", "()Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnEditListener;", "setOnEditListener", "(Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnEditListener;)V", "onMessageClickListener", "Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnMessageClickListener;", "getOnMessageClickListener", "()Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnMessageClickListener;", "setOnMessageClickListener", "(Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnMessageClickListener;)V", "Lcom/urbanairship/Predicate;", "Lcom/urbanairship/messagecenter/Message;", "predicate", "getPredicate", "()Lcom/urbanairship/Predicate;", "setPredicate", "(Lcom/urbanairship/Predicate;)V", "viewModel", "Lcom/urbanairship/messagecenter/ui/view/MessageListViewModel;", "getViewModel", "()Lcom/urbanairship/messagecenter/ui/view/MessageListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clearHighlighted", "", "deleteAllMessages", "markAllMessagesRead", "onEditModeChanged", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refresh", "onRefreshed", "Lkotlin/Function0;", "setHighlighted", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "OnEditListener", "OnMessageClickListener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListFragment.kt\ncom/urbanairship/messagecenter/ui/MessageListFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n106#2,15:170\n766#3:185\n857#3,2:186\n*S KotlinDebug\n*F\n+ 1 MessageListFragment.kt\ncom/urbanairship/messagecenter/ui/MessageListFragment\n*L\n31#1:170,15\n152#1:185\n152#1:186,2\n*E\n"})
/* loaded from: classes5.dex */
public class MessageListFragment extends Fragment {
    private boolean isEditing;
    private MessageListView messageListView;
    private OnEditListener onEditListener;
    private OnMessageClickListener onMessageClickListener;
    private Predicate predicate;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnEditListener;", "", "onDeleteMessages", "", "count", "", "onEditModeChanged", "isEditing", "", "onMarkMessagesRead", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnEditListener {
        void onDeleteMessages(int count);

        void onEditModeChanged(boolean isEditing);

        void onMarkMessagesRead(int count);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageListFragment$OnMessageClickListener;", "", "onMessageClick", "", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnMessageClickListener {
        void onMessageClick(@NotNull Message message);
    }

    @JvmOverloads
    public MessageListFragment() {
        this(0, 1, null);
    }

    protected void onEditModeChanged(boolean isEditing) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public /* synthetic */ MessageListFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.ua_fragment_message_list : i);
    }

    @JvmOverloads
    public MessageListFragment(@LayoutRes int i) {
        super(i);
        Function0 function0 = new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return MessageListViewModel.Companion.factory$default(MessageListViewModel.INSTANCE, null, 1, null);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MessageListViewModel.class), new Function0<ViewModelStore>() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m250viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM250viewModels$lambda1 = FragmentViewModelLazyKt.m250viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM250viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM250viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0 == null ? new Function0<ViewModelProvider.Factory>() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM250viewModels$lambda1 = FragmentViewModelLazyKt.m250viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM250viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM250viewModels$lambda1 : null;
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? this.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        } : function0);
    }

    @NotNull
    protected final MessageListViewModel getViewModel() {
        return (MessageListViewModel) this.viewModel.getValue();
    }

    public final void setEditing(boolean z) {
        this.isEditing = z;
        MessageListView messageListView = this.messageListView;
        if (messageListView == null) {
            return;
        }
        messageListView.setEditing(z);
    }

    public final boolean isEditing() {
        MessageListView messageListView = this.messageListView;
        return messageListView != null ? messageListView.isEditing() : this.isEditing;
    }

    @Nullable
    public final Predicate<Message> getPredicate() {
        return this.predicate;
    }

    public final void setPredicate(@Nullable Predicate<Message> predicate) {
        this.predicate = predicate;
        getViewModel().setPredicate(predicate);
    }

    @Nullable
    public final OnMessageClickListener getOnMessageClickListener() {
        return this.onMessageClickListener;
    }

    public final void setOnMessageClickListener(@Nullable OnMessageClickListener onMessageClickListener) {
        this.onMessageClickListener = onMessageClickListener;
    }

    @Nullable
    public final OnEditListener getOnEditListener() {
        return this.onEditListener;
    }

    public final void setOnEditListener(@Nullable OnEditListener onEditListener) {
        this.onEditListener = onEditListener;
    }

    @Nullable
    protected final MessageListView getMessageListView() {
        return this.messageListView;
    }

    protected final void setMessageListView(@Nullable MessageListView messageListView) {
        this.messageListView = messageListView;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        try {
            View viewFindViewById = view.findViewById(android.R.id.list);
            Intrinsics.checkNotNull(viewFindViewById);
            MessageListView messageListView = (MessageListView) viewFindViewById;
            this.messageListView = messageListView;
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(messageListView, null), 3, null);
            messageListView.setListener(new MessageListView.Listener() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment.onViewCreated.2
                @Override // com.urbanairship.messagecenter.ui.view.MessageListView.Listener
                public void onEditModeChanged(boolean isEditing) {
                    Unit unit;
                    MessageListFragment.this.onEditModeChanged(isEditing);
                    OnEditListener onEditListener = MessageListFragment.this.getOnEditListener();
                    if (onEditListener != null) {
                        onEditListener.onEditModeChanged(isEditing);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        MessageListFragmentKt.logNullListenerWarning("OnEditModeChangedListener", "onEditModeChangedListener");
                    }
                }

                @Override // com.urbanairship.messagecenter.ui.view.MessageListView.Listener
                public void onShowMessage(@NotNull Message message) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(message, "message");
                    OnMessageClickListener onMessageClickListener = MessageListFragment.this.getOnMessageClickListener();
                    if (onMessageClickListener != null) {
                        onMessageClickListener.onMessageClick(message);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        MessageListFragmentKt.logNullListenerWarning("OnMessageSelectedListener", "onMessageClickListener");
                    }
                }

                @Override // com.urbanairship.messagecenter.ui.view.MessageListView.Listener
                public void onAction(@NotNull final MessageListAction action) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (action instanceof MessageListAction.DeleteMessages) {
                        OnEditListener onEditListener = MessageListFragment.this.getOnEditListener();
                        if (onEditListener != null) {
                            onEditListener.onDeleteMessages(((MessageListAction.DeleteMessages) action).getMessages().size());
                        }
                        MessageListFragment.this.getViewModel().deleteMessages(((MessageListAction.DeleteMessages) action).getMessages());
                        return;
                    }
                    if (action instanceof MessageListAction.MarkMessagesRead) {
                        OnEditListener onEditListener2 = MessageListFragment.this.getOnEditListener();
                        if (onEditListener2 != null) {
                            onEditListener2.onMarkMessagesRead(((MessageListAction.MarkMessagesRead) action).getMessages().size());
                        }
                        MessageListFragment.this.getViewModel().markMessagesRead(((MessageListAction.MarkMessagesRead) action).getMessages());
                        return;
                    }
                    if (!(action instanceof MessageListAction.Refresh)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MessageListFragment.this.getViewModel().refreshInbox(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment$onViewCreated$2$onAction$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2915invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2915invoke() {
                            ((MessageListAction.Refresh) action).getOnRefreshed().invoke();
                        }
                    });
                }
            });
        } catch (Exception e) {
            throw new IllegalStateException("MessageListFragment layout must include a MessageListView with id: android.R.id.list", e);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.MessageListFragment$onViewCreated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ MessageListView $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MessageListView messageListView, Continuation continuation) {
            super(2, continuation);
            this.$list = messageListView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageListFragment.this.new AnonymousClass1(this.$list, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.messagecenter.ui.MessageListFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01501 extends SuspendLambda implements Function2 {
            final /* synthetic */ MessageListView $list;
            int label;
            final /* synthetic */ MessageListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01501(MessageListFragment messageListFragment, MessageListView messageListView, Continuation continuation) {
                super(2, continuation);
                this.this$0 = messageListFragment;
                this.$list = messageListView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C01501(this.this$0, this.$list, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C01501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<MessageListState> states = this.this$0.getViewModel().getStates();
                    final MessageListView messageListView = this.$list;
                    FlowCollector<? super MessageListState> flowCollector = new FlowCollector() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment.onViewCreated.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(MessageListState messageListState, Continuation continuation) {
                            messageListView.render(messageListState);
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (states.collect(flowCollector, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = MessageListFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                C01501 c01501 = new C01501(MessageListFragment.this, this.$list, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, c01501, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setHighlighted(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        getViewModel().setHighlighted(messageId);
    }

    public final void clearHighlighted() {
        getViewModel().setHighlighted((String) null);
    }

    public final void deleteAllMessages() {
        MessageListState value = getViewModel().getStates().getValue();
        MessageListState.Content content = value instanceof MessageListState.Content ? (MessageListState.Content) value : null;
        if (content != null) {
            getViewModel().deleteMessages(content.getMessages());
            OnEditListener onEditListener = this.onEditListener;
            if (onEditListener != null) {
                onEditListener.onDeleteMessages(content.getMessages().size());
            }
        }
    }

    public final void markAllMessagesRead() {
        MessageListState value = getViewModel().getStates().getValue();
        MessageListState.Content content = value instanceof MessageListState.Content ? (MessageListState.Content) value : null;
        if (content != null) {
            List<Message> messages = content.getMessages();
            ArrayList arrayList = new ArrayList();
            for (Object obj : messages) {
                if (!((Message) obj).getIsRead()) {
                    arrayList.add(obj);
                }
            }
            getViewModel().markMessagesRead(arrayList);
            OnEditListener onEditListener = this.onEditListener;
            if (onEditListener != null) {
                onEditListener.onMarkMessagesRead(arrayList.size());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(MessageListFragment messageListFragment, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
        }
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageListFragment.refresh.1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2916invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2916invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        messageListFragment.refresh(function0);
    }

    public final void refresh(@NotNull Function0<Unit> onRefreshed) {
        Intrinsics.checkNotNullParameter(onRefreshed, "onRefreshed");
        getViewModel().refreshInbox(onRefreshed);
    }
}
