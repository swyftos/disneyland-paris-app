package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cc */
/* JADX INFO: loaded from: classes2.dex */
public class C2107cc extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private UUID f760i;

    /* JADX INFO: renamed from: j */
    private String f761j;

    /* JADX INFO: renamed from: k */
    private String f762k;

    public C2107cc(String str, String str2, UUID uuid, C2123cs c2123cs, C2123cs c2123cs2) {
        super("ui", c2123cs, c2123cs2);
        this.f761j = str;
        this.f762k = str2;
        this.f760i = uuid;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("event").value(this.f762k);
        jsonWriter.name("fragmentName").value(this.f761j);
        jsonWriter.name("fragmentUuid").value(this.f760i.toString().toLowerCase());
    }
}
