package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2680Y7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2662W7 f2310a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2737e6 f2311b;

    public C2680Y7(@NotNull C2662W7 scrollRecorder, @NotNull C2737e6 snapshotPausingController) {
        Intrinsics.checkNotNullParameter(scrollRecorder, "scrollRecorder");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        this.f2310a = scrollRecorder;
        this.f2311b = snapshotPausingController;
    }
}
