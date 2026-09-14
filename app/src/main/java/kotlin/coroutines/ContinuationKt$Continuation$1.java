package kotlin.coroutines;

import ch.qos.logback.core.net.SyslogConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, m1836d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class ContinuationKt$Continuation$1 implements Continuation<Object> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function1 $resumeWith;

    public ContinuationKt$Continuation$1(CoroutineContext coroutineContext, Function1<? super Result<Object>, Unit> function1) {
        this.$context = coroutineContext;
        this.$resumeWith = function1;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public CoroutineContext get$context() {
        return this.$context;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        this.$resumeWith.invoke(Result.m5276boximpl(result));
    }
}
