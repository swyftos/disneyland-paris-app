package com.mrousavy.camera.core.extensions;

import android.annotation.SuppressLint;
import android.location.Location;
import android.media.MediaActionSound;
import android.util.Log;
import androidx.camera.core.ImageCapture;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.MetadataProvider;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087H¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"takePicture", "Lcom/mrousavy/camera/core/extensions/PhotoFileInfo;", "Landroidx/camera/core/ImageCapture;", "file", "Ljava/io/File;", "isMirrored", "", "enableShutterSound", "metadataProvider", "Lcom/mrousavy/camera/core/MetadataProvider;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "executor", "Ljava/util/concurrent/Executor;", "(Landroidx/camera/core/ImageCapture;Ljava/io/File;ZZLcom/mrousavy/camera/core/MetadataProvider;Lcom/mrousavy/camera/core/CameraSession$Callback;Ljava/util/concurrent/Executor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageCapture+takePicture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageCapture+takePicture.kt\ncom/mrousavy/camera/core/extensions/ImageCapture_takePictureKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,77:1\n351#2,11:78\n*S KotlinDebug\n*F\n+ 1 ImageCapture+takePicture.kt\ncom/mrousavy/camera/core/extensions/ImageCapture_takePictureKt\n*L\n30#1:78,11\n*E\n"})
/* loaded from: classes4.dex */
public final class ImageCapture_takePictureKt {
    @SuppressLint({"RestrictedApi"})
    @Nullable
    public static final Object takePicture(@NotNull ImageCapture imageCapture, @NotNull File file, boolean z, boolean z2, @NotNull MetadataProvider metadataProvider, @NotNull CameraSession.Callback callback, @NotNull Executor executor, @NotNull Continuation<? super PhotoFileInfo> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        MediaActionSound mediaActionSound = z2 ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
        }
        ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(file);
        ImageCapture.Metadata metadata = new ImageCapture.Metadata();
        Location location = metadataProvider.getLocation();
        if (location != null) {
            Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            metadata.setLocation(metadataProvider.getLocation());
        }
        metadata.setReversedHorizontal(z);
        builder.setMetadata(metadata);
        ImageCapture.OutputFileOptions outputFileOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "build(...)");
        imageCapture.lambda$takePicture$2(outputFileOptionsBuild, executor, new ImageCapture_takePictureKt$takePicture$2$1(z2, mediaActionSound, callback, cancellableContinuationImpl, file, outputFileOptionsBuild));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
