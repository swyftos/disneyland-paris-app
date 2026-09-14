package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import androidx.annotation.Keep;
import com.facebook.imageutils.JfifUtil;
import com.urbanairship.reactnative.ReactMessageView;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.PdfiumCore;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001a\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001b\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001c\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u000e\u0010\u001d\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010JV\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010+JP\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00104JP\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0086@¢\u0006\u0002\u0010\fJF\u00109\u001a\u00020:2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0086@¢\u0006\u0002\u0010AJF\u0010B\u001a\u00020C2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010FJ>\u0010G\u001a\u00020H2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010JJ>\u0010K\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020HH\u0086@¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u000201H\u0016J\u0006\u0010N\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, m1836d2 = {"Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Ljava/io/Closeable;", "page", "Lio/legere/pdfiumandroid/PdfPage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/PdfPage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPage", "()Lio/legere/pdfiumandroid/PdfPage;", "openTextPage", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageWidth", "", "screenDpi", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageHeight", "getPageWidthPoint", "getPageHeightPoint", "getPageMatrix", "Landroid/graphics/Matrix;", "getPageRotation", "getPageCropBox", "Landroid/graphics/RectF;", "getPageMediaBox", "getPageBleedBox", "getPageTrimBox", "getPageArtBox", "getPageBoundingBox", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "renderPage", "", "surface", "Landroid/view/Surface;", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "(Landroid/view/Surface;IIIIZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "matrix", "clipRect", "textMask", "(Landroid/view/Surface;Landroid/graphics/Matrix;Landroid/graphics/RectF;ZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderPageBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;IIIIZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/RectF;ZZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "sizeX", "sizeY", "rotate", "pageX", "", "pageY", "(IIIIIDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDeviceCoordsToPage", "Landroid/graphics/PointF;", "deviceX", "deviceY", "(IIIIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "(IIIIILandroid/graphics/RectF;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToPage", "(IIIIILandroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ReactMessageView.EVENT_CLOSE, "safeClose", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPdfPageKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PdfPageKt.kt\nio/legere/pdfiumandroid/suspend/PdfPageKt\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,394:1\n116#2,10:395\n116#2,10:405\n*S KotlinDebug\n*F\n+ 1 PdfPageKt.kt\nio/legere/pdfiumandroid/suspend/PdfPageKt\n*L\n164#1:395,10\n215#1:405,10\n*E\n"})
public final class PdfPageKt implements Closeable {

    @NotNull
    private final CoroutineDispatcher dispatcher;

    @NotNull
    private final PdfPage page;

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt", m1845f = "PdfPageKt.kt", m1846i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, m1847l = {399, 167, 181, 194}, m1848m = "renderPage", m1849n = {"this", "surface", "retValue", "$this$withLock_u24default$iv", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "this", "retValue", "$this$withLock_u24default$iv", "pointers", "startX", "startY", "drawSizeX", "drawSizeY", "renderAnnot", "canvasColor", "pageBackgroundColor", "retValue", "$this$withLock_u24default$iv", "nativeWindow", "bufferPtr", "retValue", "$this$withLock_u24default$iv"}, m1850s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1"})
    static final class C69061 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C69061(Continuation<? super C69061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfPageKt.this.renderPage(null, 0, 0, 0, 0, false, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$3 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt", m1845f = "PdfPageKt.kt", m1846i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3}, m1847l = {399, JfifUtil.MARKER_SOS, 235, 249}, m1848m = "renderPage", m1849n = {"this", "surface", "matrix", "clipRect", "retValue", "$this$withLock_u24default$iv", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "this", "surface", "matrix", "clipRect", "retValue", "$this$withLock_u24default$iv", "sizes", "pointers", "renderAnnot", "textMask", "canvasColor", "pageBackgroundColor", "surface", "retValue", "$this$withLock_u24default$iv", "nativeWindow", "bufferPtr", "retValue", "$this$withLock_u24default$iv"}, m1850s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1"})
    static final class C69073 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C69073(Continuation<? super C69073> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfPageKt.this.renderPage(null, null, null, false, false, 0, 0, this);
        }
    }

    public PdfPageKt(@NotNull PdfPage page, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    @NotNull
    public final PdfPage getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfTextPageKt>, Object> {
        int label;

        C69052(Continuation<? super C69052> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69052(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfTextPageKt> continuation) {
            return ((C69052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(PdfPageKt.this.getPage().openTextPage(), PdfPageKt.this.dispatcher);
        }
    }

    @Nullable
    public final Object openTextPage(@NotNull Continuation<? super PdfTextPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69052(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidth$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68992(int i, Continuation<? super C68992> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68992(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68992) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidth(this.$screenDpi));
        }
    }

    @Nullable
    public final Object getPageWidth(int i, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68992(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68912(int i, Continuation<? super C68912> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68912(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68912) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeight(this.$screenDpi));
        }
    }

    @Nullable
    public final Object getPageHeight(int i, @NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68912(i, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageWidthPoint$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C69002(Continuation<? super C69002> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69002(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C69002) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageWidthPoint());
        }
    }

    @Nullable
    public final Object getPageWidthPoint(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69002(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeightPoint$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C68922(Continuation<? super C68922> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68922(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68922) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageHeightPoint());
        }
    }

    @Nullable
    public final Object getPageHeightPoint(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68922(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/Matrix;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMatrix$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Matrix>, Object> {
        int label;

        C68942(Continuation<? super C68942> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68942(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Matrix> continuation) {
            return ((C68942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMatrix();
        }
    }

    @Nullable
    public final Object getPageMatrix(@NotNull Continuation<? super Matrix> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68942(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageRotation$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C68962(Continuation<? super C68962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68962(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(PdfPageKt.this.getPage().getPageRotation());
        }
    }

    @Nullable
    public final Object getPageRotation(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68962(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageCropBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68902 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68902(Continuation<? super C68902> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68902(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68902) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageCropBox();
        }
    }

    @Nullable
    public final Object getPageCropBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68902(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageMediaBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68952(Continuation<? super C68952> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68952(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageMediaBox();
        }
    }

    @Nullable
    public final Object getPageMediaBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68952(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBleedBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68882(Continuation<? super C68882> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68882(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBleedBox();
        }
    }

    @Nullable
    public final Object getPageBleedBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68882(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageTrimBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68982(Continuation<? super C68982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68982(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageTrimBox();
        }
    }

    @Nullable
    public final Object getPageTrimBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68982(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageArtBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68872(Continuation<? super C68872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68872(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageArtBox();
        }
    }

    @Nullable
    public final Object getPageArtBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68872(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageBoundingBox$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        int label;

        C68892(Continuation<? super C68892> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68892(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C68892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageBoundingBox();
        }
    }

    @Nullable
    public final Object getPageBoundingBox(@NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68892(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/util/Size;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageSize$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Size>, Object> {
        final /* synthetic */ int $screenDpi;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68972(int i, Continuation<? super C68972> continuation) {
            super(2, continuation);
            this.$screenDpi = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68972(this.$screenDpi, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Size> continuation) {
            return ((C68972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageSize(this.$screenDpi);
        }
    }

    @Nullable
    public final Object getPageSize(int i, @NotNull Continuation<? super Size> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68972(i, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0198 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0199  */
    /* JADX WARN: Code duplicated, block: B:57:0x01ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Nullable
    public final Object renderPage(@Nullable Surface surface, int i, int i2, int i3, int i4, boolean z, int i5, int i6, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C69061 c69061;
        Mutex surfaceMutex;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        Surface surface2;
        Ref.BooleanRef booleanRef;
        int i11;
        PdfPageKt pdfPageKt;
        int i12;
        int i13;
        Mutex mutex;
        int i14;
        Mutex mutex2;
        int i15;
        PdfPageKt pdfPageKt2;
        int i16;
        int i17;
        boolean z3;
        int i18;
        int i19;
        long[] jArr;
        long j;
        long j2;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$2$2 pdfPageKt$renderPage$2$2;
        Ref.BooleanRef booleanRef2;
        long j3;
        MainCoroutineDispatcher main;
        PdfPageKt$renderPage$2$3 pdfPageKt$renderPage$2$3;
        Object obj;
        if (continuation instanceof C69061) {
            c69061 = (C69061) continuation;
            int i20 = c69061.label;
            if ((i20 & Integer.MIN_VALUE) != 0) {
                c69061.label = i20 - Integer.MIN_VALUE;
            } else {
                c69061 = new C69061(continuation);
            }
        } else {
            c69061 = new C69061(continuation);
        }
        Object obj2 = c69061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i21 = c69061.label;
        try {
            if (i21 == 0) {
                ResultKt.throwOnFailure(obj2);
                Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                surfaceMutex = PdfiumCore.INSTANCE.getSurfaceMutex();
                c69061.L$0 = this;
                c69061.L$1 = surface;
                c69061.L$2 = booleanRef3;
                c69061.L$3 = surfaceMutex;
                i7 = i;
                c69061.I$0 = i7;
                c69061.I$1 = i2;
                i8 = i3;
                c69061.I$2 = i8;
                c69061.I$3 = i4;
                z2 = z;
                c69061.Z$0 = z2;
                i9 = i5;
                c69061.I$4 = i9;
                i10 = i6;
                c69061.I$5 = i10;
                c69061.label = 1;
                if (surfaceMutex.lock(null, c69061) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                surface2 = surface;
                booleanRef = booleanRef3;
                i11 = 2;
                pdfPageKt = this;
                i12 = i4;
                i13 = i2;
            } else {
                if (i21 != 1) {
                    if (i21 != 2) {
                        if (i21 == 3) {
                            j3 = c69061.J$1;
                            j = c69061.J$0;
                            Mutex mutex3 = (Mutex) c69061.L$1;
                            booleanRef2 = (Ref.BooleanRef) c69061.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                mutex2 = mutex3;
                                main = Dispatchers.getMain();
                                pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                                c69061.L$0 = booleanRef2;
                                c69061.L$1 = mutex2;
                                c69061.label = 4;
                                if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, c69061) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutex = mutex2;
                            } catch (Throwable th) {
                                th = th;
                                mutex = mutex3;
                            }
                        } else {
                            if (i21 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex = (Mutex) c69061.L$1;
                            booleanRef2 = (Ref.BooleanRef) c69061.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        obj = null;
                    } else {
                        int i22 = c69061.I$5;
                        int i23 = c69061.I$4;
                        boolean z4 = c69061.Z$0;
                        int i24 = c69061.I$3;
                        int i25 = c69061.I$2;
                        int i26 = c69061.I$1;
                        int i27 = c69061.I$0;
                        jArr = (long[]) c69061.L$3;
                        mutex2 = (Mutex) c69061.L$2;
                        booleanRef = (Ref.BooleanRef) c69061.L$1;
                        pdfPageKt2 = (PdfPageKt) c69061.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            i19 = i22;
                            i18 = i23;
                            z3 = z4;
                            i14 = i24;
                            i16 = i25;
                            i17 = i26;
                            i15 = i27;
                            try {
                                j = jArr[0];
                                j2 = jArr[1];
                                if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                                    coroutineDispatcher = pdfPageKt2.dispatcher;
                                    pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(booleanRef, pdfPageKt2, j2, i15, i17, i16, i14, z3, i18, i19, null);
                                    c69061.L$0 = booleanRef;
                                    c69061.L$1 = mutex2;
                                    c69061.L$2 = null;
                                    c69061.L$3 = null;
                                    c69061.J$0 = j;
                                    c69061.J$1 = j2;
                                    c69061.label = 3;
                                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, c69061) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    booleanRef2 = booleanRef;
                                    j3 = j2;
                                    main = Dispatchers.getMain();
                                    pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                                    c69061.L$0 = booleanRef2;
                                    c69061.L$1 = mutex2;
                                    c69061.label = 4;
                                    if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, c69061) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    mutex = mutex2;
                                }
                                Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                                mutex2.unlock(null);
                                return boolBoxBoolean;
                            } catch (Throwable th3) {
                                th = th3;
                                mutex = mutex2;
                                obj = null;
                                mutex.unlock(obj);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj = null;
                            mutex = mutex2;
                        }
                    }
                    mutex.unlock(obj);
                    throw th;
                }
                int i28 = c69061.I$5;
                int i29 = c69061.I$4;
                boolean z5 = c69061.Z$0;
                int i30 = c69061.I$3;
                i8 = c69061.I$2;
                i13 = c69061.I$1;
                int i31 = c69061.I$0;
                Mutex mutex4 = (Mutex) c69061.L$3;
                Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) c69061.L$2;
                surface2 = (Surface) c69061.L$1;
                pdfPageKt = (PdfPageKt) c69061.L$0;
                ResultKt.throwOnFailure(obj2);
                i11 = 2;
                i10 = i28;
                i12 = i30;
                i7 = i31;
                z2 = z5;
                booleanRef = booleanRef4;
                i9 = i29;
                surfaceMutex = mutex4;
                try {
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Boxing.boxBoolean(booleanRef2.element);
                } catch (Throwable th5) {
                    th = th5;
                    obj = null;
                    mutex.unlock(obj);
                    throw th;
                }
            }
            int[] iArr = new int[i11];
            long[] jArr2 = new long[i11];
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            PdfPageKt$renderPage$2$1 pdfPageKt$renderPage$2$1 = new PdfPageKt$renderPage$2$1(surface2, iArr, jArr2, null);
            c69061.L$0 = pdfPageKt;
            c69061.L$1 = booleanRef;
            c69061.L$2 = surfaceMutex;
            c69061.L$3 = jArr2;
            c69061.I$0 = i7;
            c69061.I$1 = i13;
            c69061.I$2 = i8;
            c69061.I$3 = i12;
            c69061.Z$0 = z2;
            c69061.I$4 = i9;
            c69061.I$5 = i10;
            c69061.label = 2;
            Object objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$2$1, c69061);
            coroutine_suspended = coroutine_suspended;
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            i14 = i12;
            mutex2 = surfaceMutex;
            i15 = i7;
            pdfPageKt2 = pdfPageKt;
            i16 = i8;
            i17 = i13;
            z3 = z2;
            i18 = i9;
            i19 = i10;
            jArr = jArr2;
            j = jArr[0];
            j2 = jArr[1];
            if (j2 != 0) {
                coroutineDispatcher = pdfPageKt2.dispatcher;
                pdfPageKt$renderPage$2$2 = new PdfPageKt$renderPage$2$2(booleanRef, pdfPageKt2, j2, i15, i17, i16, i14, z3, i18, i19, null);
                c69061.L$0 = booleanRef;
                c69061.L$1 = mutex2;
                c69061.L$2 = null;
                c69061.L$3 = null;
                c69061.J$0 = j;
                c69061.J$1 = j2;
                c69061.label = 3;
                if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$2$2, c69061) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef2 = booleanRef;
                j3 = j2;
                main = Dispatchers.getMain();
                pdfPageKt$renderPage$2$3 = new PdfPageKt$renderPage$2$3(j, j3, null);
                c69061.L$0 = booleanRef2;
                c69061.L$1 = mutex2;
                c69061.label = 4;
                if (BuildersKt.withContext(main, pdfPageKt$renderPage$2$3, c69061) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                return Boxing.boxBoolean(booleanRef2.element);
            }
            Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
            mutex2.unlock(null);
            return boolBoxBoolean2;
        } catch (Throwable th6) {
            th = th6;
            mutex = surfaceMutex;
            obj = null;
            mutex.unlock(obj);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x01c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:57:0x01e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Nullable
    public final Object renderPage(@Nullable Surface surface, @NotNull Matrix matrix, @NotNull RectF rectF, boolean z, boolean z2, int i, int i2, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C69073 c69073;
        RectF rectF2;
        boolean z3;
        boolean z4;
        PdfPageKt pdfPageKt;
        int i3;
        Surface surface2;
        Ref.BooleanRef booleanRef;
        Mutex mutex;
        int i4;
        Matrix matrix2;
        int i5;
        Mutex mutex2;
        int i6;
        RectF rectF3;
        boolean z5;
        boolean z6;
        Matrix matrix3;
        Surface surface3;
        PdfPageKt pdfPageKt2;
        long[] jArr;
        Ref.BooleanRef booleanRef2;
        int[] iArr;
        ?? r7;
        long j;
        long j2;
        int i7;
        int i8;
        CoroutineDispatcher coroutineDispatcher;
        PdfPageKt$renderPage$4$2 pdfPageKt$renderPage$4$2;
        Ref.BooleanRef booleanRef3;
        ?? r8;
        Object obj;
        if (continuation instanceof C69073) {
            c69073 = (C69073) continuation;
            int i9 = c69073.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                c69073.label = i9 - Integer.MIN_VALUE;
            } else {
                c69073 = new C69073(continuation);
            }
        } else {
            c69073 = new C69073(continuation);
        }
        Object objWithContext = c69073.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = c69073.label;
        try {
            try {
                if (i10 == 0) {
                    ResultKt.throwOnFailure(objWithContext);
                    Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
                    Mutex surfaceMutex = PdfiumCore.INSTANCE.getSurfaceMutex();
                    c69073.L$0 = this;
                    c69073.L$1 = surface;
                    c69073.L$2 = matrix;
                    rectF2 = rectF;
                    c69073.L$3 = rectF2;
                    c69073.L$4 = booleanRef4;
                    c69073.L$5 = surfaceMutex;
                    z3 = z;
                    c69073.Z$0 = z3;
                    z4 = z2;
                    c69073.Z$1 = z4;
                    c69073.I$0 = i;
                    c69073.I$1 = i2;
                    c69073.label = 1;
                    if (surfaceMutex.lock(null, c69073) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pdfPageKt = this;
                    i3 = i2;
                    surface2 = surface;
                    booleanRef = booleanRef4;
                    mutex = surfaceMutex;
                    i4 = i;
                    matrix2 = matrix;
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                long j3 = c69073.J$1;
                                long j4 = c69073.J$0;
                                Mutex mutex3 = (Mutex) c69073.L$2;
                                booleanRef3 = (Ref.BooleanRef) c69073.L$1;
                                surface3 = (Surface) c69073.L$0;
                                try {
                                    ResultKt.throwOnFailure(objWithContext);
                                    r8 = coroutine_suspended;
                                    mutex2 = mutex3;
                                    j = j4;
                                    j2 = j3;
                                    MainCoroutineDispatcher main = Dispatchers.getMain();
                                    PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$3 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                                    c69073.L$0 = booleanRef3;
                                    c69073.L$1 = mutex2;
                                    obj = null;
                                    c69073.L$2 = null;
                                    c69073.label = 4;
                                    objWithContext = BuildersKt.withContext(main, pdfPageKt$renderPage$4$3, c69073);
                                    if (objWithContext == r8) {
                                        return r8;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    coroutine_suspended = mutex3;
                                }
                            } else {
                                if (i10 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex2 = (Mutex) c69073.L$1;
                                booleanRef3 = (Ref.BooleanRef) c69073.L$0;
                                ResultKt.throwOnFailure(objWithContext);
                                obj = null;
                            }
                            mutex2.unlock(obj);
                            return Boxing.boxBoolean(booleanRef3.element);
                        }
                        int i11 = c69073.I$1;
                        int i12 = c69073.I$0;
                        boolean z7 = c69073.Z$1;
                        boolean z8 = c69073.Z$0;
                        jArr = (long[]) c69073.L$7;
                        iArr = (int[]) c69073.L$6;
                        Mutex mutex4 = (Mutex) c69073.L$5;
                        booleanRef2 = (Ref.BooleanRef) c69073.L$4;
                        RectF rectF4 = (RectF) c69073.L$3;
                        Matrix matrix4 = (Matrix) c69073.L$2;
                        Surface surface4 = (Surface) c69073.L$1;
                        pdfPageKt2 = (PdfPageKt) c69073.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            i5 = i11;
                            i6 = i12;
                            matrix3 = matrix4;
                            surface3 = surface4;
                            z6 = z7;
                            z5 = z8;
                            rectF3 = rectF4;
                            r7 = coroutine_suspended;
                            mutex2 = mutex4;
                            j = jArr[0];
                            j2 = jArr[1];
                            i7 = iArr[0];
                            i8 = iArr[1];
                            Logger.INSTANCE.mo1818d("PdfPageKt", "nativeWindow: " + j);
                            if (j2 != 0 && j2 != -1 && j != 0 && j != -1) {
                                coroutineDispatcher = pdfPageKt2.dispatcher;
                                pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(booleanRef2, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i6, i5, null);
                                c69073.L$0 = surface3;
                                c69073.L$1 = booleanRef2;
                                c69073.L$2 = mutex2;
                                c69073.L$3 = null;
                                c69073.L$4 = null;
                                c69073.L$5 = null;
                                c69073.L$6 = null;
                                c69073.L$7 = null;
                                c69073.J$0 = j;
                                c69073.J$1 = j2;
                                c69073.label = 3;
                                if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, c69073) == r7) {
                                    return r7;
                                }
                                booleanRef3 = booleanRef2;
                                r8 = r7;
                                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                                PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$4 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                                c69073.L$0 = booleanRef3;
                                c69073.L$1 = mutex2;
                                obj = null;
                                c69073.L$2 = null;
                                c69073.label = 4;
                                objWithContext = BuildersKt.withContext(main2, pdfPageKt$renderPage$4$4, c69073);
                                if (objWithContext == r8) {
                                    return r8;
                                }
                                mutex2.unlock(obj);
                                return Boxing.boxBoolean(booleanRef3.element);
                            }
                            Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                            mutex2.unlock(null);
                            return boolBoxBoolean;
                        } catch (Throwable th2) {
                            th = th2;
                            coroutine_suspended = mutex4;
                        }
                        coroutine_suspended.unlock(null);
                        throw th;
                    }
                    i3 = c69073.I$1;
                    i4 = c69073.I$0;
                    boolean z9 = c69073.Z$1;
                    boolean z10 = c69073.Z$0;
                    Mutex mutex5 = (Mutex) c69073.L$5;
                    Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) c69073.L$4;
                    RectF rectF5 = (RectF) c69073.L$3;
                    matrix2 = (Matrix) c69073.L$2;
                    surface2 = (Surface) c69073.L$1;
                    pdfPageKt = (PdfPageKt) c69073.L$0;
                    ResultKt.throwOnFailure(objWithContext);
                    mutex = mutex5;
                    rectF2 = rectF5;
                    z4 = z9;
                    booleanRef = booleanRef5;
                    z3 = z10;
                }
                int[] iArr2 = new int[2];
                long[] jArr2 = new long[2];
                MainCoroutineDispatcher main3 = Dispatchers.getMain();
                PdfPageKt$renderPage$4$1 pdfPageKt$renderPage$4$1 = new PdfPageKt$renderPage$4$1(surface2, iArr2, jArr2, null);
                c69073.L$0 = pdfPageKt;
                c69073.L$1 = surface2;
                c69073.L$2 = matrix2;
                c69073.L$3 = rectF2;
                c69073.L$4 = booleanRef;
                c69073.L$5 = mutex;
                c69073.L$6 = iArr2;
                c69073.L$7 = jArr2;
                c69073.Z$0 = z3;
                c69073.Z$1 = z4;
                c69073.I$0 = i4;
                c69073.I$1 = i3;
                c69073.label = 2;
                Object objWithContext2 = BuildersKt.withContext(main3, pdfPageKt$renderPage$4$1, c69073);
                ?? r9 = coroutine_suspended;
                if (objWithContext2 == r9) {
                    return r9;
                }
                i5 = i3;
                mutex2 = mutex;
                i6 = i4;
                rectF3 = rectF2;
                z5 = z3;
                z6 = z4;
                matrix3 = matrix2;
                surface3 = surface2;
                pdfPageKt2 = pdfPageKt;
                jArr = jArr2;
                booleanRef2 = booleanRef;
                iArr = iArr2;
                r7 = r9;
                j = jArr[0];
                j2 = jArr[1];
                i7 = iArr[0];
                i8 = iArr[1];
                Logger.INSTANCE.mo1818d("PdfPageKt", "nativeWindow: " + j);
                if (j2 != 0) {
                    coroutineDispatcher = pdfPageKt2.dispatcher;
                    pdfPageKt$renderPage$4$2 = new PdfPageKt$renderPage$4$2(booleanRef2, pdfPageKt2, j2, i7, i8, matrix3, rectF3, z5, z6, i6, i5, null);
                    c69073.L$0 = surface3;
                    c69073.L$1 = booleanRef2;
                    c69073.L$2 = mutex2;
                    c69073.L$3 = null;
                    c69073.L$4 = null;
                    c69073.L$5 = null;
                    c69073.L$6 = null;
                    c69073.L$7 = null;
                    c69073.J$0 = j;
                    c69073.J$1 = j2;
                    c69073.label = 3;
                    if (BuildersKt.withContext(coroutineDispatcher, pdfPageKt$renderPage$4$2, c69073) == r7) {
                        return r7;
                    }
                    booleanRef3 = booleanRef2;
                    r8 = r7;
                    MainCoroutineDispatcher main4 = Dispatchers.getMain();
                    PdfPageKt$renderPage$4$3 pdfPageKt$renderPage$4$5 = new PdfPageKt$renderPage$4$3(surface3, j, j2, null);
                    c69073.L$0 = booleanRef3;
                    c69073.L$1 = mutex2;
                    obj = null;
                    c69073.L$2 = null;
                    c69073.label = 4;
                    objWithContext = BuildersKt.withContext(main4, pdfPageKt$renderPage$4$5, c69073);
                    if (objWithContext == r8) {
                        return r8;
                    }
                    mutex2.unlock(obj);
                    return Boxing.boxBoolean(booleanRef3.element);
                }
                Boolean boolBoxBoolean2 = Boxing.boxBoolean(false);
                mutex2.unlock(null);
                return boolBoxBoolean2;
            } catch (Throwable th3) {
                th = th3;
                coroutine_suspended = mutex;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ int $drawSizeX;
        final /* synthetic */ int $drawSizeY;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69082(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, Continuation<? super C69082> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$startX = i;
            this.$startY = i2;
            this.$drawSizeX = i3;
            this.$drawSizeY = i4;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i5;
            this.$pageBackgroundColor = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69082(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object renderPageBitmap(@NotNull Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C69082(bitmap, i, i2, i3, i4, z, z2, i5, i6, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69094 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $canvasColor;
        final /* synthetic */ RectF $clipRect;
        final /* synthetic */ Matrix $matrix;
        final /* synthetic */ int $pageBackgroundColor;
        final /* synthetic */ boolean $renderAnnot;
        final /* synthetic */ boolean $textMask;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69094(Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, int i, int i2, Continuation<? super C69094> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$matrix = matrix;
            this.$clipRect = rectF;
            this.$renderAnnot = z;
            this.$textMask = z2;
            this.$canvasColor = i;
            this.$pageBackgroundColor = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69094(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69094) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PdfPageKt.this.getPage().renderPageBitmap(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object renderPageBitmap(@Nullable Bitmap bitmap, @NotNull Matrix matrix, @NotNull RectF rectF, boolean z, boolean z2, int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C69094(bitmap, matrix, rectF, z, z2, i, i2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2 */
    @Metadata(m1835d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1836d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageLinks$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfDocument.Link>>, Object> {
        int label;

        C68932(Continuation<? super C68932> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C68932(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfDocument.Link>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<PdfDocument.Link>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfDocument.Link>> continuation) {
            return ((C68932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().getPageLinks();
        }
    }

    @Nullable
    public final Object getPageLinks(@NotNull Continuation<? super List<PdfDocument.Link>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68932(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/Point;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapPageCoordsToDevice$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Point>, Object> {
        final /* synthetic */ double $pageX;
        final /* synthetic */ double $pageY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69022(int i, int i2, int i3, int i4, int i5, double d, double d2, Continuation<? super C69022> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$pageX = d;
            this.$pageY = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69022(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Point> continuation) {
            return ((C69022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapPageCoordsToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$pageX, this.$pageY);
        }
    }

    @Nullable
    public final Object mapPageCoordsToDevice(int i, int i2, int i3, int i4, int i5, double d, double d2, @NotNull Continuation<? super Point> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69022(i, i2, i3, i4, i5, d, d2, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/PointF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapDeviceCoordsToPage$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PointF>, Object> {
        final /* synthetic */ int $deviceX;
        final /* synthetic */ int $deviceY;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69012(int i, int i2, int i3, int i4, int i5, int i6, int i7, Continuation<? super C69012> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$deviceX = i6;
            this.$deviceY = i7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69012(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PointF> continuation) {
            return ((C69012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapDeviceCoordsToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$deviceX, this.$deviceY);
        }
    }

    @Nullable
    public final Object mapDeviceCoordsToPage(int i, int i2, int i3, int i4, int i5, int i6, int i7, @NotNull Continuation<? super PointF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69012(i, i2, i3, i4, i5, i6, i7, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/Rect;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Rect>, Object> {
        final /* synthetic */ RectF $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69032(int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation<? super C69032> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rectF;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69032(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Rect> continuation) {
            return ((C69032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    @Nullable
    public final Object mapRectToDevice(int i, int i2, int i3, int i4, int i5, @NotNull RectF rectF, @NotNull Continuation<? super Rect> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69032(i, i2, i3, i4, i5, rectF, null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "Landroid/graphics/RectF;", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToPage$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C69042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
        final /* synthetic */ Rect $coords;
        final /* synthetic */ int $rotate;
        final /* synthetic */ int $sizeX;
        final /* synthetic */ int $sizeY;
        final /* synthetic */ int $startX;
        final /* synthetic */ int $startY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69042(int i, int i2, int i3, int i4, int i5, Rect rect, Continuation<? super C69042> continuation) {
            super(2, continuation);
            this.$startX = i;
            this.$startY = i2;
            this.$sizeX = i3;
            this.$sizeY = i4;
            this.$rotate = i5;
            this.$coords = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfPageKt.this.new C69042(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
            return ((C69042) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PdfPageKt.this.getPage().mapRectToPage(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
    }

    @Nullable
    public final Object mapRectToPage(int i, int i2, int i3, int i4, int i5, @NotNull Rect rect, @NotNull Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C69042(i, i2, i3, i4, i5, rect, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.page.close();
    }

    public final boolean safeClose() {
        try {
            this.page.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.mo1819e("PdfPageKt", e, "PdfPageKt.safeClose");
            return false;
        }
    }
}
