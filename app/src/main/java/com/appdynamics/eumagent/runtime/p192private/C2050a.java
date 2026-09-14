package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.a */
/* JADX INFO: loaded from: classes2.dex */
public final class C2050a extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f463i;

    /* JADX INFO: renamed from: j */
    private String f464j;

    /* JADX INFO: renamed from: k */
    private Iterable<C2137p> f465k;

    public C2050a(String str, String str2, C2123cs c2123cs, Iterable<C2137p> iterable) {
        super("crash-report", c2123cs);
        this.f463i = str;
        this.f464j = str2;
        this.f465k = iterable;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("bcs").beginArray();
        for (C2137p c2137p : this.f465k) {
            jsonWriter.beginObject().name("text").value(c2137p.f901i).name("ts").value(c2137p.f874g.f818b).endObject();
        }
        jsonWriter.endArray();
        jsonWriter.name(this.f464j).jsonValue(this.f463i);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    public final String toString() {
        return "ExternalCrashReportEvent{when=" + this.f874g + '}';
    }
}
