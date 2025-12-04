package com.allegion.accessnfccredential.communication;

import com.allegion.accessnfccredential.enums.AlAPDUVerifyResponse;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlVerify;", "Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "rawMessage", "", "([B)V", "response", "getResponse", "()[B", "setResponse", "status", "Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse;", "getStatus", "()Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse;", "setStatus", "(Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse;)V", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlVerify extends AlAPDUMessage {

    @Nullable
    private byte[] response;

    @NotNull
    private AlAPDUVerifyResponse status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlVerify(@NotNull byte[] rawMessage) throws AlNFCComponentException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        this.response = AlAPDUResponse.INSTANCE.getSuccess();
        this.status = AlAPDUVerifyResponse.NONE;
        try {
            AlAPDUVerifyResponse alAPDUVerifyResponseFromByteArray = AlAPDUVerifyResponse.INSTANCE.fromByteArray(getParser().getCdata());
            if (alAPDUVerifyResponseFromByteArray == null) {
                Intrinsics.throwNpe();
            }
            this.status = alAPDUVerifyResponseFromByteArray;
        } catch (Exception unused) {
            throw new AlNFCComponentException("Verify Status is invalid or missing.");
        }
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    @Nullable
    public byte[] getResponse() {
        return this.response;
    }

    @Override // com.allegion.accessnfccredential.communication.AlAPDUMessage
    public void setResponse(@Nullable byte[] bArr) {
        this.response = bArr;
    }

    @NotNull
    public final AlAPDUVerifyResponse getStatus() {
        return this.status;
    }

    public final void setStatus(@NotNull AlAPDUVerifyResponse alAPDUVerifyResponse) {
        Intrinsics.checkParameterIsNotNull(alAPDUVerifyResponse, "<set-?>");
        this.status = alAPDUVerifyResponse;
    }
}
