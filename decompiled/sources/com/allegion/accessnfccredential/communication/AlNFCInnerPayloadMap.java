package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086.¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlNFCInnerPayloadMap;", "", "()V", "credNonce", "", "getCredNonce", "()[B", "setCredNonce", "([B)V", "diversifiedKey", "getDiversifiedKey", "setDiversifiedKey", "diversifiedKeyInput", "getDiversifiedKeyInput", "setDiversifiedKeyInput", "encCardData", "getEncCardData", "setEncCardData", AlCBORMessage.SIGNATURES, "", "Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "getSignatures", "()[Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "setSignatures", "([Lcom/allegion/accessnfccredential/communication/AlSignatureMap;)V", "[Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlNFCInnerPayloadMap {

    @NotNull
    public byte[] credNonce;

    @NotNull
    public byte[] diversifiedKey;

    @NotNull
    public byte[] diversifiedKeyInput;

    @NotNull
    public byte[] encCardData;

    @NotNull
    public AlSignatureMap[] signatures;

    @NotNull
    public final byte[] getCredNonce() {
        byte[] bArr = this.credNonce;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credNonce");
        }
        return bArr;
    }

    public final void setCredNonce(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.credNonce = bArr;
    }

    @NotNull
    public final byte[] getDiversifiedKey() {
        byte[] bArr = this.diversifiedKey;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("diversifiedKey");
        }
        return bArr;
    }

    public final void setDiversifiedKey(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.diversifiedKey = bArr;
    }

    @NotNull
    public final byte[] getDiversifiedKeyInput() {
        byte[] bArr = this.diversifiedKeyInput;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("diversifiedKeyInput");
        }
        return bArr;
    }

    public final void setDiversifiedKeyInput(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.diversifiedKeyInput = bArr;
    }

    @NotNull
    public final byte[] getEncCardData() {
        byte[] bArr = this.encCardData;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("encCardData");
        }
        return bArr;
    }

    public final void setEncCardData(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.encCardData = bArr;
    }

    @NotNull
    public final AlSignatureMap[] getSignatures() {
        AlSignatureMap[] alSignatureMapArr = this.signatures;
        if (alSignatureMapArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.SIGNATURES);
        }
        return alSignatureMapArr;
    }

    public final void setSignatures(@NotNull AlSignatureMap[] alSignatureMapArr) {
        Intrinsics.checkParameterIsNotNull(alSignatureMapArr, "<set-?>");
        this.signatures = alSignatureMapArr;
    }
}
