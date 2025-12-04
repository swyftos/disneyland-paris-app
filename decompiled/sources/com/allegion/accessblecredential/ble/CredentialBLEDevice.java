package com.allegion.accessblecredential.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.core.AllegionBleDevice;
import com.allegion.core.enums.AlBLEDeviceType;
import com.allegion.core.enums.ProtocolBlockType;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B1\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0012\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-BI\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0012\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b,\u0010.B\u0011\b\u0012\u0012\u0006\u0010/\u001a\u00020\u0006¢\u0006\u0004\b,\u00100J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%¨\u00062"}, d2 = {"Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "Lcom/allegion/core/AllegionBleDevice;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/EnumSet;", "Lcom/allegion/core/enums/ProtocolBlockType;", "deviceFeatures", "Ljava/util/EnumSet;", "getDeviceFeatures", "()Ljava/util/EnumSet;", "Landroid/bluetooth/BluetoothDevice;", "<set-?>", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "rssiSearchValue", "I", "getRssiSearchValue", "setRssiSearchValue", "(I)V", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "deviceProtocolVersion", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "getDeviceProtocolVersion", "()Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "", "isShortRange", "Z", "()Z", "device", "", "serial", "Lcom/allegion/core/enums/AlBLEDeviceType;", "deviceType", "rssi", "<init>", "(Landroid/bluetooth/BluetoothDevice;[BLcom/allegion/core/enums/AlBLEDeviceType;ILcom/allegion/accessblecredential/enums/AlProtocolVersion;)V", "(Landroid/bluetooth/BluetoothDevice;[BLcom/allegion/core/enums/AlBLEDeviceType;ILjava/util/EnumSet;Lcom/allegion/accessblecredential/enums/AlProtocolVersion;Z)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class CredentialBLEDevice extends AllegionBleDevice implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private BluetoothDevice bluetoothDevice;

    @NotNull
    private final EnumSet<ProtocolBlockType> deviceFeatures;

    @NotNull
    private final AlProtocolVersion deviceProtocolVersion;
    private final boolean isShortRange;
    private int rssiSearchValue;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessblecredential/ble/CredentialBLEDevice$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "", TCEventPropertiesNames.TCP_SIZE, "", "newArray", "(I)[Lcom/allegion/accessblecredential/ble/CredentialBLEDevice;", "<init>", "()V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.allegion.accessblecredential.ble.CredentialBLEDevice$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<CredentialBLEDevice> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CredentialBLEDevice createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new CredentialBLEDevice(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CredentialBLEDevice[] newArray(int size) {
            return new CredentialBLEDevice[size];
        }
    }

    public /* synthetic */ CredentialBLEDevice(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    @NotNull
    public final EnumSet<ProtocolBlockType> getDeviceFeatures() {
        return this.deviceFeatures;
    }

    @NotNull
    public final AlProtocolVersion getDeviceProtocolVersion() {
        return this.deviceProtocolVersion;
    }

    public final int getRssiSearchValue() {
        return this.rssiSearchValue;
    }

    /* renamed from: isShortRange, reason: from getter */
    public final boolean getIsShortRange() {
        return this.isShortRange;
    }

    public final void setRssiSearchValue(int i) {
        this.rssiSearchValue = i;
    }

    @Override // com.allegion.core.AllegionBleDevice, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeInt(this.rssiSearchValue);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CredentialBLEDevice(@NotNull BluetoothDevice device, @NotNull byte[] serial, @NotNull AlBLEDeviceType deviceType, int i, @NotNull AlProtocolVersion deviceProtocolVersion) {
        Intrinsics.checkParameterIsNotNull(device, "device");
        Intrinsics.checkParameterIsNotNull(serial, "serial");
        Intrinsics.checkParameterIsNotNull(deviceType, "deviceType");
        Intrinsics.checkParameterIsNotNull(deviceProtocolVersion, "deviceProtocolVersion");
        EnumSet enumSetNoneOf = EnumSet.noneOf(ProtocolBlockType.class);
        Intrinsics.checkExpressionValueIsNotNull(enumSetNoneOf, "EnumSet.noneOf(ProtocolBlockType::class.java)");
        this(device, serial, deviceType, i, enumSetNoneOf, deviceProtocolVersion, false, 64, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialBLEDevice(@NotNull BluetoothDevice device, @NotNull byte[] serial, @NotNull AlBLEDeviceType deviceType, int i, @NotNull EnumSet<ProtocolBlockType> deviceFeatures, @NotNull AlProtocolVersion deviceProtocolVersion, boolean z) {
        super(device.getName(), device.getAddress(), serial, deviceType);
        Intrinsics.checkParameterIsNotNull(device, "device");
        Intrinsics.checkParameterIsNotNull(serial, "serial");
        Intrinsics.checkParameterIsNotNull(deviceType, "deviceType");
        Intrinsics.checkParameterIsNotNull(deviceFeatures, "deviceFeatures");
        Intrinsics.checkParameterIsNotNull(deviceProtocolVersion, "deviceProtocolVersion");
        this.bluetoothDevice = device;
        this.rssiSearchValue = i;
        this.deviceFeatures = deviceFeatures;
        this.deviceProtocolVersion = deviceProtocolVersion;
        this.isShortRange = z;
    }

    public /* synthetic */ CredentialBLEDevice(BluetoothDevice bluetoothDevice, byte[] bArr, AlBLEDeviceType alBLEDeviceType, int i, EnumSet enumSet, AlProtocolVersion alProtocolVersion, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bluetoothDevice, bArr, alBLEDeviceType, i, enumSet, alProtocolVersion, (i2 & 64) != 0 ? false : z);
    }

    private CredentialBLEDevice(Parcel parcel) {
        super(parcel);
        EnumSet<ProtocolBlockType> enumSetNoneOf = EnumSet.noneOf(ProtocolBlockType.class);
        Intrinsics.checkExpressionValueIsNotNull(enumSetNoneOf, "EnumSet.noneOf(ProtocolBlockType::class.java)");
        this.deviceFeatures = enumSetNoneOf;
        this.deviceProtocolVersion = AlProtocolVersion.PLATINUM_V1;
        this.isShortRange = false;
    }
}
