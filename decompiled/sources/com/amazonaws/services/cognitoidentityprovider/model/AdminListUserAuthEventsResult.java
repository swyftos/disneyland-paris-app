package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class AdminListUserAuthEventsResult implements Serializable {
    private List authEvents;
    private String nextToken;

    public List<AuthEventType> getAuthEvents() {
        return this.authEvents;
    }

    public void setAuthEvents(Collection<AuthEventType> collection) {
        if (collection == null) {
            this.authEvents = null;
        } else {
            this.authEvents = new ArrayList(collection);
        }
    }

    public AdminListUserAuthEventsResult withAuthEvents(AuthEventType... authEventTypeArr) {
        if (getAuthEvents() == null) {
            this.authEvents = new ArrayList(authEventTypeArr.length);
        }
        for (AuthEventType authEventType : authEventTypeArr) {
            this.authEvents.add(authEventType);
        }
        return this;
    }

    public AdminListUserAuthEventsResult withAuthEvents(Collection<AuthEventType> collection) {
        setAuthEvents(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public AdminListUserAuthEventsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAuthEvents() != null) {
            sb.append("AuthEvents: " + getAuthEvents() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getAuthEvents() == null ? 0 : getAuthEvents().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListUserAuthEventsResult)) {
            return false;
        }
        AdminListUserAuthEventsResult adminListUserAuthEventsResult = (AdminListUserAuthEventsResult) obj;
        if ((adminListUserAuthEventsResult.getAuthEvents() == null) ^ (getAuthEvents() == null)) {
            return false;
        }
        if (adminListUserAuthEventsResult.getAuthEvents() != null && !adminListUserAuthEventsResult.getAuthEvents().equals(getAuthEvents())) {
            return false;
        }
        if ((adminListUserAuthEventsResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return adminListUserAuthEventsResult.getNextToken() == null || adminListUserAuthEventsResult.getNextToken().equals(getNextToken());
    }
}
