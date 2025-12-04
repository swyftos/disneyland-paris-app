package com.disney.id.android;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.tracker.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/disney/id/android/PeriodicSCALPBundlerWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "initializationCallbackHolder", "Lcom/disney/id/android/InitializationCallbackHolder;", "getInitializationCallbackHolder$OneID_release", "()Lcom/disney/id/android/InitializationCallbackHolder;", "setInitializationCallbackHolder$OneID_release", "(Lcom/disney/id/android/InitializationCallbackHolder;)V", "oneIDSCALPBundle", "Lcom/disney/id/android/SCALPBundle;", "getOneIDSCALPBundle$OneID_release", "()Lcom/disney/id/android/SCALPBundle;", "setOneIDSCALPBundle$OneID_release", "(Lcom/disney/id/android/SCALPBundle;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: com.disney.id.android.PeriodicSCALPBundlerWorker$doWork$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PeriodicSCALPBundlerWorker.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
        /* JADX WARN: Type inference failed for: r14v13, types: [com.disney.id.android.SCALPBundle] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.disney.id.android.tracker.TrackerEventKey] */
        /* JADX WARN: Type inference failed for: r1v3, types: [com.disney.id.android.tracker.TrackerEventKey, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.disney.id.android.tracker.TrackerEventKey] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.disney.id.android.SCALPBundle] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r14)
                goto L7d
            L13:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L1b:
                java.lang.Object r1 = r13.L$0
                com.disney.id.android.tracker.TrackerEventKey r1 = (com.disney.id.android.tracker.TrackerEventKey) r1
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Throwable -> L69
                goto L66
            L23:
                kotlin.ResultKt.throwOnFailure(r14)
                com.disney.id.android.PeriodicSCALPBundlerWorker r14 = com.disney.id.android.PeriodicSCALPBundlerWorker.this
                com.disney.id.android.tracker.Tracker r5 = r14.getTracker$OneID_release()
                com.disney.id.android.PeriodicSCALPBundlerWorker r14 = com.disney.id.android.PeriodicSCALPBundlerWorker.this
                com.disney.id.android.InitializationCallbackHolder r14 = r14.getInitializationCallbackHolder$OneID_release()
                com.disney.id.android.tracker.TrackerEventKey r14 = r14.getTrackerEventKey()
                if (r14 == 0) goto L3e
                java.lang.String r14 = r14.getId()
                r6 = r14
                goto L3f
            L3e:
                r6 = r4
            L3f:
                com.disney.id.android.tracker.EventAction r7 = com.disney.id.android.tracker.EventAction.LOG_GET_CONFIG_DATA
                com.disney.id.android.PeriodicSCALPBundlerWorker r14 = com.disney.id.android.PeriodicSCALPBundlerWorker.this
                com.disney.id.android.SWID r14 = r14.getSwid$OneID_release()
                java.lang.String r8 = r14.get()
                r11 = 16
                r12 = 0
                java.lang.String r9 = "from(periodicworker)"
                r10 = 0
                com.disney.id.android.tracker.TrackerEventKey r1 = com.disney.id.android.tracker.Tracker.DefaultImpls.startConversationEvent$default(r5, r6, r7, r8, r9, r10, r11, r12)
                com.disney.id.android.PeriodicSCALPBundlerWorker r14 = com.disney.id.android.PeriodicSCALPBundlerWorker.this     // Catch: java.lang.Throwable -> L69
                com.disney.id.android.SCALPBundle r14 = r14.getOneIDSCALPBundle$OneID_release()     // Catch: java.lang.Throwable -> L69
                r13.L$0 = r1     // Catch: java.lang.Throwable -> L69
                r13.label = r3     // Catch: java.lang.Throwable -> L69
                java.lang.Object r14 = r14.loadSCALP(r1, r13)     // Catch: java.lang.Throwable -> L69
                if (r14 != r0) goto L66
                return r0
            L66:
                com.disney.id.android.ConfigData r14 = (com.disney.id.android.ConfigData) r14     // Catch: java.lang.Throwable -> L69
                goto L6a
            L69:
                r14 = r4
            L6a:
                if (r14 == 0) goto L90
                com.disney.id.android.PeriodicSCALPBundlerWorker r3 = com.disney.id.android.PeriodicSCALPBundlerWorker.this
                com.disney.id.android.SCALPBundle r3 = r3.getOneIDSCALPBundle$OneID_release()
                r13.L$0 = r4
                r13.label = r2
                java.lang.Object r14 = r3.initializeBundle(r1, r14, r13)
                if (r14 != r0) goto L7d
                return r0
            L7d:
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r13 = r14.booleanValue()
                if (r13 == 0) goto L8a
                androidx.work.ListenableWorker$Result r13 = androidx.work.ListenableWorker.Result.success()
                goto L8e
            L8a:
                androidx.work.ListenableWorker$Result r13 = androidx.work.ListenableWorker.Result.failure()
            L8e:
                if (r13 != 0) goto L94
            L90:
                androidx.work.ListenableWorker$Result r13 = androidx.work.ListenableWorker.Result.failure()
            L94:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.PeriodicSCALPBundlerWorker.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // androidx.work.CoroutineWorker
    @Nullable
    public Object doWork(@NotNull Continuation<? super ListenableWorker.Result> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(null), continuation);
    }
}
