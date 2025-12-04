package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.Utils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes2.dex */
public class SystemReducedMotionOption implements ReducedMotionOption {
    @Override // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(@Nullable Context context) {
        if (context == null || Utils.getAnimationScale(context) != BitmapDescriptorFactory.HUE_RED) {
            return ReducedMotionMode.STANDARD_MOTION;
        }
        return ReducedMotionMode.REDUCED_MOTION;
    }
}
