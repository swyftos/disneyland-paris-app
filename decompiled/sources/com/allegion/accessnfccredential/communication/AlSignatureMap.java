package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "", "()V", AlCBORMessage.KEY_ID, "", "getKeyId", "()Ljava/lang/String;", "setKeyId", "(Ljava/lang/String;)V", AlCBORMessage.SIGNATURE, "", "getSignature", "()[B", "setSignature", "([B)V", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlSignatureMap {

    @NotNull
    public String keyId;

    @NotNull
    public byte[] signature;

    @NotNull
    public final String getKeyId() {
        String str = this.keyId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.KEY_ID);
        }
        return str;
    }

    public final void setKeyId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.keyId = str;
    }

    @NotNull
    public final byte[] getSignature() {
        byte[] bArr = this.signature;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.SIGNATURE);
        }
        return bArr;
    }

    public final void setSignature(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.signature = bArr;
    }
}
