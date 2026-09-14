package com.appdynamics.eumagent.runtime.p192private;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bq */
/* JADX INFO: loaded from: classes2.dex */
public class C2094bq extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private List<List<C2092bo>> f714i;

    /* JADX INFO: renamed from: j */
    private String f715j;

    /* JADX INFO: renamed from: k */
    private String f716k;

    C2094bq(C2123cs c2123cs, List<List<C2092bo>> list, String str, String str2) {
        super("touch-points", c2123cs);
        this.f714i = list;
        this.f715j = str;
        this.f716k = str2;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("screenshot").value(this.f715j);
        jsonWriter.name("screenshotPre").value(this.f716k);
        jsonWriter.name("tracks").beginArray();
        for (List<C2092bo> list : this.f714i) {
            jsonWriter.beginArray();
            for (C2092bo c2092bo : list) {
                jsonWriter.beginObject();
                jsonWriter.name("ts").value(c2092bo.f698a);
                jsonWriter.name(TypedValues.CycleType.S_WAVE_PHASE).value(c2092bo.f699b);
                jsonWriter.name("x").value(c2092bo.f700c);
                jsonWriter.name("y").value(c2092bo.f701d);
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
        }
        jsonWriter.endArray();
    }
}
