package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Beta
/* loaded from: classes4.dex */
public interface PrimitiveSink {
    @CanIgnoreReturnValue
    PrimitiveSink putBoolean(boolean z);

    @CanIgnoreReturnValue
    PrimitiveSink putByte(byte b);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr, int i, int i2);

    @CanIgnoreReturnValue
    PrimitiveSink putChar(char c);

    @CanIgnoreReturnValue
    PrimitiveSink putDouble(double d);

    @CanIgnoreReturnValue
    PrimitiveSink putFloat(float f);

    @CanIgnoreReturnValue
    PrimitiveSink putInt(int i);

    @CanIgnoreReturnValue
    PrimitiveSink putLong(long j);

    @CanIgnoreReturnValue
    PrimitiveSink putShort(short s);

    @CanIgnoreReturnValue
    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
