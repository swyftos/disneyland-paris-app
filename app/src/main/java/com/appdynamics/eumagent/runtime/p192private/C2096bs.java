package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bs */
/* JADX INFO: loaded from: classes2.dex */
public class C2096bs extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private UUID f717i;

    /* JADX INFO: renamed from: j */
    private String f718j;

    /* JADX INFO: renamed from: k */
    private String f719k;

    public C2096bs(String str, C2123cs c2123cs, C2123cs c2123cs2, UUID uuid, String str2) {
        super("ui", c2123cs, c2123cs2);
        this.f718j = str;
        this.f717i = uuid;
        this.f719k = str2;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value(this.f719k);
        jsonWriter.name("sessionFrameName").value(this.f718j);
        jsonWriter.name("sessionFrameUuid").value(this.f717i.toString().toLowerCase());
    }
}
