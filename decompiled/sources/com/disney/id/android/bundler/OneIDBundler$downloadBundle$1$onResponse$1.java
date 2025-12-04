package com.disney.id.android.bundler;

import android.content.SharedPreferences;
import com.disney.id.android.bundler.OneIDBundler;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import java.io.IOException;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes3.dex */
final class OneIDBundler$downloadBundle$1$onResponse$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ OneIDTrackerEvent $event;
    final /* synthetic */ Response $response;
    final /* synthetic */ TrackerEventKey $transactionEventKey;
    int label;
    final /* synthetic */ OneIDBundler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneIDBundler$downloadBundle$1$onResponse$1(Response response, OneIDBundler oneIDBundler, OneIDTrackerEvent oneIDTrackerEvent, TrackerEventKey trackerEventKey, Continuation continuation) {
        super(2, continuation);
        this.$response = response;
        this.this$0 = oneIDBundler;
        this.$event = oneIDTrackerEvent;
        this.$transactionEventKey = trackerEventKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneIDBundler$downloadBundle$1$onResponse$1(this.$response, this.this$0, this.$event, this.$transactionEventKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneIDBundler$downloadBundle$1$onResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ResponseBody responseBody = (ResponseBody) this.$response.body();
        String str = null;
        InputStream inputStreamByteStream = responseBody != null ? responseBody.byteStream() : null;
        if (inputStreamByteStream != null) {
            this.this$0.writeBundle(inputStreamByteStream, this.$event);
            Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), this.$transactionEventKey, false, null, null, null, false, 62, null);
            Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
            String str2 = OneIDBundler.TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
            Logger.DefaultImpls.d$default(logger$OneID_release, str2, "The Bundle was just written to file", null, 4, null);
            SharedPreferences.Editor editorEdit = this.this$0.sharedPreferences.edit();
            String str3 = this.this$0.storedETagKey;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storedETagKey");
            } else {
                str = str3;
            }
            editorEdit.putString(str, this.$response.headers().get("ETag")).apply();
            this.this$0.bundleState = OneIDBundler.BundleState.ReadyNew;
        } else {
            Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
            String str4 = OneIDBundler.TAG;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
            Logger.DefaultImpls.e$default(logger$OneID_release2, str4, "response was null for some reason", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), this.$transactionEventKey, false, "UNKNOWN_ERROR", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(response was null for some reason)", false, 32, null);
        }
        return Unit.INSTANCE;
    }
}
