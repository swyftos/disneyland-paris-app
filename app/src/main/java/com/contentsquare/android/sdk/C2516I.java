package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I */
/* JADX INFO: loaded from: classes2.dex */
public final class C2516I {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f1700a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f1701b;

    public C2516I(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f1700a = eventsProvidersManager;
        this.f1701b = new Logger("AppStateEventProvider");
    }
}
