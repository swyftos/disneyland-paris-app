package com.urbanairship.android.layout.widget;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Dimension;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.property.TextAppearance;
import com.urbanairship.android.layout.shape.Shape;
import com.urbanairship.android.layout.util.LayoutUtils;
import java.util.List;

/* loaded from: classes5.dex */
public class ShapeButton extends AppCompatButton implements Checkable, Clippable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private OnCheckedChangeListener checkedChangeListener;
    private final TextAppearance checkedTextAppearance;
    private final ClippableViewDelegate clippableViewDelegate;
    private boolean isChecked;
    private final String text;
    private final TextAppearance uncheckedTextAppearance;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(View view, boolean z);
    }

    public ShapeButton(@NonNull Context context, @NonNull List<Shape> list, @NonNull List<Shape> list2, @Nullable String str, @Nullable TextAppearance textAppearance, @Nullable TextAppearance textAppearance2) {
        this(context, list, list2, null, null, str, textAppearance, textAppearance2);
    }

    public ShapeButton(@NonNull Context context, @NonNull List<Shape> list, @NonNull List<Shape> list2, @Nullable Image.Icon icon, @Nullable Image.Icon icon2) {
        this(context, list, list2, icon, icon2, null, null, null);
    }

    public ShapeButton(@NonNull Context context, @NonNull List<Shape> list, @NonNull List<Shape> list2, @Nullable Image.Icon icon, @Nullable Image.Icon icon2, @Nullable String str, @Nullable TextAppearance textAppearance, @Nullable TextAppearance textAppearance2) {
        super(context);
        this.isChecked = false;
        this.checkedChangeListener = null;
        this.checkedTextAppearance = textAppearance;
        this.uncheckedTextAppearance = textAppearance2;
        this.text = str;
        this.clippableViewDelegate = new ClippableViewDelegate();
        setBackground(Shape.buildStateListDrawable(context, list, list2, icon, icon2));
        setForeground(ContextCompat.getDrawable(context, com.urbanairship.android.layout.R.drawable.ua_layout_imagebutton_ripple));
        setText(str);
        updateText();
        setPadding(0, 0, 0, 0);
        setGravity(17);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z != this.isChecked) {
            this.isChecked = z;
            refreshDrawableState();
            updateText();
            OnCheckedChangeListener onCheckedChangeListener = this.checkedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    public void toggle() {
        setChecked(!this.isChecked);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        return zPerformClick;
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    @MainThread
    public void setClipPathBorderRadius(@Dimension float f) {
        this.clippableViewDelegate.setClipPathBorderRadius(this, f);
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    @MainThread
    public void setClipPathBorderRadius(float[] fArr) {
        this.clippableViewDelegate.setClipPathBorderRadii(this, fArr);
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.checkedChangeListener = onCheckedChangeListener;
    }

    private void updateText() {
        if (this.text == null || this.checkedTextAppearance == null || this.uncheckedTextAppearance == null) {
            return;
        }
        LayoutUtils.applyTextAppearance(this, isChecked() ? this.checkedTextAppearance : this.uncheckedTextAppearance);
    }
}
