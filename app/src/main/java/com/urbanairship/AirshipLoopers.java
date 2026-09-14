package com.urbanairship;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.facebook.react.modules.appstate.AppStateModule;
import com.urbanairship.util.AirshipHandlerThread;

/* JADX INFO: loaded from: classes4.dex */
public class AirshipLoopers {
    private static Looper backgroundLooper;

    @NonNull
    public static Looper getBackgroundLooper() {
        if (backgroundLooper == null) {
            synchronized (AirshipLoopers.class) {
                try {
                    if (backgroundLooper == null) {
                        AirshipHandlerThread airshipHandlerThread = new AirshipHandlerThread(AppStateModule.APP_STATE_BACKGROUND);
                        airshipHandlerThread.start();
                        backgroundLooper = airshipHandlerThread.getLooper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return backgroundLooper;
    }
}
