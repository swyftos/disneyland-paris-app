package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.Util;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
public class DefaultScrollHandle extends RelativeLayout implements ScrollHandle {
    protected Context context;
    private float currentPos;
    private Handler handler;
    private Runnable hidePageScrollerRunnable;
    private boolean inverted;
    private PDFView pdfView;
    private float relativeHandlerMiddle;
    protected TextView textView;

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    public DefaultScrollHandle(Context context, boolean z) {
        super(context);
        this.relativeHandlerMiddle = BitmapDescriptorFactory.HUE_RED;
        this.handler = new Handler();
        this.hidePageScrollerRunnable = new Runnable() { // from class: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultScrollHandle.this.hide();
            }
        };
        this.context = context;
        this.inverted = z;
        this.textView = new TextView(context);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i;
        int i2 = 40;
        int i3 = 65;
        if (pDFView.isSwipeVertical()) {
            if (this.inverted) {
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_left);
                i = 9;
            } else {
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_right);
                i = 11;
            }
            i3 = 40;
            i2 = 65;
        } else if (this.inverted) {
            drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_top);
            i = 10;
        } else {
            drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_bottom);
            i = 12;
        }
        setBackground(drawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getDP(this.context, i2), Util.getDP(this.context, i3));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.textView, layoutParams2);
        layoutParams.addRule(i);
        pDFView.addView(this, layoutParams);
        this.pdfView = pDFView;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void destroyLayout() {
        this.pdfView.removeView(this);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setScroll(float f) {
        if (!shown()) {
            show();
        } else {
            this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        }
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            setPosition((pDFView.isSwipeVertical() ? this.pdfView.getHeight() : this.pdfView.getWidth()) * f);
        }
    }

    private void setPosition(float f) {
        int width;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return;
        }
        if (this.pdfView.isSwipeVertical()) {
            width = this.pdfView.getHeight();
        } else {
            width = this.pdfView.getWidth();
        }
        float f2 = width;
        float dp = f - this.relativeHandlerMiddle;
        if (dp < BitmapDescriptorFactory.HUE_RED) {
            dp = 0.0f;
        } else if (dp > f2 - Util.getDP(this.context, 40)) {
            dp = f2 - Util.getDP(this.context, 40);
        }
        if (this.pdfView.isSwipeVertical()) {
            setY(dp);
        } else {
            setX(dp);
        }
        calculateMiddle();
        invalidate();
    }

    private void calculateMiddle() {
        float x;
        float width;
        int width2;
        if (this.pdfView.isSwipeVertical()) {
            x = getY();
            width = getHeight();
            width2 = this.pdfView.getHeight();
        } else {
            x = getX();
            width = getWidth();
            width2 = this.pdfView.getWidth();
        }
        this.relativeHandlerMiddle = ((x + this.relativeHandlerMiddle) / width2) * width;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hideDelayed() {
        this.handler.postDelayed(this.hidePageScrollerRunnable, 1000L);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setPageNum(int i) {
        String strValueOf = String.valueOf(i);
        if (this.textView.getText().equals(strValueOf)) {
            return;
        }
        this.textView.setText(strValueOf);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public boolean shown() {
        return getVisibility() == 0;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void show() {
        setVisibility(0);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hide() {
        setVisibility(4);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.textView.setTextSize(1, i);
    }

    private boolean isPDFViewReady() {
        PDFView pDFView = this.pdfView;
        return (pDFView == null || pDFView.getPageCount() <= 0 || this.pdfView.documentFitsView()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.isPDFViewReady()
            if (r0 != 0) goto Lb
            boolean r3 = super.onTouchEvent(r4)
            return r3
        Lb:
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L2e
            if (r0 == r1) goto L25
            r2 = 2
            if (r0 == r2) goto L59
            r2 = 3
            if (r0 == r2) goto L25
            r2 = 5
            if (r0 == r2) goto L2e
            r2 = 6
            if (r0 == r2) goto L25
            boolean r3 = super.onTouchEvent(r4)
            return r3
        L25:
            r3.hideDelayed()
            com.github.barteksc.pdfviewer.PDFView r3 = r3.pdfView
            r3.performPageSnap()
            return r1
        L2e:
            com.github.barteksc.pdfviewer.PDFView r0 = r3.pdfView
            r0.stopFling()
            android.os.Handler r0 = r3.handler
            java.lang.Runnable r2 = r3.hidePageScrollerRunnable
            r0.removeCallbacks(r2)
            com.github.barteksc.pdfviewer.PDFView r0 = r3.pdfView
            boolean r0 = r0.isSwipeVertical()
            if (r0 == 0) goto L4e
            float r0 = r4.getRawY()
            float r2 = r3.getY()
            float r0 = r0 - r2
            r3.currentPos = r0
            goto L59
        L4e:
            float r0 = r4.getRawX()
            float r2 = r3.getX()
            float r0 = r0 - r2
            r3.currentPos = r0
        L59:
            com.github.barteksc.pdfviewer.PDFView r0 = r3.pdfView
            boolean r0 = r0.isSwipeVertical()
            r2 = 0
            if (r0 == 0) goto L7d
            float r4 = r4.getRawY()
            float r0 = r3.currentPos
            float r4 = r4 - r0
            float r0 = r3.relativeHandlerMiddle
            float r4 = r4 + r0
            r3.setPosition(r4)
            com.github.barteksc.pdfviewer.PDFView r4 = r3.pdfView
            float r0 = r3.relativeHandlerMiddle
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            r4.setPositionOffset(r0, r2)
            goto L97
        L7d:
            float r4 = r4.getRawX()
            float r0 = r3.currentPos
            float r4 = r4 - r0
            float r0 = r3.relativeHandlerMiddle
            float r4 = r4 + r0
            r3.setPosition(r4)
            com.github.barteksc.pdfviewer.PDFView r4 = r3.pdfView
            float r0 = r3.relativeHandlerMiddle
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            r4.setPositionOffset(r0, r2)
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
