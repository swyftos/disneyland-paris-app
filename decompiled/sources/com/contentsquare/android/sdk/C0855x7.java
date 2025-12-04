package com.contentsquare.android.sdk;

import android.os.Handler;
import androidx.annotation.UiThread;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.x7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0855x7 {

    @NotNull
    public final SystemInstantiable a;

    @NotNull
    public final Handler b;
    public long c;
    public long d;

    public C0855x7(@NotNull SystemInstantiable systemInstantiable, @NotNull Handler uiHandler, long j) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        this.a = systemInstantiable;
        this.b = uiHandler;
        this.c = j;
    }

    @UiThread
    public final void a(Runnable runnable, long j) {
        if (this.a.currentTimeMillis() - this.d > j) {
            this.d = this.a.currentTimeMillis();
            this.b.post(runnable);
        }
    }
}
