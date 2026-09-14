package com.dylanvann.fastimage;

/* JADX INFO: loaded from: classes3.dex */
public interface FastImageProgressListener {
    float getGranularityPercentage();

    void onProgress(String str, long j, long j2);
}
