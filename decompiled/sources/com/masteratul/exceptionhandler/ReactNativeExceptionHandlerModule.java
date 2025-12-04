package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.lang.Thread;

/* loaded from: classes4.dex */
public class ReactNativeExceptionHandlerModule extends ReactContextBaseJavaModule {
    private static Class errorIntentTargetClass = DefaultErrorScreen.class;
    private static NativeExceptionHandlerIfc nativeExceptionHandler;
    private Activity activity;
    private Callback callbackHolder;
    private Thread.UncaughtExceptionHandler originalHandler;
    private ReactApplicationContext reactContext;

    public ReactNativeExceptionHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ReactNativeExceptionHandler";
    }

    @ReactMethod
    public void setHandlerforNativeException(final boolean z, final boolean z2, Callback callback) {
        this.callbackHolder = callback;
        this.originalHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.masteratul.exceptionhandler.ReactNativeExceptionHandlerModule.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                ReactNativeExceptionHandlerModule.this.callbackHolder.invoke(stackTraceString);
                if (ReactNativeExceptionHandlerModule.nativeExceptionHandler != null) {
                    ReactNativeExceptionHandlerModule.nativeExceptionHandler.handleNativeException(thread, th, ReactNativeExceptionHandlerModule.this.originalHandler);
                    return;
                }
                ReactNativeExceptionHandlerModule reactNativeExceptionHandlerModule = ReactNativeExceptionHandlerModule.this;
                reactNativeExceptionHandlerModule.activity = reactNativeExceptionHandlerModule.getCurrentActivity();
                Intent intent = new Intent();
                intent.setClass(ReactNativeExceptionHandlerModule.this.activity, ReactNativeExceptionHandlerModule.errorIntentTargetClass);
                intent.putExtra("stack_trace_string", stackTraceString);
                intent.setFlags(268435456);
                ReactNativeExceptionHandlerModule.this.activity.startActivity(intent);
                ReactNativeExceptionHandlerModule.this.activity.finish();
                if (z && ReactNativeExceptionHandlerModule.this.originalHandler != null) {
                    ReactNativeExceptionHandlerModule.this.originalHandler.uncaughtException(thread, th);
                }
                if (z2) {
                    System.exit(0);
                }
            }
        });
    }

    public static void replaceErrorScreenActivityClass(Class cls) {
        errorIntentTargetClass = cls;
    }

    public static void setNativeExceptionHandler(NativeExceptionHandlerIfc nativeExceptionHandlerIfc) {
        nativeExceptionHandler = nativeExceptionHandlerIfc;
    }
}
