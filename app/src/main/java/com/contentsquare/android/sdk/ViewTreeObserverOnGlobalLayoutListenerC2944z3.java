package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay.C2365a;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z3 */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC2944z3 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2365a f3309a;

    public ViewTreeObserverOnGlobalLayoutListenerC2944z3(C2365a c2365a) {
        this.f3309a = c2365a;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iHeight;
        int iWidth;
        C2365a c2365a = this.f3309a;
        View rootView = c2365a.m773a().getRootView();
        if (rootView != null) {
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            iHeight = rect.height();
            iWidth = rect.width();
        } else {
            iHeight = 0;
            iWidth = 0;
        }
        if (c2365a.f1150j == 0 || c2365a.f1151k == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            c2365a.f1143c.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            iWidth = displayMetrics.widthPixels;
            iHeight = i;
        }
        Pair pairM1842to = TuplesKt.m1842to(Integer.valueOf(iHeight), Integer.valueOf(iWidth));
        this.f3309a.f1150j = ((Number) pairM1842to.getFirst()).intValue();
        this.f3309a.f1151k = ((Number) pairM1842to.getSecond()).intValue();
        ViewTreeObserver viewTreeObserver = this.f3309a.m773a().getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "fabLayout.viewTreeObserver");
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }
}
