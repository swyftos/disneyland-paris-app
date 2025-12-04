package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.imagecapture.TakePictureManager;

/* loaded from: classes.dex */
final class AutoValue_TakePictureManager_CaptureError extends TakePictureManager.CaptureError {
    private final ImageCaptureException imageCaptureException;
    private final int requestId;

    AutoValue_TakePictureManager_CaptureError(int i, ImageCaptureException imageCaptureException) {
        this.requestId = i;
        if (imageCaptureException == null) {
            throw new NullPointerException("Null imageCaptureException");
        }
        this.imageCaptureException = imageCaptureException;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    int getRequestId() {
        return this.requestId;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    ImageCaptureException getImageCaptureException() {
        return this.imageCaptureException;
    }

    public String toString() {
        return "CaptureError{requestId=" + this.requestId + ", imageCaptureException=" + this.imageCaptureException + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TakePictureManager.CaptureError)) {
            return false;
        }
        TakePictureManager.CaptureError captureError = (TakePictureManager.CaptureError) obj;
        return this.requestId == captureError.getRequestId() && this.imageCaptureException.equals(captureError.getImageCaptureException());
    }

    public int hashCode() {
        return this.imageCaptureException.hashCode() ^ ((this.requestId ^ 1000003) * 1000003);
    }
}
