package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.impl.utils.futures.Futures;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    @NonNull
    default ListenableFuture<Void> snapshot(@IntRange(from = 0, to = WebToNativeBridgeBase.CLOSE_WAIT_DURATION_MILLISECONDS) int i, @IntRange(from = 0, to = 359) int i2) {
        return Futures.immediateFuture(null);
    }
}
