package com.urbanairship.remotedata;

import com.facebook.hermes.intl.Constants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PrivacyManager;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m1836d2 = {"Lcom/urbanairship/remotedata/RemoteDataRefreshManager;", "", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "providers", "", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "(Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/PrivacyManager;Ljava/util/List;)V", "_refreshFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lcom/urbanairship/remotedata/RemoteDataSource;", "Lcom/urbanairship/remotedata/RemoteDataProvider$RefreshResult;", "getProviders", "()Ljava/util/List;", "refreshFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getRefreshFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "refreshPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispatchRefreshJob", "", "performRefresh", "Lcom/urbanairship/job/JobResult;", "changeToken", "", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "(Ljava/lang/String;Ljava/util/Locale;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    /* JADX INFO: renamed from: com.urbanairship.remotedata.RemoteDataRefreshManager$performRefresh$2 */
    static final class C58692 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $changeToken;
        final /* synthetic */ Locale $locale;
        final /* synthetic */ int $randomValue;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C58692(String str, Locale locale, int i, Continuation continuation) {
            super(2, continuation);
            this.$changeToken = str;
            this.$locale = locale;
            this.$randomValue = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C58692 c58692 = RemoteDataRefreshManager.this.new C58692(this.$changeToken, this.$locale, this.$randomValue, continuation);
            c58692.L$0 = obj;
            return c58692;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C58692) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0050  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:32:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:13:0x004a->B:35:?, LOOP_END, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objAwaitAll;
            RemoteDataRefreshManager remoteDataRefreshManager;
            Iterator it;
            MutableSharedFlow mutableSharedFlow;
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 2;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objAwaitAll = obj;
                    if (((List) objAwaitAll).contains(RemoteDataProvider.RefreshResult.FAILED)) {
                        return JobResult.RETRY;
                    }
                    return JobResult.SUCCESS;
                }
                it = (Iterator) this.L$1;
                remoteDataRefreshManager = (RemoteDataRefreshManager) this.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    RemoteDataProvider remoteDataProvider = (RemoteDataProvider) it.next();
                    mutableSharedFlow = remoteDataRefreshManager._refreshFlow;
                    pair = new Pair(remoteDataProvider.getSource(), RemoteDataProvider.RefreshResult.SKIPPED);
                    this.L$0 = remoteDataRefreshManager;
                    this.L$1 = it;
                    this.label = 1;
                    if (mutableSharedFlow.emit(pair, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return JobResult.SUCCESS;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (!RemoteDataRefreshManager.this.privacyManager.isAnyFeatureEnabled$urbanairship_core_release(true)) {
                List<RemoteDataProvider> providers = RemoteDataRefreshManager.this.getProviders();
                remoteDataRefreshManager = RemoteDataRefreshManager.this;
                it = providers.iterator();
                while (it.hasNext()) {
                    RemoteDataProvider remoteDataProvider2 = (RemoteDataProvider) it.next();
                    mutableSharedFlow = remoteDataRefreshManager._refreshFlow;
                    pair = new Pair(remoteDataProvider2.getSource(), RemoteDataProvider.RefreshResult.SKIPPED);
                    this.L$0 = remoteDataRefreshManager;
                    this.L$1 = it;
                    this.label = 1;
                    if (mutableSharedFlow.emit(pair, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return JobResult.SUCCESS;
            }
            List<RemoteDataProvider> providers2 = RemoteDataRefreshManager.this.getProviders();
            String str = this.$changeToken;
            Locale locale = this.$locale;
            int i3 = this.$randomValue;
            RemoteDataRefreshManager remoteDataRefreshManager2 = RemoteDataRefreshManager.this;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(providers2, 10));
            Iterator<T> it2 = providers2.iterator();
            while (it2.hasNext()) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteDataRefreshManager$performRefresh$2$result$1$1((RemoteDataProvider) it2.next(), str, locale, i3, remoteDataRefreshManager2, null), 3, null));
                arrayList = arrayList2;
                i2 = 2;
            }
            this.label = i2;
            objAwaitAll = AwaitKt.awaitAll(arrayList, this);
            if (objAwaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((List) objAwaitAll).contains(RemoteDataProvider.RefreshResult.FAILED)) {
                return JobResult.RETRY;
            }
            return JobResult.SUCCESS;
        }
    }

    @Nullable
    public final Object performRefresh(@NotNull String str, @NotNull Locale locale, int i, @NotNull Continuation<? super JobResult> continuation) {
        this.refreshPending.set(false);
        return BuildersKt.withContext(AirshipDispatchers.INSTANCE.getIO(), new C58692(str, locale, i, null), continuation);
    }

    public final void dispatchRefreshJob() {
        if (this.refreshPending.compareAndSet(false, true)) {
            JobInfo jobInfoBuild = JobInfo.newBuilder().setAction(RemoteData.ACTION_REFRESH).setNetworkAccessRequired(true).setAirshipComponent(RemoteData.class).setConflictStrategy(0).build();
            Intrinsics.checkNotNullExpressionValue(jobInfoBuild, "build(...)");
            this.jobDispatcher.dispatch(jobInfoBuild);
        }
    }
}
