package eightbitlab.com.blurview;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public interface BlurAlgorithm {
    Bitmap blur(Bitmap bitmap, float f);

    boolean canModifyBitmap();

    void destroy();

    @NonNull
    Bitmap.Config getSupportedBitmapConfig();
}
