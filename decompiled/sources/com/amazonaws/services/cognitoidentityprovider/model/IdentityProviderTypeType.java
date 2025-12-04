package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum IdentityProviderTypeType {
    SAML("SAML"),
    Facebook("Facebook"),
    Google("Google"),
    LoginWithAmazon("LoginWithAmazon"),
    SignInWithApple("SignInWithApple"),
    OIDC("OIDC");

    private static final Map enumMap;
    private String value;

    static {
        IdentityProviderTypeType identityProviderTypeType = SAML;
        IdentityProviderTypeType identityProviderTypeType2 = Facebook;
        IdentityProviderTypeType identityProviderTypeType3 = Google;
        IdentityProviderTypeType identityProviderTypeType4 = LoginWithAmazon;
        IdentityProviderTypeType identityProviderTypeType5 = SignInWithApple;
        IdentityProviderTypeType identityProviderTypeType6 = OIDC;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("SAML", identityProviderTypeType);
        map.put("Facebook", identityProviderTypeType2);
        map.put("Google", identityProviderTypeType3);
        map.put("LoginWithAmazon", identityProviderTypeType4);
        map.put("SignInWithApple", identityProviderTypeType5);
        map.put("OIDC", identityProviderTypeType6);
    }

    IdentityProviderTypeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IdentityProviderTypeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (IdentityProviderTypeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
