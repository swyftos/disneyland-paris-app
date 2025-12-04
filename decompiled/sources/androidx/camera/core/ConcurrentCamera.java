package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* loaded from: classes.dex */
public class ConcurrentCamera {
    private List mCameras;

    public ConcurrentCamera(@NonNull List<Camera> list) {
        this.mCameras = list;
    }

    @NonNull
    public List<Camera> getCameras() {
        return this.mCameras;
    }

    public static final class SingleCameraConfig {
        private CameraSelector mCameraSelector;
        private CompositionSettings mCompositionSettings;
        private LifecycleOwner mLifecycleOwner;
        private UseCaseGroup mUseCaseGroup;

        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull LifecycleOwner lifecycleOwner) {
            this(cameraSelector, useCaseGroup, CompositionSettings.DEFAULT, lifecycleOwner);
        }

        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull CompositionSettings compositionSettings, @NonNull LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mCompositionSettings = compositionSettings;
            this.mLifecycleOwner = lifecycleOwner;
        }

        @NonNull
        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        @NonNull
        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @NonNull
        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        @NonNull
        public CompositionSettings getCompositionSettings() {
            return this.mCompositionSettings;
        }
    }
}
