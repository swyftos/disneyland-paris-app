package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AliasListEntry implements Serializable {
    private String aliasArn;
    private String aliasName;
    private String targetKeyId;

    public String getAliasName() {
        return this.aliasName;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public AliasListEntry withAliasName(String str) {
        this.aliasName = str;
        return this;
    }

    public String getAliasArn() {
        return this.aliasArn;
    }

    public void setAliasArn(String str) {
        this.aliasArn = str;
    }

    public AliasListEntry withAliasArn(String str) {
        this.aliasArn = str;
        return this;
    }

    public String getTargetKeyId() {
        return this.targetKeyId;
    }

    public void setTargetKeyId(String str) {
        this.targetKeyId = str;
    }

    public AliasListEntry withTargetKeyId(String str) {
        this.targetKeyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAliasName() != null) {
            sb.append("AliasName: " + getAliasName() + ",");
        }
        if (getAliasArn() != null) {
            sb.append("AliasArn: " + getAliasArn() + ",");
        }
        if (getTargetKeyId() != null) {
            sb.append("TargetKeyId: " + getTargetKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getAliasName() == null ? 0 : getAliasName().hashCode()) + 31) * 31) + (getAliasArn() == null ? 0 : getAliasArn().hashCode())) * 31) + (getTargetKeyId() != null ? getTargetKeyId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AliasListEntry)) {
            return false;
        }
        AliasListEntry aliasListEntry = (AliasListEntry) obj;
        if ((aliasListEntry.getAliasName() == null) ^ (getAliasName() == null)) {
            return false;
        }
        if (aliasListEntry.getAliasName() != null && !aliasListEntry.getAliasName().equals(getAliasName())) {
            return false;
        }
        if ((aliasListEntry.getAliasArn() == null) ^ (getAliasArn() == null)) {
            return false;
        }
        if (aliasListEntry.getAliasArn() != null && !aliasListEntry.getAliasArn().equals(getAliasArn())) {
            return false;
        }
        if ((aliasListEntry.getTargetKeyId() == null) ^ (getTargetKeyId() == null)) {
            return false;
        }
        return aliasListEntry.getTargetKeyId() == null || aliasListEntry.getTargetKeyId().equals(getTargetKeyId());
    }
}
