package com.allegion.accessnfccredential.communication;

import com.allegion.accessnfccredential.enums.AlAPDUProtocolVersion;
import com.allegion.accessnfccredential.exception.AlAPDUMessageValidationException;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u0004¨\u0006%"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlAPDUMessage;", "", "rawMessage", "", "([B)V", "cdata", "getCdata", "()[B", "cla", "", "getCla", "()B", "ins", "getIns", "lc", "", "getLc", "()I", "le", "getLe", "p1", "getP1", "p2", "getP2", "parser", "Lcom/allegion/accessnfccredential/utility/AlAPDUParser;", "getParser$AccessNFCCredential_release", "()Lcom/allegion/accessnfccredential/utility/AlAPDUParser;", "protocolVersion", "Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;", "getProtocolVersion$AccessNFCCredential_release", "()Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;", "setProtocolVersion$AccessNFCCredential_release", "(Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;)V", "response", "getResponse", "setResponse", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class AlAPDUMessage {

    @NotNull
    private final AlAPDUParser parser;

    @NotNull
    private AlAPDUProtocolVersion protocolVersion;

    @Nullable
    private byte[] response;

    @NotNull
    /* renamed from: getParser$AccessNFCCredential_release, reason: from getter */
    public final AlAPDUParser getParser() {
        return this.parser;
    }

    @NotNull
    /* renamed from: getProtocolVersion$AccessNFCCredential_release, reason: from getter */
    public final AlAPDUProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    public final void setProtocolVersion$AccessNFCCredential_release(@NotNull AlAPDUProtocolVersion alAPDUProtocolVersion) {
        Intrinsics.checkParameterIsNotNull(alAPDUProtocolVersion, "<set-?>");
        this.protocolVersion = alAPDUProtocolVersion;
    }

    @Nullable
    public byte[] getResponse() {
        return this.response;
    }

    public void setResponse(@Nullable byte[] bArr) {
        this.response = bArr;
    }

    public final byte getCla() {
        return this.parser.getCla();
    }

    public final byte getIns() {
        return this.parser.getIns();
    }

    public final byte getP1() {
        return this.parser.getP1();
    }

    public final byte getP2() {
        return this.parser.getP2();
    }

    public final int getLc() {
        return this.parser.getLc();
    }

    @NotNull
    public final byte[] getCdata() {
        return this.parser.getCdata();
    }

    public final int getLe() {
        return this.parser.getLe();
    }

    public AlAPDUMessage(@NotNull byte[] rawMessage) throws AlNFCComponentException {
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        this.protocolVersion = AlAPDUProtocolVersion.SCHLAGE_ACCESS;
        try {
            this.parser = new AlAPDUParser(rawMessage);
        } catch (AlAPDUMessageValidationException e) {
            throw new AlNFCComponentException(e);
        }
    }
}
