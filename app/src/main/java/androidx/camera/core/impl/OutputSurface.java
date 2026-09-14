package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class OutputSurface {
    public abstract int getImageFormat();

    @NonNull
    public abstract Size getSize();

    @NonNull
    public abstract Surface getSurface();

    @NonNull
    public static OutputSurface create(@NonNull Surface surface, @NonNull Size size, int i) {
        return new AutoValue_OutputSurface(surface, size, i);
    }
}
