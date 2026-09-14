package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Option;

/* JADX INFO: loaded from: classes3.dex */
public final class AnimationDecoderOption {
    public static final Option<Boolean> DISABLE_ANIMATION_APNG_DECODER;
    public static final Option<Boolean> DISABLE_ANIMATION_AVIF_DECODER;
    public static final Option<Boolean> DISABLE_ANIMATION_GIF_DECODER;
    public static final Option<Boolean> DISABLE_ANIMATION_WEBP_DECODER;
    public static final Option<Boolean> NO_ANIMATION_BOUNDS_MEASURE;

    static {
        Boolean bool = Boolean.FALSE;
        DISABLE_ANIMATION_GIF_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER", bool);
        DISABLE_ANIMATION_WEBP_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER", bool);
        DISABLE_ANIMATION_APNG_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER", bool);
        NO_ANIMATION_BOUNDS_MEASURE = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_BOUNDS_MEASURE", bool);
        DISABLE_ANIMATION_AVIF_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_AVIF_DECODER", bool);
    }
}
