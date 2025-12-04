package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class CompromisedCredentialsRiskConfigurationType implements Serializable {
    private CompromisedCredentialsActionsType actions;
    private List eventFilter;

    public List<String> getEventFilter() {
        return this.eventFilter;
    }

    public void setEventFilter(Collection<String> collection) {
        if (collection == null) {
            this.eventFilter = null;
        } else {
            this.eventFilter = new ArrayList(collection);
        }
    }

    public CompromisedCredentialsRiskConfigurationType withEventFilter(String... strArr) {
        if (getEventFilter() == null) {
            this.eventFilter = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.eventFilter.add(str);
        }
        return this;
    }

    public CompromisedCredentialsRiskConfigurationType withEventFilter(Collection<String> collection) {
        setEventFilter(collection);
        return this;
    }

    public CompromisedCredentialsActionsType getActions() {
        return this.actions;
    }

    public void setActions(CompromisedCredentialsActionsType compromisedCredentialsActionsType) {
        this.actions = compromisedCredentialsActionsType;
    }

    public CompromisedCredentialsRiskConfigurationType withActions(CompromisedCredentialsActionsType compromisedCredentialsActionsType) {
        this.actions = compromisedCredentialsActionsType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventFilter() != null) {
            sb.append("EventFilter: " + getEventFilter() + ",");
        }
        if (getActions() != null) {
            sb.append("Actions: " + getActions());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getEventFilter() == null ? 0 : getEventFilter().hashCode()) + 31) * 31) + (getActions() != null ? getActions().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CompromisedCredentialsRiskConfigurationType)) {
            return false;
        }
        CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType = (CompromisedCredentialsRiskConfigurationType) obj;
        if ((compromisedCredentialsRiskConfigurationType.getEventFilter() == null) ^ (getEventFilter() == null)) {
            return false;
        }
        if (compromisedCredentialsRiskConfigurationType.getEventFilter() != null && !compromisedCredentialsRiskConfigurationType.getEventFilter().equals(getEventFilter())) {
            return false;
        }
        if ((compromisedCredentialsRiskConfigurationType.getActions() == null) ^ (getActions() == null)) {
            return false;
        }
        return compromisedCredentialsRiskConfigurationType.getActions() == null || compromisedCredentialsRiskConfigurationType.getActions().equals(getActions());
    }
}
