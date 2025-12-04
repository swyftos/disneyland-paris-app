package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class GetUserResult implements Serializable {
    private List mFAOptions;
    private String preferredMfaSetting;
    private List userAttributes;
    private List userMFASettingList;
    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public GetUserResult withUsername(String str) {
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

    public GetUserResult withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public GetUserResult withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public List<MFAOptionType> getMFAOptions() {
        return this.mFAOptions;
    }

    public void setMFAOptions(Collection<MFAOptionType> collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public GetUserResult withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public GetUserResult withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }

    public String getPreferredMfaSetting() {
        return this.preferredMfaSetting;
    }

    public void setPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
    }

    public GetUserResult withPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
        return this;
    }

    public List<String> getUserMFASettingList() {
        return this.userMFASettingList;
    }

    public void setUserMFASettingList(Collection<String> collection) {
        if (collection == null) {
            this.userMFASettingList = null;
        } else {
            this.userMFASettingList = new ArrayList(collection);
        }
    }

    public GetUserResult withUserMFASettingList(String... strArr) {
        if (getUserMFASettingList() == null) {
            this.userMFASettingList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userMFASettingList.add(str);
        }
        return this;
    }

    public GetUserResult withUserMFASettingList(Collection<String> collection) {
        setUserMFASettingList(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions() + ",");
        }
        if (getPreferredMfaSetting() != null) {
            sb.append("PreferredMfaSetting: " + getPreferredMfaSetting() + ",");
        }
        if (getUserMFASettingList() != null) {
            sb.append("UserMFASettingList: " + getUserMFASettingList());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getUsername() == null ? 0 : getUsername().hashCode()) + 31) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getMFAOptions() == null ? 0 : getMFAOptions().hashCode())) * 31) + (getPreferredMfaSetting() == null ? 0 : getPreferredMfaSetting().hashCode())) * 31) + (getUserMFASettingList() != null ? getUserMFASettingList().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserResult)) {
            return false;
        }
        GetUserResult getUserResult = (GetUserResult) obj;
        if ((getUserResult.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (getUserResult.getUsername() != null && !getUserResult.getUsername().equals(getUsername())) {
            return false;
        }
        if ((getUserResult.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (getUserResult.getUserAttributes() != null && !getUserResult.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((getUserResult.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        if (getUserResult.getMFAOptions() != null && !getUserResult.getMFAOptions().equals(getMFAOptions())) {
            return false;
        }
        if ((getUserResult.getPreferredMfaSetting() == null) ^ (getPreferredMfaSetting() == null)) {
            return false;
        }
        if (getUserResult.getPreferredMfaSetting() != null && !getUserResult.getPreferredMfaSetting().equals(getPreferredMfaSetting())) {
            return false;
        }
        if ((getUserResult.getUserMFASettingList() == null) ^ (getUserMFASettingList() == null)) {
            return false;
        }
        return getUserResult.getUserMFASettingList() == null || getUserResult.getUserMFASettingList().equals(getUserMFASettingList());
    }
}
