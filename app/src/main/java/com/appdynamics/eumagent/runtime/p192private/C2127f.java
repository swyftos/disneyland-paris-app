package com.appdynamics.eumagent.runtime.p192private;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.contentsquare.android.core.system.DeviceInfo;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.f */
/* JADX INFO: loaded from: classes2.dex */
public class C2127f implements C2063am.b {

    /* JADX INFO: renamed from: d */
    private static final String f843d = "f";

    /* JADX INFO: renamed from: a */
    public final Context f844a;

    /* JADX INFO: renamed from: b */
    public volatile String f845b;

    /* JADX INFO: renamed from: c */
    public String f846c;

    /* JADX INFO: renamed from: e */
    private final C2063am f847e;

    /* JADX INFO: renamed from: f */
    private final b f848f = new b(this, 0);

    /* JADX INFO: renamed from: g */
    private final String f849g;

    /* JADX INFO: renamed from: h */
    private final String f850h;

    /* JADX INFO: renamed from: i */
    private boolean f851i;

    /* JADX INFO: renamed from: j */
    private C2126e f852j;

    /* JADX INFO: renamed from: k */
    private C2116cl f853k;

    public C2127f(Context context, String str, String str2, C2063am c2063am, C2116cl c2116cl, C2135n c2135n, DeviceMetricsCollector deviceMetricsCollector) {
        String str3;
        String str4;
        this.f852j = null;
        this.f844a = context;
        this.f847e = c2063am;
        this.f850h = str;
        String strM679a = m679a(context);
        this.f849g = strM679a;
        if (c2135n != null) {
            String str5 = c2135n.f898a;
            str4 = c2135n.f899b;
            str3 = str5;
        } else {
            str3 = null;
            str4 = null;
        }
        this.f853k = c2116cl;
        int iM680b = m680b(context);
        String str6 = Build.MANUFACTURER;
        String str7 = Build.MODEL;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        this.f852j = new C2126e(strM679a, iM680b, str, "24.12.0", "7eb5b59c4b1d293baef883eeaeed20a927213323", str6, str7, Long.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576), m684e(), m685f(), Integer.valueOf(m686g()), Build.VERSION.RELEASE, "unknown", "unknown", c2116cl.m650a(), str3, str4, deviceMetricsCollector);
        this.f851i = false;
        this.f845b = str2;
        this.f846c = context.getPackageName();
        c2063am.f535a.m656a(C2115ck.class, this);
        c2063am.f535a.m656a(C2114cj.class, this);
        c2063am.f535a.m656a(C2111cg.class, this);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.f$b */
    class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        boolean f854a;

        private b() {
            this.f854a = false;
        }

