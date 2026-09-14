package com.contentsquare.android.sdk;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.p0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2841p0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final WindowCallbackC2634T8.b f2993a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ViewTreeObserverOnGlobalLayoutListenerC2664X0 f2994b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final List<WeakReference<InterfaceC2934y3>> f2995c;

    public C2841p0() {
        WindowCallbackC2634T8.b staticProvider = new WindowCallbackC2634T8.b();
        ViewTreeObserverOnGlobalLayoutListenerC2664X0 decorViewTreeObserver = new ViewTreeObserverOnGlobalLayoutListenerC2664X0(staticProvider);
        ArrayList listeners = new ArrayList();
        Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
        Intrinsics.checkNotNullParameter(decorViewTreeObserver, "decorViewTreeObserver");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.f2993a = staticProvider;
        this.f2994b = decorViewTreeObserver;
        this.f2995c = listeners;
    }

    /* JADX INFO: renamed from: a */
    public final void m1191a(@NotNull InterfaceC2934y3 onTouchListener) {
        Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
        Iterator<WeakReference<InterfaceC2934y3>> it = this.f2995c.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(onTouchListener, it.next().get())) {
                it.remove();
            }
        }
    }
}
