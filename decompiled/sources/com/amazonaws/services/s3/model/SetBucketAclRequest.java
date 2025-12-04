package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketAclRequest extends AmazonWebServiceRequest {
    private AccessControlList acl;
    private String bucketName;
    private CannedAccessControlList cannedAcl;

    public SetBucketAclRequest(String str, AccessControlList accessControlList) {
        this.bucketName = str;
        this.acl = accessControlList;
        this.cannedAcl = null;
    }

    public SetBucketAclRequest(String str, CannedAccessControlList cannedAccessControlList) {
        this.bucketName = str;
        this.acl = null;
        this.cannedAcl = cannedAccessControlList;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public AccessControlList getAcl() {
        return this.acl;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }
}
