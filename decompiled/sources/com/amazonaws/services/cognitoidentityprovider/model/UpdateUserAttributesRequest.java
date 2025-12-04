package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private Map clientMetadata;
    private List userAttributes;

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

    public UpdateUserAttributesRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public UpdateUserAttributesRequest withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public UpdateUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public UpdateUserAttributesRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public UpdateUserAttributesRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public UpdateUserAttributesRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserAttributes() == null ? 0 : getUserAttributes().hashCode()) + 31) * 31) + (getAccessToken() == null ? 0 : getAccessToken().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserAttributesRequest)) {
            return false;
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = (UpdateUserAttributesRequest) obj;
        if ((updateUserAttributesRequest.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (updateUserAttributesRequest.getUserAttributes() != null && !updateUserAttributesRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((updateUserAttributesRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (updateUserAttributesRequest.getAccessToken() != null && !updateUserAttributesRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((updateUserAttributesRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return updateUserAttributesRequest.getClientMetadata() == null || updateUserAttributesRequest.getClientMetadata().equals(getClientMetadata());
    }
}
