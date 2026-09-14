package com.mrousavy.camera.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/mrousavy/camera/core/FrameInvalidError;", "Lcom/mrousavy/camera/core/CameraError;", "<init>", "()V", "react-native-vision-camera_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FrameInvalidError extends CameraError {
    public FrameInvalidError() {
        super("capture", "frame-invalid", "Trying to access an already closed Frame! Are you trying to access the Image data outside of a Frame Processor's lifetime?\n- If you want to use `console.log(frame)`, use `console.log(frame.toString())` instead.\n- If you want to do async processing, use `runAsync(...)` instead.\n- If you want to use runOnJS, increment it's ref-count: `frame.incrementRefCount()`", null, 8, null);
    }
}
