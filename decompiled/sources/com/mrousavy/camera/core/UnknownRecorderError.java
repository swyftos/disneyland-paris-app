package com.mrousavy.camera.core;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/UnknownRecorderError;", "Lcom/mrousavy/camera/core/RecorderError;", "wasVideoRecorded", "", "cause", "", "<init>", "(ZLjava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnknownRecorderError extends RecorderError {
    public UnknownRecorderError(boolean z, @Nullable Throwable th) {
        super("recorder-error", "An error occurred while recording a video! " + CameraErrorKt.getVideoCapturedMessage(z) + " " + (th != null ? th.getMessage() : null), z, th);
    }
}
