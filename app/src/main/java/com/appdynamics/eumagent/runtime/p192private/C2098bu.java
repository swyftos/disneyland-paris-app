package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bu */
/* JADX INFO: loaded from: classes2.dex */
public class C2098bu extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private String f727i;

    public C2098bu(String str, C2123cs c2123cs, C2123cs c2123cs2) {
        super("timer-event", c2123cs, c2123cs2);
        this.f727i = str;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("timerName").value(this.f727i);
    }
}
