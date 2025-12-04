package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class RiskExceptionConfigurationType implements Serializable {
    private List blockedIPRangeList;
    private List skippedIPRangeList;

    public List<String> getBlockedIPRangeList() {
        return this.blockedIPRangeList;
    }

    public void setBlockedIPRangeList(Collection<String> collection) {
        if (collection == null) {
            this.blockedIPRangeList = null;
        } else {
            this.blockedIPRangeList = new ArrayList(collection);
        }
    }

    public RiskExceptionConfigurationType withBlockedIPRangeList(String... strArr) {
        if (getBlockedIPRangeList() == null) {
            this.blockedIPRangeList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.blockedIPRangeList.add(str);
        }
        return this;
    }

    public RiskExceptionConfigurationType withBlockedIPRangeList(Collection<String> collection) {
        setBlockedIPRangeList(collection);
        return this;
    }

    public List<String> getSkippedIPRangeList() {
        return this.skippedIPRangeList;
    }

    public void setSkippedIPRangeList(Collection<String> collection) {
        if (collection == null) {
            this.skippedIPRangeList = null;
        } else {
            this.skippedIPRangeList = new ArrayList(collection);
        }
    }

    public RiskExceptionConfigurationType withSkippedIPRangeList(String... strArr) {
        if (getSkippedIPRangeList() == null) {
            this.skippedIPRangeList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.skippedIPRangeList.add(str);
        }
        return this;
    }

    public RiskExceptionConfigurationType withSkippedIPRangeList(Collection<String> collection) {
        setSkippedIPRangeList(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getBlockedIPRangeList() != null) {
            sb.append("BlockedIPRangeList: " + getBlockedIPRangeList() + ",");
        }
        if (getSkippedIPRangeList() != null) {
            sb.append("SkippedIPRangeList: " + getSkippedIPRangeList());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getBlockedIPRangeList() == null ? 0 : getBlockedIPRangeList().hashCode()) + 31) * 31) + (getSkippedIPRangeList() != null ? getSkippedIPRangeList().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RiskExceptionConfigurationType)) {
            return false;
        }
        RiskExceptionConfigurationType riskExceptionConfigurationType = (RiskExceptionConfigurationType) obj;
        if ((riskExceptionConfigurationType.getBlockedIPRangeList() == null) ^ (getBlockedIPRangeList() == null)) {
            return false;
        }
        if (riskExceptionConfigurationType.getBlockedIPRangeList() != null && !riskExceptionConfigurationType.getBlockedIPRangeList().equals(getBlockedIPRangeList())) {
            return false;
        }
        if ((riskExceptionConfigurationType.getSkippedIPRangeList() == null) ^ (getSkippedIPRangeList() == null)) {
            return false;
        }
        return riskExceptionConfigurationType.getSkippedIPRangeList() == null || riskExceptionConfigurationType.getSkippedIPRangeList().equals(getSkippedIPRangeList());
    }
}
