package expo.modules.core.logging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class PersistentFileLogSerialDispatchQueue$queueRunner$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ PersistentFileLogSerialDispatchQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PersistentFileLogSerialDispatchQueue$queueRunner$1(PersistentFileLogSerialDispatchQueue persistentFileLogSerialDispatchQueue, Continuation continuation) {
        super(2, continuation);
        this.this$0 = persistentFileLogSerialDispatchQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PersistentFileLogSerialDispatchQueue$queueRunner$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PersistentFileLogSerialDispatchQueue$queueRunner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:12:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r4)
            goto L29
        Lf:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L17:
            kotlin.ResultKt.throwOnFailure(r4)
        L1a:
            expo.modules.core.logging.PersistentFileLogSerialDispatchQueue r4 = r3.this$0
            kotlinx.coroutines.channels.Channel r4 = expo.modules.core.logging.PersistentFileLogSerialDispatchQueue.access$getChannel$p(r4)
            r3.label = r2
            java.lang.Object r4 = r4.receive(r3)
            if (r4 != r0) goto L29
            return r0
        L29:
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r4.invoke()
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$queueRunner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
