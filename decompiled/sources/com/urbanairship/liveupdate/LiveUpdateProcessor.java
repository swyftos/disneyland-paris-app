package com.urbanairship.liveupdate;

import androidx.annotation.VisibleForTesting;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest;
import com.urbanairship.channel.LiveUpdateMutation;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.liveupdate.data.LiveUpdateDao;
import com.urbanairship.push.PushMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0003:;<B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0000¢\u0006\u0002\b%J\u0016\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010'J&\u0010(\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010)2\u0006\u0010$\u001a\u00020*H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020#H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00020#2\u0006\u0010$\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020#2\u0006\u0010$\u001a\u000206H\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020#H\u0002J\u000e\u00109\u001a\u00020#H\u0082@¢\u0006\u0002\u0010.R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor;", "", "dao", "Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/liveupdate/data/LiveUpdateDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "callbacks", "Lkotlinx/coroutines/channels/Channel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;", "cancels", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;", "channelUpdates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "getChannelUpdates", "()Lkotlinx/coroutines/flow/Flow;", "handlerCallbacks", "getHandlerCallbacks", "isProcessing", "", "isProcessing$urbanairship_live_update_release$annotations", "()V", "isProcessing$urbanairship_live_update_release", "()Z", "notificationCancels", "getNotificationCancels", "operationQueue", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "processJob", "Lkotlinx/coroutines/Job;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "updates", "enqueue", "", "operation", "enqueue$urbanairship_live_update_release", "process", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCancel", "Lkotlinx/coroutines/channels/ChannelResult;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "processCancel--JK-KAw", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processClearAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStart", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStop", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processUpdate", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryStartProcessing", "tryStopProcessing", "HandlerCallback", "NotificationCancel", "Operation", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateProcessor.kt\ncom/urbanairship/liveupdate/LiveUpdateProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1603#2,9:291\n1855#2:300\n1856#2:303\n1612#2:304\n1855#2,2:305\n1#3:301\n1#3:302\n*S KotlinDebug\n*F\n+ 1 LiveUpdateProcessor.kt\ncom/urbanairship/liveupdate/LiveUpdateProcessor\n*L\n224#1:291,9\n224#1:300\n224#1:303\n224#1:304\n227#1:305,2\n224#1:302\n*E\n"})
/* loaded from: classes5.dex */
public final class LiveUpdateProcessor {
    private final Channel callbacks;
    private final Channel cancels;
    private final Flow channelUpdates;
    private final LiveUpdateDao dao;
    private final Flow handlerCallbacks;
    private final Flow notificationCancels;
    private final Channel operationQueue;
    private Job processJob;
    private final CoroutineScope scope;
    private final Channel updates;

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processClearAll$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processClearAll(this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processStart$1, reason: invalid class name and case insensitive filesystem */
    static final class C11511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processStart(null, this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processStop$1, reason: invalid class name and case insensitive filesystem */
    static final class C11521 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11521(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processStop(null, this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processUpdate(null, this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$tryStopProcessing$1, reason: invalid class name and case insensitive filesystem */
    static final class C11551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.tryStopProcessing(this);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void isProcessing$urbanairship_live_update_release$annotations() {
    }

    public LiveUpdateProcessor(@NotNull LiveUpdateDao dao, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dao = dao;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        Channel channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.callbacks = channelChannel$default;
        this.handlerCallbacks = FlowKt.flowOn(FlowKt.receiveAsFlow(channelChannel$default), Dispatchers.getDefault());
        Channel channelChannel$default2 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.cancels = channelChannel$default2;
        this.notificationCancels = FlowKt.flowOn(FlowKt.receiveAsFlow(channelChannel$default2), Dispatchers.getDefault());
        Channel channelChannel$default3 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.updates = channelChannel$default3;
        this.channelUpdates = FlowKt.flowOn(FlowKt.receiveAsFlow(channelChannel$default3), Dispatchers.getDefault());
        this.operationQueue = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public /* synthetic */ LiveUpdateProcessor(LiveUpdateDao liveUpdateDao, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveUpdateDao, (i & 2) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    @NotNull
    public final Flow<HandlerCallback> getHandlerCallbacks() {
        return this.handlerCallbacks;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;", "", "type", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NotificationCancel {
        private final String name;
        private final String type;

        public static /* synthetic */ NotificationCancel copy$default(NotificationCancel notificationCancel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notificationCancel.type;
            }
            if ((i & 2) != 0) {
                str2 = notificationCancel.name;
            }
            return notificationCancel.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final NotificationCancel copy(@NotNull String type, @NotNull String name) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            return new NotificationCancel(type, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotificationCancel)) {
                return false;
            }
            NotificationCancel notificationCancel = (NotificationCancel) other;
            return Intrinsics.areEqual(this.type, notificationCancel.type) && Intrinsics.areEqual(this.name, notificationCancel.name);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "NotificationCancel(type=" + this.type + ", name=" + this.name + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public NotificationCancel(@NotNull String type, @NotNull String name) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            this.type = type;
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @NotNull
    public final Flow<NotificationCancel> getNotificationCancels() {
        return this.notificationCancels;
    }

    @NotNull
    public final Flow<LiveUpdateMutation> getChannelUpdates() {
        return this.channelUpdates;
    }

    public final boolean isProcessing$urbanairship_live_update_release() {
        Job job = this.processJob;
        return job != null && job.isActive();
    }

    public final void enqueue$urbanairship_live_update_release(@NotNull Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.operationQueue.mo3620trySendJP2dKIU(operation);
        tryStartProcessing();
    }

    private final void tryStartProcessing() {
        Job job = this.processJob;
        if (job == null || job == null || !job.isActive()) {
            this.processJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11541(null), 3, null);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$tryStartProcessing$1, reason: invalid class name and case insensitive filesystem */
    static final class C11541 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C11541(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LiveUpdateProcessor.this.new C11541(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:7:0x0016). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r8)
            L16:
                r8 = r1
                goto L3c
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L20:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4a
            L28:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.String r8 = "Live Update processor started."
                java.lang.Object[] r1 = new java.lang.Object[r2]
                com.urbanairship.UALog.v(r8, r1)
                com.urbanairship.liveupdate.LiveUpdateProcessor r8 = com.urbanairship.liveupdate.LiveUpdateProcessor.this
                kotlinx.coroutines.channels.Channel r8 = com.urbanairship.liveupdate.LiveUpdateProcessor.access$getOperationQueue$p(r8)
                kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()
            L3c:
                r7.L$0 = r8
                r7.label = r4
                java.lang.Object r1 = r8.hasNext(r7)
                if (r1 != r0) goto L47
                return r0
            L47:
                r6 = r1
                r1 = r8
                r8 = r6
            L4a:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L65
                java.lang.Object r8 = r1.next()
                com.urbanairship.liveupdate.LiveUpdateProcessor$Operation r8 = (com.urbanairship.liveupdate.LiveUpdateProcessor.Operation) r8
                com.urbanairship.liveupdate.LiveUpdateProcessor r5 = com.urbanairship.liveupdate.LiveUpdateProcessor.this
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = com.urbanairship.liveupdate.LiveUpdateProcessor.access$process(r5, r8, r7)
                if (r8 != r0) goto L16
                return r0
            L65:
                java.lang.String r7 = "Live Update processor finished."
                java.lang.Object[] r8 = new java.lang.Object[r2]
                com.urbanairship.UALog.v(r7, r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.C11541.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object tryStopProcessing(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.liveupdate.LiveUpdateProcessor.C11551
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.liveupdate.LiveUpdateProcessor$tryStopProcessing$1 r0 = (com.urbanairship.liveupdate.LiveUpdateProcessor.C11551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.LiveUpdateProcessor$tryStopProcessing$1 r0 = new com.urbanairship.liveupdate.LiveUpdateProcessor$tryStopProcessing$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.urbanairship.liveupdate.LiveUpdateProcessor r4 = (com.urbanairship.liveupdate.LiveUpdateProcessor) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4d
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.Channel r5 = r4.operationQueue
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L67
            com.urbanairship.liveupdate.data.LiveUpdateDao r5 = r4.dao
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.isAnyActive(r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L67
            kotlinx.coroutines.Job r5 = r4.processJob
            r0 = 0
            if (r5 == 0) goto L5d
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r5, r0, r3, r0)
        L5d:
            r4.processJob = r0
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "Live Update processor stopped."
            com.urbanairship.UALog.v(r5, r4)
        L67:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.tryStopProcessing(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object process(Operation operation, Continuation continuation) throws Throwable {
        if (operation instanceof Operation.Start) {
            Object objProcessStart = processStart((Operation.Start) operation, continuation);
            return objProcessStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessStart : Unit.INSTANCE;
        }
        if (operation instanceof Operation.Update) {
            Object objProcessUpdate = processUpdate((Operation.Update) operation, continuation);
            return objProcessUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessUpdate : Unit.INSTANCE;
        }
        if (operation instanceof Operation.Stop) {
            Object objProcessStop = processStop((Operation.Stop) operation, continuation);
            return objProcessStop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessStop : Unit.INSTANCE;
        }
        if (operation instanceof Operation.Cancel) {
            Object objM2903processCancelJKKAw = m2903processCancelJKKAw((Operation.Cancel) operation, continuation);
            return objM2903processCancelJKKAw == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2903processCancelJKKAw : Unit.INSTANCE;
        }
        if (!(operation instanceof Operation.ClearAll)) {
            return Unit.INSTANCE;
        }
        Object objProcessClearAll = processClearAll(continuation);
        return objProcessClearAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessClearAll : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processStart(com.urbanairship.liveupdate.LiveUpdateProcessor.Operation.Start r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.processStart(com.urbanairship.liveupdate.LiveUpdateProcessor$Operation$Start, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processUpdate(com.urbanairship.liveupdate.LiveUpdateProcessor.Operation.Update r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.processUpdate(com.urbanairship.liveupdate.LiveUpdateProcessor$Operation$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4 A[Catch: all -> 0x004c, TryCatch #4 {all -> 0x004c, blocks: (B:15:0x0045, B:67:0x0172, B:36:0x00c0, B:38:0x00c4, B:41:0x00cd, B:47:0x00da, B:50:0x00e3, B:52:0x00ef, B:57:0x011f, B:59:0x0129, B:60:0x012d, B:62:0x0145, B:63:0x0155, B:32:0x00a8), top: B:98:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #4 {all -> 0x004c, blocks: (B:15:0x0045, B:67:0x0172, B:36:0x00c0, B:38:0x00c4, B:41:0x00cd, B:47:0x00da, B:50:0x00e3, B:52:0x00ef, B:57:0x011f, B:59:0x0129, B:60:0x012d, B:62:0x0145, B:63:0x0155, B:32:0x00a8), top: B:98:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0204 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processStop(com.urbanairship.liveupdate.LiveUpdateProcessor.Operation.Stop r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.processStop(com.urbanairship.liveupdate.LiveUpdateProcessor$Operation$Stop, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: processCancel--JK-KAw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2903processCancelJKKAw(com.urbanairship.liveupdate.LiveUpdateProcessor.Operation.Cancel r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.liveupdate.LiveUpdateProcessor$processCancel$1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.liveupdate.LiveUpdateProcessor$processCancel$1 r0 = (com.urbanairship.liveupdate.LiveUpdateProcessor$processCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.LiveUpdateProcessor$processCancel$1 r0 = new com.urbanairship.liveupdate.LiveUpdateProcessor$processCancel$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.liveupdate.LiveUpdateProcessor$Operation$Cancel r5 = (com.urbanairship.liveupdate.LiveUpdateProcessor.Operation.Cancel) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.liveupdate.LiveUpdateProcessor r4 = (com.urbanairship.liveupdate.LiveUpdateProcessor) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L50
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.liveupdate.data.LiveUpdateDao r6 = r4.dao
            java.lang.String r2 = r5.getName()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getState(r2, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            com.urbanairship.liveupdate.data.LiveUpdateState r6 = (com.urbanairship.liveupdate.data.LiveUpdateState) r6
            if (r6 == 0) goto L6c
            kotlinx.coroutines.channels.Channel r4 = r4.cancels
            com.urbanairship.liveupdate.LiveUpdateProcessor$NotificationCancel r0 = new com.urbanairship.liveupdate.LiveUpdateProcessor$NotificationCancel
            java.lang.String r6 = r6.getType()
            java.lang.String r5 = r5.getName()
            r0.<init>(r6, r5)
            java.lang.Object r4 = r4.mo3620trySendJP2dKIU(r0)
            kotlinx.coroutines.channels.ChannelResult r4 = kotlinx.coroutines.channels.ChannelResult.m3635boximpl(r4)
            goto L6d
        L6c:
            r4 = 0
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.m2903processCancelJKKAw(com.urbanairship.liveupdate.LiveUpdateProcessor$Operation$Cancel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processClearAll(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.urbanairship.liveupdate.LiveUpdateProcessor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.urbanairship.liveupdate.LiveUpdateProcessor$processClearAll$1 r0 = (com.urbanairship.liveupdate.LiveUpdateProcessor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.LiveUpdateProcessor$processClearAll$1 r0 = new com.urbanairship.liveupdate.LiveUpdateProcessor$processClearAll$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L4a
            if (r2 == r5) goto L42
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lbe
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            java.lang.Object r9 = r0.L$0
            com.urbanairship.liveupdate.LiveUpdateProcessor r9 = (com.urbanairship.liveupdate.LiveUpdateProcessor) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb3
        L42:
            java.lang.Object r9 = r0.L$0
            com.urbanairship.liveupdate.LiveUpdateProcessor r9 = (com.urbanairship.liveupdate.LiveUpdateProcessor) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5a
        L4a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.urbanairship.liveupdate.data.LiveUpdateDao r10 = r9.dao
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.getAllActive(r0)
            if (r10 != r1) goto L5a
            return r1
        L5a:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r10 = r10.iterator()
        L65:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L89
            java.lang.Object r5 = r10.next()
            com.urbanairship.liveupdate.data.LiveUpdateStateWithContent r5 = (com.urbanairship.liveupdate.data.LiveUpdateStateWithContent) r5
            com.urbanairship.liveupdate.data.LiveUpdateContent r7 = r5.getContent()
            if (r7 == 0) goto L82
            com.urbanairship.liveupdate.LiveUpdate$Companion r8 = com.urbanairship.liveupdate.LiveUpdate.INSTANCE
            com.urbanairship.liveupdate.data.LiveUpdateState r5 = r5.getState()
            com.urbanairship.liveupdate.LiveUpdate r5 = r8.from$urbanairship_live_update_release(r5, r7)
            goto L83
        L82:
            r5 = r6
        L83:
            if (r5 == 0) goto L65
            r2.add(r5)
            goto L65
        L89:
            java.util.Iterator r10 = r2.iterator()
        L8d:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto La6
            java.lang.Object r2 = r10.next()
            com.urbanairship.liveupdate.LiveUpdate r2 = (com.urbanairship.liveupdate.LiveUpdate) r2
            kotlinx.coroutines.channels.Channel r5 = r9.callbacks
            com.urbanairship.liveupdate.LiveUpdateProcessor$HandlerCallback r7 = new com.urbanairship.liveupdate.LiveUpdateProcessor$HandlerCallback
            com.urbanairship.liveupdate.LiveUpdateEvent r8 = com.urbanairship.liveupdate.LiveUpdateEvent.END
            r7.<init>(r8, r2, r6)
            r5.mo3620trySendJP2dKIU(r7)
            goto L8d
        La6:
            com.urbanairship.liveupdate.data.LiveUpdateDao r10 = r9.dao
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = r10.deleteAll(r0)
            if (r10 != r1) goto Lb3
            return r1
        Lb3:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r9 = r9.tryStopProcessing(r0)
            if (r9 != r1) goto Lbe
            return r1
        Lbe:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.processClearAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "", "()V", "timestamp", "", "getTimestamp", "()J", "Cancel", "ClearAll", "Start", "Stop", "Update", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$ClearAll;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @VisibleForTesting
    public static abstract class Operation {
        public /* synthetic */ Operation(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract long getTimestamp();

        private Operation() {
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "type", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Start extends Operation {
            private final JsonMap content;
            private final Long dismissalTimestamp;
            private final PushMessage message;
            private final String name;
            private final long timestamp;
            private final String type;

            public static /* synthetic */ Start copy$default(Start start, String str, String str2, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = start.name;
                }
                if ((i & 2) != 0) {
                    str2 = start.type;
                }
                String str3 = str2;
                if ((i & 4) != 0) {
                    jsonMap = start.content;
                }
                JsonMap jsonMap2 = jsonMap;
                if ((i & 8) != 0) {
                    j = start.timestamp;
                }
                long j2 = j;
                if ((i & 16) != 0) {
                    l = start.dismissalTimestamp;
                }
                Long l2 = l;
                if ((i & 32) != 0) {
                    pushMessage = start.message;
                }
                return start.copy(str, str3, jsonMap2, j2, l2, pushMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* renamed from: component4, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* renamed from: component6, reason: from getter */
            public final PushMessage getMessage() {
                return this.message;
            }

            @NotNull
            public final Start copy(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(content, "content");
                return new Start(name, type, content, timestamp, dismissalTimestamp, message);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Start)) {
                    return false;
                }
                Start start = (Start) other;
                return Intrinsics.areEqual(this.name, start.name) && Intrinsics.areEqual(this.type, start.type) && Intrinsics.areEqual(this.content, start.content) && this.timestamp == start.timestamp && Intrinsics.areEqual(this.dismissalTimestamp, start.dismissalTimestamp) && Intrinsics.areEqual(this.message, start.message);
            }

            public int hashCode() {
                int iHashCode = ((((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
                Long l = this.dismissalTimestamp;
                int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
                PushMessage pushMessage = this.message;
                return iHashCode2 + (pushMessage != null ? pushMessage.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Start(name=" + this.name + ", type=" + this.type + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ", message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Start(String str, String str2, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, jsonMap, j, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : pushMessage);
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final JsonMap getContent() {
                return this.content;
            }

            @Override // com.urbanairship.liveupdate.LiveUpdateProcessor.Operation
            public long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            public final PushMessage getMessage() {
                return this.message;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long j, @Nullable Long l, @Nullable PushMessage pushMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(content, "content");
                this.name = name;
                this.type = type;
                this.content = content;
                this.timestamp = j;
                this.dismissalTimestamp = l;
                this.message = pushMessage;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Update extends Operation {
            private final JsonMap content;
            private final Long dismissalTimestamp;
            private final PushMessage message;
            private final String name;
            private final long timestamp;

            public static /* synthetic */ Update copy$default(Update update, String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = update.name;
                }
                if ((i & 2) != 0) {
                    jsonMap = update.content;
                }
                JsonMap jsonMap2 = jsonMap;
                if ((i & 4) != 0) {
                    j = update.timestamp;
                }
                long j2 = j;
                if ((i & 8) != 0) {
                    l = update.dismissalTimestamp;
                }
                Long l2 = l;
                if ((i & 16) != 0) {
                    pushMessage = update.message;
                }
                return update.copy(str, jsonMap2, j2, l2, pushMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* renamed from: component3, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final PushMessage getMessage() {
                return this.message;
            }

            @NotNull
            public final Update copy(@NotNull String name, @NotNull JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(content, "content");
                return new Update(name, content, timestamp, dismissalTimestamp, message);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return Intrinsics.areEqual(this.name, update.name) && Intrinsics.areEqual(this.content, update.content) && this.timestamp == update.timestamp && Intrinsics.areEqual(this.dismissalTimestamp, update.dismissalTimestamp) && Intrinsics.areEqual(this.message, update.message);
            }

            public int hashCode() {
                int iHashCode = ((((this.name.hashCode() * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
                Long l = this.dismissalTimestamp;
                int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
                PushMessage pushMessage = this.message;
                return iHashCode2 + (pushMessage != null ? pushMessage.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Update(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ", message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Update(String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, jsonMap, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : pushMessage);
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            public final JsonMap getContent() {
                return this.content;
            }

            @Override // com.urbanairship.liveupdate.LiveUpdateProcessor.Operation
            public long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            public final PushMessage getMessage() {
                return this.message;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Update(@NotNull String name, @NotNull JsonMap content, long j, @Nullable Long l, @Nullable PushMessage pushMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(content, "content");
                this.name = name;
                this.content = content;
                this.timestamp = j;
                this.dismissalTimestamp = l;
                this.message = pushMessage;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Stop extends Operation {
            private final JsonMap content;
            private final Long dismissalTimestamp;
            private final PushMessage message;
            private final String name;
            private final long timestamp;

            public static /* synthetic */ Stop copy$default(Stop stop, String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = stop.name;
                }
                if ((i & 2) != 0) {
                    jsonMap = stop.content;
                }
                JsonMap jsonMap2 = jsonMap;
                if ((i & 4) != 0) {
                    j = stop.timestamp;
                }
                long j2 = j;
                if ((i & 8) != 0) {
                    l = stop.dismissalTimestamp;
                }
                Long l2 = l;
                if ((i & 16) != 0) {
                    pushMessage = stop.message;
                }
                return stop.copy(str, jsonMap2, j2, l2, pushMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* renamed from: component3, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final PushMessage getMessage() {
                return this.message;
            }

            @NotNull
            public final Stop copy(@NotNull String name, @Nullable JsonMap content, long timestamp, @Nullable Long dismissalTimestamp, @Nullable PushMessage message) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new Stop(name, content, timestamp, dismissalTimestamp, message);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Stop)) {
                    return false;
                }
                Stop stop = (Stop) other;
                return Intrinsics.areEqual(this.name, stop.name) && Intrinsics.areEqual(this.content, stop.content) && this.timestamp == stop.timestamp && Intrinsics.areEqual(this.dismissalTimestamp, stop.dismissalTimestamp) && Intrinsics.areEqual(this.message, stop.message);
            }

            public int hashCode() {
                int iHashCode = this.name.hashCode() * 31;
                JsonMap jsonMap = this.content;
                int iHashCode2 = (((iHashCode + (jsonMap == null ? 0 : jsonMap.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
                Long l = this.dismissalTimestamp;
                int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
                PushMessage pushMessage = this.message;
                return iHashCode3 + (pushMessage != null ? pushMessage.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Stop(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ", message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Stop(String str, JsonMap jsonMap, long j, Long l, PushMessage pushMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : jsonMap, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : pushMessage);
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @Nullable
            public final JsonMap getContent() {
                return this.content;
            }

            @Override // com.urbanairship.liveupdate.LiveUpdateProcessor.Operation
            public long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            public final PushMessage getMessage() {
                return this.message;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Stop(@NotNull String name, @Nullable JsonMap jsonMap, long j, @Nullable Long l, @Nullable PushMessage pushMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
                this.content = jsonMap;
                this.timestamp = j;
                this.dismissalTimestamp = l;
                this.message = pushMessage;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "timestamp", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Cancel extends Operation {
            private final String name;
            private final long timestamp;

            public static /* synthetic */ Cancel copy$default(Cancel cancel, String str, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = cancel.name;
                }
                if ((i & 2) != 0) {
                    j = cancel.timestamp;
                }
                return cancel.copy(str, j);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component2, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @NotNull
            public final Cancel copy(@NotNull String name, long timestamp) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new Cancel(name, timestamp);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Cancel)) {
                    return false;
                }
                Cancel cancel = (Cancel) other;
                return Intrinsics.areEqual(this.name, cancel.name) && this.timestamp == cancel.timestamp;
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + Long.hashCode(this.timestamp);
            }

            @NotNull
            public String toString() {
                return "Cancel(name=" + this.name + ", timestamp=" + this.timestamp + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Cancel(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? 0L : j);
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            @Override // com.urbanairship.liveupdate.LiveUpdateProcessor.Operation
            public long getTimestamp() {
                return this.timestamp;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Cancel(@NotNull String name, long j) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
                this.timestamp = j;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$ClearAll;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ClearAll extends Operation {
            private final long timestamp;

            public ClearAll() {
                this(0L, 1, null);
            }

            public static /* synthetic */ ClearAll copy$default(ClearAll clearAll, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = clearAll.timestamp;
                }
                return clearAll.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @NotNull
            public final ClearAll copy(long timestamp) {
                return new ClearAll(timestamp);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ClearAll) && this.timestamp == ((ClearAll) other).timestamp;
            }

            public int hashCode() {
                return Long.hashCode(this.timestamp);
            }

            @NotNull
            public String toString() {
                return "ClearAll(timestamp=" + this.timestamp + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ ClearAll(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? 0L : j);
            }

            @Override // com.urbanairship.liveupdate.LiveUpdateProcessor.Operation
            public long getTimestamp() {
                return this.timestamp;
            }

            public ClearAll(long j) {
                super(null);
                this.timestamp = j;
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;", "", "action", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "message", "Lcom/urbanairship/push/PushMessage;", "(Lcom/urbanairship/liveupdate/LiveUpdateEvent;Lcom/urbanairship/liveupdate/LiveUpdate;Lcom/urbanairship/push/PushMessage;)V", "getAction", "()Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getUpdate", "()Lcom/urbanairship/liveupdate/LiveUpdate;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class HandlerCallback {
        private final LiveUpdateEvent action;
        private final PushMessage message;
        private final LiveUpdate update;

        public static /* synthetic */ HandlerCallback copy$default(HandlerCallback handlerCallback, LiveUpdateEvent liveUpdateEvent, LiveUpdate liveUpdate, PushMessage pushMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                liveUpdateEvent = handlerCallback.action;
            }
            if ((i & 2) != 0) {
                liveUpdate = handlerCallback.update;
            }
            if ((i & 4) != 0) {
                pushMessage = handlerCallback.message;
            }
            return handlerCallback.copy(liveUpdateEvent, liveUpdate, pushMessage);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final LiveUpdateEvent getAction() {
            return this.action;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LiveUpdate getUpdate() {
            return this.update;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final PushMessage getMessage() {
            return this.message;
        }

        @NotNull
        public final HandlerCallback copy(@NotNull LiveUpdateEvent action, @NotNull LiveUpdate update, @Nullable PushMessage message) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(update, "update");
            return new HandlerCallback(action, update, message);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HandlerCallback)) {
                return false;
            }
            HandlerCallback handlerCallback = (HandlerCallback) other;
            return this.action == handlerCallback.action && Intrinsics.areEqual(this.update, handlerCallback.update) && Intrinsics.areEqual(this.message, handlerCallback.message);
        }

        public int hashCode() {
            int iHashCode = ((this.action.hashCode() * 31) + this.update.hashCode()) * 31;
            PushMessage pushMessage = this.message;
            return iHashCode + (pushMessage == null ? 0 : pushMessage.hashCode());
        }

        @NotNull
        public String toString() {
            return "HandlerCallback(action=" + this.action + ", update=" + this.update + ", message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public HandlerCallback(@NotNull LiveUpdateEvent action, @NotNull LiveUpdate update, @Nullable PushMessage pushMessage) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(update, "update");
            this.action = action;
            this.update = update;
            this.message = pushMessage;
        }

        @NotNull
        public final LiveUpdateEvent getAction() {
            return this.action;
        }

        @NotNull
        public final LiveUpdate getUpdate() {
            return this.update;
        }

        @Nullable
        public final PushMessage getMessage() {
            return this.message;
        }
    }
}
