package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateUserPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List autoVerifiedAttributes;
    private DeviceConfigurationType deviceConfiguration;
    private EmailConfigurationType emailConfiguration;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private LambdaConfigType lambdaConfig;
    private String mfaConfiguration;
    private UserPoolPolicyType policies;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsVerificationMessage;
    private UserPoolAddOnsType userPoolAddOns;
    private String userPoolId;
    private Map userPoolTags;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public UpdateUserPoolRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UserPoolPolicyType getPolicies() {
        return this.policies;
    }

    public void setPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
    }

    public UpdateUserPoolRequest withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public UpdateUserPoolRequest withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public List<String> getAutoVerifiedAttributes() {
        return this.autoVerifiedAttributes;
    }

    public void setAutoVerifiedAttributes(Collection<String> collection) {
        if (collection == null) {
            this.autoVerifiedAttributes = null;
        } else {
            this.autoVerifiedAttributes = new ArrayList(collection);
        }
    }

    public UpdateUserPoolRequest withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public UpdateUserPoolRequest withAutoVerifiedAttributes(Collection<String> collection) {
        setAutoVerifiedAttributes(collection);
        return this;
    }

    public String getSmsVerificationMessage() {
        return this.smsVerificationMessage;
    }

    public void setSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
    }

    public UpdateUserPoolRequest withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationMessage() {
        return this.emailVerificationMessage;
    }

    public void setEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
    }

    public UpdateUserPoolRequest withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationSubject() {
        return this.emailVerificationSubject;
    }

    public void setEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
    }

    public UpdateUserPoolRequest withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public VerificationMessageTemplateType getVerificationMessageTemplate() {
        return this.verificationMessageTemplate;
    }

    public void setVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
    }

    public UpdateUserPoolRequest withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public UpdateUserPoolRequest withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public UpdateUserPoolRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public UpdateUserPoolRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public DeviceConfigurationType getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public void setDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
    }

    public UpdateUserPoolRequest withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public EmailConfigurationType getEmailConfiguration() {
        return this.emailConfiguration;
    }

    public void setEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
    }

    public UpdateUserPoolRequest withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public UpdateUserPoolRequest withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public Map<String, String> getUserPoolTags() {
        return this.userPoolTags;
    }

    public void setUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
    }

    public UpdateUserPoolRequest withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public UpdateUserPoolRequest addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (this.userPoolTags.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.userPoolTags.put(str, str2);
        return this;
    }

    public UpdateUserPoolRequest clearUserPoolTagsEntries() {
        this.userPoolTags = null;
        return this;
    }

    public AdminCreateUserConfigType getAdminCreateUserConfig() {
        return this.adminCreateUserConfig;
    }

    public void setAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
    }

    public UpdateUserPoolRequest withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public UserPoolAddOnsType getUserPoolAddOns() {
        return this.userPoolAddOns;
    }

    public void setUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
    }

    public UpdateUserPoolRequest withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public AccountRecoverySettingType getAccountRecoverySetting() {
        return this.accountRecoverySetting;
    }

    public void setAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
    }

    public UpdateUserPoolRequest withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getPolicies() != null) {
            sb.append("Policies: " + getPolicies() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getAutoVerifiedAttributes() != null) {
            sb.append("AutoVerifiedAttributes: " + getAutoVerifiedAttributes() + ",");
        }
        if (getSmsVerificationMessage() != null) {
            sb.append("SmsVerificationMessage: " + getSmsVerificationMessage() + ",");
        }
        if (getEmailVerificationMessage() != null) {
            sb.append("EmailVerificationMessage: " + getEmailVerificationMessage() + ",");
        }
        if (getEmailVerificationSubject() != null) {
            sb.append("EmailVerificationSubject: " + getEmailVerificationSubject() + ",");
        }
        if (getVerificationMessageTemplate() != null) {
            sb.append("VerificationMessageTemplate: " + getVerificationMessageTemplate() + ",");
        }
        if (getSmsAuthenticationMessage() != null) {
            sb.append("SmsAuthenticationMessage: " + getSmsAuthenticationMessage() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration() + ",");
        }
        if (getDeviceConfiguration() != null) {
            sb.append("DeviceConfiguration: " + getDeviceConfiguration() + ",");
        }
        if (getEmailConfiguration() != null) {
            sb.append("EmailConfiguration: " + getEmailConfiguration() + ",");
        }
        if (getSmsConfiguration() != null) {
            sb.append("SmsConfiguration: " + getSmsConfiguration() + ",");
        }
        if (getUserPoolTags() != null) {
            sb.append("UserPoolTags: " + getUserPoolTags() + ",");
        }
        if (getAdminCreateUserConfig() != null) {
            sb.append("AdminCreateUserConfig: " + getAdminCreateUserConfig() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getPolicies() == null ? 0 : getPolicies().hashCode())) * 31) + (getLambdaConfig() == null ? 0 : getLambdaConfig().hashCode())) * 31) + (getAutoVerifiedAttributes() == null ? 0 : getAutoVerifiedAttributes().hashCode())) * 31) + (getSmsVerificationMessage() == null ? 0 : getSmsVerificationMessage().hashCode())) * 31) + (getEmailVerificationMessage() == null ? 0 : getEmailVerificationMessage().hashCode())) * 31) + (getEmailVerificationSubject() == null ? 0 : getEmailVerificationSubject().hashCode())) * 31) + (getVerificationMessageTemplate() == null ? 0 : getVerificationMessageTemplate().hashCode())) * 31) + (getSmsAuthenticationMessage() == null ? 0 : getSmsAuthenticationMessage().hashCode())) * 31) + (getMfaConfiguration() == null ? 0 : getMfaConfiguration().hashCode())) * 31) + (getDeviceConfiguration() == null ? 0 : getDeviceConfiguration().hashCode())) * 31) + (getEmailConfiguration() == null ? 0 : getEmailConfiguration().hashCode())) * 31) + (getSmsConfiguration() == null ? 0 : getSmsConfiguration().hashCode())) * 31) + (getUserPoolTags() == null ? 0 : getUserPoolTags().hashCode())) * 31) + (getAdminCreateUserConfig() == null ? 0 : getAdminCreateUserConfig().hashCode())) * 31) + (getUserPoolAddOns() == null ? 0 : getUserPoolAddOns().hashCode())) * 31) + (getAccountRecoverySetting() != null ? getAccountRecoverySetting().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolRequest)) {
            return false;
        }
        UpdateUserPoolRequest updateUserPoolRequest = (UpdateUserPoolRequest) obj;
        if ((updateUserPoolRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolId() != null && !updateUserPoolRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateUserPoolRequest.getPolicies() == null) ^ (getPolicies() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getPolicies() != null && !updateUserPoolRequest.getPolicies().equals(getPolicies())) {
            return false;
        }
        if ((updateUserPoolRequest.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getLambdaConfig() != null && !updateUserPoolRequest.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((updateUserPoolRequest.getAutoVerifiedAttributes() == null) ^ (getAutoVerifiedAttributes() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getAutoVerifiedAttributes() != null && !updateUserPoolRequest.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if ((updateUserPoolRequest.getSmsVerificationMessage() == null) ^ (getSmsVerificationMessage() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getSmsVerificationMessage() != null && !updateUserPoolRequest.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if ((updateUserPoolRequest.getEmailVerificationMessage() == null) ^ (getEmailVerificationMessage() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationMessage() != null && !updateUserPoolRequest.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if ((updateUserPoolRequest.getEmailVerificationSubject() == null) ^ (getEmailVerificationSubject() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationSubject() != null && !updateUserPoolRequest.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if ((updateUserPoolRequest.getVerificationMessageTemplate() == null) ^ (getVerificationMessageTemplate() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getVerificationMessageTemplate() != null && !updateUserPoolRequest.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if ((updateUserPoolRequest.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getSmsAuthenticationMessage() != null && !updateUserPoolRequest.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((updateUserPoolRequest.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getMfaConfiguration() != null && !updateUserPoolRequest.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if ((updateUserPoolRequest.getDeviceConfiguration() == null) ^ (getDeviceConfiguration() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getDeviceConfiguration() != null && !updateUserPoolRequest.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if ((updateUserPoolRequest.getEmailConfiguration() == null) ^ (getEmailConfiguration() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getEmailConfiguration() != null && !updateUserPoolRequest.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if ((updateUserPoolRequest.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getSmsConfiguration() != null && !updateUserPoolRequest.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if ((updateUserPoolRequest.getUserPoolTags() == null) ^ (getUserPoolTags() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolTags() != null && !updateUserPoolRequest.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if ((updateUserPoolRequest.getAdminCreateUserConfig() == null) ^ (getAdminCreateUserConfig() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getAdminCreateUserConfig() != null && !updateUserPoolRequest.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if ((updateUserPoolRequest.getUserPoolAddOns() == null) ^ (getUserPoolAddOns() == null)) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolAddOns() != null && !updateUserPoolRequest.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if ((updateUserPoolRequest.getAccountRecoverySetting() == null) ^ (getAccountRecoverySetting() == null)) {
            return false;
        }
        return updateUserPoolRequest.getAccountRecoverySetting() == null || updateUserPoolRequest.getAccountRecoverySetting().equals(getAccountRecoverySetting());
    }
}
