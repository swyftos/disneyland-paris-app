package com.urbanairship.util;

import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
final class AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ UUID $changeToken;
    final /* synthetic */ String $identifier;
    final /* synthetic */ Ref.ObjectRef $lastIdentifier;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AutoRefreshingDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1(AutoRefreshingDataProvider autoRefreshingDataProvider, String str, UUID uuid, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = autoRefreshingDataProvider;
        this.$identifier = str;
        this.$changeToken = uuid;
        this.$lastIdentifier = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1 autoRefreshingDataProvider$updates$2$2$fetchUpdates$1 = new AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1(this.this$0, this.$identifier, this.$changeToken, this.$lastIdentifier, continuation);
        autoRefreshingDataProvider$updates$2$2$fetchUpdates$1.L$0 = obj;
        return autoRefreshingDataProvider$updates$2$2$fetchUpdates$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0077 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0078  */
    /* JADX WARN: Code duplicated, block: B:23:0x0081  */
    /* JADX WARN: Code duplicated, block: B:25:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd A[RETURN] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00de -> B:39:0x00e1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.util.AutoRefreshingDataProvider$updates$2$2$fetchUpdates$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
