package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

/* loaded from: classes2.dex */
public enum S3Actions implements Action {
    AllS3Actions("s3:*"),
    GetObject("s3:GetObject"),
    GetObjectVersion("s3:GetObjectVersion"),
    PutObject("s3:PutObject"),
    GetObjectAcl("s3:GetObjectAcl"),
    GetObjectVersionAcl("s3:GetObjectVersionAcl"),
    SetObjectAcl("s3:PutObjectAcl"),
    SetObjectVersionAcl("s3:PutObjectAclVersion"),
    DeleteObject("s3:DeleteObject"),
    DeleteObjectVersion("s3:DeleteObjectVersion"),
    ListMultipartUploadParts("s3:ListMultipartUploadParts"),
    AbortMultipartUpload("s3:AbortMultipartUpload"),
    RestoreObject("s3:RestoreObject"),
    CreateBucket("s3:CreateBucket"),
    DeleteBucket("s3:DeleteBucket"),
    ListObjects("s3:ListBucket"),
    ListObjectVersions("s3:ListBucketVersions"),
    ListBuckets("s3:ListAllMyBuckets"),
    ListBucketMultipartUploads("s3:ListBucketMultipartUploads"),
    GetBucketAcl("s3:GetBucketAcl"),
    SetBucketAcl("s3:PutBucketAcl"),
    GetBucketCrossOriginConfiguration("s3:GetBucketCORS"),
    SetBucketCrossOriginConfiguration("s3:PutBucketCORS"),
    GetBucketVersioningConfiguration("s3:GetBucketVersioning"),
    SetBucketVersioningConfiguration("s3:PutBucketVersioning"),
    GetBucketRequesterPays("s3:GetBucketRequestPayment"),
    SetBucketRequesterPays("s3:PutBucketRequestPayment"),
    GetBucketLocation("s3:GetBucketLocation"),
    GetBucketPolicy("s3:GetBucketPolicy"),
    SetBucketPolicy("s3:PutBucketPolicy"),
    DeleteBucketPolicy("s3:DeleteBucketPolicy"),
    GetBucketNotificationConfiguration("s3:GetBucketNotification"),
    SetBucketNotificationConfiguration("s3:PutBucketNotification"),
    GetBucketLogging("s3:GetBucketLogging"),
    SetBucketLogging("s3:PutBucketLogging"),
    GetBucketTagging("s3:GetBucketTagging"),
    SetBucketTagging("s3:PutBucketTagging"),
    GetBucketWebsiteConfiguration("s3:GetBucketWebsite"),
    SetBucketWebsiteConfiguration("s3:PutBucketWebsite"),
    DeleteBucketWebsiteConfiguration("s3:DeleteBucketWebsite"),
    GetBucketLifecycleConfiguration("s3:GetLifecycleConfiguration"),
    SetBucketLifecycleConfiguration("s3:PutLifecycleConfiguration");

    private final String action;

    S3Actions(String str) {
        this.action = str;
    }

    @Override // com.amazonaws.auth.policy.Action
    public String getActionName() {
        return this.action;
    }
}
