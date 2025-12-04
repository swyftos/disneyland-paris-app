package com.allegion.accessnfccredential.enums;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUParameterKey;", "", "kind", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKind", "()Ljava/lang/String;", "toString", "APPLICATION_ID", "DEACTIVATION_REASON", "LOCATION_ID", "PAYLOAD", "PROTOCOL_VERSION", "VERIFY_STATUS", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlAPDUParameterKey {
    APPLICATION_ID("Application ID"),
    DEACTIVATION_REASON("Deactivation Reason"),
    LOCATION_ID("Location ID"),
    PAYLOAD("Payload"),
    PROTOCOL_VERSION("Protocol Version"),
    VERIFY_STATUS("Verify Status");


    @NotNull
    private final String kind;

    AlAPDUParameterKey(String str) {
        this.kind = str;
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
}
