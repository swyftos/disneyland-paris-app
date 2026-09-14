package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bh */
/* JADX INFO: loaded from: classes2.dex */
public class C2085bh extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    private int f662i;

    /* JADX INFO: renamed from: j */
    private int f663j;

    /* JADX INFO: renamed from: k */
    private int f664k;

    /* JADX INFO: renamed from: l */
    private String[] f665l;

    public C2085bh(String str, C2123cs c2123cs, int i, int i2, String[] strArr, int i3) {
        super("screenshot", c2123cs, null, str);
        this.f662i = i;
        this.f663j = i2;
        this.f665l = strArr;
        this.f664k = i3;
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("width").value(this.f662i);
        jsonWriter.name("height").value(this.f663j);
        jsonWriter.name("cols").value(this.f664k);
        jsonWriter.name("tiles").beginArray();
        int i = 0;
        while (true) {
            String[] strArr = this.f665l;
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
