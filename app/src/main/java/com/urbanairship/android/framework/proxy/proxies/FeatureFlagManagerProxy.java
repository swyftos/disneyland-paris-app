package com.urbanairship.android.framework.proxy.proxies;

import com.google.firebase.messaging.Constants;
import com.urbanairship.featureflag.FeatureFlag;
import com.urbanairship.featureflag.FeatureFlagManager;
import com.urbanairship.featureflag.FeatureFlagResultCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy;", "", "featureFlagManagerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/featureflag/FeatureFlagManager;", "(Lkotlin/jvm/functions/Function0;)V", "resultCache", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "getResultCache", "()Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "flag", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;", "name", "", "useResultCache", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInteraction", "", "ResultCacheProxy", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class FeatureFlagManagerProxy {
    private final Function0 featureFlagManagerProvider;
    private final ResultCacheProxy resultCache;

    /* JADX INFO: renamed from: com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$flag$1 */
    static final class C46941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C46941(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeatureFlagManagerProxy.this.flag(null, false, this);
        }
    }

    public FeatureFlagManagerProxy(@NotNull Function0<FeatureFlagManager> featureFlagManagerProvider) {
        Intrinsics.checkNotNullParameter(featureFlagManagerProvider, "featureFlagManagerProvider");
        this.featureFlagManagerProvider = featureFlagManagerProvider;
        this.resultCache = new ResultCacheProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$resultCache$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FeatureFlagResultCache invoke() {
                return ((FeatureFlagManager) this.this$0.featureFlagManagerProvider.invoke()).getResultCache();
            }
        });
    }

    @NotNull
    public final ResultCacheProxy getResultCache() {
        return this.resultCache;
    }

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "", "cacheProvider", "Lkotlin/Function0;", "Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "(Lkotlin/jvm/functions/Function0;)V", "cache", "", "flag", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "cache-8Mi8wO0", "(Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCachedFlag", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
    public static final class ResultCacheProxy {
        private final Function0 cacheProvider;

        public ResultCacheProxy(@NotNull Function0<FeatureFlagResultCache> cacheProvider) {
            Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
            this.cacheProvider = cacheProvider;
        }

        @Nullable
        /* JADX INFO: renamed from: cache-8Mi8wO0, reason: not valid java name */
        public final Object m4954cache8Mi8wO0(@NotNull FeatureFlagProxy featureFlagProxy, long j, @NotNull Continuation<? super Unit> continuation) {
            Object objM5105cache8Mi8wO0 = ((FeatureFlagResultCache) this.cacheProvider.invoke()).m5105cache8Mi8wO0(featureFlagProxy.getOriginal$airship_framework_proxy_release(), j, continuation);
            return objM5105cache8Mi8wO0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5105cache8Mi8wO0 : Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Nullable
        public final Object flag(@NotNull String str, @NotNull Continuation<? super FeatureFlagProxy> continuation) {
            FeatureFlagManagerProxy$ResultCacheProxy$flag$1 featureFlagManagerProxy$ResultCacheProxy$flag$1;
            if (continuation instanceof FeatureFlagManagerProxy$ResultCacheProxy$flag$1) {
                featureFlagManagerProxy$ResultCacheProxy$flag$1 = (FeatureFlagManagerProxy$ResultCacheProxy$flag$1) continuation;
                int i = featureFlagManagerProxy$ResultCacheProxy$flag$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    featureFlagManagerProxy$ResultCacheProxy$flag$1.label = i - Integer.MIN_VALUE;
                } else {
                    featureFlagManagerProxy$ResultCacheProxy$flag$1 = new FeatureFlagManagerProxy$ResultCacheProxy$flag$1(this, continuation);
                }
            } else {
                featureFlagManagerProxy$ResultCacheProxy$flag$1 = new FeatureFlagManagerProxy$ResultCacheProxy$flag$1(this, continuation);
            }
            Object objFlag = featureFlagManagerProxy$ResultCacheProxy$flag$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = featureFlagManagerProxy$ResultCacheProxy$flag$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFlag);
                FeatureFlagResultCache featureFlagResultCache = (FeatureFlagResultCache) this.cacheProvider.invoke();
                featureFlagManagerProxy$ResultCacheProxy$flag$1.label = 1;
                objFlag = featureFlagResultCache.flag(str, featureFlagManagerProxy$ResultCacheProxy$flag$1);
                if (objFlag == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objFlag);
            }
            FeatureFlag featureFlag = (FeatureFlag) objFlag;
            if (featureFlag != null) {
                return new FeatureFlagProxy(featureFlag);
            }
            return null;
        }

        @Nullable
        public final Object removeCachedFlag(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            Object objRemoveCachedFlag = ((FeatureFlagResultCache) this.cacheProvider.invoke()).removeCachedFlag(str, continuation);
            return objRemoveCachedFlag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRemoveCachedFlag : Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object flag$default(FeatureFlagManagerProxy featureFlagManagerProxy, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return featureFlagManagerProxy.flag(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object flag(@NotNull String str, boolean z, @NotNull Continuation<? super FeatureFlagProxy> continuation) {
        C46941 c46941;
        Object objM5104flag0E7RQCE;
        if (continuation instanceof C46941) {
            c46941 = (C46941) continuation;
            int i = c46941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c46941.label = i - Integer.MIN_VALUE;
            } else {
                c46941 = new C46941(continuation);
            }
        } else {
            c46941 = new C46941(continuation);
        }
        Object obj = c46941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c46941.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagManager featureFlagManager = (FeatureFlagManager) this.featureFlagManagerProvider.invoke();
            c46941.label = 1;
            objM5104flag0E7RQCE = featureFlagManager.m5104flag0E7RQCE(str, z, c46941);
            if (objM5104flag0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM5104flag0E7RQCE = ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(objM5104flag0E7RQCE);
        return new FeatureFlagProxy((FeatureFlag) objM5104flag0E7RQCE);
    }

    public final void trackInteraction(@NotNull FeatureFlagProxy flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        ((FeatureFlagManager) this.featureFlagManagerProvider.invoke()).trackInteraction(flag.getOriginal$airship_framework_proxy_release());
    }
}
