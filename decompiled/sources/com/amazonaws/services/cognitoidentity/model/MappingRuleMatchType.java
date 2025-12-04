package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum MappingRuleMatchType {
    Equals("Equals"),
    Contains("Contains"),
    StartsWith("StartsWith"),
    NotEqual("NotEqual");

    private static final Map enumMap;
    private String value;

    static {
        MappingRuleMatchType mappingRuleMatchType = Equals;
        MappingRuleMatchType mappingRuleMatchType2 = Contains;
        MappingRuleMatchType mappingRuleMatchType3 = StartsWith;
        MappingRuleMatchType mappingRuleMatchType4 = NotEqual;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Equals", mappingRuleMatchType);
        map.put("Contains", mappingRuleMatchType2);
        map.put("StartsWith", mappingRuleMatchType3);
        map.put("NotEqual", mappingRuleMatchType4);
    }

    MappingRuleMatchType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static MappingRuleMatchType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (MappingRuleMatchType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
