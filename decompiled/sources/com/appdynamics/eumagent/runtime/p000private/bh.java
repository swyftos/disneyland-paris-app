package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class bh extends j {
    private int i;
    private int j;
    private int k;
    private String[] l;

    public bh(String str, cs csVar, int i, int i2, String[] strArr, int i3) {
        super("screenshot", csVar, null, str);
        this.i = i;
        this.j = i2;
        this.l = strArr;
        this.k = i3;
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("width").value(this.i);
        jsonWriter.name("height").value(this.j);
        jsonWriter.name("cols").value(this.k);
        jsonWriter.name("tiles").beginArray();
        int i = 0;
        while (true) {
            String[] strArr = this.l;
            if (i < strArr.length) {
                jsonWriter.value(strArr[i]);
                i++;
            } else {
                jsonWriter.endArray();
                return;
            }
        }
    }
}
