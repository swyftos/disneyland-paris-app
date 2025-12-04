package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminRespondToAuthChallengeRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String challengeName;
    private Map challengeResponses;
    private String clientId;
    private Map clientMetadata;
    private ContextDataType contextData;
    private String session;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminRespondToAuthChallengeRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public AdminRespondToAuthChallengeRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public AdminRespondToAuthChallengeRequest withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public void setChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
    }

    public AdminRespondToAuthChallengeRequest withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }

    public Map<String, String> getChallengeResponses() {
        return this.challengeResponses;
    }

    public void setChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
    }

    public AdminRespondToAuthChallengeRequest withChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
        return this;
    }

    public AdminRespondToAuthChallengeRequest addChallengeResponsesEntry(String str, String str2) {
        if (this.challengeResponses == null) {
            this.challengeResponses = new HashMap();
        }
        if (this.challengeResponses.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.challengeResponses.put(str, str2);
        return this;
    }

    public AdminRespondToAuthChallengeRequest clearChallengeResponsesEntries() {
        this.challengeResponses = null;
        return this;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public AdminRespondToAuthChallengeRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public AdminRespondToAuthChallengeRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public ContextDataType getContextData() {
        return this.contextData;
    }

    public void setContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
    }

    public AdminRespondToAuthChallengeRequest withContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public AdminRespondToAuthChallengeRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminRespondToAuthChallengeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public AdminRespondToAuthChallengeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
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
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getChallengeResponses() != null) {
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getContextData() != null) {
            sb.append("ContextData: " + getContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getChallengeName() == null ? 0 : getChallengeName().hashCode())) * 31) + (getChallengeResponses() == null ? 0 : getChallengeResponses().hashCode())) * 31) + (getSession() == null ? 0 : getSession().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getContextData() == null ? 0 : getContextData().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminRespondToAuthChallengeRequest)) {
            return false;
        }
        AdminRespondToAuthChallengeRequest adminRespondToAuthChallengeRequest = (AdminRespondToAuthChallengeRequest) obj;
        if ((adminRespondToAuthChallengeRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getUserPoolId() != null && !adminRespondToAuthChallengeRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getClientId() != null && !adminRespondToAuthChallengeRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getChallengeName() == null) ^ (getChallengeName() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeName() != null && !adminRespondToAuthChallengeRequest.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getChallengeResponses() == null) ^ (getChallengeResponses() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeResponses() != null && !adminRespondToAuthChallengeRequest.getChallengeResponses().equals(getChallengeResponses())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getSession() != null && !adminRespondToAuthChallengeRequest.getSession().equals(getSession())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getAnalyticsMetadata() != null && !adminRespondToAuthChallengeRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getContextData() == null) ^ (getContextData() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getContextData() != null && !adminRespondToAuthChallengeRequest.getContextData().equals(getContextData())) {
            return false;
        }
        if ((adminRespondToAuthChallengeRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return adminRespondToAuthChallengeRequest.getClientMetadata() == null || adminRespondToAuthChallengeRequest.getClientMetadata().equals(getClientMetadata());
    }
}
