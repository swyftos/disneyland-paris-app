package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AccountTakeoverRiskConfigurationType implements Serializable {
    private AccountTakeoverActionsType actions;
    private NotifyConfigurationType notifyConfiguration;

    public NotifyConfigurationType getNotifyConfiguration() {
        return this.notifyConfiguration;
    }

    public void setNotifyConfiguration(NotifyConfigurationType notifyConfigurationType) {
        this.notifyConfiguration = notifyConfigurationType;
    }

    public AccountTakeoverRiskConfigurationType withNotifyConfiguration(NotifyConfigurationType notifyConfigurationType) {
        this.notifyConfiguration = notifyConfigurationType;
        return this;
    }

    public AccountTakeoverActionsType getActions() {
        return this.actions;
    }

    public void setActions(AccountTakeoverActionsType accountTakeoverActionsType) {
        this.actions = accountTakeoverActionsType;
    }

    public AccountTakeoverRiskConfigurationType withActions(AccountTakeoverActionsType accountTakeoverActionsType) {
        this.actions = accountTakeoverActionsType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getNotifyConfiguration() != null) {
            sb.append("NotifyConfiguration: " + getNotifyConfiguration() + ",");
        }
        if (getActions() != null) {
            sb.append("Actions: " + getActions());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getNotifyConfiguration() == null ? 0 : getNotifyConfiguration().hashCode()) + 31) * 31) + (getActions() != null ? getActions().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountTakeoverRiskConfigurationType)) {
            return false;
        }
        AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType = (AccountTakeoverRiskConfigurationType) obj;
        if ((accountTakeoverRiskConfigurationType.getNotifyConfiguration() == null) ^ (getNotifyConfiguration() == null)) {
            return false;
        }
        if (accountTakeoverRiskConfigurationType.getNotifyConfiguration() != null && !accountTakeoverRiskConfigurationType.getNotifyConfiguration().equals(getNotifyConfiguration())) {
            return false;
        }
        if ((accountTakeoverRiskConfigurationType.getActions() == null) ^ (getActions() == null)) {
            return false;
        }
        return accountTakeoverRiskConfigurationType.getActions() == null || accountTakeoverRiskConfigurationType.getActions().equals(getActions());
    }
}
