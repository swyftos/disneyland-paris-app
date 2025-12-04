package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class DeleteObjectTaggingResult {
    private String versionId;

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public DeleteObjectTaggingResult withVersionId(String str) {
        setVersionId(str);
        return this;
    }
}
