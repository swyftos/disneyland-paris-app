package com.urbanairship.featureflag;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.util.Clock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0018H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\rH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lcom/urbanairship/featureflag/FlagDeferredResolver;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "resolver", "Lcom/urbanairship/deferred/DeferredResolver;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/cache/AirshipCache;Lcom/urbanairship/deferred/DeferredResolver;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "backOffIntervals", "", "", "", "pendingTasks", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "Lcom/urbanairship/featureflag/DeferredFlag;", "fetchFlag", "request", "Lcom/urbanairship/deferred/DeferredRequest;", "requestId", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "allowRetry", "", "fetchFlag-yxL6bBk", "(Lcom/urbanairship/deferred/DeferredRequest;Ljava/lang/String;Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "flagInfo", "resolve-0E7RQCE", "(Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/featureflag/FeatureFlagInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve-BWLJW6A", "(Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/featureflag/FeatureFlagInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/FlagDeferredResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n1#2:219\n*E\n"})
/* loaded from: classes5.dex */
public final class FlagDeferredResolver {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long DEFAULT_BACKOFF_MS = 30000;

    @Deprecated
    public static final int IMMEDIATE_BACKOFF_RETRY_MS = 5000;

    @Deprecated
    public static final long MIN_CACHE_TIME_MS = 60000;
    private final Map backOffIntervals;
    private final AirshipCache cache;
    private final Clock clock;
    private final CoroutineDispatcher dispatcher;
    private final Map pendingTasks;
    private final DeferredResolver resolver;

    public FlagDeferredResolver(@NotNull AirshipCache cache, @NotNull DeferredResolver resolver, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.cache = cache;
        this.resolver = resolver;
        this.clock = clock;
        this.dispatcher = dispatcher;
        this.pendingTasks = new LinkedHashMap();
        this.backOffIntervals = new LinkedHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FlagDeferredResolver(AirshipCache airshipCache, DeferredResolver deferredResolver, Clock DEFAULT_CLOCK, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(airshipCache, deferredResolver, DEFAULT_CLOCK, (i & 8) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: resolve-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2869resolve0E7RQCE(@org.jetbrains.annotations.NotNull com.urbanairship.deferred.DeferredRequest r19, @org.jetbrains.annotations.NotNull com.urbanairship.featureflag.FeatureFlagInfo r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.urbanairship.featureflag.DeferredFlag>> r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r21
            boolean r2 = r0 instanceof com.urbanairship.featureflag.FlagDeferredResolver$resolve$1
            if (r2 == 0) goto L18
            r2 = r0
            com.urbanairship.featureflag.FlagDeferredResolver$resolve$1 r2 = (com.urbanairship.featureflag.FlagDeferredResolver$resolve$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            com.urbanairship.featureflag.FlagDeferredResolver$resolve$1 r2 = new com.urbanairship.featureflag.FlagDeferredResolver$resolve$1
            r2.<init>(r1, r0)
            goto L16
        L1e:
            java.lang.Object r0 = r6.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r8 = 1
            if (r2 == 0) goto L37
            if (r2 != r8) goto L2f
            kotlin.ResultKt.throwOnFailure(r0)
            goto L8e
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r20.getName()
            java.lang.String r2 = r20.getId()
            long r3 = r20.getLastUpdated()
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
            java.lang.String r4 = r19.getContactId()
            if (r4 != 0) goto L52
            java.lang.String r4 = ""
        L52:
            android.net.Uri r5 = r19.getUri()
            java.lang.String r5 = r5.toString()
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2, r3, r4, r5}
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r0)
            r16 = 62
            r17 = 0
            java.lang.String r10 = ":"
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r2 = kotlin.collections.CollectionsKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            kotlinx.coroutines.CoroutineDispatcher r9 = r1.dispatcher
            com.urbanairship.featureflag.FlagDeferredResolver$resolve$2 r10 = new com.urbanairship.featureflag.FlagDeferredResolver$resolve$2
            r5 = 0
            r0 = r10
            r1 = r18
            r3 = r19
            r4 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            r6.label = r8
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r9, r10, r6)
            if (r0 != r7) goto L8e
            return r7
        L8e:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.getValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FlagDeferredResolver.m2869resolve0E7RQCE(com.urbanairship.deferred.DeferredRequest, com.urbanairship.featureflag.FeatureFlagInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: resolve-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2868resolveBWLJW6A(com.urbanairship.deferred.DeferredRequest r12, com.urbanairship.featureflag.FeatureFlagInfo r13, java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FlagDeferredResolver.m2868resolveBWLJW6A(com.urbanairship.deferred.DeferredRequest, com.urbanairship.featureflag.FeatureFlagInfo, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(2:14|73)(2:15|16))(4:17|68|70|(1:72)(1:90)))(7:18|88|19|39|40|44|(2:46|47)(2:48|(2:50|51)(2:52|(3:54|(1:56)(1:57)|(4:74|(1:76)(1:77)|78|79)(2:62|(2:64|(1:66)(4:67|68|70|(0)(0)))(3:69|70|(0)(0))))(2:80|(2:82|83)(2:84|85))))))(1:23))(2:24|(3:26|(2:28|(1:30))(1:31)|32)(4:34|86|35|(1:37)(5:38|39|40|44|(0)(0))))|33|86|35|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
    
        r9 = r1;
        r1 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* renamed from: fetchFlag-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2867fetchFlagyxL6bBk(com.urbanairship.deferred.DeferredRequest r20, java.lang.String r21, com.urbanairship.featureflag.FeatureFlagInfo r22, boolean r23, kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FlagDeferredResolver.m2867fetchFlagyxL6bBk(com.urbanairship.deferred.DeferredRequest, java.lang.String, com.urbanairship.featureflag.FeatureFlagInfo, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
