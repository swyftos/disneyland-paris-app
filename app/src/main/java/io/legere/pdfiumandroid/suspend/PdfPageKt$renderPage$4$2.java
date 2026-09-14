package io.legere.pdfiumandroid.suspend;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
@DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$4$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
final class PdfPageKt$renderPage$4$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bufferPtr;
    final /* synthetic */ int $canvasColor;
    final /* synthetic */ RectF $clipRect;
    final /* synthetic */ Matrix $matrix;
    final /* synthetic */ int $pageBackgroundColor;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ Ref.BooleanRef $retValue;
    final /* synthetic */ int $surfaceHeight;
    final /* synthetic */ int $surfaceWidth;
    final /* synthetic */ boolean $textMask;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPage$4$2(Ref.BooleanRef booleanRef, PdfPageKt pdfPageKt, long j, int i, int i2, Matrix matrix, RectF rectF, boolean z, boolean z2, int i3, int i4, Continuation<? super PdfPageKt$renderPage$4$2> continuation) {
        super(2, continuation);
        this.$retValue = booleanRef;
        this.this$0 = pdfPageKt;
        this.$bufferPtr = j;
        this.$surfaceWidth = i;
        this.$surfaceHeight = i2;
        this.$matrix = matrix;
        this.$clipRect = rectF;
        this.$renderAnnot = z;
        this.$textMask = z2;
        this.$canvasColor = i3;
        this.$pageBackgroundColor = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$renderPage$4$2(this.$retValue, this.this$0, this.$bufferPtr, this.$surfaceWidth, this.$surfaceHeight, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfPageKt$renderPage$4$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$retValue.element = this.this$0.getPage().renderPage(this.$bufferPtr, this.$surfaceWidth, this.$surfaceHeight, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, this.$canvasColor, this.$pageBackgroundColor);
        return Unit.INSTANCE;
    }
}
