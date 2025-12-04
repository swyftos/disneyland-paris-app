package com.disney.id.android;

import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.TrackerEventKey;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneID$Companion$initialize$2$6 extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.BooleanRef $delayWorker;
    final /* synthetic */ TrackerEventKey $initializationEventKey;
    final /* synthetic */ OneID $this_apply;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$2$6(OneID oneID, TrackerEventKey trackerEventKey, Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.$this_apply = oneID;
        this.$initializationEventKey = trackerEventKey;
        this.$delayWorker = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneID$Companion$initialize$2$6(this.$this_apply, this.$initializationEventKey, this.$delayWorker, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$2$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConfigData configData;
        Ref.BooleanRef booleanRef;
        boolean zBooleanValue;
        Ref.BooleanRef booleanRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Logger logger$OneID_release = this.$this_apply.getLogger$OneID_release();
            String str = OneID.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            logger$OneID_release.e(str, "SCALP refresh failed", th);
            configData = null;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SCALPBundle scalpBundleDownloader$OneID_release = this.$this_apply.getScalpBundleDownloader$OneID_release();
            TrackerEventKey trackerEventKey = this.$initializationEventKey;
            this.label = 1;
            obj = scalpBundleDownloader$OneID_release.loadSCALP(trackerEventKey, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef2 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
                booleanRef = booleanRef2;
                booleanRef.element = zBooleanValue;
                this.$this_apply.startPeriodicWorker$OneID_release(this.$delayWorker.element);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        configData = (ConfigData) obj;
        booleanRef = this.$delayWorker;
        if (configData == null) {
            zBooleanValue = false;
            booleanRef.element = zBooleanValue;
            this.$this_apply.startPeriodicWorker$OneID_release(this.$delayWorker.element);
            return Unit.INSTANCE;
        }
        SCALPBundle scalpBundleDownloader$OneID_release2 = this.$this_apply.getScalpBundleDownloader$OneID_release();
        TrackerEventKey trackerEventKey2 = this.$initializationEventKey;
        this.L$0 = booleanRef;
        this.label = 2;
        obj = scalpBundleDownloader$OneID_release2.initializeBundle(trackerEventKey2, configData, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        booleanRef2 = booleanRef;
        zBooleanValue = ((Boolean) obj).booleanValue();
        booleanRef = booleanRef2;
        booleanRef.element = zBooleanValue;
        this.$this_apply.startPeriodicWorker$OneID_release(this.$delayWorker.element);
        return Unit.INSTANCE;
    }
}
