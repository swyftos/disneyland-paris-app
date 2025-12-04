package com.contentsquare.android.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/utils/GzipUtil;", "", "()V", "compress", "", "content", "byteArrayOutputStream", "Ljava/io/ByteArrayOutputStream;", "decompress", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGzipUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipUtil.kt\ncom/contentsquare/android/core/utils/GzipUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
/* loaded from: classes2.dex */
public final class GzipUtil {

    @NotNull
    public static final GzipUtil INSTANCE = new GzipUtil();

    private GzipUtil() {
    }

    public static /* synthetic */ byte[] compress$default(GzipUtil gzipUtil, byte[] bArr, ByteArrayOutputStream byteArrayOutputStream, int i, Object obj) {
        if ((i & 2) != 0) {
            byteArrayOutputStream = new ByteArrayOutputStream();
        }
        return gzipUtil.compress(bArr, byteArrayOutputStream);
    }

    @NotNull
    public final byte[] compress(byte[] content, ByteArrayOutputStream byteArrayOutputStream) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(byteArrayOutputStream, "byteArrayOutputStream");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(content);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
            CloseableKt.closeFinally(gZIPOutputStream, null);
            return byteArray;
        } finally {
        }
    }

    @NotNull
    public final byte[] decompress(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(content));
        try {
            byte[] bytes = ByteStreamsKt.readBytes(gZIPInputStream);
            CloseableKt.closeFinally(gZIPInputStream, null);
            return bytes;
        } finally {
        }
    }
}
