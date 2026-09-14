package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.e */
/* JADX INFO: loaded from: classes2.dex */
public final class C2126e {

    /* JADX INFO: renamed from: a */
    public final String f825a;

    /* JADX INFO: renamed from: b */
    public final String f826b;

    /* JADX INFO: renamed from: c */
    public final String f827c;

    /* JADX INFO: renamed from: d */
    public final String f828d;

    /* JADX INFO: renamed from: e */
    public final Integer f829e;

    /* JADX INFO: renamed from: f */
    public final String f830f;

    /* JADX INFO: renamed from: g */
    public final String f831g;

    /* JADX INFO: renamed from: h */
    public final String f832h;

    /* JADX INFO: renamed from: i */
    public final Map<Class, Map<String, Object>> f833i;

    /* JADX INFO: renamed from: j */
    private String f834j;

    /* JADX INFO: renamed from: k */
    private int f835k;

    /* JADX INFO: renamed from: l */
    private String f836l;

    /* JADX INFO: renamed from: m */
    private String f837m;

    /* JADX INFO: renamed from: n */
    private String f838n;

    /* JADX INFO: renamed from: o */
    private Long f839o;

    /* JADX INFO: renamed from: p */
    private String f840p;

    /* JADX INFO: renamed from: q */
    private String f841q;

    /* JADX INFO: renamed from: r */
    private DeviceMetricsCollector f842r;

    public C2126e(String str, int i, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Integer num, String str9, String str10, String str11, Map<Class, Map<String, Object>> map, String str12, String str13, DeviceMetricsCollector deviceMetricsCollector) {
        this.f834j = str;
        this.f835k = i;
        this.f836l = str2;
        this.f837m = str3;
        this.f838n = str4;
        this.f825a = str5;
        this.f826b = str6;
        this.f839o = l;
        this.f827c = str7;
        this.f828d = str8;
        this.f829e = num;
        this.f840p = str9;
        this.f830f = str10;
        this.f831g = str11;
        this.f833i = map;
        this.f832h = str12;
        this.f841q = str13;
        this.f842r = deviceMetricsCollector;
    }

    /* JADX INFO: renamed from: a */
    public final void m676a(JsonWriter jsonWriter, Map<Class, Map<String, Object>> map) {
        Long totalMemoryInMegaBytes;
        Double totalBatteryCapacity;
        Long totalDiskSpaceInMegaBytes;
        if (this.f835k != -1) {
            jsonWriter.name("avi").value(this.f835k);
        }
        jsonWriter.name("av").value(this.f834j).name("agv").value(this.f837m).name(DeviceInfo.LABEL_APP_BUILD_NUMBER).value(this.f838n).name("dm").value(this.f825a).name("dmo").value(this.f826b).name("ds").value(this.f839o).name("tm").value(this.f827c).name("cf").value(this.f828d).name("cc").value(this.f829e).name("osv").value(this.f840p).name("ca").value(this.f830f).name("ct").value(this.f831g);
        if (this.f836l != null) {
            jsonWriter.name("bid").value(this.f836l);
        }
        if (this.f832h != null && this.f841q != null) {
            jsonWriter.name("hat").value(this.f832h);
            jsonWriter.name("hav").value(this.f841q);
        }
        Map<Class, Map<String, Object>> map2 = this.f833i;
        if (map2 != null && map != null) {
            HashMap map3 = new HashMap();
            for (Map.Entry<Class, Map<String, Object>> entry : map2.entrySet()) {
                Class key = entry.getKey();
                HashMap map4 = new HashMap(entry.getValue());
                map4.putAll(map.get(key));
                map3.put(key, map4);
            }
            C2124ct.m662a(jsonWriter, map3);
        } else if (map != null) {
            C2124ct.m662a(jsonWriter, map);
        } else if (map2 != null) {
            C2124ct.m662a(jsonWriter, map2);
        }
        if (this.f842r.shouldCollectStorageDeviceSpecification().booleanValue() && (totalDiskSpaceInMegaBytes = this.f842r.getTotalDiskSpaceInMegaBytes()) != null) {
            jsonWriter.name("dss").value(totalDiskSpaceInMegaBytes);
        }
        if (this.f842r.shouldCollectBatteryDeviceSpecification().booleanValue() && (totalBatteryCapacity = this.f842r.getTotalBatteryCapacity()) != null) {
            jsonWriter.name("dsb").value(totalBatteryCapacity);
        }
        if (!this.f842r.shouldCollectMemoryDeviceSpecification().booleanValue() || (totalMemoryInMegaBytes = this.f842r.getTotalMemoryInMegaBytes()) == null) {
            return;
        }
        jsonWriter.name("dsm").value(totalMemoryInMegaBytes);
    }

    /* JADX INFO: renamed from: a */
    public final C2126e m675a(String str, String str2, Map<Class, Map<String, Object>> map) {
        return new C2126e(this.f834j, this.f835k, this.f836l, this.f837m, this.f838n, this.f825a, this.f826b, this.f839o, this.f827c, this.f828d, this.f829e, this.f840p, str, str2, map, this.f832h, this.f841q, this.f842r);
    }
}
