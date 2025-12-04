package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.widget.ConstrainedViewDelegate;

/* loaded from: classes5.dex */
public class ConstrainedFrameLayout extends FrameLayout implements Clippable {
    private final ClippableViewDelegate clippableViewDelegate;
    private final ConstrainedViewDelegate constrainedViewDelegate;

    public ConstrainedFrameLayout(@NonNull Context context, @NonNull ConstrainedSize constrainedSize) {
        super(context);
        this.clippableViewDelegate = new ClippableViewDelegate();
        this.constrainedViewDelegate = new ConstrainedViewDelegate(this, constrainedSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMeasure$1(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.constrainedViewDelegate.onMeasure(i, i2, new ConstrainedViewDelegate.ChildMeasurer() { // from class: com.urbanairship.android.layout.widget.ConstrainedFrameLayout$$ExternalSyntheticLambda0
            @Override // com.urbanairship.android.layout.widget.ConstrainedViewDelegate.ChildMeasurer
            public final void measureChild(View view, int i3, int i4) {
                this.f$0.measureChild(view, i3, i4);
            }
        }, new ConstrainedViewDelegate.Measurable() { // from class: com.urbanairship.android.layout.widget.ConstrainedFrameLayout$$ExternalSyntheticLambda1
            @Override // com.urbanairship.android.layout.widget.ConstrainedViewDelegate.Measurable
            public final void onMeasure(int i3, int i4) {
                this.f$0.lambda$onMeasure$1(i3, i4);
            }
        });
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
