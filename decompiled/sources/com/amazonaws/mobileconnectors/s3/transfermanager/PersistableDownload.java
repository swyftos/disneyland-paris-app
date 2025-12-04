package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

@Deprecated
/* loaded from: classes2.dex */
public final class PersistableDownload extends PersistableTransfer {
    private final String bucketName;
    private final String file;
    private final boolean isRequesterPays;
    private final String key;
    private final String pauseType;
    private final long[] range;
    private final ResponseHeaderOverrides responseHeaders;
    private final String versionId;

    @Deprecated
    public PersistableDownload() {
        this(null, null, null, null, null, false, null);
    }

    public PersistableDownload(String str, String str2, String str3, long[] jArr, ResponseHeaderOverrides responseHeaderOverrides, boolean z, String str4) {
        this.pauseType = "download";
        this.bucketName = str;
        this.key = str2;
        this.versionId = str3;
        this.range = jArr == null ? null : (long[]) jArr.clone();
        this.responseHeaders = responseHeaderOverrides;
        this.isRequesterPays = z;
        this.file = str4;
    }

    String getBucketName() {
        return this.bucketName;
    }

    String getKey() {
        return this.key;
    }

    String getVersionId() {
        return this.versionId;
    }

    long[] getRange() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    String getFile() {
        return this.file;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.PersistableTransfer
    public String serialize() {
        StringWriter stringWriter = new StringWriter();
        AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
        try {
            jsonWriter.beginObject().name("pauseType").value("download").name("bucketName").value(this.bucketName).name("key").value(this.key).name("file").value(this.file).name("versionId").value(this.versionId).name("isRequesterPays").value(this.isRequesterPays);
            if (this.range != null) {
                jsonWriter.name("range").beginArray();
                for (long j : this.range) {
                    jsonWriter.value(j);
                }
                jsonWriter.endArray();
            }
            if (this.responseHeaders != null) {
                jsonWriter.name("responseHeaders").beginObject().name(CMSAttributeTableGenerator.CONTENT_TYPE).value(this.responseHeaders.getContentType()).name("contentLanguage").value(this.responseHeaders.getContentLanguage()).name("expires").value(this.responseHeaders.getExpires()).name("cacheControl").value(this.responseHeaders.getCacheControl()).name("contentDisposition").value(this.responseHeaders.getContentDisposition()).name("contentEncoding").value(this.responseHeaders.getContentEncoding()).endObject();
            }
            jsonWriter.endObject().close();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
