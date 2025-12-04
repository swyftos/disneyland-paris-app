package com.disney.id.android;

import android.webkit.WebView;
import com.disney.id.android.OneID;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.logging.Logger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneID$Companion$initialize$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Config $config;
    final /* synthetic */ OneID $this_apply;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$2$1(Config config, OneID oneID, Continuation continuation) {
        super(2, continuation);
        this.$config = config;
        this.$this_apply = oneID;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OneID$Companion$initialize$2$1 oneID$Companion$initialize$2$1 = new OneID$Companion$initialize$2$1(this.$config, this.$this_apply, continuation);
        oneID$Companion$initialize$2$1.L$0 = obj;
        return oneID$Companion$initialize$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$config.getLogLevel().compareTo(OneID.LogLevel.DEBUG) >= 0 && OneID.Environment.PROD != this.$config.getEnvironment()) {
            try {
                WebView.setWebContentsDebuggingEnabled(true);
            } catch (Exception unused) {
                Logger logger$OneID_release = this.$this_apply.getLogger$OneID_release();
                String str = OneID.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.e$default(logger$OneID_release, str, "Unable to get webView", null, 4, null);
            }
        }
        OneID oneID = this.$this_apply;
        LightboxWebView lightboxWebView = null;
        LightboxWebView oneIDWebView$default = OneIDWebViewFactory.getOneIDWebView$default(oneID.getOneIDWebViewFactory$OneID_release(), null, 1, null);
        if (oneIDWebView$default == null) {
            Logger logger$OneID_release2 = this.$this_apply.getLogger$OneID_release();
            String str2 = OneID.TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
            Logger.DefaultImpls.e$default(logger$OneID_release2, str2, "Unable to get webView", null, 4, null);
        } else {
            lightboxWebView = oneIDWebView$default;
        }
        oneID.setOneIDWebView$OneID_release(lightboxWebView);
        LightboxWebView oneIDWebView = this.$this_apply.getOneIDWebView();
        if (oneIDWebView != null) {
            oneIDWebView.setOwner(this.$this_apply.webViewOwner);
        }
        return Unit.INSTANCE;
    }
}
