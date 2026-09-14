package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ProgressiveJpegConfig {
    boolean decodeProgressively();

    int getNextScanNumberToDecode(int i);

    QualityInfo getQualityInfo(int i);
}
