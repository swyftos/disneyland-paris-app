package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class p extends j {
    public final String i;

    public p(String str) {
        super("breadcrumb", new cs());
        this.i = ct.e(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("text").value(this.i);
    }
}
