package com.appdynamics.eumagent.runtime.p000private;

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
import com.appdynamics.eumagent.runtime.p000private.am;
import com.contentsquare.android.core.system.DeviceInfo;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class f implements am.b {
    private static final String d = "f";
    public final Context a;
    public volatile String b;
    public String c;
    private final am e;
    private final b f = new b(this, 0);
    private final String g;
    private final String h;
    private boolean i;
    private e j;
    private cl k;

    public f(Context context, String str, String str2, am amVar, cl clVar, n nVar, DeviceMetricsCollector deviceMetricsCollector) {
        cl clVar2;
        String str3;
        String str4;
        this.j = null;
        this.a = context;
        this.e = amVar;
        this.h = str;
        String strA = a(context);
        this.g = strA;
        if (nVar != null) {
            String str5 = nVar.a;
            str4 = nVar.b;
            str3 = str5;
            clVar2 = clVar;
        } else {
            clVar2 = clVar;
            str3 = null;
            str4 = null;
        }
        this.k = clVar2;
        int iB = b(context);
        String str6 = Build.MANUFACTURER;
        String str7 = Build.MODEL;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        this.j = new e(strA, iB, str, "24.12.0", "7eb5b59c4b1d293baef883eeaeed20a927213323", str6, str7, Long.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1048576), e(), f(), Integer.valueOf(g()), Build.VERSION.RELEASE, "unknown", "unknown", clVar.a(), str3, str4, deviceMetricsCollector);
        this.i = false;
        this.b = str2;
        this.c = context.getPackageName();
        amVar.a.a(ck.class, this);
        amVar.a.a(cj.class, this);
        amVar.a.a(cg.class, this);
    }

    class b extends BroadcastReceiver {
        boolean a;

        private b() {
            this.a = false;
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                f.this.e.a(new am.d(new a(this, (byte) 0), 0L, -1L));
            } catch (Throwable th) {
                ADLog.logAgentError("Error running runnable on event thread", th);
            }
        }

        class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            @Override // java.lang.Runnable
            public final void run() {
                f.this.d();
            }

            public final String toString() {
                return "UpdateNetworkInformationRunnable";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String strA = a(c());
        String strC = c(this.a);
        String str = this.j.g;
        boolean zEquals = strA.equals(str);
        if (!zEquals) {
            this.e.a(new g(strA, str));
        }
        if (zEquals && strC.equals(this.j.f)) {
            return;
        }
        e eVar = this.j;
        this.j = eVar.a(strC, strA, eVar.i);
        ADLog.log(1, "Connection has changed: {%s : %s}", strA, strC);
    }

    public final e a() {
        if (!this.f.a) {
            try {
                d();
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to update network info", th);
            }
        }
        return this.j;
    }

    public final boolean b() {
        if (this.a != null) {
            String strA = a(c());
            if (!"wifi".equals(strA) && !"wimax".equals(strA) && !"bluetooth".equals(strA) && !"ethernet".equals(strA) && !"unknown".equals(strA)) {
                return true;
            }
        }
        return false;
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            Log.e(d, "Error retrieving application version", th);
            return -1;
        }
    }

    private static String e() {
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
                    randomAccessFile.close();
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

    private static String f() {
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

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    private int g() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static String c(Context context) {
        String simOperatorName;
        try {
            simOperatorName = ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getSimOperatorName();
        } catch (Throwable th) {
            ADLog.logAgentError("Error determining carrier name", th);
            simOperatorName = "unknown";
        }
        return (simOperatorName == null || simOperatorName.isEmpty()) ? "unknown" : simOperatorName;
    }

    private static String a(int i) {
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

    public final NetworkInfo c() {
        if (this.i) {
            return null;
        }
        try {
            return ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            this.i = true;
            ADLog.logAppError("Access to ConnectivityManager is denied", e);
            return null;
        } catch (Throwable th) {
            ADLog.logAgentError("Error determining connection type", th);
            return null;
        }
    }

    public final String a(NetworkInfo networkInfo) {
        if (this.i) {
            return "unavailable";
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "offline";
        }
        int type = networkInfo.getType();
        if (type == 0) {
            String strA = a(networkInfo.getSubtype());
            return strA != null ? strA : "mobile";
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

    public final void a(CollectorChannel collectorChannel) {
        collectorChannel.addRequestProperty("ky", this.b);
        collectorChannel.addRequestProperty(DeviceInfo.BATCH_APP_NAME, this.c);
        collectorChannel.addRequestProperty("osn", "Android");
        collectorChannel.addRequestProperty("bid", this.h);
        collectorChannel.addRequestProperty("cap", "s:1,f:1");
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof ck) {
            ck ckVar = (ck) obj;
            cl clVar = this.k;
            synchronized (clVar.a) {
                try {
                    cm cmVar = clVar.a.get(ckVar.c);
                    String str = ckVar.a;
                    Object obj2 = ckVar.b;
                    if (obj2 != null) {
                        cmVar.a.put(str, obj2);
                    } else {
                        cmVar.a.remove(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            e eVar = this.j;
            this.j = eVar.a(eVar.f, eVar.g, this.k.a());
            return;
        }
        if (obj instanceof cj) {
            cl clVar2 = this.k;
            Class cls = ((cj) obj).a;
            synchronized (clVar2.a) {
                clVar2.a.get(cls).a.clear();
            }
            e eVar2 = this.j;
            this.j = eVar2.a(eVar2.f, eVar2.g, this.k.a());
            return;
        }
        if (obj instanceof cg) {
            cg cgVar = (cg) obj;
            if ("App Start".equals(cgVar.i)) {
                b bVar = this.f;
                try {
                    f.this.a.registerReceiver(bVar, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                    bVar.a = true;
                    return;
                } catch (Throwable th2) {
                    ADLog.logAgentError("Error registering ConnectionListener", th2);
                    return;
                }
            }
            if ("App Stop".equals(cgVar.i)) {
                b bVar2 = this.f;
                f.this.a.unregisterReceiver(bVar2);
                bVar2.a = false;
            }
        }
    }
}
