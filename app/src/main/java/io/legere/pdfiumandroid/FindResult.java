package io.legere.pdfiumandroid;

import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u0011J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m1836d2 = {"Lio/legere/pdfiumandroid/FindResult;", "Ljava/io/Closeable;", "handle", "", "Lio/legere/pdfiumandroid/FindHandle;", "<init>", "(J)V", "getHandle", "()J", "nativeFindNext", "", "findHandle", "nativeFindPrev", "nativeGetSchResultIndex", "", "nativeGetSchCount", "nativeCloseFind", "", "findNext", "findPrev", "getSchResultIndex", "getSchCount", "closeFind", ReactMessageView.EVENT_CLOSE, "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FindResult implements Closeable {
    private final long handle;

    private final native void nativeCloseFind(long findHandle);

    private final native boolean nativeFindNext(long findHandle);

    private final native boolean nativeFindPrev(long findHandle);

    private final native int nativeGetSchCount(long findHandle);

    private final native int nativeGetSchResultIndex(long findHandle);

    public FindResult(long j) {
        this.handle = j;
    }

    public final long getHandle() {
        return this.handle;
    }

    public final boolean findNext() {
        boolean zNativeFindNext;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            zNativeFindNext = nativeFindNext(this.handle);
        }
        return zNativeFindNext;
    }

    public final boolean findPrev() {
        boolean zNativeFindPrev;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            zNativeFindPrev = nativeFindPrev(this.handle);
        }
        return zNativeFindPrev;
    }

    public final int getSchResultIndex() {
        int iNativeGetSchResultIndex;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetSchResultIndex = nativeGetSchResultIndex(this.handle);
        }
        return iNativeGetSchResultIndex;
    }

    public final int getSchCount() {
        int iNativeGetSchCount;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetSchCount = nativeGetSchCount(this.handle);
        }
        return iNativeGetSchCount;
    }

    public final void closeFind() {
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeCloseFind(this.handle);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeCloseFind(this.handle);
    }
}
