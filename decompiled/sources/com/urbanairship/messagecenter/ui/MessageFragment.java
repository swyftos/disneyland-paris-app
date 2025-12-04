package com.urbanairship.messagecenter.ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.core.os.BundleKt;
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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.ui.view.MessageView;
import com.urbanairship.messagecenter.ui.view.MessageViewModel;
import com.urbanairship.messagecenter.ui.view.MessageViewState;
import com.urbanairship.messagecenter.ui.view.SubscriptionCancellation;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0011\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0006H\u0014J\b\u00104\u001a\u00020,H\u0016J\b\u00105\u001a\u00020,H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u000208H\u0016J\u001a\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u000108H\u0017J\u0012\u0010=\u001a\u00020,2\b\u0010<\u001a\u0004\u0018\u000108H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b(\u0010)¨\u0006@"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageFragment;", "Landroidx/fragment/app/Fragment;", "contentLayoutId", "", "(I)V", "currentMessage", "Lcom/urbanairship/messagecenter/Message;", "getCurrentMessage", "()Lcom/urbanairship/messagecenter/Message;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/messagecenter/ui/MessageFragment$Listener;", "getListener", "()Lcom/urbanairship/messagecenter/ui/MessageFragment$Listener;", "setListener", "(Lcom/urbanairship/messagecenter/ui/MessageFragment$Listener;)V", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "getMessageId", "()Ljava/lang/String;", "messageId$delegate", "Lkotlin/Lazy;", "messageView", "Lcom/urbanairship/messagecenter/ui/view/MessageView;", "getMessageView", "()Lcom/urbanairship/messagecenter/ui/view/MessageView;", "setMessageView", "(Lcom/urbanairship/messagecenter/ui/view/MessageView;)V", "pendingShowEmptyView", "", "Ljava/lang/Boolean;", "refreshSubscription", "Lcom/urbanairship/messagecenter/ui/view/SubscriptionCancellation;", "value", "showEmptyView", "getShowEmptyView", "()Z", "setShowEmptyView", "(Z)V", "viewModel", "Lcom/urbanairship/messagecenter/ui/view/MessageViewModel;", "getViewModel", "()Lcom/urbanairship/messagecenter/ui/view/MessageViewModel;", "viewModel$delegate", "clearMessage", "", "deleteMessage", "message", "loadMessage", "onMessageLoadError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Error$Type;", "onMessageLoaded", "onPause", "onResume", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "onViewStateRestored", "Companion", "Listener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageFragment.kt\ncom/urbanairship/messagecenter/ui/MessageFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n106#2,15:186\n1#3:201\n*S KotlinDebug\n*F\n+ 1 MessageFragment.kt\ncom/urbanairship/messagecenter/ui/MessageFragment\n*L\n52#1:186,15\n*E\n"})
/* loaded from: classes5.dex */
public class MessageFragment extends Fragment {

    @NotNull
    public static final String ARG_MESSAGE_ID = "message_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private Listener listener;

    /* renamed from: messageId$delegate, reason: from kotlin metadata */
    private final Lazy messageId;
    private MessageView messageView;
    private Boolean pendingShowEmptyView;
    private SubscriptionCancellation refreshSubscription;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageFragment$Listener;", "", "onMessageLoadError", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Error$Type;", "onMessageLoaded", "message", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onMessageLoadError(@NotNull MessageViewState.Error.Type error);

