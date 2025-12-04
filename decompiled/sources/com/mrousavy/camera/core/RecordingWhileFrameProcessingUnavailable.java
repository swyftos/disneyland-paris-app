package com.mrousavy.camera.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/RecordingWhileFrameProcessingUnavailable;", "Lcom/mrousavy/camera/core/CameraError;", "<init>", "()V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecordingWhileFrameProcessingUnavailable extends CameraError {
    public RecordingWhileFrameProcessingUnavailable() {
        super("system", "recording-while-frame-processing-unavailable", "Video Recordings are not possible with a Frame Processor running, because the device is running on API 22 or lower and ImageWriters are not available.", null, 8, null);
    }
}
