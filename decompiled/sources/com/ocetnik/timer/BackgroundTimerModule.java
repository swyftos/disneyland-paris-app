package com.ocetnik.timer;

import android.os.Handler;
import android.os.PowerManager;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/* loaded from: classes4.dex */
public class BackgroundTimerModule extends ReactContextBaseJavaModule {
    private Handler handler;
    private final LifecycleEventListener listener;
    private PowerManager powerManager;
    private ReactContext reactContext;
    private Runnable runnable;
    private PowerManager.WakeLock wakeLock;

    public BackgroundTimerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() { // from class: com.ocetnik.timer.BackgroundTimerModule.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                if (BackgroundTimerModule.this.wakeLock.isHeld()) {
                    BackgroundTimerModule.this.wakeLock.release();
                }
            }
        };
        this.listener = lifecycleEventListener;
        this.reactContext = reactApplicationContext;
        PowerManager powerManager = (PowerManager) getReactApplicationContext().getSystemService("power");
        this.powerManager = powerManager;
        this.wakeLock = powerManager.newWakeLock(1, "rohit_bg_wakelock");
        reactApplicationContext.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNBackgroundTimer";
    }

    @ReactMethod
    public void start(int i) {
        if (!this.wakeLock.isHeld()) {
            this.wakeLock.acquire();
        }
        this.handler = new Handler();
        Runnable runnable = new Runnable() { // from class: com.ocetnik.timer.BackgroundTimerModule.2
            @Override // java.lang.Runnable
            public void run() {
                BackgroundTimerModule backgroundTimerModule = BackgroundTimerModule.this;
                backgroundTimerModule.sendEvent(backgroundTimerModule.reactContext, "backgroundTimer");
            }
        };
        this.runnable = runnable;
        this.handler.post(runnable);
    }

    @ReactMethod
    public void stop() {
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, null);
    }

    @ReactMethod
    public void setTimeout(final int i, double d) {
        new Handler().postDelayed(new Runnable() { // from class: com.ocetnik.timer.BackgroundTimerModule.3
            @Override // java.lang.Runnable
            public void run() {
                if (BackgroundTimerModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) BackgroundTimerModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("backgroundTimer.timeout", Integer.valueOf(i));
                }
            }
        }, (long) d);
    }
}
