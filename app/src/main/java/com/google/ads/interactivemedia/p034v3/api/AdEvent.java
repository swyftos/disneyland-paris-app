package com.google.ads.interactivemedia.p034v3.api;

import androidx.annotation.InspectableProperty;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdEvent {

    public interface AdEventListener {
        void onAdEvent(AdEvent adEvent);
    }

    public abstract Map<String, String> getAdData();

    public abstract InspectableProperty getType();
}
