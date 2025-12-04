package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class T7 {

    @NotNull
    public final Q7 a;

    @NotNull
    public final C0667e6 b;

    @NotNull
    public final PreferencesStore c;

    public T7(@NotNull Q7 scrollRecorder, @NotNull C0667e6 snapshotPausingController, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(scrollRecorder, "scrollRecorder");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = scrollRecorder;
        this.b = snapshotPausingController;
        this.c = preferencesStore;
    }
}
