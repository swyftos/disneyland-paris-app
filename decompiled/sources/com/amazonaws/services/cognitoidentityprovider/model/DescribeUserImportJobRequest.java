package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DescribeUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String jobId;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DescribeUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public DescribeUserImportJobRequest withJobId(String str) {
        this.jobId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getJobId() != null) {
            sb.append("JobId: " + getJobId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getJobId() != null ? getJobId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserImportJobRequest)) {
            return false;
        }
        DescribeUserImportJobRequest describeUserImportJobRequest = (DescribeUserImportJobRequest) obj;
        if ((describeUserImportJobRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (describeUserImportJobRequest.getUserPoolId() != null && !describeUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((describeUserImportJobRequest.getJobId() == null) ^ (getJobId() == null)) {
            return false;
        }
        return describeUserImportJobRequest.getJobId() == null || describeUserImportJobRequest.getJobId().equals(getJobId());
    }
}
