package com.appdynamics.eumagent.runtime.p000private;

import android.content.Context;
import android.content.pm.PackageManager;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ak extends j {
    public Integer i;
    public Integer j;
    public Integer k;
    public Boolean l;
    public Boolean m;
    private Context n;

    public static class a {
        public Integer a;
        public Integer b;
        public Integer c;
        public Boolean d;
        public Boolean e;
        public Context f;
    }

    public ak() {
        super("device-metrics", new cs());
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("av").value(b());
        HashMap map = new HashMap();
        Integer num = this.i;
        if (num != null) {
            map.put("dcm", num);
        }
        Integer num2 = this.j;
        if (num2 != null) {
            map.put("dcs", num2);
        }
        Integer num3 = this.k;
        if (num3 != null) {
            map.put("dcb", num3);
        }
        Boolean bool = this.l;
        if (bool != null) {
            map.put("dic", bool);
        }
        Boolean bool2 = this.m;
        if (bool2 != null) {
            map.put("dil", bool2);
        }
        if (map.isEmpty()) {
            return;
        }
        a(jsonWriter, map);
    }

    private static void a(JsonWriter jsonWriter, Map<String, Object> map) throws IOException {
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

    private String b() {
        try {
            return this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }
}
