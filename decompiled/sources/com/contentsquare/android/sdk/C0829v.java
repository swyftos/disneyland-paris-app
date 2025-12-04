package com.contentsquare.android.sdk;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0829v implements InterfaceC0851x3 {

    @NotNull
    public final C0847x a;

    @NotNull
    public final Handler b;
    public Runnable c;
    public boolean d;

    public C0829v(@NotNull C0847x animationSupervisor, @NotNull Handler uiHandler) {
        Intrinsics.checkNotNullParameter(animationSupervisor, "animationSupervisor");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        this.a = animationSupervisor;
        this.b = uiHandler;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0851x3
    public final void a(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        boolean z = this.d;
        boolean zA = this.a.a(decorView);
        this.d = zA;
        if (!z || zA) {
            return;
        }
        Handler handler = this.b;
        Runnable runnable = this.c;
        if (runnable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onDrawRunnable");
            runnable = null;
        }
        handler.post(runnable);
    }
}
