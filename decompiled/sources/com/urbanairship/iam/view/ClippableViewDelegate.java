package com.urbanairship.iam.view;

import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.MainThread;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/iam/view/ClippableViewDelegate;", "", "()V", "setClipPathBorderRadius", "", "view", "Landroid/view/View;", "borderRadius", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClippableViewDelegate {
    @MainThread
    public final void setClipPathBorderRadius(@NotNull View view, float borderRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        final float fApplyDimension = TypedValue.applyDimension(1, borderRadius, view.getResources().getDisplayMetrics());
        if (fApplyDimension == BitmapDescriptorFactory.HUE_RED) {
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        } else {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.urbanairship.iam.view.ClippableViewDelegate.setClipPathBorderRadius.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(@NotNull View view2, @NotNull Outline outline) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    outline.setRoundRect(0, 0, view2.getRight() - view2.getLeft(), view2.getBottom() - view2.getTop(), fApplyDimension);
                }
            });
        }
    }
}
