package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes2.dex */
public class cc extends j {
    private UUID i;
    private String j;
    private String k;

    public cc(String str, String str2, UUID uuid, cs csVar, cs csVar2) {
        super("ui", csVar, csVar2);
        this.j = str;
        this.k = str2;
        this.i = uuid;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value(this.k);
        jsonWriter.name("fragmentName").value(this.j);
        jsonWriter.name("fragmentUuid").value(this.i.toString().toLowerCase());
    }
}
