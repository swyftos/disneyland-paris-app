package io.legere.pdfiumandroid;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import androidx.annotation.ColorInt;
import com.contentsquare.android.api.Currencies;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.reactnative.ReactMessageView;
import dalvik.annotation.optimization.FastNative;
import io.legere.pdfiumandroid.util.ConfigKt;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 R2\u00020\u0001:\u0001RB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0006\u0010)\u001a\u00020$J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u0005JL\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00142\b\b\u0003\u00103\u001a\u00020\u00052\b\b\u0003\u00104\u001a\u00020\u0005JV\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u0005JF\u0010,\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u0005JX\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u0005JH\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u0005J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?J>\u0010A\u001a\u00020B2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GJ>\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005J6\u0010M\u001a\u00020N2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010O\u001a\u00020$J6\u0010P\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NJ\b\u0010Q\u001a\u00020;H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006S"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfPage;", "Ljava/io/Closeable;", "doc", "Lio/legere/pdfiumandroid/PdfDocument;", "pageIndex", "", "pagePtr", "", "pageMap", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "<init>", "(Lio/legere/pdfiumandroid/PdfDocument;IJLjava/util/Map;)V", "getDoc", "()Lio/legere/pdfiumandroid/PdfDocument;", "getPageIndex", "()I", "getPagePtr", "()J", "isClosed", "", "isClosed$pdfiumandroid_release", "()Z", "setClosed$pdfiumandroid_release", "(Z)V", "openTextPage", "Lio/legere/pdfiumandroid/PdfTextPage;", "getPageWidth", "screenDpi", "getPageHeight", "getPageWidthPoint", "getPageHeightPoint", "getPageMatrix", "Landroid/graphics/Matrix;", "getPageRotation", "getPageCropBox", "Landroid/graphics/RectF;", "getPageMediaBox", "getPageBleedBox", "getPageTrimBox", "getPageArtBox", "getPageBoundingBox", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "renderPage", "bufferPtr", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "matrix", "clipRect", "textMask", "surface", "Landroid/view/Surface;", "renderPageBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "sizeX", "sizeY", "rotate", "pageX", "", "pageY", "mapDeviceCoordsToPage", "Landroid/graphics/PointF;", "deviceX", "deviceY", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "mapRectToPage", ReactMessageView.EVENT_CLOSE, "Companion", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPdfPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PdfPage.kt\nio/legere/pdfiumandroid/PdfPage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,982:1\n1#2:983\n*E\n"})
public final class PdfPage implements Closeable {
    public static final int BOTTOM = 3;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int LEFT = 0;
    public static final int RIGHT = 2;

    @NotNull
    private static final String TAG = "PdfPage";
    public static final int TOP = 1;

    @NotNull
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;

