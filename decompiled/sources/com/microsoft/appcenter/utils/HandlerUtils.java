package com.microsoft.appcenter.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class HandlerUtils {
    static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static void runOnUiThread(Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        Handler handler = sMainHandler;
        if (threadCurrentThread == handler.getLooper().getThread()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static Handler getMainHandler() {
        return sMainHandler;
    }
}
