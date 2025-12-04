package com.allegion.accessnfccredential.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;", "", "int", "", "(Ljava/lang/String;II)V", "getInt", "()I", "toInt", "APTIQ", "SCHLAGE_ACCESS", "Companion", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlAPDUProtocolVersion {
    APTIQ(0),
    SCHLAGE_ACCESS(1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int int;

    AlAPDUProtocolVersion(int i) {
        this.int = i;
    }

    public final int getInt() {
        return this.int;
    }

    public final int toInt() {
        return this.int;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion$Companion;", "", "()V", "fromInt", "Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;", "value", "", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AlAPDUProtocolVersion fromInt(int value) {
            for (AlAPDUProtocolVersion alAPDUProtocolVersion : AlAPDUProtocolVersion.values()) {
                if (alAPDUProtocolVersion.getInt() == value) {
                    return alAPDUProtocolVersion;
                }
            }
            return null;
        }
    }
}
