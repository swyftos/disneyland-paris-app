package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2632T6 {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Logger f2153c = new Logger("StoredBatch");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f2154a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final byte[] f2155b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T6$a */
    public static final class a {
        /* JADX INFO: renamed from: a */
        public static int m1036a(@NotNull byte[] bytes, int i) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return (bytes[i + 3] & 255) | ((bytes[i] & 255) << 24) | ((bytes[i + 1] & 255) << 16) | ((bytes[i + 2] & 255) << 8);
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public static String m1037b(@NotNull byte[] bytes, int i) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            byte[] bArr = new byte[i];
            System.arraycopy(bytes, 8, bArr, 0, i);
            return new String(bArr, Charsets.UTF_8);
        }
    }

    public C2632T6(@NotNull String batchUrl, @NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(batchUrl, "batchUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f2154a = batchUrl;
        this.f2155b = data;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final byte[] m1035a() {
        byte[] bytes = this.f2154a.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        int length2 = this.f2155b.length;
        int i = length + 12;
        byte[] bArr = new byte[i + length2];
        System.arraycopy(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1}, 0, bArr, 0, 4);
        System.arraycopy(new byte[]{(byte) (length >> 24), (byte) (length >> 16), (byte) (length >> 8), (byte) length}, 0, bArr, 4, 4);
        System.arraycopy(bytes, 0, bArr, 8, length);
        System.arraycopy(new byte[]{(byte) (length2 >> 24), (byte) (length2 >> 16), (byte) (length2 >> 8), (byte) length2}, 0, bArr, length + 8, 4);
        System.arraycopy(this.f2155b, 0, bArr, i, length2);
        return bArr;
    }
}
