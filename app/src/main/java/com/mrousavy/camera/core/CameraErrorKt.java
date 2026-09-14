package com.mrousavy.camera.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, m1836d2 = {"getVideoCapturedMessage", "", "wasVideoCaptured", "", "react-native-vision-camera_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class CameraErrorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getVideoCapturedMessage(boolean z) {
        if (z) {
            return "The output file was generated, so the recording may be valid.";
        }
        return "The output file was generated but the recording will not be valid, so you should delete the file.";
    }
}
