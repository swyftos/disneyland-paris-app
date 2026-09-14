package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ar */
/* JADX INFO: loaded from: classes2.dex */
public class C2068ar extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f570i;

    /* JADX INFO: renamed from: j */
    private Throwable f571j;

    /* JADX INFO: renamed from: k */
    private int f572k;

    public C2068ar(String str, Throwable th, int i) {
        super("log-event", new C2123cs());
        this.f570i = str;
        this.f571j = th;
        this.f572k = i;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f570i);
        sb.append("\n");
        sb.append(C2124ct.m669b(this.f571j));
        if (this.f572k > 0) {
            sb.append("\n");
            sb.append("Dropped ");
            sb.append(this.f572k);
            sb.append(" previous log messages.");
            jsonWriter.name("droppedMessages").value(this.f572k);
        }
        jsonWriter.name("text").value(sb.toString());
    }
}
