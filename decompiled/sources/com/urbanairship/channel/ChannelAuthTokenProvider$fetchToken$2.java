package com.urbanairship.channel;

import com.urbanairship.http.AuthToken;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class ChannelAuthTokenProvider$fetchToken$2 extends SuspendLambda implements Function1 {
    final /* synthetic */ String $identifier;
    int label;
    final /* synthetic */ ChannelAuthTokenProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelAuthTokenProvider$fetchToken$2(ChannelAuthTokenProvider channelAuthTokenProvider, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = channelAuthTokenProvider;
        this.$identifier = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ChannelAuthTokenProvider$fetchToken$2(this.this$0, this.$identifier, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ChannelAuthTokenProvider$fetchToken$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM2968constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.this$0.channelIDProvider.invoke();
            if (str != null && Intrinsics.areEqual(this.$identifier, str)) {
                String cachedToken = this.this$0.getCachedToken(this.$identifier);
                if (cachedToken == null) {
                    ChannelAuthApiClient channelAuthApiClient = this.this$0.apiClient;
                    this.label = 1;
                    obj = channelAuthApiClient.getToken(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return Result.m2967boximpl(Result.m2968constructorimpl(cachedToken));
                }
            } else {
                Result.Companion companion = Result.INSTANCE;
                return Result.m2967boximpl(Result.m2968constructorimpl(ResultKt.createFailure(new RequestException("Channel mismatch."))));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.isSuccessful() && requestResult.getValue() != null) {
            this.this$0.cachedAuth.set(requestResult.getValue(), ((AuthToken) requestResult.getValue()).getExpirationDateMillis());
            Result.Companion companion2 = Result.INSTANCE;
            objM2968constructorimpl = Result.m2968constructorimpl(((AuthToken) requestResult.getValue()).getToken());
        } else {
            Result.Companion companion3 = Result.INSTANCE;
            objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(new RequestException("Failed to fetch token: " + requestResult.getStatus())));
        }
        return Result.m2967boximpl(objM2968constructorimpl);
    }
}
