package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class WeightlessLinearLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int gravity;
    private int orientation;
    private int totalLength;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public WeightlessLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public WeightlessLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeightlessLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gravity = 8388659;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WeightlessLinearLayout, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.WeightlessLinearLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.WeightlessLinearLayout_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.WeightlessLinearLayout_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOrientation(int i) {
        if (this.orientation != i) {
            this.orientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setGravity(int i) {
        if (this.gravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & SyslogConstants.LOG_ALERT) == 0) {
                i |= 48;
            }
            this.gravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.gravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.gravity;
        if ((8388615 & i3) != i2) {
            this.gravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & SyslogConstants.LOG_ALERT;
        int i3 = this.gravity;
        if ((i3 & SyslogConstants.LOG_ALERT) != i2) {
            this.gravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.orientation;
        if (i == 0) {
            return new LayoutParams(-2, -1);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("com.urbanairship.android.layout.widget.WeightlessLinearLayout");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("com.urbanairship.android.layout.widget.WeightlessLinearLayout");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.orientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.orientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureVertical(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 1165
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.widget.WeightlessLinearLayout.measureVertical(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$measureVertical$0(View view, View view2) {
        return Float.compare(((LayoutParams) view.getLayoutParams()).maxHeightPercent, ((LayoutParams) view2.getLayoutParams()).maxHeightPercent);
    }

    private void forceUniformWidth(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureHorizontal(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 1146
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.widget.WeightlessLinearLayout.measureHorizontal(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$measureHorizontal$1(View view, View view2) {
        return Float.compare(((LayoutParams) view.getLayoutParams()).maxWidthPercent, ((LayoutParams) view2.getLayoutParams()).maxWidthPercent);
    }

    private void forceUniformHeight(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i2, 0, iMakeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int childCount = getChildCount();
        int i7 = this.gravity;
        int i8 = i7 & SyslogConstants.LOG_ALERT;
        int i9 = i7 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i8 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.totalLength) / 2);
        } else if (i8 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.totalLength;
        } else {
            paddingTop = getPaddingTop();
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i9;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i5 = ((((paddingRight2 - measuredWidth) - i12) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) / 2) + paddingLeft + i12;
                } else if (absoluteGravity == 5) {
                    i5 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else {
                    i5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                }
                int i13 = i5;
                int i14 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                setChildFrame(childAt, i13, i14, measuredWidth, measuredHeight);
                paddingTop = i14 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
    }

    private void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        WeightlessLinearLayout weightlessLinearLayout = this;
        int i8 = 1;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int paddingTop = getPaddingTop();
        int i9 = i4 - i2;
        int paddingBottom = i9 - getPaddingBottom();
        int paddingBottom2 = (i9 - paddingTop) - getPaddingBottom();
        int childCount = getChildCount();
        int i10 = weightlessLinearLayout.gravity;
        int i11 = i10 & SyslogConstants.LOG_ALERT;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i10, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i3 - i) - weightlessLinearLayout.totalLength) / 2);
        } else if (absoluteGravity == 5) {
            paddingLeft = ((getPaddingLeft() + i3) - i) - weightlessLinearLayout.totalLength;
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z) {
            i8 = -1;
            i5 = childCount - 1;
        } else {
            i5 = 0;
        }
        int i12 = i8;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = weightlessLinearLayout.getChildAt((i12 * i13) + i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i11;
                }
                int i15 = i14 & SyslogConstants.LOG_ALERT;
                if (i15 == 16) {
                    int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i6 = ((((paddingBottom2 - measuredHeight) - i16) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) / 2) + paddingTop + i16;
                } else if (i15 == 48) {
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                } else if (i15 == 80) {
                    i6 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else {
                    i7 = paddingTop;
                    int i17 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    setChildFrame(childAt, i17, i7, measuredWidth, measuredHeight);
                    paddingLeft = i17 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i7 = i6;
                int i172 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                setChildFrame(childAt, i172, i7, measuredWidth, measuredHeight);
                paddingLeft = i172 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }
            i13++;
            weightlessLinearLayout = this;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float maxHeightPercent;
        public float maxWidthPercent;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.maxWidthPercent = BitmapDescriptorFactory.HUE_RED;
            this.maxHeightPercent = BitmapDescriptorFactory.HUE_RED;
            this.gravity = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WeightlessLinearLayout_Layout);
            this.maxWidthPercent = typedArrayObtainStyledAttributes.getFloat(R.styleable.WeightlessLinearLayout_Layout_maxPercentWidth, BitmapDescriptorFactory.HUE_RED);
            this.maxHeightPercent = typedArrayObtainStyledAttributes.getFloat(R.styleable.WeightlessLinearLayout_Layout_maxPercentHeight, BitmapDescriptorFactory.HUE_RED);
            this.gravity = typedArrayObtainStyledAttributes.getInt(R.styleable.WeightlessLinearLayout_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.maxWidthPercent = BitmapDescriptorFactory.HUE_RED;
            this.maxHeightPercent = BitmapDescriptorFactory.HUE_RED;
            this.gravity = -1;
        }

        public LayoutParams(int i, int i2, float f, float f2) {
            super(i, i2);
            this.gravity = -1;
            this.maxWidthPercent = f;
            this.maxHeightPercent = f2;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.maxWidthPercent = BitmapDescriptorFactory.HUE_RED;
            this.maxHeightPercent = BitmapDescriptorFactory.HUE_RED;
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.maxWidthPercent = BitmapDescriptorFactory.HUE_RED;
            this.maxHeightPercent = BitmapDescriptorFactory.HUE_RED;
            this.gravity = -1;
        }

        @NonNull
        public String toString() {
            return String.format("LayoutParams{ width = %d, height = %d, maxWidth = %.2f, maxHeight = %.2f }", Integer.valueOf(((ViewGroup.MarginLayoutParams) this).width), Integer.valueOf(((ViewGroup.MarginLayoutParams) this).height), Float.valueOf(this.maxWidthPercent), Float.valueOf(this.maxHeightPercent));
        }
    }
}
