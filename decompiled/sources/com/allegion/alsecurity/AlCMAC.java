package com.allegion.alsecurity;

import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.logging.AlLog;
import java.math.BigInteger;
import java.util.Arrays;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/allegion/alsecurity/AlCMAC;", "", "key", "Ljavax/crypto/SecretKey;", "(Ljavax/crypto/SecretKey;)V", "iv", "", "createK", "k", "padMessage", "Lkotlin/Pair;", "", "message", "prepareMessage", "k1", "k2", "sign", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlCMAC {
    private static final int BLOCK_SIZE = 16;
    private static final byte PADDING = -128;
    private static final byte RB = -121;
    private final byte[] iv;
    private final SecretKey key;

    public AlCMAC(@NotNull SecretKey key) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.iv = new byte[16];
        this.key = key;
    }

    @NotNull
    public final byte[] sign(@NotNull byte[] message) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(message, "message");
        AlAes alAes = new AlAes();
        SecretKey secretKey = this.key;
        byte[] bArr = this.iv;
        byte[] bArrEncrypt = alAes.encrypt(secretKey, bArr, AlPaddingType.NO_PADDING, bArr);
        AlLog.d("K0: " + Hex.toHexString(bArrEncrypt), new Object[0]);
        byte[] bArrCreateK = createK(bArrEncrypt);
        AlLog.d("K1: " + Hex.toHexString(bArrCreateK), new Object[0]);
        byte[] bArrCreateK2 = createK(bArrCreateK);
        AlLog.d("K2: " + Hex.toHexString(bArrCreateK2), new Object[0]);
        byte[] bArrCopyOf = Arrays.copyOf(message, message.length);
        Intrinsics.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        byte[] bArrPrepareMessage = prepareMessage(bArrCopyOf, bArrCreateK, bArrCreateK2);
        byte[] bArrEncrypt2 = new byte[16];
        int length = (bArrPrepareMessage.length / 16) - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                byte[] bArrSliceArray = ArraysKt.sliceArray(bArrPrepareMessage, new IntRange(i * 16, (i2 * 16) - 1));
                for (int i3 = 0; i3 <= 15; i3++) {
                    bArrSliceArray[i3] = (byte) (bArrSliceArray[i3] ^ bArrEncrypt2[i3]);
                }
                bArrEncrypt2 = new AlAes().encrypt(this.key, bArrSliceArray, AlPaddingType.NO_PADDING, new byte[16]);
                if (i == length) {
                    break;
                }
                i = i2;
            }
        }
        AlLog.d("CMAC: " + Hex.toHexString(bArrEncrypt2), new Object[0]);
        return bArrEncrypt2;
    }

    private final byte[] createK(byte[] k) {
        byte[] newK = new BigInteger(k).shiftLeft(1).toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(newK, "newK");
        if (newK.length > 16) {
            ArraysKt.reverse(newK);
            newK = ArraysKt.sliceArray(newK, new IntRange(0, 15));
            ArraysKt.reverse(newK);
        }
        if (((byte) (k[0] & (-128))) == -128) {
            newK[15] = (byte) (newK[15] ^ RB);
        }
        Intrinsics.checkExpressionValueIsNotNull(newK, "newK");
        return newK;
    }

    private final byte[] prepareMessage(byte[] message, byte[] k1, byte[] k2) throws AlSecurityException {
        if (k1.length != 16 || k2.length != 16) {
            throw new AlSecurityException("Length must be 16 bytes.");
        }
        Pair<byte[], Boolean> pairPadMessage = padMessage(message);
        byte[] bArrComponent1 = pairPadMessage.component1();
        boolean zBooleanValue = pairPadMessage.component2().booleanValue();
        AlLog.d("Padded Message: " + Hex.toHexString(bArrComponent1), new Object[0]);
        if (!zBooleanValue) {
            int length = bArrComponent1.length - 16;
            int length2 = bArrComponent1.length - 1;
            if (length <= length2) {
                while (true) {
                    bArrComponent1[length] = (byte) (bArrComponent1[length] ^ k1[(length - bArrComponent1.length) + 16]);
                    if (length == length2) {
                        break;
                    }
                    length++;
                }
            }
            AlLog.d("Padded Message XORed with K1: " + Hex.toHexString(bArrComponent1), new Object[0]);
        } else {
            int length3 = bArrComponent1.length - 16;
            int length4 = bArrComponent1.length - 1;
            if (length3 <= length4) {
                while (true) {
                    bArrComponent1[length3] = (byte) (bArrComponent1[length3] ^ k2[(length3 - bArrComponent1.length) + 16]);
                    if (length3 == length4) {
                        break;
                    }
                    length3++;
                }
            }
            AlLog.d("Padded Message XORed with K2: " + Hex.toHexString(bArrComponent1), new Object[0]);
        }
        return bArrComponent1;
    }

    private final Pair<byte[], Boolean> padMessage(byte[] message) {
        int length = message.length % 16;
        int i = message.length != 0 ? length != 0 ? 16 - length : 0 : 16;
        if (i > 0) {
            message = ArraysKt.plus(new byte[i], message);
            message[0] = -128;
        }
        return new Pair<>(message, Boolean.valueOf(i > 0));
    }
}
