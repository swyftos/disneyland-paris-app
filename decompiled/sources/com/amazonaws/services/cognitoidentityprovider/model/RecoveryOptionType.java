package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class RecoveryOptionType implements Serializable {
    private String name;
    private Integer priority;

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public RecoveryOptionType withPriority(Integer num) {
        this.priority = num;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public RecoveryOptionType withName(String str) {
        this.name = str;
        return this;
    }

    public void setName(RecoveryOptionNameType recoveryOptionNameType) {
        this.name = recoveryOptionNameType.toString();
    }

    public RecoveryOptionType withName(RecoveryOptionNameType recoveryOptionNameType) {
        this.name = recoveryOptionNameType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPriority() != null) {
            sb.append("Priority: " + getPriority() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getPriority() == null ? 0 : getPriority().hashCode()) + 31) * 31) + (getName() != null ? getName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecoveryOptionType)) {
            return false;
        }
        RecoveryOptionType recoveryOptionType = (RecoveryOptionType) obj;
        if ((recoveryOptionType.getPriority() == null) ^ (getPriority() == null)) {
            return false;
        }
        if (recoveryOptionType.getPriority() != null && !recoveryOptionType.getPriority().equals(getPriority())) {
            return false;
        }
        if ((recoveryOptionType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        return recoveryOptionType.getName() == null || recoveryOptionType.getName().equals(getName());
    }
}
