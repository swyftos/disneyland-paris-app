package com.urbanairship.featureflag;

import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.deferred.DeferredRequest;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.deferred.DeferredResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.util.Clock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.UComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0018H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\rH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m1836d2 = {"Lcom/urbanairship/featureflag/FlagDeferredResolver;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "resolver", "Lcom/urbanairship/deferred/DeferredResolver;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/cache/AirshipCache;Lcom/urbanairship/deferred/DeferredResolver;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "backOffIntervals", "", "", "", "pendingTasks", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "Lcom/urbanairship/featureflag/DeferredFlag;", "fetchFlag", "request", "Lcom/urbanairship/deferred/DeferredRequest;", "requestId", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "allowRetry", "", "fetchFlag-yxL6bBk", "(Lcom/urbanairship/deferred/DeferredRequest;Ljava/lang/String;Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "flagInfo", "resolve-0E7RQCE", "(Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/featureflag/FeatureFlagInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve-BWLJW6A", "(Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/featureflag/FeatureFlagInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/FlagDeferredResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n1#2:219\n*E\n"})
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

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    @Nullable
    /* JADX INFO: renamed from: resolve-0E7RQCE, reason: not valid java name */
    public final Object m5111resolve0E7RQCE(@NotNull DeferredRequest deferredRequest, @NotNull FeatureFlagInfo featureFlagInfo, @NotNull Continuation<? super Result<? extends DeferredFlag>> continuation) {
        FlagDeferredResolver$resolve$1 flagDeferredResolver$resolve$1;
        if (continuation instanceof FlagDeferredResolver$resolve$1) {
            flagDeferredResolver$resolve$1 = (FlagDeferredResolver$resolve$1) continuation;
            int i = flagDeferredResolver$resolve$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flagDeferredResolver$resolve$1.label = i - Integer.MIN_VALUE;
            } else {
                flagDeferredResolver$resolve$1 = new FlagDeferredResolver$resolve$1(this, continuation);
            }
        } else {
            flagDeferredResolver$resolve$1 = new FlagDeferredResolver$resolve$1(this, continuation);
        }
        FlagDeferredResolver$resolve$1 flagDeferredResolver$resolve$2 = flagDeferredResolver$resolve$1;
        Object objWithContext = flagDeferredResolver$resolve$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flagDeferredResolver$resolve$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            String name = featureFlagInfo.getName();
            String id = featureFlagInfo.getId();
            Long lBoxLong = Boxing.boxLong(featureFlagInfo.getLastUpdated());
            String contactId = deferredRequest.getContactId();
            if (contactId == null) {
                contactId = "";
            }
            String string = deferredRequest.getUri().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf(name, id, lBoxLong, contactId, string), ":", null, null, 0, null, null, 62, null);
            CoroutineDispatcher coroutineDispatcher = this.dispatcher;
            FlagDeferredResolver$resolve$2 flagDeferredResolver$resolve$3 = new FlagDeferredResolver$resolve$2(this, strJoinToString$default, deferredRequest, featureFlagInfo, null);
            flagDeferredResolver$resolve$2.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, flagDeferredResolver$resolve$3, flagDeferredResolver$resolve$2);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: resolve-BWLJW6A, reason: not valid java name */
    public final Object m5110resolveBWLJW6A(DeferredRequest deferredRequest, FeatureFlagInfo featureFlagInfo, String str, Continuation continuation) {
        FlagDeferredResolver$resolve$3 flagDeferredResolver$resolve$3;
        DeferredFlag deferredFlag;
        FlagDeferredResolver flagDeferredResolver;
        FeatureFlagInfo featureFlagInfo2;
        Object objM5109fetchFlagyxL6bBk;
        String str2;
        Object obj;
        ULong uLongM5090getTtl6VbMDqA;
        if (continuation instanceof FlagDeferredResolver$resolve$3) {
            flagDeferredResolver$resolve$3 = (FlagDeferredResolver$resolve$3) continuation;
            int i = flagDeferredResolver$resolve$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flagDeferredResolver$resolve$3.label = i - Integer.MIN_VALUE;
            } else {
                flagDeferredResolver$resolve$3 = new FlagDeferredResolver$resolve$3(this, continuation);
            }
        } else {
            flagDeferredResolver$resolve$3 = new FlagDeferredResolver$resolve$3(this, continuation);
        }
        Object cached = flagDeferredResolver$resolve$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flagDeferredResolver$resolve$3.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(cached);
                AirshipCache airshipCache = this.cache;
                FlagDeferredResolver$resolve$cached$1 flagDeferredResolver$resolve$cached$1 = new FlagDeferredResolver$resolve$cached$1(DeferredFlag.INSTANCE);
                flagDeferredResolver$resolve$3.L$0 = this;
                flagDeferredResolver$resolve$3.L$1 = deferredRequest;
                flagDeferredResolver$resolve$3.L$2 = featureFlagInfo;
                flagDeferredResolver$resolve$3.L$3 = str;
                flagDeferredResolver$resolve$3.label = 1;
                cached = airshipCache.getCached(str, flagDeferredResolver$resolve$cached$1, flagDeferredResolver$resolve$3);
                if (cached == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 == 1) {
                    str = (String) flagDeferredResolver$resolve$3.L$3;
                    featureFlagInfo = (FeatureFlagInfo) flagDeferredResolver$resolve$3.L$2;
                    deferredRequest = (DeferredRequest) flagDeferredResolver$resolve$3.L$1;
                    this = (FlagDeferredResolver) flagDeferredResolver$resolve$3.L$0;
                    ResultKt.throwOnFailure(cached);
                } else {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Object obj2 = flagDeferredResolver$resolve$3.L$0;
                        ResultKt.throwOnFailure(cached);
                        return obj2;
                    }
                    String str3 = (String) flagDeferredResolver$resolve$3.L$2;
                    featureFlagInfo2 = (FeatureFlagInfo) flagDeferredResolver$resolve$3.L$1;
                    flagDeferredResolver = (FlagDeferredResolver) flagDeferredResolver$resolve$3.L$0;
                    ResultKt.throwOnFailure(cached);
                    str2 = str3;
                    objM5109fetchFlagyxL6bBk = ((Result) cached).getValue();
                }
                if (Result.m5282isFailureimpl(objM5109fetchFlagyxL6bBk)) {
                    obj = null;
                } else {
                    obj = objM5109fetchFlagyxL6bBk;
                }
                DeferredFlag deferredFlag2 = (DeferredFlag) obj;
                if (!Result.m5283isSuccessimpl(objM5109fetchFlagyxL6bBk) && deferredFlag2 != null) {
                    EvaluationOptions evaluationOptions = featureFlagInfo2.getEvaluationOptions();
                    long j = 60000;
                    if (evaluationOptions != null && (uLongM5090getTtl6VbMDqA = evaluationOptions.m5090getTtl6VbMDqA()) != null) {
                        j = UComparisonsKt.m5662maxOfeb3DHEI(60000L, uLongM5090getTtl6VbMDqA.getData());
                    }
                    AirshipCache airshipCache2 = flagDeferredResolver.cache;
                    Duration.Companion companion = Duration.INSTANCE;
                    long duration = DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
                    flagDeferredResolver$resolve$3.L$0 = objM5109fetchFlagyxL6bBk;
                    flagDeferredResolver$resolve$3.L$1 = null;
                    flagDeferredResolver$resolve$3.L$2 = null;
                    flagDeferredResolver$resolve$3.label = 3;
                    return airshipCache2.m5067storeexY8QGI(deferredFlag2, str2, duration, flagDeferredResolver$resolve$3) == coroutine_suspended ? coroutine_suspended : objM5109fetchFlagyxL6bBk;
                }
            }
            deferredFlag = (DeferredFlag) cached;
        } catch (JsonException e) {
            UALog.m1757w(e, new Function0() { // from class: com.urbanairship.featureflag.FlagDeferredResolver$resolve$cached$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse cached deferred flag!";
                }
            });
            deferredFlag = null;
        }
        FeatureFlagInfo featureFlagInfo3 = featureFlagInfo;
        flagDeferredResolver = this;
        DeferredRequest deferredRequest2 = deferredRequest;
        featureFlagInfo2 = featureFlagInfo3;
        if (deferredFlag != null) {
            return Result.m5277constructorimpl(deferredFlag);
        }
        flagDeferredResolver$resolve$3.L$0 = flagDeferredResolver;
        flagDeferredResolver$resolve$3.L$1 = featureFlagInfo2;
        flagDeferredResolver$resolve$3.L$2 = str;
        flagDeferredResolver$resolve$3.L$3 = null;
        flagDeferredResolver$resolve$3.label = 2;
        objM5109fetchFlagyxL6bBk = flagDeferredResolver.m5109fetchFlagyxL6bBk(deferredRequest2, str, featureFlagInfo2, true, flagDeferredResolver$resolve$3);
        if (objM5109fetchFlagyxL6bBk == coroutine_suspended) {
            return coroutine_suspended;
        }
        str2 = str;
        if (Result.m5282isFailureimpl(objM5109fetchFlagyxL6bBk)) {
            obj = null;
        } else {
            obj = objM5109fetchFlagyxL6bBk;
        }
        DeferredFlag deferredFlag3 = (DeferredFlag) obj;
        return !Result.m5283isSuccessimpl(objM5109fetchFlagyxL6bBk) ? objM5109fetchFlagyxL6bBk : objM5109fetchFlagyxL6bBk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0102 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0103  */
    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0131  */
    /* JADX WARN: Code duplicated, block: B:52:0x013a  */
    /* JADX WARN: Code duplicated, block: B:54:0x013e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0146  */
    /* JADX WARN: Code duplicated, block: B:57:0x014b  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f  */
    /* JADX WARN: Code duplicated, block: B:72:0x018d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x01ac, please report this as an issue */
    /* JADX INFO: renamed from: fetchFlag-yxL6bBk, reason: not valid java name */
    public final Object m5109fetchFlagyxL6bBk(DeferredRequest deferredRequest, String str, FeatureFlagInfo featureFlagInfo, boolean z, Continuation continuation) {
        FlagDeferredResolver$fetchFlag$1 flagDeferredResolver$fetchFlag$1;
        FeatureFlagInfo featureFlagInfo2;
        boolean z2;
        FlagDeferredResolver flagDeferredResolver;
        DeferredRequest deferredRequest2;
        DeferredRequest deferredRequest3;
        String str2;
        boolean z3;
        FeatureFlagInfo featureFlagInfo3;
        DeferredRequest deferredRequest4;
        DeferredResult deferredResult;
        Long retryAfter;
        long jLongValue;
        String str3;
        String str4;
        FlagDeferredResolver flagDeferredResolver2;
        Object objM5109fetchFlagyxL6bBk;
        String str5 = str;
        if (continuation instanceof FlagDeferredResolver$fetchFlag$1) {
            flagDeferredResolver$fetchFlag$1 = (FlagDeferredResolver$fetchFlag$1) continuation;
            int i = flagDeferredResolver$fetchFlag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flagDeferredResolver$fetchFlag$1.label = i - Integer.MIN_VALUE;
            } else {
                flagDeferredResolver$fetchFlag$1 = new FlagDeferredResolver$fetchFlag$1(this, continuation);
            }
        } else {
            flagDeferredResolver$fetchFlag$1 = new FlagDeferredResolver$fetchFlag$1(this, continuation);
        }
        Object objResolve = flagDeferredResolver$fetchFlag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flagDeferredResolver$fetchFlag$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objResolve);
                Long l = (Long) this.backOffIntervals.get(str5);
                if (l != null) {
                    long jLongValue2 = l.longValue() - this.clock.currentTimeMillis();
                    if (jLongValue2 > 0) {
                        flagDeferredResolver$fetchFlag$1.L$0 = this;
                        deferredRequest3 = deferredRequest;
                        flagDeferredResolver$fetchFlag$1.L$1 = deferredRequest3;
                        flagDeferredResolver$fetchFlag$1.L$2 = str5;
                        featureFlagInfo2 = featureFlagInfo;
                        flagDeferredResolver$fetchFlag$1.L$3 = featureFlagInfo2;
                        z2 = z;
                        flagDeferredResolver$fetchFlag$1.Z$0 = z2;
                        flagDeferredResolver$fetchFlag$1.label = 1;
                        if (DelayKt.delay(jLongValue2, flagDeferredResolver$fetchFlag$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        deferredRequest3 = deferredRequest;
                        featureFlagInfo2 = featureFlagInfo;
                        z2 = z;
                    }
                    flagDeferredResolver = this;
                    deferredRequest2 = deferredRequest3;
                } else {
                    featureFlagInfo2 = featureFlagInfo;
                    z2 = z;
                    flagDeferredResolver = this;
                    deferredRequest2 = deferredRequest;
                }
                DeferredResolver deferredResolver = flagDeferredResolver.resolver;
                FlagDeferredResolver$fetchFlag$result$1 flagDeferredResolver$fetchFlag$result$1 = new FlagDeferredResolver$fetchFlag$result$1(DeferredFlagInfo.INSTANCE);
                flagDeferredResolver$fetchFlag$1.L$0 = flagDeferredResolver;
                flagDeferredResolver$fetchFlag$1.L$1 = deferredRequest2;
                flagDeferredResolver$fetchFlag$1.L$2 = str5;
                flagDeferredResolver$fetchFlag$1.L$3 = featureFlagInfo2;
                flagDeferredResolver$fetchFlag$1.Z$0 = z2;
                flagDeferredResolver$fetchFlag$1.label = 2;
                objResolve = deferredResolver.resolve(deferredRequest2, flagDeferredResolver$fetchFlag$result$1, flagDeferredResolver$fetchFlag$1);
                if (objResolve == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str5;
                z3 = z2;
                deferredResult = (DeferredResult) objResolve;
                featureFlagInfo3 = featureFlagInfo2;
                deferredRequest4 = deferredRequest2;
                if (deferredResult instanceof DeferredResult.Success) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m5277constructorimpl(new DeferredFlag.Found((DeferredFlagInfo) ((DeferredResult.Success) deferredResult).getResult()));
                }
                if (deferredResult instanceof DeferredResult.NotFound) {
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m5277constructorimpl(DeferredFlag.NotFound.INSTANCE);
                }
                if (deferredResult instanceof DeferredResult.RetriableError) {
                    DeferredResult.RetriableError retriableError = (DeferredResult.RetriableError) deferredResult;
                    retryAfter = retriableError.getRetryAfter();
                    if (retryAfter != null) {
                        jLongValue = retryAfter.longValue();
                    } else {
                        jLongValue = 30000;
                    }
                    if (z3) {
                    }
                    flagDeferredResolver.backOffIntervals.put(str2, Boxing.boxLong(flagDeferredResolver.clock.currentTimeMillis() + jLongValue));
                    Result.Companion companion3 = Result.INSTANCE;
                    Integer statusCode = retriableError.getStatusCode();
                    if (!z3) {
                        str3 = "Retries are not allowed";
                    } else {
                        str3 = "Unable to immediately retry. Try again in " + jLongValue + " ms.";
                    }
                    return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(statusCode, str3)));
                }
                if (deferredResult instanceof DeferredResult.OutOfDate) {
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.OutOfDate()));
                }
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(null, null, 3, null)));
            }
            if (i2 == 1) {
                boolean z4 = flagDeferredResolver$fetchFlag$1.Z$0;
                FeatureFlagInfo featureFlagInfo4 = (FeatureFlagInfo) flagDeferredResolver$fetchFlag$1.L$3;
                String str6 = (String) flagDeferredResolver$fetchFlag$1.L$2;
                deferredRequest2 = (DeferredRequest) flagDeferredResolver$fetchFlag$1.L$1;
                flagDeferredResolver = (FlagDeferredResolver) flagDeferredResolver$fetchFlag$1.L$0;
                ResultKt.throwOnFailure(objResolve);
                z2 = z4;
                featureFlagInfo2 = featureFlagInfo4;
                str5 = str6;
            } else {
                if (i2 == 2) {
                    z3 = flagDeferredResolver$fetchFlag$1.Z$0;
                    featureFlagInfo2 = (FeatureFlagInfo) flagDeferredResolver$fetchFlag$1.L$3;
                    str2 = (String) flagDeferredResolver$fetchFlag$1.L$2;
                    deferredRequest2 = (DeferredRequest) flagDeferredResolver$fetchFlag$1.L$1;
                    flagDeferredResolver = (FlagDeferredResolver) flagDeferredResolver$fetchFlag$1.L$0;
                    try {
                        ResultKt.throwOnFailure(objResolve);
                        deferredResult = (DeferredResult) objResolve;
                        featureFlagInfo3 = featureFlagInfo2;
                        deferredRequest4 = deferredRequest2;
                    } catch (JsonException e) {
                        e = e;
                        UALog.m1757w(e, new Function0() { // from class: com.urbanairship.featureflag.FlagDeferredResolver$fetchFlag$result$2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to parse resolved deferred flag info!";
                            }
                        });
                        featureFlagInfo3 = featureFlagInfo2;
                        deferredRequest4 = deferredRequest2;
                        deferredResult = null;
                    }
                    if (deferredResult instanceof DeferredResult.Success) {
                        Result.Companion companion6 = Result.INSTANCE;
                        return Result.m5277constructorimpl(new DeferredFlag.Found((DeferredFlagInfo) ((DeferredResult.Success) deferredResult).getResult()));
                    }
                    if (deferredResult instanceof DeferredResult.NotFound) {
                        Result.Companion companion7 = Result.INSTANCE;
                        return Result.m5277constructorimpl(DeferredFlag.NotFound.INSTANCE);
                    }
                    if (deferredResult instanceof DeferredResult.RetriableError) {
                        DeferredResult.RetriableError retriableError2 = (DeferredResult.RetriableError) deferredResult;
                        retryAfter = retriableError2.getRetryAfter();
                        if (retryAfter != null) {
                            jLongValue = retryAfter.longValue();
                        } else {
                            jLongValue = 30000;
                        }
                        if (z3 || jLongValue > 5000) {
                            flagDeferredResolver.backOffIntervals.put(str2, Boxing.boxLong(flagDeferredResolver.clock.currentTimeMillis() + jLongValue));
                            Result.Companion companion8 = Result.INSTANCE;
                            Integer statusCode2 = retriableError2.getStatusCode();
                            if (!z3) {
                                str3 = "Retries are not allowed";
                            } else {
                                str3 = "Unable to immediately retry. Try again in " + jLongValue + " ms.";
                            }
                            return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(statusCode2, str3)));
                        }
                        if (jLongValue > 0) {
                            flagDeferredResolver$fetchFlag$1.L$0 = flagDeferredResolver;
                            flagDeferredResolver$fetchFlag$1.L$1 = deferredRequest4;
                            flagDeferredResolver$fetchFlag$1.L$2 = str2;
                            flagDeferredResolver$fetchFlag$1.L$3 = featureFlagInfo3;
                            flagDeferredResolver$fetchFlag$1.label = 3;
                            if (DelayKt.delay(jLongValue, flagDeferredResolver$fetchFlag$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str4 = str2;
                            flagDeferredResolver2 = flagDeferredResolver;
                        } else {
                            str4 = str2;
                        }
                        flagDeferredResolver$fetchFlag$1.L$0 = null;
                        flagDeferredResolver$fetchFlag$1.L$1 = null;
                        flagDeferredResolver$fetchFlag$1.L$2 = null;
                        flagDeferredResolver$fetchFlag$1.L$3 = null;
                        flagDeferredResolver$fetchFlag$1.label = 4;
                        objM5109fetchFlagyxL6bBk = flagDeferredResolver.m5109fetchFlagyxL6bBk(deferredRequest4, str4, featureFlagInfo3, false, flagDeferredResolver$fetchFlag$1);
                        if (objM5109fetchFlagyxL6bBk == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objM5109fetchFlagyxL6bBk;
                    }
                    if (deferredResult instanceof DeferredResult.OutOfDate) {
                        Result.Companion companion9 = Result.INSTANCE;
                        return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.OutOfDate()));
                    }
                    Result.Companion companion10 = Result.INSTANCE;
                    return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(null, null, 3, null)));
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objResolve);
                    return ((Result) objResolve).getValue();
                }
                featureFlagInfo3 = (FeatureFlagInfo) flagDeferredResolver$fetchFlag$1.L$3;
                str4 = (String) flagDeferredResolver$fetchFlag$1.L$2;
                deferredRequest4 = (DeferredRequest) flagDeferredResolver$fetchFlag$1.L$1;
                flagDeferredResolver2 = (FlagDeferredResolver) flagDeferredResolver$fetchFlag$1.L$0;
                ResultKt.throwOnFailure(objResolve);
            }
            flagDeferredResolver = flagDeferredResolver2;
            flagDeferredResolver$fetchFlag$1.L$0 = null;
            flagDeferredResolver$fetchFlag$1.L$1 = null;
            flagDeferredResolver$fetchFlag$1.L$2 = null;
            flagDeferredResolver$fetchFlag$1.L$3 = null;
            flagDeferredResolver$fetchFlag$1.label = 4;
            objM5109fetchFlagyxL6bBk = flagDeferredResolver.m5109fetchFlagyxL6bBk(deferredRequest4, str4, featureFlagInfo3, false, flagDeferredResolver$fetchFlag$1);
            if (objM5109fetchFlagyxL6bBk == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objM5109fetchFlagyxL6bBk;
            DeferredResolver deferredResolver2 = flagDeferredResolver.resolver;
            FlagDeferredResolver$fetchFlag$result$1 flagDeferredResolver$fetchFlag$result$2 = new FlagDeferredResolver$fetchFlag$result$1(DeferredFlagInfo.INSTANCE);
            flagDeferredResolver$fetchFlag$1.L$0 = flagDeferredResolver;
            flagDeferredResolver$fetchFlag$1.L$1 = deferredRequest2;
            flagDeferredResolver$fetchFlag$1.L$2 = str5;
            flagDeferredResolver$fetchFlag$1.L$3 = featureFlagInfo2;
            flagDeferredResolver$fetchFlag$1.Z$0 = z2;
            flagDeferredResolver$fetchFlag$1.label = 2;
            objResolve = deferredResolver2.resolve(deferredRequest2, flagDeferredResolver$fetchFlag$result$2, flagDeferredResolver$fetchFlag$1);
            if (objResolve == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str5;
            z3 = z2;
            deferredResult = (DeferredResult) objResolve;
            featureFlagInfo3 = featureFlagInfo2;
            deferredRequest4 = deferredRequest2;
            if (deferredResult instanceof DeferredResult.Success) {
                Result.Companion companion11 = Result.INSTANCE;
                return Result.m5277constructorimpl(new DeferredFlag.Found((DeferredFlagInfo) ((DeferredResult.Success) deferredResult).getResult()));
            }
            if (deferredResult instanceof DeferredResult.NotFound) {
                Result.Companion companion12 = Result.INSTANCE;
                return Result.m5277constructorimpl(DeferredFlag.NotFound.INSTANCE);
            }
            if (deferredResult instanceof DeferredResult.RetriableError) {
                DeferredResult.RetriableError retriableError3 = (DeferredResult.RetriableError) deferredResult;
                retryAfter = retriableError3.getRetryAfter();
                if (retryAfter != null) {
                    jLongValue = retryAfter.longValue();
                } else {
                    jLongValue = 30000;
                }
                if (z3) {
                }
                flagDeferredResolver.backOffIntervals.put(str2, Boxing.boxLong(flagDeferredResolver.clock.currentTimeMillis() + jLongValue));
                Result.Companion companion13 = Result.INSTANCE;
                Integer statusCode3 = retriableError3.getStatusCode();
                if (!z3) {
                    str3 = "Retries are not allowed";
                } else {
                    str3 = "Unable to immediately retry. Try again in " + jLongValue + " ms.";
                }
                return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(statusCode3, str3)));
            }
            if (deferredResult instanceof DeferredResult.OutOfDate) {
                Result.Companion companion14 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.OutOfDate()));
            }
            Result.Companion companion15 = Result.INSTANCE;
            return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.ConnectionError(null, null, 3, null)));
        } catch (JsonException e2) {
            e = e2;
            str2 = str5;
            z3 = z2;
            UALog.m1757w(e, new Function0() { // from class: com.urbanairship.featureflag.FlagDeferredResolver$fetchFlag$result$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse resolved deferred flag info!";
                }
            });
            featureFlagInfo3 = featureFlagInfo2;
            deferredRequest4 = deferredRequest2;
            deferredResult = null;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
