package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.SrWrappedProtoEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.S1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2617S1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f2082a;

    public C2617S1(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f2082a = eventsProvidersManager;
    }

    /* JADX INFO: renamed from: a */
    public final void m1026a(@NotNull SrWrappedProtoEvent event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        C2508H1 c2508h1 = this.f2082a;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
    }
}
