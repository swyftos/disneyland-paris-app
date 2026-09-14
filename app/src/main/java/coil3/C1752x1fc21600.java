package coil3;

import coil3.content.Logger;
import coil3.content.LoggingKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: renamed from: coil3.RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, m1836d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 RealImageLoader.kt\ncoil3/RealImageLoaderKt\n*L\n1#1,48:1\n232#2:49\n*E\n"})
public final class C1752x1fc21600 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Logger $logger$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1752x1fc21600(CoroutineExceptionHandler.Companion companion, Logger logger) {
        super(companion);
        this.$logger$inlined = logger;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        Logger logger = this.$logger$inlined;
        if (logger != null) {
            LoggingKt.log(logger, "RealImageLoader", exception);
        }
    }
}
