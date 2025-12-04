package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetUICustomizationResult implements Serializable {
    private UICustomizationType uICustomization;

    public UICustomizationType getUICustomization() {
        return this.uICustomization;
    }

    public void setUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
    }

    public GetUICustomizationResult withUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUICustomization() != null) {
            sb.append("UICustomization: " + getUICustomization());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUICustomization() == null ? 0 : getUICustomization().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUICustomizationResult)) {
            return false;
        }
        GetUICustomizationResult getUICustomizationResult = (GetUICustomizationResult) obj;
        if ((getUICustomizationResult.getUICustomization() == null) ^ (getUICustomization() == null)) {
            return false;
        }
        return getUICustomizationResult.getUICustomization() == null || getUICustomizationResult.getUICustomization().equals(getUICustomization());
    }
}
