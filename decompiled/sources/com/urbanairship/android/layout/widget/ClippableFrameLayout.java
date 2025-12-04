package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class ClippableFrameLayout extends FrameLayout implements Clippable {
    private final ClippableViewDelegate clippableViewDelegate;

    public ClippableFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public ClippableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClippableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ClippableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.clippableViewDelegate = new ClippableViewDelegate();
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
}
