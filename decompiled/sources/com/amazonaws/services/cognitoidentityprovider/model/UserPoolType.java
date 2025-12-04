package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UserPoolType implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List aliasAttributes;
    private String arn;
    private List autoVerifiedAttributes;
    private Date creationDate;
    private String customDomain;
    private DeviceConfigurationType deviceConfiguration;
    private String domain;
    private EmailConfigurationType emailConfiguration;
    private String emailConfigurationFailure;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private Integer estimatedNumberOfUsers;
    private String id;
    private LambdaConfigType lambdaConfig;
    private Date lastModifiedDate;
    private String mfaConfiguration;
    private String name;
    private UserPoolPolicyType policies;
    private List schemaAttributes;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsConfigurationFailure;
    private String smsVerificationMessage;
    private String status;
    private UserPoolAddOnsType userPoolAddOns;
    private Map userPoolTags;
    private List usernameAttributes;
    private UsernameConfigurationType usernameConfiguration;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public UserPoolType withId(String str) {
        this.id = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public UserPoolType withName(String str) {
        this.name = str;
        return this;
    }

    public UserPoolPolicyType getPolicies() {
        return this.policies;
    }

    public void setPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
    }

    public UserPoolType withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public UserPoolType withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public UserPoolType withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(StatusType statusType) {
        this.status = statusType.toString();
    }

    public UserPoolType withStatus(StatusType statusType) {
        this.status = statusType.toString();
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public UserPoolType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public UserPoolType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public List<SchemaAttributeType> getSchemaAttributes() {
        return this.schemaAttributes;
    }

    public void setSchemaAttributes(Collection<SchemaAttributeType> collection) {
        if (collection == null) {
            this.schemaAttributes = null;
        } else {
            this.schemaAttributes = new ArrayList(collection);
        }
    }

    public UserPoolType withSchemaAttributes(SchemaAttributeType... schemaAttributeTypeArr) {
        if (getSchemaAttributes() == null) {
            this.schemaAttributes = new ArrayList(schemaAttributeTypeArr.length);
        }
        for (SchemaAttributeType schemaAttributeType : schemaAttributeTypeArr) {
            this.schemaAttributes.add(schemaAttributeType);
        }
        return this;
    }

    public UserPoolType withSchemaAttributes(Collection<SchemaAttributeType> collection) {
        setSchemaAttributes(collection);
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

    public UserPoolType withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withAutoVerifiedAttributes(Collection<String> collection) {
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

    public UserPoolType withAliasAttributes(String... strArr) {
        if (getAliasAttributes() == null) {
            this.aliasAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.aliasAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withAliasAttributes(Collection<String> collection) {
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

    public UserPoolType withUsernameAttributes(String... strArr) {
        if (getUsernameAttributes() == null) {
            this.usernameAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.usernameAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withUsernameAttributes(Collection<String> collection) {
        setUsernameAttributes(collection);
        return this;
    }

    public String getSmsVerificationMessage() {
        return this.smsVerificationMessage;
    }

    public void setSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
    }

    public UserPoolType withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationMessage() {
        return this.emailVerificationMessage;
    }

    public void setEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
    }

    public UserPoolType withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public String getEmailVerificationSubject() {
        return this.emailVerificationSubject;
    }

    public void setEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
    }

    public UserPoolType withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public VerificationMessageTemplateType getVerificationMessageTemplate() {
        return this.verificationMessageTemplate;
    }

    public void setVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
    }

    public UserPoolType withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public UserPoolType withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public UserPoolType withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public UserPoolType withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public DeviceConfigurationType getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public void setDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
    }

    public UserPoolType withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public Integer getEstimatedNumberOfUsers() {
        return this.estimatedNumberOfUsers;
    }

    public void setEstimatedNumberOfUsers(Integer num) {
        this.estimatedNumberOfUsers = num;
    }

    public UserPoolType withEstimatedNumberOfUsers(Integer num) {
        this.estimatedNumberOfUsers = num;
        return this;
    }

    public EmailConfigurationType getEmailConfiguration() {
        return this.emailConfiguration;
    }

    public void setEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
    }

    public UserPoolType withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public UserPoolType withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public Map<String, String> getUserPoolTags() {
        return this.userPoolTags;
    }

    public void setUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
    }

    public UserPoolType withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public UserPoolType addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (this.userPoolTags.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.userPoolTags.put(str, str2);
        return this;
    }

    public UserPoolType clearUserPoolTagsEntries() {
        this.userPoolTags = null;
        return this;
    }

    public String getSmsConfigurationFailure() {
        return this.smsConfigurationFailure;
    }

    public void setSmsConfigurationFailure(String str) {
        this.smsConfigurationFailure = str;
    }

    public UserPoolType withSmsConfigurationFailure(String str) {
        this.smsConfigurationFailure = str;
        return this;
    }

    public String getEmailConfigurationFailure() {
        return this.emailConfigurationFailure;
    }

    public void setEmailConfigurationFailure(String str) {
        this.emailConfigurationFailure = str;
    }

    public UserPoolType withEmailConfigurationFailure(String str) {
        this.emailConfigurationFailure = str;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public UserPoolType withDomain(String str) {
        this.domain = str;
        return this;
    }

    public String getCustomDomain() {
        return this.customDomain;
    }

    public void setCustomDomain(String str) {
        this.customDomain = str;
    }

    public UserPoolType withCustomDomain(String str) {
        this.customDomain = str;
        return this;
    }

    public AdminCreateUserConfigType getAdminCreateUserConfig() {
        return this.adminCreateUserConfig;
    }

    public void setAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
    }

    public UserPoolType withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public UserPoolAddOnsType getUserPoolAddOns() {
        return this.userPoolAddOns;
    }

    public void setUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
    }

    public UserPoolType withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public UsernameConfigurationType getUsernameConfiguration() {
        return this.usernameConfiguration;
    }

    public void setUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
    }

    public UserPoolType withUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
        return this;
    }

    public String getArn() {
        return this.arn;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public UserPoolType withArn(String str) {
        this.arn = str;
        return this;
    }

    public AccountRecoverySettingType getAccountRecoverySetting() {
        return this.accountRecoverySetting;
    }

    public void setAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
    }

    public UserPoolType withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getId() != null) {
            sb.append("Id: " + getId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getPolicies() != null) {
            sb.append("Policies: " + getPolicies() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getSchemaAttributes() != null) {
            sb.append("SchemaAttributes: " + getSchemaAttributes() + ",");
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
        if (getEstimatedNumberOfUsers() != null) {
            sb.append("EstimatedNumberOfUsers: " + getEstimatedNumberOfUsers() + ",");
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
        if (getSmsConfigurationFailure() != null) {
            sb.append("SmsConfigurationFailure: " + getSmsConfigurationFailure() + ",");
        }
        if (getEmailConfigurationFailure() != null) {
            sb.append("EmailConfigurationFailure: " + getEmailConfigurationFailure() + ",");
        }
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getCustomDomain() != null) {
            sb.append("CustomDomain: " + getCustomDomain() + ",");
        }
        if (getAdminCreateUserConfig() != null) {
            sb.append("AdminCreateUserConfig: " + getAdminCreateUserConfig() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getUsernameConfiguration() != null) {
            sb.append("UsernameConfiguration: " + getUsernameConfiguration() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getPolicies() == null ? 0 : getPolicies().hashCode())) * 31) + (getLambdaConfig() == null ? 0 : getLambdaConfig().hashCode())) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getSchemaAttributes() == null ? 0 : getSchemaAttributes().hashCode())) * 31) + (getAutoVerifiedAttributes() == null ? 0 : getAutoVerifiedAttributes().hashCode())) * 31) + (getAliasAttributes() == null ? 0 : getAliasAttributes().hashCode())) * 31) + (getUsernameAttributes() == null ? 0 : getUsernameAttributes().hashCode())) * 31) + (getSmsVerificationMessage() == null ? 0 : getSmsVerificationMessage().hashCode())) * 31) + (getEmailVerificationMessage() == null ? 0 : getEmailVerificationMessage().hashCode())) * 31) + (getEmailVerificationSubject() == null ? 0 : getEmailVerificationSubject().hashCode())) * 31) + (getVerificationMessageTemplate() == null ? 0 : getVerificationMessageTemplate().hashCode())) * 31) + (getSmsAuthenticationMessage() == null ? 0 : getSmsAuthenticationMessage().hashCode())) * 31) + (getMfaConfiguration() == null ? 0 : getMfaConfiguration().hashCode())) * 31) + (getDeviceConfiguration() == null ? 0 : getDeviceConfiguration().hashCode())) * 31) + (getEstimatedNumberOfUsers() == null ? 0 : getEstimatedNumberOfUsers().hashCode())) * 31) + (getEmailConfiguration() == null ? 0 : getEmailConfiguration().hashCode())) * 31) + (getSmsConfiguration() == null ? 0 : getSmsConfiguration().hashCode())) * 31) + (getUserPoolTags() == null ? 0 : getUserPoolTags().hashCode())) * 31) + (getSmsConfigurationFailure() == null ? 0 : getSmsConfigurationFailure().hashCode())) * 31) + (getEmailConfigurationFailure() == null ? 0 : getEmailConfigurationFailure().hashCode())) * 31) + (getDomain() == null ? 0 : getDomain().hashCode())) * 31) + (getCustomDomain() == null ? 0 : getCustomDomain().hashCode())) * 31) + (getAdminCreateUserConfig() == null ? 0 : getAdminCreateUserConfig().hashCode())) * 31) + (getUserPoolAddOns() == null ? 0 : getUserPoolAddOns().hashCode())) * 31) + (getUsernameConfiguration() == null ? 0 : getUsernameConfiguration().hashCode())) * 31) + (getArn() == null ? 0 : getArn().hashCode())) * 31) + (getAccountRecoverySetting() != null ? getAccountRecoverySetting().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolType)) {
            return false;
        }
        UserPoolType userPoolType = (UserPoolType) obj;
        if ((userPoolType.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (userPoolType.getId() != null && !userPoolType.getId().equals(getId())) {
            return false;
        }
        if ((userPoolType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (userPoolType.getName() != null && !userPoolType.getName().equals(getName())) {
            return false;
        }
        if ((userPoolType.getPolicies() == null) ^ (getPolicies() == null)) {
            return false;
        }
        if (userPoolType.getPolicies() != null && !userPoolType.getPolicies().equals(getPolicies())) {
            return false;
        }
        if ((userPoolType.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (userPoolType.getLambdaConfig() != null && !userPoolType.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((userPoolType.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (userPoolType.getStatus() != null && !userPoolType.getStatus().equals(getStatus())) {
            return false;
        }
        if ((userPoolType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (userPoolType.getLastModifiedDate() != null && !userPoolType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((userPoolType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (userPoolType.getCreationDate() != null && !userPoolType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((userPoolType.getSchemaAttributes() == null) ^ (getSchemaAttributes() == null)) {
            return false;
        }
        if (userPoolType.getSchemaAttributes() != null && !userPoolType.getSchemaAttributes().equals(getSchemaAttributes())) {
            return false;
        }
        if ((userPoolType.getAutoVerifiedAttributes() == null) ^ (getAutoVerifiedAttributes() == null)) {
            return false;
        }
        if (userPoolType.getAutoVerifiedAttributes() != null && !userPoolType.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if ((userPoolType.getAliasAttributes() == null) ^ (getAliasAttributes() == null)) {
            return false;
        }
        if (userPoolType.getAliasAttributes() != null && !userPoolType.getAliasAttributes().equals(getAliasAttributes())) {
            return false;
        }
        if ((userPoolType.getUsernameAttributes() == null) ^ (getUsernameAttributes() == null)) {
            return false;
        }
        if (userPoolType.getUsernameAttributes() != null && !userPoolType.getUsernameAttributes().equals(getUsernameAttributes())) {
            return false;
        }
        if ((userPoolType.getSmsVerificationMessage() == null) ^ (getSmsVerificationMessage() == null)) {
            return false;
        }
        if (userPoolType.getSmsVerificationMessage() != null && !userPoolType.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if ((userPoolType.getEmailVerificationMessage() == null) ^ (getEmailVerificationMessage() == null)) {
            return false;
        }
        if (userPoolType.getEmailVerificationMessage() != null && !userPoolType.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if ((userPoolType.getEmailVerificationSubject() == null) ^ (getEmailVerificationSubject() == null)) {
            return false;
        }
        if (userPoolType.getEmailVerificationSubject() != null && !userPoolType.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if ((userPoolType.getVerificationMessageTemplate() == null) ^ (getVerificationMessageTemplate() == null)) {
            return false;
        }
        if (userPoolType.getVerificationMessageTemplate() != null && !userPoolType.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if ((userPoolType.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (userPoolType.getSmsAuthenticationMessage() != null && !userPoolType.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((userPoolType.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getMfaConfiguration() != null && !userPoolType.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if ((userPoolType.getDeviceConfiguration() == null) ^ (getDeviceConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getDeviceConfiguration() != null && !userPoolType.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if ((userPoolType.getEstimatedNumberOfUsers() == null) ^ (getEstimatedNumberOfUsers() == null)) {
            return false;
        }
        if (userPoolType.getEstimatedNumberOfUsers() != null && !userPoolType.getEstimatedNumberOfUsers().equals(getEstimatedNumberOfUsers())) {
            return false;
        }
        if ((userPoolType.getEmailConfiguration() == null) ^ (getEmailConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getEmailConfiguration() != null && !userPoolType.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if ((userPoolType.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getSmsConfiguration() != null && !userPoolType.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if ((userPoolType.getUserPoolTags() == null) ^ (getUserPoolTags() == null)) {
            return false;
        }
        if (userPoolType.getUserPoolTags() != null && !userPoolType.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if ((userPoolType.getSmsConfigurationFailure() == null) ^ (getSmsConfigurationFailure() == null)) {
            return false;
        }
        if (userPoolType.getSmsConfigurationFailure() != null && !userPoolType.getSmsConfigurationFailure().equals(getSmsConfigurationFailure())) {
            return false;
        }
        if ((userPoolType.getEmailConfigurationFailure() == null) ^ (getEmailConfigurationFailure() == null)) {
            return false;
        }
        if (userPoolType.getEmailConfigurationFailure() != null && !userPoolType.getEmailConfigurationFailure().equals(getEmailConfigurationFailure())) {
            return false;
        }
        if ((userPoolType.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (userPoolType.getDomain() != null && !userPoolType.getDomain().equals(getDomain())) {
            return false;
        }
        if ((userPoolType.getCustomDomain() == null) ^ (getCustomDomain() == null)) {
            return false;
        }
        if (userPoolType.getCustomDomain() != null && !userPoolType.getCustomDomain().equals(getCustomDomain())) {
            return false;
        }
        if ((userPoolType.getAdminCreateUserConfig() == null) ^ (getAdminCreateUserConfig() == null)) {
            return false;
        }
        if (userPoolType.getAdminCreateUserConfig() != null && !userPoolType.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if ((userPoolType.getUserPoolAddOns() == null) ^ (getUserPoolAddOns() == null)) {
            return false;
        }
        if (userPoolType.getUserPoolAddOns() != null && !userPoolType.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if ((userPoolType.getUsernameConfiguration() == null) ^ (getUsernameConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getUsernameConfiguration() != null && !userPoolType.getUsernameConfiguration().equals(getUsernameConfiguration())) {
            return false;
        }
        if ((userPoolType.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        if (userPoolType.getArn() != null && !userPoolType.getArn().equals(getArn())) {
            return false;
        }
        if ((userPoolType.getAccountRecoverySetting() == null) ^ (getAccountRecoverySetting() == null)) {
            return false;
        }
        return userPoolType.getAccountRecoverySetting() == null || userPoolType.getAccountRecoverySetting().equals(getAccountRecoverySetting());
    }
}
