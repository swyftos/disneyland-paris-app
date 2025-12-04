package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public interface BufferProvider<T> extends Observable<State> {

    public enum State {
        ACTIVE,
        INACTIVE
    }

    @NonNull
    ListenableFuture<T> acquireBuffer();
}
