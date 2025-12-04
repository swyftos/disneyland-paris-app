package com.urbanairship.android.layout.widget;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Dimension;
import androidx.annotation.MainThread;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/widget/ClippableViewDelegate;", "", "()V", "setClipPathBorderRadii", "", "view", "Landroid/view/View;", "radii", "", "setClipPathBorderRadius", "borderRadius", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClippableViewDelegate {
    @MainThread
    public final void setClipPathBorderRadius(@NotNull View view, @Dimension float borderRadius) {
        float[] fArr;
        Intrinsics.checkNotNullParameter(view, "view");
        if (borderRadius == BitmapDescriptorFactory.HUE_RED) {
            fArr = null;
        } else {
            float[] fArr2 = new float[8];
            for (int i = 0; i < 8; i++) {
                fArr2[i] = borderRadius;
            }
            fArr = fArr2;
        }
        setClipPathBorderRadii(view, fArr);
    }

    @MainThread
    public final void setClipPathBorderRadii(@NotNull View view, @Nullable final float[] radii) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (radii == null) {
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        } else {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.urbanairship.android.layout.widget.ClippableViewDelegate.setClipPathBorderRadii.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(@NotNull View view2, @NotNull Outline outline) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    Rect rect = new Rect(0, 0, view2.getRight() - view2.getLeft(), view2.getBottom() - view2.getTop());
                    if (Build.VERSION.SDK_INT >= 30) {
                        Path path = new Path();
                        path.addRoundRect(new RectF(rect), radii, Path.Direction.CW);
                        outline.setPath(path);
                        return;
                    }
                    outline.setRoundRect(rect, ArraysKt.maxOrThrow(radii));
                }
            });
        }
    }
}
