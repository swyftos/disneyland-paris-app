package com.appdynamics.eumagent.runtime.devicemetrics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import androidx.camera.video.AudioStats;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.ak;
import com.appdynamics.eumagent.runtime.p000private.am;
import com.appdynamics.eumagent.runtime.p000private.q;
import com.disney.id.android.tracker.OneIDTracker;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class DeviceMetricsCollector {
    private Context applicationContext;
    private q configurationManager;
    private Boolean currentChargingState;
    private Integer currentCollectionFrequencyInMinutes;
    private Boolean currentPowerState;
    private am eventBus;

    public DeviceMetricsCollector(q qVar, Context context, am amVar) {
        this.applicationContext = context;
        this.configurationManager = qVar;
        this.eventBus = amVar;
        Integer num = qVar.a.m;
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 2);
        this.currentCollectionFrequencyInMinutes = numValueOf;
        this.currentChargingState = null;
        this.currentPowerState = null;
        scheduleAndRunCollection(numValueOf);
        ADLog.logInfo("Device Metrics system initialized");
    }

    public DeviceMetricsCollector(q qVar, Context context) {
        this.applicationContext = context;
        this.configurationManager = qVar;
        Integer num = qVar.a.m;
        this.currentCollectionFrequencyInMinutes = Integer.valueOf(num != null ? num.intValue() : 2);
        this.currentChargingState = null;
        this.currentPowerState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAndRunCollection(Integer num) {
        new Timer().scheduleAtFixedRate(new a(this, (byte) 0), 0L, num.intValue() * OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC);
    }

    class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(DeviceMetricsCollector deviceMetricsCollector, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            DeviceMetricsCollector.this.eventBus.a(DeviceMetricsCollector.this.populateDeviceMetricsEvent());
            Integer num = DeviceMetricsCollector.this.configurationManager.a.m;
            if ((num != null ? num.intValue() : 2) != DeviceMetricsCollector.this.currentCollectionFrequencyInMinutes.intValue()) {
                if (!cancel()) {
                    ADLog.logAgentError("Failed to reschedule device metrics resource consumption task");
                    return;
                }
                DeviceMetricsCollector deviceMetricsCollector = DeviceMetricsCollector.this;
                Integer num2 = deviceMetricsCollector.configurationManager.a.m;
                deviceMetricsCollector.currentCollectionFrequencyInMinutes = Integer.valueOf(num2 != null ? num2.intValue() : 2);
                DeviceMetricsCollector deviceMetricsCollector2 = DeviceMetricsCollector.this;
                deviceMetricsCollector2.scheduleAndRunCollection(deviceMetricsCollector2.currentCollectionFrequencyInMinutes);
                ADLog.logInfo("Device Metrics collection frequency updated to: " + DeviceMetricsCollector.this.currentCollectionFrequencyInMinutes);
            }
        }
    }

    public DeviceMetricsCollector(Context context) {
        this.applicationContext = context;
    }

    public Long getTotalMemoryInMegaBytes() {
        try {
            ActivityManager activityManager = (ActivityManager) this.applicationContext.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Long.valueOf(byteToMBytes(memoryInfo.totalMem));
        } catch (Exception e) {
            ADLog.logAgentError("Unable to retrieve total memory info", e);
            return null;
        }
    }

    public Long getAvailableMemoryInMegaBytes() {
        try {
            ActivityManager activityManager = (ActivityManager) this.applicationContext.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Long.valueOf(byteToMBytes(memoryInfo.availMem));
        } catch (Exception e) {
            ADLog.logAgentError("Unable to retrieve available memory info", e);
            return null;
        }
    }

    public Long getTotalDiskSpaceInMegaBytes() {
        try {
            return Long.valueOf(byteToMBytes(new StatFs(Environment.getDataDirectory().toString()).getTotalBytes()));
        } catch (RuntimeException e) {
            ADLog.logAgentError("Unable to retrieve total disk space info", e);
            return null;
        }
    }

    public Long getAvailableDiskSpaceInMegaBytes() {
        try {
            return Long.valueOf(byteToMBytes(new StatFs(Environment.getDataDirectory().toString()).getAvailableBytes()));
        } catch (RuntimeException e) {
            ADLog.logAgentError("Unable to retrieve available disk space info", e);
            return null;
        }
    }

    public Double getTotalBatteryCapacity() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        try {
            objNewInstance = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(this.applicationContext);
        } catch (Exception e) {
            ADLog.logAgentError("Unable to set power profile", e);
            objNewInstance = null;
        }
        try {
            return (Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(objNewInstance, "battery.capacity");
        } catch (Exception e2) {
            e2.printStackTrace();
            ADLog.logAgentError("Unable to retrieve battery capacity", e2);
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
    }

    public Integer getBatteryLevel() {
        try {
            Intent intentRegisterReceiver = this.applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                ADLog.logAgentError("Unable to retrieve battery level");
                return 0;
            }
            return Integer.valueOf(intentRegisterReceiver.getIntExtra("level", -1));
        } catch (Exception e) {
            ADLog.logAgentError("Unable to retrieve battery level", e);
            return null;
        }
    }

    public Boolean getChargingState() {
        try {
            Intent intentRegisterReceiver = this.applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                ADLog.logAgentError("Unable to retrieve charging state");
                return Boolean.FALSE;
            }
            return Boolean.valueOf(intentRegisterReceiver.getIntExtra("status", -1) == 2);
        } catch (Exception e) {
            ADLog.logAgentError("Unable to retrieve charging state", e);
            return null;
        }
    }

    public Boolean getPowerMode() {
        try {
            return Boolean.valueOf(((PowerManager) this.applicationContext.getSystemService("power")).isPowerSaveMode());
        } catch (Exception unused) {
            ADLog.logAgentError("Unable to retrieve battery power mode");
            return Boolean.FALSE;
        }
    }

    public Boolean shouldCollectStorageDeviceSpecification() {
        Boolean bool = this.configurationManager.a.k;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Boolean shouldCollectBatteryDeviceSpecification() {
        Boolean bool = this.configurationManager.a.l;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Boolean shouldCollectMemoryDeviceSpecification() {
        Boolean bool = this.configurationManager.a.j;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public static long byteToMBytes(long j) {
        return j / 1048576;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ak populateDeviceMetricsEvent() {
        ak.a aVar = new ak.a();
        Long availableDiskSpaceInMegaBytes = getAvailableDiskSpaceInMegaBytes();
        Long availableMemoryInMegaBytes = getAvailableMemoryInMegaBytes();
        Integer batteryLevel = getBatteryLevel();
        Boolean chargingState = getChargingState();
        Boolean powerMode = getPowerMode();
        Boolean bool = this.configurationManager.a.k;
        if (bool != null ? bool.booleanValue() : false) {
            Long totalDiskSpaceInMegaBytes = getTotalDiskSpaceInMegaBytes();
            if (availableDiskSpaceInMegaBytes != null && totalDiskSpaceInMegaBytes != null) {
                Double dValueOf = Double.valueOf((availableDiskSpaceInMegaBytes.doubleValue() / totalDiskSpaceInMegaBytes.doubleValue()) * 100.0d);
                Integer num = this.configurationManager.a.p;
                int iIntValue = num != null ? num.intValue() : 90;
                int iIntValue2 = 100 - dValueOf.intValue();
                Integer numValueOf = Integer.valueOf(iIntValue2);
                if (iIntValue2 >= iIntValue && iIntValue2 >= 0 && iIntValue2 <= 100) {
                    aVar.b = numValueOf;
                }
            }
        }
        Boolean bool2 = this.configurationManager.a.j;
        if (bool2 != null ? bool2.booleanValue() : false) {
            Long totalMemoryInMegaBytes = getTotalMemoryInMegaBytes();
            if (availableMemoryInMegaBytes != null && totalMemoryInMegaBytes != null) {
                Double dValueOf2 = Double.valueOf((getAvailableMemoryInMegaBytes().doubleValue() / getTotalMemoryInMegaBytes().doubleValue()) * 100.0d);
                Integer num2 = this.configurationManager.a.n;
                int iIntValue3 = num2 != null ? num2.intValue() : 90;
                int iIntValue4 = 100 - dValueOf2.intValue();
                Integer numValueOf2 = Integer.valueOf(iIntValue4);
                if (iIntValue4 >= iIntValue3 && iIntValue4 >= 0 && iIntValue4 <= 100) {
                    aVar.a = numValueOf2;
                }
            }
        }
        Boolean bool3 = this.configurationManager.a.l;
        if (bool3 != null ? bool3.booleanValue() : false) {
            if (batteryLevel != null) {
                int iIntValue5 = batteryLevel.intValue();
                Integer num3 = this.configurationManager.a.o;
                if (iIntValue5 <= 100 - (num3 != null ? num3.intValue() : 90)) {
                    aVar.c = Integer.valueOf(100 - batteryLevel.intValue());
                }
            }
            if (chargingState != this.currentChargingState || chargingState.booleanValue()) {
                this.currentChargingState = chargingState;
                aVar.d = chargingState;
            }
            if (powerMode != this.currentPowerState || powerMode.booleanValue()) {
                this.currentPowerState = powerMode;
                aVar.e = powerMode;
            }
        }
        aVar.f = this.applicationContext;
        ak akVar = new ak();
        akVar.i = aVar.a;
        akVar.j = aVar.b;
        akVar.k = aVar.c;
        akVar.l = aVar.d;
        akVar.m = aVar.e;
        akVar.n = aVar.f;
        return akVar;
    }
}
