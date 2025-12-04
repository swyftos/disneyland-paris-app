package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/camera/core/CameraProvider;", "", "availableCameraInfos", "", "Landroidx/camera/core/CameraInfo;", "getAvailableCameraInfos", "()Ljava/util/List;", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "isConcurrentCameraModeOn", "", "()Z", "getCameraInfo", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "hasCamera", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CameraProvider {
    @NotNull
    List<CameraInfo> getAvailableCameraInfos();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    List<List<CameraInfo>> getAvailableConcurrentCameraInfos();

    boolean hasCamera(@NotNull CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isConcurrentCameraModeOn();

    @NotNull
    default CameraInfo getCameraInfo(@NotNull CameraSelector cameraSelector) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        throw new UnsupportedOperationException("The camera provider is not implemented properly.");
    }
}
