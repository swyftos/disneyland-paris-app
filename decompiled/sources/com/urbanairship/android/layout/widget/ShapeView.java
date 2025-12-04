package com.urbanairship.android.layout.widget;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.shape.Shape;
import java.util.List;

/* loaded from: classes5.dex */
public class ShapeView extends ImageView implements Checkable, Clippable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private final ClippableViewDelegate clippableViewDelegate;
    private boolean isChecked;

    public ShapeView(Context context, List<Shape> list, List<Shape> list2) {
        this(context, list, list2, null, null);
    }

    public ShapeView(Context context, @NonNull List<Shape> list, @NonNull List<Shape> list2, @Nullable Image.Icon icon, @Nullable Image.Icon icon2) {
        super(context);
        this.clippableViewDelegate = new ClippableViewDelegate();
        this.isChecked = false;
        setId(View.generateViewId());
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setImageDrawable(Shape.buildStateListDrawable(context, list, list2, icon, icon2));
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z != this.isChecked) {
            this.isChecked = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    public void setClipPathBorderRadius(float f) {
        this.clippableViewDelegate.setClipPathBorderRadius(this, f);
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    @MainThread
    public void setClipPathBorderRadius(float[] fArr) {
        this.clippableViewDelegate.setClipPathBorderRadii(this, fArr);
    }
}