        void onMessageLoaded(@NotNull Message message);
    }

    @JvmOverloads
    public MessageFragment() {
        this(0, 1, null);
    }

    @JvmStatic
    @NotNull
    public static final MessageFragment newInstance(@NotNull String str) {
        return INSTANCE.newInstance(str);
    }

    protected void onMessageLoadError(@NotNull MessageViewState.Error.Type error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    protected void onMessageLoaded(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
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

    public /* synthetic */ MessageFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.ua_fragment_message : i);
    }

    @JvmOverloads
    public MessageFragment(@LayoutRes int i) {
        super(i);
        this.messageId = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$messageId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("message_id");
                }
                return null;
            }
        });
        Function0 function0 = new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return MessageViewModel.INSTANCE.factory();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$special$$inlined$viewModels$default$1
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
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MessageViewModel.class), new Function0<ViewModelStore>() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m250viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$special$$inlined$viewModels$default$4
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
        }, function0 == null ? new Function0<ViewModelProvider.Factory>() { // from class: com.urbanairship.messagecenter.ui.MessageFragment$special$$inlined$viewModels$default$5
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

    @Nullable
    public final String getMessageId() {
        return (String) this.messageId.getValue();
    }

    @Nullable
    public final Message getCurrentMessage() {
        return getViewModel().getCurrentMessage();
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    @NotNull
    protected final MessageViewModel getViewModel() {
        return (MessageViewModel) this.viewModel.getValue();
    }

    @Nullable
    protected final MessageView getMessageView() {
        return this.messageView;
    }

    protected final void setMessageView(@Nullable MessageView messageView) {
        this.messageView = messageView;
    }

    public final void setShowEmptyView(boolean z) {
        MessageView messageView = this.messageView;
        Unit unit = null;
        if (messageView != null) {
            messageView.setShowEmptyView(z);
            this.pendingShowEmptyView = null;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.pendingShowEmptyView = Boolean.valueOf(z);
        }
    }

    public final boolean getShowEmptyView() {
        MessageView messageView = this.messageView;
        if (messageView != null) {
            return messageView.getShowEmptyView();
        }
        Boolean bool = this.pendingShowEmptyView;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MessageView messageView = (MessageView) view.findViewById(android.R.id.message);
        this.messageView = messageView;
        Boolean bool = this.pendingShowEmptyView;
        if (bool != null) {
            messageView.setShowEmptyView(bool.booleanValue());
            this.pendingShowEmptyView = null;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(messageView, null), 3, null);
        messageView.setListener(new MessageView.Listener() { // from class: com.urbanairship.messagecenter.ui.MessageFragment.onViewCreated.3
            @Override // com.urbanairship.messagecenter.ui.view.MessageView.Listener
            public void onMessageLoaded(@NotNull Message message) {
                Intrinsics.checkNotNullParameter(message, "message");
                MessageFragment.this.getViewModel().markMessagesRead(message);
                MessageFragment.this.onMessageLoaded(message);
                Listener listener = MessageFragment.this.getListener();
                if (listener != null) {
                    listener.onMessageLoaded(message);
                }
            }

            @Override // com.urbanairship.messagecenter.ui.view.MessageView.Listener
            public void onRetryClicked() {
                String messageId = MessageFragment.this.getMessageId();
                if (messageId != null) {
                    MessageFragment.this.getViewModel().loadMessage(messageId);
                }
            }

            @Override // com.urbanairship.messagecenter.ui.view.MessageView.Listener
            public void onMessageLoadError(@NotNull MessageViewState.Error.Type error) {
                Intrinsics.checkNotNullParameter(error, "error");
                MessageFragment.this.onMessageLoadError(error);
                Listener listener = MessageFragment.this.getListener();
                if (listener != null) {
                    listener.onMessageLoadError(error);
                }
            }
        });
        if (savedInstanceState == null) {
            String messageId = getMessageId();
            if (messageId != null) {
                getViewModel().loadMessage(messageId);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                UALog.i$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.MessageFragment.onViewCreated.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "MessageFragment started without a message ID. Call loadMessage(messageId) to load a message.";
                    }
                }, 1, null);
            }
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.MessageFragment$onViewCreated$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ MessageView $messageView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MessageView messageView, Continuation continuation) {
            super(2, continuation);
            this.$messageView = messageView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageFragment.this.new AnonymousClass2(this.$messageView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.messagecenter.ui.MessageFragment$onViewCreated$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            final /* synthetic */ MessageView $messageView;
            int label;
            final /* synthetic */ MessageFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MessageFragment messageFragment, MessageView messageView, Continuation continuation) {
                super(2, continuation);
                this.this$0 = messageFragment;
                this.$messageView = messageView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.this$0, this.$messageView, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* renamed from: com.urbanairship.messagecenter.ui.MessageFragment$onViewCreated$2$1$1, reason: invalid class name and collision with other inner class name */
            /* synthetic */ class C01491 implements FlowCollector, FunctionAdapter {
                final /* synthetic */ MessageView $tmp0;

                C01491(MessageView messageView) {
                    this.$tmp0 = messageView;
                }

                public final boolean equals(Object obj) {
                    if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                    }
                    return false;
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.$tmp0, MessageView.class, "render", "render(Lcom/urbanairship/messagecenter/ui/view/MessageViewState;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(MessageViewState messageViewState, Continuation continuation) {
                    Object objInvokeSuspend$render = AnonymousClass1.invokeSuspend$render(this.$tmp0, messageViewState, continuation);
                    return objInvokeSuspend$render == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$render : Unit.INSTANCE;
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<MessageViewState> states = this.this$0.getViewModel().getStates();
                    C01491 c01491 = new C01491(this.$messageView);
                    this.label = 1;
                    if (states.collect(c01491, this) == coroutine_suspended) {
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ Object invokeSuspend$render(MessageView messageView, MessageViewState messageViewState, Continuation continuation) {
                messageView.render(messageViewState);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = MessageFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(MessageFragment.this, this.$messageView, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, anonymousClass1, this) == coroutine_suspended) {
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        MessageView messageView = this.messageView;
        if (messageView != null) {
            messageView.resumeWebView();
        }
        this.refreshSubscription = getViewModel().subscribeForMessageUpdates$urbanairship_message_center_release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
        MessageView messageView = this.messageView;
        if (messageView != null) {
            messageView.pauseWebView();
        }
        SubscriptionCancellation subscriptionCancellation = this.refreshSubscription;
        if (subscriptionCancellation != null) {
            subscriptionCancellation.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        MessageView messageView = this.messageView;
        if (messageView != null) {
            messageView.saveWebViewState(outState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        MessageView messageView;
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null || (messageView = this.messageView) == null) {
            return;
        }
        messageView.restoreWebViewState(savedInstanceState);
    }

    public final void loadMessage(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        getViewModel().loadMessage(messageId);
    }

    public final void clearMessage() {
        getViewModel().clearMessage();
    }

    public final void deleteMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        getViewModel().deleteMessages(message);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageFragment$Companion;", "", "()V", "ARG_MESSAGE_ID", "", "newInstance", "Lcom/urbanairship/messagecenter/ui/MessageFragment;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MessageFragment newInstance(@NotNull String messageId) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            MessageFragment messageFragment = new MessageFragment(0, 1, null);
            messageFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("message_id", messageId)));
            return messageFragment;
        }
    }
}
