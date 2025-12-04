package com.urbanairship.remotedata;

import com.facebook.hermes.intl.Constants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PrivacyManager;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.remotedata.RemoteDataProvider;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataRefreshManager;", "", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "providers", "", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "(Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/PrivacyManager;Ljava/util/List;)V", "_refreshFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lcom/urbanairship/remotedata/RemoteDataSource;", "Lcom/urbanairship/remotedata/RemoteDataProvider$RefreshResult;", "getProviders", "()Ljava/util/List;", "refreshFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getRefreshFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "refreshPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispatchRefreshJob", "", "performRefresh", "Lcom/urbanairship/job/JobResult;", "changeToken", "", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "(Ljava/lang/String;Ljava/util/Locale;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoteDataRefreshManager {
    private final MutableSharedFlow _refreshFlow;
    private final JobDispatcher jobDispatcher;
    private final PrivacyManager privacyManager;
    private final List providers;
    private final SharedFlow refreshFlow;
    private final AtomicBoolean refreshPending;

    public RemoteDataRefreshManager(@NotNull JobDispatcher jobDispatcher, @NotNull PrivacyManager privacyManager, @NotNull List<? extends RemoteDataProvider> providers) {
        Intrinsics.checkNotNullParameter(jobDispatcher, "jobDispatcher");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.jobDispatcher = jobDispatcher;
        this.privacyManager = privacyManager;
        this.providers = providers;
        this.refreshPending = new AtomicBoolean(false);
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._refreshFlow = mutableSharedFlowMutableSharedFlow$default;
        this.refreshFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @NotNull
    public final List<RemoteDataProvider> getProviders() {
        return this.providers;
    }

    @NotNull
    public final SharedFlow<Pair<RemoteDataSource, RemoteDataProvider.RefreshResult>> getRefreshFlow() {
        return this.refreshFlow;
    }

    /* renamed from: com.urbanairship.remotedata.RemoteDataRefreshManager$performRefresh$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $changeToken;
        final /* synthetic */ Locale $locale;
        final /* synthetic */ int $randomValue;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Locale locale, int i, Continuation continuation) {
            super(2, continuation);
            this.$changeToken = str;
            this.$locale = locale;
            this.$randomValue = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = RemoteDataRefreshManager.this.new AnonymousClass2(this.$changeToken, this.$locale, this.$randomValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2b
                if (r2 == r4) goto L1f
                if (r2 != r3) goto L17
                kotlin.ResultKt.throwOnFailure(r19)
                r0 = r19
                goto Lcb
            L17:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1f:
                java.lang.Object r2 = r0.L$1
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r3 = r0.L$0
                com.urbanairship.remotedata.RemoteDataRefreshManager r3 = (com.urbanairship.remotedata.RemoteDataRefreshManager) r3
                kotlin.ResultKt.throwOnFailure(r19)
                goto L4a
            L2b:
                kotlin.ResultKt.throwOnFailure(r19)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                com.urbanairship.remotedata.RemoteDataRefreshManager r5 = com.urbanairship.remotedata.RemoteDataRefreshManager.this
                com.urbanairship.PrivacyManager r5 = com.urbanairship.remotedata.RemoteDataRefreshManager.access$getPrivacyManager$p(r5)
                boolean r5 = r5.isAnyFeatureEnabled$urbanairship_core_release(r4)
                if (r5 != 0) goto L75
                com.urbanairship.remotedata.RemoteDataRefreshManager r2 = com.urbanairship.remotedata.RemoteDataRefreshManager.this
                java.util.List r2 = r2.getProviders()
                com.urbanairship.remotedata.RemoteDataRefreshManager r3 = com.urbanairship.remotedata.RemoteDataRefreshManager.this
                java.util.Iterator r2 = r2.iterator()
            L4a:
                boolean r5 = r2.hasNext()
                if (r5 == 0) goto L72
                java.lang.Object r5 = r2.next()
                com.urbanairship.remotedata.RemoteDataProvider r5 = (com.urbanairship.remotedata.RemoteDataProvider) r5
                kotlinx.coroutines.flow.MutableSharedFlow r6 = com.urbanairship.remotedata.RemoteDataRefreshManager.access$get_refreshFlow$p(r3)
                kotlin.Pair r7 = new kotlin.Pair
                com.urbanairship.remotedata.RemoteDataSource r5 = r5.getSource()
                com.urbanairship.remotedata.RemoteDataProvider$RefreshResult r8 = com.urbanairship.remotedata.RemoteDataProvider.RefreshResult.SKIPPED
                r7.<init>(r5, r8)
                r0.L$0 = r3
                r0.L$1 = r2
                r0.label = r4
                java.lang.Object r5 = r6.emit(r7, r0)
                if (r5 != r1) goto L4a
                return r1
            L72:
                com.urbanairship.job.JobResult r0 = com.urbanairship.job.JobResult.SUCCESS
                return r0
            L75:
                com.urbanairship.remotedata.RemoteDataRefreshManager r4 = com.urbanairship.remotedata.RemoteDataRefreshManager.this
                java.util.List r4 = r4.getProviders()
                java.lang.String r12 = r0.$changeToken
                java.util.Locale r13 = r0.$locale
                int r14 = r0.$randomValue
                com.urbanairship.remotedata.RemoteDataRefreshManager r15 = com.urbanairship.remotedata.RemoteDataRefreshManager.this
                java.util.ArrayList r11 = new java.util.ArrayList
                r5 = 10
                int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r5)
                r11.<init>(r5)
                java.util.Iterator r4 = r4.iterator()
            L92:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto Lc0
                java.lang.Object r5 = r4.next()
                r6 = r5
                com.urbanairship.remotedata.RemoteDataProvider r6 = (com.urbanairship.remotedata.RemoteDataProvider) r6
                com.urbanairship.remotedata.RemoteDataRefreshManager$performRefresh$2$result$1$1 r16 = new com.urbanairship.remotedata.RemoteDataRefreshManager$performRefresh$2$result$1$1
                r17 = 0
                r5 = r16
                r7 = r12
                r8 = r13
                r9 = r14
                r10 = r15
                r3 = r11
                r11 = r17
                r5.<init>(r6, r7, r8, r9, r10, r11)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                r5 = r2
                r8 = r16
                kotlinx.coroutines.Deferred r5 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
                r3.add(r5)
                r11 = r3
                r3 = 2
                goto L92
            Lc0:
                r5 = r3
                r3 = r11
                r0.label = r5
                java.lang.Object r0 = kotlinx.coroutines.AwaitKt.awaitAll(r3, r0)
                if (r0 != r1) goto Lcb
                return r1
            Lcb:
                java.util.List r0 = (java.util.List) r0
                com.urbanairship.remotedata.RemoteDataProvider$RefreshResult r1 = com.urbanairship.remotedata.RemoteDataProvider.RefreshResult.FAILED
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto Ld8
                com.urbanairship.job.JobResult r0 = com.urbanairship.job.JobResult.RETRY
                goto Lda
            Ld8:
                com.urbanairship.job.JobResult r0 = com.urbanairship.job.JobResult.SUCCESS
            Lda:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteDataRefreshManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    public final Object performRefresh(@NotNull String str, @NotNull Locale locale, int i, @NotNull Continuation<? super JobResult> continuation) {
        this.refreshPending.set(false);
        return BuildersKt.withContext(AirshipDispatchers.INSTANCE.getIO(), new AnonymousClass2(str, locale, i, null), continuation);
    }

    public final void dispatchRefreshJob() {
        if (this.refreshPending.compareAndSet(false, true)) {
            JobInfo jobInfoBuild = JobInfo.newBuilder().setAction(RemoteData.ACTION_REFRESH).setNetworkAccessRequired(true).setAirshipComponent(RemoteData.class).setConflictStrategy(0).build();
            Intrinsics.checkNotNullExpressionValue(jobInfoBuild, "build(...)");
            this.jobDispatcher.dispatch(jobInfoBuild);
        }
    }
}
