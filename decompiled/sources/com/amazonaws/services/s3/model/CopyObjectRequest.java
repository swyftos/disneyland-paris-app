package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class CopyObjectRequest extends AmazonWebServiceRequest implements SSEAwsKeyManagementParamsProvider, Serializable, S3AccelerateUnsupported {
    private AccessControlList accessControlList;
    private CannedAccessControlList cannedACL;
    private String destinationBucketName;
    private String destinationKey;
    private SSECustomerKey destinationSSECustomerKey;
    private boolean isRequesterPays;
    private List matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private ObjectMetadata newObjectMetadata;
    private ObjectTagging newObjectTagging;
    private List nonmatchingEtagConstraints;
    private String redirectLocation;
    private String sourceBucketName;
    private String sourceKey;
    private SSECustomerKey sourceSSECustomerKey;
    private String sourceVersionId;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private String storageClass;
    private Date unmodifiedSinceConstraint;

    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        this(str, str2, null, str3, str4);
    }

    public CopyObjectRequest(String str, String str2, String str3, String str4, String str5) {
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.sourceBucketName = str;
        this.sourceKey = str2;
        this.sourceVersionId = str3;
        this.destinationBucketName = str4;
        this.destinationKey = str5;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public CopyObjectRequest withSourceBucketName(String str) {
        setSourceBucketName(str);
        return this;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public CopyObjectRequest withSourceKey(String str) {
        setSourceKey(str);
        return this;
    }

    public String getSourceVersionId() {
        return this.sourceVersionId;
    }

    public void setSourceVersionId(String str) {
        this.sourceVersionId = str;
    }

    public CopyObjectRequest withSourceVersionId(String str) {
        setSourceVersionId(str);
        return this;
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public CopyObjectRequest withDestinationBucketName(String str) {
        setDestinationBucketName(str);
        return this;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public CopyObjectRequest withDestinationKey(String str) {
        setDestinationKey(str);
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public CopyObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public void setStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass.toString();
    }

    public CopyObjectRequest withStorageClass(StorageClass storageClass) {
        setStorageClass(storageClass);
        return this;
    }

    public CannedAccessControlList getCannedAccessControlList() {
        return this.cannedACL;
    }

    public void setCannedAccessControlList(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
    }

    public CopyObjectRequest withCannedAccessControlList(CannedAccessControlList cannedAccessControlList) {
        setCannedAccessControlList(cannedAccessControlList);
        return this;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public void setAccessControlList(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }

    public CopyObjectRequest withAccessControlList(AccessControlList accessControlList) {
        setAccessControlList(accessControlList);
        return this;
    }

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public CopyObjectRequest withNewObjectMetadata(ObjectMetadata objectMetadata) {
        setNewObjectMetadata(objectMetadata);
        return this;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints = list;
    }

    public CopyObjectRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints = list;
    }

    public CopyObjectRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public CopyObjectRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public CopyObjectRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public CopyObjectRequest withRedirectLocation(String str) {
        this.redirectLocation = str;
        return this;
    }

    public SSECustomerKey getSourceSSECustomerKey() {
        return this.sourceSSECustomerKey;
    }

    public void setSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sourceSSECustomerKey = sSECustomerKey;
    }

    public CopyObjectRequest withSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSourceSSECustomerKey(sSECustomerKey);
        return this;
    }

    public SSECustomerKey getDestinationSSECustomerKey() {
        return this.destinationSSECustomerKey;
    }

    public void setDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.destinationSSECustomerKey = sSECustomerKey;
    }

    public CopyObjectRequest withDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setDestinationSSECustomerKey(sSECustomerKey);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.SSEAwsKeyManagementParamsProvider
    public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams() {
        return this.sseAwsKeyManagementParams;
    }

    public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null && this.destinationSSECustomerKey != null) {
            throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
        }
        this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
    }

    public CopyObjectRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        setSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public CopyObjectRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }

    public ObjectTagging getNewObjectTagging() {
        return this.newObjectTagging;
    }

    public void setNewObjectTagging(ObjectTagging objectTagging) {
        this.newObjectTagging = objectTagging;
    }

    public CopyObjectRequest withNewObjectTagging(ObjectTagging objectTagging) {
        setNewObjectTagging(objectTagging);
        return this;
    }
}
