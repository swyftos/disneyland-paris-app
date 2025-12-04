package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class a extends j {
    private String i;
    private String j;
    private Iterable<p> k;

    public a(String str, String str2, cs csVar, Iterable<p> iterable) {
        super("crash-report", csVar);
        this.i = str;
        this.j = str2;
        this.k = iterable;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("bcs").beginArray();
        for (p pVar : this.k) {
            jsonWriter.beginObject().name("text").value(pVar.i).name("ts").value(pVar.g.b).endObject();
        }
        jsonWriter.endArray();
        jsonWriter.name(this.j).jsonValue(this.i);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final String toString() {
        return "ExternalCrashReportEvent{when=" + this.g + '}';
    }
}
