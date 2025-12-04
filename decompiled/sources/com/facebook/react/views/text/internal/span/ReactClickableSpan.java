package com.facebook.react.views.text.internal.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ViewGroupClickEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/views/text/internal/span/ReactClickableSpan;", "Landroid/text/style/ClickableSpan;", "Lcom/facebook/react/views/text/internal/span/ReactSpan;", "reactTag", "", "<init>", "(I)V", "getReactTag", "()I", "isKeyboardFocused", "", "()Z", "setKeyboardFocused", "(Z)V", "focusBgColor", "getFocusBgColor", "setFocusBgColor", ViewProps.ON_CLICK, "", "view", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactClickableSpan extends ClickableSpan implements ReactSpan {
    private int focusBgColor;
    private boolean isKeyboardFocused;
    private final int reactTag;

    public ReactClickableSpan(int i) {
        this.reactTag = i;
    }

    public final int getReactTag() {
        return this.reactTag;
    }

    /* renamed from: isKeyboardFocused, reason: from getter */
    public final boolean getIsKeyboardFocused() {
        return this.isKeyboardFocused;
    }

    public final void setKeyboardFocused(boolean z) {
        this.isKeyboardFocused = z;
    }

    public final int getFocusBgColor() {
        return this.focusBgColor;
    }

    public final void setFocusBgColor(int i) {
        this.focusBgColor = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, this.reactTag);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId(reactContext), this.reactTag));
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        if (this.isKeyboardFocused) {
            ds.bgColor = this.focusBgColor;
        }
    }
}
