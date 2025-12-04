package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MappingRule implements Serializable {
    private String claim;
    private String matchType;
    private String roleARN;
    private String value;

    public String getClaim() {
        return this.claim;
    }

    public void setClaim(String str) {
        this.claim = str;
    }

    public MappingRule withClaim(String str) {
        this.claim = str;
        return this;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public void setMatchType(String str) {
        this.matchType = str;
    }

    public MappingRule withMatchType(String str) {
        this.matchType = str;
        return this;
    }

    public void setMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
    }

    public MappingRule withMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public MappingRule withValue(String str) {
        this.value = str;
        return this;
    }

    public String getRoleARN() {
        return this.roleARN;
    }

    public void setRoleARN(String str) {
        this.roleARN = str;
    }

    public MappingRule withRoleARN(String str) {
        this.roleARN = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClaim() != null) {
            sb.append("Claim: " + getClaim() + ",");
        }
        if (getMatchType() != null) {
            sb.append("MatchType: " + getMatchType() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue() + ",");
        }
        if (getRoleARN() != null) {
            sb.append("RoleARN: " + getRoleARN());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getClaim() == null ? 0 : getClaim().hashCode()) + 31) * 31) + (getMatchType() == null ? 0 : getMatchType().hashCode())) * 31) + (getValue() == null ? 0 : getValue().hashCode())) * 31) + (getRoleARN() != null ? getRoleARN().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MappingRule)) {
            return false;
        }
        MappingRule mappingRule = (MappingRule) obj;
        if ((mappingRule.getClaim() == null) ^ (getClaim() == null)) {
            return false;
        }
        if (mappingRule.getClaim() != null && !mappingRule.getClaim().equals(getClaim())) {
            return false;
        }
        if ((mappingRule.getMatchType() == null) ^ (getMatchType() == null)) {
            return false;
        }
        if (mappingRule.getMatchType() != null && !mappingRule.getMatchType().equals(getMatchType())) {
            return false;
        }
        if ((mappingRule.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        if (mappingRule.getValue() != null && !mappingRule.getValue().equals(getValue())) {
            return false;
        }
        if ((mappingRule.getRoleARN() == null) ^ (getRoleARN() == null)) {
            return false;
        }
        return mappingRule.getRoleARN() == null || mappingRule.getRoleARN().equals(getRoleARN());
    }
}
