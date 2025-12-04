package eightbitlab.com.blurview;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public interface BlurViewFacade {
    BlurViewFacade setBlurAlgorithm(BlurAlgorithm blurAlgorithm);

    BlurViewFacade setBlurAutoUpdate(boolean z);

    BlurViewFacade setBlurEnabled(boolean z);

    BlurViewFacade setBlurRadius(float f);

    BlurViewFacade setFrameClearDrawable(@Nullable Drawable drawable);

    BlurViewFacade setHasFixedTransformationMatrix(boolean z);

    BlurViewFacade setOverlayColor(@ColorInt int i);
}
