package com.contentsquare.android.sdk;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v */
/* JADX INFO: loaded from: classes2.dex */
public final class C2900v implements InterfaceC2924x3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2920x f3162a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Handler f3163b;

    /* JADX INFO: renamed from: c */
    public Runnable f3164c;

    /* JADX INFO: renamed from: d */
    public boolean f3165d;

    public C2900v(@NotNull C2920x animationSupervisor, @NotNull Handler uiHandler) {
        Intrinsics.checkNotNullParameter(animationSupervisor, "animationSupervisor");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        this.f3162a = animationSupervisor;
        this.f3163b = uiHandler;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2924x3
    /* JADX INFO: renamed from: a */
    public final void mo1214a(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        boolean z = this.f3165d;
        boolean zM1229a = this.f3162a.m1229a(decorView);
        this.f3165d = zM1229a;
        if (!z || zM1229a) {
            return;
        }
        Handler handler = this.f3163b;
        Runnable runnable = this.f3164c;
        if (runnable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onDrawRunnable");
            runnable = null;
        }
        handler.post(runnable);
    }
}
