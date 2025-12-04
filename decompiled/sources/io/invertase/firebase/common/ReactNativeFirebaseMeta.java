package io.invertase.firebase.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

/* loaded from: classes5.dex */
public class ReactNativeFirebaseMeta {
    private static ReactNativeFirebaseMeta sharedInstance = new ReactNativeFirebaseMeta();

    public static ReactNativeFirebaseMeta getSharedInstance() {
        return sharedInstance;
    }

    private Bundle getMetaData() {
        ApplicationInfo applicationInfo;
        try {
            Context applicationContext = ReactNativeFirebaseApp.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null) {
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public boolean contains(String str) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return false;
        }
        return metaData.containsKey("rnfirebase_" + str);
    }

    public boolean getBooleanValue(String str, boolean z) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return z;
        }
        return metaData.getBoolean("rnfirebase_" + str, z);
    }

    public String getStringValue(String str, String str2) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return str2;
        }
        return metaData.getString("rnfirebase_" + str, str2);
    }

    public WritableMap getAll() {
        Bundle metaData = getMetaData();
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (metaData == null) {
            return writableMapCreateMap;
        }
        for (String str : metaData.keySet()) {
            if (str.startsWith("rnfirebase_")) {
                Object obj = metaData.get(str);
                if (obj == null) {
                    writableMapCreateMap.putNull(str);
                } else if (obj instanceof String) {
                    writableMapCreateMap.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    writableMapCreateMap.putBoolean(str, ((Boolean) obj).booleanValue());
                }
            }
        }
        return writableMapCreateMap;
    }
}
