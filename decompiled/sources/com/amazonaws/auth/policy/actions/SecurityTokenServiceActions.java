package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

/* loaded from: classes2.dex */
public enum SecurityTokenServiceActions implements Action {
    AllSecurityTokenServiceActions("sts:*"),
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithSAML("sts:AssumeRoleWithSAML"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity"),
    DecodeAuthorizationMessage("sts:DecodeAuthorizationMessage"),
    GetAccessKeyInfo("sts:GetAccessKeyInfo"),
    GetCallerIdentity("sts:GetCallerIdentity"),
    GetFederationToken("sts:GetFederationToken"),
    GetSessionToken("sts:GetSessionToken");

    private final String action;

    SecurityTokenServiceActions(String str) {
        this.action = str;
    }

    @Override // com.amazonaws.auth.policy.Action
    public String getActionName() {
        return this.action;
    }
}
