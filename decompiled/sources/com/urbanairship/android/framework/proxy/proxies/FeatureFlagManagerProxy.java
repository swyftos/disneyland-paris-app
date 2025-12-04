package com.urbanairship.android.framework.proxy.proxies;

import com.google.firebase.messaging.Constants;
import com.urbanairship.featureflag.FeatureFlagManager;
import com.urbanairship.featureflag.FeatureFlagResultCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy;", "", "featureFlagManagerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/featureflag/FeatureFlagManager;", "(Lkotlin/jvm/functions/Function0;)V", "resultCache", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "getResultCache", "()Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "flag", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;", "name", "", "useResultCache", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInteraction", "", "ResultCacheProxy", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureFlagManagerProxy {
    private final Function0 featureFlagManagerProvider;
    private final ResultCacheProxy resultCache;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$flag$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
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

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy;", "", "cacheProvider", "Lkotlin/Function0;", "Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "(Lkotlin/jvm/functions/Function0;)V", "cache", "", "flag", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "cache-8Mi8wO0", "(Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCachedFlag", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy$ResultCacheProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
    public static final class ResultCacheProxy {
        private final Function0 cacheProvider;

        public ResultCacheProxy(@NotNull Function0<FeatureFlagResultCache> cacheProvider) {
            Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
            this.cacheProvider = cacheProvider;
        }

        @Nullable
        /* renamed from: cache-8Mi8wO0, reason: not valid java name */
        public final Object m2712cache8Mi8wO0(@NotNull FeatureFlagProxy featureFlagProxy, long j, @NotNull Continuation<? super Unit> continuation) {
            Object objM2863cache8Mi8wO0 = ((FeatureFlagResultCache) this.cacheProvider.invoke()).m2863cache8Mi8wO0(featureFlagProxy.getOriginal$airship_framework_proxy_release(), j, continuation);
            return objM2863cache8Mi8wO0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2863cache8Mi8wO0 : Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object flag(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$ResultCacheProxy$flag$1
                if (r0 == 0) goto L13
                r0 = r6
                com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$ResultCacheProxy$flag$1 r0 = (com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$ResultCacheProxy$flag$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$ResultCacheProxy$flag$1 r0 = new com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$ResultCacheProxy$flag$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r6)
                goto L45
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlin.jvm.functions.Function0 r4 = r4.cacheProvider
                java.lang.Object r4 = r4.invoke()
                com.urbanairship.featureflag.FeatureFlagResultCache r4 = (com.urbanairship.featureflag.FeatureFlagResultCache) r4
                r0.label = r3
                java.lang.Object r6 = r4.flag(r5, r0)
                if (r6 != r1) goto L45
                return r1
            L45:
                com.urbanairship.featureflag.FeatureFlag r6 = (com.urbanairship.featureflag.FeatureFlag) r6
                if (r6 == 0) goto L4f
                com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy r4 = new com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy
                r4.<init>(r6)
                goto L50
            L4f:
                r4 = 0
            L50:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy.ResultCacheProxy.flag(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object flag(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$flag$1 r0 = (com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$flag$1 r0 = new com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy$flag$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.getValue()
            goto L4b
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.functions.Function0 r4 = r4.featureFlagManagerProvider
            java.lang.Object r4 = r4.invoke()
            com.urbanairship.featureflag.FeatureFlagManager r4 = (com.urbanairship.featureflag.FeatureFlagManager) r4
            r0.label = r3
            java.lang.Object r4 = r4.m2862flag0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L4b
            return r1
        L4b:
            kotlin.ResultKt.throwOnFailure(r4)
            com.urbanairship.featureflag.FeatureFlag r4 = (com.urbanairship.featureflag.FeatureFlag) r4
            com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy r5 = new com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy.flag(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void trackInteraction(@NotNull FeatureFlagProxy flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        ((FeatureFlagManager) this.featureFlagManagerProvider.invoke()).trackInteraction(flag.getOriginal$airship_framework_proxy_release());
    }
}
