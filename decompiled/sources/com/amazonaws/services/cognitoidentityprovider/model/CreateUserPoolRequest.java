package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CreateUserPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List aliasAttributes;
    private List autoVerifiedAttributes;
    private DeviceConfigurationType deviceConfiguration;
    private EmailConfigurationType emailConfiguration;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private LambdaConfigType lambdaConfig;
    private String mfaConfiguration;
    private UserPoolPolicyType policies;
    private String poolName;
    private List schema;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsVerificationMessage;
    private UserPoolAddOnsType userPoolAddOns;
    private Map userPoolTags;
    private List usernameAttributes;
    private UsernameConfigurationType usernameConfiguration;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public String getPoolName() {
        return this.poolName;
    }

    public void setPoolName(String str) {
        this.poolName = str;
    }

    public CreateUserPoolRequest withPoolName(String str) {
        this.poolName = str;
        return this;
    }

    public UserPoolPolicyType getPolicies() {
        return this.policies;
    }

    public void setPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
    }

    public CreateUserPoolRequest withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public CreateUserPoolRequest withLambdaConfig(LambdaConfigType lambdaConfigType) {
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

    public CreateUserPoolRequest withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withAutoVerifiedAttributes(Collection<String> collection) {
        setAutoVerifiedAttributes(collection);
        return this;
    }

    public List<String> getAliasAttributes() {
        return this.aliasAttributes;
    }

    public void setAliasAttributes(Collection<String> collection) {
        if (collection == null) {
            this.aliasAttributes = null;
        } else {
            this.aliasAttributes = new ArrayList(collection);
        }
    }

    public CreateUserPoolRequest withAliasAttributes(String... strArr) {
        if (getAliasAttributes() == null) {
            this.aliasAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.aliasAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withAliasAttributes(Collection<String> collection) {
        setAliasAttributes(collection);
        return this;
    }

    public List<String> getUsernameAttributes() {
        return this.usernameAttributes;
    }

    public void setUsernameAttributes(Collection<String> collection) {
        if (collection == null) {
            this.usernameAttributes = null;
        } else {
            this.usernameAttributes = new ArrayList(collection);
        }
    }

    public CreateUserPoolRequest withUsernameAttributes(String... strArr) {
        if (getUsernameAttributes() == null) {
            this.usernameAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.usernameAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withUsernameAttributes(Collection<String> collection) {
        setUsernameAttributes(collection);
        return this;
    }

    public String getSmsVerificationMessage() {
        return this.smsVerificationMessage;
    }

    public void setSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
    }

    public CreateUserPoolRequest withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationMessage() {
        return this.emailVerificationMessage;
    }

    public void setEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
    }

    public CreateUserPoolRequest withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationSubject() {
        return this.emailVerificationSubject;
    }

    public void setEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
    }

    public CreateUserPoolRequest withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public VerificationMessageTemplateType getVerificationMessageTemplate() {
        return this.verificationMessageTemplate;
    }

    public void setVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
    }

    public CreateUserPoolRequest withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public CreateUserPoolRequest withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public CreateUserPoolRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public CreateUserPoolRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public DeviceConfigurationType getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public void setDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
    }

    public CreateUserPoolRequest withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public EmailConfigurationType getEmailConfiguration() {
        return this.emailConfiguration;
    }

    public void setEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
    }

    public CreateUserPoolRequest withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public CreateUserPoolRequest withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public Map<String, String> getUserPoolTags() {
        return this.userPoolTags;
    }

    public void setUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
    }

    public CreateUserPoolRequest withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public CreateUserPoolRequest addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (this.userPoolTags.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.userPoolTags.put(str, str2);
        return this;
    }

    public CreateUserPoolRequest clearUserPoolTagsEntries() {
        this.userPoolTags = null;
        return this;
    }

    public AdminCreateUserConfigType getAdminCreateUserConfig() {
        return this.adminCreateUserConfig;
    }

    public void setAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
    }

    public CreateUserPoolRequest withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public List<SchemaAttributeType> getSchema() {
        return this.schema;
    }

    public void setSchema(Collection<SchemaAttributeType> collection) {
        if (collection == null) {
            this.schema = null;
        } else {
            this.schema = new ArrayList(collection);
        }
    }

    public CreateUserPoolRequest withSchema(SchemaAttributeType... schemaAttributeTypeArr) {
        if (getSchema() == null) {
            this.schema = new ArrayList(schemaAttributeTypeArr.length);
        }
        for (SchemaAttributeType schemaAttributeType : schemaAttributeTypeArr) {
            this.schema.add(schemaAttributeType);
        }
        return this;
    }

    public CreateUserPoolRequest withSchema(Collection<SchemaAttributeType> collection) {
        setSchema(collection);
        return this;
    }

    public UserPoolAddOnsType getUserPoolAddOns() {
        return this.userPoolAddOns;
    }

    public void setUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
    }

    public CreateUserPoolRequest withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public UsernameConfigurationType getUsernameConfiguration() {
        return this.usernameConfiguration;
    }

    public void setUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
    }

    public CreateUserPoolRequest withUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
        return this;
    }

    public AccountRecoverySettingType getAccountRecoverySetting() {
        return this.accountRecoverySetting;
    }

    public void setAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
    }

    public CreateUserPoolRequest withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPoolName() != null) {
            sb.append("PoolName: " + getPoolName() + ",");
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
        if (getAliasAttributes() != null) {
            sb.append("AliasAttributes: " + getAliasAttributes() + ",");
        }
        if (getUsernameAttributes() != null) {
            sb.append("UsernameAttributes: " + getUsernameAttributes() + ",");
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
        if (getSchema() != null) {
            sb.append("Schema: " + getSchema() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getUsernameConfiguration() != null) {
            sb.append("UsernameConfiguration: " + getUsernameConfiguration() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((getPoolName() == null ? 0 : getPoolName().hashCode()) + 31) * 31) + (getPolicies() == null ? 0 : getPolicies().hashCode())) * 31) + (getLambdaConfig() == null ? 0 : getLambdaConfig().hashCode())) * 31) + (getAutoVerifiedAttributes() == null ? 0 : getAutoVerifiedAttributes().hashCode())) * 31) + (getAliasAttributes() == null ? 0 : getAliasAttributes().hashCode())) * 31) + (getUsernameAttributes() == null ? 0 : getUsernameAttributes().hashCode())) * 31) + (getSmsVerificationMessage() == null ? 0 : getSmsVerificationMessage().hashCode())) * 31) + (getEmailVerificationMessage() == null ? 0 : getEmailVerificationMessage().hashCode())) * 31) + (getEmailVerificationSubject() == null ? 0 : getEmailVerificationSubject().hashCode())) * 31) + (getVerificationMessageTemplate() == null ? 0 : getVerificationMessageTemplate().hashCode())) * 31) + (getSmsAuthenticationMessage() == null ? 0 : getSmsAuthenticationMessage().hashCode())) * 31) + (getMfaConfiguration() == null ? 0 : getMfaConfiguration().hashCode())) * 31) + (getDeviceConfiguration() == null ? 0 : getDeviceConfiguration().hashCode())) * 31) + (getEmailConfiguration() == null ? 0 : getEmailConfiguration().hashCode())) * 31) + (getSmsConfiguration() == null ? 0 : getSmsConfiguration().hashCode())) * 31) + (getUserPoolTags() == null ? 0 : getUserPoolTags().hashCode())) * 31) + (getAdminCreateUserConfig() == null ? 0 : getAdminCreateUserConfig().hashCode())) * 31) + (getSchema() == null ? 0 : getSchema().hashCode())) * 31) + (getUserPoolAddOns() == null ? 0 : getUserPoolAddOns().hashCode())) * 31) + (getUsernameConfiguration() == null ? 0 : getUsernameConfiguration().hashCode())) * 31) + (getAccountRecoverySetting() != null ? getAccountRecoverySetting().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolRequest)) {
            return false;
        }
        CreateUserPoolRequest createUserPoolRequest = (CreateUserPoolRequest) obj;
        if ((createUserPoolRequest.getPoolName() == null) ^ (getPoolName() == null)) {
            return false;
        }
        if (createUserPoolRequest.getPoolName() != null && !createUserPoolRequest.getPoolName().equals(getPoolName())) {
            return false;
        }
        if ((createUserPoolRequest.getPolicies() == null) ^ (getPolicies() == null)) {
            return false;
        }
        if (createUserPoolRequest.getPolicies() != null && !createUserPoolRequest.getPolicies().equals(getPolicies())) {
            return false;
        }
        if ((createUserPoolRequest.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (createUserPoolRequest.getLambdaConfig() != null && !createUserPoolRequest.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((createUserPoolRequest.getAutoVerifiedAttributes() == null) ^ (getAutoVerifiedAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAutoVerifiedAttributes() != null && !createUserPoolRequest.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getAliasAttributes() == null) ^ (getAliasAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAliasAttributes() != null && !createUserPoolRequest.getAliasAttributes().equals(getAliasAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getUsernameAttributes() == null) ^ (getUsernameAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUsernameAttributes() != null && !createUserPoolRequest.getUsernameAttributes().equals(getUsernameAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsVerificationMessage() == null) ^ (getSmsVerificationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsVerificationMessage() != null && !createUserPoolRequest.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailVerificationMessage() == null) ^ (getEmailVerificationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailVerificationMessage() != null && !createUserPoolRequest.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailVerificationSubject() == null) ^ (getEmailVerificationSubject() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailVerificationSubject() != null && !createUserPoolRequest.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if ((createUserPoolRequest.getVerificationMessageTemplate() == null) ^ (getVerificationMessageTemplate() == null)) {
            return false;
        }
        if (createUserPoolRequest.getVerificationMessageTemplate() != null && !createUserPoolRequest.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsAuthenticationMessage() != null && !createUserPoolRequest.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getMfaConfiguration() != null && !createUserPoolRequest.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getDeviceConfiguration() == null) ^ (getDeviceConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getDeviceConfiguration() != null && !createUserPoolRequest.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailConfiguration() == null) ^ (getEmailConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailConfiguration() != null && !createUserPoolRequest.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsConfiguration() != null && !createUserPoolRequest.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getUserPoolTags() == null) ^ (getUserPoolTags() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUserPoolTags() != null && !createUserPoolRequest.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if ((createUserPoolRequest.getAdminCreateUserConfig() == null) ^ (getAdminCreateUserConfig() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAdminCreateUserConfig() != null && !createUserPoolRequest.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if ((createUserPoolRequest.getSchema() == null) ^ (getSchema() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSchema() != null && !createUserPoolRequest.getSchema().equals(getSchema())) {
            return false;
        }
        if ((createUserPoolRequest.getUserPoolAddOns() == null) ^ (getUserPoolAddOns() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUserPoolAddOns() != null && !createUserPoolRequest.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if ((createUserPoolRequest.getUsernameConfiguration() == null) ^ (getUsernameConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUsernameConfiguration() != null && !createUserPoolRequest.getUsernameConfiguration().equals(getUsernameConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getAccountRecoverySetting() == null) ^ (getAccountRecoverySetting() == null)) {
            return false;
        }
        return createUserPoolRequest.getAccountRecoverySetting() == null || createUserPoolRequest.getAccountRecoverySetting().equals(getAccountRecoverySetting());
    }
}
