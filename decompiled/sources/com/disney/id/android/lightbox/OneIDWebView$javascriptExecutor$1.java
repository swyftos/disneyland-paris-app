package com.disney.id.android.lightbox;

import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.disney.id.android.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/disney/id/android/lightbox/OneIDWebView$javascriptExecutor$1", "Lcom/disney/id/android/lightbox/JavascriptExecutor;", "executeJavascript", "", "js", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDWebView$javascriptExecutor$1 implements JavascriptExecutor {
    final /* synthetic */ OneIDWebView this$0;

    OneIDWebView$javascriptExecutor$1(OneIDWebView oneIDWebView) {
        this.this$0 = oneIDWebView;
    }

    @Override // com.disney.id.android.lightbox.JavascriptExecutor
    public void executeJavascript(@NotNull final String js) {
        Intrinsics.checkNotNullParameter(js, "js");
        Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
        String tAG$OneID_release = OneIDWebView.INSTANCE.getTAG$OneID_release();
        Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
        Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "JS -> Web // executeJavascript\n" + js, null, 4, null);
        final OneIDWebView oneIDWebView = this.this$0;
        oneIDWebView.post(new Runnable() { // from class: com.disney.id.android.lightbox.OneIDWebView$javascriptExecutor$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneIDWebView$javascriptExecutor$1.executeJavascript$lambda$0(oneIDWebView, js);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeJavascript$lambda$0(OneIDWebView this$0, String js) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(js, "$js");
        InstrumentationCallbacks.loadUrlCalled(this$0);
        this$0.loadUrl("javascript:" + js);
    }
}
