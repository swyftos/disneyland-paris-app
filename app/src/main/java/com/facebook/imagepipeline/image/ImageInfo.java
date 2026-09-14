package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageInfo extends HasImageMetadata {
    int getHeight();

    QualityInfo getQualityInfo();

    default int getSizeInBytes() {
        return 0;
    }

    int getWidth();
}
