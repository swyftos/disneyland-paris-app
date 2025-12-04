package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.SrWrappedProtoEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class S1 {

    @NotNull
    public final H1 a;

    public S1(@NotNull H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.a = eventsProvidersManager;
    }

    public final void a(@NotNull SrWrappedProtoEvent event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        H1 h1 = this.a;
        synchronized (h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            h1.a.add(event);
        }
    }
}
