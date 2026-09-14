package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2633T7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2604Q7 f2156a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2737e6 f2157b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final PreferencesStore f2158c;

    public C2633T7(@NotNull C2604Q7 scrollRecorder, @NotNull C2737e6 snapshotPausingController, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(scrollRecorder, "scrollRecorder");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f2156a = scrollRecorder;
        this.f2157b = snapshotPausingController;
        this.f2158c = preferencesStore;
    }
}
