package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface MultipleFileUpload extends Transfer {
    String getBucketName();

    String getKeyPrefix();

    Collection<? extends Upload> getSubTransfers();
}
