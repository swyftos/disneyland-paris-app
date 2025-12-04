package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class IpAddressCondition extends Condition {

    public enum IpAddressComparisonType {
        IpAddress,
        NotIpAddress
    }

    public IpAddressCondition(String str) {
        this(IpAddressComparisonType.IpAddress, str);
    }

    public IpAddressCondition(IpAddressComparisonType ipAddressComparisonType, String str) {
        this.type = ipAddressComparisonType.toString();
        this.conditionKey = ConditionFactory.SOURCE_IP_CONDITION_KEY;
        this.values = Arrays.asList(str);
    }
}
