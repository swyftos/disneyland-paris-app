package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2525I8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f1713a;

    public C2525I8(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f1713a = eventsProvidersManager;
    }

    /* JADX INFO: renamed from: a */
    public final void m945a(@NotNull AbstractC2485E8 event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        C2508H1 c2508h1 = this.f1713a;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
    }
}
