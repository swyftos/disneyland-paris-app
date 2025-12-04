package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum DeliveryMediumType {
    SMS("SMS"),
    EMAIL("EMAIL");

    private static final Map enumMap;
    private String value;

    static {
        DeliveryMediumType deliveryMediumType = SMS;
        DeliveryMediumType deliveryMediumType2 = EMAIL;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SMS", deliveryMediumType);
        map.put("EMAIL", deliveryMediumType2);
    }

    DeliveryMediumType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DeliveryMediumType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DeliveryMediumType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
