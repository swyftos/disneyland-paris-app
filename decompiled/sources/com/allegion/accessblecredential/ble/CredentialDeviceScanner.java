package com.allegion.accessblecredential.ble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.allegion.accessblecredential.ble.CredentialDeviceScanner;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.core.enums.AlBLEDeviceType;
import com.allegion.core.enums.ProtocolBlockType;
import com.allegion.core.enums.SapphireStatus;
import com.allegion.core.exception.BleException;
import com.allegion.core.operations.support.HexConverter;
import com.allegion.core.scanning.Advertisement;
import com.allegion.core.scanning.BleScanner;
import com.allegion.logging.AlLog;
import java.util.EnumSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner;", "Lcom/allegion/core/scanning/BleScanner;", "Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner$BleScannerDevicesListener;", "scannerDevicesListener", "", "setBleScannerDevicesListener", "(Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner$BleScannerDevicesListener;)V", "Landroid/bluetooth/BluetoothDevice;", "device", "", "rssi", "", "scanRecord", "Lcom/allegion/core/scanning/Advertisement;", "advert", "onLeScan", "(Landroid/bluetooth/BluetoothDevice;I[BLcom/allegion/core/scanning/Advertisement;)V", "ADVERT_VERSION_2", "I", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "bleScannerDevicesListener", "Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner$BleScannerDevicesListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "BleScannerDevicesListener", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class CredentialDeviceScanner extends BleScanner {
    private final int ADVERT_VERSION_2;
    private BleScannerDevicesListener bleScannerDevicesListener;
    private final ReentrantLock lock;

    @FunctionalInterface
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/allegion/accessblecredential/ble/CredentialDeviceScanner$BleScannerDevicesListener;", "", "Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "device", "Lcom/allegion/core/exception/BleException;", "exception", "", "onAllegionDeviceFound", "(Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;Lcom/allegion/core/exception/BleException;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
    public interface BleScannerDevicesListener {
        void onAllegionDeviceFound(@NotNull CredentialBLEDevice device, @Nullable BleException exception);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialDeviceScanner(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.ADVERT_VERSION_2 = 2;
        this.lock = new ReentrantLock();
    }

    @Override // com.allegion.core.scanning.BleScanner
    public void onLeScan(@NotNull BluetoothDevice device, int rssi, @NotNull byte[] scanRecord, @NotNull Advertisement advert) {
        Intrinsics.checkParameterIsNotNull(device, "device");
        Intrinsics.checkParameterIsNotNull(scanRecord, "scanRecord");
        Intrinsics.checkParameterIsNotNull(advert, "advert");
        String strBytesToString = HexConverter.bytesToString(scanRecord);
        Intrinsics.checkExpressionValueIsNotNull(strBytesToString, "HexConverter.bytesToString(scanRecord)");
        AlLog.i(strBytesToString, new Object[0]);
        String name = device.getName();
        if (name == null) {
            name = "null";
        }
        AlLog.i(name, ": ", Integer.valueOf(rssi), "power");
        if (advert.isAllegion() && advert.getVersion() == this.ADVERT_VERSION_2 && advert.isProtocolBlockPresent(ProtocolBlockType.SAPPHIRE) && this.bleScannerDevicesListener != null) {
            EnumSet deviceFeatures = EnumSet.noneOf(ProtocolBlockType.class);
            for (ProtocolBlockType protocolBlockType : ProtocolBlockType.values()) {
                if (advert.getSecurityVersion(protocolBlockType) != -1) {
                    ProtocolBlockType protocolBlockType2 = ProtocolBlockType.SAPPHIRE;
                    if (!advert.isCommissioned(protocolBlockType2) && !advert.isFDR(protocolBlockType2)) {
                        deviceFeatures.add(protocolBlockType);
                    }
                }
            }
            ProtocolBlockType protocolBlockType3 = ProtocolBlockType.SAPPHIRE;
            boolean z = advert.getSapphireStatus(protocolBlockType3) == SapphireStatus.NEAR_CONNECTIONS;
            byte[] serialNumber = advert.getSerialNumber();
            Intrinsics.checkExpressionValueIsNotNull(serialNumber, "ad.serialNumber");
            AlBLEDeviceType deviceType = advert.getDeviceType();
            Intrinsics.checkExpressionValueIsNotNull(deviceType, "ad.deviceType");
            Intrinsics.checkExpressionValueIsNotNull(deviceFeatures, "deviceFeatures");
            int securityVersion = advert.getSecurityVersion(protocolBlockType3);
            AlProtocolVersion.values();
            final CredentialBLEDevice credentialBLEDevice = new CredentialBLEDevice(device, serialNumber, deviceType, rssi, deviceFeatures, securityVersion <= 3 ? AlProtocolVersion.values()[advert.getSecurityVersion(protocolBlockType3) - 1] : AlProtocolVersion.PLATINUM_V1, z);
            BleScanner.scannerHandler.post(new Runnable() { // from class: com.allegion.accessblecredential.ble.CredentialDeviceScanner$platinumDeviceFound$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.lock.lock();
                    try {
                        CredentialDeviceScanner.BleScannerDevicesListener bleScannerDevicesListener = this.this$0.bleScannerDevicesListener;
                        if (bleScannerDevicesListener != null) {
                            bleScannerDevicesListener.onAllegionDeviceFound(credentialBLEDevice, null);
                        }
                    } finally {
                        this.this$0.lock.unlock();
                    }
                }
            });
        }
    }

    public final void setBleScannerDevicesListener(@Nullable BleScannerDevicesListener scannerDevicesListener) {
        this.lock.lock();
        if (scannerDevicesListener != null) {
            try {
                this.bleScannerDevicesListener = scannerDevicesListener;
            } finally {
                this.lock.unlock();
            }
        }
    }
}
