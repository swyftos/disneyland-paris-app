package com.allegion.accessblecredential.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.Handler;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener;
import com.allegion.core.exception.BleException;
import com.allegion.core.operations.BlePeripheral;
import com.allegion.core.operations.gatt.GattLookup;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001.\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010B\u001a\u00020!\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J%\u0010'\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0010¢\u0006\u0004\b%\u0010&J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!H\u0000¢\u0006\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020!8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010>R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010B\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010>\u001a\u0004\bC\u0010D\"\u0004\bE\u0010*R\"\u0010F\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u0011R\u0018\u0010J\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006R"}, d2 = {"Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;", "Lcom/allegion/core/operations/BlePeripheral;", "Lcom/allegion/accessblecredential/listeners/IAlBlePeripheralTransportListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setPeripheralTransportListener", "(Lcom/allegion/accessblecredential/listeners/IAlBlePeripheralTransportListener;)V", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "", "status", "onCharacteristicRead", "(Landroid/bluetooth/BluetoothGattCharacteristic;I)V", "onCharacteristicWrite", "onCharacteristicChanged", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "onServicesDiscovered", "(I)V", "Landroid/bluetooth/BluetoothGattDescriptor;", "descriptor", "onDescriptorWrite", "(Landroid/bluetooth/BluetoothGattDescriptor;I)V", "disconnected", "()V", "mtu", "onMtuChanged", "Lcom/allegion/core/exception/BleException;", "e", "connectFailed", "(Lcom/allegion/core/exception/BleException;)V", "Lcom/allegion/core/operations/gatt/GattLookup;", "getGattLookup", "()Lcom/allegion/core/operations/gatt/GattLookup;", "", "", "", "data", "writeCharacteristic$AccessBleCredential_release", "(Ljava/lang/String;Ljava/util/List;)V", "writeCharacteristic", "characteristicName", "writeNotificationDescriptorToLock$AccessBleCredential_release", "(Ljava/lang/String;)V", "writeNotificationDescriptorToLock", "peripheralTransportListener", "Lcom/allegion/accessblecredential/listeners/IAlBlePeripheralTransportListener;", "com/allegion/accessblecredential/ble/CredentialBLEPeripheral$noOpListener$1", "noOpListener", "Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral$noOpListener$1;", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "protocolVersion", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "getProtocolVersion", "()Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "setProtocolVersion", "(Lcom/allegion/accessblecredential/enums/AlProtocolVersion;)V", "Lkotlin/Function0;", "bleCredWorker", "Lkotlin/jvm/functions/Function0;", "TIME_OUT_DELAY", "I", "BLE_CREDENTIAL_DATA", "Ljava/lang/String;", "", "dataPackets", "Ljava/util/Iterator;", "serialNumber", "getSerialNumber", "()Ljava/lang/String;", "setSerialNumber", "mtuSize", "getMtuSize", "()I", "setMtuSize", "gattLookup", "Lcom/allegion/core/operations/gatt/GattLookup;", "Landroid/bluetooth/BluetoothDevice;", "device", "Landroid/content/Context;", "context", "<init>", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Lcom/allegion/accessblecredential/enums/AlProtocolVersion;Landroid/content/Context;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class CredentialBLEPeripheral extends BlePeripheral {
    private final String BLE_CREDENTIAL_DATA;
    private final int TIME_OUT_DELAY;
    private final Function0<Unit> bleCredWorker;
    private String characteristicName;
    private Iterator<byte[]> dataPackets;
    private GattLookup gattLookup;
    private int mtuSize;
    private final CredentialBLEPeripheral$noOpListener$1 noOpListener;
    private IAlBlePeripheralTransportListener peripheralTransportListener;

    @NotNull
    private AlProtocolVersion protocolVersion;

    @NotNull
    private String serialNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.allegion.accessblecredential.ble.CredentialBLEPeripheral$noOpListener$1, com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener] */
    public CredentialBLEPeripheral(@NotNull BluetoothDevice device, @NotNull String serialNumber, @NotNull AlProtocolVersion protocolVersion, @NotNull Context context) throws AlBleComponentException {
        super(device, context, false);
        Intrinsics.checkParameterIsNotNull(device, "device");
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        Intrinsics.checkParameterIsNotNull(protocolVersion, "protocolVersion");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.serialNumber = serialNumber;
        this.protocolVersion = protocolVersion;
        this.BLE_CREDENTIAL_DATA = "BleCredentialData";
        this.TIME_OUT_DELAY = 100000;
        this.characteristicName = "BleCredentialData";
        this.mtuSize = 247;
        this.bleCredWorker = new Function0<Unit>() { // from class: com.allegion.accessblecredential.ble.CredentialBLEPeripheral$bleCredWorker$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.this$0.disconnect(false);
                AlLog.d("Disconnect due to BLE timeout", new Object[0]);
                return Unit.INSTANCE;
            }
        };
        ?? r2 = new IAlBlePeripheralTransportListener() { // from class: com.allegion.accessblecredential.ble.CredentialBLEPeripheral$noOpListener$1
            @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
            public void onConnection() {
            }

            @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
            public void onConnectionFailed() {
            }

            @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
            public void onDataReceived(@NotNull byte[] data) throws AlBleComponentException {
                Intrinsics.checkParameterIsNotNull(data, "data");
            }

            @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
            public void onDisconnection() {
            }

            @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
            public void onException(@NotNull Exception e) {
                Intrinsics.checkParameterIsNotNull(e, "e");
            }
        };
        this.noOpListener = r2;
        this.peripheralTransportListener = r2;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader == null) {
                Intrinsics.throwNpe();
            }
            this.gattLookup = GattLookup.getInstance(classLoader.getResourceAsStream("res/raw/credential_gatt_profile.json"));
        } catch (Exception e) {
            AlLog.e(e, "The gatt profile was not loaded.", new Object[0]);
            throw new AlBleComponentException("The gatt profile was not loaded.", e);
        }
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void connectFailed(@NotNull BleException e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        AlLog.d("Connection failed", new Object[0]);
        try {
            setBleState(BlePeripheral.BleState.INITIAL);
            disconnect(false);
        } catch (Exception e2) {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener == null) {
                Intrinsics.throwNpe();
            }
            iAlBlePeripheralTransportListener.onException(e2);
        }
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void disconnected() {
        IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
        if (iAlBlePeripheralTransportListener == null) {
            Intrinsics.throwNpe();
        }
        iAlBlePeripheralTransportListener.onDisconnection();
        setBleState(BlePeripheral.BleState.INITIAL);
        AlLog.d("Disconnected connection to lock", new Object[0]);
    }

    @Override // com.allegion.core.operations.BlePeripheral
    @Nullable
    protected GattLookup getGattLookup() {
        return this.gattLookup;
    }

    public int getMtuSize() {
        return this.mtuSize;
    }

    @NotNull
    public final AlProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    @NotNull
    public final String getSerialNumber() {
        return this.serialNumber;
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void onCharacteristicChanged(@NotNull BluetoothGattCharacteristic characteristic) {
        Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
        try {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener == null) {
                Intrinsics.throwNpe();
            }
            byte[] value = characteristic.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "characteristic.value");
            iAlBlePeripheralTransportListener.onDataReceived(value);
        } catch (AlBleComponentException e) {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener2 = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener2 == null) {
                Intrinsics.throwNpe();
            }
            iAlBlePeripheralTransportListener2.onException(e);
        }
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void onCharacteristicRead(@NotNull BluetoothGattCharacteristic characteristic, int status) {
        Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
        AlLog.d("Characteristic read: ", characteristic.getValue());
        try {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener == null) {
                Intrinsics.throwNpe();
            }
            byte[] value = characteristic.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "characteristic.value");
            iAlBlePeripheralTransportListener.onDataReceived(value);
        } catch (AlBleComponentException e) {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener2 = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener2 == null) {
                Intrinsics.throwNpe();
            }
            iAlBlePeripheralTransportListener2.onException(e);
        }
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void onCharacteristicWrite(@NotNull BluetoothGattCharacteristic characteristic, int status) {
        Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
        Iterator<byte[]> it = this.dataPackets;
        if (it == null) {
            Intrinsics.throwNpe();
        }
        if (it.hasNext()) {
            Iterator<byte[]> it2 = this.dataPackets;
            if (it2 == null) {
                Intrinsics.throwNpe();
            }
            byte[] next = it2.next();
            if (writeCharacteristic(this.characteristicName, next, 1)) {
                AlLog.d("Write Characteristic: ", Hex.toHexString(next));
                AlLog.d("Successful write", new Object[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.allegion.accessblecredential.ble.CredentialBLEPeripheral$sam$java_lang_Runnable$0] */
    @Override // com.allegion.core.operations.BlePeripheral
    protected void onDescriptorWrite(@NotNull BluetoothGattDescriptor descriptor, int status) {
        Intrinsics.checkParameterIsNotNull(descriptor, "descriptor");
        Handler peripheralHandler = BlePeripheral.getPeripheralHandler();
        final Function0<Unit> function0 = this.bleCredWorker;
        if (function0 != null) {
            function0 = new Runnable() { // from class: com.allegion.accessblecredential.ble.CredentialBLEPeripheral$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkExpressionValueIsNotNull(function0.invoke(), "invoke(...)");
                }
            };
        }
        peripheralHandler.postDelayed((Runnable) function0, this.TIME_OUT_DELAY);
        try {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener == null) {
                Intrinsics.throwNpe();
            }
            byte[] value = descriptor.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "descriptor.value");
            iAlBlePeripheralTransportListener.onDataReceived(value);
        } catch (AlBleComponentException e) {
            IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener2 = this.peripheralTransportListener;
            if (iAlBlePeripheralTransportListener2 == null) {
                Intrinsics.throwNpe();
            }
            iAlBlePeripheralTransportListener2.onException(e);
        }
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void onMtuChanged(int mtu) {
        setMtuSize(mtu);
        IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener = this.peripheralTransportListener;
        if (iAlBlePeripheralTransportListener == null) {
            Intrinsics.throwNpe();
        }
        iAlBlePeripheralTransportListener.onConnection();
    }

    @Override // com.allegion.core.operations.BlePeripheral
    protected void onServicesDiscovered(int status) {
        AlLog.d("Services Discovered: ", Integer.valueOf(status));
        if (getGatt() != null) {
            setBleState(BlePeripheral.BleState.GATT_CONNECTED);
            getGatt().requestMtu(getMtuSize());
        }
    }

    public void setMtuSize(int i) {
        this.mtuSize = i;
    }

    public void setPeripheralTransportListener(@Nullable IAlBlePeripheralTransportListener listener) {
        if (listener == null) {
            this.peripheralTransportListener = this.noOpListener;
        } else {
            this.peripheralTransportListener = listener;
        }
    }

    public final void setProtocolVersion(@NotNull AlProtocolVersion alProtocolVersion) {
        Intrinsics.checkParameterIsNotNull(alProtocolVersion, "<set-?>");
        this.protocolVersion = alProtocolVersion;
    }

    public final void setSerialNumber(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.serialNumber = str;
    }

    public void writeCharacteristic$AccessBleCredential_release(@NotNull String characteristic, @NotNull List<byte[]> data) {
        Intrinsics.checkParameterIsNotNull(characteristic, "characteristic");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Iterator<byte[]> it = data.iterator();
        this.dataPackets = it;
        this.characteristicName = characteristic;
        if (it == null) {
            Intrinsics.throwNpe();
        }
        if (writeCharacteristic(characteristic, it.next(), 1)) {
            AlLog.d("Successful write", new Object[0]);
        } else {
            this.dataPackets = data.iterator();
        }
    }

    public final void writeNotificationDescriptorToLock$AccessBleCredential_release(@NotNull String characteristicName) {
        IAlBlePeripheralTransportListener iAlBlePeripheralTransportListener;
        Intrinsics.checkParameterIsNotNull(characteristicName, "characteristicName");
        if (writeNotificationDescriptor(characteristicName, true) || (iAlBlePeripheralTransportListener = this.peripheralTransportListener) == null) {
            return;
        }
        iAlBlePeripheralTransportListener.onConnectionFailed();
    }
}
