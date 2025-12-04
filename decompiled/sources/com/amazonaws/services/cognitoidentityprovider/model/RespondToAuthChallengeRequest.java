package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RespondToAuthChallengeRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String challengeName;
    private Map challengeResponses;
    private String clientId;
    private Map clientMetadata;
    private String session;
    private UserContextDataType userContextData;

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public RespondToAuthChallengeRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public RespondToAuthChallengeRequest withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public void setChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
    }

    public RespondToAuthChallengeRequest withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public RespondToAuthChallengeRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public Map<String, String> getChallengeResponses() {
        return this.challengeResponses;
    }

    public void setChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
    }

    public RespondToAuthChallengeRequest withChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
        return this;
    }

    public RespondToAuthChallengeRequest addChallengeResponsesEntry(String str, String str2) {
        if (this.challengeResponses == null) {
            this.challengeResponses = new HashMap();
        }
        if (this.challengeResponses.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.challengeResponses.put(str, str2);
        return this;
    }

    public RespondToAuthChallengeRequest clearChallengeResponsesEntries() {
        this.challengeResponses = null;
        return this;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public RespondToAuthChallengeRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public RespondToAuthChallengeRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public RespondToAuthChallengeRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public RespondToAuthChallengeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public RespondToAuthChallengeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getChallengeResponses() != null) {
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getChallengeName() == null ? 0 : getChallengeName().hashCode())) * 31) + (getSession() == null ? 0 : getSession().hashCode())) * 31) + (getChallengeResponses() == null ? 0 : getChallengeResponses().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RespondToAuthChallengeRequest)) {
            return false;
        }
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = (RespondToAuthChallengeRequest) obj;
        if ((respondToAuthChallengeRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getClientId() != null && !respondToAuthChallengeRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getChallengeName() == null) ^ (getChallengeName() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getChallengeName() != null && !respondToAuthChallengeRequest.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getSession() != null && !respondToAuthChallengeRequest.getSession().equals(getSession())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getChallengeResponses() == null) ^ (getChallengeResponses() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getChallengeResponses() != null && !respondToAuthChallengeRequest.getChallengeResponses().equals(getChallengeResponses())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getAnalyticsMetadata() != null && !respondToAuthChallengeRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (respondToAuthChallengeRequest.getUserContextData() != null && !respondToAuthChallengeRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((respondToAuthChallengeRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return respondToAuthChallengeRequest.getClientMetadata() == null || respondToAuthChallengeRequest.getClientMetadata().equals(getClientMetadata());
    }
}
