package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled(int i) {
    }

    public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(int i, @NonNull CameraCaptureFailure cameraCaptureFailure) {
    }

    public void onCaptureProcessProgressed(int i, int i2) {
    }

    public void onCaptureStarted(int i) {
    }
}
