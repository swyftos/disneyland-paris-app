package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.conditions.ArnCondition;
import com.amazonaws.auth.policy.conditions.StringCondition;

/* loaded from: classes2.dex */
public final class ConditionFactory {
    public static final String CURRENT_TIME_CONDITION_KEY = "aws:CurrentTime";
    public static final String EPOCH_TIME_CONDITION_KEY = "aws:EpochTime";
    public static final String REFERER_CONDITION_KEY = "aws:Referer";
    public static final String SECURE_TRANSPORT_CONDITION_KEY = "aws:SecureTransport";
    public static final String SOURCE_ARN_CONDITION_KEY = "aws:SourceArn";
    public static final String SOURCE_IP_CONDITION_KEY = "aws:SourceIp";
    public static final String USER_AGENT_CONDITION_KEY = "aws:UserAgent";

    public static Condition newSourceArnCondition(String str) {
        return new ArnCondition(ArnCondition.ArnComparisonType.ArnLike, SOURCE_ARN_CONDITION_KEY, str);
    }

    public static Condition newSecureTransportCondition() {
        return new BooleanCondition(SECURE_TRANSPORT_CONDITION_KEY, true);
    }

    public static Condition newUserAgentCondition(StringCondition.StringComparisonType stringComparisonType, String str) {
        return new StringCondition(stringComparisonType, USER_AGENT_CONDITION_KEY, str);
    }

    public static Condition newRefererCondition(StringCondition.StringComparisonType stringComparisonType, String str) {
        return new StringCondition(stringComparisonType, REFERER_CONDITION_KEY, str);
    }
}
