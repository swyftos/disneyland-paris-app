package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MFAOptionType implements Serializable {
    private String attributeName;
    private String deliveryMedium;

    public String getDeliveryMedium() {
        return this.deliveryMedium;
    }

    public void setDeliveryMedium(String str) {
        this.deliveryMedium = str;
    }

    public MFAOptionType withDeliveryMedium(String str) {
        this.deliveryMedium = str;
        return this;
    }

    public void setDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
    }

    public MFAOptionType withDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
        return this;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public MFAOptionType withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeliveryMedium() != null) {
            sb.append("DeliveryMedium: " + getDeliveryMedium() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getDeliveryMedium() == null ? 0 : getDeliveryMedium().hashCode()) + 31) * 31) + (getAttributeName() != null ? getAttributeName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MFAOptionType)) {
            return false;
        }
        MFAOptionType mFAOptionType = (MFAOptionType) obj;
        if ((mFAOptionType.getDeliveryMedium() == null) ^ (getDeliveryMedium() == null)) {
            return false;
        }
        if (mFAOptionType.getDeliveryMedium() != null && !mFAOptionType.getDeliveryMedium().equals(getDeliveryMedium())) {
            return false;
        }
        if ((mFAOptionType.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        return mFAOptionType.getAttributeName() == null || mFAOptionType.getAttributeName().equals(getAttributeName());
    }
}
