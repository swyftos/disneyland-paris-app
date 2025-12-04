package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class VerificationMessageTemplateType implements Serializable {
    private String defaultEmailOption;
    private String emailMessage;
    private String emailMessageByLink;
    private String emailSubject;
    private String emailSubjectByLink;
    private String smsMessage;

    public String getSmsMessage() {
        return this.smsMessage;
    }

    public void setSmsMessage(String str) {
        this.smsMessage = str;
    }

    public VerificationMessageTemplateType withSmsMessage(String str) {
        this.smsMessage = str;
        return this;
    }

    public String getEmailMessage() {
        return this.emailMessage;
    }

    public void setEmailMessage(String str) {
        this.emailMessage = str;
    }

    public VerificationMessageTemplateType withEmailMessage(String str) {
        this.emailMessage = str;
        return this;
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public void setEmailSubject(String str) {
        this.emailSubject = str;
    }

    public VerificationMessageTemplateType withEmailSubject(String str) {
        this.emailSubject = str;
        return this;
    }

    public String getEmailMessageByLink() {
        return this.emailMessageByLink;
    }

    public void setEmailMessageByLink(String str) {
        this.emailMessageByLink = str;
    }

    public VerificationMessageTemplateType withEmailMessageByLink(String str) {
        this.emailMessageByLink = str;
        return this;
    }

    public String getEmailSubjectByLink() {
        return this.emailSubjectByLink;
    }

    public void setEmailSubjectByLink(String str) {
        this.emailSubjectByLink = str;
    }

    public VerificationMessageTemplateType withEmailSubjectByLink(String str) {
        this.emailSubjectByLink = str;
        return this;
    }

    public String getDefaultEmailOption() {
        return this.defaultEmailOption;
    }

    public void setDefaultEmailOption(String str) {
        this.defaultEmailOption = str;
    }

    public VerificationMessageTemplateType withDefaultEmailOption(String str) {
        this.defaultEmailOption = str;
        return this;
    }

    public void setDefaultEmailOption(DefaultEmailOptionType defaultEmailOptionType) {
        this.defaultEmailOption = defaultEmailOptionType.toString();
    }

    public VerificationMessageTemplateType withDefaultEmailOption(DefaultEmailOptionType defaultEmailOptionType) {
        this.defaultEmailOption = defaultEmailOptionType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsMessage() != null) {
            sb.append("SmsMessage: " + getSmsMessage() + ",");
        }
        if (getEmailMessage() != null) {
            sb.append("EmailMessage: " + getEmailMessage() + ",");
        }
        if (getEmailSubject() != null) {
            sb.append("EmailSubject: " + getEmailSubject() + ",");
        }
        if (getEmailMessageByLink() != null) {
            sb.append("EmailMessageByLink: " + getEmailMessageByLink() + ",");
        }
        if (getEmailSubjectByLink() != null) {
            sb.append("EmailSubjectByLink: " + getEmailSubjectByLink() + ",");
        }
        if (getDefaultEmailOption() != null) {
            sb.append("DefaultEmailOption: " + getDefaultEmailOption());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getSmsMessage() == null ? 0 : getSmsMessage().hashCode()) + 31) * 31) + (getEmailMessage() == null ? 0 : getEmailMessage().hashCode())) * 31) + (getEmailSubject() == null ? 0 : getEmailSubject().hashCode())) * 31) + (getEmailMessageByLink() == null ? 0 : getEmailMessageByLink().hashCode())) * 31) + (getEmailSubjectByLink() == null ? 0 : getEmailSubjectByLink().hashCode())) * 31) + (getDefaultEmailOption() != null ? getDefaultEmailOption().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerificationMessageTemplateType)) {
            return false;
        }
        VerificationMessageTemplateType verificationMessageTemplateType = (VerificationMessageTemplateType) obj;
        if ((verificationMessageTemplateType.getSmsMessage() == null) ^ (getSmsMessage() == null)) {
            return false;
        }
        if (verificationMessageTemplateType.getSmsMessage() != null && !verificationMessageTemplateType.getSmsMessage().equals(getSmsMessage())) {
            return false;
        }
        if ((verificationMessageTemplateType.getEmailMessage() == null) ^ (getEmailMessage() == null)) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailMessage() != null && !verificationMessageTemplateType.getEmailMessage().equals(getEmailMessage())) {
            return false;
        }
        if ((verificationMessageTemplateType.getEmailSubject() == null) ^ (getEmailSubject() == null)) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailSubject() != null && !verificationMessageTemplateType.getEmailSubject().equals(getEmailSubject())) {
            return false;
        }
        if ((verificationMessageTemplateType.getEmailMessageByLink() == null) ^ (getEmailMessageByLink() == null)) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailMessageByLink() != null && !verificationMessageTemplateType.getEmailMessageByLink().equals(getEmailMessageByLink())) {
            return false;
        }
        if ((verificationMessageTemplateType.getEmailSubjectByLink() == null) ^ (getEmailSubjectByLink() == null)) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailSubjectByLink() != null && !verificationMessageTemplateType.getEmailSubjectByLink().equals(getEmailSubjectByLink())) {
            return false;
        }
        if ((verificationMessageTemplateType.getDefaultEmailOption() == null) ^ (getDefaultEmailOption() == null)) {
            return false;
        }
        return verificationMessageTemplateType.getDefaultEmailOption() == null || verificationMessageTemplateType.getDefaultEmailOption().equals(getDefaultEmailOption());
    }
}
