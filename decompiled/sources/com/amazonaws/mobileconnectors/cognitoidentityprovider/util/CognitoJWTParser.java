package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import android.util.Base64;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CognitoJWTParser {
    public static JSONObject getHeader(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[0], 8), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new CognitoParameterInvalidException(e.getMessage());
        } catch (JSONException e2) {
            throw new CognitoParameterInvalidException(e2.getMessage());
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static JSONObject getPayload(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[1], 8), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new CognitoParameterInvalidException(e.getMessage());
        } catch (JSONException e2) {
            throw new CognitoParameterInvalidException(e2.getMessage());
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static String getSignature(String str) {
        try {
            validateJWT(str);
            return new String(Base64.decode(str.split("\\.")[2], 8), "UTF-8");
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static String getClaim(String str, String str2) throws JSONException {
        try {
            Object obj = getPayload(str).get(str2);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("invalid token");
        }
    }

    public static void validateJWT(String str) {
        if (str.split("\\.").length != 3) {
            throw new CognitoParameterInvalidException("not a JSON Web Token");
        }
    }
}
