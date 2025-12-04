package androidx.camera.extensions.internal.sessionprocessor;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.List;

@AutoValue
/* loaded from: classes.dex */
public abstract class ImageReaderOutputConfig implements Camera2OutputConfig {
    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getId();

    abstract int getImageFormat();

    abstract int getMaxImages();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @Nullable
    public abstract /* synthetic */ String getPhysicalCameraId();

    abstract Size getSize();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    public abstract /* synthetic */ int getSurfaceGroupId();

    @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2OutputConfig
    @NonNull
    public abstract /* synthetic */ List getSurfaceSharingOutputConfigs();

    static ImageReaderOutputConfig create(int i, int i2, String str, List list, Size size, int i3, int i4) {
        return new AutoValue_ImageReaderOutputConfig(i, i2, str, list, size, i3, i4);
    }

    static ImageReaderOutputConfig create(int i, Size size, int i2, int i3) {
        return new AutoValue_ImageReaderOutputConfig(i, -1, null, Collections.emptyList(), size, i2, i3);
    }
}
