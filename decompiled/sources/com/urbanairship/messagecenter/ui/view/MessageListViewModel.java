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
import com.google.firebase.messaging.Constants;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.messagecenter.Inbox;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.view.MessageListState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0014\u0010\u001f\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\u0016\u0010 \u001a\u00020\u001b2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\"J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010#\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&J\u0016\u0010'\u001a\u00020\u001b2\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListViewModel;", "Landroidx/lifecycle/ViewModel;", "predicate", "Lcom/urbanairship/Predicate;", "Lcom/urbanairship/messagecenter/Message;", "inbox", "Lcom/urbanairship/messagecenter/Inbox;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/urbanairship/Predicate;Lcom/urbanairship/messagecenter/Inbox;Landroidx/lifecycle/SavedStateHandle;)V", "_states", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "getMessagesJob", "Lkotlinx/coroutines/Job;", "refreshJob", "restoredState", "Lcom/urbanairship/messagecenter/ui/view/MessageListState$Content;", "states", "Lkotlinx/coroutines/flow/StateFlow;", "getStates", "()Lkotlinx/coroutines/flow/StateFlow;", "statesLiveData", "Landroidx/lifecycle/LiveData;", "getStatesLiveData", "()Landroidx/lifecycle/LiveData;", "deleteMessages", "", "messages", "", "getMessages", "markMessagesRead", "refreshInbox", "onRefreshed", "Lkotlin/Function0;", "setHighlighted", "message", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "setPredicate", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageListViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageListViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,192:1\n1549#2:193\n1620#2,3:194\n1549#2:197\n1620#2,3:198\n*S KotlinDebug\n*F\n+ 1 MessageListViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageListViewModel\n*L\n94#1:193\n94#1:194,3\n100#1:197\n100#1:198,3\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageListViewModel extends ViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final MutableStateFlow _states;
    private Job getMessagesJob;
    private final Inbox inbox;
    private Predicate predicate;
    private Job refreshJob;
    private final MessageListState.Content restoredState;
    private final SavedStateHandle savedStateHandle;
    private final StateFlow states;
    private final LiveData statesLiveData;

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ViewModelProvider.Factory factory() {
        return INSTANCE.factory();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ViewModelProvider.Factory factory(@Nullable Predicate<Message> predicate) {
        return INSTANCE.factory(predicate);
    }

    public /* synthetic */ MessageListViewModel(Predicate predicate, Inbox inbox, SavedStateHandle savedStateHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(predicate, (i & 2) != 0 ? MessageCenter.INSTANCE.shared().getInbox() : inbox, savedStateHandle);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListViewModel$Companion;", "", "()V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "predicate", "Lcom/urbanairship/Predicate;", "Lcom/urbanairship/messagecenter/Message;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMessageListViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageListViewModel$Companion\n+ 2 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,192:1\n35#2:193\n77#2,2:194\n*S KotlinDebug\n*F\n+ 1 MessageListViewModel.kt\ncom/urbanairship/messagecenter/ui/view/MessageListViewModel$Companion\n*L\n144#1:193\n145#1:194,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ViewModelProvider.Factory factory() {
            return factory$default(this, null, 1, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ViewModelProvider.Factory factory(@Nullable final Predicate<Message> predicate) {
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MessageListViewModel.class), new Function1() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel$Companion$factory$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final MessageListViewModel invoke(CreationExtras initializer) {
                    Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
                    return new MessageListViewModel(predicate, MessageCenter.INSTANCE.shared().getInbox(), SavedStateHandleSupport.createSavedStateHandle(initializer));
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewModelProvider.Factory factory$default(Companion companion, Predicate predicate, int i, Object obj) {
            if ((i & 1) != 0) {
                predicate = null;
            }
            return companion.factory(predicate);
        }
    }

    public MessageListViewModel(@Nullable Predicate<Message> predicate, @NotNull Inbox inbox, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(inbox, "inbox");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.predicate = predicate;
        this.inbox = inbox;
        this.savedStateHandle = savedStateHandle;
        Object obj = this.restoredState;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(obj == null ? MessageListState.Loading.INSTANCE : obj);
        this._states = MutableStateFlow;
        this.states = FlowKt.asStateFlow(MutableStateFlow);
        this.statesLiveData = FlowLiveDataConversions.asLiveData$default(MutableStateFlow, (CoroutineContext) null, 0L, 3, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        getMessages();
    }

    @NotNull
    public final StateFlow<MessageListState> getStates() {
        return this.states;
    }

    @NotNull
    public final LiveData<MessageListState> getStatesLiveData() {
        return this.statesLiveData;
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageListViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageListViewModel.this.new AnonymousClass1(continuation);
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
                StateFlow<MessageListState> states = MessageListViewModel.this.getStates();
                C01521 c01521 = new FlowCollector() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(MessageListState messageListState, Continuation continuation) {
                        UALog.v("> " + messageListState, new Object[0]);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (states.collect(c01521, this) == coroutine_suspended) {
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

    public final void setPredicate(@Nullable Predicate<Message> predicate) {
        this.predicate = predicate;
        getMessages();
    }

    public final void setHighlighted(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        setHighlighted(message.getId());
    }

    public final void setHighlighted(@Nullable final String messageId) {
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.setHighlighted.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Setting highlighted message: " + messageId;
            }
        }, 1, null);
        Object value = this._states.getValue();
        MessageListState.Content content = value instanceof MessageListState.Content ? (MessageListState.Content) value : null;
        if (content != null) {
            this._states.setValue(MessageListState.Content.copy$default(content, null, false, messageId, 3, null));
        }
    }

    public final void markMessagesRead(@NotNull final List<Message> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.markMessagesRead.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Marking " + messages.size() + " messages read";
            }
        }, 1, null);
        Inbox inbox = this.inbox;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(((Message) it.next()).getId());
        }
        inbox.markMessagesRead(CollectionsKt.toSet(arrayList));
    }

    public final void deleteMessages(@NotNull final List<Message> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.deleteMessages.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Deleting  " + messages.size() + " messages";
            }
        }, 1, null);
        Inbox inbox = this.inbox;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(((Message) it.next()).getId());
        }
        inbox.deleteMessages(CollectionsKt.toSet(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshInbox$default(MessageListViewModel messageListViewModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.refreshInbox.1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2921invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2921invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        messageListViewModel.refreshInbox(function0);
    }

    public final void refreshInbox(@NotNull Function0<Unit> onRefreshed) {
        Intrinsics.checkNotNullParameter(onRefreshed, "onRefreshed");
        this._states.setValue(MessageListState.Loading.INSTANCE);
        Job job = this.refreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.refreshJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C12632(onRefreshed, null), 3, null);
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageListViewModel$refreshInbox$2, reason: invalid class name and case insensitive filesystem */
    static final class C12632 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $onRefreshed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12632(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$onRefreshed = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageListViewModel.this.new C12632(this.$onRefreshed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.refreshInbox.2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Refreshing messages...";
                    }
                }, 1, null);
                Inbox inbox = MessageListViewModel.this.inbox;
                this.label = 1;
                if (inbox.fetchMessages(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MessageListViewModel.this.getMessages();
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.refreshInbox.2.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Messages refreshed!";
                }
            }, 1, null);
            this.$onRefreshed.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMessages() {
        Job job = this.getMessagesJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.getMessagesJob = FlowKt.launchIn(FlowKt.m3656catch(FlowKt.onEach(this.inbox.getMessagesFlow(this.predicate), new C12601(null)), new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageListViewModel$getMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C12601 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C12601(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12601 c12601 = MessageListViewModel.this.new C12601(continuation);
            c12601.L$0 = obj;
            return c12601;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C12601) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MessageListState.Content content;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                MutableStateFlow mutableStateFlow = MessageListViewModel.this._states;
                Object value = MessageListViewModel.this._states.getValue();
                MessageListState.Content content2 = value instanceof MessageListState.Content ? (MessageListState.Content) value : null;
                if (content2 == null || (content = MessageListState.Content.copy$default(content2, list, false, null, 6, null)) == null) {
                    content = new MessageListState.Content(list, false, null, 4, null);
                }
                mutableStateFlow.setValue(content);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.urbanairship.messagecenter.ui.view.MessageListViewModel$getMessages$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = MessageListViewModel.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UALog.e((Throwable) this.L$0, new Function0() { // from class: com.urbanairship.messagecenter.ui.view.MessageListViewModel.getMessages.2.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error fetching messages";
                }
            });
            MessageListViewModel.this._states.setValue(MessageListState.Error.INSTANCE);
            return Unit.INSTANCE;
        }
    }
}
