package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class EmailConfigurationType implements Serializable {
    private String configurationSet;
    private String emailSendingAccount;
    private String from;
    private String replyToEmailAddress;
    private String sourceArn;

    public String getSourceArn() {
        return this.sourceArn;
    }

    public void setSourceArn(String str) {
        this.sourceArn = str;
    }

    public EmailConfigurationType withSourceArn(String str) {
        this.sourceArn = str;
        return this;
    }

    public String getReplyToEmailAddress() {
        return this.replyToEmailAddress;
    }

    public void setReplyToEmailAddress(String str) {
        this.replyToEmailAddress = str;
    }

    public EmailConfigurationType withReplyToEmailAddress(String str) {
        this.replyToEmailAddress = str;
        return this;
    }

    public String getEmailSendingAccount() {
        return this.emailSendingAccount;
    }

    public void setEmailSendingAccount(String str) {
        this.emailSendingAccount = str;
    }

    public EmailConfigurationType withEmailSendingAccount(String str) {
        this.emailSendingAccount = str;
        return this;
    }

    public void setEmailSendingAccount(EmailSendingAccountType emailSendingAccountType) {
        this.emailSendingAccount = emailSendingAccountType.toString();
    }

    public EmailConfigurationType withEmailSendingAccount(EmailSendingAccountType emailSendingAccountType) {
        this.emailSendingAccount = emailSendingAccountType.toString();
        return this;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public EmailConfigurationType withFrom(String str) {
        this.from = str;
        return this;
    }

    public String getConfigurationSet() {
        return this.configurationSet;
    }

    public void setConfigurationSet(String str) {
        this.configurationSet = str;
    }

    public EmailConfigurationType withConfigurationSet(String str) {
        this.configurationSet = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSourceArn() != null) {
            sb.append("SourceArn: " + getSourceArn() + ",");
        }
        if (getReplyToEmailAddress() != null) {
            sb.append("ReplyToEmailAddress: " + getReplyToEmailAddress() + ",");
        }
        if (getEmailSendingAccount() != null) {
            sb.append("EmailSendingAccount: " + getEmailSendingAccount() + ",");
        }
        if (getFrom() != null) {
            sb.append("From: " + getFrom() + ",");
        }
        if (getConfigurationSet() != null) {
            sb.append("ConfigurationSet: " + getConfigurationSet());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getSourceArn() == null ? 0 : getSourceArn().hashCode()) + 31) * 31) + (getReplyToEmailAddress() == null ? 0 : getReplyToEmailAddress().hashCode())) * 31) + (getEmailSendingAccount() == null ? 0 : getEmailSendingAccount().hashCode())) * 31) + (getFrom() == null ? 0 : getFrom().hashCode())) * 31) + (getConfigurationSet() != null ? getConfigurationSet().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EmailConfigurationType)) {
            return false;
        }
        EmailConfigurationType emailConfigurationType = (EmailConfigurationType) obj;
        if ((emailConfigurationType.getSourceArn() == null) ^ (getSourceArn() == null)) {
            return false;
        }
        if (emailConfigurationType.getSourceArn() != null && !emailConfigurationType.getSourceArn().equals(getSourceArn())) {
            return false;
        }
        if ((emailConfigurationType.getReplyToEmailAddress() == null) ^ (getReplyToEmailAddress() == null)) {
            return false;
        }
        if (emailConfigurationType.getReplyToEmailAddress() != null && !emailConfigurationType.getReplyToEmailAddress().equals(getReplyToEmailAddress())) {
            return false;
        }
        if ((emailConfigurationType.getEmailSendingAccount() == null) ^ (getEmailSendingAccount() == null)) {
            return false;
        }
        if (emailConfigurationType.getEmailSendingAccount() != null && !emailConfigurationType.getEmailSendingAccount().equals(getEmailSendingAccount())) {
            return false;
        }
        if ((emailConfigurationType.getFrom() == null) ^ (getFrom() == null)) {
            return false;
        }
        if (emailConfigurationType.getFrom() != null && !emailConfigurationType.getFrom().equals(getFrom())) {
            return false;
        }
        if ((emailConfigurationType.getConfigurationSet() == null) ^ (getConfigurationSet() == null)) {
            return false;
        }
        return emailConfigurationType.getConfigurationSet() == null || emailConfigurationType.getConfigurationSet().equals(getConfigurationSet());
    }
}
