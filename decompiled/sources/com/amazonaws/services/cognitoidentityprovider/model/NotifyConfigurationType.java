package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class NotifyConfigurationType implements Serializable {
    private NotifyEmailType blockEmail;
    private String from;
    private NotifyEmailType mfaEmail;
    private NotifyEmailType noActionEmail;
    private String replyTo;
    private String sourceArn;

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public NotifyConfigurationType withFrom(String str) {
        this.from = str;
        return this;
    }

    public String getReplyTo() {
        return this.replyTo;
    }

    public void setReplyTo(String str) {
        this.replyTo = str;
    }

    public NotifyConfigurationType withReplyTo(String str) {
        this.replyTo = str;
        return this;
    }

    public String getSourceArn() {
        return this.sourceArn;
    }

    public void setSourceArn(String str) {
        this.sourceArn = str;
    }

    public NotifyConfigurationType withSourceArn(String str) {
        this.sourceArn = str;
        return this;
    }

    public NotifyEmailType getBlockEmail() {
        return this.blockEmail;
    }

    public void setBlockEmail(NotifyEmailType notifyEmailType) {
        this.blockEmail = notifyEmailType;
    }

    public NotifyConfigurationType withBlockEmail(NotifyEmailType notifyEmailType) {
        this.blockEmail = notifyEmailType;
        return this;
    }

    public NotifyEmailType getNoActionEmail() {
        return this.noActionEmail;
    }

    public void setNoActionEmail(NotifyEmailType notifyEmailType) {
        this.noActionEmail = notifyEmailType;
    }

    public NotifyConfigurationType withNoActionEmail(NotifyEmailType notifyEmailType) {
        this.noActionEmail = notifyEmailType;
        return this;
    }

    public NotifyEmailType getMfaEmail() {
        return this.mfaEmail;
    }

    public void setMfaEmail(NotifyEmailType notifyEmailType) {
        this.mfaEmail = notifyEmailType;
    }

    public NotifyConfigurationType withMfaEmail(NotifyEmailType notifyEmailType) {
        this.mfaEmail = notifyEmailType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFrom() != null) {
            sb.append("From: " + getFrom() + ",");
        }
        if (getReplyTo() != null) {
            sb.append("ReplyTo: " + getReplyTo() + ",");
        }
        if (getSourceArn() != null) {
            sb.append("SourceArn: " + getSourceArn() + ",");
        }
        if (getBlockEmail() != null) {
            sb.append("BlockEmail: " + getBlockEmail() + ",");
        }
        if (getNoActionEmail() != null) {
            sb.append("NoActionEmail: " + getNoActionEmail() + ",");
        }
        if (getMfaEmail() != null) {
            sb.append("MfaEmail: " + getMfaEmail());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getFrom() == null ? 0 : getFrom().hashCode()) + 31) * 31) + (getReplyTo() == null ? 0 : getReplyTo().hashCode())) * 31) + (getSourceArn() == null ? 0 : getSourceArn().hashCode())) * 31) + (getBlockEmail() == null ? 0 : getBlockEmail().hashCode())) * 31) + (getNoActionEmail() == null ? 0 : getNoActionEmail().hashCode())) * 31) + (getMfaEmail() != null ? getMfaEmail().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotifyConfigurationType)) {
            return false;
        }
        NotifyConfigurationType notifyConfigurationType = (NotifyConfigurationType) obj;
        if ((notifyConfigurationType.getFrom() == null) ^ (getFrom() == null)) {
            return false;
        }
        if (notifyConfigurationType.getFrom() != null && !notifyConfigurationType.getFrom().equals(getFrom())) {
            return false;
        }
        if ((notifyConfigurationType.getReplyTo() == null) ^ (getReplyTo() == null)) {
            return false;
        }
        if (notifyConfigurationType.getReplyTo() != null && !notifyConfigurationType.getReplyTo().equals(getReplyTo())) {
            return false;
        }
        if ((notifyConfigurationType.getSourceArn() == null) ^ (getSourceArn() == null)) {
            return false;
        }
        if (notifyConfigurationType.getSourceArn() != null && !notifyConfigurationType.getSourceArn().equals(getSourceArn())) {
            return false;
        }
        if ((notifyConfigurationType.getBlockEmail() == null) ^ (getBlockEmail() == null)) {
            return false;
        }
        if (notifyConfigurationType.getBlockEmail() != null && !notifyConfigurationType.getBlockEmail().equals(getBlockEmail())) {
            return false;
        }
        if ((notifyConfigurationType.getNoActionEmail() == null) ^ (getNoActionEmail() == null)) {
            return false;
        }
        if (notifyConfigurationType.getNoActionEmail() != null && !notifyConfigurationType.getNoActionEmail().equals(getNoActionEmail())) {
            return false;
        }
        if ((notifyConfigurationType.getMfaEmail() == null) ^ (getMfaEmail() == null)) {
            return false;
        }
        return notifyConfigurationType.getMfaEmail() == null || notifyConfigurationType.getMfaEmail().equals(getMfaEmail());
    }
}
