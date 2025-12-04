package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class at extends j {
    private String i;
    private long j;

    public at(String str, long j, cs csVar) {
        super("custom-metric-event", csVar);
        this.i = str;
        this.j = j;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("metricName").value(this.i);
        jsonWriter.name("val").value(this.j);
    }
}
