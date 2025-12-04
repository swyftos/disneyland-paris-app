package com.allegion.accessblecredential.controllers;

import android.content.Context;
import com.allegion.accessblecredential.ble.CredentialBLEDevice;
import com.allegion.accessblecredential.ble.CredentialDeviceScanner;
import com.allegion.core.exception.BleException;
import com.allegion.core.scanning.BleScanner;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B\t\b\u0016¢\u0006\u0004\b*\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020\u001c¢\u0006\u0004\b*\u0010.J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR4\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0018R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/allegion/accessblecredential/controllers/AlBLEController;", "Lcom/allegion/core/scanning/BleScanner$BleScanListener;", "Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner$BleScannerDevicesListener;", "", "startScanner", "()V", "", "scanTime", "(I)V", "clearBleDevices", "stopScanner", "onStopScan", "Lcom/allegion/core/exception/BleException;", "except", "onStartScan", "(Lcom/allegion/core/exception/BleException;)V", "Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "device", "exception", "onAllegionDeviceFound", "(Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;Lcom/allegion/core/exception/BleException;)V", "Ljava/util/ArrayList;", "list", "resetRssiValues", "(Ljava/util/ArrayList;)V", "", "deviceIsStored", "(Ljava/util/ArrayList;Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;)Z", "Lcom/allegion/accessblecredential/controllers/AlBLEController$IBleControllerListener;", "bleControllerListener", "Lcom/allegion/accessblecredential/controllers/AlBLEController$IBleControllerListener;", "getBleDevices", "()Ljava/util/ArrayList;", "setBleDevices", "bleDevices", "credentialBleDevices", "Ljava/util/ArrayList;", "SCAN_TIME_IN_SECONDS", "I", "Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner;", "mBleScanner", "Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner;", "<init>", "Landroid/content/Context;", "context", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/content/Context;Lcom/allegion/accessblecredential/controllers/AlBLEController$IBleControllerListener;)V", "IBleControllerListener", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlBLEController implements BleScanner.BleScanListener, CredentialDeviceScanner.BleScannerDevicesListener {
    private final int SCAN_TIME_IN_SECONDS;
    private IBleControllerListener bleControllerListener;
    private ArrayList<CredentialBLEDevice> credentialBleDevices;
    private CredentialDeviceScanner mBleScanner;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/allegion/accessblecredential/controllers/AlBLEController$IBleControllerListener;", "", "Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "device", "", "onNewDeviceFound", "(Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;)V", "", "isScanning", "onScanningStateChanged", "(Z)V", "Lcom/allegion/core/exception/BleException;", "except", PDFView.EVENT_ON_ERROR, "(Lcom/allegion/core/exception/BleException;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
    public interface IBleControllerListener {
        void onError(@NotNull BleException except);

        void onNewDeviceFound(@NotNull CredentialBLEDevice device);

        void onScanningStateChanged(boolean isScanning);
    }

    public AlBLEController() {
        this.SCAN_TIME_IN_SECONDS = 3;
        this.credentialBleDevices = new ArrayList<>();
    }

    public final void clearBleDevices() {
        ArrayList<CredentialBLEDevice> arrayList = this.credentialBleDevices;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final boolean deviceIsStored(@NotNull ArrayList<CredentialBLEDevice> list, @NotNull CredentialBLEDevice device) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Intrinsics.checkParameterIsNotNull(device, "device");
        if (!list.contains(device)) {
            return false;
        }
        list.get(list.indexOf(device)).setRssiSearchValue(device.getRssiSearchValue());
        return true;
    }

    @Nullable
    public final ArrayList<CredentialBLEDevice> getBleDevices() {
        return this.credentialBleDevices;
    }

    @Override // com.allegion.accessblecredential.ble.CredentialDeviceScanner.BleScannerDevicesListener
    public void onAllegionDeviceFound(@NotNull CredentialBLEDevice device, @Nullable BleException exception) {
        Intrinsics.checkParameterIsNotNull(device, "device");
        if (exception != null) {
            AlLog.i("Exception - %s", exception.toString());
            return;
        }
        ArrayList<CredentialBLEDevice> bleDevices = getBleDevices();
        if (bleDevices == null) {
            Intrinsics.throwNpe();
        }
        bleDevices.add(device);
        IBleControllerListener iBleControllerListener = this.bleControllerListener;
        if (iBleControllerListener != null) {
            iBleControllerListener.onNewDeviceFound(device);
        }
    }

    @Override // com.allegion.core.scanning.BleScanner.BleScanListener
    public void onStartScan(@Nullable BleException except) {
        if (except != null) {
            stopScanner();
            IBleControllerListener iBleControllerListener = this.bleControllerListener;
            if (iBleControllerListener != null) {
                iBleControllerListener.onError(except);
            }
            AlLog.i("Exception - %s", except.toString());
        }
        IBleControllerListener iBleControllerListener2 = this.bleControllerListener;
        if (iBleControllerListener2 != null) {
            iBleControllerListener2.onScanningStateChanged(true);
        }
        AlLog.i("Scan Started", new Object[0]);
    }

    @Override // com.allegion.core.scanning.BleScanner.BleScanListener
    public void onStopScan() {
        AlLog.i("Scan Stopped", new Object[0]);
        IBleControllerListener iBleControllerListener = this.bleControllerListener;
        if (iBleControllerListener != null) {
            iBleControllerListener.onScanningStateChanged(false);
        }
    }

    public final void resetRssiValues(@NotNull ArrayList<CredentialBLEDevice> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Iterator<CredentialBLEDevice> it = list.iterator();
        while (it.hasNext()) {
            it.next().setRssiSearchValue(0);
        }
    }

    public final void setBleDevices(@Nullable ArrayList<CredentialBLEDevice> arrayList) {
        ArrayList<CredentialBLEDevice> arrayList2 = this.credentialBleDevices;
        if (arrayList2 == null) {
            Intrinsics.throwNpe();
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        arrayList2.addAll(arrayList);
    }

    public final void startScanner() {
        CredentialDeviceScanner credentialDeviceScanner = this.mBleScanner;
        if (credentialDeviceScanner == null) {
            Intrinsics.throwNpe();
        }
        credentialDeviceScanner.startScan(this.SCAN_TIME_IN_SECONDS);
    }

    public final void stopScanner() {
        CredentialDeviceScanner credentialDeviceScanner = this.mBleScanner;
        if (credentialDeviceScanner == null) {
            Intrinsics.throwNpe();
        }
        credentialDeviceScanner.lambda$new$2();
    }

    public final void startScanner(int scanTime) {
        clearBleDevices();
        CredentialDeviceScanner credentialDeviceScanner = this.mBleScanner;
        if (credentialDeviceScanner == null) {
            Intrinsics.throwNpe();
        }
        credentialDeviceScanner.startScan(scanTime);
    }

    public AlBLEController(@NotNull Context context, @NotNull IBleControllerListener listener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.SCAN_TIME_IN_SECONDS = 3;
        CredentialDeviceScanner credentialDeviceScanner = new CredentialDeviceScanner(context);
        this.mBleScanner = credentialDeviceScanner;
        credentialDeviceScanner.setOnBleScanListener(this);
        CredentialDeviceScanner credentialDeviceScanner2 = this.mBleScanner;
        if (credentialDeviceScanner2 == null) {
            Intrinsics.throwNpe();
        }
        credentialDeviceScanner2.setBleScannerDevicesListener(this);
        this.bleControllerListener = listener;
        this.credentialBleDevices = new ArrayList<>();
    }
}
