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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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

    /* JADX WARN: Code duplicated, block: B:102:0x0281  */
    /* JADX WARN: Code duplicated, block: B:106:0x0293  */
    /* JADX WARN: Code duplicated, block: B:147:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:170:0x0435  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c3  */
    /* JADX WARN: Multi-variable type inference failed */
    private void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iMax;
        int iMax2;
        int i9;
        int i10;
        boolean z;
        int childMeasureSpec;
        int i11;
        ArrayList arrayList;
        int childMeasureSpec2;
        int i12;
        int i13;
        int iMakeMeasureSpec;
        int i14;
        int i15;
        int i16;
        View view;
        int i17;
        int i18;
        int i19;
        boolean z2;
        this.totalLength = 0;
        int childCount = getChildCount();
        ArrayList arrayList2 = new ArrayList();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int iMax3 = 0;
        int iMax4 = 0;
        int iCombineMeasuredStates = 0;
        int iMax5 = 0;
        int i20 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        while (i20 < childCount) {
            View childAt = getChildAt(i20);
            if (childAt == null || childAt.getVisibility() == 8) {
                i20 = i20;
                childCount = childCount;
                arrayList2 = arrayList2;
                size = size;
                mode2 = mode2;
                i16 = iMax3;
                iMax4 = iMax4;
                iMax5 = iMax5;
                iCombineMeasuredStates = iCombineMeasuredStates;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.maxHeightPercent > BitmapDescriptorFactory.HUE_RED) {
                    arrayList2.add(childAt);
                }
                if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && layoutParams.maxHeightPercent > BitmapDescriptorFactory.HUE_RED) {
                    int i21 = this.totalLength;
                    this.totalLength = Math.max(i21, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i21 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    view = childAt;
                    i16 = iMax3;
                    i19 = 1073741824;
                    z4 = true;
                } else {
                    view = childAt;
                    int i22 = iMax3;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height != 0 || layoutParams.maxHeightPercent <= BitmapDescriptorFactory.HUE_RED) {
                        i17 = Integer.MIN_VALUE;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                        i17 = 0;
                    }
                    int marginStart = layoutParams.getMarginStart() + layoutParams.getMarginEnd();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                        float f = layoutParams.maxWidthPercent;
                        if (f > BitmapDescriptorFactory.HUE_RED) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = ((int) (size * f)) - marginStart;
                            i18 = 0;
                        } else {
                            i18 = Integer.MIN_VALUE;
                        }
                    } else {
                        i18 = Integer.MIN_VALUE;
                    }
                    int i23 = !arrayList2.isEmpty() ? this.totalLength : 0;
                    i16 = i22;
                    int i24 = i17;
                    measureChildWithMargins(view, i, marginStart, i2, i23);
                    if (i24 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i24;
                    }
                    if (i18 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i18;
                    }
                    int measuredHeight = view.getMeasuredHeight();
                    int i25 = this.totalLength;
                    this.totalLength = Math.max(i25, measuredHeight + i25 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    i19 = 1073741824;
                }
                if (mode == i19 || ((ViewGroup.MarginLayoutParams) layoutParams).width != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z3 = true;
                }
                int marginStart2 = layoutParams.getMarginStart() + layoutParams.getMarginEnd();
                int measuredWidth = view.getMeasuredWidth() + marginStart2;
                iMax5 = Math.max(iMax5, measuredWidth);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                z5 = z5 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1;
                if (layoutParams.maxHeightPercent > BitmapDescriptorFactory.HUE_RED) {
                    if (!z2) {
                        marginStart2 = measuredWidth;
                    }
                    iMax3 = Math.max(i16, marginStart2);
                    iMax4 = iMax4;
                } else {
                    if (!z2) {
                        marginStart2 = measuredWidth;
                    }
                    iMax4 = Math.max(iMax4, marginStart2);
                }
                i20++;
                arrayList2 = arrayList2;
                mode2 = mode2;
                size = size;
                childCount = childCount;
            }
            iMax3 = i16;
            i20++;
            arrayList2 = arrayList2;
            mode2 = mode2;
            size = size;
            childCount = childCount;
        }
        int i26 = iMax4;
        int i27 = childCount;
        ArrayList arrayList3 = arrayList2;
        int i28 = size;
        int i29 = mode2;
        int i30 = iMax3;
        int i31 = iCombineMeasuredStates;
        int i32 = iMax5;
        int paddingTop = this.totalLength + getPaddingTop() + getPaddingBottom();
        this.totalLength = paddingTop;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
        int i33 = 16777215 & iResolveSizeAndState;
        int i34 = i33 - this.totalLength;
        if (i34 < 0) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            i6 = i27;
            int i35 = 0;
            int i36 = 0;
            while (i35 < i6) {
                View childAt2 = getChildAt(i35);
                int i37 = i26;
                if (childAt2 != 0) {
                    i14 = i32;
                    if (childAt2.getVisibility() != 8) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        i15 = i31;
                        if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -2 && layoutParams2.maxHeightPercent == BitmapDescriptorFactory.HUE_RED && (childAt2 instanceof ShrinkableView) && ((ShrinkableView) childAt2).isShrinkable()) {
                            arrayList4.add(childAt2);
                            int measuredHeight2 = childAt2.getMeasuredHeight();
                            arrayList5.add(Integer.valueOf(measuredHeight2));
                            i36 += measuredHeight2;
                        }
                    }
                    i35++;
                    i26 = i37;
                    i32 = i14;
                    i31 = i15;
                } else {
                    i14 = i32;
                }
                i15 = i31;
                i35++;
                i26 = i37;
                i32 = i14;
                i31 = i15;
            }
            int i38 = i26;
            i4 = i32;
            i7 = i31;
            if (arrayList4.isEmpty() || i36 < Math.abs(i34)) {
                i3 = i38;
            } else {
                float f2 = (i34 + i36) / i36;
                int i39 = 0;
                while (i39 < arrayList4.size()) {
                    View view2 = (View) arrayList4.get(i39);
                    LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                    int iMax6 = Math.max(0, (int) (((Integer) arrayList5.get(i39)).intValue() * f2));
                    int measuredWidth2 = view2.getMeasuredWidth();
                    int i40 = ((ViewGroup.MarginLayoutParams) layoutParams3).width;
                    float f3 = f2;
                    if (i40 == 0) {
                        float f4 = layoutParams3.maxWidthPercent;
                        if (f4 > BitmapDescriptorFactory.HUE_RED) {
                            if (i28 == 0 && mode == 0) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                                i12 = i28;
                                i13 = 1073741824;
                            } else {
                                i12 = i28;
                                int marginStart3 = ((int) (i12 * f4)) - (layoutParams3.getMarginStart() + layoutParams3.getMarginEnd());
                                i13 = 1073741824;
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(marginStart3, 1073741824);
                            }
                            arrayList = arrayList4;
                            i28 = i12;
                            childMeasureSpec2 = iMakeMeasureSpec;
                            i11 = i13;
                        } else {
                            i11 = 1073741824;
                            arrayList = arrayList4;
                            if (i40 != -1 && mode != 1073741824) {
                                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                            } else {
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, layoutParams3.getMarginStart() + layoutParams3.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                            }
                        }
                    } else {
                        i11 = 1073741824;
                        arrayList = arrayList4;
                        if (i40 != -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, layoutParams3.getMarginStart() + layoutParams3.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                        } else {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, layoutParams3.getMarginStart() + layoutParams3.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                        }
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax6, i11));
                    i39++;
                    i38 = i38;
                    f2 = f3;
                    arrayList4 = arrayList;
                }
                i3 = i38;
                this.totalLength = 0;
                for (int i41 = 0; i41 < i6; i41++) {
                    View childAt3 = getChildAt(i41);
                    if (childAt3 != null && childAt3.getVisibility() != 8) {
                        LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                        this.totalLength += childAt3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
                    }
                }
                int paddingTop2 = this.totalLength + getPaddingTop() + getPaddingBottom();
                this.totalLength = paddingTop2;
                i34 = i33 - paddingTop2;
            }
            i5 = i28;
        } else {
            i3 = i26;
            i4 = i32;
            i5 = i28;
            i6 = i27;
            i7 = i31;
            i = i;
        }
        if (z4 || (i34 != 0 && !arrayList3.isEmpty())) {
            Collections.sort(arrayList3, new Comparator() { // from class: com.urbanairship.android.layout.widget.WeightlessLinearLayout$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return WeightlessLinearLayout.lambda$measureVertical$0((View) obj, (View) obj2);
                }
            });
            int size2 = arrayList3.size();
            int i42 = size2 - 1;
            int i43 = i34;
            int iCombineMeasuredStates2 = i7;
            int i44 = 0;
            while (i44 < size2) {
                View view3 = (View) arrayList3.get(i44);
                int i45 = i3;
                LayoutParams layoutParams5 = (LayoutParams) view3.getLayoutParams();
                if (i29 != 0) {
                    float f5 = i43;
                    float f6 = i33;
                    float f7 = layoutParams5.maxHeightPercent;
                    int size3 = (int) ((f5 >= (f6 * f7) * ((float) (size2 - i44)) ? f7 : (f5 / (arrayList3.size() - i44)) / f6) * f6);
                    if (i44 == i42) {
                        size3 = Math.min(size3, i43);
                    }
                    i43 -= size3;
                    if (((ViewGroup.MarginLayoutParams) layoutParams5).width == 0) {
                        float f8 = layoutParams5.maxWidthPercent;
                        if (f8 <= BitmapDescriptorFactory.HUE_RED) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingStart() + getPaddingEnd() + layoutParams5.getMarginStart() + layoutParams5.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams5).width);
                        } else if (i5 == 0 && mode == 0) {
                            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                        } else {
                            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(((int) (i5 * f8)) - (layoutParams5.getMarginStart() + layoutParams5.getMarginEnd()), 1073741824);
                        }
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingStart() + getPaddingEnd() + layoutParams5.getMarginStart() + layoutParams5.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams5).width);
                    }
                    view3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(size3, 1073741824));
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view3.getMeasuredState() & (-256));
                } else {
                    size2 = size2;
                }
                i44++;
                iResolveSizeAndState = iResolveSizeAndState;
                size2 = size2;
                i33 = i33;
                i3 = i45;
            }
            i8 = iResolveSizeAndState;
            int iMax7 = i3;
            iMax = i4;
            for (int i46 = 0; i46 < i6; i46++) {
                View childAt4 = getChildAt(i46);
                if (childAt4 != null && childAt4.getVisibility() != 8) {
                    LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                    int marginStart4 = layoutParams6.getMarginStart() + layoutParams6.getMarginEnd();
                    int measuredWidth3 = childAt4.getMeasuredWidth() + marginStart4;
                    iMax = Math.max(iMax, measuredWidth3);
                    if (mode != 1073741824) {
                        i10 = -1;
                        if (((ViewGroup.MarginLayoutParams) layoutParams6).width != -1) {
                        }
                        iMax7 = Math.max(iMax7, marginStart4);
                        if (z5 || ((ViewGroup.MarginLayoutParams) layoutParams6).width != i10) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int i47 = this.totalLength;
                        this.totalLength = Math.max(i47, childAt4.getMeasuredHeight() + i47 + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin);
                        z5 = z;
                    } else {
                        i10 = -1;
                    }
                    marginStart4 = measuredWidth3;
                    iMax7 = Math.max(iMax7, marginStart4);
                    if (z5) {
                        z = false;
                    } else {
                        z = false;
                    }
                    int i48 = this.totalLength;
                    this.totalLength = Math.max(i48, childAt4.getMeasuredHeight() + i48 + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin);
                    z5 = z;
                }
            }
            this.totalLength += getPaddingTop() + getPaddingBottom();
            iMax2 = iMax7;
            i9 = iCombineMeasuredStates2;
        } else {
            iMax2 = Math.max(i3, i30);
            i8 = iResolveSizeAndState;
            iMax = i4;
            i9 = i7;
        }
        if (z5 || mode == 1073741824) {
            iMax2 = iMax;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax2 + getPaddingStart() + getPaddingEnd(), getSuggestedMinimumWidth()), i, i9), i8);
        if (z3) {
            forceUniformWidth(i6, i2);
        }
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

    /* JADX WARN: Code duplicated, block: B:100:0x0277  */
    /* JADX WARN: Code duplicated, block: B:104:0x0289  */
    /* JADX WARN: Code duplicated, block: B:144:0x0392  */
    /* JADX WARN: Code duplicated, block: B:167:0x0420  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c2  */
    /* JADX WARN: Multi-variable type inference failed */
    private void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iMax;
        int iMax2;
        int i8;
        int i9;
        int i10;
        boolean z;
        int childMeasureSpec;
        int i11;
        ArrayList arrayList;
        int i12;
        int childMeasureSpec2;
        int i13;
        int i14;
        int iMakeMeasureSpec;
        int i15;
        View view;
        byte b;
        int i16;
        int i17;
        boolean z2;
        this.totalLength = 0;
        int childCount = getChildCount();
        ArrayList arrayList2 = new ArrayList();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int iMax3 = 0;
        int iMax4 = 0;
        int iCombineMeasuredStates = 0;
        int iMax5 = 0;
        int i18 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            if (childAt == null || childAt.getVisibility() == 8) {
                i18 = i18;
                childCount = childCount;
                arrayList2 = arrayList2;
                mode = mode;
                size = size;
                iMax4 = iMax4;
                iMax5 = iMax5;
                iCombineMeasuredStates = iCombineMeasuredStates;
                iMax3 = iMax3;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.maxWidthPercent > BitmapDescriptorFactory.HUE_RED) {
                    arrayList2.add(childAt);
                }
                if (mode == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && layoutParams.maxWidthPercent > BitmapDescriptorFactory.HUE_RED) {
                    int i19 = this.totalLength;
                    this.totalLength = Math.max(i19, i19 + layoutParams.getMarginStart() + layoutParams.getMarginEnd());
                    mode = mode;
                    view = childAt;
                    i17 = 1073741824;
                    z4 = true;
                } else {
                    view = childAt;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width != 0 || layoutParams.maxWidthPercent <= BitmapDescriptorFactory.HUE_RED) {
                        b = -2147483648;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                        b = 0;
                    }
                    byte b2 = b;
                    int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height == 0) {
                        float f = layoutParams.maxHeightPercent;
                        if (f > BitmapDescriptorFactory.HUE_RED) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = ((int) (size * f)) - i20;
                            i16 = 0;
                        } else {
                            i16 = Integer.MIN_VALUE;
                        }
                    } else {
                        i16 = Integer.MIN_VALUE;
                    }
                    int i21 = i16;
                    measureChildWithMargins(view, i, !arrayList2.isEmpty() ? this.totalLength : 0, i2, i20);
                    if (b2 != -2147483648) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = b2;
                    }
                    if (i21 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i21;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    int i22 = this.totalLength;
                    this.totalLength = Math.max(i22, measuredWidth + i22 + layoutParams.getMarginStart() + layoutParams.getMarginEnd());
                    i17 = 1073741824;
                }
                if (mode2 == i17 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z3 = true;
                }
                int i23 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i23;
                iMax5 = Math.max(iMax5, measuredHeight);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                z5 = z5 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1;
                if (layoutParams.maxWidthPercent > BitmapDescriptorFactory.HUE_RED) {
                    if (!z2) {
                        i23 = measuredHeight;
                    }
                    iMax3 = Math.max(iMax3, i23);
                } else {
                    if (!z2) {
                        i23 = measuredHeight;
                    }
                    iMax4 = Math.max(iMax4, i23);
                    iMax3 = iMax3;
                }
                i18++;
                size = size;
                mode = mode;
                arrayList2 = arrayList2;
                childCount = childCount;
            }
            iMax4 = iMax4;
            i18++;
            size = size;
            mode = mode;
            arrayList2 = arrayList2;
            childCount = childCount;
        }
        int i24 = childCount;
        ArrayList arrayList3 = arrayList2;
        int i25 = mode;
        int i26 = size;
        int i27 = iMax3;
        int i28 = iMax4;
        int i29 = iCombineMeasuredStates;
        int paddingStart = this.totalLength + getPaddingStart() + getPaddingEnd();
        this.totalLength = paddingStart;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingStart, getSuggestedMinimumWidth()), i, 0);
        int i30 = 16777215 & iResolveSizeAndState;
        int i31 = i30 - this.totalLength;
        if (i31 < 0) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            i5 = i24;
            int i32 = 0;
            int i33 = 0;
            while (i32 < i5) {
                View childAt2 = getChildAt(i32);
                int i34 = iMax5;
                if (childAt2 != 0) {
                    i15 = i29;
                    if (childAt2.getVisibility() != 8 && ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt2.getLayoutParams())).width == -2 && (childAt2 instanceof ShrinkableView) && ((ShrinkableView) childAt2).isShrinkable()) {
                        arrayList4.add(childAt2);
                        int measuredWidth2 = childAt2.getMeasuredWidth();
                        arrayList5.add(Integer.valueOf(measuredWidth2));
                        i33 += measuredWidth2;
                    }
                } else {
                    i15 = i29;
                }
                i32++;
                iMax5 = i34;
                i29 = i15;
            }
            i3 = iMax5;
            i6 = i29;
            if (arrayList4.isEmpty() || i33 < Math.abs(i31)) {
                i4 = i26;
            } else {
                float f2 = (i31 + i33) / i33;
                int i35 = 0;
                while (i35 < arrayList4.size()) {
                    View view2 = (View) arrayList4.get(i35);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    int iMax6 = Math.max(0, (int) (((Integer) arrayList5.get(i35)).intValue() * f2));
                    int measuredHeight2 = view2.getMeasuredHeight();
                    float f3 = f2;
                    int i36 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                    ArrayList arrayList6 = arrayList4;
                    if (i36 == 0) {
                        float f4 = layoutParams2.maxHeightPercent;
                        if (f4 > BitmapDescriptorFactory.HUE_RED) {
                            if (i26 == 0 && mode2 == 0) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                                i13 = i26;
                                i14 = 1073741824;
                            } else {
                                i13 = i26;
                                int i37 = ((int) (i13 * f4)) - (((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                                i14 = 1073741824;
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i37, 1073741824);
                            }
                            childMeasureSpec2 = iMakeMeasureSpec;
                            arrayList = arrayList5;
                            i12 = i14;
                            i11 = i13;
                        } else {
                            i11 = i26;
                            arrayList = arrayList5;
                            i12 = 1073741824;
                            if (i36 != -1 && mode2 != 1073741824) {
                                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                            } else {
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, i36);
                            }
                        }
                    } else {
                        i11 = i26;
                        arrayList = arrayList5;
                        i12 = 1073741824;
                        if (i36 != -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, i36);
                        } else {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, i36);
                        }
                    }
                    view2.measure(View.MeasureSpec.makeMeasureSpec(iMax6, i12), childMeasureSpec2);
                    i35++;
                    arrayList5 = arrayList;
                    f2 = f3;
                    i26 = i11;
                    arrayList4 = arrayList6;
                }
                i4 = i26;
                this.totalLength = 0;
                for (int i38 = 0; i38 < i5; i38++) {
                    View childAt3 = getChildAt(i38);
                    if (childAt3 != null && childAt3.getVisibility() != 8) {
                        LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                        this.totalLength += childAt3.getMeasuredWidth() + layoutParams3.getMarginStart() + layoutParams3.getMarginEnd();
                    }
                }
                int paddingStart2 = this.totalLength + getPaddingStart() + getPaddingEnd();
                this.totalLength = paddingStart2;
                i31 = i30 - paddingStart2;
            }
        } else {
            i3 = iMax5;
            i4 = i26;
            i5 = i24;
            i6 = i29;
        }
        if (z4 || (i31 != 0 && !arrayList3.isEmpty())) {
            Collections.sort(arrayList3, new Comparator() { // from class: com.urbanairship.android.layout.widget.WeightlessLinearLayout$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return WeightlessLinearLayout.lambda$measureHorizontal$1((View) obj, (View) obj2);
                }
            });
            int size2 = arrayList3.size();
            int i39 = size2 - 1;
            int i40 = i31;
            int iCombineMeasuredStates2 = i6;
            int i41 = 0;
            while (i41 < size2) {
                View view3 = (View) arrayList3.get(i41);
                LayoutParams layoutParams4 = (LayoutParams) view3.getLayoutParams();
                if (i25 != 0) {
                    float f5 = i40;
                    float f6 = i30;
                    float f7 = layoutParams4.maxWidthPercent;
                    int size3 = (int) ((f5 >= (f6 * f7) * ((float) (size2 - i41)) ? f7 : (f5 / (arrayList3.size() - i41)) / f6) * f6);
                    if (i41 == i39) {
                        size3 = Math.min(size3, i40);
                    }
                    i40 -= size3;
                    if (((ViewGroup.MarginLayoutParams) layoutParams4).height == 0) {
                        float f8 = layoutParams4.maxHeightPercent;
                        if (f8 <= BitmapDescriptorFactory.HUE_RED) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams4).height);
                        } else if (i4 == 0 && mode2 == 0) {
                            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                        } else {
                            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(((int) (i4 * f8)) - (((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin), 1073741824);
                        }
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams4).height);
                    }
                    view3.measure(View.MeasureSpec.makeMeasureSpec(size3, 1073741824), childMeasureSpec);
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view3.getMeasuredState() & (-16777216));
                } else {
                    size2 = size2;
                }
                i41++;
                i28 = i28;
                size2 = size2;
                iResolveSizeAndState = iResolveSizeAndState;
                i30 = i30;
            }
            i7 = iResolveSizeAndState;
            int i42 = 0;
            int iMax7 = i28;
            iMax = i3;
            while (i42 < i5) {
                View childAt4 = getChildAt(i42);
                if (childAt4 == null || childAt4.getVisibility() == 8) {
                    i9 = i25;
                } else {
                    LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                    int i43 = ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                    int measuredHeight3 = childAt4.getMeasuredHeight() + i43;
                    iMax = Math.max(iMax, measuredHeight3);
                    i9 = i25;
                    if (i9 != 1073741824) {
                        i10 = -1;
                        if (((ViewGroup.MarginLayoutParams) layoutParams5).height != -1) {
                        }
                        iMax7 = Math.max(iMax7, i43);
                        if (z5 || ((ViewGroup.MarginLayoutParams) layoutParams5).height != i10) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int i44 = this.totalLength;
                        this.totalLength = Math.max(i44, childAt4.getMeasuredWidth() + i44 + layoutParams5.getMarginStart() + layoutParams5.getMarginEnd());
                        z5 = z;
                    } else {
                        i10 = -1;
                    }
                    i43 = measuredHeight3;
                    iMax7 = Math.max(iMax7, i43);
                    if (z5) {
                        z = false;
                    } else {
                        z = false;
                    }
                    int i45 = this.totalLength;
                    this.totalLength = Math.max(i45, childAt4.getMeasuredWidth() + i45 + layoutParams5.getMarginStart() + layoutParams5.getMarginEnd());
                    z5 = z;
                }
                i42++;
                i25 = i9;
            }
            this.totalLength += getPaddingStart() + getPaddingEnd();
            iMax2 = iMax7;
            i8 = iCombineMeasuredStates2;
        } else {
            iMax2 = Math.max(i28, i27);
            i7 = iResolveSizeAndState;
            iMax = i3;
            i8 = i6;
        }
        if (z5 || mode2 == 1073741824) {
            iMax2 = iMax;
        }
        setMeasuredDimension(i7, View.resolveSizeAndState(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i8));
        if (z3) {
            forceUniformHeight(i5, i);
        }
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
                } else {
                    if (i15 != 80) {
                        i7 = paddingTop;
                    } else {
                        i6 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    int i17 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    setChildFrame(childAt, i17, i7, measuredWidth, measuredHeight);
                    paddingLeft = i17 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i7 = i6;
                int i18 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                setChildFrame(childAt, i18, i7, measuredWidth, measuredHeight);
                paddingLeft = i18 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
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
