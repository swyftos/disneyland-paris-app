package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AccountTakeoverActionsType implements Serializable {
    private AccountTakeoverActionType highAction;
    private AccountTakeoverActionType lowAction;
    private AccountTakeoverActionType mediumAction;

    public AccountTakeoverActionType getLowAction() {
        return this.lowAction;
    }

    public void setLowAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.lowAction = accountTakeoverActionType;
    }

    public AccountTakeoverActionsType withLowAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.lowAction = accountTakeoverActionType;
        return this;
    }

    public AccountTakeoverActionType getMediumAction() {
        return this.mediumAction;
    }

    public void setMediumAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.mediumAction = accountTakeoverActionType;
    }

    public AccountTakeoverActionsType withMediumAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.mediumAction = accountTakeoverActionType;
        return this;
    }

    public AccountTakeoverActionType getHighAction() {
        return this.highAction;
    }

    public void setHighAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.highAction = accountTakeoverActionType;
    }

    public AccountTakeoverActionsType withHighAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.highAction = accountTakeoverActionType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLowAction() != null) {
            sb.append("LowAction: " + getLowAction() + ",");
        }
        if (getMediumAction() != null) {
            sb.append("MediumAction: " + getMediumAction() + ",");
        }
        if (getHighAction() != null) {
            sb.append("HighAction: " + getHighAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getLowAction() == null ? 0 : getLowAction().hashCode()) + 31) * 31) + (getMediumAction() == null ? 0 : getMediumAction().hashCode())) * 31) + (getHighAction() != null ? getHighAction().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountTakeoverActionsType)) {
            return false;
        }
        AccountTakeoverActionsType accountTakeoverActionsType = (AccountTakeoverActionsType) obj;
        if ((accountTakeoverActionsType.getLowAction() == null) ^ (getLowAction() == null)) {
            return false;
        }
        if (accountTakeoverActionsType.getLowAction() != null && !accountTakeoverActionsType.getLowAction().equals(getLowAction())) {
            return false;
        }
        if ((accountTakeoverActionsType.getMediumAction() == null) ^ (getMediumAction() == null)) {
            return false;
        }
        if (accountTakeoverActionsType.getMediumAction() != null && !accountTakeoverActionsType.getMediumAction().equals(getMediumAction())) {
            return false;
        }
        if ((accountTakeoverActionsType.getHighAction() == null) ^ (getHighAction() == null)) {
            return false;
        }
        return accountTakeoverActionsType.getHighAction() == null || accountTakeoverActionsType.getHighAction().equals(getHighAction());
    }
}
