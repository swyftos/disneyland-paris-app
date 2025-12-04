package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SetRiskConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private AccountTakeoverRiskConfigurationType accountTakeoverRiskConfiguration;
    private String clientId;
    private CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfiguration;
    private RiskExceptionConfigurationType riskExceptionConfiguration;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public SetRiskConfigurationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public SetRiskConfigurationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public CompromisedCredentialsRiskConfigurationType getCompromisedCredentialsRiskConfiguration() {
        return this.compromisedCredentialsRiskConfiguration;
    }

    public void setCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
    }

    public SetRiskConfigurationRequest withCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
        return this;
    }

    public AccountTakeoverRiskConfigurationType getAccountTakeoverRiskConfiguration() {
        return this.accountTakeoverRiskConfiguration;
    }

    public void setAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
    }

    public SetRiskConfigurationRequest withAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
        return this;
    }

    public RiskExceptionConfigurationType getRiskExceptionConfiguration() {
        return this.riskExceptionConfiguration;
    }

    public void setRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
    }

    public SetRiskConfigurationRequest withRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getCompromisedCredentialsRiskConfiguration() != null) {
            sb.append("CompromisedCredentialsRiskConfiguration: " + getCompromisedCredentialsRiskConfiguration() + ",");
        }
        if (getAccountTakeoverRiskConfiguration() != null) {
            sb.append("AccountTakeoverRiskConfiguration: " + getAccountTakeoverRiskConfiguration() + ",");
        }
        if (getRiskExceptionConfiguration() != null) {
            sb.append("RiskExceptionConfiguration: " + getRiskExceptionConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getCompromisedCredentialsRiskConfiguration() == null ? 0 : getCompromisedCredentialsRiskConfiguration().hashCode())) * 31) + (getAccountTakeoverRiskConfiguration() == null ? 0 : getAccountTakeoverRiskConfiguration().hashCode())) * 31) + (getRiskExceptionConfiguration() != null ? getRiskExceptionConfiguration().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetRiskConfigurationRequest)) {
            return false;
        }
        SetRiskConfigurationRequest setRiskConfigurationRequest = (SetRiskConfigurationRequest) obj;
        if ((setRiskConfigurationRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (setRiskConfigurationRequest.getUserPoolId() != null && !setRiskConfigurationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((setRiskConfigurationRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (setRiskConfigurationRequest.getClientId() != null && !setRiskConfigurationRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((setRiskConfigurationRequest.getCompromisedCredentialsRiskConfiguration() == null) ^ (getCompromisedCredentialsRiskConfiguration() == null)) {
            return false;
        }
        if (setRiskConfigurationRequest.getCompromisedCredentialsRiskConfiguration() != null && !setRiskConfigurationRequest.getCompromisedCredentialsRiskConfiguration().equals(getCompromisedCredentialsRiskConfiguration())) {
            return false;
        }
        if ((setRiskConfigurationRequest.getAccountTakeoverRiskConfiguration() == null) ^ (getAccountTakeoverRiskConfiguration() == null)) {
            return false;
        }
        if (setRiskConfigurationRequest.getAccountTakeoverRiskConfiguration() != null && !setRiskConfigurationRequest.getAccountTakeoverRiskConfiguration().equals(getAccountTakeoverRiskConfiguration())) {
            return false;
        }
        if ((setRiskConfigurationRequest.getRiskExceptionConfiguration() == null) ^ (getRiskExceptionConfiguration() == null)) {
            return false;
        }
        return setRiskConfigurationRequest.getRiskExceptionConfiguration() == null || setRiskConfigurationRequest.getRiskExceptionConfiguration().equals(getRiskExceptionConfiguration());
    }
}
