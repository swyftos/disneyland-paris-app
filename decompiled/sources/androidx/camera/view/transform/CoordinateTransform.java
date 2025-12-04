package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.TransformExperimental;
import androidx.core.util.Preconditions;

@TransformExperimental
/* loaded from: classes.dex */
public final class CoordinateTransform {
    private final Matrix mMatrix;

    public CoordinateTransform(@NonNull OutputTransform outputTransform, @NonNull OutputTransform outputTransform2) {
        if (!TransformUtils.isAspectRatioMatchingWithRoundingError(outputTransform.getViewPortSize(), outputTransform2.getViewPortSize())) {
            Logger.w("CoordinateTransform", String.format("The source viewport (%s) does not match the target viewport (%s). Please make sure they are associated with the same Viewport.", outputTransform.getViewPortSize(), outputTransform2.getViewPortSize()));
        }
        Matrix matrix = new Matrix();
        this.mMatrix = matrix;
        Preconditions.checkState(outputTransform.getMatrix().invert(matrix), "The source transform cannot be inverted");
        matrix.postConcat(outputTransform2.getMatrix());
    }

    public void transform(@NonNull Matrix matrix) {
        matrix.set(this.mMatrix);
    }

    public void mapPoints(@NonNull float[] fArr) {
        this.mMatrix.mapPoints(fArr);
    }

    public void mapPoint(@NonNull PointF pointF) {
        float[] fArr = {pointF.x, pointF.y};
        this.mMatrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
    }

    public void mapRect(@NonNull RectF rectF) {
        this.mMatrix.mapRect(rectF);
    }
}
