package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class StartUserImportJobResult implements Serializable {
    private UserImportJobType userImportJob;

    public UserImportJobType getUserImportJob() {
        return this.userImportJob;
    }

    public void setUserImportJob(UserImportJobType userImportJobType) {
        this.userImportJob = userImportJobType;
    }

    public StartUserImportJobResult withUserImportJob(UserImportJobType userImportJobType) {
        this.userImportJob = userImportJobType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserImportJob() != null) {
            sb.append("UserImportJob: " + getUserImportJob());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUserImportJob() == null ? 0 : getUserImportJob().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StartUserImportJobResult)) {
            return false;
        }
        StartUserImportJobResult startUserImportJobResult = (StartUserImportJobResult) obj;
        if ((startUserImportJobResult.getUserImportJob() == null) ^ (getUserImportJob() == null)) {
            return false;
        }
        return startUserImportJobResult.getUserImportJob() == null || startUserImportJobResult.getUserImportJob().equals(getUserImportJob());
    }
}
