package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListKeyPoliciesResult implements Serializable {
    private String nextMarker;
    private List policyNames = new ArrayList();
    private Boolean truncated;

    public List<String> getPolicyNames() {
        return this.policyNames;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            this.policyNames = new ArrayList(collection);
        }
    }

    public ListKeyPoliciesResult withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            this.policyNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.policyNames.add(str);
        }
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(Collection<String> collection) {
        setPolicyNames(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public ListKeyPoliciesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public ListKeyPoliciesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPolicyNames() != null) {
            sb.append("PolicyNames: " + getPolicyNames() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getPolicyNames() == null ? 0 : getPolicyNames().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31) + (getTruncated() != null ? getTruncated().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyPoliciesResult)) {
            return false;
        }
        ListKeyPoliciesResult listKeyPoliciesResult = (ListKeyPoliciesResult) obj;
        if ((listKeyPoliciesResult.getPolicyNames() == null) ^ (getPolicyNames() == null)) {
            return false;
        }
        if (listKeyPoliciesResult.getPolicyNames() != null && !listKeyPoliciesResult.getPolicyNames().equals(getPolicyNames())) {
            return false;
        }
        if ((listKeyPoliciesResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() != null && !listKeyPoliciesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeyPoliciesResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeyPoliciesResult.getTruncated() == null || listKeyPoliciesResult.getTruncated().equals(getTruncated());
    }
}
