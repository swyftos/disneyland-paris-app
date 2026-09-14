package com.contentsquare.android.sdk;

import android.os.Handler;
import androidx.annotation.UiThread;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2928x7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final SystemInstantiable f3243a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Handler f3244b;

    /* JADX INFO: renamed from: c */
    public long f3245c;

    /* JADX INFO: renamed from: d */
    public long f3246d;

    public C2928x7(@NotNull SystemInstantiable systemInstantiable, @NotNull Handler uiHandler, long j) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        this.f3243a = systemInstantiable;
        this.f3244b = uiHandler;
        this.f3245c = j;
    }

    @UiThread
    /* JADX INFO: renamed from: a */
    public final void m1235a(Runnable runnable, long j) {
        if (this.f3243a.currentTimeMillis() - this.f3246d > j) {
            this.f3246d = this.f3243a.currentTimeMillis();
            this.f3244b.post(runnable);
        }
    }
}
