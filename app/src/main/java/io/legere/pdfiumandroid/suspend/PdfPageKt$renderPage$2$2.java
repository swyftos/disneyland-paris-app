package io.legere.pdfiumandroid.suspend;

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
@DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$2$2", m1845f = "PdfPageKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
final class PdfPageKt$renderPage$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bufferPtr;
    final /* synthetic */ int $canvasColor;
    final /* synthetic */ int $drawSizeX;
    final /* synthetic */ int $drawSizeY;
    final /* synthetic */ int $pageBackgroundColor;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ Ref.BooleanRef $retValue;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPage$2$2(Ref.BooleanRef booleanRef, PdfPageKt pdfPageKt, long j, int i, int i2, int i3, int i4, boolean z, int i5, int i6, Continuation<? super PdfPageKt$renderPage$2$2> continuation) {
        super(2, continuation);
        this.$retValue = booleanRef;
        this.this$0 = pdfPageKt;
        this.$bufferPtr = j;
        this.$startX = i;
        this.$startY = i2;
        this.$drawSizeX = i3;
        this.$drawSizeY = i4;
        this.$renderAnnot = z;
        this.$canvasColor = i5;
        this.$pageBackgroundColor = i6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$renderPage$2$2(this.$retValue, this.this$0, this.$bufferPtr, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$canvasColor, this.$pageBackgroundColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfPageKt$renderPage$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$retValue.element = this.this$0.getPage().renderPage(this.$bufferPtr, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$canvasColor, this.$pageBackgroundColor);
        return Unit.INSTANCE;
    }
}
