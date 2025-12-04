package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class AdminGetUserResult implements Serializable {
    private Boolean enabled;
    private List mFAOptions;
    private String preferredMfaSetting;
    private List userAttributes;
    private Date userCreateDate;
    private Date userLastModifiedDate;
    private List userMFASettingList;
    private String userStatus;
    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminGetUserResult withUsername(String str) {
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

    public AdminGetUserResult withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public AdminGetUserResult withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public Date getUserCreateDate() {
        return this.userCreateDate;
    }

    public void setUserCreateDate(Date date) {
        this.userCreateDate = date;
    }

    public AdminGetUserResult withUserCreateDate(Date date) {
        this.userCreateDate = date;
        return this;
    }

    public Date getUserLastModifiedDate() {
        return this.userLastModifiedDate;
    }

    public void setUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
    }

    public AdminGetUserResult withUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
        return this;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public AdminGetUserResult withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(String str) {
        this.userStatus = str;
    }

    public AdminGetUserResult withUserStatus(String str) {
        this.userStatus = str;
        return this;
    }

    public void setUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
    }

    public AdminGetUserResult withUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
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

    public AdminGetUserResult withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public AdminGetUserResult withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }

    public String getPreferredMfaSetting() {
        return this.preferredMfaSetting;
    }

    public void setPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
    }

    public AdminGetUserResult withPreferredMfaSetting(String str) {
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

    public AdminGetUserResult withUserMFASettingList(String... strArr) {
        if (getUserMFASettingList() == null) {
            this.userMFASettingList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userMFASettingList.add(str);
        }
        return this;
    }

    public AdminGetUserResult withUserMFASettingList(Collection<String> collection) {
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
        if (getUserCreateDate() != null) {
            sb.append("UserCreateDate: " + getUserCreateDate() + ",");
        }
        if (getUserLastModifiedDate() != null) {
            sb.append("UserLastModifiedDate: " + getUserLastModifiedDate() + ",");
        }
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getUserStatus() != null) {
            sb.append("UserStatus: " + getUserStatus() + ",");
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
        return (((((((((((((((((getUsername() == null ? 0 : getUsername().hashCode()) + 31) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getUserCreateDate() == null ? 0 : getUserCreateDate().hashCode())) * 31) + (getUserLastModifiedDate() == null ? 0 : getUserLastModifiedDate().hashCode())) * 31) + (getEnabled() == null ? 0 : getEnabled().hashCode())) * 31) + (getUserStatus() == null ? 0 : getUserStatus().hashCode())) * 31) + (getMFAOptions() == null ? 0 : getMFAOptions().hashCode())) * 31) + (getPreferredMfaSetting() == null ? 0 : getPreferredMfaSetting().hashCode())) * 31) + (getUserMFASettingList() != null ? getUserMFASettingList().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetUserResult)) {
            return false;
        }
        AdminGetUserResult adminGetUserResult = (AdminGetUserResult) obj;
        if ((adminGetUserResult.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminGetUserResult.getUsername() != null && !adminGetUserResult.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminGetUserResult.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserAttributes() != null && !adminGetUserResult.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((adminGetUserResult.getUserCreateDate() == null) ^ (getUserCreateDate() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserCreateDate() != null && !adminGetUserResult.getUserCreateDate().equals(getUserCreateDate())) {
            return false;
        }
        if ((adminGetUserResult.getUserLastModifiedDate() == null) ^ (getUserLastModifiedDate() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserLastModifiedDate() != null && !adminGetUserResult.getUserLastModifiedDate().equals(getUserLastModifiedDate())) {
            return false;
        }
        if ((adminGetUserResult.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (adminGetUserResult.getEnabled() != null && !adminGetUserResult.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((adminGetUserResult.getUserStatus() == null) ^ (getUserStatus() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserStatus() != null && !adminGetUserResult.getUserStatus().equals(getUserStatus())) {
            return false;
        }
        if ((adminGetUserResult.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        if (adminGetUserResult.getMFAOptions() != null && !adminGetUserResult.getMFAOptions().equals(getMFAOptions())) {
            return false;
        }
        if ((adminGetUserResult.getPreferredMfaSetting() == null) ^ (getPreferredMfaSetting() == null)) {
            return false;
        }
        if (adminGetUserResult.getPreferredMfaSetting() != null && !adminGetUserResult.getPreferredMfaSetting().equals(getPreferredMfaSetting())) {
            return false;
        }
        if ((adminGetUserResult.getUserMFASettingList() == null) ^ (getUserMFASettingList() == null)) {
            return false;
        }
        return adminGetUserResult.getUserMFASettingList() == null || adminGetUserResult.getUserMFASettingList().equals(getUserMFASettingList());
    }
}
