package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.messaging.Constants;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DeviceDataCollector extends DataCollector {
    protected static final String LOCAL_STORAGE_DEVICE_ID_KEY = "CognitoDeviceId";
    protected static final String LOCAL_STORAGE_PATH = "AWS.Cognito.ContextData";

    @Override // com.amazonaws.cognito.clientcontext.datacollection.DataCollector
    public Map<String, String> collect(Context context) {
        HashMap map = new HashMap();
        map.put(DataRecordKey.TIMEZONE, getTimezoneOffset());
        map.put(DataRecordKey.PLATFORM, Constants.FirelogAnalytics.SDK_PLATFORM_ANDROID);
        map.put(DataRecordKey.THIRD_PARTY_DEVICE_AGENT, getThirdPartyDeviceAgent());
        map.put(DataRecordKey.DEVICE_AGENT, getCognitoDeviceAgent(context));
        map.put(DataRecordKey.DEVICE_LANGUAGE, getLanguage());
        Display display = getDisplay(context);
        map.put(DataRecordKey.DEVICE_HEIGHT, String.valueOf(display.getHeight()));
        map.put(DataRecordKey.DEVICE_WIDTH, String.valueOf(display.getWidth()));
        return map;
    }

    private Display getDisplay(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    protected String getCognitoDeviceAgent(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_PATH, 0);
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString(LOCAL_STORAGE_DEVICE_ID_KEY, null);
        if (string != null) {
            return string;
        }
        String str = UUID.randomUUID().toString() + ":" + new Date().getTime();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(LOCAL_STORAGE_DEVICE_ID_KEY, str);
        editorEdit.apply();
        return str;
    }

    protected String getThirdPartyDeviceAgent() {
        return "android_id";
    }

    protected String getLanguage() {
        return Locale.getDefault().toString();
    }

    private String getTimezoneOffset() {
        int rawOffset = getTimezone().getRawOffset();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = rawOffset;
        long hours = timeUnit.toHours(j);
        long minutes = timeUnit.toMinutes(j) - TimeUnit.HOURS.toMinutes(hours);
        StringBuilder sb = new StringBuilder();
        sb.append(hours < 0 ? "-" : "");
        sb.append(String.format(Locale.US, "%02d:%02d", Long.valueOf(Math.abs(hours)), Long.valueOf(minutes)));
        return sb.toString();
    }

    protected TimeZone getTimezone() {
        return TimeZone.getDefault();
    }
}
