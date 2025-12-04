package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface InputBuffer {
    boolean cancel();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    ListenableFuture<Void> getTerminationFuture();

    void setEndOfStream(boolean z);

    void setPresentationTimeUs(long j);

    boolean submit();
}
