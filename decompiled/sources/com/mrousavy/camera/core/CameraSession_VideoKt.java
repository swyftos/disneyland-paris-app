package com.mrousavy.camera.core;

import android.annotation.SuppressLint;
import android.location.Location;
import android.util.Log;
import android.util.Size;
import androidx.annotation.OptIn;
import androidx.camera.video.ExperimentalPersistentRecording;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.core.util.Consumer;
import androidx.media3.common.MimeTypes;
import com.google.firebase.messaging.Constants;
import com.mrousavy.camera.core.extensions.VideoRecordEvent_toCameraErrorKt;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ab\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0014"}, d2 = {"startRecording", "", "Lcom/mrousavy/camera/core/CameraSession;", "enableAudio", "", "options", "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "callback", "Lkotlin/Function1;", "Lcom/mrousavy/camera/core/types/Video;", "Lkotlin/ParameterName;", "name", MimeTypes.BASE_TYPE_VIDEO, PDFView.EVENT_ON_ERROR, "Lcom/mrousavy/camera/core/CameraError;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "stopRecording", "cancelRecording", "pauseRecording", "resumeRecording", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraSession_VideoKt {
    @OptIn(markerClass = {ExperimentalPersistentRecording.class})
    @SuppressLint({"MissingPermission", "RestrictedApi"})
    public static final void startRecording(@NotNull final CameraSession cameraSession, boolean z, @NotNull final RecordVideoOptions options, @NotNull final Function1<? super Video, Unit> callback, @NotNull final Function1<? super CameraError, Unit> onError) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (cameraSession.getCamera() == null) {
            throw new CameraNotReadyError();
        }
        if (cameraSession.getRecording() != null) {
            throw new RecordingInProgressError();
        }
        final VideoCapture<Recorder> videoOutput$react_native_vision_camera_release = cameraSession.getVideoOutput$react_native_vision_camera_release();
        if (videoOutput$react_native_vision_camera_release == null) {
            throw new VideoNotEnabledError();
        }
        FileOutputOptions.Builder builder = new FileOutputOptions.Builder(options.getFile().getFile());
        Location location = cameraSession.getMetadataProvider().getLocation();
        if (location != null) {
            Log.i(CameraSession.TAG, "Setting Video Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            builder.setLocation(location);
        }
        FileOutputOptions fileOutputOptionsM123build = builder.m123build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsM123build, "build(...)");
        PendingRecording pendingRecordingPrepareRecording = ((Recorder) videoOutput$react_native_vision_camera_release.getOutput()).prepareRecording(cameraSession.getContext(), fileOutputOptionsM123build);
        Intrinsics.checkNotNullExpressionValue(pendingRecordingPrepareRecording, "prepareRecording(...)");
        if (z) {
            cameraSession.checkMicrophonePermission$react_native_vision_camera_release();
            pendingRecordingPrepareRecording = PendingRecording.withAudioEnabled$default(pendingRecordingPrepareRecording, false, 1, null);
        }
        PendingRecording pendingRecordingAsPersistentRecording = pendingRecordingPrepareRecording.asPersistentRecording();
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(false);
        cameraSession.setRecording$react_native_vision_camera_release(pendingRecordingAsPersistentRecording.start(CameraQueues.INSTANCE.getCameraExecutor(), new Consumer() { // from class: com.mrousavy.camera.core.CameraSession_VideoKt$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) throws UnknownRecorderError {
                CameraSession_VideoKt.startRecording$lambda$2(cameraSession, onError, options, videoOutput$react_native_vision_camera_release, callback, (VideoRecordEvent) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRecording$lambda$2(CameraSession cameraSession, Function1 function1, RecordVideoOptions recordVideoOptions, VideoCapture videoCapture, Function1 function12, VideoRecordEvent event) throws UnknownRecorderError {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof VideoRecordEvent.Start) {
            Log.i(CameraSession.TAG, "Recording started!");
            return;
        }
        if (event instanceof VideoRecordEvent.Resume) {
            Log.i(CameraSession.TAG, "Recording resumed!");
            return;
        }
        if (event instanceof VideoRecordEvent.Pause) {
            Log.i(CameraSession.TAG, "Recording paused!");
            return;
        }
        if (event instanceof VideoRecordEvent.Status) {
            Log.i(CameraSession.TAG, "Status update! Recorded " + ((VideoRecordEvent.Status) event).getRecordingStats().getNumBytesRecorded() + " bytes.");
            return;
        }
        if (event instanceof VideoRecordEvent.Finalize) {
            if (cameraSession.getIsRecordingCanceled()) {
                Log.i(CameraSession.TAG, "Recording was canceled, deleting file..");
                function1.invoke(new RecordingCanceledError());
                try {
                    recordVideoOptions.getFile().getFile().delete();
                    return;
                } catch (Throwable th) {
                    cameraSession.getCallback().onError(new FileIOError(th));
                    return;
                }
            }
            Log.i(CameraSession.TAG, "Recording stopped!");
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) event;
            RecorderError cameraError = VideoRecordEvent_toCameraErrorKt.getCameraError(finalize);
            if (cameraError != null) {
                if (cameraError.getWasVideoRecorded()) {
                    Log.e(CameraSession.TAG, "Video Recorder encountered an error, but the video was recorded anyways.", cameraError);
                } else {
                    Log.e(CameraSession.TAG, "Video Recorder encountered a fatal error!", cameraError);
                    function1.invoke(cameraError);
                    return;
                }
            }
            long recordedDurationNanos = finalize.getRecordingStats().getRecordedDurationNanos() / 1000000;
            Log.i(CameraSession.TAG, "Successfully completed video recording! Captured " + (recordedDurationNanos / 1000.0d) + " seconds.");
            String path = finalize.getOutputResults().getOutputUri().getPath();
            if (path == null) {
                throw new UnknownRecorderError(false, null);
            }
            Size attachedSurfaceResolution = videoCapture.getAttachedSurfaceResolution();
            if (attachedSurfaceResolution == null) {
                attachedSurfaceResolution = new Size(0, 0);
            }
            function12.invoke(new Video(path, recordedDurationNanos, attachedSurfaceResolution));
        }
    }

    public static final void stopRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.stop();
        cameraSession.setRecording$react_native_vision_camera_release(null);
    }

    public static final void cancelRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(true);
        stopRecording(cameraSession);
    }

    public static final void pauseRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.pause();
    }

    public static final void resumeRecording(@NotNull CameraSession cameraSession) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.resume();
    }
}
