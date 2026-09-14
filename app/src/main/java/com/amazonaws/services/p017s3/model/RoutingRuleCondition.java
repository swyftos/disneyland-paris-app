package com.amazonaws.services.p017s3.model;

/* JADX INFO: loaded from: classes2.dex */
public class RoutingRuleCondition {
    String httpErrorCodeReturnedEquals;
    String keyPrefixEquals;

    public void setKeyPrefixEquals(String str) {
        this.keyPrefixEquals = str;
    }

    public String getKeyPrefixEquals() {
        return this.keyPrefixEquals;
    }

    public RoutingRuleCondition withKeyPrefixEquals(String str) {
        setKeyPrefixEquals(str);
        return this;
    }

    public void setHttpErrorCodeReturnedEquals(String str) {
        this.httpErrorCodeReturnedEquals = str;
    }

    public String getHttpErrorCodeReturnedEquals() {
        return this.httpErrorCodeReturnedEquals;
    }

    public RoutingRuleCondition withHttpErrorCodeReturnedEquals(String str) {
        setHttpErrorCodeReturnedEquals(str);
        return this;
    }
}
