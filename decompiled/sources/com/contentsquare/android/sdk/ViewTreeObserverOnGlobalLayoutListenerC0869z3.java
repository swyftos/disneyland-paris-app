package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.contentsquare.android.sdk.z3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0869z3 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a a;

    public ViewTreeObserverOnGlobalLayoutListenerC0869z3(com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar) {
        this.a = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iHeight;
        int iWidth;
        com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a aVar = this.a;
        View rootView = aVar.a().getRootView();
        if (rootView != null) {
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            iHeight = rect.height();
            iWidth = rect.width();
        } else {
            iHeight = 0;
            iWidth = 0;
        }
        if (aVar.j == 0 || aVar.k == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            aVar.c.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            iWidth = displayMetrics.widthPixels;
            iHeight = i;
        }
        Pair pair = TuplesKt.to(Integer.valueOf(iHeight), Integer.valueOf(iWidth));
        this.a.j = ((Number) pair.getFirst()).intValue();
        this.a.k = ((Number) pair.getSecond()).intValue();
        ViewTreeObserver viewTreeObserver = this.a.a().getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "fabLayout.viewTreeObserver");
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }
}
