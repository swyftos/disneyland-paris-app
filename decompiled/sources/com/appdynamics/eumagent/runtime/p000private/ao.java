package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class ao extends j {
    private String i;
    private String j;
    private boolean k;
    private Object[] l;
    private Object m;
    private Throwable n;

    public ao(String str, String str2, boolean z, Object[] objArr, Object obj, Throwable th, cs csVar, cs csVar2) {
        super("method-call", csVar, csVar2);
        this.i = str;
        this.j = str2;
        this.k = z;
        this.l = objArr;
        this.m = obj;
        this.n = th;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("mid").beginObject();
        jsonWriter.name("cls").value(this.i);
        jsonWriter.name("mth").value(this.j);
        jsonWriter.name("icm").value(this.k);
        jsonWriter.endObject();
        if (this.l != null) {
            jsonWriter.name("args").beginArray();
            for (Object obj : this.l) {
                bz.a(jsonWriter, obj);
            }
            jsonWriter.endArray();
        }
        if (this.m != null) {
            jsonWriter.name("ret");
            bz.a(jsonWriter, this.m);
        }
        if (this.n != null) {
            StringWriter stringWriter = new StringWriter();
            bz.a(new JsonWriter(stringWriter), this.n, true);
            jsonWriter.name("stackTrace").value(stringWriter.toString());
        }
    }
}
