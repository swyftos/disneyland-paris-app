package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.at */
/* JADX INFO: loaded from: classes2.dex */
public class C2070at extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f577i;

    /* JADX INFO: renamed from: j */
    private long f578j;

    public C2070at(String str, long j, C2123cs c2123cs) {
        super("custom-metric-event", c2123cs);
        this.f577i = str;
        this.f578j = j;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("metricName").value(this.f577i);
        jsonWriter.name("val").value(this.f578j);
    }
}
