package com.appdynamics.eumagent.runtime.p192private;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cl */
/* JADX INFO: loaded from: classes2.dex */
public final class C2116cl {

    /* JADX INFO: renamed from: a */
    public final Map<Class, C2117cm> f809a;

    public C2116cl() {
        HashMap map = new HashMap();
        map.put(String.class, new C2117cm());
        map.put(Long.class, new C2117cm());
        map.put(Boolean.class, new C2117cm());
        map.put(Double.class, new C2117cm());
        map.put(Date.class, new C2117cm());
        this.f809a = map;
    }

    /* JADX INFO: renamed from: a */
    public final Map<Class, Map<String, Object>> m650a() {
        Map<Class, Map<String, Object>> mapUnmodifiableMap;
        synchronized (this.f809a) {
            try {
                HashMap map = new HashMap();
                for (Map.Entry<Class, C2117cm> entry : this.f809a.entrySet()) {
                    map.put(entry.getKey(), Collections.unmodifiableMap(new HashMap(entry.getValue().f810a)));
                }
                mapUnmodifiableMap = Collections.unmodifiableMap(map);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mapUnmodifiableMap;
    }
}
