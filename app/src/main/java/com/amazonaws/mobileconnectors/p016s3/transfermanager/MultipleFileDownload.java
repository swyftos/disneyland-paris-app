package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface MultipleFileDownload extends Transfer {
    void abort() throws IOException;

    String getBucketName();

    String getKeyPrefix();
}
