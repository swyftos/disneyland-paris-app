package com.mrousavy.camera.core;

import androidx.annotation.OptIn;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.frameprocessors.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/FrameProcessorPipeline;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "<init>", "(Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FrameProcessorPipeline implements ImageAnalysis.Analyzer {
    private final CameraSession.Callback callback;

    public FrameProcessorPipeline(@NotNull CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    @OptIn(markerClass = {ExperimentalGetImage.class})
    public void analyze(@NotNull ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Frame frame = new Frame(imageProxy);
        try {
            frame.incrementRefCount();
            this.callback.onFrame(frame);
        } finally {
            frame.decrementRefCount();
        }
    }
}
