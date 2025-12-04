package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CompromisedCredentialsActionsType implements Serializable {
    private String eventAction;

    public String getEventAction() {
        return this.eventAction;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public CompromisedCredentialsActionsType withEventAction(String str) {
        this.eventAction = str;
        return this;
    }

    public void setEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
    }

    public CompromisedCredentialsActionsType withEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventAction() != null) {
            sb.append("EventAction: " + getEventAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getEventAction() == null ? 0 : getEventAction().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CompromisedCredentialsActionsType)) {
            return false;
        }
        CompromisedCredentialsActionsType compromisedCredentialsActionsType = (CompromisedCredentialsActionsType) obj;
        if ((compromisedCredentialsActionsType.getEventAction() == null) ^ (getEventAction() == null)) {
            return false;
        }
        return compromisedCredentialsActionsType.getEventAction() == null || compromisedCredentialsActionsType.getEventAction().equals(getEventAction());
    }
}
