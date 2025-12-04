package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class A7 {

    @NotNull
    public final Logger a = new Logger("TimeCollector");

    @NotNull
    public final LinkedHashMap b = new LinkedHashMap();

    @NotNull
    public final LinkedHashMap c = new LinkedHashMap();

    public static void a(A7 a7, String key) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a7.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        if (!a7.b.containsKey(key)) {
            a7.b.put(key, Long.valueOf(jCurrentTimeMillis));
            return;
        }
        a7.a.d("Time measurement with key \"" + key + "\" already in progress");
    }

    public static void b(A7 a7, String key) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a7.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        if (!a7.b.containsKey(key)) {
            a7.a.d("Time measurement with key \"" + key + "\" not started");
            return;
        }
        Long l = (Long) a7.b.get(key);
        if (l != null) {
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (a7.c.containsKey(key)) {
                List list = (List) a7.c.get(key);
                if (list != null) {
                    list.add(Long.valueOf(jLongValue));
                }
            } else {
                a7.c.put(key, CollectionsKt.mutableListOf(Long.valueOf(jLongValue)));
            }
        }
    }
}
