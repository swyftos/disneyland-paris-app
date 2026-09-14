package com.appdynamics.eumagent.runtime.crashes;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p192private.C2056af;
import com.appdynamics.eumagent.runtime.p192private.C2063am;
import com.appdynamics.eumagent.runtime.p192private.C2115ck;
import com.appdynamics.eumagent.runtime.p192private.C2116cl;
import com.appdynamics.eumagent.runtime.p192private.C2127f;
import com.appdynamics.eumagent.runtime.p192private.C2135n;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashHandler implements C2063am.b {

    /* JADX INFO: renamed from: a */
    public static boolean f433a = false;

    /* JADX INFO: renamed from: b */
    public final C2063am f434b;

    /* JADX INFO: renamed from: c */
    public final String f435c;

    /* JADX INFO: renamed from: d */
    public final String f436d;

    /* JADX INFO: renamed from: e */
    public final String f437e;

    /* JADX INFO: renamed from: f */
    public final int f438f;

    /* JADX INFO: renamed from: g */
    public String f439g;

    /* JADX INFO: renamed from: h */
    public int f440h;

    /* JADX INFO: renamed from: i */
    public C2056af f441i;

    /* JADX INFO: renamed from: j */
    public C2127f f442j;

    /* JADX INFO: renamed from: k */
    private final C2135n f443k;

    /* JADX INFO: renamed from: l */
    private DeviceMetricsCollector f444l;

    private native int setUserData(String str, String str2);

    public native int leaveBreadcrumb(String str);

    public native int setupSignalHandler(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3);

    static {
        try {
            System.loadLibrary("adeum");
            f433a = true;
        } catch (Throwable unused) {
            f433a = false;
            ADLog.logInfo("Native crash reporting is disabled");
        }
    }

    public NativeCrashHandler(Context context, String str, C2063am c2063am, int i, C2135n c2135n, DeviceMetricsCollector deviceMetricsCollector) {
        this.f439g = "Unknown";
        this.f440h = 0;
        this.f435c = context.getFilesDir().getAbsolutePath();
        this.f436d = str;
        this.f434b = c2063am;
        String packageName = context.getPackageName();
        this.f437e = packageName;
        this.f438f = i;
        this.f443k = c2135n;
        this.f444l = deviceMetricsCollector;
        if (f433a) {
            c2063am.f535a.m656a(C2115ck.class, this);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                this.f439g = packageInfo.versionName;
                this.f440h = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                ADLog.logAgentError("Native crash handler failed to get package info.", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m492a(C2116cl c2116cl) {
        if (f433a) {
            for (Map.Entry<Class, Map<String, Object>> entry : c2116cl.m650a().entrySet()) {
                for (Map.Entry<String, Object> entry2 : entry.getValue().entrySet()) {
                    m486a(entry2.getKey(), entry2.getValue(), entry.getKey());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m486a(String str, Object obj, Class cls) {
        int i;
        if (cls.equals(String.class)) {
            i = 0;
        } else if (cls.equals(Long.class)) {
            i = 1;
        } else if (cls.equals(Boolean.class)) {
            i = 2;
        } else if (cls.equals(Double.class)) {
            i = 3;
        } else {
            i = cls.equals(Date.class) ? 4 : -1;
        }
        if (i == -1) {
            ADLog.logInfo("Native crash handler got unknown user data type: ".concat(String.valueOf(cls)));
            return;
        }
        try {
            if (setUserData(i + ":" + str, obj != null ? obj.toString() : null) != 0) {
                ADLog.logInfo("Native crash handler failed to set user data: (" + str + " : " + obj + ")");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (f433a && (obj instanceof C2115ck)) {
            C2115ck c2115ck = (C2115ck) obj;
            m486a(c2115ck.f806a, c2115ck.f807b, c2115ck.f808c);
        }
    }
}
