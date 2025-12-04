package com.amazonaws.auth.policy;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class Condition {
    protected String conditionKey;
    protected String type;
    protected List<String> values;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getConditionKey() {
        return this.conditionKey;
    }

    public void setConditionKey(String str) {
        this.conditionKey = str;
    }

    public List<String> getValues() {
        return this.values;
    }

    public void setValues(List<String> list) {
        this.values = list;
    }

    public Condition withType(String str) {
        setType(str);
        return this;
    }

    public Condition withConditionKey(String str) {
        setConditionKey(str);
        return this;
    }

    public Condition withValues(String... strArr) {
        setValues(Arrays.asList(strArr));
        return this;
    }

    public Condition withValues(List<String> list) {
        setValues(list);
        return this;
    }
}
