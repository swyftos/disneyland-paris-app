package androidx.camera.core;

import androidx.annotation.NonNull;
import java.util.Set;

/* loaded from: classes.dex */
public interface ImageCaptureCapabilities {
    @NonNull
    @ExperimentalImageCaptureOutputFormat
    Set<Integer> getSupportedOutputFormats();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();
}
