package com.urbanairship.channel;

import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class ChannelSubscriptions$resolveSubscriptionLists$2 extends SuspendLambda implements Function1 {
    final /* synthetic */ String $channelId;
    int label;
    final /* synthetic */ ChannelSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelSubscriptions$resolveSubscriptionLists$2(ChannelSubscriptions channelSubscriptions, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = channelSubscriptions;
        this.$channelId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ChannelSubscriptions$resolveSubscriptionLists$2(this.this$0, this.$channelId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ChannelSubscriptions$resolveSubscriptionLists$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SubscriptionsResult subscriptionsResult = (SubscriptionsResult) this.this$0.subscriptionListCache.get();
            if (subscriptionsResult == null || !Intrinsics.areEqual(subscriptionsResult.getChannelId(), this.$channelId)) {
                SubscriptionListApiClient subscriptionListApiClient = this.this$0.subscriptionListApiClient;
                String str = this.$channelId;
                this.label = 1;
                obj = subscriptionListApiClient.getSubscriptionLists(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Result.Companion companion = Result.INSTANCE;
                return Result.m2967boximpl(Result.m2968constructorimpl(subscriptionsResult.getSubscriptions()));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.isSuccessful() && requestResult.getValue() != null) {
            this.this$0.subscriptionListCache.set(new SubscriptionsResult(this.$channelId, (Set) requestResult.getValue()), this.this$0.clock.currentTimeMillis() + AudienceOverridesProvider.EXPIRY_MS);
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m2967boximpl(Result.m2968constructorimpl(requestResult.getValue()));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m2967boximpl(Result.m2968constructorimpl(ResultKt.createFailure(new RequestException("Failed to fetch subscription lists with status: " + requestResult.getStatus()))));
    }
}
