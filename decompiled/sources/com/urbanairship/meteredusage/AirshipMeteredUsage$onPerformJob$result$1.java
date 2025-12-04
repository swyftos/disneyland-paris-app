package com.urbanairship.meteredusage;

import com.urbanairship.http.RequestResult;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class AirshipMeteredUsage$onPerformJob$result$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.ObjectRef $channelId;
    final /* synthetic */ Ref.ObjectRef $events;
    int label;
    final /* synthetic */ AirshipMeteredUsage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AirshipMeteredUsage$onPerformJob$result$1(AirshipMeteredUsage airshipMeteredUsage, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = airshipMeteredUsage;
        this.$events = objectRef;
        this.$channelId = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AirshipMeteredUsage$onPerformJob$result$1(this.this$0, this.$events, this.$channelId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AirshipMeteredUsage$onPerformJob$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MeteredUsageApiClient meteredUsageApiClient = this.this$0.client;
                List<MeteredUsageEventEntity> list = (List) this.$events.element;
                String str = (String) this.$channelId.element;
                this.label = 1;
                obj = meteredUsageApiClient.uploadEvents(list, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (RequestResult) obj;
        } catch (Exception e) {
            return new RequestResult(e);
        }
    }
}
