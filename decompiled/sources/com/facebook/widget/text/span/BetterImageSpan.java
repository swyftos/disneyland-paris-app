package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class BetterImageSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int mAlignment;
    private Rect mBounds;
    private final Drawable mDrawable;
    private final Paint.FontMetricsInt mFontMetricsInt;
    protected int mHeight;
    private final Rect mMargin;
    protected int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BetterImageSpanAlignment {
    }

    public static final int normalizeAlignment(int i) {
        if (i != 0) {
            return i != 2 ? 1 : 2;
        }
        return 0;
    }

    public BetterImageSpan(Drawable drawable) {
        this(drawable, 1);
    }

    public BetterImageSpan(Drawable drawable, int i) {
        this(drawable, i, new Rect());
    }

    public BetterImageSpan(Drawable drawable, int i, Rect rect) {
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        this.mDrawable = drawable;
        this.mAlignment = i;
        this.mMargin = rect;
        updateBounds();
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public Rect getMargin() {
        return this.mMargin;
    }

    public int getVerticalAlignment() {
        return this.mAlignment;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        updateBounds();
        if (fontMetricsInt == null) {
            return this.mWidth;
        }
        return calculateLineWidthAndFontHeight(fontMetricsInt);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.mFontMetricsInt);
        Paint.FontMetricsInt fontMetricsInt = this.mFontMetricsInt;
        float f2 = f + this.mMargin.left;
        canvas.translate(f2, getIconTop(i4, fontMetricsInt.ascent, fontMetricsInt.descent, i3, i5));
        this.mDrawable.draw(canvas);
        canvas.translate(-f2, -r8);
    }

    public void updateBounds() {
        Rect bounds = this.mDrawable.getBounds();
        this.mBounds = bounds;
        int iWidth = bounds.width();
        Rect rect = this.mMargin;
        this.mWidth = iWidth + rect.left + rect.right;
        this.mHeight = this.mBounds.height();
    }

    protected int getOffsetAboveBaseline(int i, int i2) {
        int i3 = this.mAlignment;
        if (i3 == 0) {
            return (i2 - this.mHeight) - this.mMargin.bottom;
        }
        if (i3 == 2) {
            Rect rect = this.mMargin;
            int i4 = (i2 - i) + rect.top;
            int i5 = rect.bottom;
            return (i + (((i4 + i5) - this.mHeight) / 2)) - i5;
        }
        return (-this.mHeight) - this.mMargin.bottom;
    }

    protected int getIconTop(int i, int i2, int i3, int i4, int i5) {
        Paint.FontMetricsInt fontMetricsInt = this.mFontMetricsInt;
        return i + getOffsetAboveBaseline(fontMetricsInt.ascent, fontMetricsInt.descent);
    }

    protected int calculateLineWidthAndFontHeight(Paint.FontMetricsInt fontMetricsInt) {
        int i;
        int offsetAboveBaseline = getOffsetAboveBaseline(fontMetricsInt.ascent, fontMetricsInt.descent);
        int i2 = this.mHeight + offsetAboveBaseline;
        if (this.mAlignment == 2) {
            Rect rect = this.mMargin;
            i = offsetAboveBaseline - rect.top;
            i2 += rect.bottom;
        } else {
            i = offsetAboveBaseline - this.mMargin.top;
        }
        updateFontHeight(fontMetricsInt, i, i2);
        return this.mWidth;
    }

    protected void updateFontHeight(Paint.FontMetricsInt fontMetricsInt, int i, int i2) {
        if (i < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = i;
        }
        if (i < fontMetricsInt.top) {
            fontMetricsInt.top = i;
        }
        if (i2 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i2;
        }
        if (i2 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i2;
        }
    }
}
