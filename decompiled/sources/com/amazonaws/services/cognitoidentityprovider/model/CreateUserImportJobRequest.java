package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class CreateUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudWatchLogsRoleArn;
    private String jobName;
    private String userPoolId;

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String str) {
        this.jobName = str;
    }

    public CreateUserImportJobRequest withJobName(String str) {
        this.jobName = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public CreateUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getCloudWatchLogsRoleArn() {
        return this.cloudWatchLogsRoleArn;
    }

    public void setCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
    }

    public CreateUserImportJobRequest withCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getJobName() != null) {
            sb.append("JobName: " + getJobName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCloudWatchLogsRoleArn() != null) {
            sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getJobName() == null ? 0 : getJobName().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getCloudWatchLogsRoleArn() != null ? getCloudWatchLogsRoleArn().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserImportJobRequest)) {
            return false;
        }
        CreateUserImportJobRequest createUserImportJobRequest = (CreateUserImportJobRequest) obj;
        if ((createUserImportJobRequest.getJobName() == null) ^ (getJobName() == null)) {
            return false;
        }
        if (createUserImportJobRequest.getJobName() != null && !createUserImportJobRequest.getJobName().equals(getJobName())) {
            return false;
        }
        if ((createUserImportJobRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createUserImportJobRequest.getUserPoolId() != null && !createUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createUserImportJobRequest.getCloudWatchLogsRoleArn() == null) ^ (getCloudWatchLogsRoleArn() == null)) {
            return false;
        }
        return createUserImportJobRequest.getCloudWatchLogsRoleArn() == null || createUserImportJobRequest.getCloudWatchLogsRoleArn().equals(getCloudWatchLogsRoleArn());
    }
}
