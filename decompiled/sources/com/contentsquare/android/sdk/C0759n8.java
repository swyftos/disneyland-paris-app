package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.contentsquare.android.sdk.C0766o5;
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

@SourceDebugExtension({"SMAP\nViewExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewExt.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/ViewExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,49:1\n314#2,11:50\n314#2,11:61\n*S KotlinDebug\n*F\n+ 1 ViewExt.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/ViewExtKt\n*L\n16#1:50,11\n41#1:61,11\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.n8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0759n8 {

    /* renamed from: com.contentsquare.android.sdk.n8$a */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ View a;
        public final /* synthetic */ b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, b bVar) {
            super(1);
            this.a = view;
            this.b = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            this.a.removeOnLayoutChangeListener(this.b);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.n8$b */
    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ CancellableContinuation<Unit> a;

        public b(CancellableContinuationImpl cancellableContinuationImpl) {
            this.a = cancellableContinuationImpl;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            CancellableContinuation<Unit> cancellableContinuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m2968constructorimpl(Unit.INSTANCE));
        }
    }

    @Nullable
    public static final Object a(@NotNull View view, @NotNull C0766o5.a aVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
        cancellableContinuationImpl.initCancellability();
        RunnableC0749m8 runnableC0749m8 = new RunnableC0749m8(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new C0739l8(view, runnableC0749m8));
        view.postOnAnimation(runnableC0749m8);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(aVar);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Nullable
    public static final Object a(@NotNull View view, @NotNull Continuation<? super Unit> continuation) {
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
