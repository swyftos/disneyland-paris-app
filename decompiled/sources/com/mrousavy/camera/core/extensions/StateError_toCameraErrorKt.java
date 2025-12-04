package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraState;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraInUseError;
import com.mrousavy.camera.core.CameraIsRestrictedError;
import com.mrousavy.camera.core.DoNotDisturbBugError;
import com.mrousavy.camera.core.FatalCameraError;
import com.mrousavy.camera.core.InvalidOutputConfigurationError;
import com.mrousavy.camera.core.MaxCamerasInUseError;
import com.mrousavy.camera.core.RecoverableError;
import com.mrousavy.camera.core.UnknownCameraError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toCameraError", "Lcom/mrousavy/camera/core/CameraError;", "Landroidx/camera/core/CameraState$StateError;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StateError_toCameraErrorKt {
    @NotNull
    public static final CameraError toCameraError(@NotNull CameraState.StateError stateError) {
        Intrinsics.checkNotNullParameter(stateError, "<this>");
        switch (stateError.getCode()) {
            case 1:
                return new MaxCamerasInUseError(stateError.getCause());
            case 2:
                return new CameraInUseError(stateError.getCause());
            case 3:
                return new RecoverableError(stateError.getCause());
            case 4:
                return new InvalidOutputConfigurationError(stateError.getCause());
            case 5:
                return new CameraIsRestrictedError(stateError.getCause());
            case 6:
                return new FatalCameraError(stateError.getCause());
            case 7:
                return new DoNotDisturbBugError(stateError.getCause());
            default:
                return new UnknownCameraError(stateError.getCause());
        }
    }
}
