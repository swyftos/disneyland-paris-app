package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AccountTakeoverActionType implements Serializable {
    private String eventAction;
    private Boolean notify;

    public Boolean isNotify() {
        return this.notify;
    }

    public Boolean getNotify() {
        return this.notify;
    }

    public void setNotify(Boolean bool) {
        this.notify = bool;
    }

    public AccountTakeoverActionType withNotify(Boolean bool) {
        this.notify = bool;
        return this;
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public AccountTakeoverActionType withEventAction(String str) {
        this.eventAction = str;
        return this;
    }

    public void setEventAction(AccountTakeoverEventActionType accountTakeoverEventActionType) {
        this.eventAction = accountTakeoverEventActionType.toString();
    }

    public AccountTakeoverActionType withEventAction(AccountTakeoverEventActionType accountTakeoverEventActionType) {
        this.eventAction = accountTakeoverEventActionType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getNotify() != null) {
            sb.append("Notify: " + getNotify() + ",");
        }
        if (getEventAction() != null) {
            sb.append("EventAction: " + getEventAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getNotify() == null ? 0 : getNotify().hashCode()) + 31) * 31) + (getEventAction() != null ? getEventAction().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountTakeoverActionType)) {
            return false;
        }
        AccountTakeoverActionType accountTakeoverActionType = (AccountTakeoverActionType) obj;
        if ((accountTakeoverActionType.getNotify() == null) ^ (getNotify() == null)) {
            return false;
        }
        if (accountTakeoverActionType.getNotify() != null && !accountTakeoverActionType.getNotify().equals(getNotify())) {
            return false;
        }
        if ((accountTakeoverActionType.getEventAction() == null) ^ (getEventAction() == null)) {
            return false;
        }
        return accountTakeoverActionType.getEventAction() == null || accountTakeoverActionType.getEventAction().equals(getEventAction());
    }
}
