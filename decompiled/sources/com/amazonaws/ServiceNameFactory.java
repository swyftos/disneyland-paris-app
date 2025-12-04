package com.amazonaws;

import androidx.slidingpanelayout.widget.SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0;
import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: classes2.dex */
enum ServiceNameFactory {
    ;

    public static ServiceNameFactory valueOf(String str) {
        SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(Enum.valueOf(ServiceNameFactory.class, str));
        return null;
    }

    static String getServiceName(String str) {
        HttpClientConfig httpClientConfig = InternalConfig.Factory.getInternalConfig().getHttpClientConfig(str);
        if (httpClientConfig == null) {
            return null;
        }
        return httpClientConfig.getServiceName();
    }
}
