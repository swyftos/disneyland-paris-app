package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.logging.AlLog;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlMutualAuthentication;", "Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "rawMessage", "", AlCBORMessage.NONCE, "([B[B)V", "decrypted", "response", "getResponse", "()[B", "setResponse", "([B)V", "generateSecurityCheckByteArray", "cdata", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlMutualAuthentication extends AlAPDUMessage {
    private final byte[] decrypted;

    @Nullable
    private byte[] response;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlMutualAuthentication(@NotNull byte[] rawMessage, @NotNull byte[] nonce) throws AlNFCComponentException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        Intrinsics.checkParameterIsNotNull(nonce, "nonce");
        try {
            AlAes alAes = new AlAes();
            AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
            SecretKey diversifiedKey = alNFCConfigUtility.getDiversifiedKey();
            if (diversifiedKey == null) {
                Intrinsics.throwNpe();
            }
            byte[] bArrDecrypt = alAes.decrypt(diversifiedKey, getParser().getCdata(), AlPaddingType.NO_PADDING, new byte[16]);
            this.decrypted = bArrDecrypt;
            byte[] bArrGenerateSecurityCheckByteArray = generateSecurityCheckByteArray(nonce, getParser().getCdata());
            if (Arrays.equals(ArraysKt.sliceArray(bArrDecrypt, new IntRange(0, 15)), nonce)) {
                throw new AlNFCComponentException("Nonces must be unique.");
            }
            if (Arrays.equals(ArraysKt.sliceArray(bArrDecrypt, new IntRange(16, 31)), bArrGenerateSecurityCheckByteArray)) {
                throw new AlNFCComponentException("Security check failed.");
            }
            byte[] bArrSliceArray = ArraysKt.sliceArray(bArrDecrypt, new IntRange(32, 47));
            byte[] randomAndroid = alNFCConfigUtility.getRandomAndroid();
            if (randomAndroid == null) {
                Intrinsics.throwNpe();
            }
            if (!Arrays.equals(bArrSliceArray, randomAndroid)) {
                throw new AlNFCComponentException("Random number sent to the device must be the same random number returned by the device.");
            }
            alNFCConfigUtility.setRandomDevice(ArraysKt.sliceArray(bArrDecrypt, new IntRange(16, 31)));
        } catch (Exception e) {
            throw new AlNFCComponentException("Failed to decrypt mutual authentication message.", e);
        }
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    public void setResponse(@Nullable byte[] bArr) {
        this.response = bArr;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    @Nullable
    public byte[] getResponse() {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append("(Nonce, Random Number): ");
            sb.append(Hex.toHexString(bArr));
            sb.append(", ");
            AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
            sb.append(Hex.toHexString(alNFCConfigUtility.getRandomDevice()));
            AlLog.d(sb.toString(), new Object[0]);
            AlAes alAes = new AlAes();
            SecretKey diversifiedKey = alNFCConfigUtility.getDiversifiedKey();
            if (diversifiedKey == null) {
                Intrinsics.throwNpe();
            }
            byte[] randomDevice = alNFCConfigUtility.getRandomDevice();
            if (randomDevice == null) {
                Intrinsics.throwNpe();
            }
            return ArraysKt.plus(alAes.encrypt(diversifiedKey, ArraysKt.plus(bArr, randomDevice), AlPaddingType.NO_PADDING, new byte[16]), AlAPDUResponse.INSTANCE.getSuccess());
        } catch (Exception e) {
            AlLog.d("ERROR: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    @NotNull
    public final byte[] generateSecurityCheckByteArray(@NotNull byte[] nonce, @NotNull byte[] cdata) throws AlNFCComponentException {
        Intrinsics.checkParameterIsNotNull(nonce, "nonce");
        Intrinsics.checkParameterIsNotNull(cdata, "cdata");
        if (nonce.length > cdata.length) {
            throw new AlNFCComponentException("Nonce should be smaller or equal in size to CData");
        }
        byte[] bArr = new byte[cdata.length];
        int length = nonce.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (nonce[i] ^ cdata[i]);
        }
        return bArr;
    }
}
