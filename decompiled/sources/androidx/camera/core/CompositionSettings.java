package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.core.util.Pair;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.rnscreens.Screen;

/* loaded from: classes.dex */
public class CompositionSettings {
    public static final CompositionSettings DEFAULT = new Builder().setAlpha(1.0f).setOffset(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED).setScale(1.0f, 1.0f).build();
    private final float mAlpha;
    private final Pair mOffset;
    private final Pair mScale;

    private CompositionSettings(float f, Pair pair, Pair pair2) {
        this.mAlpha = f;
        this.mOffset = pair;
        this.mScale = pair2;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    @NonNull
    public Pair<Float, Float> getOffset() {
        return this.mOffset;
    }

    @NonNull
    public Pair<Float, Float> getScale() {
        return this.mScale;
    }

    public static final class Builder {
        private float mAlpha;
        private Pair mOffset;
        private Pair mScale;

        public Builder() {
            Float fValueOf = Float.valueOf(1.0f);
            this.mAlpha = 1.0f;
            Float fValueOf2 = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
            this.mOffset = Pair.create(fValueOf2, fValueOf2);
            this.mScale = Pair.create(fValueOf, fValueOf);
        }

        @NonNull
        public Builder setAlpha(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
            this.mAlpha = f;
            return this;
        }

        @NonNull
        public Builder setOffset(@FloatRange(from = Screen.SHEET_FIT_TO_CONTENTS, to = 1.0d) float f, @FloatRange(from = Screen.SHEET_FIT_TO_CONTENTS, to = 1.0d) float f2) {
            this.mOffset = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        @NonNull
        public Builder setScale(float f, float f2) {
            this.mScale = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        @NonNull
        public CompositionSettings build() {
            return new CompositionSettings(this.mAlpha, this.mOffset, this.mScale);
        }
    }
}
