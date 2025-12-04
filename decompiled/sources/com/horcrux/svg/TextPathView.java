package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.TextProperties;
import javax.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class TextPathView extends TextView {
    private String mHref;
    private TextProperties.TextPathMethod mMethod;
    private TextProperties.TextPathMidLine mMidLine;
    private TextProperties.TextPathSide mSide;
    private TextProperties.TextPathSpacing mSpacing;

    @Nullable
    private SVGLength mStartOffset;

    @Override // com.horcrux.svg.GroupView
    void popGlyphContext() {
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    void pushGlyphContext() {
    }

    public TextPathView(ReactContext reactContext) {
        super(reactContext);
        this.mMethod = TextProperties.TextPathMethod.align;
        this.mSpacing = TextProperties.TextPathSpacing.exact;
    }

    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    public void setStartOffset(Dynamic dynamic) {
        this.mStartOffset = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.TextView
    public void setMethod(@Nullable String str) {
        this.mMethod = TextProperties.TextPathMethod.valueOf(str);
        invalidate();
    }

    public void setSpacing(@Nullable String str) {
        this.mSpacing = TextProperties.TextPathSpacing.valueOf(str);
        invalidate();
    }

    public void setSide(@Nullable String str) {
        this.mSide = TextProperties.TextPathSide.valueOf(str);
        invalidate();
    }

    public void setSharp(@Nullable String str) {
        this.mMidLine = TextProperties.TextPathMidLine.valueOf(str);
        invalidate();
    }

    TextProperties.TextPathMethod getMethod() {
        return this.mMethod;
    }

    TextProperties.TextPathSpacing getSpacing() {
        return this.mSpacing;
    }

    TextProperties.TextPathSide getSide() {
        return this.mSide;
    }

    TextProperties.TextPathMidLine getMidLine() {
        return this.mMidLine;
    }

    SVGLength getStartOffset() {
        return this.mStartOffset;
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        drawGroup(canvas, paint, f);
    }

    Path getTextPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate instanceof RenderableView) {
            return ((RenderableView) definedTemplate).getPath(canvas, paint);
        }
        return null;
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        return getGroupPath(canvas, paint);
    }
}
