package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class GrantListEntry implements Serializable {
    private GrantConstraints constraints;
    private Date creationDate;
    private String grantId;
    private String granteePrincipal;
    private String issuingAccount;
    private String keyId;
    private String name;
    private List operations = new ArrayList();
    private String retiringPrincipal;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GrantListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public GrantListEntry withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public GrantListEntry withName(String str) {
        this.name = str;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public GrantListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
    }

    public GrantListEntry withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public GrantListEntry withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public String getIssuingAccount() {
        return this.issuingAccount;
    }

    public void setIssuingAccount(String str) {
        this.issuingAccount = str;
    }

    public GrantListEntry withIssuingAccount(String str) {
        this.issuingAccount = str;
        return this;
    }

    public List<String> getOperations() {
        return this.operations;
    }

    public void setOperations(Collection<String> collection) {
        if (collection == null) {
            this.operations = null;
        } else {
            this.operations = new ArrayList(collection);
        }
    }

    public GrantListEntry withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.operations.add(str);
        }
        return this;
    }

    public GrantListEntry withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public GrantListEntry withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getGranteePrincipal() != null) {
            sb.append("GranteePrincipal: " + getGranteePrincipal() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal() + ",");
        }
        if (getIssuingAccount() != null) {
            sb.append("IssuingAccount: " + getIssuingAccount() + ",");
        }
        if (getOperations() != null) {
            sb.append("Operations: " + getOperations() + ",");
        }
        if (getConstraints() != null) {
            sb.append("Constraints: " + getConstraints());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getGranteePrincipal() == null ? 0 : getGranteePrincipal().hashCode())) * 31) + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode())) * 31) + (getIssuingAccount() == null ? 0 : getIssuingAccount().hashCode())) * 31) + (getOperations() == null ? 0 : getOperations().hashCode())) * 31) + (getConstraints() != null ? getConstraints().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantListEntry)) {
            return false;
        }
        GrantListEntry grantListEntry = (GrantListEntry) obj;
        if ((grantListEntry.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (grantListEntry.getKeyId() != null && !grantListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((grantListEntry.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (grantListEntry.getGrantId() != null && !grantListEntry.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((grantListEntry.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (grantListEntry.getName() != null && !grantListEntry.getName().equals(getName())) {
            return false;
        }
        if ((grantListEntry.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (grantListEntry.getCreationDate() != null && !grantListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((grantListEntry.getGranteePrincipal() == null) ^ (getGranteePrincipal() == null)) {
            return false;
        }
        if (grantListEntry.getGranteePrincipal() != null && !grantListEntry.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if ((grantListEntry.getRetiringPrincipal() == null) ^ (getRetiringPrincipal() == null)) {
            return false;
        }
        if (grantListEntry.getRetiringPrincipal() != null && !grantListEntry.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if ((grantListEntry.getIssuingAccount() == null) ^ (getIssuingAccount() == null)) {
            return false;
        }
        if (grantListEntry.getIssuingAccount() != null && !grantListEntry.getIssuingAccount().equals(getIssuingAccount())) {
            return false;
        }
        if ((grantListEntry.getOperations() == null) ^ (getOperations() == null)) {
            return false;
        }
        if (grantListEntry.getOperations() != null && !grantListEntry.getOperations().equals(getOperations())) {
            return false;
        }
        if ((grantListEntry.getConstraints() == null) ^ (getConstraints() == null)) {
            return false;
        }
        return grantListEntry.getConstraints() == null || grantListEntry.getConstraints().equals(getConstraints());
    }
}
