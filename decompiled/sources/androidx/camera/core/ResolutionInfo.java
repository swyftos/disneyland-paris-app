package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal;

/* loaded from: classes.dex */
public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    public ResolutionInfo(@NonNull Size size, @NonNull Rect rect, int i) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(size).setCropRect(rect).setRotationDegrees(i).build();
    }

    @NonNull
    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    @NonNull
    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        return this.mResolutionInfoInternal.equals(obj);
    }

    @NonNull
    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }

    static abstract class ResolutionInfoInternal {
        abstract Rect getCropRect();

        abstract Size getResolution();

        abstract int getRotationDegrees();

        ResolutionInfoInternal() {
        }

        static abstract class Builder {
            abstract ResolutionInfoInternal build();

            abstract Builder setCropRect(Rect rect);

            abstract Builder setRotationDegrees(int i);

            Builder() {
            }
        }
    }
}
