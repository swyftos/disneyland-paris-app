package com.mrousavy.camera.core.extensions;

import androidx.camera.video.VideoRecordEvent;
import com.mrousavy.camera.core.DurationLimitReachedError;
import com.mrousavy.camera.core.EncoderError;
import com.mrousavy.camera.core.FileSizeLimitReachedError;
import com.mrousavy.camera.core.InsufficientStorageForRecorderError;
import com.mrousavy.camera.core.InvalidRecorderConfigurationError;
import com.mrousavy.camera.core.NoDataError;
import com.mrousavy.camera.core.RecorderError;
import com.mrousavy.camera.core.UnknownRecorderError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m1836d2 = {"getCameraError", "Lcom/mrousavy/camera/core/RecorderError;", "Landroidx/camera/video/VideoRecordEvent$Finalize;", "react-native-vision-camera_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class VideoRecordEvent_toCameraErrorKt {
    @Nullable
    public static final RecorderError getCameraError(@NotNull VideoRecordEvent.Finalize finalize) {
        Intrinsics.checkNotNullParameter(finalize, "<this>");
        if (!finalize.hasError()) {
            return null;
        }
        switch (finalize.getError()) {
            case 0:
                return null;
            case 1:
                return new UnknownRecorderError(false, finalize.getCause());
            case 2:
                return new FileSizeLimitReachedError(finalize.getCause());
            case 3:
                return new InsufficientStorageForRecorderError(finalize.getCause());
            case 4:
                return new NoDataError(finalize.getCause());
            case 5:
                return new InvalidRecorderConfigurationError(finalize.getCause());
            case 6:
                return new EncoderError(finalize.getCause());
            case 7:
                return new UnknownRecorderError(false, finalize.getCause());
            case 8:
                return new NoDataError(finalize.getCause());
            case 9:
                return new DurationLimitReachedError(finalize.getCause());
            case 10:
                return new UnknownRecorderError(true, finalize.getCause());
            default:
                return new UnknownRecorderError(false, finalize.getCause());
        }
    }
}
