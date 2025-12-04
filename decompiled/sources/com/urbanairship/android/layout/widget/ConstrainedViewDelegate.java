package com.urbanairship.android.layout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.util.ResourceUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class ConstrainedViewDelegate {
    private final ConstrainedSize size;
    private final WeakReference weakView;

    interface ChildMeasurer {
        void measureChild(View view, int i, int i2);
    }

    interface Measurable {
        void onMeasure(int i, int i2);
    }

    ConstrainedViewDelegate(View view, ConstrainedSize constrainedSize) {
        this.weakView = new WeakReference(view);
        this.size = constrainedSize;
    }

    public void onMeasure(int i, int i2, @NonNull ChildMeasurer childMeasurer, @NonNull Measurable measurable) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        View view = (View) this.weakView.get();
        if (view == null) {
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = view.getLayoutParams().width == -2;
        boolean z2 = view.getLayoutParams().height == -2;
        int iMax = !z ? size : 0;
        int iMax2 = !z2 ? size2 : 0;
        if (z || z2) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    childMeasurer.measureChild(childAt, i, i2);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (z) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                    }
                    if (z2) {
                        iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                    }
                }
            }
            int iConstrainDimension = constrainDimension(this.size.getMinWidth(), this.size.getMaxWidth(), size, iMax);
            int iConstrainDimension2 = constrainDimension(this.size.getMinHeight(), this.size.getMaxHeight(), size2, iMax2);
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iConstrainDimension, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iConstrainDimension2, 1073741824);
        } else {
            iMakeMeasureSpec = i;
            iMakeMeasureSpec2 = i2;
        }
        measurable.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    private int constrainDimension(ConstrainedSize.ConstrainedDimension constrainedDimension, ConstrainedSize.ConstrainedDimension constrainedDimension2, int i, int i2) {
        float fDpToPx;
        View view = (View) this.weakView.get();
        if (view == null) {
            return i2;
        }
        if (constrainedDimension != null) {
            int i3 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[constrainedDimension.getType().ordinal()];
            int iDpToPx = Integer.MIN_VALUE;
            if (i3 != 1) {
                if (i3 == 2) {
                    iDpToPx = (int) ResourceUtils.dpToPx(view.getContext(), constrainedDimension.getInt());
                }
            } else if (i > 0) {
                iDpToPx = (int) (i * constrainedDimension.getFloat());
            }
            if (i2 < iDpToPx) {
                i2 = iDpToPx;
            }
        }
        if (constrainedDimension2 == null) {
            return i2;
        }
        int i4 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[constrainedDimension2.getType().ordinal()];
        int i5 = Integer.MAX_VALUE;
        if (i4 != 1) {
            if (i4 == 2) {
                fDpToPx = ResourceUtils.dpToPx(view.getContext(), constrainedDimension2.getInt());
                i5 = (int) fDpToPx;
            }
        } else if (i > 0) {
            fDpToPx = i * constrainedDimension2.getFloat();
            i5 = (int) fDpToPx;
        }
        return i2 > i5 ? i5 : i2;
    }

    /* renamed from: com.urbanairship.android.layout.widget.ConstrainedViewDelegate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType;

        static {
            int[] iArr = new int[ConstrainedSize.ConstrainedDimensionType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType = iArr;
            try {
                iArr[ConstrainedSize.ConstrainedDimensionType.PERCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[ConstrainedSize.ConstrainedDimensionType.ABSOLUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
