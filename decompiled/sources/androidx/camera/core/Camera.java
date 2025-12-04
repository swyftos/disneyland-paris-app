package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraConfig;

/* loaded from: classes.dex */
public interface Camera {
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraInfo getCameraInfo();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraConfig getExtendedConfig();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default boolean isUseCasesCombinationSupported(boolean z, @NonNull UseCase... useCaseArr) {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        return isUseCasesCombinationSupported(true, useCaseArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default boolean isUseCasesCombinationSupportedByFramework(@NonNull UseCase... useCaseArr) {
        return isUseCasesCombinationSupported(false, useCaseArr);
    }
}
