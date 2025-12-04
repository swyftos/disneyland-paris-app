package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class CognitoSecretHash {
    public static String getSecretHash(String str, String str2, String str3) {
        if (str == null) {
            throw new CognitoParameterInvalidException("user ID cannot be null");
        }
        if (str2 == null) {
            throw new CognitoParameterInvalidException("client ID cannot be null");
        }
        if (StringUtils.isBlank(str3)) {
            return null;
        }
        Charset charset = StringUtils.UTF8;
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(charset), "HmacSHA256");
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            mac.update(str.getBytes(charset));
            return new String(Base64.encode(mac.doFinal(str2.getBytes(charset))));
        } catch (Exception unused) {
            throw new CognitoInternalErrorException("errors in HMAC calculation");
        }
    }
}
