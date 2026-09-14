package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.p1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2842p1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f2996a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f2997b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2472D5 f2998c;

    public C2842p1(@NotNull C2508H1 eventsProvidersManager, @NotNull SystemInstantiable systemInstantiable, @NotNull C2472D5 configuration) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f2996a = eventsProvidersManager;
        this.f2997b = systemInstantiable;
        this.f2998c = configuration;
    }

    /* JADX INFO: renamed from: a */
    public final void m1192a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.f2998c.m898a()) {
            C2832o1 event = new C2832o1(name, this.f2997b.currentTimeMillis());
            C2508H1 c2508h1 = this.f2996a;
            synchronized (c2508h1) {
                Intrinsics.checkNotNullParameter(event, "event");
                c2508h1.f1661a.add(event);
            }
        }
    }
}
