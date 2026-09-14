package com.disney.p026id.android;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.tracker.EventAction;
import com.disney.p026id.android.tracker.Tracker;
import com.disney.p026id.android.tracker.TrackerEventKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, m1836d2 = {"Lcom/disney/id/android/PeriodicSCALPBundlerWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "initializationCallbackHolder", "Lcom/disney/id/android/InitializationCallbackHolder;", "getInitializationCallbackHolder$OneID_release", "()Lcom/disney/id/android/InitializationCallbackHolder;", "setInitializationCallbackHolder$OneID_release", "(Lcom/disney/id/android/InitializationCallbackHolder;)V", "oneIDSCALPBundle", "Lcom/disney/id/android/SCALPBundle;", "getOneIDSCALPBundle$OneID_release", "()Lcom/disney/id/android/SCALPBundle;", "setOneIDSCALPBundle$OneID_release", "(Lcom/disney/id/android/SCALPBundle;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class PeriodicSCALPBundlerWorker extends CoroutineWorker {

    @Inject
    public InitializationCallbackHolder initializationCallbackHolder;

    @Inject
    public SCALPBundle oneIDSCALPBundle;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodicSCALPBundlerWorker(@NotNull Context appContext, @NotNull WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @NotNull
    public final InitializationCallbackHolder getInitializationCallbackHolder$OneID_release() {
        InitializationCallbackHolder initializationCallbackHolder = this.initializationCallbackHolder;
        if (initializationCallbackHolder != null) {
            return initializationCallbackHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initializationCallbackHolder");
        return null;
    }

    public final void setInitializationCallbackHolder$OneID_release(@NotNull InitializationCallbackHolder initializationCallbackHolder) {
        Intrinsics.checkNotNullParameter(initializationCallbackHolder, "<set-?>");
        this.initializationCallbackHolder = initializationCallbackHolder;
    }

    @NotNull
    public final SCALPBundle getOneIDSCALPBundle$OneID_release() {
        SCALPBundle sCALPBundle = this.oneIDSCALPBundle;
        if (sCALPBundle != null) {
            return sCALPBundle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIDSCALPBundle");
        return null;
    }

    public final void setOneIDSCALPBundle$OneID_release(@NotNull SCALPBundle sCALPBundle) {
        Intrinsics.checkNotNullParameter(sCALPBundle, "<set-?>");
        this.oneIDSCALPBundle = sCALPBundle;
    }

    /* JADX INFO: renamed from: com.disney.id.android.PeriodicSCALPBundlerWorker$doWork$2 */
    static final class C30052 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C30052(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PeriodicSCALPBundlerWorker.this.new C30052(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C30052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0085  */
        /* JADX WARN: Code duplicated, block: B:30:0x008a  */
        /* JADX WARN: Code duplicated, block: B:32:0x0090  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ConfigData configData;
            TrackerEventKey trackerEventKey;
            ListenableWorker.Result resultFailure;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Tracker tracker$OneID_release = PeriodicSCALPBundlerWorker.this.getTracker$OneID_release();
                    TrackerEventKey trackerEventKey2 = PeriodicSCALPBundlerWorker.this.getInitializationCallbackHolder$OneID_release().getTrackerEventKey();
                    TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(tracker$OneID_release, trackerEventKey2 != null ? trackerEventKey2.getId() : null, EventAction.LOG_GET_CONFIG_DATA, PeriodicSCALPBundlerWorker.this.getSwid$OneID_release().get(), "from(periodicworker)", null, 16, null);
                    SCALPBundle oneIDSCALPBundle$OneID_release = PeriodicSCALPBundlerWorker.this.getOneIDSCALPBundle$OneID_release();
                    this.L$0 = trackerEventKeyStartConversationEvent$default;
                    this.label = 1;
                    obj = oneIDSCALPBundle$OneID_release.loadSCALP(trackerEventKeyStartConversationEvent$default, this);
                    i = trackerEventKeyStartConversationEvent$default;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i == 1) {
                        TrackerEventKey trackerEventKey3 = (TrackerEventKey) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = trackerEventKey3;
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        resultFailure = ListenableWorker.Result.success();
                    } else {
                        resultFailure = ListenableWorker.Result.failure();
                    }
                    if (resultFailure == null) {
                        resultFailure = ListenableWorker.Result.failure();
                    }
                    Intrinsics.checkNotNull(resultFailure);
                    return resultFailure;
                }
                configData = (ConfigData) obj;
                trackerEventKey = i;
            } catch (Throwable unused) {
                configData = null;
                trackerEventKey = i;
            }
            if (configData != null) {
                SCALPBundle oneIDSCALPBundle$OneID_release2 = PeriodicSCALPBundlerWorker.this.getOneIDSCALPBundle$OneID_release();
                this.L$0 = null;
                this.label = 2;
                obj = oneIDSCALPBundle$OneID_release2.initializeBundle(trackerEventKey, configData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) obj).booleanValue()) {
                    resultFailure = ListenableWorker.Result.success();
                } else {
                    resultFailure = ListenableWorker.Result.failure();
                }
                if (resultFailure == null) {
                    resultFailure = ListenableWorker.Result.failure();
                }
            } else {
                resultFailure = ListenableWorker.Result.failure();
            }
            Intrinsics.checkNotNull(resultFailure);
            return resultFailure;
        }
    }

    @Override // androidx.work.CoroutineWorker
    @Nullable
    public Object doWork(@NotNull Continuation<? super ListenableWorker.Result> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C30052(null), continuation);
    }
}
