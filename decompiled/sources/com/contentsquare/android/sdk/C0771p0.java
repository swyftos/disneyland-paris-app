package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.T8;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.p0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0771p0 {

    @NotNull
    public final T8.b a;

    @NotNull
    public final X0 b;

    @NotNull
    public final List<WeakReference<InterfaceC0860y3>> c;

    public C0771p0() {
        T8.b staticProvider = new T8.b();
        X0 decorViewTreeObserver = new X0(staticProvider);
        ArrayList listeners = new ArrayList();
        Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
        Intrinsics.checkNotNullParameter(decorViewTreeObserver, "decorViewTreeObserver");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.a = staticProvider;
        this.b = decorViewTreeObserver;
        this.c = listeners;
    }

    public final void a(@NotNull InterfaceC0860y3 onTouchListener) {
        Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
        Iterator<WeakReference<InterfaceC0860y3>> it = this.c.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(onTouchListener, it.next().get())) {
                it.remove();
            }
        }
    }
}
