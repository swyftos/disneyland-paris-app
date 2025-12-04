package com.urbanairship.util;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\b \u0018\u0000 .*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002./B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ,\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0011H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0001H&¢\u0006\u0002\u0010(J$\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010!\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0006\u0010,\u001a\u00020-R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00188FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Lcom/urbanairship/util/AutoRefreshingDataProvider;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "identifierUpdates", "Lkotlinx/coroutines/flow/Flow;", "", "overrideUpdates", "clock", "Lcom/urbanairship/util/Clock;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;)V", "changeTokenFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "fetchCache", "Lcom/urbanairship/util/AutoRefreshingDataProvider$FetchCache;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "updates", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/Result;", "getUpdates$annotations", "()V", "getUpdates", "()Lkotlinx/coroutines/flow/SharedFlow;", "updates$delegate", "Lkotlin/Lazy;", "fetch", "identifier", "changeToken", "fetch-0E7RQCE", "(Ljava/lang/String;Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApplyOverrides", "data", "overrides", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "onFetch", "onFetch-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "Companion", "FetchCache", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AutoRefreshingDataProvider<T, R> {
    private static final long initialBackoff;
    private static final long maxBackoff;
    private static final long maxCacheAge;
    private final MutableStateFlow changeTokenFlow;
    private final FetchCache fetchCache;
    private final Flow identifierUpdates;
    private final Flow overrideUpdates;
    private final CoroutineScope scope;
    private final TaskSleeper taskSleeper;

    /* renamed from: updates$delegate, reason: from kotlin metadata */
    private final Lazy updates;

    public static /* synthetic */ void getUpdates$annotations() {
    }

    public abstract T onApplyOverrides(T data, R overrides);

    @Nullable
    /* renamed from: onFetch-gIAlu-s */
    public abstract Object mo2837onFetchgIAlus(@NotNull String str, @NotNull Continuation<? super Result<? extends T>> continuation);

    public AutoRefreshingDataProvider(@NotNull Flow<String> identifierUpdates, @NotNull Flow<? extends R> overrideUpdates, @NotNull Clock clock, @NotNull TaskSleeper taskSleeper, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(identifierUpdates, "identifierUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.identifierUpdates = identifierUpdates;
        this.overrideUpdates = overrideUpdates;
        this.taskSleeper = taskSleeper;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.changeTokenFlow = StateFlowKt.MutableStateFlow(UUID.randomUUID());
        this.fetchCache = new FetchCache(clock, maxCacheAge, null);
        this.updates = LazyKt.lazy(new Function0() { // from class: com.urbanairship.util.AutoRefreshingDataProvider$updates$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedFlow invoke() {
                return FlowKt.shareIn(FlowKt.transformLatest(FlowKt.combine(this.this$0.identifierUpdates, this.this$0.changeTokenFlow, new AnonymousClass1(null)), new AutoRefreshingDataProvider$updates$2$invoke$$inlined$flatMapLatest$1(null, this.this$0, new Ref.ObjectRef())), this.this$0.scope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 100L, 0L, 2, null), 1);
            }

            /* renamed from: com.urbanairship.util.AutoRefreshingDataProvider$updates$2$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function3 {
                /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(String str, UUID uuid, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = str;
                    anonymousClass1.L$1 = uuid;
                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return new Pair((String) this.L$0, (UUID) this.L$1);
                }
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutoRefreshingDataProvider(Flow flow, Flow flow2, Clock DEFAULT_CLOCK, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(flow, flow2, DEFAULT_CLOCK, (i & 8) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 16) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    public final void refresh() {
        this.changeTokenFlow.setValue(UUID.randomUUID());
    }

    @NotNull
    public final SharedFlow<Result<T>> getUpdates() {
        return (SharedFlow) this.updates.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: fetch-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2947fetch0E7RQCE(java.lang.String r5, java.util.UUID r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.urbanairship.util.AutoRefreshingDataProvider$fetch$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.util.AutoRefreshingDataProvider$fetch$1 r0 = (com.urbanairship.util.AutoRefreshingDataProvider$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.util.AutoRefreshingDataProvider$fetch$1 r0 = new com.urbanairship.util.AutoRefreshingDataProvider$fetch$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r4 = r0.L$2
            r6 = r4
            java.util.UUID r6 = (java.util.UUID) r6
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.util.AutoRefreshingDataProvider r4 = (com.urbanairship.util.AutoRefreshingDataProvider) r4
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.getValue()
            goto L64
        L3d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.util.AutoRefreshingDataProvider$FetchCache r7 = r4.fetchCache
            kotlin.Result r7 = r7.m2948getCacheYNEx5aM(r5, r6)
            if (r7 == 0) goto L55
            java.lang.Object r4 = r7.getValue()
            return r4
        L55:
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.mo2837onFetchgIAlus(r5, r0)
            if (r7 != r1) goto L64
            return r1
        L64:
            boolean r0 = kotlin.Result.m2974isSuccessimpl(r7)
            if (r0 == 0) goto L6f
            com.urbanairship.util.AutoRefreshingDataProvider$FetchCache r4 = r4.fetchCache
            r4.setCache(r5, r6, r7)
        L6f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.util.AutoRefreshingDataProvider.m2947fetch0E7RQCE(java.lang.String, java.util.UUID, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DurationUnit durationUnit = DurationUnit.SECONDS;
        initialBackoff = DurationKt.toDuration(8, durationUnit);
        maxBackoff = DurationKt.toDuration(64, durationUnit);
        maxCacheAge = DurationKt.toDuration(10, DurationUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class FetchCache {
        private final CachedValue cachedResponse;
        private final Clock clock;
        private final long maxCacheAge;

        public /* synthetic */ FetchCache(Clock clock, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(clock, j);
        }

        private FetchCache(Clock clock, long j) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            this.clock = clock;
            this.maxCacheAge = j;
            this.cachedResponse = new CachedValue(clock);
        }

        /* renamed from: getCache-YNEx5aM, reason: not valid java name */
        public final Result m2948getCacheYNEx5aM(String contactId, UUID changeToken) {
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            Intrinsics.checkNotNullParameter(changeToken, "changeToken");
            Triple triple = (Triple) this.cachedResponse.get();
            if (triple != null && Intrinsics.areEqual(triple.getFirst(), contactId) && Intrinsics.areEqual(triple.getSecond(), changeToken)) {
                return (Result) triple.getThird();
            }
            return null;
        }

        public final void setCache(String contactId, UUID changeToken, Object obj) {
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            Intrinsics.checkNotNullParameter(changeToken, "changeToken");
            this.cachedResponse.set(new Triple(contactId, changeToken, Result.m2967boximpl(obj)), this.clock.currentTimeMillis() + Duration.m3485getInWholeMillisecondsimpl(this.maxCacheAge));
        }

        /* renamed from: getRemainingCacheTimeMillis-UwyO8pc, reason: not valid java name */
        public final long m2949getRemainingCacheTimeMillisUwyO8pc() {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(this.cachedResponse.remainingCacheTimeMillis(), DurationUnit.MILLISECONDS);
        }
    }
}
