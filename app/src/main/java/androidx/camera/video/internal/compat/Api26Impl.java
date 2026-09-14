package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class Api26Impl {
    @NonNull
    public static MediaMuxer createMediaMuxer(@NonNull FileDescriptor fileDescriptor, int i) throws IOException {
        return new MediaMuxer(fileDescriptor, i);
    }
}
