package eightbitlab.com.blurview;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface BlurViewFacade {
    BlurViewFacade setBlurAutoUpdate(boolean z);

    BlurViewFacade setBlurEnabled(boolean z);

    BlurViewFacade setBlurRadius(float f);

    BlurViewFacade setFrameClearDrawable(@Nullable Drawable drawable);

    BlurViewFacade setOverlayColor(@ColorInt int i);
}
