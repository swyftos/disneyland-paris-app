package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.p000private.av;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes2.dex */
public class bc extends j {
    public final URL i;
    private long j;
    private long k;
    private int l;
    private String m;
    private av n;
    private Throwable o;
    private String p;
    private String q;

    public bc(URL url, cs csVar, cs csVar2, int i, String str, av avVar, long j, long j2, String str2, Map<Class, Map<String, Object>> map) {
        this(url, csVar, csVar2, i, str, avVar, j, j2, str2, null, null, map);
    }

    public bc(URL url, cs csVar, cs csVar2, String str, Throwable th, Map<Class, Map<String, Object>> map) {
        this(url, csVar, csVar2, -1, null, null, -1L, -1L, str, th, null, map);
    }

    public bc(URL url, cs csVar, cs csVar2, String str, String str2, Map<Class, Map<String, Object>> map) {
        this(url, csVar, csVar2, -1, null, null, -1L, -1L, str, null, str2, map);
    }

    private bc(URL url, cs csVar, cs csVar2, int i, String str, av avVar, long j, long j2, String str2, Throwable th, String str3, Map<Class, Map<String, Object>> map) {
        super("network-request", csVar, csVar2);
        this.i = url;
        this.m = str;
        this.l = i;
        this.n = avVar;
        this.k = j;
        this.j = j2;
        this.q = str2;
        this.o = th;
        this.p = str3;
        this.f = map;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        String strB;
        jsonWriter.name("url").value(this.i.toString());
        if (this.j >= 0) {
            jsonWriter.name("pcl").value(this.j);
        }
        if (this.k >= 0) {
            jsonWriter.name("qcl").value(this.k);
        }
        if (this.l > 0) {
            jsonWriter.name("hrc").value(this.l);
        }
        if (this.m != null) {
            jsonWriter.name("hsl").value(this.m);
        }
        if (this.n != null) {
            jsonWriter.name("crg").value(this.n.a);
            if (this.n.b != null) {
                jsonWriter.name("sst").value(this.n.b);
            }
            if (this.n.d != null) {
                jsonWriter.name("bgan").value(this.n.d);
            }
            jsonWriter.name("bts").beginArray();
            for (av.a aVar : this.n.c) {
                jsonWriter.beginObject();
                jsonWriter.name("btId").value(aVar.a);
                jsonWriter.name("time").value(aVar.c);
                jsonWriter.name("estimatedTime").value(aVar.b);
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.name("see").value(this.n.e);
        }
        String strSubstring = this.p;
        Throwable th = this.o;
        if (th != null) {
            strSubstring = th.toString();
            strB = ct.b(this.o);
        } else {
            strB = null;
        }
        if (strB != null) {
            jsonWriter.name("stackTrace").value(strB);
        }
        if (strSubstring != null) {
            if (strSubstring.length() > 1000) {
                strSubstring = strSubstring.substring(0, 1000);
            }
            jsonWriter.name("ne").value(strSubstring);
        }
        JsonWriter jsonWriterName = jsonWriter.name("is");
        String str = this.q;
        if (str == null) {
            str = "Unknown";
        }
        jsonWriterName.value(str);
    }
}
