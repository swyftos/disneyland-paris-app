package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
import com.contentsquare.android.sdk.C0856y;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAnimationSupervisor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationSupervisor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/animations/AnimationSupervisor\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n483#2,7:79\n215#3,2:86\n1747#4,2:88\n1749#4:91\n1#5:90\n*S KotlinDebug\n*F\n+ 1 AnimationSupervisor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/animations/AnimationSupervisor\n*L\n49#1:79,7\n50#1:86,2\n61#1:88,2\n61#1:91\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0847x {

    @NotNull
    public final SystemInstantiable a;

    @NotNull
    public final C0838w b;

    @NotNull
    public final C0856y c;

    @NotNull
    public final LinkedHashMap d;

    public C0847x(@NotNull SystemInstantiable systemInstantiable, @NotNull C0838w animationStateChecker, @NotNull C0856y animationTelemetrySender) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(animationStateChecker, "animationStateChecker");
        Intrinsics.checkNotNullParameter(animationTelemetrySender, "animationTelemetrySender");
        this.a = systemInstantiable;
        this.b = animationStateChecker;
        this.c = animationTelemetrySender;
        this.d = new LinkedHashMap();
    }

    public final boolean a(@NotNull View root) {
        boolean z;
        Intrinsics.checkNotNullParameter(root, "root");
        Collection collectionValues = this.d.values();
        if (collectionValues == null || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                View it2 = (View) ((WeakReference) it.next()).get();
                if (it2 != null) {
                    C0838w c0838w = this.b;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    c0838w.getClass();
                    if (C0838w.a(it2) && Intrinsics.areEqual(it2.getRootView(), root)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        } else {
            z = false;
        }
        C0856y c0856y = this.c;
        if (z && c0856y.c == null) {
            c0856y.c = new C0856y.a(c0856y.b.currentTimeMillis());
        } else if (!z) {
            c0856y.c = null;
        }
        C0856y.a aVar = c0856y.c;
        if (aVar != null && c0856y.b.currentTimeMillis() - aVar.a > 1000 && !aVar.b) {
            LogMonitor.INSTANCE.warn("Session Replay detected long animation", MapsKt.mapOf(TuplesKt.to("srLink", c0856y.a.a())));
            C0856y.a aVar2 = c0856y.c;
            if (aVar2 != null) {
                aVar2.b = true;
            }
        }
        return z;
    }

    public final void a() {
        LinkedHashMap linkedHashMap = this.d;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((WeakReference) entry.getValue()).get() == null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            this.d.remove(((Map.Entry) it.next()).getKey());
        }
    }
}
