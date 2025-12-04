package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class AnimatableTextStyle {

    @Nullable
    public final AnimatableColorValue color;

    @Nullable
    public final AnimatableIntegerValue opacity;

    @Nullable
    public final AnimatableColorValue stroke;

    @Nullable
    public final AnimatableFloatValue strokeWidth;

    @Nullable
    public final AnimatableFloatValue tracking;

    public AnimatableTextStyle(@Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableColorValue animatableColorValue2, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableIntegerValue animatableIntegerValue) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
        this.opacity = animatableIntegerValue;
    }
}
