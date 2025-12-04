package com.urbanairship.featureflag;

import androidx.annotation.RestrictTo;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "(Lcom/urbanairship/cache/AirshipCache;)V", "pendingResultScope", "Lkotlinx/coroutines/CoroutineScope;", "", "flag", "Lcom/urbanairship/featureflag/FeatureFlag;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "cache-8Mi8wO0", "(Lcom/urbanairship/featureflag/FeatureFlag;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheAsync", "ttlMilliseconds", "Lkotlin/ULong;", "cacheAsync-2TYgG_w", "(Lcom/urbanairship/featureflag/FeatureFlag;J)V", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagAsync", "Lcom/urbanairship/PendingResult;", "makeKey", "key", "removeCachedFlag", "removeCachedFlagAsync", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFlagResultCache {
    private final AirshipCache cache;
    private final CoroutineScope pendingResultScope;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FeatureFlagResultCache(@NotNull AirshipCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.pendingResultScope = CoroutineScopeKt.CoroutineScope(AirshipDispatchers.INSTANCE.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Nullable
    /* renamed from: cache-8Mi8wO0, reason: not valid java name */
    public final Object m2863cache8Mi8wO0(@NotNull FeatureFlag featureFlag, long j, @NotNull Continuation<? super Unit> continuation) {
        Object objM2825storeexY8QGI;
        String strMakeKey = makeKey(featureFlag.getName());
        return (strMakeKey != null && (objM2825storeexY8QGI = this.cache.m2825storeexY8QGI(featureFlag, strMakeKey, j, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objM2825storeexY8QGI : Unit.INSTANCE;
    }

    @Nullable
    public final Object flag(@NotNull String str, @NotNull Continuation<? super FeatureFlag> continuation) {
        String strMakeKey = makeKey(str);
        if (strMakeKey == null) {
            return null;
        }
        return this.cache.getCached(strMakeKey, new Function1() { // from class: com.urbanairship.featureflag.FeatureFlagResultCache.flag.2
            @Override // kotlin.jvm.functions.Function1
            public final FeatureFlag invoke(JsonValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return FeatureFlag.INSTANCE.fromJson(it);
            }
        }, continuation);
    }

    @Nullable
    public final Object removeCachedFlag(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objDelete;
        String strMakeKey = makeKey(str);
        return (strMakeKey != null && (objDelete = this.cache.delete(strMakeKey, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objDelete : Unit.INSTANCE;
    }

    /* renamed from: cacheAsync-2TYgG_w, reason: not valid java name */
    public final void m2864cacheAsync2TYgG_w(@NotNull FeatureFlag flag, long ttlMilliseconds) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new FeatureFlagResultCache$cacheAsync$1(this, flag, ttlMilliseconds, null), 3, null);
    }

    /* renamed from: com.urbanairship.featureflag.FeatureFlagResultCache$flagAsync$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ FeatureFlagResultCache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PendingResult pendingResult, FeatureFlagResultCache featureFlagResultCache, String str, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = featureFlagResultCache;
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$pendingResult, this.this$0, this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                FeatureFlagResultCache featureFlagResultCache = this.this$0;
                String str = this.$name;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objFlag = featureFlagResultCache.flag(str, this);
                if (objFlag == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objFlag;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<FeatureFlag> flagAsync(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PendingResult<FeatureFlag> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new AnonymousClass1(pendingResult, this, name, null), 3, null);
        return pendingResult;
    }

    /* renamed from: com.urbanairship.featureflag.FeatureFlagResultCache$removeCachedFlagAsync$1, reason: invalid class name and case insensitive filesystem */
    static final class C11281 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11281(String str, Continuation continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FeatureFlagResultCache.this.new C11281(this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FeatureFlagResultCache featureFlagResultCache = FeatureFlagResultCache.this;
                String str = this.$name;
                this.label = 1;
                if (featureFlagResultCache.removeCachedFlag(str, this) == coroutine_suspended) {
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

    public final void removeCachedFlagAsync(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C11281(name, null), 3, null);
    }

    private final String makeKey(String key) {
        if (key.length() == 0) {
            return null;
        }
        return "FeatureFlagResultCache:" + key;
    }
}
