package com.google.ads.interactivemedia.p034v3.api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdErrorEvent {

    public interface AdErrorListener {
        void onAdError(AdErrorEvent adErrorEvent);
    }

    public abstract AdError getError();
}
