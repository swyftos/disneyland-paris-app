package com.amazonaws.services.cognitoidentityprovider.model;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum AttributeDataType {
    String("String"),
    Number("Number"),
    DateTime(ExifInterface.TAG_DATETIME),
    Boolean("Boolean");

    private static final Map enumMap;
    private String value;

    static {
        AttributeDataType attributeDataType = String;
        AttributeDataType attributeDataType2 = Number;
        AttributeDataType attributeDataType3 = DateTime;
        AttributeDataType attributeDataType4 = Boolean;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("String", attributeDataType);
        map.put("Number", attributeDataType2);
        map.put(ExifInterface.TAG_DATETIME, attributeDataType3);
        map.put("Boolean", attributeDataType4);
    }

    AttributeDataType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AttributeDataType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AttributeDataType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
