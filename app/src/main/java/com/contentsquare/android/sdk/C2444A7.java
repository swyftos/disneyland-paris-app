package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2444A7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f1414a = new Logger("TimeCollector");

    /* JADX INFO: renamed from: b */
    @NotNull
    public final LinkedHashMap f1415b = new LinkedHashMap();

    /* JADX INFO: renamed from: c */
    @NotNull
    public final LinkedHashMap f1416c = new LinkedHashMap();

    /* JADX INFO: renamed from: a */
    public static void m866a(C2444A7 c2444a7, String key) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c2444a7.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        if (!c2444a7.f1415b.containsKey(key)) {
            c2444a7.f1415b.put(key, Long.valueOf(jCurrentTimeMillis));
            return;
        }
        c2444a7.f1414a.m827d("Time measurement with key \"" + key + "\" already in progress");
    }

    /* JADX INFO: renamed from: b */
    public static void m867b(C2444A7 c2444a7, String key) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c2444a7.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        if (!c2444a7.f1415b.containsKey(key)) {
            c2444a7.f1414a.m827d("Time measurement with key \"" + key + "\" not started");
            return;
        }
        Long l = (Long) c2444a7.f1415b.get(key);
        if (l != null) {
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (c2444a7.f1416c.containsKey(key)) {
                List list = (List) c2444a7.f1416c.get(key);
                if (list != null) {
                    list.add(Long.valueOf(jLongValue));
                }
            } else {
                c2444a7.f1416c.put(key, CollectionsKt.mutableListOf(Long.valueOf(jLongValue)));
            }
        }
    }
}
