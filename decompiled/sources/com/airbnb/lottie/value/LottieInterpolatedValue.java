package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes2.dex */
abstract class LottieInterpolatedValue extends LottieValueCallback {
    private final Object endValue;
    private final Interpolator interpolator;
    private final Object startValue;

    abstract Object interpolateValue(Object obj, Object obj2, float f);

    LottieInterpolatedValue(Object obj, Object obj2) {
        this(obj, obj2, new LinearInterpolator());
    }

    LottieInterpolatedValue(Object obj, Object obj2, Interpolator interpolator) {
        this.startValue = obj;
        this.endValue = obj2;
        this.interpolator = interpolator;
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }
}
