package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.c */
/* JADX INFO: loaded from: classes2.dex */
public class C2104c extends AbstractC2131j {
    private C2104c(C2123cs c2123cs) {
        super("system-event", c2123cs);
    }

    public C2104c() {
        this(new C2123cs());
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value("Agent Init");
    }
}
