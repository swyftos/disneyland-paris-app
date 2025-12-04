package com.mrousavy.camera.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/InvalidFpsError;", "Lcom/mrousavy/camera/core/CameraError;", "fps", "", "<init>", "(I)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvalidFpsError extends CameraError {
    public InvalidFpsError(int i) {
        super("format", "invalid-fps", "The given format cannot run at " + i + " FPS! Make sure your FPS is lower than `format.maxFps` but higher than `format.minFps`.", null, 8, null);
    }
}
