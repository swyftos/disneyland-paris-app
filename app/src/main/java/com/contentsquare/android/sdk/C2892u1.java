package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2892u1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f3138a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f3139b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2472D5 f3140c;

    public C2892u1(@NotNull C2508H1 eventsProvidersManager, @NotNull SystemInstantiable systemInstantiable, @NotNull C2472D5 configuration) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f3138a = eventsProvidersManager;
        this.f3139b = systemInstantiable;
        this.f3140c = configuration;
    }

    /* JADX INFO: renamed from: a */
    public final void m1206a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.f3140c.m898a()) {
            C2882t1 event = new C2882t1(name, this.f3139b.currentTimeMillis());
            C2508H1 c2508h1 = this.f3138a;
            synchronized (c2508h1) {
                Intrinsics.checkNotNullParameter(event, "event");
                c2508h1.f1661a.add(event);
            }
        }
    }
}
