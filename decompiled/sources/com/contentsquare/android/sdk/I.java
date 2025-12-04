package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class I {

    @NotNull
    public final H1 a;

    @NotNull
    public final Logger b;

    public I(@NotNull H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.a = eventsProvidersManager;
        this.b = new Logger("AppStateEventProvider");
    }
}
