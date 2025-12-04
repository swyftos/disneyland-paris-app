package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum RiskDecisionType {
    NoRisk("NoRisk"),
    AccountTakeover("AccountTakeover"),
    Block("Block");

    private static final Map enumMap;
    private String value;

    static {
        RiskDecisionType riskDecisionType = NoRisk;
        RiskDecisionType riskDecisionType2 = AccountTakeover;
        RiskDecisionType riskDecisionType3 = Block;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("NoRisk", riskDecisionType);
        map.put("AccountTakeover", riskDecisionType2);
        map.put("Block", riskDecisionType3);
    }

    RiskDecisionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static RiskDecisionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (RiskDecisionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
