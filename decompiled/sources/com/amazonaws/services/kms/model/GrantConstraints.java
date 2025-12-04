package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GrantConstraints implements Serializable {
    private Map encryptionContextSubset = new HashMap();
    private Map encryptionContextEquals = new HashMap();

    public Map<String, String> getEncryptionContextSubset() {
        return this.encryptionContextSubset;
    }

    public void setEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
    }

    public GrantConstraints withEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
        return this;
    }

    public GrantConstraints addEncryptionContextSubsetEntry(String str, String str2) {
        if (this.encryptionContextSubset == null) {
            this.encryptionContextSubset = new HashMap();
        }
        if (this.encryptionContextSubset.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.encryptionContextSubset.put(str, str2);
        return this;
    }

    public GrantConstraints clearEncryptionContextSubsetEntries() {
        this.encryptionContextSubset = null;
        return this;
    }

    public Map<String, String> getEncryptionContextEquals() {
        return this.encryptionContextEquals;
    }

    public void setEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
    }

    public GrantConstraints withEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
        return this;
    }

    public GrantConstraints addEncryptionContextEqualsEntry(String str, String str2) {
        if (this.encryptionContextEquals == null) {
            this.encryptionContextEquals = new HashMap();
        }
        if (this.encryptionContextEquals.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.encryptionContextEquals.put(str, str2);
        return this;
    }

    public GrantConstraints clearEncryptionContextEqualsEntries() {
        this.encryptionContextEquals = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEncryptionContextSubset() != null) {
            sb.append("EncryptionContextSubset: " + getEncryptionContextSubset() + ",");
        }
        if (getEncryptionContextEquals() != null) {
            sb.append("EncryptionContextEquals: " + getEncryptionContextEquals());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getEncryptionContextSubset() == null ? 0 : getEncryptionContextSubset().hashCode()) + 31) * 31) + (getEncryptionContextEquals() != null ? getEncryptionContextEquals().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantConstraints)) {
            return false;
        }
        GrantConstraints grantConstraints = (GrantConstraints) obj;
        if ((grantConstraints.getEncryptionContextSubset() == null) ^ (getEncryptionContextSubset() == null)) {
            return false;
        }
        if (grantConstraints.getEncryptionContextSubset() != null && !grantConstraints.getEncryptionContextSubset().equals(getEncryptionContextSubset())) {
            return false;
        }
        if ((grantConstraints.getEncryptionContextEquals() == null) ^ (getEncryptionContextEquals() == null)) {
            return false;
        }
        return grantConstraints.getEncryptionContextEquals() == null || grantConstraints.getEncryptionContextEquals().equals(getEncryptionContextEquals());
    }
}
