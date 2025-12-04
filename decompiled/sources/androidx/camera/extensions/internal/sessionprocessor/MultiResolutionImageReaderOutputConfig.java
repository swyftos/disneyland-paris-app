package androidx.camera.extensions.internal.sessionprocessor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes.dex */
public abstract class MultiResolutionImageReaderOutputConfig implements Camera2OutputConfig {
    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getId();

    abstract int getImageFormat();

    abstract int getMaxImages();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @Nullable
    public abstract /* synthetic */ String getPhysicalCameraId();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getSurfaceGroupId();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @NonNull
    public abstract /* synthetic */ List getSurfaceSharingOutputConfigs();

    static MultiResolutionImageReaderOutputConfig create(int i, int i2, String str, List list, int i3, int i4) {
        return new AutoValue_MultiResolutionImageReaderOutputConfig(i, i2, str, list, i3, i4);
    }
}
