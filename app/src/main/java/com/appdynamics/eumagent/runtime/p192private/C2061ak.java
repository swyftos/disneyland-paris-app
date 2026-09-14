package com.appdynamics.eumagent.runtime.p192private;

import android.content.Context;
import android.content.pm.PackageManager;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ak */
/* JADX INFO: loaded from: classes2.dex */
public class C2061ak extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    public Integer f520i;

    /* JADX INFO: renamed from: j */
    public Integer f521j;

    /* JADX INFO: renamed from: k */
    public Integer f522k;

    /* JADX INFO: renamed from: l */
    public Boolean f523l;

    /* JADX INFO: renamed from: m */
    public Boolean f524m;

    /* JADX INFO: renamed from: n */
    private Context f525n;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ak$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public Integer f526a;

        /* JADX INFO: renamed from: b */
        public Integer f527b;

        /* JADX INFO: renamed from: c */
        public Integer f528c;

        /* JADX INFO: renamed from: d */
        public Boolean f529d;

        /* JADX INFO: renamed from: e */
        public Boolean f530e;

        /* JADX INFO: renamed from: f */
        public Context f531f;
    }

    public C2061ak() {
        super("device-metrics", new C2123cs());
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("av").value(m555b());
        HashMap map = new HashMap();
        Integer num = this.f520i;
        if (num != null) {
            map.put("dcm", num);
        }
        Integer num2 = this.f521j;
        if (num2 != null) {
            map.put("dcs", num2);
        }
        Integer num3 = this.f522k;
        if (num3 != null) {
            map.put("dcb", num3);
        }
        Boolean bool = this.f523l;
        if (bool != null) {
            map.put("dic", bool);
        }
        Boolean bool2 = this.f524m;
        if (bool2 != null) {
            map.put("dil", bool2);
        }
        if (map.isEmpty()) {
            return;
        }
        m552a(jsonWriter, map);
    }

    /* JADX INFO: renamed from: a */
    private static void m552a(JsonWriter jsonWriter, Map<String, Object> map) throws IOException {
        jsonWriter.name("drcm").beginObject();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                jsonWriter.name(str).value((Integer) obj);
            } else if (obj instanceof Boolean) {
                jsonWriter.name(str).value((Boolean) obj);
            } else {
                ADLog.logVerbose("Cannot write device metrics resource consumption value ".concat(String.valueOf(obj)));
            }
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: renamed from: b */
    private String m555b() {
        try {
            return this.f525n.getPackageManager().getPackageInfo(this.f525n.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }
}