    @NotNull
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeClosePage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeClosePages(long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeDeviceCoordsToPage(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeGetDestPageIndex(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float[] nativeGetLinkRect(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String nativeGetLinkURI(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageArtBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageBleedBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageBoundingBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageCropBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeGetPageHeightPixel(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeGetPageHeightPoint(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long[] nativeGetPageLinks(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageMatrix(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageMediaBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeGetPageRotation(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int[] nativeGetPageSizeByIndex(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native float[] nativeGetPageTrimBox(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeGetPageWidthPixel(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeGetPageWidthPoint(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean nativeLockSurface(Surface surface, int[] iArr, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int[] nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean nativeRenderPage(long j, long j2, int i, int i2, int i3, int i4, boolean z, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeRenderPageBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeRenderPageBitmapWithMatrix(long j, Bitmap bitmap, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean nativeRenderPageSurface(long j, Surface surface, int i, int i2, boolean z, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean nativeRenderPageSurfaceWithMatrix(long j, Surface surface, float[] fArr, float[] fArr2, boolean z, boolean z2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean nativeRenderPageWithMatrix(long j, long j2, int i, int i2, float[] fArr, float[] fArr2, boolean z, boolean z2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeUnlockSurface(long[] jArr);

    public PdfPage(@NotNull PdfDocument doc, int i, long j, @NotNull Map<Integer, PdfDocument.PageCount> pageMap) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(pageMap, "pageMap");
        this.doc = doc;
        this.pageIndex = i;
        this.pagePtr = j;
        this.pageMap = pageMap;
    }

    @NotNull
    public final PdfDocument getDoc() {
        return this.doc;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final long getPagePtr() {
        return this.pagePtr;
    }

    /* JADX INFO: renamed from: isClosed$pdfiumandroid_release, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final void setClosed$pdfiumandroid_release(boolean z) {
        this.isClosed = z;
    }

    @NotNull
    public final PdfTextPage openTextPage() {
        return this.doc.openTextPage(this);
    }

    public final int getPageWidth(int screenDpi) {
        int iNativeGetPageWidthPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageWidthPixel = INSTANCE.nativeGetPageWidthPixel(this.pagePtr, screenDpi);
        }
        return iNativeGetPageWidthPixel;
    }

    public final int getPageHeight(int screenDpi) {
        int iNativeGetPageHeightPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageHeightPixel = INSTANCE.nativeGetPageHeightPixel(this.pagePtr, screenDpi);
        }
        return iNativeGetPageHeightPixel;
    }

    public final int getPageWidthPoint() {
        int iNativeGetPageWidthPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageWidthPoint = INSTANCE.nativeGetPageWidthPoint(this.pagePtr);
        }
        return iNativeGetPageWidthPoint;
    }

    public final int getPageHeightPoint() {
        int iNativeGetPageHeightPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageHeightPoint = INSTANCE.nativeGetPageHeightPoint(this.pagePtr);
        }
        return iNativeGetPageHeightPoint;
    }

    @Nullable
    public final Matrix getPageMatrix() {
        Matrix matrix;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageMatrix = INSTANCE.nativeGetPageMatrix(this.pagePtr);
            Logger logger = Logger.INSTANCE;
            logger.mo1818d(TAG, "pageMatrix[0] = " + fArrNativeGetPageMatrix[0]);
            logger.mo1818d(TAG, "pageMatrix[1] = " + fArrNativeGetPageMatrix[1]);
            logger.mo1818d(TAG, "pageMatrix[2] = " + fArrNativeGetPageMatrix[2]);
            logger.mo1818d(TAG, "pageMatrix[3] = " + fArrNativeGetPageMatrix[3]);
            logger.mo1818d(TAG, "pageMatrix[4] = " + fArrNativeGetPageMatrix[4]);
            logger.mo1818d(TAG, "pageMatrix[5] = " + fArrNativeGetPageMatrix[5]);
            float[] fArr = {fArrNativeGetPageMatrix[0], fArrNativeGetPageMatrix[1], fArrNativeGetPageMatrix[4], fArrNativeGetPageMatrix[2], fArrNativeGetPageMatrix[3], fArrNativeGetPageMatrix[5], BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
            matrix = new Matrix();
            matrix.setValues(fArr);
        }
        return matrix;
    }

    public final int getPageRotation() {
        int iNativeGetPageRotation;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeGetPageRotation = INSTANCE.nativeGetPageRotation(this.pagePtr);
        }
        return iNativeGetPageRotation;
    }

    @NotNull
    public final RectF getPageCropBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageCropBox = INSTANCE.nativeGetPageCropBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageCropBox[0];
            rectF.top = fArrNativeGetPageCropBox[1];
            rectF.right = fArrNativeGetPageCropBox[2];
            rectF.bottom = fArrNativeGetPageCropBox[3];
        }
        return rectF;
    }

    @NotNull
    public final RectF getPageMediaBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageMediaBox = INSTANCE.nativeGetPageMediaBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageMediaBox[0];
            rectF.top = fArrNativeGetPageMediaBox[1];
            rectF.right = fArrNativeGetPageMediaBox[2];
            rectF.bottom = fArrNativeGetPageMediaBox[3];
        }
        return rectF;
    }

    @NotNull
    public final RectF getPageBleedBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageBleedBox = INSTANCE.nativeGetPageBleedBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageBleedBox[0];
            rectF.top = fArrNativeGetPageBleedBox[1];
            rectF.right = fArrNativeGetPageBleedBox[2];
            rectF.bottom = fArrNativeGetPageBleedBox[3];
        }
        return rectF;
    }

    @NotNull
    public final RectF getPageTrimBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageTrimBox = INSTANCE.nativeGetPageTrimBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageTrimBox[0];
            rectF.top = fArrNativeGetPageTrimBox[1];
            rectF.right = fArrNativeGetPageTrimBox[2];
            rectF.bottom = fArrNativeGetPageTrimBox[3];
        }
        return rectF;
    }

    @NotNull
    public final RectF getPageArtBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageArtBox = INSTANCE.nativeGetPageArtBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageArtBox[0];
            rectF.top = fArrNativeGetPageArtBox[1];
            rectF.right = fArrNativeGetPageArtBox[2];
            rectF.bottom = fArrNativeGetPageArtBox[3];
        }
        return rectF;
    }

    @NotNull
    public final RectF getPageBoundingBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] fArrNativeGetPageBoundingBox = INSTANCE.nativeGetPageBoundingBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = fArrNativeGetPageBoundingBox[0];
            rectF.top = fArrNativeGetPageBoundingBox[1];
            rectF.right = fArrNativeGetPageBoundingBox[2];
            rectF.bottom = fArrNativeGetPageBoundingBox[3];
        }
        return rectF;
    }

    @NotNull
    public final Size getPageSize(int screenDpi) {
        Size size;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            int[] iArrNativeGetPageSizeByIndex = INSTANCE.nativeGetPageSizeByIndex(this.doc.getMNativeDocPtr(), this.pageIndex, screenDpi);
            size = new Size(iArrNativeGetPageSizeByIndex[0], iArrNativeGetPageSizeByIndex[1]);
        }
        return size;
    }

    public final boolean renderPage(long bufferPtr, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot, @ColorInt int canvasColor, @ColorInt int pageBackgroundColor) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return false;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                return INSTANCE.nativeRenderPage(this.pagePtr, bufferPtr, startX, startY, drawSizeX, drawSizeY, renderAnnot, canvasColor, pageBackgroundColor);
            } catch (NullPointerException e) {
                Logger.INSTANCE.mo1819e(TAG, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return false;
            } catch (Exception e2) {
                Logger.INSTANCE.mo1819e(TAG, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return false;
            }
        }
    }

    public final boolean renderPage(long bufferPtr, int drawSizeX, int drawSizeY, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        boolean zNativeRenderPageWithMatrix;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return false;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            zNativeRenderPageWithMatrix = INSTANCE.nativeRenderPageWithMatrix(this.pagePtr, bufferPtr, drawSizeX, drawSizeY, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }
        return zNativeRenderPageWithMatrix;
    }

    public final boolean renderPage(@NotNull Surface surface, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        boolean zNativeRenderPageSurfaceWithMatrix;
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return false;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            zNativeRenderPageSurfaceWithMatrix = INSTANCE.nativeRenderPageSurfaceWithMatrix(this.pagePtr, surface, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }
        return zNativeRenderPageSurfaceWithMatrix;
    }

    public final void renderPageBitmap(@Nullable Bitmap bitmap, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            INSTANCE.nativeRenderPageBitmap(this.doc.getMNativeDocPtr(), this.pagePtr, bitmap, startX, startY, drawSizeX, drawSizeY, renderAnnot, textMask, canvasColor, pageBackgroundColor);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void renderPageBitmap(@Nullable Bitmap bitmap, @NotNull Matrix matrix, @NotNull RectF clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            INSTANCE.nativeRenderPageBitmapWithMatrix(this.pagePtr, bitmap, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, new float[]{clipRect.left, clipRect.top, clipRect.right, clipRect.bottom}, renderAnnot, textMask, canvasColor, pageBackgroundColor);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final List<PdfDocument.Link> getPageLinks() {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            arrayList = new ArrayList();
            for (long j : INSTANCE.nativeGetPageLinks(this.pagePtr)) {
                Companion companion = INSTANCE;
                int iNativeGetDestPageIndex = companion.nativeGetDestPageIndex(this.doc.getMNativeDocPtr(), j);
                String strNativeGetLinkURI = companion.nativeGetLinkURI(this.doc.getMNativeDocPtr(), j);
                float[] fArrNativeGetLinkRect = companion.nativeGetLinkRect(this.doc.getMNativeDocPtr(), j);
                if (fArrNativeGetLinkRect.length != 4 && (iNativeGetDestPageIndex != -1 || strNativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(new RectF(fArrNativeGetLinkRect[0], fArrNativeGetLinkRect[1], fArrNativeGetLinkRect[2], fArrNativeGetLinkRect[3]), Integer.valueOf(iNativeGetDestPageIndex), strNativeGetLinkURI));
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final Point mapPageCoordsToDevice(int startX, int startY, int sizeX, int sizeY, int rotate, double pageX, double pageY) {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        int[] iArrNativePageCoordsToDevice = INSTANCE.nativePageCoordsToDevice(this.pagePtr, startX, startY, sizeX, sizeY, rotate, pageX, pageY);
        return new Point(iArrNativePageCoordsToDevice[0], iArrNativePageCoordsToDevice[1]);
    }

    @NotNull
    public final PointF mapDeviceCoordsToPage(int startX, int startY, int sizeX, int sizeY, int rotate, int deviceX, int deviceY) {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        float[] fArrNativeDeviceCoordsToPage = INSTANCE.nativeDeviceCoordsToPage(this.pagePtr, startX, startY, sizeX, sizeY, rotate, deviceX, deviceY);
        return new PointF(fArrNativeDeviceCoordsToPage[0], fArrNativeDeviceCoordsToPage[1]);
    }

    @NotNull
    public final Rect mapRectToDevice(int startX, int startY, int sizeX, int sizeY, int rotate, @NotNull RectF coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        Point pointMapPageCoordsToDevice = mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, coords.left, coords.top);
        Point pointMapPageCoordsToDevice2 = mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, coords.right, coords.bottom);
        return new Rect(pointMapPageCoordsToDevice.x, pointMapPageCoordsToDevice.y, pointMapPageCoordsToDevice2.x, pointMapPageCoordsToDevice2.y);
    }

    @NotNull
    public final RectF mapRectToPage(int startX, int startY, int sizeX, int sizeY, int rotate, @NotNull Rect coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        PointF pointFMapDeviceCoordsToPage = mapDeviceCoordsToPage(startX, startY, sizeX, sizeY, rotate, coords.left, coords.top);
        PointF pointFMapDeviceCoordsToPage2 = mapDeviceCoordsToPage(startX, startY, sizeX, sizeY, rotate, coords.right, coords.bottom);
        return new RectF(pointFMapDeviceCoordsToPage.x, pointFMapDeviceCoordsToPage.y, pointFMapDeviceCoordsToPage2.x, pointFMapDeviceCoordsToPage2.y);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            PdfDocument.PageCount pageCount = this.pageMap.get(Integer.valueOf(this.pageIndex));
            if (pageCount != null) {
                if (pageCount.getCount() > 1) {
                    pageCount.setCount(pageCount.getCount() - 1);
                    return;
                }
                this.pageMap.remove(Integer.valueOf(this.pageIndex));
                this.isClosed = true;
                INSTANCE.nativeClosePage(this.pagePtr);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0012H\u0083 J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0083 J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0083 J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0083 J!\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0011\u0010!\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 JQ\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 J]\u0010+\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 JA\u0010/\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 JM\u00100\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 Jc\u00101\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 JO\u00104\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0083 J!\u00105\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0083 J\u0011\u00108\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 JI\u00109\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0083 JI\u0010@\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0083 J\u0019\u0010C\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0007H\u0083 J\u0019\u0010D\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0007H\u0083 J\u0011\u0010E\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010F\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010G\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010H\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010I\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010J\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010K\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010L\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010M\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010N\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006O"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfPage$Companion;", "", "<init>", "()V", "TAG", "", "LEFT", "", Currencies.AlphabeticCode.TOP_STR, "RIGHT", "BOTTOM", "lockSurface", "", "surface", "Landroid/view/Surface;", "dimensions", "", "ptrs", "", "unlockSurface", "", "nativeClosePage", "pagePtr", "", "nativeClosePages", "pagesPtr", "nativeGetDestPageIndex", "docPtr", "linkPtr", "nativeGetLinkURI", "nativeGetLinkRect", "", "nativeLockSurface", "nativeUnlockSurface", "nativeRenderPage", "bufferPtr", "startX", "startY", "drawSizeHor", "drawSizeVer", "renderAnnot", "canvasColor", "pageBackgroundColor", "nativeRenderPageWithMatrix", "matrix", "clipRect", "textMask", "nativeRenderPageSurface", "nativeRenderPageSurfaceWithMatrix", "nativeRenderPageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "nativeRenderPageBitmapWithMatrix", "nativeGetPageSizeByIndex", "pageIndex", "dpi", "nativeGetPageLinks", "nativePageCoordsToDevice", "sizeX", "sizeY", "rotate", "pageX", "", "pageY", "nativeDeviceCoordsToPage", "deviceX", "deviceY", "nativeGetPageWidthPixel", "nativeGetPageHeightPixel", "nativeGetPageWidthPoint", "nativeGetPageHeightPoint", "nativeGetPageRotation", "nativeGetPageMediaBox", "nativeGetPageCropBox", "nativeGetPageBleedBox", "nativeGetPageTrimBox", "nativeGetPageArtBox", "nativeGetPageBoundingBox", "nativeGetPageMatrix", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeClosePage(long pagePtr) {
            PdfPage.nativeClosePage(pagePtr);
        }

        @JvmStatic
        private final void nativeClosePages(long[] pagesPtr) {
            PdfPage.nativeClosePages(pagesPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeDeviceCoordsToPage(long pagePtr, int startX, int startY, int sizeX, int sizeY, int rotate, int deviceX, int deviceY) {
            return PdfPage.nativeDeviceCoordsToPage(pagePtr, startX, startY, sizeX, sizeY, rotate, deviceX, deviceY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetDestPageIndex(long docPtr, long linkPtr) {
            return PdfPage.nativeGetDestPageIndex(docPtr, linkPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float[] nativeGetLinkRect(long docPtr, long linkPtr) {
            return PdfPage.nativeGetLinkRect(docPtr, linkPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String nativeGetLinkURI(long docPtr, long linkPtr) {
            return PdfPage.nativeGetLinkURI(docPtr, linkPtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageArtBox(long pagePtr) {
            return PdfPage.nativeGetPageArtBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageBleedBox(long pagePtr) {
            return PdfPage.nativeGetPageBleedBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageBoundingBox(long pagePtr) {
            return PdfPage.nativeGetPageBoundingBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageCropBox(long pagePtr) {
            return PdfPage.nativeGetPageCropBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeGetPageHeightPixel(long pagePtr, int dpi) {
            return PdfPage.nativeGetPageHeightPixel(pagePtr, dpi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeGetPageHeightPoint(long pagePtr) {
            return PdfPage.nativeGetPageHeightPoint(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long[] nativeGetPageLinks(long pagePtr) {
            return PdfPage.nativeGetPageLinks(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageMatrix(long pagePtr) {
            return PdfPage.nativeGetPageMatrix(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageMediaBox(long pagePtr) {
            return PdfPage.nativeGetPageMediaBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeGetPageRotation(long pagePtr) {
            return PdfPage.nativeGetPageRotation(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] nativeGetPageSizeByIndex(long docPtr, int pageIndex, int dpi) {
            return PdfPage.nativeGetPageSizeByIndex(docPtr, pageIndex, dpi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final float[] nativeGetPageTrimBox(long pagePtr) {
            return PdfPage.nativeGetPageTrimBox(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeGetPageWidthPixel(long pagePtr, int dpi) {
            return PdfPage.nativeGetPageWidthPixel(pagePtr, dpi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeGetPageWidthPoint(long pagePtr) {
            return PdfPage.nativeGetPageWidthPoint(pagePtr);
        }

        @JvmStatic
        private final boolean nativeLockSurface(Surface surface, int[] dimensions, long[] ptrs) {
            return PdfPage.nativeLockSurface(surface, dimensions, ptrs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int[] nativePageCoordsToDevice(long pagePtr, int startX, int startY, int sizeX, int sizeY, int rotate, double pageX, double pageY) {
            return PdfPage.nativePageCoordsToDevice(pagePtr, startX, startY, sizeX, sizeY, rotate, pageX, pageY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPage(long pagePtr, long bufferPtr, int startX, int startY, int drawSizeHor, int drawSizeVer, boolean renderAnnot, int canvasColor, int pageBackgroundColor) {
            return PdfPage.nativeRenderPage(pagePtr, bufferPtr, startX, startY, drawSizeHor, drawSizeVer, renderAnnot, canvasColor, pageBackgroundColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeRenderPageBitmap(long docPtr, long pagePtr, Bitmap bitmap, int startX, int startY, int drawSizeHor, int drawSizeVer, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
            PdfPage.nativeRenderPageBitmap(docPtr, pagePtr, bitmap, startX, startY, drawSizeHor, drawSizeVer, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeRenderPageBitmapWithMatrix(long pagePtr, Bitmap bitmap, float[] matrix, float[] clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
            PdfPage.nativeRenderPageBitmapWithMatrix(pagePtr, bitmap, matrix, clipRect, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }

        @JvmStatic
        private final boolean nativeRenderPageSurface(long pagePtr, Surface surface, int startX, int startY, boolean renderAnnot, int canvasColor, int pageBackgroundColor) {
            return PdfPage.nativeRenderPageSurface(pagePtr, surface, startX, startY, renderAnnot, canvasColor, pageBackgroundColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPageSurfaceWithMatrix(long pagePtr, Surface surface, float[] matrix, float[] clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
            return PdfPage.nativeRenderPageSurfaceWithMatrix(pagePtr, surface, matrix, clipRect, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean nativeRenderPageWithMatrix(long pagePtr, long bufferPtr, int drawSizeHor, int drawSizeVer, float[] matrix, float[] clipRect, boolean renderAnnot, boolean textMask, int canvasColor, int pageBackgroundColor) {
            return PdfPage.nativeRenderPageWithMatrix(pagePtr, bufferPtr, drawSizeHor, drawSizeVer, matrix, clipRect, renderAnnot, textMask, canvasColor, pageBackgroundColor);
        }

        @JvmStatic
        private final void nativeUnlockSurface(long[] ptrs) {
            PdfPage.nativeUnlockSurface(ptrs);
        }

        private Companion() {
        }

        public final boolean lockSurface(@NotNull Surface surface, @NotNull int[] dimensions, @NotNull long[] ptrs) {
            boolean zNativeLockSurface;
            Intrinsics.checkNotNullParameter(surface, "surface");
            Intrinsics.checkNotNullParameter(dimensions, "dimensions");
            Intrinsics.checkNotNullParameter(ptrs, "ptrs");
            synchronized (PdfiumCore.INSTANCE.getLock()) {
                zNativeLockSurface = PdfPage.INSTANCE.nativeLockSurface(surface, dimensions, ptrs);
            }
            return zNativeLockSurface;
        }

        public final void unlockSurface(@NotNull long[] ptrs) {
            Intrinsics.checkNotNullParameter(ptrs, "ptrs");
            synchronized (PdfiumCore.INSTANCE.getLock()) {
                PdfPage.INSTANCE.nativeUnlockSurface(ptrs);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
