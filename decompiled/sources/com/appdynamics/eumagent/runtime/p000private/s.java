package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class s {
    public Boolean a;
    public Boolean b;
    public Boolean c;
    public Long d;
    public Boolean e;
    public Boolean f;
    public Boolean g;
    public List<String> h = Collections.emptyList();
    public Long i;
    public Boolean j;
    public Boolean k;
    public Boolean l;
    public Integer m;
    public Integer n;
    public Integer o;
    public Integer p;

    public static s a(JsonReader jsonReader) throws IOException {
        s sVar = new s();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("enableScreenshot".equals(strNextName)) {
                sVar.a = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("screenshotUseCellular".equals(strNextName)) {
                sVar.b = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("autoScreenshot".equals(strNextName)) {
                sVar.c = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgentAjax".equals(strNextName)) {
                sVar.f = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgent".equals(strNextName)) {
                sVar.e = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("enableJSAgentSPA".equals(strNextName)) {
                sVar.g = Boolean.valueOf(jsonReader.nextBoolean());
            } else if ("timestamp".equalsIgnoreCase(strNextName)) {
                sVar.d = Long.valueOf(jsonReader.nextLong());
            } else if ("anrThreshold".equalsIgnoreCase(strNextName)) {
                sVar.i = Long.valueOf(jsonReader.nextLong());
            } else if (!"deviceMetricsConfigurations".equals(strNextName)) {
                if ("enableMemory".equals(strNextName)) {
                    sVar.j = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("enableStorage".equals(strNextName)) {
                    sVar.k = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("enableBattery".equals(strNextName)) {
                    sVar.l = Boolean.valueOf(jsonReader.nextBoolean());
                } else if ("collectionFrequencyMins".equals(strNextName)) {
                    sVar.m = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalMemoryThresholdPercentage".equals(strNextName)) {
                    sVar.n = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalBatteryThresholdPercentage".equals(strNextName)) {
                    sVar.o = Integer.valueOf(jsonReader.nextInt());
                } else if ("criticalStorageThresholdPercentage".equals(strNextName)) {
                    sVar.p = Integer.valueOf(jsonReader.nextInt());
                } else if ("enableFeatures".equalsIgnoreCase(strNextName)) {
                    sVar.h = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        sVar.h.add(jsonReader.nextString());
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
                        sVar.j = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("enableBattery")) {
                        sVar.l = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("enableStorage")) {
                        sVar.k = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (strNextName2.equals("collectionFrequencyMins")) {
                        sVar.m = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalMemoryThresholdPercentage")) {
                        sVar.n = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalBatteryThresholdPercentage")) {
                        sVar.o = Integer.valueOf(jsonReader.nextInt());
                    } else if (strNextName2.equals("criticalStorageThresholdPercentage")) {
                        sVar.p = Integer.valueOf(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return sVar;
    }

    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        if (this.d != null) {
            jsonWriter.name("timestamp").value(this.d);
        }
        if (this.a != null) {
            jsonWriter.name("enableScreenshot").value(this.a);
        }
        if (this.b != null) {
            jsonWriter.name("screenshotUseCellular").value(this.b);
        }
        if (this.c != null) {
            jsonWriter.name("autoScreenshot").value(this.c);
        }
        if (this.f != null) {
            jsonWriter.name("enableJSAgentAjax").value(this.f);
        }
        if (this.e != null) {
            jsonWriter.name("enableJSAgent").value(this.e);
        }
        if (this.g != null) {
            jsonWriter.name("enableJSAgentSPA").value(this.g);
        }
        if (this.i != null) {
            jsonWriter.name("anrThreshold").value(this.i);
        }
        if (this.j != null) {
            jsonWriter.name("enableMemory").value(this.j);
        }
        if (this.k != null) {
            jsonWriter.name("enableStorage").value(this.k);
        }
        if (this.l != null) {
            jsonWriter.name("enableBattery").value(this.l);
        }
        if (this.m != null) {
            jsonWriter.name("collectionFrequencyMins").value(this.m);
        }
        if (this.n != null) {
            jsonWriter.name("criticalMemoryThresholdPercentage").value(this.n);
        }
        if (this.p != null) {
            jsonWriter.name("criticalStorageThresholdPercentage").value(this.p);
        }
        if (this.o != null) {
            jsonWriter.name("criticalBatteryThresholdPercentage").value(this.o);
        }
        if (this.h != null) {
            jsonWriter.name("enableFeatures").beginArray();
            Iterator<String> it = this.h.iterator();
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
            a(new JsonWriter(stringWriter));
            return stringWriter.toString();
        } catch (Throwable th) {
            return "{ Error: " + th.getClass().getSimpleName() + ":" + th.getMessage() + "}";
        }
    }
}
