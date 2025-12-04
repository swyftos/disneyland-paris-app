package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface VendorExtender {
    @Nullable
    default SessionProcessor createSessionProcessor(@NonNull Context context) {
        return null;
    }

    @Nullable
    default Range<Long> getEstimatedCaptureLatencyRange(@Nullable Size size) {
        return null;
    }

    default void init(@NonNull CameraInfo cameraInfo) {
    }

    default boolean isCaptureProcessProgressAvailable() {
        return false;
    }

    default boolean isCurrentExtensionModeAvailable() {
        return false;
    }

    default boolean isExtensionAvailable(@NonNull String str, @NonNull Map<String, CameraCharacteristics> map) {
        return false;
    }

    default boolean isExtensionStrengthAvailable() {
        return false;
    }

    default boolean isPostviewAvailable() {
        return false;
    }

    @NonNull
    default List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions() {
        return Collections.emptyList();
    }

    @NonNull
    default List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions() {
        return Collections.emptyList();
    }

    @NonNull
    default Size[] getSupportedYuvAnalysisResolutions() {
        return new Size[0];
    }

    @NonNull
    default Map<Integer, List<Size>> getSupportedPostviewResolutions(@NonNull Size size) {
        return Collections.emptyMap();
    }

    @NonNull
    default List<CaptureResult.Key> getSupportedCaptureResultKeys() {
        return Collections.emptyList();
    }

    default boolean willReceiveOnCaptureCompleted() {
        Version version = Version.VERSION_1_2;
        if (ClientVersion.isMaximumCompatibleVersion(version) || ExtensionVersion.isMaximumCompatibleVersion(version)) {
            return false;
        }
        return !getSupportedCaptureResultKeys().isEmpty();
    }
}
