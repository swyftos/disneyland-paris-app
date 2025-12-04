package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.UUID;

/* loaded from: classes2.dex */
public class CognitoPinpointSharedContext {
    private static final Log LOGGER = LogFactory.getLog(CognitoPinpointSharedContext.class);

    public static String getPinpointEndpoint(Context context, String str) {
        return getPinpointEndpoint(context, str, "UniqueId");
    }

    public static String getPinpointEndpoint(Context context, String str, String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(str + "515d6767-01b7-49e5-8273-c8d11b0f331d", 0);
                String string = sharedPreferences.getString(str2, null);
                if (string != null) {
                    return string;
                }
                String string2 = UUID.randomUUID().toString();
                sharedPreferences.edit().putString(str2, string2).apply();
                return string2;
            } catch (Exception e) {
                LOGGER.error("Error while reading from SharedPreferences", e);
            }
        }
        return null;
    }
}
