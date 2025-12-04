package com.learnium.RNDeviceInfo.resolver;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.Constants;
import com.learnium.RNDeviceInfo.RNDeviceModule;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* loaded from: classes4.dex */
public class DeviceIdResolver {
    private final Context context;

    public DeviceIdResolver(Context context) {
        this.context = context;
    }

    public String getInstanceIdSync() {
        String instanceIdFromPrefs = getInstanceIdFromPrefs();
        if (instanceIdFromPrefs != "unknown") {
            return instanceIdFromPrefs;
        }
        try {
            String firebaseInstanceId = getFirebaseInstanceId();
            setInstanceIdInPrefs(firebaseInstanceId);
            return firebaseInstanceId;
        } catch (ClassNotFoundException unused) {
            try {
                String gmsInstanceId = getGmsInstanceId();
                setInstanceIdInPrefs(gmsInstanceId);
                return gmsInstanceId;
            } catch (ClassNotFoundException unused2) {
                String uUIDInstanceId = getUUIDInstanceId();
                setInstanceIdInPrefs(uUIDInstanceId);
                return uUIDInstanceId;
            } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused3) {
                System.err.println("N/A: Unsupported version of com.google.android.gms.iid in your project.");
                String uUIDInstanceId2 = getUUIDInstanceId();
                setInstanceIdInPrefs(uUIDInstanceId2);
                return uUIDInstanceId2;
            }
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused4) {
            System.err.println("N/A: Unsupported version of com.google.firebase:firebase-iid in your project.");
            String gmsInstanceId2 = getGmsInstanceId();
            setInstanceIdInPrefs(gmsInstanceId2);
            return gmsInstanceId2;
        }
    }

    String getUUIDInstanceId() {
        return UUID.randomUUID().toString();
    }

    String getInstanceIdFromPrefs() {
        return RNDeviceModule.getRNDISharedPreferences(this.context).getString(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "unknown");
    }

    void setInstanceIdInPrefs(String str) {
        SharedPreferences.Editor editorEdit = RNDeviceModule.getRNDISharedPreferences(this.context).edit();
        editorEdit.putString(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, str);
        editorEdit.apply();
    }

    String getGmsInstanceId() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Class.forName("com.google.android.gms.iid.InstanceID").getDeclaredMethod("getInstance", Context.class).invoke(null, this.context.getApplicationContext());
        return (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
    }

    String getFirebaseInstanceId() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = FirebaseInstanceId.$r8$clinit;
        Object objInvoke = FirebaseInstanceId.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        return (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
    }
}
