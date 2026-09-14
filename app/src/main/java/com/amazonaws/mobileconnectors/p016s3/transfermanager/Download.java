package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import com.amazonaws.mobileconnectors.p016s3.transfermanager.exception.PauseException;
import com.amazonaws.services.p017s3.model.ObjectMetadata;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Download extends Transfer {
    void abort() throws IOException;

    String getBucketName();

    String getKey();

    ObjectMetadata getObjectMetadata();

    PersistableDownload pause() throws PauseException;
}
