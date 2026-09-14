package com.airbnb.lottie;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class Lottie {
    public static void initialize(@NonNull LottieConfig lottieConfig) {
        C1806L.setFetcher(lottieConfig.networkFetcher);
        C1806L.setCacheProvider(lottieConfig.cacheProvider);
        C1806L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
        C1806L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        C1806L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
        C1806L.setDefaultAsyncUpdates(lottieConfig.defaultAsyncUpdates);
        C1806L.setReducedMotionOption(lottieConfig.reducedMotionOption);
    }
}
