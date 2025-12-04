package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.compose.ComposePageScroller;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.Z4;
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

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeScrollUseCase$capture$2", f = "VerticalComposeScrollUseCase.kt", i = {1}, l = {19, 34}, m = "invokeSuspend", n = {"throwable"}, s = {"L$2"})
/* loaded from: classes2.dex */
public final class X7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public Y7 a;
    public Throwable b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ ComposePageScroller e;
    public final /* synthetic */ Y7 f;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeScrollUseCase$capture$2$1$1", f = "VerticalComposeScrollUseCase.kt", i = {0}, l = {20, 29}, m = "invokeSuspend", n = {"page"}, s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ int b;
        public final /* synthetic */ Y7 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ComposePageScroller e;

        /* renamed from: com.contentsquare.android.sdk.X7$a$a, reason: collision with other inner class name */
        public static final class C0044a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Y7 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0044a(Y7 y7) {
                super(0);
                this.a = y7;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                this.a.a.a.tryEmit(Z4.d.a);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Y7 y7, String str, ComposePageScroller composePageScroller, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = y7;
            this.d = str;
            this.e = composePageScroller;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, this.e, continuation);
            aVar.b = ((Number) obj).intValue();
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
            int i2 = this.a;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.b;
                Y7 y7 = this.c;
                C0667e6 c0667e6 = y7.b;
                C0044a c0044a = new C0044a(y7);
                this.b = i;
                this.a = 1;
                if (c0667e6.a(c0044a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                i = this.b;
                ResultKt.throwOnFailure(obj);
            }
            AbstractC0657d6.b bVar = new AbstractC0657d6.b(this.d, i, this.e);
            this.c.a.a.tryEmit(new Z4.e(bVar.b, bVar.c.getNumberOfPages()));
            W7 w7 = this.c.a;
            this.a = 2;
            if (w7.a((W7) bVar, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X7(ComposePageScroller composePageScroller, Y7 y7, Continuation<? super X7> continuation) {
        super(2, continuation);
        this.e = composePageScroller;
        this.f = y7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        X7 x7 = new X7(this.e, this.f, continuation);
        x7.d = obj;
        return x7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((X7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM2968constructorimpl;
        Y7 y7;
        Object obj2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(th2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ComposePageScroller composePageScroller = this.e;
            Y7 y72 = this.f;
            Result.Companion companion2 = Result.INSTANCE;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            a aVar = new a(y72, string, composePageScroller, null);
            this.c = 1;
            if (composePageScroller.scrollForCapture(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = this.b;
                y7 = this.a;
                obj2 = this.d;
                ResultKt.throwOnFailure(obj);
                y7.a.a(th);
                objM2968constructorimpl = obj2;
                return Result.m2967boximpl(objM2968constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
        }
        objM2968constructorimpl = Result.m2968constructorimpl(Unit.INSTANCE);
        y7 = this.f;
        Throwable thM2971exceptionOrNullimpl = Result.m2971exceptionOrNullimpl(objM2968constructorimpl);
        if (thM2971exceptionOrNullimpl != null) {
            this.d = objM2968constructorimpl;
            this.a = y7;
            this.b = thM2971exceptionOrNullimpl;
            this.c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM2968constructorimpl;
            th = thM2971exceptionOrNullimpl;
            y7.a.a(th);
            objM2968constructorimpl = obj2;
        }
        return Result.m2967boximpl(objM2968constructorimpl);
    }
}
