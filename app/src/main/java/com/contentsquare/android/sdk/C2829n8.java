package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nViewExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewExt.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/ViewExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,49:1\n314#2,11:50\n314#2,11:61\n*S KotlinDebug\n*F\n+ 1 ViewExt.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/ViewExtKt\n*L\n16#1:50,11\n41#1:61,11\n*E\n"})
public final class C2829n8 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.n8$a */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f2923a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ b f2924b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, b bVar) {
            super(1);
            this.f2923a = view;
            this.f2924b = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            this.f2923a.removeOnLayoutChangeListener(this.f2924b);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.n8$b */
    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ CancellableContinuation<Unit> f2925a;

        public b(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f2925a = cancellableContinuationImpl;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            CancellableContinuation<Unit> cancellableContinuation = this.f2925a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m5277constructorimpl(Unit.INSTANCE));
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static final Object m1181a(@NotNull View view, @NotNull C2836o5.a aVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
        cancellableContinuationImpl.initCancellability();
        RunnableC2819m8 runnableC2819m8 = new RunnableC2819m8(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new C2809l8(view, runnableC2819m8));
        view.postOnAnimation(runnableC2819m8);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(aVar);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static final Object m1182a(@NotNull View view, @NotNull Continuation<? super Unit> continuation) {
        if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        b bVar = new b(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new a(view, bVar));
        view.addOnLayoutChangeListener(bVar);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
