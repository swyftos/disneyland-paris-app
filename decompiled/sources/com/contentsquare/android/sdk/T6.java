package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class T6 {

    @NotNull
    public static final Logger c = new Logger("StoredBatch");

    @NotNull
    public final String a;

    @NotNull
    public final byte[] b;

    public static final class a {
        public static int a(@NotNull byte[] bytes, int i) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return (bytes[i + 3] & 255) | ((bytes[i] & 255) << 24) | ((bytes[i + 1] & 255) << 16) | ((bytes[i + 2] & 255) << 8);
        }

        @NotNull
        public static String b(@NotNull byte[] bytes, int i) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            byte[] bArr = new byte[i];
            System.arraycopy(bytes, 8, bArr, 0, i);
            return new String(bArr, Charsets.UTF_8);
        }
    }

    public T6(@NotNull String batchUrl, @NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(batchUrl, "batchUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = batchUrl;
        this.b = data;
    }

    @NotNull
    public final byte[] a() {
        byte[] bytes = this.a.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        int length2 = this.b.length;
        int i = length + 12;
        byte[] bArr = new byte[i + length2];
        System.arraycopy(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1}, 0, bArr, 0, 4);
        System.arraycopy(new byte[]{(byte) (length >> 24), (byte) (length >> 16), (byte) (length >> 8), (byte) length}, 0, bArr, 4, 4);
        System.arraycopy(bytes, 0, bArr, 8, length);
        System.arraycopy(new byte[]{(byte) (length2 >> 24), (byte) (length2 >> 16), (byte) (length2 >> 8), (byte) length2}, 0, bArr, length + 8, 4);
        System.arraycopy(this.b, 0, bArr, i, length2);
        return bArr;
    }
}
