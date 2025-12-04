package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class UpdateUserAttributesResult implements Serializable {
    private List codeDeliveryDetailsList;

    public List<CodeDeliveryDetailsType> getCodeDeliveryDetailsList() {
        return this.codeDeliveryDetailsList;
    }

    public void setCodeDeliveryDetailsList(Collection<CodeDeliveryDetailsType> collection) {
        if (collection == null) {
            this.codeDeliveryDetailsList = null;
        } else {
            this.codeDeliveryDetailsList = new ArrayList(collection);
        }
    }

    public UpdateUserAttributesResult withCodeDeliveryDetailsList(CodeDeliveryDetailsType... codeDeliveryDetailsTypeArr) {
        if (getCodeDeliveryDetailsList() == null) {
            this.codeDeliveryDetailsList = new ArrayList(codeDeliveryDetailsTypeArr.length);
        }
        for (CodeDeliveryDetailsType codeDeliveryDetailsType : codeDeliveryDetailsTypeArr) {
            this.codeDeliveryDetailsList.add(codeDeliveryDetailsType);
        }
        return this;
    }

    public UpdateUserAttributesResult withCodeDeliveryDetailsList(Collection<CodeDeliveryDetailsType> collection) {
        setCodeDeliveryDetailsList(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCodeDeliveryDetailsList() != null) {
            sb.append("CodeDeliveryDetailsList: " + getCodeDeliveryDetailsList());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCodeDeliveryDetailsList() == null ? 0 : getCodeDeliveryDetailsList().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserAttributesResult)) {
            return false;
        }
        UpdateUserAttributesResult updateUserAttributesResult = (UpdateUserAttributesResult) obj;
        if ((updateUserAttributesResult.getCodeDeliveryDetailsList() == null) ^ (getCodeDeliveryDetailsList() == null)) {
            return false;
        }
        return updateUserAttributesResult.getCodeDeliveryDetailsList() == null || updateUserAttributesResult.getCodeDeliveryDetailsList().equals(getCodeDeliveryDetailsList());
    }
}
