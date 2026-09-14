package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2821n0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C2908v7 f2897a = new C2908v7(1);

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Logger f2898b = new Logger("CPUThreadPool");

    /* JADX INFO: renamed from: a */
    public static void m1180a(@NotNull InterfaceRunnableC2811m0 task) {
        boolean z;
        Intrinsics.checkNotNullParameter(task, "task");
        C2908v7 c2908v7 = f2897a;
        synchronized (c2908v7) {
            Intrinsics.checkNotNullParameter(task, "task");
            try {
                c2908v7.f3195a.execute(task);
                z = true;
            } catch (RejectedExecutionException e) {
                c2908v7.f3196b.m828d(e, "addTask failed");
                z = false;
            }
        }
        if (z) {
            return;
        }
        f2898b.m829e("the CPUThreadPool is full, a task was skipped");
    }
}
