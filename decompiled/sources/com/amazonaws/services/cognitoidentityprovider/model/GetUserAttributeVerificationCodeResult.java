package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetUserAttributeVerificationCodeResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public GetUserAttributeVerificationCodeResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCodeDeliveryDetails() == null ? 0 : getCodeDeliveryDetails().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserAttributeVerificationCodeResult)) {
            return false;
        }
        GetUserAttributeVerificationCodeResult getUserAttributeVerificationCodeResult = (GetUserAttributeVerificationCodeResult) obj;
        if ((getUserAttributeVerificationCodeResult.getCodeDeliveryDetails() == null) ^ (getCodeDeliveryDetails() == null)) {
            return false;
        }
        return getUserAttributeVerificationCodeResult.getCodeDeliveryDetails() == null || getUserAttributeVerificationCodeResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails());
    }
}
