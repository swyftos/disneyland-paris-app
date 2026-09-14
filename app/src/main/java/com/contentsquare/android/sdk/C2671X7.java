package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.compose.ComposePageScroller;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.X7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeScrollUseCase$capture$2", m1845f = "VerticalComposeScrollUseCase.kt", m1846i = {1}, m1847l = {19, 34}, m1848m = "invokeSuspend", m1849n = {"throwable"}, m1850s = {"L$2"})
public final class C2671X7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

    /* JADX INFO: renamed from: a */
    public C2680Y7 f2279a;

    /* JADX INFO: renamed from: b */
    public Throwable f2280b;

    /* JADX INFO: renamed from: c */
    public int f2281c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2282d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ComposePageScroller f2283e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C2680Y7 f2284f;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.X7$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeScrollUseCase$capture$2$1$1", m1845f = "VerticalComposeScrollUseCase.kt", m1846i = {0}, m1847l = {20, 29}, m1848m = "invokeSuspend", m1849n = {"page"}, m1850s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2285a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ int f2286b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C2680Y7 f2287c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ String f2288d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ ComposePageScroller f2289e;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.X7$a$a, reason: collision with other inner class name */
        public static final class C8140a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ C2680Y7 f2290a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8140a(C2680Y7 c2680y7) {
                super(0);
                this.f2290a = c2680y7;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                this.f2290a.f2310a.f2369a.tryEmit(AbstractC2686Z4.d.f2337a);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C2680Y7 c2680y7, String str, ComposePageScroller composePageScroller, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f2287c = c2680y7;
            this.f2288d = str;
            this.f2289e = composePageScroller;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.f2287c, this.f2288d, this.f2289e, continuation);
            aVar.f2286b = ((Number) obj).intValue();
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return ((a) create(Integer.valueOf(num.intValue()), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f2285a;
            if (i2 != 0) {
                if (i2 == 1) {
                    i = this.f2286b;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            i = this.f2286b;
            C2680Y7 c2680y7 = this.f2287c;
            C2737e6 c2737e6 = c2680y7.f2311b;
            C8140a c8140a = new C8140a(c2680y7);
            this.f2286b = i;
            this.f2285a = 1;
            if (c2737e6.m1123a(c8140a, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            AbstractC2727d6.b bVar = new AbstractC2727d6.b(this.f2288d, i, this.f2289e);
            this.f2287c.f2310a.f2369a.tryEmit(new AbstractC2686Z4.e(bVar.f2508b, bVar.f2509c.getNumberOfPages()));
            C2662W7 c2662w7 = this.f2287c.f2310a;
            this.f2285a = 2;
            if (c2662w7.m1086a(bVar, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2671X7(ComposePageScroller composePageScroller, C2680Y7 c2680y7, Continuation<? super C2671X7> continuation) {
        super(2, continuation);
        this.f2283e = composePageScroller;
        this.f2284f = c2680y7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2671X7 c2671x7 = new C2671X7(this.f2283e, this.f2284f, continuation);
        c2671x7.f2282d = obj;
        return c2671x7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((C2671X7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM5277constructorimpl;
        C2680Y7 c2680y7;
        Object obj2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2281c;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = this.f2280b;
                    c2680y7 = this.f2279a;
                    obj2 = this.f2282d;
                    ResultKt.throwOnFailure(obj);
                }
                c2680y7.f2310a.m1087a(th);
                objM5277constructorimpl = obj2;
                return Result.m5276boximpl(objM5277constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
            ComposePageScroller composePageScroller = this.f2283e;
            C2680Y7 c2680y8 = this.f2284f;
            Result.Companion companion = Result.INSTANCE;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            a aVar = new a(c2680y8, string, composePageScroller, null);
            this.f2281c = 1;
            if (composePageScroller.scrollForCapture(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objM5277constructorimpl = Result.m5277constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th2));
        }
        c2680y7 = this.f2284f;
        Throwable thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5277constructorimpl);
        if (thM5280exceptionOrNullimpl != null) {
            this.f2282d = objM5277constructorimpl;
            this.f2279a = c2680y7;
            this.f2280b = thM5280exceptionOrNullimpl;
            this.f2281c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM5277constructorimpl;
            th = thM5280exceptionOrNullimpl;
            c2680y7.f2310a.m1087a(th);
            objM5277constructorimpl = obj2;
        }
        return Result.m5276boximpl(objM5277constructorimpl);
    }
}
