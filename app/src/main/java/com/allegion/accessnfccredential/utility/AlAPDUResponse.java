package com.allegion.accessnfccredential.utility;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m1836d2 = {"Lcom/allegion/accessnfccredential/utility/AlAPDUResponse;", "", "()V", "Companion", "AccessNFCCredential_release"}, m1837k = 1, m1838mv = {1, 1, 15})
public final class AlAPDUResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m1836d2 = {"Lcom/allegion/accessnfccredential/utility/AlAPDUResponse$Companion;", "", "()V", "getError", "", "getSuccess", "AccessNFCCredential_release"}, m1837k = 1, m1838mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final byte[] getSuccess() {
            byte[] bArrDecode = Hex.decode("9000");
            Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "Hex.decode(\"9000\")");
            return bArrDecode;
        }

        @NotNull
        public final byte[] getError() {
            byte[] bArrDecode = Hex.decode("90AE");
            Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "Hex.decode(\"90AE\")");
            return bArrDecode;
        }
    }
}
