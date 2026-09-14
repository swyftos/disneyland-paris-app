package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bc */
/* JADX INFO: loaded from: classes2.dex */
public class C2080bc extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    public final URL f632i;

    /* JADX INFO: renamed from: j */
    private long f633j;

    /* JADX INFO: renamed from: k */
    private long f634k;

    /* JADX INFO: renamed from: l */
    private int f635l;

    /* JADX INFO: renamed from: m */
    private String f636m;

    /* JADX INFO: renamed from: n */
    private C2072av f637n;

    /* JADX INFO: renamed from: o */
    private Throwable f638o;

    /* JADX INFO: renamed from: p */
    private String f639p;

    /* JADX INFO: renamed from: q */
    private String f640q;

    public C2080bc(URL url, C2123cs c2123cs, C2123cs c2123cs2, int i, String str, C2072av c2072av, long j, long j2, String str2, Map<Class, Map<String, Object>> map) {
        this(url, c2123cs, c2123cs2, i, str, c2072av, j, j2, str2, null, null, map);
    }

    public C2080bc(URL url, C2123cs c2123cs, C2123cs c2123cs2, String str, Throwable th, Map<Class, Map<String, Object>> map) {
        this(url, c2123cs, c2123cs2, -1, null, null, -1L, -1L, str, th, null, map);
    }

    public C2080bc(URL url, C2123cs c2123cs, C2123cs c2123cs2, String str, String str2, Map<Class, Map<String, Object>> map) {
        this(url, c2123cs, c2123cs2, -1, null, null, -1L, -1L, str, null, str2, map);
    }

    private C2080bc(URL url, C2123cs c2123cs, C2123cs c2123cs2, int i, String str, C2072av c2072av, long j, long j2, String str2, Throwable th, String str3, Map<Class, Map<String, Object>> map) {
        super("network-request", c2123cs, c2123cs2);
        this.f632i = url;
        this.f636m = str;
        this.f635l = i;
        this.f637n = c2072av;
        this.f634k = j;
        this.f633j = j2;
        this.f640q = str2;
        this.f638o = th;
        this.f639p = str3;
        this.f873f = map;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        String strM669b;
        jsonWriter.name("url").value(this.f632i.toString());
        if (this.f633j >= 0) {
            jsonWriter.name("pcl").value(this.f633j);
        }
        if (this.f634k >= 0) {
            jsonWriter.name("qcl").value(this.f634k);
        }
        if (this.f635l > 0) {
            jsonWriter.name("hrc").value(this.f635l);
        }
        if (this.f636m != null) {
            jsonWriter.name("hsl").value(this.f636m);
        }
        if (this.f637n != null) {
            jsonWriter.name("crg").value(this.f637n.f595a);
            if (this.f637n.f596b != null) {
                jsonWriter.name("sst").value(this.f637n.f596b);
            }
            if (this.f637n.f598d != null) {
                jsonWriter.name("bgan").value(this.f637n.f598d);
            }
            jsonWriter.name("bts").beginArray();
            for (C2072av.a aVar : this.f637n.f597c) {
                jsonWriter.beginObject();
                jsonWriter.name("btId").value(aVar.f600a);
                jsonWriter.name("time").value(aVar.f602c);
                jsonWriter.name("estimatedTime").value(aVar.f601b);
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.name("see").value(this.f637n.f599e);
        }
        String strSubstring = this.f639p;
        Throwable th = this.f638o;
        if (th != null) {
            strSubstring = th.toString();
            strM669b = C2124ct.m669b(this.f638o);
        } else {
            strM669b = null;
        }
        if (strM669b != null) {
            jsonWriter.name("stackTrace").value(strM669b);
        }
        if (strSubstring != null) {
            if (strSubstring.length() > 1000) {
                strSubstring = strSubstring.substring(0, 1000);
            }
            jsonWriter.name("ne").value(strSubstring);
        }
        JsonWriter jsonWriterName = jsonWriter.name("is");
        String str = this.f640q;
        if (str == null) {
            str = "Unknown";
        }
        jsonWriterName.value(str);
    }
}
