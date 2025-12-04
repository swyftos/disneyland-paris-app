package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class bu extends j {
    private String i;

    public bu(String str, cs csVar, cs csVar2) {
        super("timer-event", csVar, csVar2);
        this.i = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("timerName").value(this.i);
    }
}
