package com.allegion.accessnfccredential.communication;

import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.AlCMAC;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.logging.AlLog;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlGetData;", "Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "rawMessage", "", "payload", "Lcom/allegion/accessnfccredential/communication/AlNFCPayload;", "([BLcom/allegion/accessnfccredential/communication/AlNFCPayload;)V", "response", "getResponse", "()[B", "setResponse", "([B)V", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlGetData extends AlAPDUMessage {
    private final AlNFCPayload payload;

    @Nullable
    private byte[] response;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlGetData(@NotNull byte[] rawMessage, @NotNull AlNFCPayload payload) {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        this.payload = payload;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    public void setResponse(@Nullable byte[] bArr) {
        this.response = bArr;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    @Nullable
    public byte[] getResponse() throws AlNFCComponentException {
        try {
            SecretKey sessionKey = AlNFCConfigUtility.INSTANCE.getSessionKey();
            if (sessionKey != null) {
                byte[] bArrEncrypt = new AlAes().encrypt(sessionKey, this.payload.getCredential$AccessNFCCredential_release(), AlPaddingType.NO_PADDING, new byte[16]);
                return ArraysKt.plus(ArraysKt.plus(bArrEncrypt, new AlCMAC(sessionKey).sign(bArrEncrypt)), AlAPDUResponse.INSTANCE.getSuccess());
            }
            throw new AlNFCComponentException("Unable to get session key.");
        } catch (Exception e) {
            AlLog.d("ERROR: " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
