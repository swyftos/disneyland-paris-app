package com.allegion.altranslation;

import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toByteArray", "", "Ljava/util/UUID;", "toUUID", "AlTranslation_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlUUIDUtilityKt {
    @NotNull
    public static final UUID toUUID(@NotNull byte[] toUUID) {
        Intrinsics.checkParameterIsNotNull(toUUID, "$this$toUUID");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(toUUID);
        Intrinsics.checkExpressionValueIsNotNull(byteBufferWrap, "ByteBuffer.wrap(this)");
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull UUID toByteArray) {
        Intrinsics.checkParameterIsNotNull(toByteArray, "$this$toByteArray");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        Intrinsics.checkExpressionValueIsNotNull(byteBufferWrap, "ByteBuffer.wrap(ByteArray(16))");
        byteBufferWrap.putLong(toByteArray.getMostSignificantBits());
        byteBufferWrap.putLong(toByteArray.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkExpressionValueIsNotNull(bArrArray, "bb.array()");
        return bArrArray;
    }
}
