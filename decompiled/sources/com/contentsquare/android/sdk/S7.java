package com.contentsquare.android.sdk;

import android.graphics.Rect;
import com.contentsquare.android.core.communication.compose.ComposeLazyScroller;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.sdk.Z4;
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
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeLazyUseCase$capture$2", f = "VerticalComposeLazyUseCase.kt", i = {1}, l = {29, 51}, m = "invokeSuspend", n = {"throwable"}, s = {"L$2"})
/* loaded from: classes2.dex */
public final class S7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public T7 a;
    public Throwable b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ T7 e;
    public final /* synthetic */ ComposeLazyScroller f;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.VerticalComposeLazyUseCase$capture$2$1$1", f = "VerticalComposeLazyUseCase.kt", i = {0, 0, 0, 0, 0, 1}, l = {30, 41, 48}, m = "invokeSuspend", n = {"itemsToProcess", "pageRect", "itemsCount", "processedItemsCount", "isLastPage", "context"}, s = {"L$0", "L$1", "I$0", "I$1", "Z$0", "L$0"})
    @SourceDebugExtension({"SMAP\nVerticalComposeLazyUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/VerticalComposeLazyUseCase$capture$2$1$1\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,56:1\n337#2,10:57\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/VerticalComposeLazyUseCase$capture$2$1$1\n*L\n36#1:57,10\n*E\n"})
    public static final class a extends SuspendLambda implements Function6<Integer, Integer, List<? extends ViewNode>, Rect, Boolean, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ int b;
        public /* synthetic */ int c;
        public /* synthetic */ Object d;
        public /* synthetic */ Rect e;
        public /* synthetic */ boolean f;
        public final /* synthetic */ long g;
        public final /* synthetic */ String h;
        public final /* synthetic */ ComposeLazyScroller i;
        public final /* synthetic */ T7 j;

        /* renamed from: com.contentsquare.android.sdk.S7$a$a, reason: collision with other inner class name */
        public static final class C0043a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ T7 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0043a(T7 t7) {
                super(0);
                this.a = t7;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                this.a.a.a.tryEmit(Z4.d.a);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, String str, ComposeLazyScroller composeLazyScroller, T7 t7, Continuation<? super a> continuation) {
            super(6, continuation);
            this.g = j;
            this.h = str;
            this.i = composeLazyScroller;
            this.j = t7;
        }

        @Override // kotlin.jvm.functions.Function6
        public final Object invoke(Integer num, Integer num2, List<? extends ViewNode> list, Rect rect, Boolean bool, Continuation<? super Unit> continuation) {
            int iIntValue = num.intValue();
            int iIntValue2 = num2.intValue();
            boolean zBooleanValue = bool.booleanValue();
            a aVar = new a(this.g, this.h, this.i, this.j, continuation);
            aVar.b = iIntValue;
            aVar.c = iIntValue2;
            aVar.d = list;
            aVar.e = rect;
            aVar.f = zBooleanValue;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00c2 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.a
                r3 = 0
                r4 = 3
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L42
                if (r2 == r6) goto L2a
                if (r2 == r5) goto L21
                if (r2 != r4) goto L19
                kotlin.ResultKt.throwOnFailure(r21)
                goto Lc3
            L19:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L21:
                java.lang.Object r2 = r0.d
                com.contentsquare.android.sdk.d6$a r2 = (com.contentsquare.android.sdk.AbstractC0657d6.a) r2
                kotlin.ResultKt.throwOnFailure(r21)
                goto La2
            L2a:
                boolean r2 = r0.f
                int r6 = r0.c
                int r7 = r0.b
                android.graphics.Rect r8 = r0.e
                java.lang.Object r9 = r0.d
                java.util.List r9 = (java.util.List) r9
                kotlin.ResultKt.throwOnFailure(r21)
                r19 = r2
                r15 = r6
                r14 = r7
                r18 = r8
                r17 = r9
                goto L6f
            L42:
                kotlin.ResultKt.throwOnFailure(r21)
                int r7 = r0.b
                int r2 = r0.c
                java.lang.Object r8 = r0.d
                r9 = r8
                java.util.List r9 = (java.util.List) r9
                android.graphics.Rect r8 = r0.e
                boolean r10 = r0.f
                long r11 = r0.g
                r0.d = r9
                r0.e = r8
                r0.b = r7
                r0.c = r2
                r0.f = r10
                r0.a = r6
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.m3608delayVtjQ1oo(r11, r0)
                if (r6 != r1) goto L67
                return r1
            L67:
                r15 = r2
                r14 = r7
                r18 = r8
                r17 = r9
                r19 = r10
            L6f:
                com.contentsquare.android.sdk.d6$a r2 = new com.contentsquare.android.sdk.d6$a
                java.lang.String r12 = r0.h
                com.contentsquare.android.core.communication.compose.ComposeLazyScroller r13 = r0.i
                android.graphics.Rect r6 = r13.getScrollableRect()
                android.graphics.RectF r7 = new android.graphics.RectF
                r7.<init>(r6)
                android.graphics.Rect r6 = new android.graphics.Rect
                r6.<init>()
                r7.roundOut(r6)
                r11 = r2
                r16 = r6
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
                com.contentsquare.android.sdk.T7 r6 = r0.j
                com.contentsquare.android.sdk.e6 r7 = r6.b
                com.contentsquare.android.sdk.S7$a$a r8 = new com.contentsquare.android.sdk.S7$a$a
                r8.<init>(r6)
                r0.d = r2
                r0.e = r3
                r0.a = r5
                java.lang.Object r5 = r7.a(r8, r0)
                if (r5 != r1) goto La2
                return r1
            La2:
                com.contentsquare.android.sdk.T7 r5 = r0.j
                com.contentsquare.android.sdk.Q7 r5 = r5.a
                int r6 = r2.d
                int r7 = r2.c
                kotlinx.coroutines.flow.MutableStateFlow<com.contentsquare.android.sdk.Z4> r5 = r5.a
                com.contentsquare.android.sdk.Z4$e r8 = new com.contentsquare.android.sdk.Z4$e
                r8.<init>(r6, r7)
                r5.tryEmit(r8)
                com.contentsquare.android.sdk.T7 r5 = r0.j
                com.contentsquare.android.sdk.Q7 r5 = r5.a
                r0.d = r3
                r0.a = r4
                java.lang.Object r0 = r5.a(r2, r0)
                if (r0 != r1) goto Lc3
                return r1
            Lc3:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.S7.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S7(T7 t7, ComposeLazyScroller composeLazyScroller, Continuation<? super S7> continuation) {
        super(2, continuation);
        this.e = t7;
        this.f = composeLazyScroller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        S7 s7 = new S7(this.e, this.f, continuation);
        s7.d = obj;
        return s7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((S7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM2968constructorimpl;
        T7 t7;
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
            T7 t72 = this.e;
            ComposeLazyScroller composeLazyScroller = this.f;
            Result.Companion companion2 = Result.INSTANCE;
            Duration.Companion companion3 = Duration.INSTANCE;
            long duration = DurationKt.toDuration(t72.c.getInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, 0), DurationUnit.MILLISECONDS);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            a aVar = new a(duration, string, composeLazyScroller, t72, null);
            this.c = 1;
            if (composeLazyScroller.scrollForCapture(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = this.b;
                t7 = this.a;
                obj2 = this.d;
                ResultKt.throwOnFailure(obj);
                t7.a.a(th);
                objM2968constructorimpl = obj2;
                return Result.m2967boximpl(objM2968constructorimpl);
            }
            ResultKt.throwOnFailure(obj);
        }
        objM2968constructorimpl = Result.m2968constructorimpl(Unit.INSTANCE);
        t7 = this.e;
        Throwable thM2971exceptionOrNullimpl = Result.m2971exceptionOrNullimpl(objM2968constructorimpl);
        if (thM2971exceptionOrNullimpl != null) {
            this.d = objM2968constructorimpl;
            this.a = t7;
            this.b = thM2971exceptionOrNullimpl;
            this.c = 2;
            if (YieldKt.yield(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objM2968constructorimpl;
            th = thM2971exceptionOrNullimpl;
            t7.a.a(th);
            objM2968constructorimpl = obj2;
        }
        return Result.m2967boximpl(objM2968constructorimpl);
    }
}
