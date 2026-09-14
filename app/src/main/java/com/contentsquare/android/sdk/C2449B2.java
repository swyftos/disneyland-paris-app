package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2449B2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f1436a;

    public C2449B2(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f1436a = eventsProvidersManager;
    }

    /* JADX INFO: renamed from: a */
    public final void m877a(@NotNull C2459C2 event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        C2508H1 c2508h1 = this.f1436a;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
    }
}
