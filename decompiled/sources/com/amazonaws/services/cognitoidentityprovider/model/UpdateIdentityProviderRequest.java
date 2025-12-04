package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateIdentityProviderRequest extends AmazonWebServiceRequest implements Serializable {
    private Map attributeMapping;
    private List idpIdentifiers;
    private Map providerDetails;
    private String providerName;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public UpdateIdentityProviderRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public UpdateIdentityProviderRequest withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public Map<String, String> getProviderDetails() {
        return this.providerDetails;
    }

    public void setProviderDetails(Map<String, String> map) {
        this.providerDetails = map;
    }

    public UpdateIdentityProviderRequest withProviderDetails(Map<String, String> map) {
        this.providerDetails = map;
        return this;
    }

    public UpdateIdentityProviderRequest addProviderDetailsEntry(String str, String str2) {
        if (this.providerDetails == null) {
            this.providerDetails = new HashMap();
        }
        if (this.providerDetails.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.providerDetails.put(str, str2);
        return this;
    }

    public UpdateIdentityProviderRequest clearProviderDetailsEntries() {
        this.providerDetails = null;
        return this;
    }

    public Map<String, String> getAttributeMapping() {
        return this.attributeMapping;
    }

    public void setAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
    }

    public UpdateIdentityProviderRequest withAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
        return this;
    }

    public UpdateIdentityProviderRequest addAttributeMappingEntry(String str, String str2) {
        if (this.attributeMapping == null) {
            this.attributeMapping = new HashMap();
        }
        if (this.attributeMapping.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.attributeMapping.put(str, str2);
        return this;
    }

    public UpdateIdentityProviderRequest clearAttributeMappingEntries() {
        this.attributeMapping = null;
        return this;
    }

    public List<String> getIdpIdentifiers() {
        return this.idpIdentifiers;
    }

    public void setIdpIdentifiers(Collection<String> collection) {
        if (collection == null) {
            this.idpIdentifiers = null;
        } else {
            this.idpIdentifiers = new ArrayList(collection);
        }
    }

    public UpdateIdentityProviderRequest withIdpIdentifiers(String... strArr) {
        if (getIdpIdentifiers() == null) {
            this.idpIdentifiers = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.idpIdentifiers.add(str);
        }
        return this;
    }

    public UpdateIdentityProviderRequest withIdpIdentifiers(Collection<String> collection) {
        setIdpIdentifiers(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderDetails() != null) {
            sb.append("ProviderDetails: " + getProviderDetails() + ",");
        }
        if (getAttributeMapping() != null) {
            sb.append("AttributeMapping: " + getAttributeMapping() + ",");
        }
        if (getIdpIdentifiers() != null) {
            sb.append("IdpIdentifiers: " + getIdpIdentifiers());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getProviderName() == null ? 0 : getProviderName().hashCode())) * 31) + (getProviderDetails() == null ? 0 : getProviderDetails().hashCode())) * 31) + (getAttributeMapping() == null ? 0 : getAttributeMapping().hashCode())) * 31) + (getIdpIdentifiers() != null ? getIdpIdentifiers().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateIdentityProviderRequest)) {
            return false;
        }
        UpdateIdentityProviderRequest updateIdentityProviderRequest = (UpdateIdentityProviderRequest) obj;
        if ((updateIdentityProviderRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateIdentityProviderRequest.getUserPoolId() != null && !updateIdentityProviderRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateIdentityProviderRequest.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        if (updateIdentityProviderRequest.getProviderName() != null && !updateIdentityProviderRequest.getProviderName().equals(getProviderName())) {
            return false;
        }
        if ((updateIdentityProviderRequest.getProviderDetails() == null) ^ (getProviderDetails() == null)) {
            return false;
        }
        if (updateIdentityProviderRequest.getProviderDetails() != null && !updateIdentityProviderRequest.getProviderDetails().equals(getProviderDetails())) {
            return false;
        }
        if ((updateIdentityProviderRequest.getAttributeMapping() == null) ^ (getAttributeMapping() == null)) {
            return false;
        }
        if (updateIdentityProviderRequest.getAttributeMapping() != null && !updateIdentityProviderRequest.getAttributeMapping().equals(getAttributeMapping())) {
            return false;
        }
        if ((updateIdentityProviderRequest.getIdpIdentifiers() == null) ^ (getIdpIdentifiers() == null)) {
            return false;
        }
        return updateIdentityProviderRequest.getIdpIdentifiers() == null || updateIdentityProviderRequest.getIdpIdentifiers().equals(getIdpIdentifiers());
    }
}
