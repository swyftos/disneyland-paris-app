package com.contentsquare.android.sdk;

import android.app.Activity;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay.C2365a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N6 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nStatusDialogManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatusDialogManager.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/statusdialog/StatusDialogManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
public final class C2573N6 implements InterfaceC2732e1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2559M2 f1890a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Function0<Unit> f1891b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public DialogFragmentC2712c1 f1892c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public Function1<? super C2722d1, Unit> f1893d;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.N6$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.statusdialog.StatusDialogManager", m1845f = "StatusDialogManager.kt", m1846i = {}, m1847l = {36}, m1848m = "showDialog", m1849n = {}, m1850s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public DialogFragmentC2712c1 f1894a;

        /* JADX INFO: renamed from: b */
        public C2573N6 f1895b;

        /* JADX INFO: renamed from: c */
        public /* synthetic */ Object f1896c;

        /* JADX INFO: renamed from: e */
        public int f1898e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f1896c = obj;
            this.f1898e |= Integer.MIN_VALUE;
            return C2573N6.this.m991a(this);
        }
    }

    public C2573N6(@NotNull C2559M2 liveActivityProvider, @NotNull C2365a.g onDialogDismissed) {
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(onDialogDismissed, "onDialogDismissed");
        this.f1890a = liveActivityProvider;
        this.f1891b = onDialogDismissed;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2732e1
    /* JADX INFO: renamed from: a */
    public final void mo992a() {
        this.f1891b.invoke();
        this.f1892c = null;
        this.f1893d = null;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2732e1
    /* JADX INFO: renamed from: a */
    public final void mo993a(@NotNull DialogFragmentC2712c1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f1893d = callback;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m991a(@NotNull Continuation<? super Unit> continuation) {
        a aVar;
        DialogFragmentC2712c1 dialogFragmentC2712c1;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f1898e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f1898e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f1896c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f1898e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DialogFragmentC2712c1 dialogFragmentC2712c2 = new DialogFragmentC2712c1();
            Activity activity = this.f1890a.f1856a.get();
            if (activity != null) {
                aVar.f1894a = dialogFragmentC2712c2;
                aVar.f1895b = this;
                aVar.f1898e = 1;
                if (dialogFragmentC2712c2.m1105a(activity, this, aVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            dialogFragmentC2712c1 = dialogFragmentC2712c2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = aVar.f1895b;
            dialogFragmentC2712c1 = aVar.f1894a;
            ResultKt.throwOnFailure(obj);
        }
        this.f1892c = dialogFragmentC2712c1;
        return Unit.INSTANCE;
    }
}
