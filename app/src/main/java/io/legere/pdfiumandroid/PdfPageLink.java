package io.legere.pdfiumandroid;

import android.graphics.RectF;
import com.urbanairship.actions.ToastAction;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfPageLink;", "Ljava/io/Closeable;", "pageLinkPtr", "", "<init>", "(J)V", "countWebLinks", "", "getURL", "", ArrayContainsMatcher.INDEX_KEY, ToastAction.LENGTH_KEY, "countRects", "getRect", "Landroid/graphics/RectF;", "linkIndex", "rectIndex", "getTextRange", "Lkotlin/Pair;", ReactMessageView.EVENT_CLOSE, "", "Companion", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class PdfPageLink implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = PdfPageLink.class.getName();
    private final long pageLinkPtr;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeClosePageLink(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeCountRects(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeCountWebLinks(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float[] nativeGetRect(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int[] nativeGetTextRange(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeGetURL(long j, int i, int i2, byte[] bArr);

    public PdfPageLink(long j) {
        this.pageLinkPtr = j;
    }

    public final int countWebLinks() {
        int iNativeCountWebLinks;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeCountWebLinks = INSTANCE.nativeCountWebLinks(this.pageLinkPtr);
        }
        return iNativeCountWebLinks;
    }

    @Nullable
    public final String getURL(int index, int length) {
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                byte[] bArr = new byte[length * 2];
                if (INSTANCE.nativeGetURL(this.pageLinkPtr, index, length, bArr) <= 0) {
                    return "";
                }
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                return new String(bArr, UTF_16LE);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.mo1819e(TAG2, e, "mContext may be null");
                return null;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    public final int countRects(int index) {
        int iNativeCountRects;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeCountRects = INSTANCE.nativeCountRects(this.pageLinkPtr, index);
        }
        return iNativeCountRects;
    }

    @NotNull
    public final RectF getRect(int linkIndex, int rectIndex) {
        RectF rectF;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetRect = INSTANCE.nativeGetRect(this.pageLinkPtr, linkIndex, rectIndex);
            rectF = new RectF(fArrNativeGetRect[0], fArrNativeGetRect[1], fArrNativeGetRect[2], fArrNativeGetRect[3]);
        }
        return rectF;
    }

    @NotNull
    public final Pair<Integer, Integer> getTextRange(int index) {
        Pair<Integer, Integer> pair;
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            int[] iArrNativeGetTextRange = INSTANCE.nativeGetTextRange(this.pageLinkPtr, index);
            pair = new Pair<>(Integer.valueOf(iArrNativeGetTextRange[0]), Integer.valueOf(iArrNativeGetTextRange[1]));
        }
        return pair;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        INSTANCE.nativeClosePageLink(this.pageLinkPtr);
    }

    @Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J)\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0083 J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0083 J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0083 R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u001a"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfPageLink$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "nativeClosePageLink", "", "pageLinkPtr", "", "nativeCountWebLinks", "", "nativeGetURL", ArrayContainsMatcher.INDEX_KEY, "count", "result", "", "nativeCountRects", "nativeGetRect", "", "linkIndex", "rectIndex", "nativeGetTextRange", "", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeClosePageLink(long pageLinkPtr) {
            PdfPageLink.nativeClosePageLink(pageLinkPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeCountRects(long pageLinkPtr, int index) {
            return PdfPageLink.nativeCountRects(pageLinkPtr, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeCountWebLinks(long pageLinkPtr) {
            return PdfPageLink.nativeCountWebLinks(pageLinkPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetRect(long pageLinkPtr, int linkIndex, int rectIndex) {
            return PdfPageLink.nativeGetRect(pageLinkPtr, linkIndex, rectIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] nativeGetTextRange(long pageLinkPtr, int index) {
            return PdfPageLink.nativeGetTextRange(pageLinkPtr, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetURL(long pageLinkPtr, int index, int count, byte[] result) {
            return PdfPageLink.nativeGetURL(pageLinkPtr, index, count, result);
        }

        private Companion() {
        }
    }
}
