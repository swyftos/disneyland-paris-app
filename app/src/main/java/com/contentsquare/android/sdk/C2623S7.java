package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.graphics.RectF;
import com.contentsquare.android.core.communication.compose.ComposeLazyScroller;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.List;
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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.S7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeLazyUseCase$capture$2", m1845f = "VerticalComposeLazyUseCase.kt", m1846i = {1}, m1847l = {29, 51}, m1848m = "invokeSuspend", m1849n = {"throwable"}, m1850s = {"L$2"})
public final class C2623S7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

    /* JADX INFO: renamed from: a */
    public C2633T7 f2101a;

    /* JADX INFO: renamed from: b */
    public Throwable f2102b;

    /* JADX INFO: renamed from: c */
    public int f2103c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2104d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2633T7 f2105e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ComposeLazyScroller f2106f;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S7$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeLazyUseCase$capture$2$1$1", m1845f = "VerticalComposeLazyUseCase.kt", m1846i = {0, 0, 0, 0, 0, 1}, m1847l = {30, 41, 48}, m1848m = "invokeSuspend", m1849n = {"itemsToProcess", "pageRect", "itemsCount", "processedItemsCount", "isLastPage", "context"}, m1850s = {"L$0", "L$1", "I$0", "I$1", "Z$0", "L$0"})
    @SourceDebugExtension({"SMAP\nVerticalComposeLazyUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/VerticalComposeLazyUseCase$capture$2$1$1\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,56:1\n337#2,10:57\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/VerticalComposeLazyUseCase$capture$2$1$1\n*L\n36#1:57,10\n*E\n"})
    public static final class a extends SuspendLambda implements Function6<Integer, Integer, List<? extends ViewNode>, Rect, Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2107a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ int f2108b;

        /* JADX INFO: renamed from: c */
        public /* synthetic */ int f2109c;

        /* JADX INFO: renamed from: d */
        public /* synthetic */ Object f2110d;

        /* JADX INFO: renamed from: e */
        public /* synthetic */ Rect f2111e;

        /* JADX INFO: renamed from: f */
        public /* synthetic */ boolean f2112f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ long f2113g;

        /* JADX INFO: renamed from: h */
        public final /* synthetic */ String f2114h;

        /* JADX INFO: renamed from: i */
        public final /* synthetic */ ComposeLazyScroller f2115i;

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C2633T7 f2116j;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.S7$a$a, reason: collision with other inner class name */
        public static final class C8139a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ C2633T7 f2117a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8139a(C2633T7 c2633t7) {
                super(0);
                this.f2117a = c2633t7;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                this.f2117a.f2156a.f2369a.tryEmit(AbstractC2686Z4.d.f2337a);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, String str, ComposeLazyScroller composeLazyScroller, C2633T7 c2633t7, Continuation<? super a> continuation) {
            super(6, continuation);
            this.f2113g = j;
            this.f2114h = str;
            this.f2115i = composeLazyScroller;
            this.f2116j = c2633t7;
        }

        @Override // kotlin.jvm.functions.Function6
        public final Object invoke(Integer num, Integer num2, List<? extends ViewNode> list, Rect rect, Boolean bool, Continuation<? super Unit> continuation) {
            int iIntValue = num.intValue();
            int iIntValue2 = num2.intValue();
            boolean zBooleanValue = bool.booleanValue();
            a aVar = new a(this.f2113g, this.f2114h, this.f2115i, this.f2116j, continuation);
            aVar.f2108b = iIntValue;
            aVar.f2109c = iIntValue2;
            aVar.f2110d = list;
            aVar.f2111e = rect;
            aVar.f2112f = zBooleanValue;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00c2 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i;
            int i2;
            Rect rect;
            List list;
            boolean z;
            AbstractC2727d6.a aVar;
            C2604Q7 c2604q7;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f2107a;
            if (i3 != 0) {
                if (i3 == 1) {
                    boolean z2 = this.f2112f;
                    int i4 = this.f2109c;
                    int i5 = this.f2108b;
                    Rect rect2 = this.f2111e;
                    List list2 = (List) this.f2110d;
                    ResultKt.throwOnFailure(obj);
                    z = z2;
                    i = i4;
                    i2 = i5;
                    rect = rect2;
                    list = list2;
                } else if (i3 == 2) {
                    aVar = (AbstractC2727d6.a) this.f2110d;
                    ResultKt.throwOnFailure(obj);
                    this.f2116j.f2156a.f2369a.tryEmit(new AbstractC2686Z4.e(aVar.f2502d, aVar.f2501c));
                    c2604q7 = this.f2116j.f2156a;
                    this.f2110d = null;
                    this.f2107a = 3;
                    if (c2604q7.m1086a(aVar, (Continuation<? super Unit>) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            int i6 = this.f2108b;
            int i7 = this.f2109c;
            List list3 = (List) this.f2110d;
            Rect rect3 = this.f2111e;
            boolean z3 = this.f2112f;
            long j = this.f2113g;
            this.f2110d = list3;
            this.f2111e = rect3;
            this.f2108b = i6;
            this.f2109c = i7;
            this.f2112f = z3;
            this.f2107a = 1;
            if (DelayKt.m5913delayVtjQ1oo(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i7;
            i2 = i6;
            rect = rect3;
            list = list3;
            z = z3;
            String str = this.f2114h;
            ComposeLazyScroller composeLazyScroller = this.f2115i;
            RectF rectF = new RectF(composeLazyScroller.getScrollableRect());
            Rect rect4 = new Rect();
            rectF.roundOut(rect4);
            aVar = new AbstractC2727d6.a(str, composeLazyScroller, i2, i, rect4, list, rect, z);
            C2633T7 c2633t7 = this.f2116j;
            C2737e6 c2737e6 = c2633t7.f2157b;
            C8139a c8139a = new C8139a(c2633t7);
            this.f2110d = aVar;
            this.f2111e = null;
            this.f2107a = 2;
            if (c2737e6.m1123a(c8139a, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.f2116j.f2156a.f2369a.tryEmit(new AbstractC2686Z4.e(aVar.f2502d, aVar.f2501c));
            c2604q7 = this.f2116j.f2156a;
            this.f2110d = null;
            this.f2107a = 3;
            if (c2604q7.m1086a(aVar, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2623S7(C2633T7 c2633t7, ComposeLazyScroller composeLazyScroller, Continuation<? super C2623S7> continuation) {
        super(2, continuation);
        this.f2105e = c2633t7;
        this.f2106f = composeLazyScroller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C2623S7 c2623s7 = new C2623S7(this.f2105e, this.f2106f, continuation);
        c2623s7.f2104d = obj;
        return c2623s7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((C2623S7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM5277constructorimpl;
        C2633T7 c2633t7;
        Object obj2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2103c;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = this.f2102b;
                    c2633t7 = this.f2101a;
                    obj2 = this.f2104d;
                    ResultKt.throwOnFailure(obj);
                }
                c2633t7.f2156a.m1087a(th);
                objM5277constructorimpl = obj2;
                return Result.m5276boximpl(objM5277constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
            C2633T7 c2633t8 = this.f2105e;
            ComposeLazyScroller composeLazyScroller = this.f2106f;
            Result.Companion companion = Result.INSTANCE;
            Duration.Companion companion2 = Duration.INSTANCE;
            long duration = DurationKt.toDuration(c2633t8.f2158c.getInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, 0), DurationUnit.MILLISECONDS);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            a aVar = new a(duration, string, composeLazyScroller, c2633t8, null);
            this.f2103c = 1;
            if (composeLazyScroller.scrollForCapture(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objM5277constructorimpl = Result.m5277constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th2));
        }
        c2633t7 = this.f2105e;
        Throwable thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5277constructorimpl);
        if (thM5280exceptionOrNullimpl != null) {
            this.f2104d = objM5277constructorimpl;
            this.f2101a = c2633t7;
            this.f2102b = thM5280exceptionOrNullimpl;
            this.f2103c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM5277constructorimpl;
            th = thM5280exceptionOrNullimpl;
            c2633t7.f2156a.m1087a(th);
            objM5277constructorimpl = obj2;
        }
        return Result.m5276boximpl(objM5277constructorimpl);
    }
}
