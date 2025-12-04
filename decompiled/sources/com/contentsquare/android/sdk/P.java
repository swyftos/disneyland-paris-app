package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.SystemInstantiable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nBaseProfiler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseProfiler.kt\ncom/contentsquare/android/internal/features/profiler/BaseProfiler\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n361#2,7:109\n766#3:116\n857#3,2:117\n1549#3:119\n1620#3,3:120\n*S KotlinDebug\n*F\n+ 1 BaseProfiler.kt\ncom/contentsquare/android/internal/features/profiler/BaseProfiler\n*L\n41#1:109,7\n54#1:116\n54#1:117,2\n54#1:119\n54#1:120,3\n*E\n"})
/* loaded from: classes2.dex */
public abstract class P<T> {

    @NotNull
    public final LinkedHashSet a;
    public boolean b;

    public P() {
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        new LinkedHashMap();
        this.a = new LinkedHashSet();
    }

    public final synchronized void a(T t) {
        this.a.remove(t);
    }
}
