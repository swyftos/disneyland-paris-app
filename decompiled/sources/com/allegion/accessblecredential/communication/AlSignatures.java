package com.allegion.accessblecredential.communication;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlSignatures;", "", "", AlCBORMessage.KEY_ID, "Ljava/lang/String;", "getKeyId", "()Ljava/lang/String;", "setKeyId", "(Ljava/lang/String;)V", "", AlCBORMessage.SIGNATURE, "[B", "getSignature", "()[B", "setSignature", "([B)V", "<init>", "()V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlSignatures {

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

    @NotNull
    public final byte[] getSignature() {
        byte[] bArr = this.signature;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.SIGNATURE);
        }
        return bArr;
    }

    public final void setKeyId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.keyId = str;
    }

    public final void setSignature(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.signature = bArr;
    }
}
