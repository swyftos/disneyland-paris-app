package com.amazonaws.mobileconnectors.s3.transfermanager;

import androidx.media3.datasource.cache.CacheDataSink;
import com.facebook.common.statfs.StatFsHelper;

@Deprecated
/* loaded from: classes2.dex */
public class TransferManagerConfiguration {
    private long minimumUploadPartSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    private long multipartUploadThreshold = 16777216;
    private long multipartCopyThreshold = 5368709120L;
    private long multipartCopyPartSize = StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES;

    public long getMinimumUploadPartSize() {
        return this.minimumUploadPartSize;
    }

    public void setMinimumUploadPartSize(long j) {
        this.minimumUploadPartSize = j;
    }

    public long getMultipartUploadThreshold() {
        return this.multipartUploadThreshold;
    }

    public void setMultipartUploadThreshold(long j) {
        this.multipartUploadThreshold = j;
    }

    public long getMultipartCopyPartSize() {
        return this.multipartCopyPartSize;
    }

    public void setMultipartCopyPartSize(long j) {
        this.multipartCopyPartSize = j;
    }

    public long getMultipartCopyThreshold() {
        return this.multipartCopyThreshold;
    }

    public void setMultipartCopyThreshold(long j) {
        this.multipartCopyThreshold = j;
    }
}
