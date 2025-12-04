package com.amazonaws.services.s3.model;

import androidx.autofill.HintConstants;

/* loaded from: classes2.dex */
public class EmailAddressGrantee implements Grantee {
    private String emailAddress = null;

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS;
    }

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.emailAddress = str;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.emailAddress;
    }

    public int hashCode() {
        String str = this.emailAddress;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        String str = this.emailAddress;
        if (str == null) {
            if (emailAddressGrantee.emailAddress != null) {
                return false;
            }
        } else if (!str.equals(emailAddressGrantee.emailAddress)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.emailAddress;
    }
}
