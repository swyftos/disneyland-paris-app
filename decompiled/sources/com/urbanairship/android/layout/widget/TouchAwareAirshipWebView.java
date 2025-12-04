package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.view.MotionEvent;
import com.urbanairship.android.layout.view.ButtonLayoutView;
import com.urbanairship.webkit.AirshipWebView;
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

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/layout/widget/TouchAwareAirshipWebView;", "Lcom/urbanairship/webkit/AirshipWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "touchesChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroid/view/MotionEvent;", "onTouchEvent", "", "event", "touchEvents", "Lkotlinx/coroutines/flow/Flow;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTouchAwareWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchAwareWebView.kt\ncom/urbanairship/android/layout/widget/TouchAwareAirshipWebView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1#2:84\n*E\n"})
/* loaded from: classes5.dex */
public final class TouchAwareAirshipWebView extends AirshipWebView {
    private final Channel touchesChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchAwareAirshipWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchesChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        final ButtonLayoutView buttonLayoutViewFindButtonLayoutParent;
        if (event != null) {
            ChannelResult.m3635boximpl(this.touchesChannel.mo3620trySendJP2dKIU(event));
        }
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (event != null && event.getAction() == 1 && (buttonLayoutViewFindButtonLayoutParent = TouchAwareWebViewKt.findButtonLayoutParent(this)) != null) {
            post(new Runnable() { // from class: com.urbanairship.android.layout.widget.TouchAwareAirshipWebView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TouchAwareAirshipWebView.onTouchEvent$lambda$2$lambda$1(buttonLayoutViewFindButtonLayoutParent);
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
}
