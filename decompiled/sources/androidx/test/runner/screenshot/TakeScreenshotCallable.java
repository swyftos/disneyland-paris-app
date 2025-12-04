package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class TakeScreenshotCallable implements Callable<Bitmap> {
    private WeakReference viewRef;

    @VisibleForTesting
    static class Factory {
        Factory() {
        }

        Callable create(View view) {
            return new TakeScreenshotCallable(view);
        }
    }

    private TakeScreenshotCallable(View view) {
        this.viewRef = new WeakReference(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() {
        ((View) this.viewRef.get()).setDrawingCacheEnabled(true);
        try {
            try {
                return Bitmap.createBitmap(((View) this.viewRef.get()).getDrawingCache());
            } catch (OutOfMemoryError e) {
                Log.e("TakeScreenshotCallable", "Out of memory exception while trying to take a screenshot.", e);
                ((View) this.viewRef.get()).setDrawingCacheEnabled(false);
                return null;
            }
        } finally {
            ((View) this.viewRef.get()).setDrawingCacheEnabled(false);
        }
    }
}
