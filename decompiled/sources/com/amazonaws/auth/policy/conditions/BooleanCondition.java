package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class BooleanCondition extends Condition {
    public BooleanCondition(String str, boolean z) {
        this.type = "Bool";
        this.conditionKey = str;
        this.values = Arrays.asList(Boolean.toString(z));
    }
}
