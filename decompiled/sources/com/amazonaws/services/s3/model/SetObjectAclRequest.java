package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SetObjectAclRequest extends AmazonWebServiceRequest implements Serializable {
    private final AccessControlList acl;
    private final String bucketName;
    private final CannedAccessControlList cannedAcl;
    private boolean isRequesterPays;
    private final String key;
    private final String versionId;

    public SetObjectAclRequest(String str, String str2, AccessControlList accessControlList) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = null;
        this.acl = accessControlList;
        this.cannedAcl = null;
    }

    public SetObjectAclRequest(String str, String str2, CannedAccessControlList cannedAccessControlList) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = null;
        this.acl = null;
        this.cannedAcl = cannedAccessControlList;
    }

    public SetObjectAclRequest(String str, String str2, String str3, AccessControlList accessControlList) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = str3;
        this.acl = accessControlList;
        this.cannedAcl = null;
    }

    public SetObjectAclRequest(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = str3;
        this.acl = null;
        this.cannedAcl = cannedAccessControlList;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public AccessControlList getAcl() {
        return this.acl;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public SetObjectAclRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
