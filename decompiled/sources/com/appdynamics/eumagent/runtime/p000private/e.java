package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;
    public final String f;
    public final String g;
    public final String h;
    public final Map<Class, Map<String, Object>> i;
    private String j;
    private int k;
    private String l;
    private String m;
    private String n;
    private Long o;
    private String p;
    private String q;
    private DeviceMetricsCollector r;

    public e(String str, int i, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Integer num, String str9, String str10, String str11, Map<Class, Map<String, Object>> map, String str12, String str13, DeviceMetricsCollector deviceMetricsCollector) {
        this.j = str;
        this.k = i;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.a = str5;
        this.b = str6;
        this.o = l;
        this.c = str7;
        this.d = str8;
        this.e = num;
        this.p = str9;
        this.f = str10;
        this.g = str11;
        this.i = map;
        this.h = str12;
        this.q = str13;
        this.r = deviceMetricsCollector;
    }

    public final void a(JsonWriter jsonWriter, Map<Class, Map<String, Object>> map) {
        Long totalMemoryInMegaBytes;
        Double totalBatteryCapacity;
        Long totalDiskSpaceInMegaBytes;
        if (this.k != -1) {
            jsonWriter.name("avi").value(this.k);
        }
        jsonWriter.name("av").value(this.j).name("agv").value(this.m).name(DeviceInfo.LABEL_APP_BUILD_NUMBER).value(this.n).name("dm").value(this.a).name("dmo").value(this.b).name("ds").value(this.o).name("tm").value(this.c).name("cf").value(this.d).name("cc").value(this.e).name("osv").value(this.p).name("ca").value(this.f).name("ct").value(this.g);
        if (this.l != null) {
            jsonWriter.name("bid").value(this.l);
        }
        if (this.h != null && this.q != null) {
            jsonWriter.name("hat").value(this.h);
            jsonWriter.name("hav").value(this.q);
        }
        Map<Class, Map<String, Object>> map2 = this.i;
        if (map2 != null && map != null) {
            HashMap map3 = new HashMap();
            for (Map.Entry<Class, Map<String, Object>> entry : map2.entrySet()) {
                Class key = entry.getKey();
                HashMap map4 = new HashMap(entry.getValue());
                map4.putAll(map.get(key));
                map3.put(key, map4);
            }
            ct.a(jsonWriter, map3);
        } else if (map != null) {
            ct.a(jsonWriter, map);
        } else if (map2 != null) {
            ct.a(jsonWriter, map2);
        }
        if (this.r.shouldCollectStorageDeviceSpecification().booleanValue() && (totalDiskSpaceInMegaBytes = this.r.getTotalDiskSpaceInMegaBytes()) != null) {
            jsonWriter.name("dss").value(totalDiskSpaceInMegaBytes);
        }
        if (this.r.shouldCollectBatteryDeviceSpecification().booleanValue() && (totalBatteryCapacity = this.r.getTotalBatteryCapacity()) != null) {
            jsonWriter.name("dsb").value(totalBatteryCapacity);
        }
        if (!this.r.shouldCollectMemoryDeviceSpecification().booleanValue() || (totalMemoryInMegaBytes = this.r.getTotalMemoryInMegaBytes()) == null) {
            return;
        }
        jsonWriter.name("dsm").value(totalMemoryInMegaBytes);
    }

    public final e a(String str, String str2, Map<Class, Map<String, Object>> map) {
        return new e(this.j, this.k, this.l, this.m, this.n, this.a, this.b, this.o, this.c, this.d, this.e, this.p, str, str2, map, this.h, this.q, this.r);
    }
}
