package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.U0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2636U0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f2167a;

    public C2636U0(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f2167a = eventsProvidersManager;
    }

    /* JADX INFO: renamed from: a */
    public final void m1041a(@NotNull C2646V0 event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        C2508H1 c2508h1 = this.f2167a;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
    }
}
