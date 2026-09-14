package io.legere.pdfiumandroid;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.actions.ToastAction;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import com.urbanairship.reactnative.ReactMessageView;
import dalvik.annotation.optimization.FastNative;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001f\u001a\u00020\u0005J&\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010*\u001a\u0004\u0018\u00010!2\u0006\u0010+\u001a\u00020\u0005J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-2\u0006\u0010/\u001a\u000200J\u0018\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u00102\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u0005J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00192\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020>H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfTextPage;", "Ljava/io/Closeable;", "doc", "Lio/legere/pdfiumandroid/PdfDocument;", "pageIndex", "", "pagePtr", "", "pageMap", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "<init>", "(Lio/legere/pdfiumandroid/PdfDocument;IJLjava/util/Map;)V", "getDoc", "()Lio/legere/pdfiumandroid/PdfDocument;", "getPageIndex", "()I", "getPagePtr", "()J", "getPageMap", "()Ljava/util/Map;", "isClosed", "", "textPageCountChars", "textPageGetTextLegacy", "", "startIndex", ToastAction.LENGTH_KEY, "textPageGetText", "textPageGetUnicode", "", ArrayContainsMatcher.INDEX_KEY, "textPageGetCharBox", "Landroid/graphics/RectF;", "textPageGetCharIndexAtPos", "x", "", "y", "xTolerance", "yTolerance", "textPageCountRects", "count", "textPageGetRect", "rectIndex", "textPageGetRectsForRanges", "", "Lio/legere/pdfiumandroid/WordRangeRect;", "wordRanges", "", "textPageGetBoundedText", "rect", "getFontSize", "charIndex", "findStart", "Lio/legere/pdfiumandroid/FindResult;", "findWhat", "flags", "", "Lio/legere/pdfiumandroid/FindFlags;", "loadWebLink", "Lio/legere/pdfiumandroid/PdfPageLink;", ReactMessageView.EVENT_CLOSE, "", "Companion", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPdfTextPage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PdfTextPage.kt\nio/legere/pdfiumandroid/PdfTextPage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,504:1\n1#2:505\n1797#3,3:506\n*S KotlinDebug\n*F\n+ 1 PdfTextPage.kt\nio/legere/pdfiumandroid/PdfTextPage\n*L\n355#1:506,3\n*E\n"})
public final class PdfTextPage implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = PdfTextPage.class.getName();

    @NotNull
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;

    @NotNull
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeCloseTextPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long nativeFindStart(long j, String str, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native double nativeGetFontSize(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long nativeLoadWebLink(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeTextCountChars(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeTextCountRects(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeTextGetBoundedText(long j, double d, double d2, double d3, double d4, short[] sArr);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native double[] nativeTextGetCharBox(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeTextGetCharIndexAtPos(long j, double d, double d2, double d3, double d4);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native double[] nativeTextGetRect(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native double[] nativeTextGetRects(long j, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeTextGetText(long j, int i, int i2, short[] sArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeTextGetTextByteArray(long j, int i, int i2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    @FastNative
    @JvmStatic
    public static final native int nativeTextGetUnicode(long j, int i);

    public PdfTextPage(@NotNull PdfDocument doc, int i, long j, @NotNull Map<Integer, PdfDocument.PageCount> pageMap) {
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

    @NotNull
    public final Map<Integer, PdfDocument.PageCount> getPageMap() {
        return this.pageMap;
    }

    public final int textPageCountChars() {
        int iNativeTextCountChars;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            iNativeTextCountChars = INSTANCE.nativeTextCountChars(this.pagePtr);
        }
        return iNativeTextCountChars;
    }

    @Nullable
    public final String textPageGetTextLegacy(int startIndex, int length) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                try {
                    short[] sArr = new short[length + 1];
                    int iNativeTextGetText = INSTANCE.nativeTextGetText(this.pagePtr, startIndex, length, sArr);
                    if (iNativeTextGetText <= 0) {
                        return "";
                    }
                    int i = iNativeTextGetText - 1;
                    byte[] bArr = new byte[i * 2];
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                    for (int i2 = 0; i2 < i; i2++) {
                        byteBufferWrap.putShort(sArr[i2]);
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
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    @Nullable
    public final String textPageGetText(int startIndex, int length) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                try {
                    byte[] bArr = new byte[length * 2];
                    if (INSTANCE.nativeTextGetTextByteArray(this.pagePtr, startIndex, length, bArr) <= 0) {
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
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    public final char textPageGetUnicode(int index) {
        char cNativeTextGetUnicode;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            cNativeTextGetUnicode = (char) INSTANCE.nativeTextGetUnicode(this.pagePtr, index);
        }
        return cNativeTextGetUnicode;
    }

    @Nullable
    public final RectF textPageGetCharBox(int index) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                try {
                    double[] dArrNativeTextGetCharBox = INSTANCE.nativeTextGetCharBox(this.pagePtr, index);
                    RectF rectF = new RectF();
                    rectF.left = (float) dArrNativeTextGetCharBox[0];
                    rectF.right = (float) dArrNativeTextGetCharBox[1];
                    rectF.bottom = (float) dArrNativeTextGetCharBox[2];
                    rectF.top = (float) dArrNativeTextGetCharBox[3];
                    return rectF;
                } catch (NullPointerException e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.mo1819e(TAG2, e, "mContext may be null");
                    Unit unit = Unit.INSTANCE;
                    return null;
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    public final int textPageGetCharIndexAtPos(double x, double y, double xTolerance, double yTolerance) {
        int iNativeTextGetCharIndexAtPos;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                iNativeTextGetCharIndexAtPos = INSTANCE.nativeTextGetCharIndexAtPos(this.pagePtr, x, y, xTolerance, yTolerance);
            } catch (Exception e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.mo1819e(TAG2, e, "Exception throw from native");
                Unit unit = Unit.INSTANCE;
                return -1;
            }
        }
        return iNativeTextGetCharIndexAtPos;
    }

    public final int textPageCountRects(int startIndex, int count) {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                return INSTANCE.nativeTextCountRects(this.pagePtr, startIndex, count);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger.mo1819e(TAG2, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return -1;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return -1;
            }
        }
    }

    @Nullable
    public final RectF textPageGetRect(int rectIndex) {
        RectF rectF = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                try {
                    double[] dArrNativeTextGetRect = INSTANCE.nativeTextGetRect(this.pagePtr, rectIndex);
                    RectF rectF2 = new RectF();
                    rectF2.left = (float) dArrNativeTextGetRect[0];
                    rectF2.top = (float) dArrNativeTextGetRect[1];
                    rectF2.right = (float) dArrNativeTextGetRect[2];
                    rectF2.bottom = (float) dArrNativeTextGetRect[3];
                    rectF = rectF2;
                } catch (NullPointerException e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.mo1819e(TAG2, e, "mContext may be null");
                }
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger2.mo1819e(TAG3, e2, "Exception throw from native");
            }
        }
        return rectF;
    }

    @Nullable
    public final List<WordRangeRect> textPageGetRectsForRanges(@NotNull int[] wordRanges) {
        Intrinsics.checkNotNullParameter(wordRanges, "wordRanges");
        int i = 0;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            double[] dArrNativeTextGetRects = INSTANCE.nativeTextGetRects(this.pagePtr, wordRanges);
            if (dArrNativeTextGetRects != null) {
                ArrayList arrayList = new ArrayList();
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, dArrNativeTextGetRects.length - 1, 6);
                if (progressionLastElement >= 0) {
                    while (true) {
                        RectF rectF = new RectF();
                        rectF.left = (float) dArrNativeTextGetRects[i];
                        rectF.top = (float) dArrNativeTextGetRects[i + 1];
                        rectF.right = (float) dArrNativeTextGetRects[i + 2];
                        rectF.bottom = (float) dArrNativeTextGetRects[i + 3];
                        arrayList.add(new WordRangeRect((int) dArrNativeTextGetRects[i + 4], (int) dArrNativeTextGetRects[i + 5], rectF));
                        if (i == progressionLastElement) {
                            break;
                        }
                        i += 6;
                    }
                }
                return arrayList;
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    @Nullable
    public final String textPageGetBoundedText(@NotNull RectF rect, int length) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        String str = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                try {
                    short[] sArr = new short[length + 1];
                    int iNativeTextGetBoundedText = INSTANCE.nativeTextGetBoundedText(this.pagePtr, rect.left, rect.top, rect.right, rect.bottom, sArr) - 1;
                    byte[] bArr = new byte[iNativeTextGetBoundedText * 2];
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                    for (int i = 0; i < iNativeTextGetBoundedText; i++) {
                        byteBufferWrap.putShort(sArr[i]);
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                    str = new String(bArr, UTF_16LE);
                } catch (NullPointerException e) {
                    Logger logger = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    logger.mo1819e(TAG2, e, "mContext may be null");
                } catch (Exception e2) {
                    Logger logger2 = Logger.INSTANCE;
                    String TAG3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    logger2.mo1819e(TAG3, e2, "Exception throw from native");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final double getFontSize(int charIndex) {
        double dNativeGetFontSize;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            dNativeGetFontSize = INSTANCE.nativeGetFontSize(this.pagePtr, charIndex);
        }
        return dNativeGetFontSize;
    }

    @Nullable
    public final FindResult findStart(@NotNull String findWhat, @NotNull Set<? extends FindFlags> flags, int startIndex) {
        FindResult findResult;
        Intrinsics.checkNotNullParameter(findWhat, "findWhat");
        Intrinsics.checkNotNullParameter(flags, "flags");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return null;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                Iterator<T> it = flags.iterator();
                int value = 0;
                while (it.hasNext()) {
                    value |= ((FindFlags) it.next()).getValue();
                }
                findResult = new FindResult(INSTANCE.nativeFindStart(this.pagePtr, findWhat, value, startIndex));
            } catch (Throwable th) {
                throw th;
            }
        }
        return findResult;
    }

    @NotNull
    public final PdfPageLink loadWebLink() {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed");
        }
        return new PdfPageLink(INSTANCE.nativeLoadWebLink(this.pagePtr));
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
                INSTANCE.nativeCloseTextPage(this.pagePtr);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0083 J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0083 J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0083 J9\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0083 J)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0083 J\u0011\u0010#\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 J1\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0083 J)\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u001eH\u0083 J)\u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020-H\u0083 J\u0019\u0010.\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0083 J!\u0010/\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0083 J\u0019\u00100\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\rH\u0083 R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u00062"}, m1836d2 = {"Lio/legere/pdfiumandroid/PdfTextPage$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "nativeCloseTextPage", "", "pagePtr", "", "nativeTextCountChars", "", "textPagePtr", "nativeTextGetCharBox", "", ArrayContainsMatcher.INDEX_KEY, "nativeTextGetRect", "rectIndex", "nativeTextGetRects", "wordRanges", "", "nativeTextGetBoundedText", ViewProps.LEFT, "", ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "arr", "", "nativeFindStart", "findWhat", "flags", "startIndex", "nativeLoadWebLink", "nativeTextGetCharIndexAtPos", "x", "y", "xTolerance", "yTolerance", "nativeTextGetText", "count", "result", "nativeTextGetTextByteArray", "", "nativeTextGetUnicode", "nativeTextCountRects", "nativeGetFontSize", "charIndex", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeCloseTextPage(long pagePtr) {
            PdfTextPage.nativeCloseTextPage(pagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeFindStart(long textPagePtr, String findWhat, int flags, int startIndex) {
            return PdfTextPage.nativeFindStart(textPagePtr, findWhat, flags, startIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final double nativeGetFontSize(long pagePtr, int charIndex) {
            return PdfTextPage.nativeGetFontSize(pagePtr, charIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long nativeLoadWebLink(long textPagePtr) {
            return PdfTextPage.nativeLoadWebLink(textPagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeTextCountChars(long textPagePtr) {
            return PdfTextPage.nativeTextCountChars(textPagePtr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeTextCountRects(long textPagePtr, int startIndex, int count) {
            return PdfTextPage.nativeTextCountRects(textPagePtr, startIndex, count);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeTextGetBoundedText(long textPagePtr, double left, double top, double right, double bottom, short[] arr) {
            return PdfTextPage.nativeTextGetBoundedText(textPagePtr, left, top, right, bottom, arr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final double[] nativeTextGetCharBox(long textPagePtr, int index) {
            return PdfTextPage.nativeTextGetCharBox(textPagePtr, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetCharIndexAtPos(long textPagePtr, double x, double y, double xTolerance, double yTolerance) {
            return PdfTextPage.nativeTextGetCharIndexAtPos(textPagePtr, x, y, xTolerance, yTolerance);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final double[] nativeTextGetRect(long textPagePtr, int rectIndex) {
            return PdfTextPage.nativeTextGetRect(textPagePtr, rectIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final double[] nativeTextGetRects(long textPagePtr, int[] wordRanges) {
            return PdfTextPage.nativeTextGetRects(textPagePtr, wordRanges);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetText(long textPagePtr, int startIndex, int count, short[] result) {
            return PdfTextPage.nativeTextGetText(textPagePtr, startIndex, count, result);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeTextGetTextByteArray(long textPagePtr, int startIndex, int count, byte[] result) {
            return PdfTextPage.nativeTextGetTextByteArray(textPagePtr, startIndex, count, result);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FastNative
        @JvmStatic
        public final int nativeTextGetUnicode(long textPagePtr, int index) {
            return PdfTextPage.nativeTextGetUnicode(textPagePtr, index);
        }

        private Companion() {
        }
    }
}
