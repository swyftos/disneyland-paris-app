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

/* loaded from: classes2.dex */
public final class E2 {

    @NotNull
    public static final Logger a = new Logger("JsonProxyUtils");

    @Nullable
    public static final HeapInterface b = (HeapInterface) C0644c3.d.getValue();

    public static void a(AbstractC0660e abstractC0660e) {
        if (abstractC0660e.c.length() == 0) {
            a.i("No screenview detected. Gestures are linked to screenviews. Please implement screenview tracking to enable gestures tracking.");
        }
    }

    @JvmStatic
    @Nullable
    public static final JSONObject b(@NotNull AbstractC0660e event) throws JSONException {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof C0646c5) {
            C0646c5 event2 = (C0646c5) event;
            Intrinsics.checkNotNullParameter(event2, "event");
            JSONObject jSONObjectC = c(event2);
            try {
                jSONObjectC.put("sl", event2.m);
                CustomVar[] customVarArr = event2.o;
                if (customVarArr == null) {
                    return jSONObjectC;
                }
                if (!(!(customVarArr.length == 0))) {
                    return jSONObjectC;
                }
                jSONObjectC.put("cv", CustomVar.INSTANCE.serializeCustomVarsToJson(customVarArr));
                return jSONObjectC;
            } catch (JSONException e) {
                C0711j0.a(e, new StringBuilder("[ScreenViewEvent] Error in json proxy : "), a, e);
                return jSONObjectC;
            }
        }
        if (event instanceof H4) {
            H4 event3 = (H4) event;
            Intrinsics.checkNotNullParameter(event3, "event");
            JSONObject jSONObjectC2 = c(event3);
            try {
                jSONObjectC2.put("dx", event3.m);
                jSONObjectC2.put("dy", event3.n);
                jSONObjectC2.put("du", event3.o);
                a(event3);
                return jSONObjectC2;
            } catch (JSONException e2) {
                C0711j0.a(e2, new StringBuilder("[ResizeEvent] Error in json proxy : "), a, e2);
                return jSONObjectC2;
            }
        }
        JSONObject jSONObject = null;
        if (event instanceof X6) {
            X6 event4 = (X6) event;
            Intrinsics.checkNotNullParameter(event4, "event");
            JSONObject jSONObjectC3 = c(event4);
            try {
                jSONObjectC3.put("tvp", event4.m);
                jSONObjectC3.put("tvt", (Object) null);
                jSONObjectC3.put("tvac", (Object) null);
                jSONObjectC3.put("ur", event4.n);
                a(event4);
                return jSONObjectC3;
            } catch (JSONException e3) {
                C0711j0.a(e3, new StringBuilder("[TapEvent] Error in json proxy : "), a, e3);
                return jSONObjectC3;
            }
        }
        if (event instanceof S2) {
            S2 event5 = (S2) event;
            Intrinsics.checkNotNullParameter(event5, "event");
            JSONObject jSONObjectC4 = c(event5);
            try {
                jSONObjectC4.put("tvp", event5.m);
                jSONObjectC4.put("tvt", (Object) null);
                jSONObjectC4.put("tvac", (Object) null);
                a(event5);
                return jSONObjectC4;
            } catch (JSONException e4) {
                C0711j0.a(e4, new StringBuilder("[LongPressEvent] Error in json proxy : "), a, e4);
                return jSONObjectC4;
            }
        }
        if (event instanceof C0672f1) {
            C0672f1 event6 = (C0672f1) event;
            Intrinsics.checkNotNullParameter(event6, "event");
            JSONObject jSONObjectC5 = c(event6);
            try {
                jSONObjectC5.put("tvp", event6.m);
                jSONObjectC5.put("tvt", (Object) null);
                jSONObjectC5.put("tvac", (Object) null);
                jSONObjectC5.put("fd", event6.n);
                jSONObjectC5.put("tvd", event6.o);
                jSONObjectC5.put("tvv", event6.p);
                a(event6);
                return jSONObjectC5;
            } catch (JSONException e5) {
                C0711j0.a(e5, new StringBuilder("[DragEvent] Error in json proxy : "), a, e5);
                return jSONObjectC5;
            }
        }
        if (event instanceof R1) {
            R1 event7 = (R1) event;
            Intrinsics.checkNotNullParameter(event7, "event");
            JSONObject jSONObjectC6 = c(event7);
            try {
                jSONObjectC6.put("tvp", event7.m);
                jSONObjectC6.put("tvt", (Object) null);
                jSONObjectC6.put("tvac", (Object) null);
                jSONObjectC6.put("fd", event7.n);
                jSONObjectC6.put("tvd", event7.o);
                jSONObjectC6.put("tvv", event7.p);
                a(event7);
                return jSONObjectC6;
            } catch (JSONException e6) {
                C0711j0.a(e6, new StringBuilder("[FlickEvent] Error in json proxy : "), a, e6);
                return jSONObjectC6;
            }
        }
        if (event instanceof H) {
            H event8 = (H) event;
            Intrinsics.checkNotNullParameter(event8, "event");
            return c(event8);
        }
        if (event instanceof G) {
            G event9 = (G) event;
            Intrinsics.checkNotNullParameter(event9, "event");
            return c(event9);
        }
        if (event instanceof C) {
            C event10 = (C) event;
            Intrinsics.checkNotNullParameter(event10, "event");
            return c(event10);
        }
        if (event instanceof G7) {
            G7 event11 = (G7) event;
            Intrinsics.checkNotNullParameter(event11, "event");
            JSONObject jSONObjectC7 = c(event11);
            try {
                jSONObjectC7.put("tr", event11.m);
                return jSONObjectC7;
            } catch (JSONException e7) {
                C0711j0.a(e7, new StringBuilder("[DragEvent] Error in json proxy : "), a, e7);
                return jSONObjectC7;
            }
        }
        if (event instanceof C0793r3) {
            C0793r3 event12 = (C0793r3) event;
            Intrinsics.checkNotNullParameter(event12, "event");
            JSONObject jSONObjectC8 = c(event12);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("hm", event12.n);
                jSONObject2.put("u", event12.m);
                jSONObject2.put("sc", event12.q);
                jSONObject2.put("rst", event12.o);
                jSONObject2.put("rpt", event12.p);
                jSONObject2.put("src", event12.r);
                if (event12.s != null) {
                    jSONArray = new JSONArray();
                    Iterator<T> it = event12.s.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                } else {
                    jSONArray = null;
                }
                jSONObject2.putOpt("mbc", jSONArray);
                if (event12.t != null) {
                    jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : event12.t.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.putOpt("prba", jSONObject);
                jSONObjectC8.putOpt("nrm", jSONObject2);
                return jSONObjectC8;
            } catch (JSONException e8) {
                C0711j0.a(e8, new StringBuilder("[NetworkRequestMetricEvent] Error in json proxy : "), a, e8);
                return jSONObjectC8;
            }
        }
        if (event instanceof N7) {
            N7 event13 = (N7) event;
            Intrinsics.checkNotNullParameter(event13, "event");
            JSONObject jSONObjectC9 = c(event13);
            try {
                jSONObjectC9.putOpt("chi", event13.m);
                return jSONObjectC9;
            } catch (JSONException e9) {
                C0711j0.a(e9, new StringBuilder("[UserIdentifierEvent] Error in json proxy : "), a, e9);
                return jSONObjectC9;
            }
        }
        if (event instanceof C0702i1) {
            C0702i1 event14 = (C0702i1) event;
            Intrinsics.checkNotNullParameter(event14, "event");
            JSONObject jSONObjectC10 = c(event14);
            try {
                jSONObjectC10.put("k", event14.n);
                jSONObjectC10.put("v", event14.m);
                return jSONObjectC10;
            } catch (JSONException e10) {
                C0711j0.a(e10, new StringBuilder("[DynamicStringVarEvent] Error in json proxy : "), a, e10);
                return jSONObjectC10;
            }
        }
        if (event instanceof C0692h1) {
            C0692h1 event15 = (C0692h1) event;
            Intrinsics.checkNotNullParameter(event15, "event");
            JSONObject jSONObjectC11 = c(event15);
            try {
                jSONObjectC11.put("k", event15.n);
                jSONObjectC11.put("v", event15.m);
                return jSONObjectC11;
            } catch (JSONException e11) {
                C0711j0.a(e11, new StringBuilder("[DynamicStringVarEvent] Error in json proxy : "), a, e11);
                return jSONObjectC11;
            }
        }
        if (event instanceof C0722k1) {
            C0722k1 event16 = (C0722k1) event;
            Intrinsics.checkNotNullParameter(event16, "event");
            return c(event16);
        }
        if (event instanceof T0) {
            T0 event17 = (T0) event;
            Intrinsics.checkNotNullParameter(event17, "event");
            JSONObject jSONObjectC12 = c(event17);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("rt", event17.o);
                jSONObject3.put("message", event17.m);
                jSONObject3.put("src", event17.n);
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, String> entry2 : event17.p.entrySet()) {
                    jSONObject4.put(entry2.getKey(), entry2.getValue());
                }
                jSONObject3.putOpt("attributes", jSONObject4);
                jSONObjectC12.putOpt("cur", jSONObject3);
                return jSONObjectC12;
            } catch (JSONException e12) {
                C0711j0.a(e12, new StringBuilder("[Custom Error] Error in json proxy : "), a, e12);
                return jSONObjectC12;
            }
        }
        if (event instanceof A2) {
            A2 event18 = (A2) event;
            Intrinsics.checkNotNullParameter(event18, "event");
            JSONObject jSONObjectC13 = c(event18);
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("filename", event18.n);
                jSONObject5.put("pageurl", event18.o);
                jSONObject5.put("lineno", event18.q);
                jSONObject5.put("colno", event18.p);
                jSONObject5.put("src", event18.r);
                jSONObject5.put("rt", event18.s);
                jSONObject5.put("m", event18.m);
                jSONObjectC13.putOpt("jsr", jSONObject5);
                return jSONObjectC13;
            } catch (JSONException e13) {
                C0711j0.a(e13, new StringBuilder("[Javascript Error] Error in json proxy : "), a, e13);
                return jSONObjectC13;
            }
        }
        if (event instanceof C0736l5) {
            C0736l5 event19 = (C0736l5) event;
            Intrinsics.checkNotNullParameter(event19, "event");
            JSONObject jSONObjectC14 = c(event19);
            try {
                jSONObjectC14.put("dx", event19.m);
                jSONObjectC14.put("dy", event19.n);
                jSONObjectC14.put("du", event19.o);
                a(event19);
                return jSONObjectC14;
            } catch (JSONException e14) {
                C0711j0.a(e14, new StringBuilder("[ScrollEvent] Error in json proxy : "), a, e14);
                return jSONObjectC14;
            }
        }
        if (event instanceof C0801s1) {
            C0801s1 event20 = (C0801s1) event;
            Intrinsics.checkNotNullParameter(event20, "event");
            JSONObject jSONObjectC15 = c(event20);
            try {
                jSONObjectC15.put("n", event20.m);
                return jSONObjectC15;
            } catch (JSONException e15) {
                C0711j0.a(e15, new StringBuilder("[EtrSessionEvent] Error in json proxy : "), a, e15);
                return jSONObjectC15;
            }
        }
        if (event instanceof C0752n1) {
            C0752n1 event21 = (C0752n1) event;
            Intrinsics.checkNotNullParameter(event21, "event");
            JSONObject jSONObjectC16 = c(event21);
            try {
                jSONObjectC16.put("n", event21.m);
                return jSONObjectC16;
            } catch (JSONException e16) {
                C0711j0.a(e16, new StringBuilder("[EtrScreenEvent] Error in json proxy : "), a, e16);
                return jSONObjectC16;
            }
        }
        if (!(event instanceof C0680g)) {
            if (!(event instanceof C0813t3)) {
                a.e("!!Wrong event type sent! returning null.");
            }
            return null;
        }
        C0680g event22 = (C0680g) event;
        Intrinsics.checkNotNullParameter(event22, "event");
        JSONObject jSONObjectC17 = c(event22);
        try {
            jSONObjectC17.put(DeviceInfo.BATCH_APP_NAME, event22.m);
            return jSONObjectC17;
        } catch (JSONException e17) {
            C0711j0.a(e17, new StringBuilder("[ActivityEvent] Error in json proxy : "), a, e17);
            return jSONObjectC17;
        }
    }

    public static JSONObject c(AbstractC0660e abstractC0660e) throws JSONException {
        HeapInterface.HeapMetadata heapMetadata;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("euid", abstractC0660e.a);
            jSONObject.put("ea", abstractC0660e.b);
            jSONObject.put("url", abstractC0660e.c);
            jSONObject.put("scn", abstractC0660e.d);
            jSONObject.put("c", abstractC0660e.e.getValue());
            jSONObject.put("ci", abstractC0660e.f);
            jSONObject.put("o", abstractC0660e.g.getValue());
            jSONObject.put("vo", abstractC0660e.h);
            jSONObject.put("sn", abstractC0660e.i);
            jSONObject.put("t", abstractC0660e.j);
            jSONObject.put("upt", abstractC0660e.k);
            HeapInterface heapInterface = b;
            if (heapInterface != null && (heapMetadata = heapInterface.getHeapMetadata()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HeapInterface.HEAP_APP_ID, heapMetadata.getAppId());
                jSONObject2.put(HeapInterface.HEAP_SESSION_ID, heapMetadata.getSessionId());
                jSONObject2.put(HeapInterface.HEAP_USER_ID, heapMetadata.getUserId());
                jSONObject.put("ht", jSONObject2);
            }
        } catch (JSONException e) {
            C0711j0.a(e, new StringBuilder("[EventsBundle] Error in json proxy : "), a, e);
        }
        return jSONObject;
    }
}
