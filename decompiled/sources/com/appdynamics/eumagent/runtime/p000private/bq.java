package com.appdynamics.eumagent.runtime.p000private;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public class bq extends j {
    private List<List<bo>> i;
    private String j;
    private String k;

    bq(cs csVar, List<List<bo>> list, String str, String str2) {
        super("touch-points", csVar);
        this.i = list;
        this.j = str;
        this.k = str2;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("screenshot").value(this.j);
        jsonWriter.name("screenshotPre").value(this.k);
        jsonWriter.name("tracks").beginArray();
        for (List<bo> list : this.i) {
            jsonWriter.beginArray();
            for (bo boVar : list) {
                jsonWriter.beginObject();
                jsonWriter.name("ts").value(boVar.a);
                jsonWriter.name(TypedValues.CycleType.S_WAVE_PHASE).value(boVar.b);
                jsonWriter.name("x").value(boVar.c);
                jsonWriter.name("y").value(boVar.d);
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
        }
        jsonWriter.endArray();
    }
}
