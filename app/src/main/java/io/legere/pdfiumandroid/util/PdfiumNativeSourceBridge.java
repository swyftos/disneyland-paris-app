package io.legere.pdfiumandroid.util;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfiumSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lio/legere/pdfiumandroid/util/PdfiumNativeSourceBridge;", "", "source", "Lio/legere/pdfiumandroid/PdfiumSource;", "<init>", "(Lio/legere/pdfiumandroid/PdfiumSource;)V", "buffer", "", "read", "", ViewProps.POSITION, "", TCEventPropertiesNames.TCP_SIZE, "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPdfiumNativeSourceBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PdfiumNativeSourceBridge.kt\nio/legere/pdfiumandroid/util/PdfiumNativeSourceBridge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class PdfiumNativeSourceBridge {

    @Nullable
    private byte[] buffer;

    @NotNull
    private final PdfiumSource source;

    public PdfiumNativeSourceBridge(@NotNull PdfiumSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final int read(long position, long size) {
        try {
            if (size > 2147483647L) {
                throw new IllegalArgumentException("size is too large");
            }
            int i = (int) size;
            byte[] bArr = this.buffer;
            if (bArr == null || bArr.length < size) {
                bArr = new byte[i];
                this.buffer = bArr;
            }
            int i2 = this.source.read(position, bArr, i);
            if (i2 <= 0) {
                return 0;
            }
            return i2;
        } catch (Throwable th) {
            Logger.INSTANCE.mo1819e("PdfiumNativeSourceBridge", th, "read failed");
            return 0;
        }
    }
}
