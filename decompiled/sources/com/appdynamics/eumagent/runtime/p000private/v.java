package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class v extends j {
    private Throwable i;
    private Thread j;
    private Iterable<p> k;
    private long l;

    public v(Throwable th, Thread thread, cs csVar, Iterable<p> iterable, long j) {
        super("crash-report", csVar);
        this.i = th;
        this.j = thread;
        this.k = iterable;
        this.l = j;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        String message = this.i.getMessage();
        jsonWriter.name("androidCrashReport").beginObject();
        jsonWriter.name("thread").value(this.j.toString());
        jsonWriter.name("time").value(this.g.b);
        jsonWriter.name("stackTrace");
        if (message.contains("stack:") && this.c.h.equals("React Native")) {
            bz.a(jsonWriter, new Exception(message.substring(0, message.indexOf("stack:")), this.i), true);
        } else {
            bz.a(jsonWriter, this.i, true);
        }
        jsonWriter.endObject();
        if (message.contains("stack:") && this.c.h.equals("React Native")) {
            try {
                jsonWriter.name("hed").beginObject();
                jsonWriter.name("rst").value(message.substring(message.indexOf("stack:") + 6));
                jsonWriter.name("crt").value(this.g.b);
                jsonWriter.name("env").value("React Native");
                jsonWriter.name("em").value(message.substring(0, message.lastIndexOf("stack:")));
                jsonWriter.endObject();
            } catch (StringIndexOutOfBoundsException unused) {
                ADLog.logAgentError("Hybrid Stacktrace out of bounds");
            }
        }
        jsonWriter.name("bcs").beginArray();
        for (p pVar : this.k) {
            jsonWriter.beginObject().name("text").value(pVar.i).name("ts").value(pVar.g.b).endObject();
        }
        jsonWriter.endArray();
        jsonWriter.name("uam").value(this.l);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final String toString() {
        return "CrashReportEvent{when=" + this.g + "throwable=" + this.i + "thread=" + this.j + "breadcrumbs=" + this.k + "usedMemory=" + this.l + '}';
    }
}
