package com.appdynamics.eumagent.runtime.p000private;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class cl {
    public final Map<Class, cm> a;

    public cl() {
        HashMap map = new HashMap();
        map.put(String.class, new cm());
        map.put(Long.class, new cm());
        map.put(Boolean.class, new cm());
        map.put(Double.class, new cm());
        map.put(Date.class, new cm());
        this.a = map;
    }

    public final Map<Class, Map<String, Object>> a() {
        Map<Class, Map<String, Object>> mapUnmodifiableMap;
        synchronized (this.a) {
            try {
                HashMap map = new HashMap();
                for (Map.Entry<Class, cm> entry : this.a.entrySet()) {
                    map.put(entry.getKey(), Collections.unmodifiableMap(new HashMap(entry.getValue().a)));
                }
                mapUnmodifiableMap = Collections.unmodifiableMap(map);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mapUnmodifiableMap;
    }
}
