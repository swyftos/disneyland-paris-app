package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.u1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0821u1 {

    @NotNull
    public final H1 a;

    @NotNull
    public final SystemInstantiable b;

    @NotNull
    public final D5 c;

    public C0821u1(@NotNull H1 eventsProvidersManager, @NotNull SystemInstantiable systemInstantiable, @NotNull D5 configuration) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = eventsProvidersManager;
        this.b = systemInstantiable;
        this.c = configuration;
    }

    public final void a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.c.a()) {
            C0811t1 event = new C0811t1(name, this.b.currentTimeMillis());
            H1 h1 = this.a;
            synchronized (h1) {
                Intrinsics.checkNotNullParameter(event, "event");
                h1.a.add(event);
            }
        }
    }
}
