package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.urbanairship.android.layout.view.ButtonLayoutView;
import com.urbanairship.android.layout.view.MediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\f\u001a\u00060\rR\u00020\u0000J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/widget/TouchAwareWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "webViewListener", "Lcom/urbanairship/android/layout/view/MediaView$WebViewListener;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/view/MediaView$WebViewListener;)V", "touchesChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroid/view/MotionEvent;", "getWebViewListener", "()Lcom/urbanairship/android/layout/view/MediaView$WebViewListener;", "getJavascriptInterface", "Lcom/urbanairship/android/layout/widget/TouchAwareWebView$VideoListenerInterface;", "onTouchEvent", "", "event", "touchEvents", "Lkotlinx/coroutines/flow/Flow;", "VideoListenerInterface", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTouchAwareWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchAwareWebView.kt\ncom/urbanairship/android/layout/widget/TouchAwareWebView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1#2:84\n*E\n"})
/* loaded from: classes5.dex */
public final class TouchAwareWebView extends WebView {
    private final Channel touchesChannel;
    private final MediaView.WebViewListener webViewListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchAwareWebView(@NotNull Context context, @Nullable MediaView.WebViewListener webViewListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webViewListener = webViewListener;
        this.touchesChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Nullable
    public final MediaView.WebViewListener getWebViewListener() {
        return this.webViewListener;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        final ButtonLayoutView buttonLayoutViewFindButtonLayoutParent;
        if (event != null) {
            ChannelResult.m3635boximpl(this.touchesChannel.mo3620trySendJP2dKIU(event));
        }
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (event != null && event.getAction() == 1 && (buttonLayoutViewFindButtonLayoutParent = TouchAwareWebViewKt.findButtonLayoutParent(this)) != null) {
            post(new Runnable() { // from class: com.urbanairship.android.layout.widget.TouchAwareWebView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TouchAwareWebView.onTouchEvent$lambda$2$lambda$1(buttonLayoutViewFindButtonLayoutParent);
                }
            });
        }
        return zOnTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchEvent$lambda$2$lambda$1(ButtonLayoutView buttonLayout) {
        Intrinsics.checkNotNullParameter(buttonLayout, "$buttonLayout");
        buttonLayout.performClick();
    }

    @NotNull
    public final Flow<MotionEvent> touchEvents() {
        return FlowKt.receiveAsFlow(this.touchesChannel);
    }

    @NotNull
    public final VideoListenerInterface getJavascriptInterface() {
        return new VideoListenerInterface();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/widget/TouchAwareWebView$VideoListenerInterface;", "", "(Lcom/urbanairship/android/layout/widget/TouchAwareWebView;)V", "onVideoReady", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class VideoListenerInterface {
        public VideoListenerInterface() {
        }

        @JavascriptInterface
        public final void onVideoReady() {
            MediaView.WebViewListener webViewListener = TouchAwareWebView.this.getWebViewListener();
            if (webViewListener != null) {
                webViewListener.onVideoReady();
            }
        }
    }
}
