package com.urbanairship.http;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.AirshipDispatchers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ2\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0006\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/http/SuspendingRequestSession;", "", "requestSession", "Lcom/urbanairship/http/RequestSession;", "(Lcom/urbanairship/http/RequestSession;)V", "execute", "Lcom/urbanairship/http/RequestResult;", "", "request", "Lcom/urbanairship/http/Request;", "(Lcom/urbanairship/http/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "parser", "Lcom/urbanairship/http/ResponseParser;", "(Lcom/urbanairship/http/Request;Lcom/urbanairship/http/ResponseParser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class SuspendingRequestSession {
    private final RequestSession requestSession;

    public SuspendingRequestSession(@NotNull RequestSession requestSession) {
        Intrinsics.checkNotNullParameter(requestSession, "requestSession");
        this.requestSession = requestSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit execute$lambda$0(int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object execute(@NotNull Request request, @NotNull Continuation<? super RequestResult<Unit>> continuation) {
        return execute(request, new ResponseParser() { // from class: com.urbanairship.http.SuspendingRequestSession$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str) {
                return SuspendingRequestSession.execute$lambda$0(i, map, str);
            }
        }, continuation);
    }

    /* renamed from: com.urbanairship.http.SuspendingRequestSession$execute$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ ResponseParser $parser;
        final /* synthetic */ Request $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Request request, ResponseParser responseParser, Continuation continuation) {
            super(2, continuation);
            this.$request = request;
            this.$parser = responseParser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SuspendingRequestSession.this.new AnonymousClass4(this.$request, this.$parser, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Response responseExecute = SuspendingRequestSession.this.requestSession.execute(this.$request, this.$parser);
                    return new RequestResult(responseExecute.getStatus(), responseExecute.getResult(), responseExecute.getBody(), responseExecute.getHeaders());
                } catch (Exception e) {
                    return new RequestResult(e);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final <T> Object execute(@NotNull Request request, @NotNull ResponseParser<T> responseParser, @NotNull Continuation<? super RequestResult<T>> continuation) {
        return BuildersKt.withContext(AirshipDispatchers.INSTANCE.getIO(), new AnonymousClass4(request, responseParser, null), continuation);
    }
}
