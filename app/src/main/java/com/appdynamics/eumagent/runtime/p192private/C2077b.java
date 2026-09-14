package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.b */
/* JADX INFO: loaded from: classes2.dex */
public final class C2077b extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f612i;

    public C2077b(String str) {
        super("crash-report", new C2123cs());
        this.f612i = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("hed").jsonValue(this.f612i);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    public final String toString() {
        return "RawCrashReportEvent{when=" + this.f874g + "hybridExceptionData" + this.f612i + '}';
    }
}
