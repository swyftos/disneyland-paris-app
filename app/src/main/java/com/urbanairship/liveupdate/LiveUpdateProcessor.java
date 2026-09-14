package com.urbanairship.liveupdate;

import androidx.annotation.VisibleForTesting;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest;
import com.urbanairship.channel.LiveUpdateMutation;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.liveupdate.data.LiveUpdateContent;
import com.urbanairship.liveupdate.data.LiveUpdateDao;
import com.urbanairship.liveupdate.data.LiveUpdateState;
import com.urbanairship.liveupdate.data.LiveUpdateStateWithContent;
import com.urbanairship.push.PushMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0003:;<B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0000¢\u0006\u0002\b%J\u0016\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010'J&\u0010(\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010)2\u0006\u0010$\u001a\u00020*H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020#H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00020#2\u0006\u0010$\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020#2\u0006\u0010$\u001a\u000206H\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020#H\u0002J\u000e\u00109\u001a\u00020#H\u0082@¢\u0006\u0002\u0010.R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006="}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor;", "", "dao", "Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/liveupdate/data/LiveUpdateDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "callbacks", "Lkotlinx/coroutines/channels/Channel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;", "cancels", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;", "channelUpdates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "getChannelUpdates", "()Lkotlinx/coroutines/flow/Flow;", "handlerCallbacks", "getHandlerCallbacks", "isProcessing", "", "isProcessing$urbanairship_live_update_release$annotations", "()V", "isProcessing$urbanairship_live_update_release", "()Z", "notificationCancels", "getNotificationCancels", "operationQueue", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "processJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updates", "enqueue", "", "operation", "enqueue$urbanairship_live_update_release", "process", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCancel", "Lkotlinx/coroutines/channels/ChannelResult;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "processCancel--JK-KAw", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processClearAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStart", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStop", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processUpdate", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "(Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryStartProcessing", "tryStopProcessing", "HandlerCallback", "NotificationCancel", "Operation", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateProcessor.kt\ncom/urbanairship/liveupdate/LiveUpdateProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1603#2,9:291\n1855#2:300\n1856#2:303\n1612#2:304\n1855#2,2:305\n1#3:301\n1#3:302\n*S KotlinDebug\n*F\n+ 1 LiveUpdateProcessor.kt\ncom/urbanairship/liveupdate/LiveUpdateProcessor\n*L\n224#1:291,9\n224#1:300\n224#1:303\n224#1:304\n227#1:305,2\n224#1:302\n*E\n"})
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

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processClearAll$1 */
    static final class C53971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processClearAll(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processStart$1 */
    static final class C53981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C53981(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processStart(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processStop$1 */
    static final class C53991 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C53991(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processStop(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$processUpdate$1 */
    static final class C54001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C54001(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateProcessor.this.processUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$tryStopProcessing$1 */
    static final class C54021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C54021(Continuation continuation) {
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

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$NotificationCancel;", "", "type", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
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
        this.operationQueue.mo5925trySendJP2dKIU(operation);
        tryStartProcessing();
    }

    private final void tryStartProcessing() {
        Job job = this.processJob;
        if (job == null || job == null || !job.isActive()) {
            this.processJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C54011(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.LiveUpdateProcessor$tryStartProcessing$1 */
    static final class C54011 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C54011(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LiveUpdateProcessor.this.new C54011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C54011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0046 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0047  */
        /* JADX WARN: Code duplicated, block: B:18:0x0052  */
        /* JADX WARN: Code duplicated, block: B:20:0x0064 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:7:0x0016). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
                com.urbanairship.UALog.m1751v(r8, r1)
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
                com.urbanairship.UALog.m1751v(r7, r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.LiveUpdateProcessor.C54011.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryStopProcessing(Continuation continuation) {
        C54021 c54021;
        if (continuation instanceof C54021) {
            c54021 = (C54021) continuation;
            int i = c54021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54021.label = i - Integer.MIN_VALUE;
            } else {
                c54021 = new C54021(continuation);
            }
        } else {
            c54021 = new C54021(continuation);
        }
        Object objIsAnyActive = c54021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54021.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objIsAnyActive);
            if (this.operationQueue.isEmpty()) {
                LiveUpdateDao liveUpdateDao = this.dao;
                c54021.L$0 = this;
                c54021.label = 1;
                objIsAnyActive = liveUpdateDao.isAnyActive(c54021);
                if (objIsAnyActive == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (LiveUpdateProcessor) c54021.L$0;
        ResultKt.throwOnFailure(objIsAnyActive);
        if (!((Boolean) objIsAnyActive).booleanValue()) {
            Job job = this.processJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.processJob = null;
            UALog.m1751v("Live Update processor stopped.", new Object[0]);
        }
        return Unit.INSTANCE;
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
            Object objM5145processCancelJKKAw = m5145processCancelJKKAw((Operation.Cancel) operation, continuation);
            return objM5145processCancelJKKAw == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5145processCancelJKKAw : Unit.INSTANCE;
        }
        if (!(operation instanceof Operation.ClearAll)) {
            return Unit.INSTANCE;
        }
        Object objProcessClearAll = processClearAll(continuation);
        return objProcessClearAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessClearAll : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object processStart(Operation.Start start, Continuation continuation) {
        C53981 c53981;
        Object obj;
        Operation.Start start2;
        LiveUpdateProcessor liveUpdateProcessor;
        Operation.Start start3;
        LiveUpdateState liveUpdateState;
        LiveUpdateContent liveUpdateContent;
        Operation.Start start4;
        LiveUpdateProcessor liveUpdateProcessor2 = this;
        Operation.Start start5 = start;
        if (continuation instanceof C53981) {
            c53981 = (C53981) continuation;
            int i = c53981.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c53981.label = i - Integer.MIN_VALUE;
            } else {
                c53981 = liveUpdateProcessor2.new C53981(continuation);
            }
        } else {
            c53981 = liveUpdateProcessor2.new C53981(continuation);
        }
        Object obj2 = c53981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c53981.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            LiveUpdateDao liveUpdateDao = liveUpdateProcessor2.dao;
            String name = start.getName();
            c53981.L$0 = liveUpdateProcessor2;
            c53981.L$1 = start5;
            c53981.L$2 = start5;
            c53981.label = 1;
            Object state = liveUpdateDao.getState(name, c53981);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = state;
            start2 = start5;
        } else {
            if (i2 == 1) {
                Operation.Start start6 = (Operation.Start) c53981.L$2;
                Operation.Start start7 = (Operation.Start) c53981.L$1;
                LiveUpdateProcessor liveUpdateProcessor3 = (LiveUpdateProcessor) c53981.L$0;
                ResultKt.throwOnFailure(obj2);
                start5 = start6;
                liveUpdateProcessor2 = liveUpdateProcessor3;
                obj = obj2;
                start2 = start7;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                liveUpdateState = (LiveUpdateState) c53981.L$4;
                liveUpdateContent = (LiveUpdateContent) c53981.L$3;
                start3 = (Operation.Start) c53981.L$2;
                start4 = (Operation.Start) c53981.L$1;
                liveUpdateProcessor = (LiveUpdateProcessor) c53981.L$0;
                ResultKt.throwOnFailure(obj2);
            }
            liveUpdateProcessor.updates.mo5925trySendJP2dKIU(new LiveUpdateMutation.Set(start3.getName(), start3.getTimestamp(), 0L, 4, null));
            liveUpdateProcessor.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.START, LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateState, liveUpdateContent), start4.getMessage()));
            return Unit.INSTANCE;
        }
        LiveUpdateState liveUpdateState2 = (LiveUpdateState) obj;
        if ((liveUpdateState2 != null ? liveUpdateState2.getTimestamp() : 0L) > start5.getTimestamp()) {
            UALog.m1754w("Ignored start for Live Update '" + start5.getName() + "'. Start event was stale.", new Object[0]);
            return Unit.INSTANCE;
        }
        if (liveUpdateState2 != null && liveUpdateState2.isActive() && !Intrinsics.areEqual(liveUpdateState2.getType(), start5.getType())) {
            liveUpdateProcessor2.enqueue$urbanairship_live_update_release(new Operation.Stop(start5.getName(), null, start5.getTimestamp(), null, null, 26, null));
            liveUpdateProcessor2.enqueue$urbanairship_live_update_release(start2);
            return Unit.INSTANCE;
        }
        if (liveUpdateState2 != null && liveUpdateState2.isActive()) {
            UALog.m1754w("Ignored start for Live Update '" + start5.getName() + "'. Already started.", new Object[0]);
            return Unit.INSTANCE;
        }
        LiveUpdateState liveUpdateState3 = new LiveUpdateState(start5.getName(), start5.getType(), true, start5.getTimestamp(), start5.getDismissalTimestamp());
        LiveUpdateContent liveUpdateContent2 = new LiveUpdateContent(start5.getName(), start5.getContent(), start5.getTimestamp());
        LiveUpdateDao liveUpdateDao2 = liveUpdateProcessor2.dao;
        c53981.L$0 = liveUpdateProcessor2;
        c53981.L$1 = start2;
        c53981.L$2 = start5;
        c53981.L$3 = liveUpdateContent2;
        c53981.L$4 = liveUpdateState3;
        c53981.label = 2;
        if (liveUpdateDao2.upsert(liveUpdateState3, liveUpdateContent2, c53981) == coroutine_suspended) {
            return coroutine_suspended;
        }
        liveUpdateProcessor = liveUpdateProcessor2;
        start3 = start5;
        liveUpdateState = liveUpdateState3;
        liveUpdateContent = liveUpdateContent2;
        start4 = start2;
        liveUpdateProcessor.updates.mo5925trySendJP2dKIU(new LiveUpdateMutation.Set(start3.getName(), start3.getTimestamp(), 0L, 4, null));
        liveUpdateProcessor.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.START, LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateState, liveUpdateContent), start4.getMessage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x013d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Instruction removed from duplicated block: B:48:0x013d, please report this as an issue */
    public final Object processUpdate(Operation.Update update, Continuation continuation) {
        C54001 c54001;
        Object obj;
        Operation.Update update2;
        LiveUpdateState liveUpdateStateCopy$default;
        LiveUpdateProcessor liveUpdateProcessor;
        Operation.Update update3;
        LiveUpdateStateWithContent liveUpdateStateWithContent;
        LiveUpdateContent liveUpdateContent;
        Operation.Update update4;
        LiveUpdateState state;
        LiveUpdateContent content;
        LiveUpdateState state2;
        LiveUpdateProcessor liveUpdateProcessor2 = this;
        Operation.Update update5 = update;
        if (continuation instanceof C54001) {
            c54001 = (C54001) continuation;
            int i = c54001.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54001.label = i - Integer.MIN_VALUE;
            } else {
                c54001 = liveUpdateProcessor2.new C54001(continuation);
            }
        } else {
            c54001 = liveUpdateProcessor2.new C54001(continuation);
        }
        Object obj2 = c54001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54001.label;
        if (i2 != 0) {
            if (i2 == 1) {
                Operation.Update update6 = (Operation.Update) c54001.L$2;
                Operation.Update update7 = (Operation.Update) c54001.L$1;
                LiveUpdateProcessor liveUpdateProcessor3 = (LiveUpdateProcessor) c54001.L$0;
                ResultKt.throwOnFailure(obj2);
                update5 = update6;
                liveUpdateProcessor2 = liveUpdateProcessor3;
                obj = obj2;
                update2 = update7;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                liveUpdateContent = (LiveUpdateContent) c54001.L$4;
                liveUpdateStateWithContent = (LiveUpdateStateWithContent) c54001.L$3;
                update3 = (Operation.Update) c54001.L$2;
                update4 = (Operation.Update) c54001.L$1;
                liveUpdateProcessor = (LiveUpdateProcessor) c54001.L$0;
                ResultKt.throwOnFailure(obj2);
            }
            if (liveUpdateStateWithContent == null && (state2 = liveUpdateStateWithContent.getState()) != null && state2.isActive()) {
                liveUpdateProcessor.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.UPDATE, LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateStateWithContent.getState(), liveUpdateContent), update4.getMessage()));
            } else {
                UALog.m1754w("Ignoring Live Update for '" + update3.getName() + "'. Live Update is not started!", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj2);
        LiveUpdateDao liveUpdateDao = liveUpdateProcessor2.dao;
        String name = update.getName();
        c54001.L$0 = liveUpdateProcessor2;
        c54001.L$1 = update5;
        c54001.L$2 = update5;
        c54001.label = 1;
        Object obj3 = liveUpdateDao.get(name, c54001);
        if (obj3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj = obj3;
        update2 = update5;
        LiveUpdateStateWithContent liveUpdateStateWithContent2 = (LiveUpdateStateWithContent) obj;
        if (((liveUpdateStateWithContent2 == null || (content = liveUpdateStateWithContent2.getContent()) == null) ? -1L : content.getTimestamp()) > update5.getTimestamp()) {
            UALog.m1751v("Ignoring stale Live Update content for '" + update5.getName() + "': " + update5.getContent(), new Object[0]);
            return Unit.INSTANCE;
        }
        if (liveUpdateStateWithContent2 == null || (state = liveUpdateStateWithContent2.getState()) == null) {
            liveUpdateStateCopy$default = null;
        } else {
            Long dismissalTimestamp = update5.getDismissalTimestamp();
            if (dismissalTimestamp == null) {
                dismissalTimestamp = liveUpdateStateWithContent2.getState().getDismissalDate();
            }
            liveUpdateStateCopy$default = LiveUpdateState.copy$default(state, null, null, false, 0L, dismissalTimestamp, 15, null);
        }
        LiveUpdateContent liveUpdateContent2 = new LiveUpdateContent(update5.getName(), update5.getContent(), update5.getTimestamp());
        LiveUpdateDao liveUpdateDao2 = liveUpdateProcessor2.dao;
        c54001.L$0 = liveUpdateProcessor2;
        c54001.L$1 = update2;
        c54001.L$2 = update5;
        c54001.L$3 = liveUpdateStateWithContent2;
        c54001.L$4 = liveUpdateContent2;
        c54001.label = 2;
        if (liveUpdateDao2.upsert(liveUpdateStateCopy$default, liveUpdateContent2, c54001) == coroutine_suspended) {
            return coroutine_suspended;
        }
        liveUpdateProcessor = liveUpdateProcessor2;
        update3 = update5;
        liveUpdateStateWithContent = liveUpdateStateWithContent2;
        liveUpdateContent = liveUpdateContent2;
        update4 = update2;
        if (liveUpdateStateWithContent == null) {
            UALog.m1754w("Ignoring Live Update for '" + update3.getName() + "'. Live Update is not started!", new Object[0]);
        } else {
            UALog.m1754w("Ignoring Live Update for '" + update3.getName() + "'. Live Update is not started!", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[Catch: all -> 0x004c, TryCatch #4 {all -> 0x004c, blocks: (B:15:0x0045, B:67:0x0172, B:36:0x00c0, B:38:0x00c4, B:41:0x00cd, B:47:0x00da, B:50:0x00e3, B:52:0x00ef, B:57:0x011f, B:59:0x0129, B:60:0x012d, B:62:0x0145, B:63:0x0155, B:32:0x00a8), top: B:98:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #4 {all -> 0x004c, blocks: (B:15:0x0045, B:67:0x0172, B:36:0x00c0, B:38:0x00c4, B:41:0x00cd, B:47:0x00da, B:50:0x00e3, B:52:0x00ef, B:57:0x011f, B:59:0x0129, B:60:0x012d, B:62:0x0145, B:63:0x0155, B:32:0x00a8), top: B:98:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x01cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:83:0x0204 A[RETURN] */
    public final Object processStop(Operation.Stop stop, Continuation continuation) throws Throwable {
        C53991 c53991;
        Object obj;
        Object obj2;
        Operation.Stop stop2;
        LiveUpdateStateWithContent liveUpdateStateWithContent;
        LiveUpdateState state;
        LiveUpdateContent liveUpdateContentCopy$default;
        Unit unit;
        long j;
        Operation.Stop stop3;
        Operation.Stop stop4;
        LiveUpdateState liveUpdateState;
        Object obj3;
        Object objDeleteContent;
        Object obj4;
        LiveUpdateProcessor liveUpdateProcessor = this;
        Operation.Stop stop5 = stop;
        if (continuation instanceof C53991) {
            c53991 = (C53991) continuation;
            int i = c53991.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c53991.label = i - Integer.MIN_VALUE;
            } else {
                c53991 = liveUpdateProcessor.new C53991(continuation);
            }
        } else {
            c53991 = liveUpdateProcessor.new C53991(continuation);
        }
        Object obj5 = c53991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c53991.label) {
                case 0:
                    ResultKt.throwOnFailure(obj5);
                    LiveUpdateDao liveUpdateDao = liveUpdateProcessor.dao;
                    String name = stop.getName();
                    c53991.L$0 = liveUpdateProcessor;
                    c53991.L$1 = stop5;
                    c53991.L$2 = stop5;
                    c53991.label = 1;
                    Object obj6 = liveUpdateDao.get(name, c53991);
                    if (obj6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = obj6;
                    stop2 = stop5;
                    liveUpdateStateWithContent = (LiveUpdateStateWithContent) obj2;
                    if (liveUpdateStateWithContent != null) {
                        state = liveUpdateStateWithContent.getState();
                    } else {
                        state = null;
                    }
                    if (liveUpdateStateWithContent != null) {
                        liveUpdateContentCopy$default = liveUpdateStateWithContent.getContent();
                    } else {
                        liveUpdateContentCopy$default = null;
                    }
                    if (state != null || liveUpdateContentCopy$default == null || !state.isActive()) {
                        obj = coroutine_suspended;
                        try {
                            UALog.m1754w("Ignored end for Live Update '" + stop5.getName() + "'. Live Update is not started!", new Object[0]);
                            unit = Unit.INSTANCE;
                            c53991.L$0 = unit;
                            c53991.L$1 = null;
                            c53991.L$2 = null;
                            c53991.label = 2;
                            if (liveUpdateProcessor.tryStopProcessing(c53991) == obj) {
                                return obj;
                            }
                            return unit;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        long timestamp = state.getTimestamp();
                        if (timestamp > stop5.getTimestamp()) {
                            UALog.m1751v("Ignored end for Live Update '" + stop5.getName() + "'. Stop event was stale.", new Object[0]);
                            Unit unit2 = Unit.INSTANCE;
                            c53991.L$0 = unit2;
                            c53991.L$1 = null;
                            c53991.L$2 = null;
                            c53991.label = 3;
                            return liveUpdateProcessor.tryStopProcessing(c53991) == coroutine_suspended ? coroutine_suspended : unit2;
                        }
                        long timestamp2 = stop5.getTimestamp();
                        Long dismissalTimestamp = stop5.getDismissalTimestamp();
                        if (dismissalTimestamp == null) {
                            dismissalTimestamp = state.getDismissalDate();
                        }
                        LiveUpdateState liveUpdateStateCopy$default = LiveUpdateState.copy$default(state, null, null, false, timestamp2, dismissalTimestamp, 3, null);
                        if (stop5.getContent() != null) {
                            liveUpdateContentCopy$default = LiveUpdateContent.copy$default(liveUpdateContentCopy$default, null, stop5.getContent(), stop5.getTimestamp(), 1, null);
                        }
                        LiveUpdateDao liveUpdateDao2 = liveUpdateProcessor.dao;
                        c53991.L$0 = liveUpdateProcessor;
                        c53991.L$1 = stop2;
                        c53991.L$2 = stop5;
                        c53991.L$3 = liveUpdateStateCopy$default;
                        c53991.L$4 = liveUpdateContentCopy$default;
                        j = timestamp;
                        c53991.J$0 = j;
                        c53991.label = 4;
                        if (liveUpdateDao2.upsert(liveUpdateStateCopy$default, liveUpdateContentCopy$default, c53991) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stop3 = stop2;
                        stop4 = stop5;
                        liveUpdateState = liveUpdateStateCopy$default;
                        try {
                            liveUpdateProcessor.updates.mo5925trySendJP2dKIU(new LiveUpdateMutation.Remove(stop4.getName(), j, 0L, 4, null));
                            liveUpdateProcessor.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.END, LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateState, liveUpdateContentCopy$default), stop3.getMessage()));
                            LiveUpdateDao liveUpdateDao3 = liveUpdateProcessor.dao;
                            String name2 = stop4.getName();
                            c53991.L$0 = liveUpdateProcessor;
                            obj3 = null;
                            c53991.L$1 = null;
                            c53991.L$2 = null;
                            c53991.L$3 = null;
                            c53991.L$4 = null;
                            c53991.label = 5;
                            objDeleteContent = liveUpdateDao3.deleteContent(name2, c53991);
                            obj4 = coroutine_suspended;
                            if (objDeleteContent == obj4) {
                                return obj4;
                            }
                            c53991.L$0 = obj3;
                            c53991.label = 6;
                            if (liveUpdateProcessor.tryStopProcessing(c53991) == obj4) {
                                return obj4;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            obj = coroutine_suspended;
                        }
                    }
                    c53991.L$0 = th;
                    c53991.L$1 = null;
                    c53991.L$2 = null;
                    c53991.L$3 = null;
                    c53991.L$4 = null;
                    c53991.label = 7;
                    if (liveUpdateProcessor.tryStopProcessing(c53991) == obj) {
                        return obj;
                    }
                    throw th;
                case 1:
                    stop5 = (Operation.Stop) c53991.L$2;
                    Operation.Stop stop6 = (Operation.Stop) c53991.L$1;
                    LiveUpdateProcessor liveUpdateProcessor2 = (LiveUpdateProcessor) c53991.L$0;
                    try {
                        ResultKt.throwOnFailure(obj5);
                        stop2 = stop6;
                        liveUpdateProcessor = liveUpdateProcessor2;
                        obj2 = obj5;
                        liveUpdateStateWithContent = (LiveUpdateStateWithContent) obj2;
                        if (liveUpdateStateWithContent != null) {
                            state = liveUpdateStateWithContent.getState();
                        } else {
                            state = null;
                        }
                        if (liveUpdateStateWithContent != null) {
                            liveUpdateContentCopy$default = liveUpdateStateWithContent.getContent();
                        } else {
                            liveUpdateContentCopy$default = null;
                        }
                        if (state != null) {
                        }
                        obj = coroutine_suspended;
                        UALog.m1754w("Ignored end for Live Update '" + stop5.getName() + "'. Live Update is not started!", new Object[0]);
                        unit = Unit.INSTANCE;
                        c53991.L$0 = unit;
                        c53991.L$1 = null;
                        c53991.L$2 = null;
                        c53991.label = 2;
                        if (liveUpdateProcessor.tryStopProcessing(c53991) == obj) {
                            return obj;
                        }
                        return unit;
                    } catch (Throwable th3) {
                        th = th3;
                        obj = coroutine_suspended;
                        liveUpdateProcessor = liveUpdateProcessor2;
                    }
                    break;
                case 2:
                    Unit unit3 = (Unit) c53991.L$0;
                    ResultKt.throwOnFailure(obj5);
                    return unit3;
                case 3:
                    Unit unit4 = (Unit) c53991.L$0;
                    ResultKt.throwOnFailure(obj5);
                    return unit4;
                case 4:
                    long j2 = c53991.J$0;
                    liveUpdateContentCopy$default = (LiveUpdateContent) c53991.L$4;
                    LiveUpdateState liveUpdateState2 = (LiveUpdateState) c53991.L$3;
                    Operation.Stop stop7 = (Operation.Stop) c53991.L$2;
                    Operation.Stop stop8 = (Operation.Stop) c53991.L$1;
                    LiveUpdateProcessor liveUpdateProcessor3 = (LiveUpdateProcessor) c53991.L$0;
                    try {
                        ResultKt.throwOnFailure(obj5);
                        stop4 = stop7;
                        stop3 = stop8;
                        liveUpdateState = liveUpdateState2;
                        liveUpdateProcessor = liveUpdateProcessor3;
                        j = j2;
                        liveUpdateProcessor.updates.mo5925trySendJP2dKIU(new LiveUpdateMutation.Remove(stop4.getName(), j, 0L, 4, null));
                        liveUpdateProcessor.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.END, LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateState, liveUpdateContentCopy$default), stop3.getMessage()));
                        LiveUpdateDao liveUpdateDao4 = liveUpdateProcessor.dao;
                        String name3 = stop4.getName();
                        c53991.L$0 = liveUpdateProcessor;
                        obj3 = null;
                        c53991.L$1 = null;
                        c53991.L$2 = null;
                        c53991.L$3 = null;
                        c53991.L$4 = null;
                        c53991.label = 5;
                        objDeleteContent = liveUpdateDao4.deleteContent(name3, c53991);
                        obj4 = coroutine_suspended;
                        if (objDeleteContent == obj4) {
                            return obj4;
                        }
                        c53991.L$0 = obj3;
                        c53991.label = 6;
                        if (liveUpdateProcessor.tryStopProcessing(c53991) == obj4) {
                            return obj4;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        th = th4;
                        obj = coroutine_suspended;
                        liveUpdateProcessor = liveUpdateProcessor3;
                    }
                    break;
                case 5:
                    liveUpdateProcessor = (LiveUpdateProcessor) c53991.L$0;
                    ResultKt.throwOnFailure(obj5);
                    obj4 = coroutine_suspended;
                    obj3 = null;
                    c53991.L$0 = obj3;
                    c53991.label = 6;
                    if (liveUpdateProcessor.tryStopProcessing(c53991) == obj4) {
                        return obj4;
                    }
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj5);
                    return Unit.INSTANCE;
                case 7:
                    Throwable th5 = (Throwable) c53991.L$0;
                    ResultKt.throwOnFailure(obj5);
                    throw th5;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th6) {
            th = th6;
            obj = coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: processCancel--JK-KAw, reason: not valid java name */
    public final Object m5145processCancelJKKAw(Operation.Cancel cancel, Continuation continuation) {
        LiveUpdateProcessor$processCancel$1 liveUpdateProcessor$processCancel$1;
        if (continuation instanceof LiveUpdateProcessor$processCancel$1) {
            liveUpdateProcessor$processCancel$1 = (LiveUpdateProcessor$processCancel$1) continuation;
            int i = liveUpdateProcessor$processCancel$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                liveUpdateProcessor$processCancel$1.label = i - Integer.MIN_VALUE;
            } else {
                liveUpdateProcessor$processCancel$1 = new LiveUpdateProcessor$processCancel$1(this, continuation);
            }
        } else {
            liveUpdateProcessor$processCancel$1 = new LiveUpdateProcessor$processCancel$1(this, continuation);
        }
        Object state = liveUpdateProcessor$processCancel$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = liveUpdateProcessor$processCancel$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(state);
            LiveUpdateDao liveUpdateDao = this.dao;
            String name = cancel.getName();
            liveUpdateProcessor$processCancel$1.L$0 = this;
            liveUpdateProcessor$processCancel$1.L$1 = cancel;
            liveUpdateProcessor$processCancel$1.label = 1;
            state = liveUpdateDao.getState(name, liveUpdateProcessor$processCancel$1);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cancel = (Operation.Cancel) liveUpdateProcessor$processCancel$1.L$1;
            this = (LiveUpdateProcessor) liveUpdateProcessor$processCancel$1.L$0;
            ResultKt.throwOnFailure(state);
        }
        LiveUpdateState liveUpdateState = (LiveUpdateState) state;
        if (liveUpdateState != null) {
            return ChannelResult.m5940boximpl(this.cancels.mo5925trySendJP2dKIU(new NotificationCancel(liveUpdateState.getType(), cancel.getName())));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processClearAll(Continuation continuation) {
        C53971 c53971;
        if (continuation instanceof C53971) {
            c53971 = (C53971) continuation;
            int i = c53971.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c53971.label = i - Integer.MIN_VALUE;
            } else {
                c53971 = new C53971(continuation);
            }
        } else {
            c53971 = new C53971(continuation);
        }
        Object allActive = c53971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c53971.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(allActive);
            LiveUpdateDao liveUpdateDao = this.dao;
            c53971.L$0 = this;
            c53971.label = 1;
            allActive = liveUpdateDao.getAllActive(c53971);
            if (allActive == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                this = (LiveUpdateProcessor) c53971.L$0;
                ResultKt.throwOnFailure(allActive);
            } else if (i2 == 2) {
                this = (LiveUpdateProcessor) c53971.L$0;
                ResultKt.throwOnFailure(allActive);
                c53971.L$0 = null;
                c53971.label = 3;
                if (this.tryStopProcessing(c53971) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(allActive);
            }
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (LiveUpdateStateWithContent liveUpdateStateWithContent : (Iterable) allActive) {
            LiveUpdateContent content = liveUpdateStateWithContent.getContent();
            LiveUpdate liveUpdateFrom$urbanairship_live_update_release = content != null ? LiveUpdate.INSTANCE.from$urbanairship_live_update_release(liveUpdateStateWithContent.getState(), content) : null;
            if (liveUpdateFrom$urbanairship_live_update_release != null) {
                arrayList.add(liveUpdateFrom$urbanairship_live_update_release);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.callbacks.mo5925trySendJP2dKIU(new HandlerCallback(LiveUpdateEvent.END, (LiveUpdate) it.next(), null));
        }
        LiveUpdateDao liveUpdateDao2 = this.dao;
        c53971.L$0 = this;
        c53971.label = 2;
        if (liveUpdateDao2.deleteAll(c53971) == coroutine_suspended) {
            return coroutine_suspended;
        }
        c53971.L$0 = null;
        c53971.label = 3;
        if (this.tryStopProcessing(c53971) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "", "()V", "timestamp", "", "getTimestamp", "()J", "Cancel", "ClearAll", "Start", "Stop", "Update", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$ClearAll;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @VisibleForTesting
    public static abstract class Operation {
        public /* synthetic */ Operation(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract long getTimestamp();

        private Operation() {
        }

        @Metadata(m1835d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "type", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Start;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component6, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Update;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "message", "Lcom/urbanairship/push/PushMessage;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;Lcom/urbanairship/push/PushMessage;)Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Stop;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final JsonMap getContent() {
                return this.content;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Long getDismissalTimestamp() {
                return this.dismissalTimestamp;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$Cancel;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "name", "", "timestamp", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation$ClearAll;", "Lcom/urbanairship/liveupdate/LiveUpdateProcessor$Operation;", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

            /* JADX INFO: renamed from: component1, reason: from getter */
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

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m1836d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateProcessor$HandlerCallback;", "", "action", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "message", "Lcom/urbanairship/push/PushMessage;", "(Lcom/urbanairship/liveupdate/LiveUpdateEvent;Lcom/urbanairship/liveupdate/LiveUpdate;Lcom/urbanairship/push/PushMessage;)V", "getAction", "()Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "getMessage", "()Lcom/urbanairship/push/PushMessage;", "getUpdate", "()Lcom/urbanairship/liveupdate/LiveUpdate;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LiveUpdateEvent getAction() {
            return this.action;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LiveUpdate getUpdate() {
            return this.update;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
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
