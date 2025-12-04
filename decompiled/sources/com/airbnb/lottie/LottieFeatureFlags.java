package com.airbnb.lottie;

import android.os.Build;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;

/* loaded from: classes2.dex */
class LottieFeatureFlags {
    private final HashSet enabledFlags = new HashSet();

    LottieFeatureFlags() {
    }

    public boolean enableFlag(LottieFeatureFlag lottieFeatureFlag, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT < lottieFeatureFlag.minRequiredSdkVersion) {
                Logger.warning(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
                return false;
            }
            return this.enabledFlags.add(lottieFeatureFlag);
        }
        return this.enabledFlags.remove(lottieFeatureFlag);
    }

    public boolean isFlagEnabled(LottieFeatureFlag lottieFeatureFlag) {
        return this.enabledFlags.contains(lottieFeatureFlag);
    }
}
