package com.swmansion.reanimated;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class NativeMethodsHelper {
    public static float[] measure(View view) {
        View view2 = (View) RootViewUtil.getRootView(view);
        if (view2 == null || view == null) {
            float[] fArr = new float[6];
            fArr[0] = -1234567.0f;
            return fArr;
        }
        int[] iArr = new int[4];
        computeBoundingBox(view2, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        computeBoundingBox(view, iArr);
        iArr[0] = iArr[0] - i;
        iArr[1] = iArr[1] - i2;
        float[] fArr2 = new float[6];
        fArr2[0] = PixelUtil.toDIPFromPixel(view.getLeft());
        fArr2[1] = PixelUtil.toDIPFromPixel(view.getTop());
        for (int i3 = 2; i3 < 6; i3++) {
            fArr2[i3] = PixelUtil.toDIPFromPixel(iArr[i3 - 2]);
        }
        return fArr2;
    }

    public static void scrollTo(final View view, double d, double d2, boolean z) {
        final int iRound = Math.round(PixelUtil.toPixelFromDIP(d));
        final int iRound2 = Math.round(PixelUtil.toPixelFromDIP(d2));
        boolean z2 = view instanceof ReactHorizontalScrollView;
        if (!z2) {
            if (view instanceof ReactSwipeRefreshLayout) {
                view = findScrollView((ReactSwipeRefreshLayout) view);
            }
            if (!(view instanceof ReactScrollView)) {
                Log.w("REANIMATED", "NativeMethodsHelper: Unhandled scroll view type - allowed only {ReactScrollView, ReactHorizontalScrollView}");
                return;
            }
        }
        if (!z) {
            view.scrollTo(iRound, iRound2);
        } else if (z2) {
            view.post(new Runnable() { // from class: com.swmansion.reanimated.NativeMethodsHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NativeMethodsHelper.lambda$scrollTo$0(view, iRound, iRound2);
                }
            });
        } else {
            view.post(new Runnable() { // from class: com.swmansion.reanimated.NativeMethodsHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    NativeMethodsHelper.lambda$scrollTo$1(view, iRound, iRound2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$scrollTo$0(View view, int i, int i2) {
        ((ReactHorizontalScrollView) view).smoothScrollTo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$scrollTo$1(View view, int i, int i2) {
        ((ReactScrollView) view).smoothScrollTo(i, i2);
    }

    private static ReactScrollView findScrollView(ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        for (int i = 0; i < reactSwipeRefreshLayout.getChildCount(); i++) {
            if (reactSwipeRefreshLayout.getChildAt(i) instanceof ReactScrollView) {
                return (ReactScrollView) reactSwipeRefreshLayout.getChildAt(i);
            }
        }
        return null;
    }

    private static void computeBoundingBox(View view, int[] iArr) {
        RectF rectF = new RectF();
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, view.getWidth(), view.getHeight());
        mapRectFromViewToWindowCoords(view, rectF);
        iArr[0] = Math.round(rectF.left);
        iArr[1] = Math.round(rectF.top);
        iArr[2] = Math.round(rectF.right - rectF.left);
        iArr[3] = Math.round(rectF.bottom - rectF.top);
    }

    private static void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(view.getLeft(), view.getTop());
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
    }
}
