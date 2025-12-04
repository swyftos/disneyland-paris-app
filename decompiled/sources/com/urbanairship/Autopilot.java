package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.UAirship;

/* loaded from: classes4.dex */
public class Autopilot implements UAirship.OnReadyCallback {

    @NonNull
    public static final String AUTOPILOT_MANIFEST_KEY = "com.urbanairship.autopilot";
    private static Autopilot instance;
    private static boolean instanceCreationAttempted;

    public boolean allowEarlyTakeOff(@NonNull Context context) {
        return true;
    }

    @Nullable
    public AirshipConfigOptions createAirshipConfigOptions(@NonNull Context context) {
        return null;
    }

    public boolean isReady(@NonNull Context context) {
        return true;
    }

    public static void automaticTakeOff(@NonNull Context context) {
        automaticTakeOff((Application) context.getApplicationContext(), false);
    }

    public static synchronized void automaticTakeOff(@NonNull Application application) {
        automaticTakeOff(application, false);
    }

    static synchronized void automaticTakeOff(Application application, boolean z) {
        if (!UAirship.isFlying() && !UAirship.isTakingOff()) {
            AirshipAppBootstrap.init(application);
            if (!instanceCreationAttempted) {
                try {
                    ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                    if (applicationInfo == null || applicationInfo.metaData == null) {
                        Log.e("Airship Autopilot", "Unable to load app info.");
                        return;
                    } else {
                        instance = createAutopilotInstance(applicationInfo);
                        instanceCreationAttempted = true;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("Airship Autopilot", "Failed to get app info.", e);
                    return;
                }
            }
            Autopilot autopilot = instance;
            if (autopilot == null) {
                return;
            }
            if (!z || autopilot.allowEarlyTakeOff(application)) {
                if (instance.isReady(application)) {
                    AirshipConfigOptions airshipConfigOptionsCreateAirshipConfigOptions = instance.createAirshipConfigOptions(application);
                    if (UAirship.isFlying() || UAirship.isTakingOff()) {
                        Log.e("Airship Autopilot", "Airship is flying before autopilot is able to take off. Make sureAutopilot.onCreateAirshipConfig is not calling takeOff directly.");
                    }
                    UAirship.takeOff(application, airshipConfigOptionsCreateAirshipConfigOptions, instance);
                    instance = null;
                }
            }
        }
    }

    private static Autopilot createAutopilotInstance(ApplicationInfo applicationInfo) {
        String string = applicationInfo.metaData.getString(AUTOPILOT_MANIFEST_KEY);
        if (string == null) {
            return null;
        }
        try {
            return (Autopilot) Class.forName(string).newInstance();
        } catch (ClassNotFoundException unused) {
            Log.e("Airship Autopilot", "Class not found: " + string);
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e("Airship Autopilot", "Unable to access class: " + string);
            return null;
        } catch (InstantiationException unused3) {
            Log.e("Airship Autopilot", "Unable to create class: " + string);
            return null;
        }
    }

    @Override // com.urbanairship.UAirship.OnReadyCallback
    public void onAirshipReady(@NonNull UAirship uAirship) {
        UALog.d("Airship ready!", new Object[0]);
    }
}
