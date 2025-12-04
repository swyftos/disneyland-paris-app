package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class UpdateAuthEventFeedbackRequest extends AmazonWebServiceRequest implements Serializable {
    private String eventId;
    private String feedbackToken;
    private String feedbackValue;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public UpdateAuthEventFeedbackRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public UpdateAuthEventFeedbackRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public UpdateAuthEventFeedbackRequest withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public String getFeedbackToken() {
        return this.feedbackToken;
    }

    public void setFeedbackToken(String str) {
        this.feedbackToken = str;
    }

    public UpdateAuthEventFeedbackRequest withFeedbackToken(String str) {
        this.feedbackToken = str;
        return this;
    }

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public UpdateAuthEventFeedbackRequest withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public UpdateAuthEventFeedbackRequest withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getEventId() != null) {
            sb.append("EventId: " + getEventId() + ",");
        }
        if (getFeedbackToken() != null) {
            sb.append("FeedbackToken: " + getFeedbackToken() + ",");
        }
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getEventId() == null ? 0 : getEventId().hashCode())) * 31) + (getFeedbackToken() == null ? 0 : getFeedbackToken().hashCode())) * 31) + (getFeedbackValue() != null ? getFeedbackValue().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateAuthEventFeedbackRequest)) {
            return false;
        }
        UpdateAuthEventFeedbackRequest updateAuthEventFeedbackRequest = (UpdateAuthEventFeedbackRequest) obj;
        if ((updateAuthEventFeedbackRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getUserPoolId() != null && !updateAuthEventFeedbackRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateAuthEventFeedbackRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getUsername() != null && !updateAuthEventFeedbackRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((updateAuthEventFeedbackRequest.getEventId() == null) ^ (getEventId() == null)) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getEventId() != null && !updateAuthEventFeedbackRequest.getEventId().equals(getEventId())) {
            return false;
        }
        if ((updateAuthEventFeedbackRequest.getFeedbackToken() == null) ^ (getFeedbackToken() == null)) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getFeedbackToken() != null && !updateAuthEventFeedbackRequest.getFeedbackToken().equals(getFeedbackToken())) {
            return false;
        }
        if ((updateAuthEventFeedbackRequest.getFeedbackValue() == null) ^ (getFeedbackValue() == null)) {
            return false;
        }
        return updateAuthEventFeedbackRequest.getFeedbackValue() == null || updateAuthEventFeedbackRequest.getFeedbackValue().equals(getFeedbackValue());
    }
}
