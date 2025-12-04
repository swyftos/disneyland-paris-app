package com.mrousavy.camera.core.extensions;

import android.annotation.SuppressLint;
import android.media.MediaActionSound;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import ch.qos.logback.core.net.SyslogConstants;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.types.ShutterType;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/mrousavy/camera/core/extensions/ImageCapture_takePictureKt$takePicture$2$1", "Landroidx/camera/core/ImageCapture$OnImageSavedCallback;", "onCaptureStarted", "", "onImageSaved", "outputFileResults", "Landroidx/camera/core/ImageCapture$OutputFileResults;", PDFView.EVENT_ON_ERROR, "exception", "Landroidx/camera/core/ImageCaptureException;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = SyslogConstants.LOG_LOCAL6)
/* loaded from: classes4.dex */
public final class ImageCapture_takePictureKt$takePicture$2$1 implements ImageCapture.OnImageSavedCallback {
    final /* synthetic */ CameraSession.Callback $callback;
    final /* synthetic */ CancellableContinuation $continuation;
    final /* synthetic */ boolean $enableShutterSound;
    final /* synthetic */ File $file;
    final /* synthetic */ ImageCapture.OutputFileOptions $outputFileOptions;
    final /* synthetic */ MediaActionSound $shutterSound;

    public ImageCapture_takePictureKt$takePicture$2$1(boolean z, MediaActionSound mediaActionSound, CameraSession.Callback callback, CancellableContinuation<? super PhotoFileInfo> cancellableContinuation, File file, ImageCapture.OutputFileOptions outputFileOptions) {
        this.$enableShutterSound = z;
        this.$shutterSound = mediaActionSound;
        this.$callback = callback;
        this.$continuation = cancellableContinuation;
        this.$file = file;
        this.$outputFileOptions = outputFileOptions;
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    public void onCaptureStarted() {
        MediaActionSound mediaActionSound;
        super.onCaptureStarted();
        if (this.$enableShutterSound && (mediaActionSound = this.$shutterSound) != null) {
            mediaActionSound.play(0);
        }
        this.$callback.onShutter(ShutterType.PHOTO);
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    @SuppressLint({"RestrictedApi"})
    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        Intrinsics.checkNotNullParameter(outputFileResults, "outputFileResults");
        if (this.$continuation.isActive()) {
            URI uri = this.$file.toURI();
            Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
            ImageCapture.Metadata metadata = this.$outputFileOptions.getMetadata();
            Intrinsics.checkNotNullExpressionValue(metadata, "getMetadata(...)");
            this.$continuation.resumeWith(Result.m2968constructorimpl(new PhotoFileInfo(uri, metadata)));
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
    public void onError(ImageCaptureException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (this.$continuation.isActive()) {
            CancellableContinuation cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(exception)));
        }
    }
}
