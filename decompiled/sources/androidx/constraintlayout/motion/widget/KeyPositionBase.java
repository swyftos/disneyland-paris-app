package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    @Override // androidx.constraintlayout.motion.widget.Key
    void getAttributeNames(HashSet hashSet) {
    }

    public abstract boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2);

    abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr);

    KeyPositionBase() {
    }
}
