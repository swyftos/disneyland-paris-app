package com.appdynamics.eumagent.runtime;

import com.appdynamics.eumagent.runtime.p000private.bz;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DontObfuscate
/* loaded from: classes2.dex */
public class ServerCorrelationHeaders {
    public static final String ADEUM_TRACE_ID_HEADER = "trace-id";
    public static final String ADEUM_TRACE_PARENT_HEADER = "traceparent";
    private static Map<String, List<String>> headers;

    static {
        HashMap map = new HashMap(2);
        headers = map;
        map.put("ADRUM", Collections.singletonList("isAjax:true"));
        headers.put("ADRUM_1", Collections.singletonList("isMobile:true"));
        headers = Collections.unmodifiableMap(headers);
    }

    private ServerCorrelationHeaders() {
    }

    public static List<String> generateTraceParentHeaderValue() {
        return Collections.singletonList(bz.a());
    }

    public static Map<String, List<String>> generate() {
        return headers;
    }

    public static Map<String, List<String>> generate(boolean z) {
        if (z) {
            HashMap map = new HashMap(4);
            map.put("ADRUM", Collections.singletonList("isAjax:true"));
            map.put("ADRUM_1", Collections.singletonList("isMobile:true"));
            String strA = bz.a();
            String str = strA.split("-")[1];
            map.put(ADEUM_TRACE_PARENT_HEADER, Collections.singletonList(strA));
            map.put(ADEUM_TRACE_ID_HEADER, Collections.singletonList(str));
            return Collections.unmodifiableMap(map);
        }
        return headers;
    }
}
