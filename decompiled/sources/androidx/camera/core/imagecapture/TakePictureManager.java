package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCaptureException;
import com.google.auto.value.AutoValue;
import java.util.List;

/* loaded from: classes.dex */
public interface TakePictureManager {

    public interface Provider {
        @NonNull
        TakePictureManager newInstance(@NonNull ImageCaptureControl imageCaptureControl);
    }

    @MainThread
    void abortRequests();

    @Nullable
    @VisibleForTesting
    RequestWithCallback getCapturingRequest();

    @NonNull
    @VisibleForTesting
    ImagePipeline getImagePipeline();

    @NonNull
    @VisibleForTesting
    List<RequestWithCallback> getIncompleteRequests();

    @VisibleForTesting
    boolean hasCapturingRequest();

    @MainThread
    void offerRequest(@NonNull TakePictureRequest takePictureRequest);

    @MainThread
    void pause();

    @MainThread
    void resume();

    @MainThread
    void setImagePipeline(@NonNull ImagePipeline imagePipeline);

    @AutoValue
    public static abstract class CaptureError {
        abstract ImageCaptureException getImageCaptureException();

        abstract int getRequestId();

        static CaptureError of(int i, ImageCaptureException imageCaptureException) {
            return new AutoValue_TakePictureManager_CaptureError(i, imageCaptureException);
        }
    }
}
