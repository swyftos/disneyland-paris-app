package com.urbanairship.iam.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/iam/view/BoundedViewDelegate;", "", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "defResStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", ViewProps.MAX_HEIGHT, ViewProps.MAX_WIDTH, "getHeightMeasureSpec", "heightMeasureSpec", "getWidthMeasureSpec", "widthMeasureSpec", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BoundedViewDelegate {
    private int maxHeight;
    private int maxWidth;

    public BoundedViewDelegate(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.UrbanAirshipLayout, i, i2);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxWidth, 0);
            this.maxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxHeight, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final int getWidthMeasureSpec(int widthMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i = this.maxWidth;
        return (1 > i || i >= size) ? widthMeasureSpec : View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(widthMeasureSpec));
    }

    public final int getHeightMeasureSpec(int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.maxHeight;
        return (1 > i || i >= size) ? heightMeasureSpec : View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(heightMeasureSpec));
    }
}
