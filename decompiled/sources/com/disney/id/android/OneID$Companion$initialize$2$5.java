package com.disney.id.android;

import com.disney.id.android.SCALPBundle;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneID$Companion$initialize$2$5 extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.BooleanRef $delayWorker;
    final /* synthetic */ TrackerEventKey $initializationEventKey;
    final /* synthetic */ OneID $this_apply;
    final /* synthetic */ TrackerEventKey $transactionEventKey;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$2$5(OneID oneID, TrackerEventKey trackerEventKey, TrackerEventKey trackerEventKey2, Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.$this_apply = oneID;
        this.$transactionEventKey = trackerEventKey;
        this.$initializationEventKey = trackerEventKey2;
        this.$delayWorker = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneID$Companion$initialize$2$5(this.$this_apply, this.$transactionEventKey, this.$initializationEventKey, this.$delayWorker, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$2$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Bundler.DefaultImpls.initialize$default(this.$this_apply.getBundler$OneID_release(), this.$transactionEventKey.getId(), this.$this_apply.getScalpController$OneID_release().getBundleVersion(), this.$this_apply.getScalpController$OneID_release().getBundlerURL(), null, 8, null);
            if (this.$this_apply.getBundler$OneID_release().hasBundle()) {
                OneIDTrackerEvent event = this.$this_apply.getTracker$OneID_release().getEvent(this.$initializationEventKey);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "bundle(cached)", 3, null);
                }
                CoroutineContext coroutineContext = OneID.INSTANCE.getMainScope().getCoroutineContext();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delayWorker, this.$this_apply, this.$transactionEventKey, null);
                this.label = 1;
                if (BuildersKt.withContext(coroutineContext, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Tracker.DefaultImpls.finishEvent$default(this.$this_apply.getTracker$OneID_release(), this.$transactionEventKey, false, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "missing(bundle)", false, 32, null);
                this.$delayWorker.element = false;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$this_apply.startPeriodicWorker$OneID_release(this.$delayWorker.element);
        return Unit.INSTANCE;
    }

    /* renamed from: com.disney.id.android.OneID$Companion$initialize$2$5$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.BooleanRef $delayWorker;
        final /* synthetic */ OneID $this_apply;
        final /* synthetic */ TrackerEventKey $transactionEventKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, OneID oneID, TrackerEventKey trackerEventKey, Continuation continuation) {
            super(2, continuation);
            this.$delayWorker = booleanRef;
            this.$this_apply = oneID;
            this.$transactionEventKey = trackerEventKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$delayWorker, this.$this_apply, this.$transactionEventKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$delayWorker.element = SCALPBundle.DefaultImpls.loadBundleIntoWebview$default(this.$this_apply.getScalpBundleDownloader$OneID_release(), this.$transactionEventKey, false, false, 6, null);
            return Unit.INSTANCE;
        }
    }
}
