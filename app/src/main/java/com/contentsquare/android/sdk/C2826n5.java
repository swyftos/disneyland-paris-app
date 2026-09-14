package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.view.View;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n5 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase$capture$2", m1845f = "ScrollViewCaptureUseCase.kt", m1846i = {2}, m1847l = {37, 42, 49}, m1848m = "invokeSuspend", m1849n = {"throwable"}, m1850s = {"L$2"})
public final class C2826n5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

    /* JADX INFO: renamed from: a */
    public Object f2915a;

    /* JADX INFO: renamed from: b */
    public Object f2916b;

    /* JADX INFO: renamed from: c */
    public int f2917c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2918d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2836o5 f2919e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractC2916w5 f2920f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2826n5(C2836o5 c2836o5, AbstractC2916w5 abstractC2916w5, Continuation<? super C2826n5> continuation) {
        super(2, continuation);
        this.f2919e = c2836o5;
        this.f2920f = abstractC2916w5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2826n5 c2826n5 = new C2826n5(this.f2919e, this.f2920f, continuation);
        c2826n5.f2918d = obj;
        return c2826n5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((C2826n5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:48:0x010c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x010d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM5277constructorimpl;
        C2836o5 c2836o5;
        Throwable thM5280exceptionOrNullimpl;
        Object obj2;
        Throwable th;
        C2836o5 c2836o6;
        AbstractC2916w5 abstractC2916w5;
        C2836o5 c2836o7;
        Point point;
        Unit unitM827d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2917c;
        try {
            if (i != 0) {
                if (i == 1) {
                    c2836o6 = (C2836o5) this.f2916b;
                    abstractC2916w5 = (AbstractC2916w5) this.f2915a;
                    c2836o7 = (C2836o5) this.f2918d;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        unitM827d = Unit.INSTANCE;
                        objM5277constructorimpl = Result.m5277constructorimpl(unitM827d);
                        c2836o5 = this.f2919e;
                        thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5277constructorimpl);
                        if (thM5280exceptionOrNullimpl != null) {
                            this.f2918d = objM5277constructorimpl;
                            this.f2915a = c2836o5;
                            this.f2916b = thM5280exceptionOrNullimpl;
                            this.f2917c = 3;
                            if (YieldKt.yield(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = objM5277constructorimpl;
                            th = thM5280exceptionOrNullimpl;
                        }
                        return Result.m5276boximpl(objM5277constructorimpl);
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.f2916b;
                    c2836o5 = (C2836o5) this.f2915a;
                    obj2 = this.f2918d;
                    ResultKt.throwOnFailure(obj);
                }
                c2836o5.f2939a.m1087a(th);
                objM5277constructorimpl = obj2;
                return Result.m5276boximpl(objM5277constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
            c2836o6 = this.f2919e;
            abstractC2916w5 = this.f2920f;
            Result.Companion companion = Result.INSTANCE;
            c2836o6.f2941c.f2295a.set(false);
            View view = abstractC2916w5.mo1226a();
            c2836o6.f2940b.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            c2836o6.f2945g = new C2899u8.a(new WeakReference(view), new Point(view.getScrollX(), view.getScrollY()));
            C2940z c2940z = c2836o6.f2942d;
            this.f2918d = c2836o6;
            this.f2915a = abstractC2916w5;
            this.f2916b = c2836o6;
            this.f2917c = 1;
            obj = c2940z.m1240a(abstractC2916w5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            c2836o7 = c2836o6;
            c2836o6.f2944f = (C2940z.a) obj;
            c2836o7.getClass();
            View viewMo1226a = abstractC2916w5.mo1226a();
            if (abstractC2916w5 instanceof AbstractC2916w5.a) {
                point = new Point(viewMo1226a.getScrollX(), 0);
            } else {
                if (!(abstractC2916w5 instanceof AbstractC2916w5.b ? true : abstractC2916w5 instanceof AbstractC2916w5.c)) {
                    throw new NoWhenBranchMatchedException();
                }
                point = new Point(0, viewMo1226a.getScrollY());
            }
            if (point.x < 0 || point.y < 0) {
                unitM827d = new Logger(null, 1, null).m827d("Unable to determine target scroll coordinates");
            } else {
                this.f2918d = null;
                this.f2915a = null;
                this.f2916b = null;
                this.f2917c = 2;
                if (C2836o5.m1186a(c2836o7, point, abstractC2916w5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                unitM827d = Unit.INSTANCE;
            }
            objM5277constructorimpl = Result.m5277constructorimpl(unitM827d);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th2));
        }
        c2836o5 = this.f2919e;
        thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5277constructorimpl);
        if (thM5280exceptionOrNullimpl != null) {
            this.f2918d = objM5277constructorimpl;
            this.f2915a = c2836o5;
            this.f2916b = thM5280exceptionOrNullimpl;
            this.f2917c = 3;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM5277constructorimpl;
            th = thM5280exceptionOrNullimpl;
            c2836o5.f2939a.m1087a(th);
            objM5277constructorimpl = obj2;
        }
        return Result.m5276boximpl(objM5277constructorimpl);
    }
}