        /* synthetic */ b(C2127f c2127f, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                C2127f.this.f847e.m562a(new C2063am.d(new a(this, (byte) 0), 0L, -1L));
            } catch (Throwable th) {
                ADLog.logAgentError("Error running runnable on event thread", th);
            }
        }

        /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.f$b$a */
        class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            @Override // java.lang.Runnable
            public final void run() {
                C2127f.this.m683d();
            }

            public final String toString() {
                return "UpdateNetworkInformationRunnable";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m683d() {
        String strM688a = m688a(m691c());
        String strM682c = m682c(this.f844a);
        String str = this.f852j.f831g;
        boolean zEquals = strM688a.equals(str);
        if (!zEquals) {
            this.f847e.m562a(new C2128g(strM688a, str));
        }
        if (zEquals && strM682c.equals(this.f852j.f830f)) {
            return;
        }
        C2126e c2126e = this.f852j;
        this.f852j = c2126e.m675a(strM682c, strM688a, c2126e.f833i);
        ADLog.log(1, "Connection has changed: {%s : %s}", strM688a, strM682c);
    }

    /* JADX INFO: renamed from: a */
    public final C2126e m687a() {
        if (!this.f848f.f854a) {
            try {
                m683d();
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to update network info", th);
            }
        }
        return this.f852j;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m690b() {
        if (this.f844a != null) {
            String strM688a = m688a(m691c());
            if (!"wifi".equals(strM688a) && !"wimax".equals(strM688a) && !"bluetooth".equals(strM688a) && !"ethernet".equals(strM688a) && !"unknown".equals(strM688a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static String m679a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m680b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            Log.e(f843d, "Error retrieving application version", th);
            return -1;
        }
    }

    /* JADX INFO: renamed from: e */
    private static String m684e() {
        RandomAccessFile randomAccessFile;
        String string = "Unknown";
        try {
            randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            try {
                String line = randomAccessFile.readLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char cCharAt = line.charAt(i);
                    Character chValueOf = Character.valueOf(cCharAt);
                    if (Character.isDigit(cCharAt)) {
                        sb.append(chValueOf);
                    }
                }
                string = Long.toString(Long.parseLong(sb.toString()) / 1024);
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                }
                return string;
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable unused3) {
        }
        return string;
    }

    /* JADX INFO: renamed from: f */
    private static String m685f() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            try {
                String line = randomAccessFile.readLine();
                try {
                    randomAccessFile.close();
                    return line;
                } catch (Throwable unused) {
                    return line;
                }
            } catch (Throwable unused2) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused3) {
                    }
                }
                return "Unknown";
            }
        } catch (Throwable unused4) {
            randomAccessFile = null;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.f$a */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    /* JADX INFO: renamed from: g */
    private int m686g() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m682c(Context context) {
        String simOperatorName;
        try {
            simOperatorName = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getSimOperatorName();
        } catch (Throwable th) {
            ADLog.logAgentError("Error determining carrier name", th);
            simOperatorName = "unknown";
        }
        return (simOperatorName == null || simOperatorName.isEmpty()) ? "unknown" : simOperatorName;
    }

    /* JADX INFO: renamed from: a */
    private static String m678a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3g";
            case 13:
            case 19:
                return "4g";
            case 18:
                return "iwlan";
            case 20:
                return "5g";
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public final NetworkInfo m691c() {
        if (this.f851i) {
            return null;
        }
        try {
            return ((ConnectivityManager) this.f844a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            this.f851i = true;
            ADLog.logAppError("Access to ConnectivityManager is denied", e);
            return null;
        } catch (Throwable th) {
            ADLog.logAgentError("Error determining connection type", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m688a(NetworkInfo networkInfo) {
        if (this.f851i) {
            return "unavailable";
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "offline";
        }
        int type = networkInfo.getType();
        if (type == 0) {
            String strM678a = m678a(networkInfo.getSubtype());
            return strM678a != null ? strM678a : "mobile";
        }
        if (type == 1) {
            return "wifi";
        }
        if (type == 6) {
            return "wimax";
        }
        if (type == 7) {
            return "bluetooth";
        }
        if (type == 9) {
            return "ethernet";
        }
        return "unknown";
    }

    /* JADX INFO: renamed from: a */
    public final void m689a(CollectorChannel collectorChannel) {
        collectorChannel.addRequestProperty("ky", this.f845b);
        collectorChannel.addRequestProperty(DeviceInfo.BATCH_APP_NAME, this.f846c);
        collectorChannel.addRequestProperty("osn", "Android");
        collectorChannel.addRequestProperty("bid", this.f850h);
        collectorChannel.addRequestProperty("cap", "s:1,f:1");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2115ck) {
            C2115ck c2115ck = (C2115ck) obj;
            C2116cl c2116cl = this.f853k;
            synchronized (c2116cl.f809a) {
                try {
                    C2117cm c2117cm = c2116cl.f809a.get(c2115ck.f808c);
                    String str = c2115ck.f806a;
                    Object obj2 = c2115ck.f807b;
                    if (obj2 != null) {
                        c2117cm.f810a.put(str, (T) obj2);
                    } else {
                        c2117cm.f810a.remove(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            C2126e c2126e = this.f852j;
            this.f852j = c2126e.m675a(c2126e.f830f, c2126e.f831g, this.f853k.m650a());
            return;
        }
        if (obj instanceof C2114cj) {
            C2116cl c2116cl2 = this.f853k;
            Class cls = ((C2114cj) obj).f805a;
            synchronized (c2116cl2.f809a) {
                c2116cl2.f809a.get(cls).f810a.clear();
            }
            C2126e c2126e2 = this.f852j;
            this.f852j = c2126e2.m675a(c2126e2.f830f, c2126e2.f831g, this.f853k.m650a());
            return;
        }
        if (obj instanceof C2111cg) {
            C2111cg c2111cg = (C2111cg) obj;
            if ("App Start".equals(c2111cg.f782i)) {
                b bVar = this.f848f;
                try {
                    C2127f.this.f844a.registerReceiver(bVar, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                    bVar.f854a = true;
                    return;
                } catch (Throwable th2) {
                    ADLog.logAgentError("Error registering ConnectionListener", th2);
                    return;
                }
            }
            if ("App Stop".equals(c2111cg.f782i)) {
                b bVar2 = this.f848f;
                C2127f.this.f844a.unregisterReceiver(bVar2);
                bVar2.f854a = false;
            }
        }
    }
}
