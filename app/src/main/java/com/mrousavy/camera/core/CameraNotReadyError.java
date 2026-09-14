package com.mrousavy.camera.core;

import com.allegion.accesssdk.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/mrousavy/camera/core/CameraNotReadyError;", "Lcom/mrousavy/camera/core/CameraError;", "<init>", "()V", "react-native-vision-camera_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class CameraNotReadyError extends CameraError {
    public CameraNotReadyError() {
        super(BuildConfig.SESSION_KEY_REFERENCE, "camera-not-ready", "The Camera is not ready yet! Wait for the onInitialized() callback!", null, 8, null);
    }
}
