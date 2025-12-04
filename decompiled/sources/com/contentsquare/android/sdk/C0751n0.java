package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.n0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0751n0 {

    @NotNull
    public static final C0837v7 a = new C0837v7(1);

    @NotNull
    public static final Logger b = new Logger("CPUThreadPool");

    public static void a(@NotNull InterfaceRunnableC0741m0 task) {
        boolean z;
        Intrinsics.checkNotNullParameter(task, "task");
        C0837v7 c0837v7 = a;
        synchronized (c0837v7) {
            Intrinsics.checkNotNullParameter(task, "task");
            try {
                c0837v7.a.execute(task);
                z = true;
            } catch (RejectedExecutionException e) {
                c0837v7.b.d(e, "addTask failed");
                z = false;
            }
        }
        if (z) {
            return;
        }
        b.e("the CPUThreadPool is full, a task was skipped");
    }
}
