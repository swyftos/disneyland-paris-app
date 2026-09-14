package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.s */
/* JADX INFO: loaded from: classes2.dex */
public class C2140s {

    /* JADX INFO: renamed from: a */
    public Boolean f906a;

    /* JADX INFO: renamed from: b */
    public Boolean f907b;

    /* JADX INFO: renamed from: c */
    public Boolean f908c;

    /* JADX INFO: renamed from: d */
    public Long f909d;

    /* JADX INFO: renamed from: e */
    public Boolean f910e;

    /* JADX INFO: renamed from: f */
    public Boolean f911f;

    /* JADX INFO: renamed from: g */
    public Boolean f912g;

    /* JADX INFO: renamed from: h */
    public List<String> f913h = Collections.emptyList();

    /* JADX INFO: renamed from: i */
    public Long f914i;

    /* JADX INFO: renamed from: j */
    public Boolean f915j;

    /* JADX INFO: renamed from: k */
    public Boolean f916k;

    /* JADX INFO: renamed from: l */
    public Boolean f917l;

    /* JADX INFO: renamed from: m */
    public Integer f918m;

    /* JADX INFO: renamed from: n */
    public Integer f919n;

    /* JADX INFO: renamed from: o */
    public Integer f920o;

    /* JADX INFO: renamed from: p */
    public Integer f921p;

    /* JADX INFO: renamed from: a */
    public static C2140s m711a(JsonReader jsonReader) throws IOException {
        C2140s c2140s = new C2140s();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("enableScreenshot".equals(strNextName)) {
                c2140s.f906a = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("screenshotUseCellular".equals(strNextName)) {
                c2140s.f907b = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("autoScreenshot".equals(strNextName)) {
                c2140s.f908c = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgentAjax".equals(strNextName)) {
                c2140s.f911f = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgent".equals(strNextName)) {
                c2140s.f910e = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgentSPA".equals(strNextName)) {
                c2140s.f912g = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("timestamp".equalsIgnoreCase(strNextName)) {
                c2140s.f909d = Long.valueOf(jsonReader.nextLong());
            } else if ("anrThreshold".equalsIgnoreCase(strNextName)) {
                c2140s.f914i = Long.valueOf(jsonReader.nextLong());
            } else if (!"deviceMetricsConfigurations".equals(strNextName)) {
                if ("enableMemory".equals(strNextName)) {
                    c2140s.f915j = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("enableStorage".equals(strNextName)) {
                    c2140s.f916k = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("enableBattery".equals(strNextName)) {
                    c2140s.f917l = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("collectionFrequencyMins".equals(strNextName)) {
                    c2140s.f918m = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalMemoryThresholdPercentage".equals(strNextName)) {
                    c2140s.f919n = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalBatteryThresholdPercentage".equals(strNextName)) {
                    c2140s.f920o = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalStorageThresholdPercentage".equals(strNextName)) {
                    c2140s.f921p = Integer.valueOf(jsonReader.nextInt());
                } else if ("enableFeatures".equalsIgnoreCase(strNextName)) {
                    c2140s.f913h = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        c2140s.f913h.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                } else {
                    jsonReader.skipValue();
                }
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("enableMemory")) {
                        c2140s.f915j = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("enableBattery")) {
                        c2140s.f917l = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("enableStorage")) {
                        c2140s.f916k = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("collectionFrequencyMins")) {
                        c2140s.f918m = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalMemoryThresholdPercentage")) {
                        c2140s.f919n = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalBatteryThresholdPercentage")) {
                        c2140s.f920o = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalStorageThresholdPercentage")) {
                        c2140s.f921p = Integer.valueOf(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return c2140s;
    }

    /* JADX INFO: renamed from: a */
    public final void m712a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        if (this.f909d != null) {
            jsonWriter.name("timestamp").value(this.f909d);
        }
        if (this.f906a != null) {
            jsonWriter.name("enableScreenshot").value(this.f906a);
        }
        if (this.f907b != null) {
            jsonWriter.name("screenshotUseCellular").value(this.f907b);
        }
        if (this.f908c != null) {
            jsonWriter.name("autoScreenshot").value(this.f908c);
        }
        if (this.f911f != null) {
            jsonWriter.name("enableJSAgentAjax").value(this.f911f);
        }
        if (this.f910e != null) {
            jsonWriter.name("enableJSAgent").value(this.f910e);
        }
        if (this.f912g != null) {
            jsonWriter.name("enableJSAgentSPA").value(this.f912g);
        }
        if (this.f914i != null) {
            jsonWriter.name("anrThreshold").value(this.f914i);
        }
        if (this.f915j != null) {
            jsonWriter.name("enableMemory").value(this.f915j);
        }
        if (this.f916k != null) {
            jsonWriter.name("enableStorage").value(this.f916k);
        }
        if (this.f917l != null) {
            jsonWriter.name("enableBattery").value(this.f917l);
        }
        if (this.f918m != null) {
            jsonWriter.name("collectionFrequencyMins").value(this.f918m);
        }
        if (this.f919n != null) {
            jsonWriter.name("criticalMemoryThresholdPercentage").value(this.f919n);
        }
        if (this.f921p != null) {
            jsonWriter.name("criticalStorageThresholdPercentage").value(this.f921p);
        }
        if (this.f920o != null) {
            jsonWriter.name("criticalBatteryThresholdPercentage").value(this.f920o);
        }
        if (this.f913h != null) {
            jsonWriter.name("enableFeatures").beginArray();
            Iterator<String> it = this.f913h.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            m712a(new JsonWriter(stringWriter));
            return stringWriter.toString();
        } catch (Throwable th) {
            return "{ Error: " + th.getClass().getSimpleName() + ":" + th.getMessage() + "}";
        }
    }
}
