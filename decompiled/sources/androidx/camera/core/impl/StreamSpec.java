package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = new Range<>(0, 0);

    @NonNull
    public abstract DynamicRange getDynamicRange();

    @NonNull
    public abstract Range<Integer> getExpectedFrameRateRange();

    @Nullable
    public abstract Config getImplementationOptions();

    @NonNull
    public abstract Size getResolution();

    public abstract boolean getZslDisabled();

    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public static Builder builder(@NonNull Size size) {
        return new AutoValue_StreamSpec.Builder().setResolution(size).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED).setDynamicRange(DynamicRange.SDR).setZslDisabled(false);
    }

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract StreamSpec build();

        @NonNull
        public abstract Builder setDynamicRange(@NonNull DynamicRange dynamicRange);

        @NonNull
        public abstract Builder setExpectedFrameRateRange(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setImplementationOptions(@NonNull Config config);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);

        @NonNull
        public abstract Builder setZslDisabled(boolean z);

        Builder() {
        }
    }
}
