package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminCreateUserRequest extends AmazonWebServiceRequest implements Serializable {
    private Map clientMetadata;
    private List desiredDeliveryMediums;
    private Boolean forceAliasCreation;
    private String messageAction;
    private String temporaryPassword;
    private List userAttributes;
    private String userPoolId;
    private String username;
    private List validationData;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminCreateUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminCreateUserRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public List<AttributeType> getUserAttributes() {
        return this.userAttributes;
    }

    public void setUserAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public AdminCreateUserRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public AdminCreateUserRequest withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public List<AttributeType> getValidationData() {
        return this.validationData;
    }

    public void setValidationData(Collection<AttributeType> collection) {
        if (collection == null) {
            this.validationData = null;
        } else {
            this.validationData = new ArrayList(collection);
        }
    }

    public AdminCreateUserRequest withValidationData(AttributeType... attributeTypeArr) {
        if (getValidationData() == null) {
            this.validationData = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.validationData.add(attributeType);
        }
        return this;
    }

    public AdminCreateUserRequest withValidationData(Collection<AttributeType> collection) {
        setValidationData(collection);
        return this;
    }

    public String getTemporaryPassword() {
        return this.temporaryPassword;
    }

    public void setTemporaryPassword(String str) {
        this.temporaryPassword = str;
    }

    public AdminCreateUserRequest withTemporaryPassword(String str) {
        this.temporaryPassword = str;
        return this;
    }

    public Boolean isForceAliasCreation() {
        return this.forceAliasCreation;
    }

    public Boolean getForceAliasCreation() {
        return this.forceAliasCreation;
    }

    public void setForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
    }

    public AdminCreateUserRequest withForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
        return this;
    }

    public String getMessageAction() {
        return this.messageAction;
    }

    public void setMessageAction(String str) {
        this.messageAction = str;
    }

    public AdminCreateUserRequest withMessageAction(String str) {
        this.messageAction = str;
        return this;
    }

    public void setMessageAction(MessageActionType messageActionType) {
        this.messageAction = messageActionType.toString();
    }

    public AdminCreateUserRequest withMessageAction(MessageActionType messageActionType) {
        this.messageAction = messageActionType.toString();
        return this;
    }

    public List<String> getDesiredDeliveryMediums() {
        return this.desiredDeliveryMediums;
    }

    public void setDesiredDeliveryMediums(Collection<String> collection) {
        if (collection == null) {
            this.desiredDeliveryMediums = null;
        } else {
            this.desiredDeliveryMediums = new ArrayList(collection);
        }
    }

    public AdminCreateUserRequest withDesiredDeliveryMediums(String... strArr) {
        if (getDesiredDeliveryMediums() == null) {
            this.desiredDeliveryMediums = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.desiredDeliveryMediums.add(str);
        }
        return this;
    }

    public AdminCreateUserRequest withDesiredDeliveryMediums(Collection<String> collection) {
        setDesiredDeliveryMediums(collection);
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public AdminCreateUserRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminCreateUserRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public AdminCreateUserRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
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
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getValidationData() != null) {
            sb.append("ValidationData: " + getValidationData() + ",");
        }
        if (getTemporaryPassword() != null) {
            sb.append("TemporaryPassword: " + getTemporaryPassword() + ",");
        }
        if (getForceAliasCreation() != null) {
            sb.append("ForceAliasCreation: " + getForceAliasCreation() + ",");
        }
        if (getMessageAction() != null) {
            sb.append("MessageAction: " + getMessageAction() + ",");
        }
        if (getDesiredDeliveryMediums() != null) {
            sb.append("DesiredDeliveryMediums: " + getDesiredDeliveryMediums() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getValidationData() == null ? 0 : getValidationData().hashCode())) * 31) + (getTemporaryPassword() == null ? 0 : getTemporaryPassword().hashCode())) * 31) + (getForceAliasCreation() == null ? 0 : getForceAliasCreation().hashCode())) * 31) + (getMessageAction() == null ? 0 : getMessageAction().hashCode())) * 31) + (getDesiredDeliveryMediums() == null ? 0 : getDesiredDeliveryMediums().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserRequest)) {
            return false;
        }
        AdminCreateUserRequest adminCreateUserRequest = (AdminCreateUserRequest) obj;
        if ((adminCreateUserRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getUserPoolId() != null && !adminCreateUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminCreateUserRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getUsername() != null && !adminCreateUserRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminCreateUserRequest.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getUserAttributes() != null && !adminCreateUserRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((adminCreateUserRequest.getValidationData() == null) ^ (getValidationData() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getValidationData() != null && !adminCreateUserRequest.getValidationData().equals(getValidationData())) {
            return false;
        }
        if ((adminCreateUserRequest.getTemporaryPassword() == null) ^ (getTemporaryPassword() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getTemporaryPassword() != null && !adminCreateUserRequest.getTemporaryPassword().equals(getTemporaryPassword())) {
            return false;
        }
        if ((adminCreateUserRequest.getForceAliasCreation() == null) ^ (getForceAliasCreation() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getForceAliasCreation() != null && !adminCreateUserRequest.getForceAliasCreation().equals(getForceAliasCreation())) {
            return false;
        }
        if ((adminCreateUserRequest.getMessageAction() == null) ^ (getMessageAction() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getMessageAction() != null && !adminCreateUserRequest.getMessageAction().equals(getMessageAction())) {
            return false;
        }
        if ((adminCreateUserRequest.getDesiredDeliveryMediums() == null) ^ (getDesiredDeliveryMediums() == null)) {
            return false;
        }
        if (adminCreateUserRequest.getDesiredDeliveryMediums() != null && !adminCreateUserRequest.getDesiredDeliveryMediums().equals(getDesiredDeliveryMediums())) {
            return false;
        }
        if ((adminCreateUserRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return adminCreateUserRequest.getClientMetadata() == null || adminCreateUserRequest.getClientMetadata().equals(getClientMetadata());
    }
}
