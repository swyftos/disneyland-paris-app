package io.legere.pdfiumandroid.suspend;

import com.urbanairship.reactnative.ReactMessageView;
import io.legere.pdfiumandroid.FindResult;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lio/legere/pdfiumandroid/suspend/FindResultKt;", "Ljava/io/Closeable;", "findResult", "Lio/legere/pdfiumandroid/FindResult;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/FindResult;Lkotlinx/coroutines/CoroutineDispatcher;)V", "findNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findPrev", "getSchResultIndex", "", "getSchCount", "closeFind", "", ReactMessageView.EVENT_CLOSE, "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FindResultKt implements Closeable {

    @NotNull
    private final CoroutineDispatcher dispatcher;

    @NotNull
    private final FindResult findResult;

    public FindResultKt(@NotNull FindResult findResult, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(findResult, "findResult");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.findResult = findResult;
        this.dispatcher = dispatcher;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2", m1845f = "FindResultKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C68722(Continuation<? super C68722> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C68722(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C68722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findNext());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object findNext(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68722(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2", m1845f = "FindResultKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C68732(Continuation<? super C68732> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C68732(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C68732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findPrev());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object findPrev(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68732(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2", m1845f = "FindResultKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C68752(Continuation<? super C68752> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C68752(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchResultIndex());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object getSchResultIndex(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68752(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2", m1845f = "FindResultKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        C68742(Continuation<? super C68742> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C68742(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C68742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchCount());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object getSchCount(@NotNull Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C68742(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2 */
    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1836d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    @DebugMetadata(m1844c = "io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2", m1845f = "FindResultKt.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    static final class C68712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68712(Continuation<? super C68712> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FindResultKt.this.new C68712(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FindResultKt.this.findResult.closeFind();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object closeFind(@NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C68712(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.findResult.closeFind();
    }
}
