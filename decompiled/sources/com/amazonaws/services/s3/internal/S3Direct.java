package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;

/* loaded from: classes2.dex */
public abstract class S3Direct implements S3DirectSpi {
    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract CopyPartResult copyPart(CopyPartRequest copyPartRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract S3Object getObject(GetObjectRequest getObjectRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract PutObjectResult putObject(PutObjectRequest putObjectRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    public abstract UploadPartResult uploadPart(UploadPartRequest uploadPartRequest);
}
