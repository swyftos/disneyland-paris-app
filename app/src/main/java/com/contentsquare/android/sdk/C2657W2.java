package com.contentsquare.android.sdk;

import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay.C2365a;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2657W2 implements InterfaceC2732e1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2559M2 f2205a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final PreferencesStore f2206b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Function0<Unit> f2207c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public DialogFragmentC2712c1 f2208d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public Function1<? super C2722d1, Unit> f2209e;

    public C2657W2(@NotNull C2559M2 liveActivityProvider, @NotNull PreferencesStore preferenceStore, @NotNull C2365a.f onExplanationDismissed) {
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        Intrinsics.checkNotNullParameter(onExplanationDismissed, "onExplanationDismissed");
        this.f2205a = liveActivityProvider;
        this.f2206b = preferenceStore;
        this.f2207c = onExplanationDismissed;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2732e1
    /* JADX INFO: renamed from: a */
    public final void mo992a() {
        this.f2207c.invoke();
        this.f2208d = null;
        this.f2209e = null;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2732e1
    /* JADX INFO: renamed from: a */
    public final void mo993a(@NotNull DialogFragmentC2712c1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f2209e = callback;
    }
}
