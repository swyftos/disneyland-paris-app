package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;

@Deprecated
/* loaded from: classes2.dex */
public final class PersistableUpload extends PersistableTransfer {
    private final String bucketName;
    private final String file;
    private final String key;
    private final String multipartUploadId;
    private final long mutlipartUploadThreshold;
    private final long partSize;
    private final String pauseType;

    @Deprecated
    public PersistableUpload() {
        this(null, null, null, null, -1L, -1L);
    }

    public PersistableUpload(String str, String str2, String str3, String str4, long j, long j2) {
        this.pauseType = "upload";
        this.bucketName = str;
        this.key = str2;
        this.file = str3;
        this.multipartUploadId = str4;
        this.partSize = j;
        this.mutlipartUploadThreshold = j2;
    }

    String getBucketName() {
        return this.bucketName;
    }

    String getKey() {
        return this.key;
    }

    String getMultipartUploadId() {
        return this.multipartUploadId;
    }

    long getPartSize() {
        return this.partSize;
    }

    long getMutlipartUploadThreshold() {
        return this.mutlipartUploadThreshold;
    }

    String getFile() {
        return this.file;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.PersistableTransfer
    public String serialize() {
        StringWriter stringWriter = new StringWriter();
        try {
            JsonUtils.getJsonWriter(stringWriter).beginObject().name("pauseType").value("upload").name("bucketName").value(this.bucketName).name("key").value(this.key).name("file").value(this.file).name("multipartUploadId").value(this.multipartUploadId).name("partSize").value(this.partSize).name("mutlipartUploadThreshold").value(this.mutlipartUploadThreshold).endObject().close();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
