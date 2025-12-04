package com.urbanairship.remotedata;

import com.urbanairship.remotedata.RemoteDataProvider;
import java.util.Locale;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* loaded from: classes5.dex */
final class RemoteDataRefreshManager$performRefresh$2$result$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $changeToken;
    final /* synthetic */ RemoteDataProvider $it;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ int $randomValue;
    Object L$0;
    int label;
    final /* synthetic */ RemoteDataRefreshManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteDataRefreshManager$performRefresh$2$result$1$1(RemoteDataProvider remoteDataProvider, String str, Locale locale, int i, RemoteDataRefreshManager remoteDataRefreshManager, Continuation continuation) {
        super(2, continuation);
        this.$it = remoteDataProvider;
        this.$changeToken = str;
        this.$locale = locale;
        this.$randomValue = i;
        this.this$0 = remoteDataRefreshManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteDataRefreshManager$performRefresh$2$result$1$1(this.$it, this.$changeToken, this.$locale, this.$randomValue, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteDataRefreshManager$performRefresh$2$result$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RemoteDataProvider remoteDataProvider = this.$it;
            String str = this.$changeToken;
            Locale locale = this.$locale;
            int i2 = this.$randomValue;
            this.label = 1;
            obj = remoteDataProvider.refresh(str, locale, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                RemoteDataProvider.RefreshResult refreshResult = (RemoteDataProvider.RefreshResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                return refreshResult;
            }
            ResultKt.throwOnFailure(obj);
        }
        RemoteDataProvider.RefreshResult refreshResult2 = (RemoteDataProvider.RefreshResult) obj;
        MutableSharedFlow mutableSharedFlow = this.this$0._refreshFlow;
        Pair pair = new Pair(this.$it.getSource(), refreshResult2);
        this.L$0 = refreshResult2;
        this.label = 2;
        return mutableSharedFlow.emit(pair, this) == coroutine_suspended ? coroutine_suspended : refreshResult2;
    }
}
