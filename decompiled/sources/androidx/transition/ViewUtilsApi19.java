package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes2.dex */
abstract class ViewUtilsApi19 {
    public void clearNonTransitionAlpha(View view) {
    }

    public abstract float getTransitionAlpha(View view);

    public void saveNonTransitionAlpha(View view) {
    }

    public abstract void setAnimationMatrix(View view, Matrix matrix);

    public abstract void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4);

    public abstract void setTransitionAlpha(View view, float f);

    public abstract void setTransitionVisibility(View view, int i);

    public abstract void transformMatrixToGlobal(View view, Matrix matrix);

    public abstract void transformMatrixToLocal(View view, Matrix matrix);

    ViewUtilsApi19() {
    }
}
