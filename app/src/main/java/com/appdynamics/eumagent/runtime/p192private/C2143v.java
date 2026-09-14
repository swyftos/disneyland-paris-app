package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.v */
/* JADX INFO: loaded from: classes2.dex */
public final class C2143v extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private Throwable f943i;

    /* JADX INFO: renamed from: j */
    private Thread f944j;

    /* JADX INFO: renamed from: k */
    private Iterable<C2137p> f945k;

    /* JADX INFO: renamed from: l */
    private long f946l;

    public C2143v(Throwable th, Thread thread, C2123cs c2123cs, Iterable<C2137p> iterable, long j) {
        super("crash-report", c2123cs);
        this.f943i = th;
        this.f944j = thread;
        this.f945k = iterable;
        this.f946l = j;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        String message = this.f943i.getMessage();
        jsonWriter.name("androidCrashReport").beginObject();
        jsonWriter.name("thread").value(this.f944j.toString());
        jsonWriter.name("time").value(this.f874g.f818b);
        jsonWriter.name("stackTrace");
        if (message.contains("stack:") && this.f870c.f832h.equals("React Native")) {
            C2103bz.m628a(jsonWriter, new Exception(message.substring(0, message.indexOf("stack:")), this.f943i), true);
        } else {
            C2103bz.m628a(jsonWriter, this.f943i, true);
        }
        jsonWriter.endObject();
        if (message.contains("stack:") && this.f870c.f832h.equals("React Native")) {
            try {
                jsonWriter.name("hed").beginObject();
                jsonWriter.name("rst").value(message.substring(message.indexOf("stack:") + 6));
                jsonWriter.name("crt").value(this.f874g.f818b);
                jsonWriter.name("env").value("React Native");
                jsonWriter.name("em").value(message.substring(0, message.lastIndexOf("stack:")));
                jsonWriter.endObject();
            } catch (StringIndexOutOfBoundsException unused) {
                ADLog.logAgentError("Hybrid Stacktrace out of bounds");
            }
        }
        jsonWriter.name("bcs").beginArray();
        for (C2137p c2137p : this.f945k) {
            jsonWriter.beginObject().name("text").value(c2137p.f901i).name("ts").value(c2137p.f874g.f818b).endObject();
        }
        jsonWriter.endArray();
        jsonWriter.name("uam").value(this.f946l);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    public final String toString() {
        return "CrashReportEvent{when=" + this.f874g + "throwable=" + this.f943i + "thread=" + this.f944j + "breadcrumbs=" + this.f945k + "usedMemory=" + this.f946l + '}';
    }
}
