package com.appdynamics.eumagent.runtime.crashes;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.af;
import com.appdynamics.eumagent.runtime.p000private.am;
import com.appdynamics.eumagent.runtime.p000private.ck;
import com.appdynamics.eumagent.runtime.p000private.cl;
import com.appdynamics.eumagent.runtime.p000private.f;
import com.appdynamics.eumagent.runtime.p000private.n;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public class NativeCrashHandler implements am.b {
    public static boolean a = false;
    public final am b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public String g;
    public int h;
    public af i;
    public f j;
    private final n k;
    private DeviceMetricsCollector l;

    private native int setUserData(String str, String str2);

    public native int leaveBreadcrumb(String str);

    public native int setupSignalHandler(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3);

    static {
        try {
            System.loadLibrary("adeum");
            a = true;
        } catch (Throwable unused) {
            a = false;
            ADLog.logInfo("Native crash reporting is disabled");
        }
    }

    public NativeCrashHandler(Context context, String str, am amVar, int i, n nVar, DeviceMetricsCollector deviceMetricsCollector) throws PackageManager.NameNotFoundException {
        this.g = "Unknown";
        this.h = 0;
        this.c = context.getFilesDir().getAbsolutePath();
        this.d = str;
        this.b = amVar;
        String packageName = context.getPackageName();
        this.e = packageName;
        this.f = i;
        this.k = nVar;
        this.l = deviceMetricsCollector;
        if (a) {
            amVar.a.a(ck.class, this);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                this.g = packageInfo.versionName;
                this.h = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                ADLog.logAgentError("Native crash handler failed to get package info.", e);
            }
        }
    }

    public final void a(cl clVar) {
        if (a) {
            for (Map.Entry<Class, Map<String, Object>> entry : clVar.a().entrySet()) {
                for (Map.Entry<String, Object> entry2 : entry.getValue().entrySet()) {
                    a(entry2.getKey(), entry2.getValue(), entry.getKey());
                }
            }
        }
    }

    private void a(String str, Object obj, Class cls) {
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

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (a && (obj instanceof ck)) {
            ck ckVar = (ck) obj;
            a(ckVar.a, ckVar.b, ckVar.c);
        }
    }
}
