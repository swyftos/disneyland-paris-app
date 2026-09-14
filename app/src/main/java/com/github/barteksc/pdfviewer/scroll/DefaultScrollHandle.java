package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.Util;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes3.dex */
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
        float width3;
        if (this.pdfView.isSwipeVertical()) {
            x = getY();
            width = getHeight();
            width2 = this.pdfView.getHeight();
        } else {
            if (this.pdfView.isOnDualPageMode()) {
                x = getX();
                width = getWidth() / 2.0f;
                width3 = this.pdfView.getWidth() / 2.0f;
            } else {
                x = getX();
                width = getWidth();
                width2 = this.pdfView.getWidth();
            }
            this.relativeHandlerMiddle = ((x + this.relativeHandlerMiddle) / width3) * width;
        }
        width3 = width2;
        this.relativeHandlerMiddle = ((x + this.relativeHandlerMiddle) / width3) * width;
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

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x004e  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPDFViewReady()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.pdfView.stopFling();
            this.handler.removeCallbacks(this.hidePageScrollerRunnable);
            if (this.pdfView.isSwipeVertical()) {
                this.currentPos = motionEvent.getRawY() - getY();
            } else {
                this.currentPos = motionEvent.getRawX() - getX();
            }
        } else {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return super.onTouchEvent(motionEvent);
                            }
                        }
                        this.pdfView.stopFling();
                        this.handler.removeCallbacks(this.hidePageScrollerRunnable);
                        if (this.pdfView.isSwipeVertical()) {
                            this.currentPos = motionEvent.getRawY() - getY();
                        } else {
                            this.currentPos = motionEvent.getRawX() - getX();
                        }
                    }
                }
            }
            hideDelayed();
            this.pdfView.performPageSnap();
            return true;
        }
        if (this.pdfView.isSwipeVertical()) {
            setPosition((motionEvent.getRawY() - this.currentPos) + this.relativeHandlerMiddle);
            this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getHeight(), false);
        } else {
            setPosition((motionEvent.getRawX() - this.currentPos) + this.relativeHandlerMiddle);
            this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getWidth(), false);
        }
        return true;
    }
}
