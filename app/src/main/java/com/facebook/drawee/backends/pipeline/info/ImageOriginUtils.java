package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.base.Ascii;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class ImageOriginUtils {
    public static String toString(int i) {
        switch (i) {
            case 2:
                return TCEventPropertiesNames.TCN_NETWORK;
            case 3:
                return "disk";
            case 4:
                return "memory_encoded";
            case 5:
                return "memory_bitmap";
            case 6:
                return "memory_bitmap_shortcut";
            case 7:
                return ImagesContract.LOCAL;
            default:
                return "unknown";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int mapProducerNameToImageOrigin(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1917159454:
                if (str.equals(QualifiedResourceFetchProducer.PRODUCER_NAME)) {
                    b = 0;
                }
                break;
            case -1914072202:
                if (str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                    b = 1;
                }
                break;
            case -1683996557:
                if (str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                    b = 2;
                }
                break;
            case -1579985851:
                if (str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                    b = 3;
                }
                break;
            case -1307634203:
                if (str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                    b = 4;
                }
                break;
            case -1224383234:
                if (str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                    b = 5;
                }
                break;
            case 473552259:
                if (str.equals(LocalVideoThumbnailProducer.PRODUCER_NAME)) {
                    b = 6;
                }
                break;
            case 656304759:
                if (str.equals(DiskCacheReadProducer.PRODUCER_NAME)) {
                    b = 7;
                }
                break;
            case 957714404:
                if (str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    b = 8;
                }
                break;
            case 1019542023:
                if (str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                    b = 9;
                }
                break;
            case 1023071510:
                if (str.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    b = 10;
                }
                break;
            case 1721672898:
                if (str.equals(DataFetchProducer.PRODUCER_NAME)) {
                    b = Ascii.f3535VT;
                }
                break;
            case 1793127518:
                if (str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                    b = Ascii.f3524FF;
                }
                break;
            case 2109593398:
                if (str.equals(PartialDiskCacheProducer.PRODUCER_NAME)) {
                    b = Ascii.f3522CR;
                }
                break;
            case 2113652014:
                if (str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                    b = Ascii.f3532SO;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
            case 3:
            case 6:
            case 9:
            case 11:
            case 12:
            case 14:
                return 7;
            case 1:
            case 8:
            case 10:
                return 5;
            case 4:
                return 4;
            case 5:
                return 2;
            case 7:
            case 13:
                return 3;
            default:
                return 1;
        }
    }
}
