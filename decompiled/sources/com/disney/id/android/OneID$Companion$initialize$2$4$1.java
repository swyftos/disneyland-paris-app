package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.tracker.TrackerEventKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneID$Companion$initialize$2$4$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ OneIDListener $delegate;
    final /* synthetic */ String $email;
    final /* synthetic */ TrackerEventKey $initializationEventKey;
    final /* synthetic */ Ref.BooleanRef $scalpBundleRefreshed;
    final /* synthetic */ OneID $this_apply;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$2$4$1(OneID oneID, TrackerEventKey trackerEventKey, Context context, String str, OneIDListener oneIDListener, Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.$this_apply = oneID;
        this.$initializationEventKey = trackerEventKey;
        this.$context = context;
        this.$email = str;
        this.$delegate = oneIDListener;
        this.$scalpBundleRefreshed = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneID$Companion$initialize$2$4$1(this.$this_apply, this.$initializationEventKey, this.$context, this.$email, this.$delegate, this.$scalpBundleRefreshed, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$2$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0124  */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.disney.id.android.SCALPBundle] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.disney.id.android.tracker.TrackerEventKey] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.disney.id.android.tracker.TrackerEventKey] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.disney.id.android.tracker.TrackerEventKey, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.disney.id.android.SCALPBundle] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneID$Companion$initialize$2$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
