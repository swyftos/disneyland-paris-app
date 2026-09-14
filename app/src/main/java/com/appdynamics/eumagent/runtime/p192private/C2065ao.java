package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ao */
/* JADX INFO: loaded from: classes2.dex */
public class C2065ao extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f549i;

    /* JADX INFO: renamed from: j */
    private String f550j;

    /* JADX INFO: renamed from: k */
    private boolean f551k;

    /* JADX INFO: renamed from: l */
    private Object[] f552l;

    /* JADX INFO: renamed from: m */
    private Object f553m;

    /* JADX INFO: renamed from: n */
    private Throwable f554n;

    public C2065ao(String str, String str2, boolean z, Object[] objArr, Object obj, Throwable th, C2123cs c2123cs, C2123cs c2123cs2) {
        super("method-call", c2123cs, c2123cs2);
        this.f549i = str;
        this.f550j = str2;
        this.f551k = z;
        this.f552l = objArr;
        this.f553m = obj;
        this.f554n = th;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("mid").beginObject();
        jsonWriter.name("cls").value(this.f549i);
        jsonWriter.name("mth").value(this.f550j);
        jsonWriter.name("icm").value(this.f551k);
        jsonWriter.endObject();
        if (this.f552l != null) {
            jsonWriter.name("args").beginArray();
            for (Object obj : this.f552l) {
                C2103bz.m627a(jsonWriter, obj);
            }
            jsonWriter.endArray();
        }
        if (this.f553m != null) {
            jsonWriter.name("ret");
            C2103bz.m627a(jsonWriter, this.f553m);
        }
        if (this.f554n != null) {
            StringWriter stringWriter = new StringWriter();
            C2103bz.m628a(new JsonWriter(stringWriter), this.f554n, true);
            jsonWriter.name("stackTrace").value(stringWriter.toString());
        }
    }
}
