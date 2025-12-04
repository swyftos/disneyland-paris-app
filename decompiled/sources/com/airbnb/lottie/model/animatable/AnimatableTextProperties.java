package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class AnimatableTextProperties {

    @Nullable
    public final AnimatableTextRangeSelector rangeSelector;

    @Nullable
    public final AnimatableTextStyle textStyle;

    public AnimatableTextProperties(@Nullable AnimatableTextStyle animatableTextStyle, @Nullable AnimatableTextRangeSelector animatableTextRangeSelector) {
        this.textStyle = animatableTextStyle;
        this.rangeSelector = animatableTextRangeSelector;
    }
}
