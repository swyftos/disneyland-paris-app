package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SetIdentityPoolRolesRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;
    private Map roleMappings;
    private Map roles;

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public SetIdentityPoolRolesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public Map<String, String> getRoles() {
        return this.roles;
    }

    public void setRoles(Map<String, String> map) {
        this.roles = map;
    }

    public SetIdentityPoolRolesRequest withRoles(Map<String, String> map) {
        this.roles = map;
        return this;
    }

    public SetIdentityPoolRolesRequest addRolesEntry(String str, String str2) {
        if (this.roles == null) {
            this.roles = new HashMap();
        }
        if (this.roles.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.roles.put(str, str2);
        return this;
    }

    public SetIdentityPoolRolesRequest clearRolesEntries() {
        this.roles = null;
        return this;
    }

    public Map<String, RoleMapping> getRoleMappings() {
        return this.roleMappings;
    }

    public void setRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
    }

    public SetIdentityPoolRolesRequest withRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
        return this;
    }

    public SetIdentityPoolRolesRequest addRoleMappingsEntry(String str, RoleMapping roleMapping) {
        if (this.roleMappings == null) {
            this.roleMappings = new HashMap();
        }
        if (this.roleMappings.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.roleMappings.put(str, roleMapping);
        return this;
    }

    public SetIdentityPoolRolesRequest clearRoleMappingsEntries() {
        this.roleMappings = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getRoles() != null) {
            sb.append("Roles: " + getRoles() + ",");
        }
        if (getRoleMappings() != null) {
            sb.append("RoleMappings: " + getRoleMappings());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getRoles() == null ? 0 : getRoles().hashCode())) * 31) + (getRoleMappings() != null ? getRoleMappings().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetIdentityPoolRolesRequest)) {
            return false;
        }
        SetIdentityPoolRolesRequest setIdentityPoolRolesRequest = (SetIdentityPoolRolesRequest) obj;
        if ((setIdentityPoolRolesRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getIdentityPoolId() != null && !setIdentityPoolRolesRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((setIdentityPoolRolesRequest.getRoles() == null) ^ (getRoles() == null)) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoles() != null && !setIdentityPoolRolesRequest.getRoles().equals(getRoles())) {
            return false;
        }
        if ((setIdentityPoolRolesRequest.getRoleMappings() == null) ^ (getRoleMappings() == null)) {
            return false;
        }
        return setIdentityPoolRolesRequest.getRoleMappings() == null || setIdentityPoolRolesRequest.getRoleMappings().equals(getRoleMappings());
    }
}
