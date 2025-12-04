package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class AuthEventType implements Serializable {
    private List challengeResponses;
    private Date creationDate;
    private EventContextDataType eventContextData;
    private EventFeedbackType eventFeedback;
    private String eventId;
    private String eventResponse;
    private EventRiskType eventRisk;
    private String eventType;

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public AuthEventType withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public AuthEventType withEventType(String str) {
        this.eventType = str;
        return this;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType.toString();
    }

    public AuthEventType withEventType(EventType eventType) {
        this.eventType = eventType.toString();
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public AuthEventType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String getEventResponse() {
        return this.eventResponse;
    }

    public void setEventResponse(String str) {
        this.eventResponse = str;
    }

    public AuthEventType withEventResponse(String str) {
        this.eventResponse = str;
        return this;
    }

    public void setEventResponse(EventResponseType eventResponseType) {
        this.eventResponse = eventResponseType.toString();
    }

    public AuthEventType withEventResponse(EventResponseType eventResponseType) {
        this.eventResponse = eventResponseType.toString();
        return this;
    }

    public EventRiskType getEventRisk() {
        return this.eventRisk;
    }

    public void setEventRisk(EventRiskType eventRiskType) {
        this.eventRisk = eventRiskType;
    }

    public AuthEventType withEventRisk(EventRiskType eventRiskType) {
        this.eventRisk = eventRiskType;
        return this;
    }

    public List<ChallengeResponseType> getChallengeResponses() {
        return this.challengeResponses;
    }

    public void setChallengeResponses(Collection<ChallengeResponseType> collection) {
        if (collection == null) {
            this.challengeResponses = null;
        } else {
            this.challengeResponses = new ArrayList(collection);
        }
    }

    public AuthEventType withChallengeResponses(ChallengeResponseType... challengeResponseTypeArr) {
        if (getChallengeResponses() == null) {
            this.challengeResponses = new ArrayList(challengeResponseTypeArr.length);
        }
        for (ChallengeResponseType challengeResponseType : challengeResponseTypeArr) {
            this.challengeResponses.add(challengeResponseType);
        }
        return this;
    }

    public AuthEventType withChallengeResponses(Collection<ChallengeResponseType> collection) {
        setChallengeResponses(collection);
        return this;
    }

    public EventContextDataType getEventContextData() {
        return this.eventContextData;
    }

    public void setEventContextData(EventContextDataType eventContextDataType) {
        this.eventContextData = eventContextDataType;
    }

    public AuthEventType withEventContextData(EventContextDataType eventContextDataType) {
        this.eventContextData = eventContextDataType;
        return this;
    }

    public EventFeedbackType getEventFeedback() {
        return this.eventFeedback;
    }

    public void setEventFeedback(EventFeedbackType eventFeedbackType) {
        this.eventFeedback = eventFeedbackType;
    }

    public AuthEventType withEventFeedback(EventFeedbackType eventFeedbackType) {
        this.eventFeedback = eventFeedbackType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventId() != null) {
            sb.append("EventId: " + getEventId() + ",");
        }
        if (getEventType() != null) {
            sb.append("EventType: " + getEventType() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getEventResponse() != null) {
            sb.append("EventResponse: " + getEventResponse() + ",");
        }
        if (getEventRisk() != null) {
            sb.append("EventRisk: " + getEventRisk() + ",");
        }
        if (getChallengeResponses() != null) {
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        }
        if (getEventContextData() != null) {
            sb.append("EventContextData: " + getEventContextData() + ",");
        }
        if (getEventFeedback() != null) {
            sb.append("EventFeedback: " + getEventFeedback());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((getEventId() == null ? 0 : getEventId().hashCode()) + 31) * 31) + (getEventType() == null ? 0 : getEventType().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getEventResponse() == null ? 0 : getEventResponse().hashCode())) * 31) + (getEventRisk() == null ? 0 : getEventRisk().hashCode())) * 31) + (getChallengeResponses() == null ? 0 : getChallengeResponses().hashCode())) * 31) + (getEventContextData() == null ? 0 : getEventContextData().hashCode())) * 31) + (getEventFeedback() != null ? getEventFeedback().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthEventType)) {
            return false;
        }
        AuthEventType authEventType = (AuthEventType) obj;
        if ((authEventType.getEventId() == null) ^ (getEventId() == null)) {
            return false;
        }
        if (authEventType.getEventId() != null && !authEventType.getEventId().equals(getEventId())) {
            return false;
        }
        if ((authEventType.getEventType() == null) ^ (getEventType() == null)) {
            return false;
        }
        if (authEventType.getEventType() != null && !authEventType.getEventType().equals(getEventType())) {
            return false;
        }
        if ((authEventType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (authEventType.getCreationDate() != null && !authEventType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((authEventType.getEventResponse() == null) ^ (getEventResponse() == null)) {
            return false;
        }
        if (authEventType.getEventResponse() != null && !authEventType.getEventResponse().equals(getEventResponse())) {
            return false;
        }
        if ((authEventType.getEventRisk() == null) ^ (getEventRisk() == null)) {
            return false;
        }
        if (authEventType.getEventRisk() != null && !authEventType.getEventRisk().equals(getEventRisk())) {
            return false;
        }
        if ((authEventType.getChallengeResponses() == null) ^ (getChallengeResponses() == null)) {
            return false;
        }
        if (authEventType.getChallengeResponses() != null && !authEventType.getChallengeResponses().equals(getChallengeResponses())) {
            return false;
        }
        if ((authEventType.getEventContextData() == null) ^ (getEventContextData() == null)) {
            return false;
        }
        if (authEventType.getEventContextData() != null && !authEventType.getEventContextData().equals(getEventContextData())) {
            return false;
        }
        if ((authEventType.getEventFeedback() == null) ^ (getEventFeedback() == null)) {
            return false;
        }
        return authEventType.getEventFeedback() == null || authEventType.getEventFeedback().equals(getEventFeedback());
    }
}
