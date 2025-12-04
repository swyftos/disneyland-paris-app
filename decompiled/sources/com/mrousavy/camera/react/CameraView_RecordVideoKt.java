package com.mrousavy.camera.react;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraSession_VideoKt;
import com.mrousavy.camera.core.MicrophonePermissionError;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000b"}, d2 = {"startRecording", "", "Lcom/mrousavy/camera/react/CameraView;", "options", "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "pauseRecording", "resumeRecording", "stopRecording", "cancelRecording", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraView_RecordVideoKt {
    public static final void startRecording(@NotNull CameraView cameraView, @NotNull RecordVideoOptions options, @NotNull final Callback onRecordCallback) throws MicrophonePermissionError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        if (cameraView.getAudio() && ContextCompat.checkSelfPermission(cameraView.getContext(), "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
        CameraSession_VideoKt.startRecording(cameraView.getCameraSession(), cameraView.getAudio(), options, new Function1() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraView_RecordVideoKt.startRecording$lambda$0(onRecordCallback, (Video) obj);
            }
        }, new Function1() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraView_RecordVideoKt.startRecording$lambda$1(onRecordCallback, (CameraError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$0(Callback callback, Video video) {
        Intrinsics.checkNotNullParameter(video, "video");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", video.getPath());
        writableMapCreateMap.putDouble(TypedValues.TransitionType.S_DURATION, video.getDurationMs() / 1000.0d);
        writableMapCreateMap.putInt("width", video.getSize().getWidth());
        writableMapCreateMap.putInt("height", video.getSize().getHeight());
        callback.invoke(writableMapCreateMap, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startRecording$lambda$1(Callback callback, CameraError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        callback.invoke(null, CallbackPromiseKt.makeErrorMap$default(error.getCode(), error.getMessage(), null, null, 12, null));
        return Unit.INSTANCE;
    }

    public static final void pauseRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.pauseRecording(cameraView.getCameraSession());
    }

    public static final void resumeRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.resumeRecording(cameraView.getCameraSession());
    }

    public static final void stopRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.stopRecording(cameraView.getCameraSession());
    }

    public static final void cancelRecording(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.cancelRecording(cameraView.getCameraSession());
    }
}
