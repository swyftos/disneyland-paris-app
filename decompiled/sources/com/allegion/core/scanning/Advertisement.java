package com.allegion.core.scanning;

import androidx.annotation.NonNull;
import com.allegion.core.enums.AlBLEDeviceType;
import com.allegion.core.enums.ProtocolBlockType;
import com.allegion.core.enums.SapphireStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class Advertisement {
    private static final int COMPANY_BYTE1 = 0;
    private static final int COMPANY_BYTE2 = 1;
    private static final byte DYNAMIC_MTU_BIT = -128;
    private static final int FIRST_PROTOCOL_LENGTH_BYTE = 5;
    private static final int FIRST_PROTOCOL_START_BYTE = 7;
    private static final int MODEL_BYTE1 = 3;
    private static final int MODEL_BYTE2 = 4;
    private static final int PROTOCOL_VERSION_BYTE_16 = 1;
    private static final int PROTOCOL_VERSION_BYTE_2 = 1;
    private static final int SECURITYVERSION_BYTE = 6;
    private static final int STATE_COMMISSIONED = 2;
    private static final int STATE_FDR = 1;
    private static final int STATE_UNCONNECTED = 3;
    private static final int STATUS_BYTE = 5;
    private static final int STATUS_BYTE_VERSION_16 = 0;
    private static final int STATUS_BYTE_VERSION_2 = 0;
    private static final int VERSION_BYTE = 2;
    private byte[] companyData;
    private String name;
    private byte[] serialNumber;
    private Boolean isDynamicMtuSupported = null;
    private List<UUID> uuids = new ArrayList();

    public boolean isAllegion() {
        byte[] bArr = this.companyData;
        return bArr != null && bArr.length > 1 && bArr[0] == 59 && bArr[1] == 1;
    }

    public int getVersion() {
        byte[] bArr = this.companyData;
        if (bArr == null || bArr.length <= 2) {
            return -1;
        }
        return bArr[2];
    }

    public AlBLEDeviceType getDeviceType() {
        byte[] bArr = this.companyData;
        if (bArr == null || bArr.length <= 4) {
            return AlBLEDeviceType.UNKNOWN;
        }
        return AlBLEDeviceType.fromByteArray(new byte[]{bArr[3], bArr[4]});
    }

    @Deprecated
    private int getState() {
        return getState(1, null);
    }

    private int getState(ProtocolBlockType protocolBlockType) {
        return getState(getVersion(), protocolBlockType);
    }

    private int getState(int i, ProtocolBlockType protocolBlockType) {
        if (i == 1) {
            byte[] bArr = this.companyData;
            if (bArr == null || bArr.length <= 5) {
                return -1;
            }
            return bArr[5];
        }
        if (i == 2) {
            byte[] protocolBlock = getProtocolBlock(protocolBlockType);
            if (protocolBlock == null || protocolBlock.length <= 0) {
                return -1;
            }
            return protocolBlock[0];
        }
        byte[] protocolBlock2 = getProtocolBlock(protocolBlockType);
        if (protocolBlock2 == null || protocolBlock2.length <= 0) {
            return -1;
        }
        return protocolBlock2[0];
    }

    @Deprecated
    public int getSecurityVersion() {
        return getSecurityVersion(1, null);
    }

    public int getSecurityVersion(ProtocolBlockType protocolBlockType) {
        return getSecurityVersion(getVersion(), protocolBlockType);
    }

    private int getSecurityVersion(int i, ProtocolBlockType protocolBlockType) {
        if (i == 1) {
            byte[] bArr = this.companyData;
            if (bArr == null || bArr.length <= 6) {
                return -1;
            }
            return bArr[6];
        }
        if (i == 2) {
            byte[] protocolBlock = getProtocolBlock(protocolBlockType);
            if (protocolBlock == null || protocolBlock.length <= 1) {
                return -1;
            }
            return protocolBlockType == ProtocolBlockType.ENGAGE ? extractDynamicMtuBit(protocolBlock[1]) : protocolBlock[1];
        }
        byte[] protocolBlock2 = getProtocolBlock(protocolBlockType);
        if (protocolBlock2 == null || protocolBlock2.length <= 1) {
            return -1;
        }
        return protocolBlockType == ProtocolBlockType.ENGAGE ? extractDynamicMtuBit(protocolBlock2[1]) : protocolBlock2[1];
    }

    public byte[] getSerialNumber() {
        byte[] bArr = this.serialNumber;
        return bArr == null ? new byte[0] : bArr;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    protected void setCompanyData(byte[] bArr) {
        this.companyData = bArr;
    }

    protected void addUUID(UUID uuid) {
        this.uuids.add(uuid);
    }

    protected void setSerialNumber(byte[] bArr) {
        this.serialNumber = bArr;
    }

    protected void setName(String str) {
        this.name = str;
    }

    @Deprecated
    public boolean isUnconnected() {
        return getState() == 3;
    }

    @Deprecated
    public boolean isCommissioned() {
        return getState() == 2;
    }

    @Deprecated
    public boolean isFDR() {
        return getState() == 1;
    }

    public boolean isUnconnected(ProtocolBlockType protocolBlockType) {
        return getState(protocolBlockType) == 3;
    }

    public boolean isCommissioned(ProtocolBlockType protocolBlockType) {
        return getState(protocolBlockType) == 2;
    }

    public boolean isFDR(ProtocolBlockType protocolBlockType) {
        return getState(protocolBlockType) == 1;
    }

    private byte[] getProtocolBlock(ProtocolBlockType protocolBlockType) {
        if (this.companyData.length > 7 && protocolBlockType != null) {
            int i = 5;
            while (true) {
                byte[] bArr = this.companyData;
                if (i >= bArr.length) {
                    break;
                }
                int i2 = i + 1;
                byte b = bArr[i];
                if (b == 0) {
                    break;
                }
                int i3 = i + 2;
                if (bArr[i2] == protocolBlockType.getValue()) {
                    return Arrays.copyOfRange(this.companyData, i3, (b + i3) - 1);
                }
                i = i3 + (b - 1);
            }
        }
        return null;
    }

    public boolean isProtocolBlockPresent(@NonNull ProtocolBlockType protocolBlockType) {
        return getProtocolBlock(protocolBlockType) != null;
    }

    public SapphireStatus getSapphireStatus(ProtocolBlockType protocolBlockType) {
        if (protocolBlockType == ProtocolBlockType.SAPPHIRE) {
            return SapphireStatus.INSTANCE.valueOf(getState(protocolBlockType));
        }
        return null;
    }

    private byte extractDynamicMtuBit(byte b) {
        Boolean boolValueOf = Boolean.valueOf((b & (-128)) != 0);
        this.isDynamicMtuSupported = boolValueOf;
        return boolValueOf.booleanValue() ? (byte) (b ^ (-128)) : b;
    }

    public boolean isDynamicMtuSupported(ProtocolBlockType protocolBlockType) {
        if (this.isDynamicMtuSupported == null) {
            getSecurityVersion(getVersion(), protocolBlockType);
        }
        Boolean bool = this.isDynamicMtuSupported;
        return bool != null && bool.booleanValue();
    }
}
