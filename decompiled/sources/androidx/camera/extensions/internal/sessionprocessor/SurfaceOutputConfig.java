package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.List;

@AutoValue
/* loaded from: classes.dex */
public abstract class SurfaceOutputConfig implements Camera2OutputConfig {
    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getId();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @Nullable
    public abstract /* synthetic */ String getPhysicalCameraId();

    abstract Surface getSurface();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getSurfaceGroupId();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @NonNull
    public abstract /* synthetic */ List getSurfaceSharingOutputConfigs();

    static SurfaceOutputConfig create(int i, int i2, String str, List list, Surface surface) {
        return new AutoValue_SurfaceOutputConfig(i, i2, str, list, surface);
    }

    static SurfaceOutputConfig create(int i, Surface surface) {
        return create(i, -1, null, Collections.emptyList(), surface);
    }
}
