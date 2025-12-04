package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MessageTemplateType implements Serializable {
    private String emailMessage;
    private String emailSubject;
    private String sMSMessage;

    public String getSMSMessage() {
        return this.sMSMessage;
    }

    public void setSMSMessage(String str) {
        this.sMSMessage = str;
    }

    public MessageTemplateType withSMSMessage(String str) {
        this.sMSMessage = str;
        return this;
    }

    public String getEmailMessage() {
        return this.emailMessage;
    }

    public void setEmailMessage(String str) {
        this.emailMessage = str;
    }

    public MessageTemplateType withEmailMessage(String str) {
        this.emailMessage = str;
        return this;
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public void setEmailSubject(String str) {
        this.emailSubject = str;
    }

    public MessageTemplateType withEmailSubject(String str) {
        this.emailSubject = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSMSMessage() != null) {
            sb.append("SMSMessage: " + getSMSMessage() + ",");
        }
        if (getEmailMessage() != null) {
            sb.append("EmailMessage: " + getEmailMessage() + ",");
        }
        if (getEmailSubject() != null) {
            sb.append("EmailSubject: " + getEmailSubject());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getSMSMessage() == null ? 0 : getSMSMessage().hashCode()) + 31) * 31) + (getEmailMessage() == null ? 0 : getEmailMessage().hashCode())) * 31) + (getEmailSubject() != null ? getEmailSubject().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MessageTemplateType)) {
            return false;
        }
        MessageTemplateType messageTemplateType = (MessageTemplateType) obj;
        if ((messageTemplateType.getSMSMessage() == null) ^ (getSMSMessage() == null)) {
            return false;
        }
        if (messageTemplateType.getSMSMessage() != null && !messageTemplateType.getSMSMessage().equals(getSMSMessage())) {
            return false;
        }
        if ((messageTemplateType.getEmailMessage() == null) ^ (getEmailMessage() == null)) {
            return false;
        }
        if (messageTemplateType.getEmailMessage() != null && !messageTemplateType.getEmailMessage().equals(getEmailMessage())) {
            return false;
        }
        if ((messageTemplateType.getEmailSubject() == null) ^ (getEmailSubject() == null)) {
            return false;
        }
        return messageTemplateType.getEmailSubject() == null || messageTemplateType.getEmailSubject().equals(getEmailSubject());
    }
}
