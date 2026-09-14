package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.communication.HeapInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2479E2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Logger f1544a = new Logger("JsonProxyUtils");

    /* JADX INFO: renamed from: b */
    @Nullable
    public static final HeapInterface f1545b = (HeapInterface) C2714c3.f2441d.getValue();

    /* JADX INFO: renamed from: a */
    public static void m903a(AbstractC2730e abstractC2730e) {
        if (abstractC2730e.f2548c.length() == 0) {
            f1544a.m831i("No screenview detected. Gestures are linked to screenviews. Please implement screenview tracking to enable gestures tracking.");
        }
    }

    @JvmStatic
    @Nullable
    /* JADX INFO: renamed from: b */
    public static final JSONObject m904b(@NotNull AbstractC2730e event) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof C2716c5) {
            C2716c5 event2 = (C2716c5) event;
            Intrinsics.checkNotNullParameter(event2, "event");
            JSONObject jSONObjectM905c = m905c(event2);
            try {
                jSONObjectM905c.put("sl", event2.f2446m);
                CustomVar[] customVarArr = event2.f2448o;
                if (customVarArr == null) {
                    return jSONObjectM905c;
                }
                if (!(!(customVarArr.length == 0))) {
                    return jSONObjectM905c;
                }
                jSONObjectM905c.put("cv", CustomVar.INSTANCE.serializeCustomVarsToJson(customVarArr));
                return jSONObjectM905c;
            } catch (JSONException e) {
                C2781j0.m1160a(e, new StringBuilder("[ScreenViewEvent] Error in json proxy : "), f1544a, e);
                return jSONObjectM905c;
            }
        }
        if (event instanceof C2511H4) {
            C2511H4 event3 = (C2511H4) event;
            Intrinsics.checkNotNullParameter(event3, "event");
            JSONObject jSONObjectM905c2 = m905c(event3);
            try {
                jSONObjectM905c2.put("dx", event3.f1676m);
                jSONObjectM905c2.put("dy", event3.f1677n);
                jSONObjectM905c2.put("du", event3.f1678o);
                m903a(event3);
                return jSONObjectM905c2;
            } catch (JSONException e2) {
                C2781j0.m1160a(e2, new StringBuilder("[ResizeEvent] Error in json proxy : "), f1544a, e2);
                return jSONObjectM905c2;
            }
        }
        JSONObject jSONObject = null;
        if (event instanceof C2670X6) {
            C2670X6 event4 = (C2670X6) event;
            Intrinsics.checkNotNullParameter(event4, "event");
            JSONObject jSONObjectM905c3 = m905c(event4);
            try {
                jSONObjectM905c3.put("tvp", event4.f2275m);
                jSONObjectM905c3.put("tvt", (Object) null);
                jSONObjectM905c3.put("tvac", (Object) null);
                jSONObjectM905c3.put("ur", event4.f2276n);
                m903a(event4);
                return jSONObjectM905c3;
            } catch (JSONException e3) {
                C2781j0.m1160a(e3, new StringBuilder("[TapEvent] Error in json proxy : "), f1544a, e3);
                return jSONObjectM905c3;
            }
        }
        if (event instanceof C2618S2) {
            C2618S2 event5 = (C2618S2) event;
            Intrinsics.checkNotNullParameter(event5, "event");
            JSONObject jSONObjectM905c4 = m905c(event5);
            try {
                jSONObjectM905c4.put("tvp", event5.f2083m);
                jSONObjectM905c4.put("tvt", (Object) null);
                jSONObjectM905c4.put("tvac", (Object) null);
                m903a(event5);
                return jSONObjectM905c4;
            } catch (JSONException e4) {
                C2781j0.m1160a(e4, new StringBuilder("[LongPressEvent] Error in json proxy : "), f1544a, e4);
                return jSONObjectM905c4;
            }
        }
        if (event instanceof C2742f1) {
            C2742f1 event6 = (C2742f1) event;
            Intrinsics.checkNotNullParameter(event6, "event");
            JSONObject jSONObjectM905c5 = m905c(event6);
            try {
                jSONObjectM905c5.put("tvp", event6.f2592m);
                jSONObjectM905c5.put("tvt", (Object) null);
                jSONObjectM905c5.put("tvac", (Object) null);
                jSONObjectM905c5.put("fd", event6.f2593n);
                jSONObjectM905c5.put("tvd", event6.f2594o);
                jSONObjectM905c5.put("tvv", event6.f2595p);
                m903a(event6);
                return jSONObjectM905c5;
            } catch (JSONException e5) {
                C2781j0.m1160a(e5, new StringBuilder("[DragEvent] Error in json proxy : "), f1544a, e5);
                return jSONObjectM905c5;
            }
        }
        if (event instanceof C2607R1) {
            C2607R1 event7 = (C2607R1) event;
            Intrinsics.checkNotNullParameter(event7, "event");
            JSONObject jSONObjectM905c6 = m905c(event7);
            try {
                jSONObjectM905c6.put("tvp", event7.f2051m);
                jSONObjectM905c6.put("tvt", (Object) null);
                jSONObjectM905c6.put("tvac", (Object) null);
                jSONObjectM905c6.put("fd", event7.f2052n);
                jSONObjectM905c6.put("tvd", event7.f2053o);
                jSONObjectM905c6.put("tvv", event7.f2054p);
                m903a(event7);
                return jSONObjectM905c6;
            } catch (JSONException e6) {
                C2781j0.m1160a(e6, new StringBuilder("[FlickEvent] Error in json proxy : "), f1544a, e6);
                return jSONObjectM905c6;
            }
        }
        if (event instanceof C2506H) {
            C2506H event8 = (C2506H) event;
            Intrinsics.checkNotNullParameter(event8, "event");
            return m905c(event8);
        }
        if (event instanceof C2496G) {
            C2496G event9 = (C2496G) event;
            Intrinsics.checkNotNullParameter(event9, "event");
            return m905c(event9);
        }
        if (event instanceof C2456C) {
            C2456C event10 = (C2456C) event;
            Intrinsics.checkNotNullParameter(event10, "event");
            return m905c(event10);
        }
        if (event instanceof C2504G7) {
            C2504G7 event11 = (C2504G7) event;
            Intrinsics.checkNotNullParameter(event11, "event");
            JSONObject jSONObjectM905c7 = m905c(event11);
            try {
                jSONObjectM905c7.put("tr", event11.f1659m);
                return jSONObjectM905c7;
            } catch (JSONException e7) {
                C2781j0.m1160a(e7, new StringBuilder("[DragEvent] Error in json proxy : "), f1544a, e7);
                return jSONObjectM905c7;
            }
        }
        if (event instanceof C2864r3) {
            C2864r3 event12 = (C2864r3) event;
            Intrinsics.checkNotNullParameter(event12, "event");
            JSONObject jSONObjectM905c8 = m905c(event12);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("hm", event12.f3060n);
                jSONObject2.put("u", event12.f3059m);
                jSONObject2.put("sc", event12.f3063q);
                jSONObject2.put("rst", event12.f3061o);
                jSONObject2.put("rpt", event12.f3062p);
                jSONObject2.put("src", event12.f3064r);
                if (event12.f3065s != null) {
                    jSONArray = new JSONArray();
                    Iterator<T> it = event12.f3065s.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                } else {
                    jSONArray = null;
                }
                jSONObject2.putOpt("mbc", jSONArray);
                if (event12.f3066t != null) {
                    jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : event12.f3066t.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.putOpt("prba", jSONObject);
                jSONObjectM905c8.putOpt("nrm", jSONObject2);
                return jSONObjectM905c8;
            } catch (JSONException e8) {
                C2781j0.m1160a(e8, new StringBuilder("[NetworkRequestMetricEvent] Error in json proxy : "), f1544a, e8);
                return jSONObjectM905c8;
            }
        }
        if (event instanceof C2574N7) {
            C2574N7 event13 = (C2574N7) event;
            Intrinsics.checkNotNullParameter(event13, "event");
            JSONObject jSONObjectM905c9 = m905c(event13);
            try {
                jSONObjectM905c9.putOpt("chi", event13.f1899m);
                return jSONObjectM905c9;
            } catch (JSONException e9) {
                C2781j0.m1160a(e9, new StringBuilder("[UserIdentifierEvent] Error in json proxy : "), f1544a, e9);
                return jSONObjectM905c9;
            }
        }
        if (event instanceof C2772i1) {
            C2772i1 event14 = (C2772i1) event;
            Intrinsics.checkNotNullParameter(event14, "event");
            JSONObject jSONObjectM905c10 = m905c(event14);
            try {
                jSONObjectM905c10.put("k", event14.f2736n);
                jSONObjectM905c10.put("v", event14.f2735m);
                return jSONObjectM905c10;
            } catch (JSONException e10) {
                C2781j0.m1160a(e10, new StringBuilder("[DynamicStringVarEvent] Error in json proxy : "), f1544a, e10);
                return jSONObjectM905c10;
            }
        }
        if (event instanceof C2762h1) {
            C2762h1 event15 = (C2762h1) event;
            Intrinsics.checkNotNullParameter(event15, "event");
            JSONObject jSONObjectM905c11 = m905c(event15);
            try {
                jSONObjectM905c11.put("k", event15.f2681n);
                jSONObjectM905c11.put("v", event15.f2680m);
                return jSONObjectM905c11;
            } catch (JSONException e11) {
                C2781j0.m1160a(e11, new StringBuilder("[DynamicStringVarEvent] Error in json proxy : "), f1544a, e11);
                return jSONObjectM905c11;
            }
        }
        if (event instanceof C2792k1) {
            C2792k1 event16 = (C2792k1) event;
            Intrinsics.checkNotNullParameter(event16, "event");
            return m905c(event16);
        }
        if (event instanceof C2626T0) {
            C2626T0 event17 = (C2626T0) event;
            Intrinsics.checkNotNullParameter(event17, "event");
            JSONObject jSONObjectM905c12 = m905c(event17);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("rt", event17.f2138o);
                jSONObject3.put("message", event17.f2136m);
                jSONObject3.put("src", event17.f2137n);
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, String> entry2 : event17.f2139p.entrySet()) {
                    jSONObject4.put(entry2.getKey(), entry2.getValue());
                }
                jSONObject3.putOpt("attributes", jSONObject4);
                jSONObjectM905c12.putOpt("cur", jSONObject3);
                return jSONObjectM905c12;
            } catch (JSONException e12) {
                C2781j0.m1160a(e12, new StringBuilder("[Custom Error] Error in json proxy : "), f1544a, e12);
                return jSONObjectM905c12;
            }
        }
        if (event instanceof C2439A2) {
            C2439A2 event18 = (C2439A2) event;
            Intrinsics.checkNotNullParameter(event18, "event");
            JSONObject jSONObjectM905c13 = m905c(event18);
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("filename", event18.f1374n);
                jSONObject5.put("pageurl", event18.f1375o);
                jSONObject5.put("lineno", event18.f1377q);
                jSONObject5.put("colno", event18.f1376p);
                jSONObject5.put("src", event18.f1378r);
                jSONObject5.put("rt", event18.f1379s);
                jSONObject5.put("m", event18.f1373m);
                jSONObjectM905c13.putOpt("jsr", jSONObject5);
                return jSONObjectM905c13;
            } catch (JSONException e13) {
                C2781j0.m1160a(e13, new StringBuilder("[Javascript Error] Error in json proxy : "), f1544a, e13);
                return jSONObjectM905c13;
            }
        }
        if (event instanceof C2806l5) {
            C2806l5 event19 = (C2806l5) event;
            Intrinsics.checkNotNullParameter(event19, "event");
            JSONObject jSONObjectM905c14 = m905c(event19);
            try {
                jSONObjectM905c14.put("dx", event19.f2850m);
                jSONObjectM905c14.put("dy", event19.f2851n);
                jSONObjectM905c14.put("du", event19.f2852o);
                m903a(event19);
                return jSONObjectM905c14;
            } catch (JSONException e14) {
                C2781j0.m1160a(e14, new StringBuilder("[ScrollEvent] Error in json proxy : "), f1544a, e14);
                return jSONObjectM905c14;
            }
        }
        if (event instanceof C2872s1) {
            C2872s1 event20 = (C2872s1) event;
            Intrinsics.checkNotNullParameter(event20, "event");
            JSONObject jSONObjectM905c15 = m905c(event20);
            try {
                jSONObjectM905c15.put("n", event20.f3092m);
                return jSONObjectM905c15;
            } catch (JSONException e15) {
                C2781j0.m1160a(e15, new StringBuilder("[EtrSessionEvent] Error in json proxy : "), f1544a, e15);
                return jSONObjectM905c15;
            }
        }
        if (event instanceof C2822n1) {
            C2822n1 event21 = (C2822n1) event;
            Intrinsics.checkNotNullParameter(event21, "event");
            JSONObject jSONObjectM905c16 = m905c(event21);
            try {
                jSONObjectM905c16.put("n", event21.f2899m);
                return jSONObjectM905c16;
            } catch (JSONException e16) {
                C2781j0.m1160a(e16, new StringBuilder("[EtrScreenEvent] Error in json proxy : "), f1544a, e16);
                return jSONObjectM905c16;
            }
        }
        if (!(event instanceof C2750g)) {
            if (!(event instanceof C2884t3)) {
                f1544a.m829e("!!Wrong event type sent! returning null.");
            }
            return null;
        }
        C2750g event22 = (C2750g) event;
        Intrinsics.checkNotNullParameter(event22, "event");
        JSONObject jSONObjectM905c17 = m905c(event22);
        try {
            jSONObjectM905c17.put(DeviceInfo.BATCH_APP_NAME, event22.f2651m);
            return jSONObjectM905c17;
        } catch (JSONException e17) {
            C2781j0.m1160a(e17, new StringBuilder("[ActivityEvent] Error in json proxy : "), f1544a, e17);
            return jSONObjectM905c17;
        }
    }

    /* JADX INFO: renamed from: c */
    public static JSONObject m905c(AbstractC2730e abstractC2730e) {
        HeapInterface.HeapMetadata heapMetadata;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("euid", abstractC2730e.f2546a);
            jSONObject.put("ea", abstractC2730e.f2547b);
            jSONObject.put("url", abstractC2730e.f2548c);
            jSONObject.put("scn", abstractC2730e.f2549d);
            jSONObject.put("c", abstractC2730e.f2550e.getValue());
            jSONObject.put("ci", abstractC2730e.f2551f);
            jSONObject.put("o", abstractC2730e.f2552g.getValue());
            jSONObject.put("vo", abstractC2730e.f2553h);
            jSONObject.put("sn", abstractC2730e.f2554i);
            jSONObject.put("t", abstractC2730e.f2555j);
            jSONObject.put("upt", abstractC2730e.f2556k);
            HeapInterface heapInterface = f1545b;
            if (heapInterface != null && (heapMetadata = heapInterface.getHeapMetadata()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HeapInterface.HEAP_APP_ID, heapMetadata.getAppId());
                jSONObject2.put(HeapInterface.HEAP_SESSION_ID, heapMetadata.getSessionId());
                jSONObject2.put(HeapInterface.HEAP_USER_ID, heapMetadata.getUserId());
                jSONObject.put("ht", jSONObject2);
            }
        } catch (JSONException e) {
            C2781j0.m1160a(e, new StringBuilder("[EventsBundle] Error in json proxy : "), f1544a, e);
        }
        return jSONObject;
    }
}
