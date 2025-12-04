package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class g extends j {
    private final String i;
    private final String j;

    private g(String str, String str2, cs csVar) {
        super("system-event", csVar);
        this.i = str;
        this.j = str2;
    }

    public g(String str, String str2) {
        this(str, str2, new cs());
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value("Connection Transition");
        jsonWriter.name("ctt").value("dct");
        jsonWriter.name("cct").value(this.i);
        jsonWriter.name("pct").value(this.j);
    }
}
