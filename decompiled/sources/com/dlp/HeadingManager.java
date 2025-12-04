package com.dlp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/* loaded from: classes3.dex */
public class HeadingManager extends ReactContextBaseJavaModule implements SensorEventListener {
    private static Context mApplicationContext;
    private int mAzimuth;
    private float mFilter;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private int newAzimuth;
    private float[] orientation;
    private float[] rMat;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public HeadingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAzimuth = 0;
        this.newAzimuth = 0;
        this.mFilter = 5.0f;
        this.orientation = new float[3];
        this.rMat = new float[9];
        mApplicationContext = reactApplicationContext.getApplicationContext();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "HeadingManager";
    }

    @ReactMethod
    public void start(int i, Promise promise) {
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) mApplicationContext.getSystemService("sensor");
        }
        if (this.mSensor == null) {
            this.mSensor = this.mSensorManager.getDefaultSensor(11);
        }
        this.mFilter = i;
        promise.resolve(Boolean.valueOf(this.mSensorManager.registerListener(this, this.mSensor, 2)));
    }

    @ReactMethod
    public void stop() {
        this.mSensorManager.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            SensorManager.getRotationMatrixFromVector(this.rMat, sensorEvent.values);
            this.newAzimuth = (int) (((((Math.toDegrees(SensorManager.getOrientation(this.rMat, this.orientation)[0]) + 360.0d) % 360.0d) - Math.toDegrees(SensorManager.getOrientation(this.rMat, this.orientation)[2])) + 360.0d) % 360.0d);
            if (Math.abs(this.mAzimuth - r7) < this.mFilter) {
                return;
            }
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("headingUpdated", Integer.valueOf(this.newAzimuth));
            this.mAzimuth = this.newAzimuth;
        }
    }
}
