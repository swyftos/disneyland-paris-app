package com.allegion.accessnfccredential.enums;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0080\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse;", "", "bytes", "", "(Ljava/lang/String;I[B)V", "getBytes", "()[B", "toByteArray", "NONE", "ACCESS_UNKNOWN", "ACCESS_GRANTED", "ACCESS_DENIED", "ERROR", "Companion", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAPDUVerifyResponse {
    private static final /* synthetic */ AlAPDUVerifyResponse[] $VALUES;
    public static final AlAPDUVerifyResponse ACCESS_DENIED;
    public static final AlAPDUVerifyResponse ACCESS_GRANTED;
    public static final AlAPDUVerifyResponse ACCESS_UNKNOWN;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AlAPDUVerifyResponse ERROR;
    public static final AlAPDUVerifyResponse NONE;

    @NotNull
    private final byte[] bytes;

    public static AlAPDUVerifyResponse valueOf(String str) {
        return (AlAPDUVerifyResponse) Enum.valueOf(AlAPDUVerifyResponse.class, str);
    }

    public static AlAPDUVerifyResponse[] values() {
        return (AlAPDUVerifyResponse[]) $VALUES.clone();
    }

    private AlAPDUVerifyResponse(String str, int i, byte[] bArr) {
        this.bytes = bArr;
    }

    @NotNull
    public final byte[] getBytes() {
        return this.bytes;
    }

    static {
        byte[] bArrDecode = Hex.decode("0000");
        Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "Hex.decode(\"0000\")");
        AlAPDUVerifyResponse alAPDUVerifyResponse = new AlAPDUVerifyResponse("NONE", 0, bArrDecode);
        NONE = alAPDUVerifyResponse;
        byte[] bArrDecode2 = Hex.decode("0001");
        Intrinsics.checkExpressionValueIsNotNull(bArrDecode2, "Hex.decode(\"0001\")");
        AlAPDUVerifyResponse alAPDUVerifyResponse2 = new AlAPDUVerifyResponse("ACCESS_UNKNOWN", 1, bArrDecode2);
        ACCESS_UNKNOWN = alAPDUVerifyResponse2;
        byte[] bArrDecode3 = Hex.decode("0002");
        Intrinsics.checkExpressionValueIsNotNull(bArrDecode3, "Hex.decode(\"0002\")");
        AlAPDUVerifyResponse alAPDUVerifyResponse3 = new AlAPDUVerifyResponse("ACCESS_GRANTED", 2, bArrDecode3);
        ACCESS_GRANTED = alAPDUVerifyResponse3;
        byte[] bArrDecode4 = Hex.decode("0003");
        Intrinsics.checkExpressionValueIsNotNull(bArrDecode4, "Hex.decode(\"0003\")");
        AlAPDUVerifyResponse alAPDUVerifyResponse4 = new AlAPDUVerifyResponse("ACCESS_DENIED", 3, bArrDecode4);
        ACCESS_DENIED = alAPDUVerifyResponse4;
        byte[] bArrDecode5 = Hex.decode("0004");
        Intrinsics.checkExpressionValueIsNotNull(bArrDecode5, "Hex.decode(\"0004\")");
        AlAPDUVerifyResponse alAPDUVerifyResponse5 = new AlAPDUVerifyResponse("ERROR", 4, bArrDecode5);
        ERROR = alAPDUVerifyResponse5;
        $VALUES = new AlAPDUVerifyResponse[]{alAPDUVerifyResponse, alAPDUVerifyResponse2, alAPDUVerifyResponse3, alAPDUVerifyResponse4, alAPDUVerifyResponse5};
        INSTANCE = new Companion(null);
    }

    @NotNull
    public final byte[] toByteArray() {
        return this.bytes;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse$Companion;", "", "()V", "fromByteArray", "Lcom/allegion/accessnfccredential/enums/AlAPDUVerifyResponse;", "value", "", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AlAPDUVerifyResponse fromByteArray(@NotNull byte[] value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            for (AlAPDUVerifyResponse alAPDUVerifyResponse : AlAPDUVerifyResponse.values()) {
                if (Arrays.equals(alAPDUVerifyResponse.getBytes(), value)) {
                    return alAPDUVerifyResponse;
                }
            }
            return null;
        }
    }
}
