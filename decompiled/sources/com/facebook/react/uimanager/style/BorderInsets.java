package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.RectF;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/uimanager/style/BorderInsets;", "", "<init>", "()V", "edgeInsets", "", "", "[Ljava/lang/Float;", "setBorderWidth", "", "edge", "Lcom/facebook/react/uimanager/style/LogicalEdge;", "width", "(Lcom/facebook/react/uimanager/style/LogicalEdge;Ljava/lang/Float;)V", "resolve", "Landroid/graphics/RectF;", ViewProps.LAYOUT_DIRECTION, "", "context", "Landroid/content/Context;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BorderInsets {

    @NotNull
    private final Float[] edgeInsets = new Float[LogicalEdge.values().length];

    public final void setBorderWidth(@NotNull LogicalEdge edge, @Nullable Float width) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        this.edgeInsets[edge.ordinal()] = width;
    }

    @NotNull
    public final RectF resolve(int layoutDirection, @NotNull Context context) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(context, "context");
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        if (layoutDirection == 0) {
            Float f = this.edgeInsets[LogicalEdge.START.ordinal()];
            float fFloatValue2 = (f == null && (f = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f.floatValue();
            Float f2 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
            float fFloatValue3 = (f2 == null && (f2 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f2.floatValue();
            Float f3 = this.edgeInsets[LogicalEdge.END.ordinal()];
            float fFloatValue4 = (f3 == null && (f3 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f3 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f3 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f3.floatValue();
            Float f4 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
            if (f4 == null && (f4 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f4 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f4 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null) {
                Float f5 = this.edgeInsets[LogicalEdge.ALL.ordinal()];
                if (f5 != null) {
                    fFloatValue = f5.floatValue();
                }
            } else {
                fFloatValue = f4.floatValue();
            }
            rectF = new RectF(fFloatValue2, fFloatValue3, fFloatValue4, fFloatValue);
        } else if (layoutDirection == 1) {
            if (I18nUtil.INSTANCE.getInstance().doLeftAndRightSwapInRTL(context)) {
                Float f6 = this.edgeInsets[LogicalEdge.END.ordinal()];
                float fFloatValue5 = (f6 == null && (f6 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f6 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f6 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f6.floatValue();
                Float f7 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
                float fFloatValue6 = (f7 == null && (f7 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f7 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f7 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f7 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f7.floatValue();
                Float f8 = this.edgeInsets[LogicalEdge.START.ordinal()];
                float fFloatValue7 = (f8 == null && (f8 = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f8 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f8 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f8.floatValue();
                Float f9 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
                if (f9 == null && (f9 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f9 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f9 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null) {
                    Float f10 = this.edgeInsets[LogicalEdge.ALL.ordinal()];
                    if (f10 != null) {
                        fFloatValue = f10.floatValue();
                    }
                } else {
                    fFloatValue = f9.floatValue();
                }
                rectF = new RectF(fFloatValue5, fFloatValue6, fFloatValue7, fFloatValue);
            } else {
                Float f11 = this.edgeInsets[LogicalEdge.END.ordinal()];
                float fFloatValue8 = (f11 == null && (f11 = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f11 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f11 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f11.floatValue();
                Float f12 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
                float fFloatValue9 = (f12 == null && (f12 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f12.floatValue();
                Float f13 = this.edgeInsets[LogicalEdge.START.ordinal()];
                float fFloatValue10 = (f13 == null && (f13 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f13 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f13 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f13.floatValue();
                Float f14 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
                if (f14 == null && (f14 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f14 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f14 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null) {
                    Float f15 = this.edgeInsets[LogicalEdge.ALL.ordinal()];
                    if (f15 != null) {
                        fFloatValue = f15.floatValue();
                    }
                } else {
                    fFloatValue = f14.floatValue();
                }
                rectF = new RectF(fFloatValue8, fFloatValue9, fFloatValue10, fFloatValue);
            }
        } else {
            throw new IllegalArgumentException("Expected resolved layout direction");
        }
        return rectF;
    }
}
