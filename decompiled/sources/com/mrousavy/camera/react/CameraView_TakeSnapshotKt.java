package com.mrousavy.camera.react;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.view.PreviewView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.SnapshotFailedError;
import com.mrousavy.camera.core.SnapshotFailedPreviewNotEnabledError;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.core.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/react/CameraView;", "Lcom/mrousavy/camera/core/types/TakeSnapshotOptions;", "options", "Lcom/facebook/react/bridge/WritableMap;", "takeSnapshot", "(Lcom/mrousavy/camera/react/CameraView;Lcom/mrousavy/camera/core/types/TakeSnapshotOptions;)Lcom/facebook/react/bridge/WritableMap;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraView_TakeSnapshotKt {
    @NotNull
    public static final WritableMap takeSnapshot(@NotNull CameraView cameraView, @NotNull TakeSnapshotOptions options) throws SnapshotFailedError, SnapshotFailedPreviewNotEnabledError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Log.i("CameraView.takeSnapshot", "Capturing snapshot of Camera View...");
        PreviewView previewView = cameraView.getPreviewView();
        if (previewView == null) {
            throw new SnapshotFailedPreviewNotEnabledError();
        }
        Bitmap bitmap = previewView.getBitmap();
        if (bitmap == null) {
            throw new SnapshotFailedError();
        }
        cameraView.onShutter(ShutterType.SNAPSHOT);
        FileUtils.Companion companion = FileUtils.INSTANCE;
        File file = options.getFile().getFile();
        Intrinsics.checkNotNullExpressionValue(file, "<get-file>(...)");
        companion.writeBitmapTofile(bitmap, file, options.getQuality());
        Log.i("CameraView.takeSnapshot", "Successfully saved snapshot to file!");
        Orientation outputOrientation = cameraView.getCameraSession().getOutputOrientation();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", options.getFile().getFile().getAbsolutePath());
        writableMapCreateMap.putInt("width", bitmap.getWidth());
        writableMapCreateMap.putInt("height", bitmap.getHeight());
        writableMapCreateMap.putString("orientation", outputOrientation.getUnionValue());
        writableMapCreateMap.putBoolean("isMirrored", false);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
