package com.urbanairship.messagecenter.ui.view;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.dlp.BluetoothManager;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.InboxListener;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.view.MessageViewState;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u001f\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u001c\"\u00020\u000b¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u001f\u0010#\u001a\u00020\u00192\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u001c\"\u00020\u000b¢\u0006\u0002\u0010\u001dJ\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageViewModel;", "Landroidx/lifecycle/ViewModel;", "inbox", "Lcom/urbanairship/messagecenter/Inbox;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/urbanairship/messagecenter/Inbox;Landroidx/lifecycle/SavedStateHandle;)V", "_states", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/messagecenter/ui/view/MessageViewState;", "currentMessage", "Lcom/urbanairship/messagecenter/Message;", "getCurrentMessage", "()Lcom/urbanairship/messagecenter/Message;", "restoredState", "Lcom/urbanairship/messagecenter/ui/view/MessageViewState$Content;", "states", "Lkotlinx/coroutines/flow/StateFlow;", "getStates", "()Lkotlinx/coroutines/flow/StateFlow;", "statesLiveData", "Landroidx/lifecycle/LiveData;", "getStatesLiveData", "()Landroidx/lifecycle/LiveData;", "clearMessage", "", "deleteMessages", "messages", "", "([Lcom/urbanairship/messagecenter/Message;)V", "getOrFetchMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMessage", "markMessagesRead", "subscribeForMessageUpdates", "Lcom/urbanairship/messagecenter/ui/view/SubscriptionCancellation;", "subscribeForMessageUpdates$urbanairship_message_center_release", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageViewModel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,200:1\n11065#2:201\n11400#2,3:202\n11065#2:205\n11400#2,3:206\n*S KotlinDebug\n*F\n+ 1 MessageViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageViewModel\n*L\n102#1:201\n102#1:202,3\n108#1:205\n108#1:206,3\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageViewModel extends ViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final MutableStateFlow _states;
    private final Inbox inbox;
    private final MessageViewState.Content restoredState;
    private final SavedStateHandle savedStateHandle;
    private final StateFlow states;
    private final LiveData statesLiveData;

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageViewModel$getOrFetchMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C12671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12671(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageViewModel.this.getOrFetchMessage(null, this);
        }
    }

    @JvmStatic
    @NotNull
    public static final ViewModelProvider.Factory factory() {
        return INSTANCE.factory();
    }

    public /* synthetic */ MessageViewModel(Inbox inbox, SavedStateHandle savedStateHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MessageCenter.INSTANCE.shared().getInbox() : inbox, savedStateHandle);
    }

    public MessageViewModel(@NotNull Inbox inbox, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(inbox, "inbox");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.inbox = inbox;
        this.savedStateHandle = savedStateHandle;
        MessageViewState.Content content = (MessageViewState.Content) savedStateHandle.get(BluetoothManager.BLE_STATUS_PARAM);
        this.restoredState = content;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(content == null ? MessageViewState.Empty.INSTANCE : content);
        this._states = MutableStateFlow;
        this.states = FlowKt.asStateFlow(MutableStateFlow);
        this.statesLiveData = FlowLiveDataConversions.asLiveData$default(MutableStateFlow, (CoroutineContext) null, 0L, 3, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMessageViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageViewModel$Companion\n+ 2 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,200:1\n35#2:201\n77#2,2:202\n*S KotlinDebug\n*F\n+ 1 MessageViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageViewModel$Companion\n*L\n153#1:201\n154#1:202,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ViewModelProvider.Factory factory() {
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MessageViewModel.class), new Function1() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel$Companion$factory$1$1
                @Override // kotlin.jvm.functions.Function1
                public final MessageViewModel invoke(CreationExtras initializer) {
                    Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
                    return new MessageViewModel(MessageCenter.INSTANCE.shared().getInbox(), SavedStateHandleSupport.createSavedStateHandle(initializer));
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }

        private Companion() {
        }
    }

    @NotNull
    public final StateFlow<MessageViewState> getStates() {
        return this.states;
    }

    @NotNull
    public final LiveData<MessageViewState> getStatesLiveData() {
        return this.statesLiveData;
    }

    @Nullable
    public final Message getCurrentMessage() {
        Object value = this._states.getValue();
        MessageViewState.Content content = value instanceof MessageViewState.Content ? (MessageViewState.Content) value : null;
        if (content != null) {
            return content.getMessage();
        }
        return null;
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<MessageViewState> states = MessageViewModel.this.getStates();
                final MessageViewModel messageViewModel = MessageViewModel.this;
                FlowCollector<? super MessageViewState> flowCollector = new FlowCollector() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(MessageViewState messageViewState, Continuation continuation) {
                        UALog.v("> " + messageViewState, new Object[0]);
                        MessageViewState.Content content = messageViewState instanceof MessageViewState.Content ? (MessageViewState.Content) messageViewState : null;
                        if (content != null) {
                            messageViewModel.savedStateHandle.set(BluetoothManager.BLE_STATUS_PARAM, content);
                        }
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

    public final void loadMessage(@NotNull final String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Message currentMessage = getCurrentMessage();
        if (Intrinsics.areEqual(messageId, currentMessage != null ? currentMessage.getId() : null)) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.loadMessage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Message already loaded: " + messageId;
                }
            }, 1, null);
            return;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.loadMessage.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Loading message: " + messageId;
            }
        }, 1, null);
        this._states.setValue(MessageViewState.Loading.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(messageId, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageViewModel$loadMessage$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation continuation) {
            super(2, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageViewModel.this.new AnonymousClass3(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow2 = MessageViewModel.this._states;
                MessageViewModel messageViewModel = MessageViewModel.this;
                String str = this.$messageId;
                this.L$0 = mutableStateFlow2;
                this.label = 1;
                Object orFetchMessage = messageViewModel.getOrFetchMessage(str, this);
                if (orFetchMessage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = orFetchMessage;
                mutableStateFlow = mutableStateFlow2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableStateFlow.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    public final void clearMessage() {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.clearMessage.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Clearing message";
            }
        }, 1, null);
        this._states.setValue(MessageViewState.Empty.INSTANCE);
    }

    public final void markMessagesRead(@NotNull final Message... messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.markMessagesRead.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Marking " + messages.length + " messages read";
            }
        }, 1, null);
        Inbox inbox = this.inbox;
        ArrayList arrayList = new ArrayList(messages.length);
        for (Message message : messages) {
            arrayList.add(message.getId());
        }
        inbox.markMessagesRead(CollectionsKt.toSet(arrayList));
    }

    public final void deleteMessages(@NotNull final Message... messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel.deleteMessages.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Deleting  " + messages.length + " messages";
            }
        }, 1, null);
        Inbox inbox = this.inbox;
        ArrayList arrayList = new ArrayList(messages.length);
        for (Message message : messages) {
            arrayList.add(message.getId());
        }
        inbox.deleteMessages(CollectionsKt.toSet(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.urbanairship.messagecenter.InboxListener, com.urbanairship.messagecenter.ui.view.MessageViewModel$subscribeForMessageUpdates$listener$1] */
    @NotNull
    public final SubscriptionCancellation subscribeForMessageUpdates$urbanairship_message_center_release() {
        final ?? r0 = new InboxListener() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel$subscribeForMessageUpdates$listener$1
            @Override // com.urbanairship.messagecenter.InboxListener
            public void onInboxUpdated() {
                String id;
                Message currentMessage = this.this$0.getCurrentMessage();
                if (currentMessage == null || (id = currentMessage.getId()) == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new MessageViewModel$subscribeForMessageUpdates$listener$1$onInboxUpdated$1(this.this$0, id, null), 3, null);
            }
        };
        this.inbox.addListener(r0);
        return new SubscriptionCancellation() { // from class: com.urbanairship.messagecenter.ui.view.MessageViewModel$subscribeForMessageUpdates$1
            @Override // com.urbanairship.messagecenter.ui.view.SubscriptionCancellation
            public void cancel() {
                this.this$0.inbox.removeListener(r0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getOrFetchMessage(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.urbanairship.messagecenter.ui.view.MessageViewModel.C12671
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.messagecenter.ui.view.MessageViewModel$getOrFetchMessage$1 r0 = (com.urbanairship.messagecenter.ui.view.MessageViewModel.C12671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.ui.view.MessageViewModel$getOrFetchMessage$1 r0 = new com.urbanairship.messagecenter.ui.view.MessageViewModel$getOrFetchMessage$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L50
            if (r2 == r5) goto L43
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L95
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r6 = r0.L$1
            com.urbanairship.messagecenter.ui.view.MessageViewModel r6 = (com.urbanairship.messagecenter.ui.view.MessageViewModel) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L43:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            com.urbanairship.messagecenter.ui.view.MessageViewModel r6 = (com.urbanairship.messagecenter.ui.view.MessageViewModel) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L50:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.messagecenter.Inbox r8 = r6.inbox
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r8.getMessage(r7, r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            com.urbanairship.messagecenter.Message r8 = (com.urbanairship.messagecenter.Message) r8
            if (r8 != 0) goto La1
            com.urbanairship.messagecenter.Inbox r8 = r6.inbox
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = r8.fetchMessages(r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L85
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error r6 = new com.urbanairship.messagecenter.ui.view.MessageViewState$Error
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error$Type r7 = com.urbanairship.messagecenter.ui.view.MessageViewState.Error.Type.LOAD_FAILED
            r6.<init>(r7)
            return r6
        L85:
            com.urbanairship.messagecenter.Inbox r6 = r6.inbox
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r6.getMessage(r7, r0)
            if (r8 != r1) goto L95
            return r1
        L95:
            com.urbanairship.messagecenter.Message r8 = (com.urbanairship.messagecenter.Message) r8
            if (r8 != 0) goto La1
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error r6 = new com.urbanairship.messagecenter.ui.view.MessageViewState$Error
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error$Type r7 = com.urbanairship.messagecenter.ui.view.MessageViewState.Error.Type.UNAVAILABLE
            r6.<init>(r7)
            return r6
        La1:
            boolean r6 = r8.isExpired()
            if (r6 == 0) goto Laf
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error r6 = new com.urbanairship.messagecenter.ui.view.MessageViewState$Error
            com.urbanairship.messagecenter.ui.view.MessageViewState$Error$Type r7 = com.urbanairship.messagecenter.ui.view.MessageViewState.Error.Type.UNAVAILABLE
            r6.<init>(r7)
            return r6
        Laf:
            com.urbanairship.messagecenter.ui.view.MessageViewState$Content r6 = new com.urbanairship.messagecenter.ui.view.MessageViewState$Content
            r6.<init>(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.ui.view.MessageViewModel.getOrFetchMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
