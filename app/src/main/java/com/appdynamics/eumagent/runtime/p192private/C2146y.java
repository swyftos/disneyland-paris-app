package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.y */
/* JADX INFO: loaded from: classes2.dex */
public class C2146y extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private C2147z.c f968i;

    public C2146y(C2147z.c cVar) {
        super("crash-report", new C2123cs(cVar.f977b, cVar.f976a));
        this.f968i = cVar;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        ProcMapInfo.FileInfo fileInfo;
        jsonWriter.name("androidNativeCrashReport").beginObject();
        jsonWriter.name("pid").value(this.f968i.f979d);
        jsonWriter.name("tid").value(this.f968i.f980e);
        jsonWriter.name("sigNum").value(this.f968i.f981f);
        jsonWriter.name("sigCode").value(this.f968i.f982g);
        jsonWriter.name("fingerprint").value(this.f968i.f988m);
        jsonWriter.name("abi").value(this.f968i.f986k);
        jsonWriter.name("faultAddr").value(this.f968i.f983h);
        jsonWriter.name("stackTrace");
        jsonWriter.beginArray();
        C2052ab c2052ab = this.f968i.f985j;
        if (c2052ab != null) {
            for (C2052ab.a aVar : c2052ab.f496a) {
                jsonWriter.beginObject();
                jsonWriter.name("absoluteAddr").value(aVar.f498a);
                ProcMapInfo.C2048a c2048a = aVar.f499b;
                if (c2048a != null && (fileInfo = c2048a.f459c) != null) {
                    String str = fileInfo.f452b;
                    if (C2124ct.m666a(str)) {
                        jsonWriter.name("imageName").value("[Unknown Stack]");
                    } else {
                        jsonWriter.name("imageName").value(str);
                        jsonWriter.name("imageOffset").value(aVar.f500c);
                        if (aVar.f501d != null) {
                            jsonWriter.name("symbolName").value(aVar.f501d.f502a);
                            jsonWriter.name("symbolOffset").value(aVar.f501d.f503b);
                        }
                    }
                } else {
                    jsonWriter.name("imageName").value("[Unknown Stack]");
                }
                jsonWriter.endObject();
            }
            if (this.f968i.f985j.f497b) {
                jsonWriter.beginObject();
                jsonWriter.name("imageName").value("[Truncated Stacks]");
                jsonWriter.endObject();
            }
        }
        jsonWriter.endArray();
        if (this.f968i.f984i != null) {
            jsonWriter.name("regs");
            jsonWriter.beginArray();
            for (BigInteger bigInteger : this.f968i.f984i) {
                jsonWriter.value(bigInteger);
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
        C2147z.a[] aVarArr = this.f968i.f996u;
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        jsonWriter.name("bcs").beginArray();
        for (C2147z.a aVar2 : this.f968i.f996u) {
            jsonWriter.beginObject().name("text").value(aVar2.f972b).name("ts").value(aVar2.f971a).endObject();
        }
        jsonWriter.endArray();
    }
}
