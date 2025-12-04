package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class u extends j {
    private StackTraceElement[] i;

    public u(cs csVar, cs csVar2, StackTraceElement[] stackTraceElementArr) {
        super("anr", csVar, csVar2);
        this.i = stackTraceElementArr;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        if (this.i == null) {
            return;
        }
        jsonWriter.name("javaStackTrace");
        bz.a(jsonWriter, this.i);
    }
}
