package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SignUpResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;
    private Boolean userConfirmed;
    private String userSub;

    public Boolean isUserConfirmed() {
        return this.userConfirmed;
    }

    public Boolean getUserConfirmed() {
        return this.userConfirmed;
    }

    public void setUserConfirmed(Boolean bool) {
        this.userConfirmed = bool;
    }

    public SignUpResult withUserConfirmed(Boolean bool) {
        this.userConfirmed = bool;
        return this;
    }

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public SignUpResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }

    public String getUserSub() {
        return this.userSub;
    }

    public void setUserSub(String str) {
        this.userSub = str;
    }

    public SignUpResult withUserSub(String str) {
        this.userSub = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserConfirmed() != null) {
            sb.append("UserConfirmed: " + getUserConfirmed() + ",");
        }
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails() + ",");
        }
        if (getUserSub() != null) {
            sb.append("UserSub: " + getUserSub());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserConfirmed() == null ? 0 : getUserConfirmed().hashCode()) + 31) * 31) + (getCodeDeliveryDetails() == null ? 0 : getCodeDeliveryDetails().hashCode())) * 31) + (getUserSub() != null ? getUserSub().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignUpResult)) {
            return false;
        }
        SignUpResult signUpResult = (SignUpResult) obj;
        if ((signUpResult.getUserConfirmed() == null) ^ (getUserConfirmed() == null)) {
            return false;
        }
        if (signUpResult.getUserConfirmed() != null && !signUpResult.getUserConfirmed().equals(getUserConfirmed())) {
            return false;
        }
        if ((signUpResult.getCodeDeliveryDetails() == null) ^ (getCodeDeliveryDetails() == null)) {
            return false;
        }
        if (signUpResult.getCodeDeliveryDetails() != null && !signUpResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails())) {
            return false;
        }
        if ((signUpResult.getUserSub() == null) ^ (getUserSub() == null)) {
            return false;
        }
        return signUpResult.getUserSub() == null || signUpResult.getUserSub().equals(getUserSub());
    }
}
