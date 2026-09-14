package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class ReactCxxErrorHandler {
    private static Method mHandleErrorFunc;
    private static Object mObject;

    @DoNotStrip
    public static void setHandleErrorFunc(Object obj, Method method) {
        mObject = obj;
        mHandleErrorFunc = method;
    }

    @DoNotStrip
    private static void handleError(String str) {
        if (mHandleErrorFunc != null) {
            try {
                mHandleErrorFunc.invoke(mObject, new Exception(str));
            } catch (Exception e) {
                FLog.m1292e("ReactCxxErrorHandler", "Failed to invoke error handler function", e);
            }
        }
    }
}
