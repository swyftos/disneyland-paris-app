package com.contentsquare.android.sdk;

import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a;
import com.contentsquare.android.sdk.DialogFragmentC0642c1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nStatusDialogManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatusDialogManager.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/statusdialog/StatusDialogManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
/* loaded from: classes2.dex */
public final class N6 implements InterfaceC0662e1 {

    @NotNull
    public final M2 a;

    @NotNull
    public final Function0<Unit> b;

    @Nullable
    public DialogFragmentC0642c1 c;

    @Nullable
    public Function1<? super C0652d1, Unit> d;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.statusdialog.StatusDialogManager", f = "StatusDialogManager.kt", i = {}, l = {36}, m = "showDialog", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public DialogFragmentC0642c1 a;
        public N6 b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return N6.this.a(this);
        }
    }

    public N6(@NotNull M2 liveActivityProvider, @NotNull a.g onDialogDismissed) {
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(onDialogDismissed, "onDialogDismissed");
        this.a = liveActivityProvider;
        this.b = onDialogDismissed;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0662e1
    public final void a() {
        this.b.invoke();
        this.c = null;
        this.d = null;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0662e1
    public final void a(@NotNull DialogFragmentC0642c1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.d = callback;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.N6.a
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.N6$a r0 = (com.contentsquare.android.sdk.N6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.N6$a r0 = new com.contentsquare.android.sdk.N6$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            com.contentsquare.android.sdk.N6 r4 = r0.b
            com.contentsquare.android.sdk.c1 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L57
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            com.contentsquare.android.sdk.c1 r5 = new com.contentsquare.android.sdk.c1
            r5.<init>()
            com.contentsquare.android.sdk.M2 r2 = r4.a
            java.lang.ref.WeakReference<android.app.Activity> r2 = r2.a
            java.lang.Object r2 = r2.get()
            android.app.Activity r2 = (android.app.Activity) r2
            if (r2 == 0) goto L56
            r0.a = r5
            r0.b = r4
            r0.e = r3
            java.lang.Object r0 = r5.a(r2, r4, r0)
            if (r0 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r4.c = r0
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.N6.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
