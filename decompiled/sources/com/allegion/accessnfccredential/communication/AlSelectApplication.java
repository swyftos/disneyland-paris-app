package com.allegion.accessnfccredential.communication;

import com.allegion.accessnfccredential.exception.AlAPDUMessageValidationException;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlSelectApplication;", "Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "rawMessage", "", "([B)V", "applicationID", "getApplicationID", "()[B", "aptiQApplicationID", "kotlin.jvm.PlatformType", "response", "getResponse", "setResponse", "schlageApplicationID", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlSelectApplication extends AlAPDUMessage {

    @NotNull
    private final byte[] applicationID;
    private final byte[] aptiQApplicationID;

    @Nullable
    private byte[] response;
    private final byte[] schlageApplicationID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlSelectApplication(@NotNull byte[] rawMessage) throws AlNFCComponentException, AlAPDUMessageValidationException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        this.aptiQApplicationID = Hex.decode("F04F29421848D736");
        byte[] schlageApplicationID = Hex.decode("A0000008400000000000000000001234");
        this.schlageApplicationID = schlageApplicationID;
        this.applicationID = getCdata();
        this.response = AlAPDUResponse.INSTANCE.getSuccess();
        byte[] cdata = getParser().getCdata();
        Intrinsics.checkExpressionValueIsNotNull(schlageApplicationID, "schlageApplicationID");
        if (!Arrays.equals(cdata, schlageApplicationID)) {
            throw new AlNFCComponentException("Application ID is invalid or missing.");
        }
    }

    @NotNull
    public final byte[] getApplicationID() {
        return this.applicationID;
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
}
