package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.p */
/* JADX INFO: loaded from: classes2.dex */
public class C2137p extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    public final String f901i;

    public C2137p(String str) {
        super("breadcrumb", new C2123cs());
        this.f901i = C2124ct.m673e(str);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("text").value(this.f901i);
    }
}
