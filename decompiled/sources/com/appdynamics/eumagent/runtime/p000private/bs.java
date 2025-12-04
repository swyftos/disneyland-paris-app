package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes2.dex */
public class bs extends j {
    private UUID i;
    private String j;
    private String k;

    public bs(String str, cs csVar, cs csVar2, UUID uuid, String str2) {
        super("ui", csVar, csVar2);
        this.j = str;
        this.i = uuid;
        this.k = str2;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value(this.k);
        jsonWriter.name("sessionFrameName").value(this.j);
        jsonWriter.name("sessionFrameUuid").value(this.i.toString().toLowerCase());
    }
}
