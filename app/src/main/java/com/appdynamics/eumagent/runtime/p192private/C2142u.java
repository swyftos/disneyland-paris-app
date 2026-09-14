package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.u */
/* JADX INFO: loaded from: classes2.dex */
public class C2142u extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private StackTraceElement[] f942i;

    public C2142u(C2123cs c2123cs, C2123cs c2123cs2, StackTraceElement[] stackTraceElementArr) {
        super("anr", c2123cs, c2123cs2);
        this.f942i = stackTraceElementArr;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        if (this.f942i == null) {
            return;
        }
        jsonWriter.name("javaStackTrace");
        C2103bz.m630a(jsonWriter, this.f942i);
    }
}
