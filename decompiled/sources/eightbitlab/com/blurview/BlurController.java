package eightbitlab.com.blurview;

import android.graphics.Canvas;

/* loaded from: classes5.dex */
interface BlurController extends BlurViewFacade {
    void destroy();

    boolean draw(Canvas canvas);

    void updateBlurViewSize();
}
