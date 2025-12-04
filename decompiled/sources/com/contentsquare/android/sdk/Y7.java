package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Y7 {

    @NotNull
    public final W7 a;

    @NotNull
    public final C0667e6 b;

    public Y7(@NotNull W7 scrollRecorder, @NotNull C0667e6 snapshotPausingController) {
        Intrinsics.checkNotNullParameter(scrollRecorder, "scrollRecorder");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        this.a = scrollRecorder;
        this.b = snapshotPausingController;
    }
}
