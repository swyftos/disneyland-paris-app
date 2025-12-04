package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ar extends j {
    private String i;
    private Throwable j;
    private int k;

    public ar(String str, Throwable th, int i) {
        super("log-event", new cs());
        this.i = str;
        this.j = th;
        this.k = i;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i);
        sb.append("\n");
        sb.append(ct.b(this.j));
        if (this.k > 0) {
            sb.append("\n");
            sb.append("Dropped ");
            sb.append(this.k);
            sb.append(" previous log messages.");
            jsonWriter.name("droppedMessages").value(this.k);
        }
        jsonWriter.name("text").value(sb.toString());
    }
}
