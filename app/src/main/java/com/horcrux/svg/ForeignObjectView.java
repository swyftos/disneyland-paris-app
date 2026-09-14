package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
class ForeignObjectView extends GroupView {
    Canvas fake;
    Bitmap fakeBitmap;

    /* JADX INFO: renamed from: mH */
    SVGLength f3618mH;

    /* JADX INFO: renamed from: mW */
    SVGLength f3619mW;

    /* JADX INFO: renamed from: mX */
    SVGLength f3620mX;

    /* JADX INFO: renamed from: mY */
    SVGLength f3621mY;

    public ForeignObjectView(ReactContext reactContext) {
        super(reactContext);
        this.fakeBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        this.fake = new Canvas(this.fakeBitmap);
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        float fRelativeOnWidth = (float) relativeOnWidth(this.f3620mX);
        float fRelativeOnHeight = (float) relativeOnHeight(this.f3621mY);
        float fRelativeOnWidth2 = (float) relativeOnWidth(this.f3619mW);
        float fRelativeOnHeight2 = (float) relativeOnHeight(this.f3618mH);
        canvas.translate(fRelativeOnWidth, fRelativeOnHeight);
        canvas.clipRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, fRelativeOnWidth2, fRelativeOnHeight2);
        super.draw(canvas, paint, f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    public void setX(Dynamic dynamic) {
        this.f3620mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.f3621mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.f3619mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.f3618mH = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.GroupView
    void drawGroup(Canvas canvas, Paint paint, float f) {
        pushGlyphContext();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt;
                    if (!"none".equals(virtualView.mDisplay)) {
                        boolean z = virtualView instanceof RenderableView;
                        if (z) {
                            ((RenderableView) virtualView).mergeProperties(this);
                        }
                        int iSaveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas, this.mCTM);
                        virtualView.render(canvas, paint, this.mOpacity * f);
                        RectF clientRect = virtualView.getClientRect();
                        if (clientRect != null) {
                            rectF.union(clientRect);
                        }
                        virtualView.restoreCanvas(canvas, iSaveAndSetupCanvas);
                        if (z) {
                            ((RenderableView) virtualView).resetProperties();
                        }
                        if (virtualView.isResponsible()) {
                            svgView.enableTouchEvents();
                        }
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                } else {
                    childAt.draw(canvas);
                }
            }
        }
        setClientRect(rectF);
        popGlyphContext();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(this.fake);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(this.fake, view, j);
    }
}
