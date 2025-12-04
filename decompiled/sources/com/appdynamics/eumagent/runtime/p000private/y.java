package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.eumagent.runtime.p000private.ab;
import com.appdynamics.eumagent.runtime.p000private.z;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class y extends j {
    private z.c i;

    public y(z.c cVar) {
        super("crash-report", new cs(cVar.b, cVar.a));
        this.i = cVar;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        ProcMapInfo.FileInfo fileInfo;
        jsonWriter.name("androidNativeCrashReport").beginObject();
        jsonWriter.name("pid").value(this.i.d);
        jsonWriter.name("tid").value(this.i.e);
        jsonWriter.name("sigNum").value(this.i.f);
        jsonWriter.name("sigCode").value(this.i.g);
        jsonWriter.name("fingerprint").value(this.i.m);
        jsonWriter.name("abi").value(this.i.k);
        jsonWriter.name("faultAddr").value(this.i.h);
        jsonWriter.name("stackTrace");
        jsonWriter.beginArray();
        ab abVar = this.i.j;
        if (abVar != null) {
            for (ab.a aVar : abVar.a) {
                jsonWriter.beginObject();
                jsonWriter.name("absoluteAddr").value(aVar.a);
                ProcMapInfo.a aVar2 = aVar.b;
                if (aVar2 != null && (fileInfo = aVar2.c) != null) {
                    String str = fileInfo.b;
                    if (ct.a(str)) {
                        jsonWriter.name("imageName").value("[Unknown Stack]");
                    } else {
                        jsonWriter.name("imageName").value(str);
                        jsonWriter.name("imageOffset").value(aVar.c);
                        if (aVar.d != null) {
                            jsonWriter.name("symbolName").value(aVar.d.a);
                            jsonWriter.name("symbolOffset").value(aVar.d.b);
                        }
                    }
                } else {
                    jsonWriter.name("imageName").value("[Unknown Stack]");
                }
                jsonWriter.endObject();
            }
            if (this.i.j.b) {
                jsonWriter.beginObject();
                jsonWriter.name("imageName").value("[Truncated Stacks]");
                jsonWriter.endObject();
            }
        }
        jsonWriter.endArray();
        if (this.i.i != null) {
            jsonWriter.name("regs");
            jsonWriter.beginArray();
            for (BigInteger bigInteger : this.i.i) {
                jsonWriter.value(bigInteger);
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
        z.a[] aVarArr = this.i.u;
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        jsonWriter.name("bcs").beginArray();
        for (z.a aVar3 : this.i.u) {
            jsonWriter.beginObject().name("text").value(aVar3.b).name("ts").value(aVar3.a).endObject();
        }
        jsonWriter.endArray();
    }
}
