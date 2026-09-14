package eightbitlab.com.blurview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public interface BlurAlgorithm {
    Bitmap blur(@NonNull Bitmap bitmap, @NonNull float f);

    boolean canModifyBitmap();

    void destroy();

    @NonNull
    Bitmap.Config getSupportedBitmapConfig();

    void render(@NonNull Canvas canvas, @NonNull Bitmap bitmap);

    float scaleFactor();
}
