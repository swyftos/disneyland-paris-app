package androidx.transition;

import android.graphics.Canvas;
import androidx.annotation.DoNotInline;

/* loaded from: classes2.dex */
abstract class CanvasUtils {
    static void enableZ(Canvas canvas, boolean z) {
        if (z) {
            Api29Impl.enableZ(canvas);
        } else {
            Api29Impl.disableZ(canvas);
        }
    }

    static class Api29Impl {
        @DoNotInline
        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }

        @DoNotInline
        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }
    }
}
