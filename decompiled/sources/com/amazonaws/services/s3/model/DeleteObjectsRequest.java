package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeleteObjectsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private boolean isRequesterPays;
    private final List keys = new ArrayList();
    private MultiFactorAuthentication mfa;
    private boolean quiet;

    public DeleteObjectsRequest(String str) {
        setBucketName(str);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public DeleteObjectsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public MultiFactorAuthentication getMfa() {
        return this.mfa;
    }

    public void setMfa(MultiFactorAuthentication multiFactorAuthentication) {
        this.mfa = multiFactorAuthentication;
    }

    public DeleteObjectsRequest withMfa(MultiFactorAuthentication multiFactorAuthentication) {
        setMfa(multiFactorAuthentication);
        return this;
    }

    public void setQuiet(boolean z) {
        this.quiet = z;
    }

    public boolean getQuiet() {
        return this.quiet;
    }

    public DeleteObjectsRequest withQuiet(boolean z) {
        setQuiet(z);
        return this;
    }

    public void setKeys(List<KeyVersion> list) {
        this.keys.clear();
        this.keys.addAll(list);
    }

    public DeleteObjectsRequest withKeys(List<KeyVersion> list) {
        setKeys(list);
        return this;
    }

    public List<KeyVersion> getKeys() {
        return this.keys;
    }

    public DeleteObjectsRequest withKeys(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new KeyVersion(str));
        }
        setKeys(arrayList);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public DeleteObjectsRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }

    public static class KeyVersion implements Serializable {
        private final String key;
        private final String version;

        public KeyVersion(String str) {
            this(str, null);
        }

        public KeyVersion(String str, String str2) {
            this.key = str;
            this.version = str2;
        }

        public String getKey() {
            return this.key;
        }

        public String getVersion() {
            return this.version;
        }
    }
}
