package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SetObjectTaggingRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private String key;
    private ObjectTagging tagging;
    private String versionId;

    public SetObjectTaggingRequest(String str, String str2, ObjectTagging objectTagging) {
        this(str, str2, null, objectTagging);
    }

    public SetObjectTaggingRequest(String str, String str2, String str3, ObjectTagging objectTagging) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = str3;
        this.tagging = objectTagging;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetObjectTaggingRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public SetObjectTaggingRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public SetObjectTaggingRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public ObjectTagging getTagging() {
        return this.tagging;
    }

    public void setTagging(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public SetObjectTaggingRequest withTagging(ObjectTagging objectTagging) {
        setTagging(objectTagging);
        return this;
    }
}
