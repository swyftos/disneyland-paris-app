package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ApplicationDataCollector extends DataCollector {
    private static final String TAG = "ApplicationDataCollector";

    @Override // com.amazonaws.cognito.clientcontext.datacollection.DataCollector
    public Map<String, String> collect(Context context) {
        HashMap map = new HashMap();
        map.put(DataRecordKey.APP_NAME, getAppName(context));
        map.put(DataRecordKey.APP_TARGET_SDK, getAppTargetSdk(context));
        map.put(DataRecordKey.APP_VERSION, getAppVersion(context));
        return map;
    }

    private String getAppName(Context context) {
        return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
    }

    private String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(TAG, "Unable to get app version. Provided package name could not be found.");
            return "";
        }
    }

    private String getAppTargetSdk(Context context) {
        return String.valueOf(context.getApplicationInfo().targetSdkVersion);
    }
}
