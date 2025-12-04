package com.contentsquare.android.sdk;

import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.DialogFragmentC0642c1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class W2 implements InterfaceC0662e1 {

    @NotNull
    public final M2 a;

    @NotNull
    public final PreferencesStore b;

    @NotNull
    public final Function0<Unit> c;

    @Nullable
    public DialogFragmentC0642c1 d;

    @Nullable
    public Function1<? super C0652d1, Unit> e;

    public W2(@NotNull M2 liveActivityProvider, @NotNull PreferencesStore preferenceStore, @NotNull a.f onExplanationDismissed) {
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        Intrinsics.checkNotNullParameter(onExplanationDismissed, "onExplanationDismissed");
        this.a = liveActivityProvider;
        this.b = preferenceStore;
        this.c = onExplanationDismissed;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0662e1
    public final void a() {
        this.c.invoke();
        this.d = null;
        this.e = null;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0662e1
    public final void a(@NotNull DialogFragmentC0642c1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.e = callback;
    }
}
