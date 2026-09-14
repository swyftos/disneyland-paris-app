package com.amazonaws.mobileconnectors.p016s3.transfermanager;

import com.amazonaws.services.p017s3.model.ObjectMetadata;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface ObjectMetadataProvider {
    void provideObjectMetadata(File file, ObjectMetadata objectMetadata);
}
