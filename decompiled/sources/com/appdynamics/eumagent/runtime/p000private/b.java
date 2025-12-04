package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class b extends j {
    private String i;

    public b(String str) {
        super("crash-report", new cs());
        this.i = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("hed").jsonValue(this.i);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final String toString() {
        return "RawCrashReportEvent{when=" + this.g + "hybridExceptionData" + this.i + '}';
    }
}
