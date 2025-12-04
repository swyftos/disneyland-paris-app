package com.allegion.accessnfccredential.enums;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUByte;", "", "kind", "", "index", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIndex", "()I", "getKind", "()Ljava/lang/String;", "toInt", "toString", "CLA", "INS", "P1", "P2", "Lc", "CData", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlAPDUByte {
    CLA("Class", 0),
    INS("Instruction", 1),
    P1("Parameter 1", 2),
    P2("Parameter 2", 3),
    Lc("Length of Nc", 4),
    CData("Command Data", 5);

    private final int index;

    @NotNull
    private final String kind;

    AlAPDUByte(String str, int i) {
        this.kind = str;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getKind() {
        return this.kind;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.kind;
    }

    public final int toInt() {
        return this.index;
    }
}
