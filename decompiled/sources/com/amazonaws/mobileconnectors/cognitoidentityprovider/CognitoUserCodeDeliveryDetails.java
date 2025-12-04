package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;

/* loaded from: classes2.dex */
public class CognitoUserCodeDeliveryDetails {
    private final String attributeName;
    private final String deliveryMedium;
    private final String destination;

    protected CognitoUserCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        if (codeDeliveryDetailsType != null) {
            this.destination = codeDeliveryDetailsType.getDestination();
            this.deliveryMedium = codeDeliveryDetailsType.getDeliveryMedium();
            this.attributeName = codeDeliveryDetailsType.getAttributeName();
        } else {
            this.destination = null;
            this.deliveryMedium = null;
            this.attributeName = null;
        }
    }

    protected CognitoUserCodeDeliveryDetails(MFAOptionType mFAOptionType) {
        if (mFAOptionType != null) {
            this.destination = null;
            this.deliveryMedium = mFAOptionType.getDeliveryMedium();
            this.attributeName = mFAOptionType.getAttributeName();
        } else {
            this.destination = null;
            this.deliveryMedium = null;
            this.attributeName = null;
        }
    }

    public CognitoUserCodeDeliveryDetails(String str, String str2, String str3) {
        this.destination = str;
        this.deliveryMedium = str2;
        this.attributeName = str3;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeliveryMedium() {
        return this.deliveryMedium;
    }

    public String getAttributeName() {
        return this.attributeName;
    }
}
