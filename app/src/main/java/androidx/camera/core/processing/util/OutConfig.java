package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import com.google.auto.value.AutoValue;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class OutConfig {
    @NonNull
    public abstract Rect getCropRect();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    @NonNull
    public abstract Size getSize();

    public abstract int getTargets();

    abstract UUID getUuid();

    public abstract boolean isMirroring();

    public abstract boolean shouldRespectInputCropRect();

    @NonNull
    /* JADX INFO: renamed from: of */
    public static OutConfig m65of(@NonNull SurfaceEdge surfaceEdge) {
        return m63of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.isMirroring());
    }

    @NonNull
    /* JADX INFO: renamed from: of */
    public static OutConfig m63of(int i, int i2, @NonNull Rect rect, @NonNull Size size, int i3, boolean z) {
        return m64of(i, i2, rect, size, i3, z, false);
    }

    @NonNull
    /* JADX INFO: renamed from: of */
    public static OutConfig m64of(int i, int i2, @NonNull Rect rect, @NonNull Size size, int i3, boolean z, boolean z2) {
        return new AutoValue_OutConfig(UUID.randomUUID(), i, i2, rect, size, i3, z, z2);
    }
}
