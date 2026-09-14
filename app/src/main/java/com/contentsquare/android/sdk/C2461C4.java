package com.contentsquare.android.sdk;

import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2461C4 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.C4$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final WeakReference<RecyclerView> f1462a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final Parcelable f1463b;

        public a(@NotNull WeakReference<RecyclerView> recyclerViewRef, @Nullable Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(recyclerViewRef, "recyclerViewRef");
            this.f1462a = recyclerViewRef;
            this.f1463b = parcelable;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.C4$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewScroller", m1845f = "RecyclerViewScroller.kt", m1846i = {0}, m1847l = {36, 38}, m1848m = "scrollByAndWait", m1849n = {"delayAfterScrollMilliseconds"}, m1850s = {"I$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public int f1464a;

        /* JADX INFO: renamed from: b */
        public /* synthetic */ Object f1465b;

        /* JADX INFO: renamed from: d */
        public int f1467d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1465b = obj;
            this.f1467d |= Integer.MIN_VALUE;
            return C2461C4.this.m883a(null, 0, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m883a(@NotNull RecyclerView recyclerView, int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i3 = bVar.f1467d;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bVar.f1467d = i3 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.f1465b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = bVar.f1467d;
        if (i4 != 0) {
            if (i4 == 1) {
                i2 = bVar.f1464a;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        recyclerView.scrollBy(0, i);
        recyclerView.requestLayout();
        bVar.f1464a = i2;
        bVar.f1467d = 1;
        if (C2829n8.m1182a(recyclerView, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (i2 <= 0) {
            return Unit.INSTANCE;
        }
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(i2, DurationUnit.MILLISECONDS);
        bVar.f1467d = 2;
        if (DelayKt.m5913delayVtjQ1oo(duration, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m884a(@NotNull RecyclerView recyclerView, int i, @NotNull Continuation continuation) {
        C2471D4 c2471d4;
        if (continuation instanceof C2471D4) {
            c2471d4 = (C2471D4) continuation;
            int i2 = c2471d4.f1518d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c2471d4.f1518d = i2 - Integer.MIN_VALUE;
            } else {
                c2471d4 = new C2471D4(this, continuation);
            }
        } else {
            c2471d4 = new C2471D4(this, continuation);
        }
        Object obj = c2471d4.f1516b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c2471d4.f1518d;
        if (i3 != 0) {
            if (i3 == 1) {
                i = c2471d4.f1515a;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        recyclerView.scrollToPosition(0);
        c2471d4.f1515a = i;
        c2471d4.f1518d = 1;
        if (C2829n8.m1182a(recyclerView, c2471d4) == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (i <= 0) {
            return Unit.INSTANCE;
        }
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        c2471d4.f1518d = 2;
        if (DelayKt.m5913delayVtjQ1oo(duration, c2471d4) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
