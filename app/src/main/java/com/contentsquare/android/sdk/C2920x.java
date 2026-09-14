package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nAnimationSupervisor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationSupervisor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/animations/AnimationSupervisor\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n483#2,7:79\n215#3,2:86\n1747#4,2:88\n1749#4:91\n1#5:90\n*S KotlinDebug\n*F\n+ 1 AnimationSupervisor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/animations/AnimationSupervisor\n*L\n49#1:79,7\n50#1:86,2\n61#1:88,2\n61#1:91\n*E\n"})
public final class C2920x {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final SystemInstantiable f3218a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2910w f3219b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2930y f3220c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final LinkedHashMap f3221d;

    public C2920x(@NotNull SystemInstantiable systemInstantiable, @NotNull C2910w animationStateChecker, @NotNull C2930y animationTelemetrySender) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(animationStateChecker, "animationStateChecker");
        Intrinsics.checkNotNullParameter(animationTelemetrySender, "animationTelemetrySender");
        this.f3218a = systemInstantiable;
        this.f3219b = animationStateChecker;
        this.f3220c = animationTelemetrySender;
        this.f3221d = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1229a(@NotNull View root) {
        boolean z;
        Intrinsics.checkNotNullParameter(root, "root");
        Collection collectionValues = this.f3221d.values();
        if (collectionValues != null && collectionValues.isEmpty()) {
            z = false;
            break;
        }
        Iterator it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            View it2 = (View) ((WeakReference) it.next()).get();
            if (it2 != null) {
                C2910w c2910w = this.f3219b;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                c2910w.getClass();
                if (C2910w.m1225a(it2) && Intrinsics.areEqual(it2.getRootView(), root)) {
                    z = true;
                    break;
                }
            }
        }
        C2930y c2930y = this.f3220c;
        if (z && c2930y.f3254c == null) {
            c2930y.f3254c = new C2930y.a(c2930y.f3253b.currentTimeMillis());
        } else if (!z) {
            c2930y.f3254c = null;
        }
        C2930y.a aVar = c2930y.f3254c;
        if (aVar != null && c2930y.f3253b.currentTimeMillis() - aVar.f3255a > 1000 && !aVar.f3256b) {
            LogMonitor.INSTANCE.warn("Session Replay detected long animation", MapsKt.mapOf(TuplesKt.m1842to("srLink", c2930y.f3252a.m1164a())));
            C2930y.a aVar2 = c2930y.f3254c;
            if (aVar2 != null) {
                aVar2.f3256b = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public final void m1228a() {
        LinkedHashMap linkedHashMap = this.f3221d;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((WeakReference) entry.getValue()).get() == null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            this.f3221d.remove(((Map.Entry) it.next()).getKey());
        }
    }
}
