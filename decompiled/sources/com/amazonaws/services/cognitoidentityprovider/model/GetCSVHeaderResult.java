package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class GetCSVHeaderResult implements Serializable {
    private List cSVHeader;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetCSVHeaderResult withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public List<String> getCSVHeader() {
        return this.cSVHeader;
    }

    public void setCSVHeader(Collection<String> collection) {
        if (collection == null) {
            this.cSVHeader = null;
        } else {
            this.cSVHeader = new ArrayList(collection);
        }
    }

    public GetCSVHeaderResult withCSVHeader(String... strArr) {
        if (getCSVHeader() == null) {
            this.cSVHeader = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.cSVHeader.add(str);
        }
        return this;
    }

    public GetCSVHeaderResult withCSVHeader(Collection<String> collection) {
        setCSVHeader(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCSVHeader() != null) {
            sb.append("CSVHeader: " + getCSVHeader());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getCSVHeader() != null ? getCSVHeader().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCSVHeaderResult)) {
            return false;
        }
        GetCSVHeaderResult getCSVHeaderResult = (GetCSVHeaderResult) obj;
        if ((getCSVHeaderResult.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (getCSVHeaderResult.getUserPoolId() != null && !getCSVHeaderResult.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((getCSVHeaderResult.getCSVHeader() == null) ^ (getCSVHeader() == null)) {
            return false;
        }
        return getCSVHeaderResult.getCSVHeader() == null || getCSVHeaderResult.getCSVHeader().equals(getCSVHeader());
    }
}
