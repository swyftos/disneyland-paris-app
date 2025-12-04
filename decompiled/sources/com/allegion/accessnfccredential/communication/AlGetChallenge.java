package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.accessnfccredential.enums.AlAPDUProtocolVersion;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.logging.AlLog;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlGetChallenge;", "Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "rawMessage", "", "([B)V", "locationID", "getLocationID", "()[B", AlCBORMessage.NONCE, "getNonce", "response", "getResponse", "setResponse", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlGetChallenge extends AlAPDUMessage {

    @NotNull
    private final byte[] locationID;

    @NotNull
    private final byte[] nonce;

    @Nullable
    private byte[] response;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlGetChallenge(@NotNull byte[] rawMessage) throws AlNFCComponentException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        byte[] bArr = new byte[16];
        this.nonce = bArr;
        try {
            AlAPDUProtocolVersion alAPDUProtocolVersionFromInt = AlAPDUProtocolVersion.INSTANCE.fromInt(getParser().getCdata()[0]);
            if (alAPDUProtocolVersionFromInt == null) {
                Intrinsics.throwNpe();
            }
            setProtocolVersion$AccessNFCCredential_release(alAPDUProtocolVersionFromInt);
            try {
                this.locationID = ArraysKt.sliceArray(getParser().getCdata(), new IntRange(1, 3));
                new SecureRandom().nextBytes(bArr);
                AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
                alNFCConfigUtility.setRandomAndroid(new byte[16]);
                new SecureRandom().nextBytes(alNFCConfigUtility.getRandomAndroid());
            } catch (Exception unused) {
                throw new AlNFCComponentException("Site ID is invalid or missing.");
            }
        } catch (Exception unused2) {
            throw new AlNFCComponentException("Security Version is invalid or missing.");
        }
    }

    @NotNull
    public final byte[] getLocationID() {
        return this.locationID;
    }

    @NotNull
    public final byte[] getNonce() {
        return this.nonce;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    public void setResponse(@Nullable byte[] bArr) {
        this.response = bArr;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    @Nullable
    public byte[] getResponse() throws AlNFCComponentException {
        try {
            AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
            SecretKey diversifiedKey = alNFCConfigUtility.getDiversifiedKey();
            if (diversifiedKey != null) {
                byte[] randomAndroid = alNFCConfigUtility.getRandomAndroid();
                if (randomAndroid != null) {
                    SecretKey diversifiedKeyInput = alNFCConfigUtility.getDiversifiedKeyInput();
                    if (diversifiedKeyInput != null) {
                        AlLog.d("(Nonce, Random Number): " + Hex.toHexString(this.nonce) + ", " + Hex.toHexString(alNFCConfigUtility.getRandomAndroid()), new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("diversifiedKeyInput: ");
                        sb.append(Hex.toHexString(diversifiedKeyInput.getEncoded()));
                        AlLog.d(sb.toString(), new Object[0]);
                        byte[] bArrEncrypt = new AlAes().encrypt(diversifiedKey, ArraysKt.plus(this.nonce, randomAndroid), AlPaddingType.NO_PADDING, new byte[16]);
                        byte[] encoded = diversifiedKeyInput.getEncoded();
                        Intrinsics.checkExpressionValueIsNotNull(encoded, "kdDiv.encoded");
                        return ArraysKt.plus(ArraysKt.plus(bArrEncrypt, encoded), AlAPDUResponse.INSTANCE.getSuccess());
                    }
                    throw new AlNFCComponentException("Unable to get diversified key input");
                }
                throw new AlNFCComponentException("Unable to get random number");
            }
            throw new AlNFCComponentException("Unable to get diversified key");
        } catch (Exception e) {
            AlLog.d("ERROR: " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
