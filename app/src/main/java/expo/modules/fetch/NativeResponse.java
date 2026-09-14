package expo.modules.fetch;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.dlp.BluetoothManager;
import com.google.firebase.messaging.Constants;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020&J\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J(\u0010,\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&0\u0016J\u0018\u00100\u001a\u00020&2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020&2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u000207H\u0016J!\u00108\u001a\u00020\u00172\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0:\"\u00020\u000eH\u0002¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR.\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u000e\u0010\r\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006A"}, m1836d2 = {"Lexpo/modules/fetch/NativeResponse;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lokhttp3/Callback;", "appContext", "Lexpo/modules/kotlin/AppContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lexpo/modules/kotlin/AppContext;Lkotlinx/coroutines/CoroutineScope;)V", "sink", "Lexpo/modules/fetch/ResponseSink;", "getSink", "()Lexpo/modules/fetch/ResponseSink;", "value", "Lexpo/modules/fetch/ResponseState;", BluetoothManager.BLE_STATUS_PARAM, "getState", "()Lexpo/modules/fetch/ResponseState;", "setState", "(Lexpo/modules/fetch/ResponseState;)V", "stateChangeOnceListeners", "", "Lkotlin/Function1;", "", "Lexpo/modules/fetch/StateChangeListener;", "Lexpo/modules/fetch/NativeResponseInit;", "responseInit", "getResponseInit", "()Lexpo/modules/fetch/NativeResponseInit;", "Ljava/lang/Exception;", "Lkotlin/Exception;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "getError", "()Ljava/lang/Exception;", "bodyUsed", "getBodyUsed", "()Z", "deallocate", "", "onStarted", "startStreaming", "", "cancelStreaming", "emitRequestCanceled", "waitForStates", "states", "", "callback", "onFailure", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "isInvalidState", "validStates", "", "([Lexpo/modules/fetch/ResponseState;)Z", "createResponseInit", "pumpResponseBodyStream", "stream", "Lokio/BufferedSource;", "Companion", "expo_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nNativeResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NativeResponse.kt\nexpo/modules/fetch/NativeResponse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,208:1\n1#2:209\n1557#3:210\n1628#3,3:211\n*S KotlinDebug\n*F\n+ 1 NativeResponse.kt\nexpo/modules/fetch/NativeResponse\n*L\n158#1:210\n158#1:211,3\n*E\n"})
public final class NativeResponse extends SharedObject implements Callback {
    private static final String TAG = NativeResponse.class.getSimpleName();
    private final CoroutineScope coroutineScope;
    private Exception error;
    private NativeResponseInit responseInit;
    private final ResponseSink sink;
    private ResponseState state;
    private final List stateChangeOnceListeners;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeResponse(@NotNull AppContext appContext, @NotNull CoroutineScope coroutineScope) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.sink = new ResponseSink();
        this.state = ResponseState.INITIALIZED;
        this.stateChangeOnceListeners = new ArrayList();
    }

    @NotNull
    public final ResponseSink getSink() {
        return this.sink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResponseState getState() {
        ResponseState responseState;
        synchronized (this) {
            responseState = this.state;
        }
        return responseState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(ResponseState responseState) {
        synchronized (this) {
            this.state = responseState;
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new NativeResponse$state$3(this, responseState, null), 3, null);
    }

    @Nullable
    public final NativeResponseInit getResponseInit() {
        return this.responseInit;
    }

    @Nullable
    public final Exception getError() {
        return this.error;
    }

    public final boolean getBodyUsed() {
        return this.sink.getBodyUsed();
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        this.sink.finalize();
        super.deallocate();
    }

    public final void onStarted() {
        if (isInvalidState(ResponseState.INITIALIZED)) {
            return;
        }
        setState(ResponseState.STARTED);
    }

    @Nullable
    public final byte[] startStreaming() {
        ResponseState responseState = ResponseState.RESPONSE_RECEIVED;
        ResponseState responseState2 = ResponseState.BODY_COMPLETED;
        if (isInvalidState(responseState, responseState2)) {
            return null;
        }
        if (getState() == responseState) {
            setState(ResponseState.BODY_STREAMING_STARTED);
            emit("didReceiveResponseData", this.sink.finalize());
        } else if (getState() == responseState2) {
            return this.sink.finalize();
        }
        return null;
    }

    public final void cancelStreaming() {
        if (isInvalidState(ResponseState.BODY_STREAMING_STARTED)) {
            return;
        }
        setState(ResponseState.BODY_STREAMING_CANCELED);
    }

    public final void emitRequestCanceled() {
        FetchRequestCanceledException fetchRequestCanceledException = new FetchRequestCanceledException();
        this.error = fetchRequestCanceledException;
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(fetchRequestCanceledException));
        }
        setState(ResponseState.ERROR_RECEIVED);
    }

    public final void waitForStates(@NotNull final List<? extends ResponseState> states, @NotNull final Function1<? super ResponseState, Unit> callback) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (states.contains(getState())) {
            callback.invoke(getState());
        } else {
            this.stateChangeOnceListeners.add(new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(NativeResponse.waitForStates$lambda$2(states, callback, (ResponseState) obj));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean waitForStates$lambda$2(List list, Function1 function1, ResponseState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (!list.contains(newState)) {
            return false;
        }
        function1.invoke(newState);
        return true;
    }

    @Override // okhttp3.Callback
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (e.getMessage() == "Canceled") {
            return;
        }
        ResponseState responseState = ResponseState.STARTED;
        ResponseState responseState2 = ResponseState.RESPONSE_RECEIVED;
        ResponseState responseState3 = ResponseState.BODY_STREAMING_STARTED;
        if (isInvalidState(responseState, responseState2, responseState3, ResponseState.BODY_STREAMING_CANCELED)) {
            return;
        }
        if (getState() == responseState3) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e));
        }
        this.error = e;
        setState(ResponseState.ERROR_RECEIVED);
        emit("readyForJSFinalization", new Object[0]);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NotNull Call call, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.responseInit = createResponseInit(response);
        setState(ResponseState.RESPONSE_RECEIVED);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new C61131(response, this, null), 2, null);
    }

    /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$onResponse$1 */
    static final class C61131 extends SuspendLambda implements Function2 {
        final /* synthetic */ Response $response;
        int label;
        final /* synthetic */ NativeResponse this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61131(Response response, NativeResponse nativeResponse, Continuation continuation) {
            super(2, continuation);
            this.$response = response;
            this.this$0 = nativeResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C61131(this.$response, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C61131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BufferedSource source;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResponseBody responseBodyBody = this.$response.body();
            if (responseBodyBody != null && (source = responseBodyBody.getSource()) != null) {
                this.this$0.pumpResponseBodyStream(source);
                this.$response.close();
                if (this.this$0.getState() == ResponseState.BODY_STREAMING_STARTED) {
                    this.this$0.emit("didComplete", new Object[0]);
                }
                this.this$0.setState(ResponseState.BODY_COMPLETED);
                this.this$0.emit("readyForJSFinalization", new Object[0]);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean isInvalidState(ResponseState... validStates) {
        if (ArraysKt.contains(validStates, getState())) {
            return false;
        }
        String strJoinToString$default = ArraysKt.joinToString$default(validStates, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NativeResponse.isInvalidState$lambda$3((ResponseState) obj);
            }
        }, 30, (Object) null);
        Log.w(TAG, "Invalid state - currentState[" + getState().getIntValue() + "] validStates[" + strJoinToString$default + "]");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence isInvalidState$lambda$3(ResponseState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getIntValue());
    }

    private final NativeResponseInit createResponseInit(Response response) {
        int iCode = response.code();
        String strMessage = response.message();
        Headers headers = response.headers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headers, 10));
        for (Pair<? extends String, ? extends String> pair : headers) {
            arrayList.add(TuplesKt.m1842to(pair.getFirst(), pair.getSecond()));
        }
        return new NativeResponseInit(arrayList, iCode, strMessage, response.request().url().getUrl(), response.isRedirect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pumpResponseBodyStream(BufferedSource stream) {
        while (!stream.exhausted()) {
            try {
                ResponseState responseState = ResponseState.RESPONSE_RECEIVED;
                ResponseState responseState2 = ResponseState.BODY_STREAMING_STARTED;
                if (isInvalidState(responseState, responseState2, ResponseState.BODY_STREAMING_CANCELED)) {
                    return;
                }
                if (getState() == responseState) {
                    this.sink.appendBufferBody$expo_release(stream.getBuffer().readByteArray());
                } else if (getState() != responseState2) {
                    return;
                } else {
                    emit("didReceiveResponseData", stream.getBuffer().readByteArray());
                }
            } catch (IOException e) {
                this.error = e;
                if (getState() == ResponseState.BODY_STREAMING_STARTED) {
                    emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e));
                }
                setState(ResponseState.ERROR_RECEIVED);
                return;
            }
        }
    }
}
