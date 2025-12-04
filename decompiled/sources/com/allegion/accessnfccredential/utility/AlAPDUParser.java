package com.allegion.accessnfccredential.utility;

import com.allegion.accessnfccredential.enums.AlAPDUByte;
import com.allegion.accessnfccredential.exception.AlAPDUMessageValidationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/allegion/accessnfccredential/utility/AlAPDUParser;", "", "message", "", "([B)V", "cdata", "getCdata", "()[B", "cla", "", "getCla", "()B", "ins", "getIns", "lc", "", "getLc", "()I", "le", "getLe", "p1", "getP1", "p2", "getP2", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAPDUParser {
    private byte[] message;

    public AlAPDUParser(@NotNull byte[] message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        this.message = message;
    }

    public final byte getCla() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.CLA;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("CLA is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex()];
    }

    public final byte getIns() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.INS;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("INS is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex()];
    }

    public final byte getP1() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.P1;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("P1 is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex()];
    }

    public final byte getP2() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.P2;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("P2 is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex()];
    }

    public final int getLc() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.Lc;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("Lc is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex()];
    }

    @NotNull
    public final byte[] getCdata() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.CData;
        if (length < alAPDUByte.getIndex() + 1) {
            throw new AlAPDUMessageValidationException("CData is invalid or missing.");
        }
        return ArraysKt.sliceArray(this.message, new IntRange(alAPDUByte.getIndex(), (alAPDUByte.getIndex() + getLc()) - 1));
    }

    public final int getLe() throws AlAPDUMessageValidationException {
        int length = this.message.length;
        AlAPDUByte alAPDUByte = AlAPDUByte.CData;
        if (length < alAPDUByte.getIndex() + getLc()) {
            throw new AlAPDUMessageValidationException("Le is invalid or missing.");
        }
        return this.message[alAPDUByte.getIndex() + getLc()];
    }
}
