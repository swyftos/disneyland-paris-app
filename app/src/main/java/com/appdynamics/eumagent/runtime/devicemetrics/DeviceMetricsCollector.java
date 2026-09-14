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
import com.appdynamics.eumagent.runtime.p192private.C2061ak;
import com.appdynamics.eumagent.runtime.p192private.C2063am;
import com.appdynamics.eumagent.runtime.p192private.C2138q;
import com.disney.p026id.android.tracker.OneIDTracker;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceMetricsCollector {
    private Context applicationContext;
    private C2138q configurationManager;
    private Boolean currentChargingState;
    private Integer currentCollectionFrequencyInMinutes;
    private Boolean currentPowerState;
    private C2063am eventBus;

    public DeviceMetricsCollector(C2138q c2138q, Context context, C2063am c2063am) {
        this.applicationContext = context;
        this.configurationManager = c2138q;
        this.eventBus = c2063am;
        Integer num = c2138q.f902a.f918m;
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 2);
        this.currentCollectionFrequencyInMinutes = numValueOf;
        this.currentChargingState = null;
        this.currentPowerState = null;
        scheduleAndRunCollection(numValueOf);
        ADLog.logInfo("Device Metrics system initialized");
    }

    public DeviceMetricsCollector(C2138q c2138q, Context context) {
        this.applicationContext = context;
        this.configurationManager = c2138q;
        Integer num = c2138q.f902a.f918m;
        this.currentCollectionFrequencyInMinutes = Integer.valueOf(num != null ? num.intValue() : 2);
        this.currentChargingState = null;
        this.currentPowerState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAndRunCollection(Integer num) {
        new Timer().scheduleAtFixedRate(new C2049a(this, (byte) 0), 0L, num.intValue() * OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector$a */
    class C2049a extends TimerTask {
        private C2049a() {
        }

        /* synthetic */ C2049a(DeviceMetricsCollector deviceMetricsCollector, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            DeviceMetricsCollector.this.eventBus.m562a(DeviceMetricsCollector.this.populateDeviceMetricsEvent());
            Integer num = DeviceMetricsCollector.this.configurationManager.f902a.f918m;
            if ((num != null ? num.intValue() : 2) != DeviceMetricsCollector.this.currentCollectionFrequencyInMinutes.intValue()) {
                if (!cancel()) {
                    ADLog.logAgentError("Failed to reschedule device metrics resource consumption task");
                    return;
                }
                DeviceMetricsCollector deviceMetricsCollector = DeviceMetricsCollector.this;
                Integer num2 = deviceMetricsCollector.configurationManager.f902a.f918m;
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

    public Double getTotalBatteryCapacity() {
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
        Boolean bool = this.configurationManager.f902a.f916k;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Boolean shouldCollectBatteryDeviceSpecification() {
        Boolean bool = this.configurationManager.f902a.f917l;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Boolean shouldCollectMemoryDeviceSpecification() {
        Boolean bool = this.configurationManager.f902a.f915j;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public static long byteToMBytes(long j) {
        return j / 1048576;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2061ak populateDeviceMetricsEvent() {
        C2061ak.a aVar = new C2061ak.a();
        Long availableDiskSpaceInMegaBytes = getAvailableDiskSpaceInMegaBytes();
        Long availableMemoryInMegaBytes = getAvailableMemoryInMegaBytes();
        Integer batteryLevel = getBatteryLevel();
        Boolean chargingState = getChargingState();
        Boolean powerMode = getPowerMode();
        Boolean bool = this.configurationManager.f902a.f916k;
        if (bool != null ? bool.booleanValue() : false) {
            Long totalDiskSpaceInMegaBytes = getTotalDiskSpaceInMegaBytes();
            if (availableDiskSpaceInMegaBytes != null && totalDiskSpaceInMegaBytes != null) {
                Double dValueOf = Double.valueOf((availableDiskSpaceInMegaBytes.doubleValue() / totalDiskSpaceInMegaBytes.doubleValue()) * 100.0d);
                Integer num = this.configurationManager.f902a.f921p;
                int iIntValue = num != null ? num.intValue() : 90;
                int iIntValue2 = 100 - dValueOf.intValue();
                Integer numValueOf = Integer.valueOf(iIntValue2);
                if (iIntValue2 >= iIntValue && iIntValue2 >= 0 && iIntValue2 <= 100) {
                    aVar.f527b = numValueOf;
                }
            }
        }
        Boolean bool2 = this.configurationManager.f902a.f915j;
        if (bool2 != null ? bool2.booleanValue() : false) {
            Long totalMemoryInMegaBytes = getTotalMemoryInMegaBytes();
            if (availableMemoryInMegaBytes != null && totalMemoryInMegaBytes != null) {
                Double dValueOf2 = Double.valueOf((getAvailableMemoryInMegaBytes().doubleValue() / getTotalMemoryInMegaBytes().doubleValue()) * 100.0d);
                Integer num2 = this.configurationManager.f902a.f919n;
                int iIntValue3 = num2 != null ? num2.intValue() : 90;
                int iIntValue4 = 100 - dValueOf2.intValue();
                Integer numValueOf2 = Integer.valueOf(iIntValue4);
                if (iIntValue4 >= iIntValue3 && iIntValue4 >= 0 && iIntValue4 <= 100) {
                    aVar.f526a = numValueOf2;
                }
            }
        }
        Boolean bool3 = this.configurationManager.f902a.f917l;
        if (bool3 != null ? bool3.booleanValue() : false) {
            if (batteryLevel != null) {
                int iIntValue5 = batteryLevel.intValue();
                Integer num3 = this.configurationManager.f902a.f920o;
                if (iIntValue5 <= 100 - (num3 != null ? num3.intValue() : 90)) {
                    aVar.f528c = Integer.valueOf(100 - batteryLevel.intValue());
                }
            }
            if (chargingState != this.currentChargingState || chargingState.booleanValue()) {
                this.currentChargingState = chargingState;
                aVar.f529d = chargingState;
            }
            if (powerMode != this.currentPowerState || powerMode.booleanValue()) {
                this.currentPowerState = powerMode;
                aVar.f530e = powerMode;
            }
        }
        aVar.f531f = this.applicationContext;
        C2061ak c2061ak = new C2061ak();
        c2061ak.f520i = aVar.f526a;
        c2061ak.f521j = aVar.f527b;
        c2061ak.f522k = aVar.f528c;
        c2061ak.f523l = aVar.f529d;
        c2061ak.f524m = aVar.f530e;
        c2061ak.f525n = aVar.f531f;
        return c2061ak;
    }
}
