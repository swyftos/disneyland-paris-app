package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.g */
/* JADX INFO: loaded from: classes2.dex */
public class C2128g extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private final String f857i;

    /* JADX INFO: renamed from: j */
    private final String f858j;

    private C2128g(String str, String str2, C2123cs c2123cs) {
        super("system-event", c2123cs);
        this.f857i = str;
        this.f858j = str2;
    }

    public C2128g(String str, String str2) {
        this(str, str2, new C2123cs());
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value("Connection Transition");
        jsonWriter.name("ctt").value("dct");
        jsonWriter.name("cct").value(this.f857i);
        jsonWriter.name("pct").value(this.f858j);
    }
}
