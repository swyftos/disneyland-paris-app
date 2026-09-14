package com.appdynamics.eumagent.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.media3.common.C0740C;
import com.appdynamics.eumagent.runtime.crashes.NativeCrashHandler;
import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p192private.AbstractC2131j;
import com.appdynamics.eumagent.runtime.p192private.C2050a;
import com.appdynamics.eumagent.runtime.p192private.C2053ac;
import com.appdynamics.eumagent.runtime.p192private.C2054ad;
import com.appdynamics.eumagent.runtime.p192private.C2056af;
import com.appdynamics.eumagent.runtime.p192private.C2057ag;
import com.appdynamics.eumagent.runtime.p192private.C2058ah;
import com.appdynamics.eumagent.runtime.p192private.C2060aj;
import com.appdynamics.eumagent.runtime.p192private.C2062al;
import com.appdynamics.eumagent.runtime.p192private.C2063am;
import com.appdynamics.eumagent.runtime.p192private.C2066ap;
import com.appdynamics.eumagent.runtime.p192private.C2069as;
import com.appdynamics.eumagent.runtime.p192private.C2070at;
import com.appdynamics.eumagent.runtime.p192private.C2074ax;
import com.appdynamics.eumagent.runtime.p192private.C2075ay;
import com.appdynamics.eumagent.runtime.p192private.C2076az;
import com.appdynamics.eumagent.runtime.p192private.C2077b;
import com.appdynamics.eumagent.runtime.p192private.C2078ba;
import com.appdynamics.eumagent.runtime.p192private.C2079bb;
import com.appdynamics.eumagent.runtime.p192private.C2082be;
import com.appdynamics.eumagent.runtime.p192private.C2084bg;
import com.appdynamics.eumagent.runtime.p192private.C2086bi;
import com.appdynamics.eumagent.runtime.p192private.C2087bj;
import com.appdynamics.eumagent.runtime.p192private.C2088bk;
import com.appdynamics.eumagent.runtime.p192private.C2090bm;
import com.appdynamics.eumagent.runtime.p192private.C2091bn;
import com.appdynamics.eumagent.runtime.p192private.C2093bp;
import com.appdynamics.eumagent.runtime.p192private.C2095br;
import com.appdynamics.eumagent.runtime.p192private.C2097bt;
import com.appdynamics.eumagent.runtime.p192private.C2099bv;
import com.appdynamics.eumagent.runtime.p192private.C2100bw;
import com.appdynamics.eumagent.runtime.p192private.C2101bx;
import com.appdynamics.eumagent.runtime.p192private.C2103bz;
import com.appdynamics.eumagent.runtime.p192private.C2104c;
import com.appdynamics.eumagent.runtime.p192private.C2105ca;
import com.appdynamics.eumagent.runtime.p192private.C2106cb;
import com.appdynamics.eumagent.runtime.p192private.C2107cc;
import com.appdynamics.eumagent.runtime.p192private.C2109ce;
import com.appdynamics.eumagent.runtime.p192private.C2110cf;
import com.appdynamics.eumagent.runtime.p192private.C2111cg;
import com.appdynamics.eumagent.runtime.p192private.C2112ch;
import com.appdynamics.eumagent.runtime.p192private.C2113ci;
import com.appdynamics.eumagent.runtime.p192private.C2114cj;
import com.appdynamics.eumagent.runtime.p192private.C2115ck;
import com.appdynamics.eumagent.runtime.p192private.C2116cl;
import com.appdynamics.eumagent.runtime.p192private.C2121cq;
import com.appdynamics.eumagent.runtime.p192private.C2123cs;
import com.appdynamics.eumagent.runtime.p192private.C2124ct;
import com.appdynamics.eumagent.runtime.p192private.C2125d;
import com.appdynamics.eumagent.runtime.p192private.C2126e;
import com.appdynamics.eumagent.runtime.p192private.C2127f;
import com.appdynamics.eumagent.runtime.p192private.C2130i;
import com.appdynamics.eumagent.runtime.p192private.C2132k;
import com.appdynamics.eumagent.runtime.p192private.C2133l;
import com.appdynamics.eumagent.runtime.p192private.C2135n;
import com.appdynamics.eumagent.runtime.p192private.C2136o;
import com.appdynamics.eumagent.runtime.p192private.C2137p;
import com.appdynamics.eumagent.runtime.p192private.C2138q;
import com.appdynamics.eumagent.runtime.p192private.C2139r;
import com.appdynamics.eumagent.runtime.p192private.C2141t;
import com.appdynamics.eumagent.runtime.p192private.C2144w;
import com.appdynamics.eumagent.runtime.p192private.C2145x;
import com.appdynamics.eumagent.runtime.p192private.C2146y;
import com.appdynamics.eumagent.runtime.p192private.C2147z;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Instrumentation {
    public static final int LOGGING_LEVEL_INFO = 2;
    public static final int LOGGING_LEVEL_NONE = 4;
    public static final int LOGGING_LEVEL_VERBOSE = 1;
    public static final int MAX_USER_DATA_STRING_LENGTH = 2048;
    public static final int VALID_INTERACTION_CAPTURE_MODES = 7;

    /* JADX INFO: renamed from: b */
    static C2144w f399b;

    /* JADX INFO: renamed from: c */
    static NativeCrashHandler f400c;
    public static C2135n hybridAgentInfo;

    /* JADX INFO: renamed from: o */
    private static volatile String f408o;

    /* JADX INFO: renamed from: p */
    private static int f409p;

    /* JADX INFO: renamed from: q */
    private static volatile boolean f410q;

    /* JADX INFO: renamed from: r */
    private static ScheduledThreadPoolExecutor f411r;

    /* JADX INFO: renamed from: i */
    final C2079bb f412i;

    /* JADX INFO: renamed from: j */
    final C2075ay f413j;

    /* JADX INFO: renamed from: k */
    final C2069as f414k;

    /* JADX INFO: renamed from: l */
    final C2138q f415l;

    /* JADX INFO: renamed from: s */
    private C2127f f416s;

    /* JADX INFO: renamed from: t */
    private ScheduledExecutorService f417t;

    /* JADX INFO: renamed from: u */
    private ScheduledExecutorService f418u;

    /* JADX INFO: renamed from: v */
    private C2045b f419v;

    /* JADX INFO: renamed from: w */
    private C2130i f420w;

    /* JADX INFO: renamed from: x */
    private C2056af f421x;

    /* JADX INFO: renamed from: y */
    private NetworkRequestCallback f422y;

    /* JADX INFO: renamed from: a */
    static final C2063am f398a = new C2063am();

    /* JADX INFO: renamed from: d */
    static volatile C2112ch f401d = null;

    /* JADX INFO: renamed from: e */
    static volatile C2105ca f402e = null;

    /* JADX INFO: renamed from: f */
    static volatile C2101bx f403f = null;

    /* JADX INFO: renamed from: g */
    static volatile C2106cb f404g = null;
    public static volatile boolean initializationStarted = false;
    public static volatile boolean isTraceparentHeaderEnabled = false;

    /* JADX INFO: renamed from: h */
    static volatile Instrumentation f405h = null;

    /* JADX INFO: renamed from: m */
    private static boolean f406m = false;

    /* JADX INFO: renamed from: n */
    private static int f407n = 2;

    public static void changeAppKey(String str) {
        m483a(str);
        try {
            Instrumentation instrumentation = f405h;
            if (instrumentation == null) {
                ADLog.logInfo("Ignoring Instrumentation.changeAppKey() invoked before Instrumentation.start() called.");
                return;
            }
            instrumentation.f416s.f845b = str;
            String str2 = f408o;
            f408o = str;
            f398a.m562a(new C2125d(str2, str));
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while changing AppKey", th);
            throw new RuntimeException("Failed to changeAppKey", th);
        }
    }

    public static void start(String str, Context context) {
        start(AgentConfiguration.builder().withAppKey(str).withContext(context).build());
    }

    @Deprecated
    public static void start(String str, Context context, String str2) {
        start(AgentConfiguration.builder().withAppKey(str).withContext(context).withCollectorURL(str2).build());
    }

    @Deprecated
    public static void start(String str, Context context, boolean z) {
        start(AgentConfiguration.builder().withAppKey(str).withContext(context).withLoggingEnabled(z).build());
    }

    @Deprecated
    public static void start(String str, Context context, String str2, boolean z) {
        start(AgentConfiguration.builder().withAppKey(str).withContext(context).withCollectorURL(str2).withLoggingEnabled(z).build());
    }

    public static void startFromHybrid(AgentConfiguration agentConfiguration, String str, String str2) {
        hybridAgentInfo = new C2135n(str, str2);
        start(agentConfiguration);
    }

    public static synchronized void start(AgentConfiguration agentConfiguration) {
        final Activity activity;
        try {
            ADLog.setLoggingLevel(agentConfiguration.loggingLevel);
            f407n = agentConfiguration.loggingLevel;
            String strM480a = m480a(agentConfiguration);
            String str = f408o;
            if (str != null && !str.equals(agentConfiguration.appKey)) {
                throw new IllegalStateException("Instrumentation framework was already initialized with a different key");
            }
            if (ADLog.isInfoLoggingEnabled()) {
                ADLog.logInfo("Agent version = 24.12.0, agent build = 7eb5b59c4b1d293baef883eeaeed20a927213323, appBuildID = " + strM480a + ", starting up with configuration [" + agentConfiguration + "]");
            }
            if (ADLog.isVerboseLoggingEnabled()) {
                ADLog.logVerbose(String.format("start called from activity: %s, initializationStarted = %s, instance is null = %s", agentConfiguration.context.getClass().getName(), Boolean.valueOf(initializationStarted), Boolean.valueOf(f405h == null)));
            }
            if (f405h == null && !initializationStarted) {
                initializationStarted = true;
                int i = agentConfiguration.interactionCaptureMode;
                f409p = i;
                if (i != 0) {
                    if ((i & 7) == 0) {
                        ADLog.log(2, "Current interaction capture mode %d is not supported", i);
                    } else {
                        if ((i & 1) != 0) {
                            f402e = new C2105ca(f398a);
                        }
                        if ((f409p & 2) != 0) {
                            f404g = new C2106cb(f398a, null);
                        }
                        if ((f409p & 4) != 0) {
                            f403f = new C2101bx(f398a);
                        }
                        if (f402e != null || f403f != null || f404g != null) {
                            if (C2112ch.m645a()) {
                                f401d = new C2112ch(f402e, f403f, f404g);
                            } else {
                                f401d = null;
                                ADLog.logAgentError("Fail to reflect mOnHierarchyChangeListener in ViewGroup class.");
                            }
                        }
                    }
                    WeakReference<Activity> weakReference = InstrumentationCallbacks.currentActivity;
                    if (weakReference != null && (activity = weakReference.get()) != null) {
                        activity.runOnUiThread(new Runnable() { // from class: com.appdynamics.eumagent.runtime.Instrumentation.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (Instrumentation.f401d == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                                    return;
                                }
                                Instrumentation.f401d.m647a(activity.getWindow().getDecorView());
                            }
                        });
                    }
                }
                C2139r c2139r = new C2139r(agentConfiguration.context.getFilesDir());
                C2063am c2063am = f398a;
                C2138q c2138q = new C2138q(c2139r, agentConfiguration, c2063am);
                isTraceparentHeaderEnabled = c2138q.f903b.traceparentHeaderEnabled;
                if (agentConfiguration.crashReportingEnabled) {
                    C2144w c2144w = new C2144w(agentConfiguration.context, Thread.getDefaultUncaughtExceptionHandler(), c2063am, new C2145x(), agentConfiguration.crashCallback, c2138q);
                    f399b = c2144w;
                    Thread.setDefaultUncaughtExceptionHandler(c2144w.f953g);
                } else {
                    C2144w c2144w2 = f399b;
                    if (c2144w2 != null) {
                        c2144w2.f954h = c2138q;
                    }
                    f399b = null;
                }
                if (f411r == null) {
                    f411r = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC20422("ADEum-Agent"), new ThreadPoolExecutor.DiscardPolicy());
                }
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = f411r;
                scheduledThreadPoolExecutor.execute(new RunnableC2044a(agentConfiguration, c2138q, strM480a, scheduledThreadPoolExecutor));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.Instrumentation$a */
    static class RunnableC2044a implements Runnable {

        /* JADX INFO: renamed from: a */
        private final AgentConfiguration f429a;

        /* JADX INFO: renamed from: b */
        private final C2138q f430b;

        /* JADX INFO: renamed from: c */
        private final String f431c;

        /* JADX INFO: renamed from: d */
        private final ScheduledThreadPoolExecutor f432d;

        public RunnableC2044a(AgentConfiguration agentConfiguration, C2138q c2138q, String str, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            this.f429a = agentConfiguration;
            this.f430b = c2138q;
            this.f431c = str;
            this.f432d = scheduledThreadPoolExecutor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2079bb c2079bb;
            Activity activity;
            try {
                C2056af c2056af = new C2056af(this.f429a.context);
                if (c2056af.f505a.mo534b("disable_agent_till", -1L) > System.currentTimeMillis()) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logInfo("Agent is disabled until = " + c2056af.f505a.mo534b("disable_agent_till", -1L) + ". Shutting down agent.");
                    }
                    Instrumentation.disableInstrumentation(0L);
                    return;
                }
                C2116cl c2116cl = new C2116cl();
                C2138q c2138q = this.f430b;
                Context context = this.f429a.context;
                C2063am c2063am = Instrumentation.f398a;
                DeviceMetricsCollector deviceMetricsCollector = new DeviceMetricsCollector(c2138q, context, c2063am);
                AgentConfiguration agentConfiguration = this.f429a;
                final NativeCrashHandler nativeCrashHandler = new NativeCrashHandler(agentConfiguration.context, this.f431c, c2063am, agentConfiguration.loggingLevel, Instrumentation.hybridAgentInfo, deviceMetricsCollector);
                Instrumentation.f400c = nativeCrashHandler;
                if (NativeCrashHandler.f433a) {
                    try {
                        if (nativeCrashHandler.setupSignalHandler(nativeCrashHandler.f435c, nativeCrashHandler.f436d, Build.FINGERPRINT, "24.12.0", "7eb5b59c4b1d293baef883eeaeed20a927213323", Build.VERSION.RELEASE, nativeCrashHandler.f437e, nativeCrashHandler.f439g, nativeCrashHandler.f440h, 99, nativeCrashHandler.f438f) != 0) {
                            ADLog.logInfo("Failed to setup native crash handler");
                        }
                    } catch (UnsatisfiedLinkError unused) {
                    }
                    nativeCrashHandler.f434b.m562a(new C2063am.d(new Runnable() { // from class: com.appdynamics.eumagent.runtime.crashes.NativeCrashHandler.1
                        public RunnableC20471() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            String str;
                            String str2;
                            C2147z c2147z = new C2147z();
                            String str3 = NativeCrashHandler.this.f435c;
                            C2053ac c2053ac = new C2053ac();
                            c2147z.f969a = new ArrayList();
                            c2147z.f970b = new ArrayList();
                            File file = new File(str3 + "/adeum_native_crash_reports");
                            if (!file.isDirectory()) {
                                ADLog.log(1, "Native Crash Directory (%s) is not a directory, aborting read", file);
                            } else {
                                if (ADLog.isVerboseLoggingEnabled()) {
                                    ADLog.log(1, "Contents of folder %s is = %s", file, Arrays.toString(file.list()));
                                }
                                File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.appdynamics.eumagent.runtime.private.z.1
                                    @Override // java.io.FilenameFilter
                                    public final boolean accept(File file2, String str4) {
                                        return str4.startsWith("native_crash.") && !str4.endsWith(".log");
                                    }
                                });
                                if (fileArrListFiles == null) {
                                    ADLog.log(1, "IO error while reading native crash files from crash directory (%s), aborting read", file);
                                } else {
                                    Arrays.sort(fileArrListFiles, C2124ct.f819a);
                                    File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: com.appdynamics.eumagent.runtime.private.z.2
                                        @Override // java.io.FilenameFilter
                                        public final boolean accept(File file2, String str4) {
                                            return str4.startsWith("native_crash.") && str4.endsWith(".log");
                                        }
                                    });
                                    if (fileArrListFiles2 == null) {
                                        ADLog.log(1, "IO error while reading native crash log files from crash directory (%s), aborting read", file);
                                    } else {
                                        Arrays.sort(fileArrListFiles2, C2124ct.f819a);
                                        for (File file2 : fileArrListFiles) {
                                            try {
                                                C2147z.c cVarM724a = C2147z.m724a(C2147z.m725a(file2));
                                                if (cVarM724a != null) {
                                                    c2053ac.m523a(cVarM724a.f985j);
                                                    c2147z.f969a.add(cVarM724a);
                                                }
                                            } catch (Throwable th) {
                                                try {
                                                    ADLog.log(2, "Exception while reading native crash file (%s): %s", file2.getName(), th.toString());
                                                } catch (Throwable th2) {
                                                    file2.delete();
                                                    throw th2;
                                                }
                                            }
                                            file2.delete();
                                        }
                                        for (File file3 : fileArrListFiles2) {
                                            try {
                                                c2147z.f970b.add(C2147z.m727b(file3));
                                            } catch (Throwable th3) {
                                                try {
                                                    ADLog.log(2, "Exception while reading native crash log file (%s): %s", file3.getName(), th3.toString());
                                                } catch (Throwable th4) {
                                                    file3.delete();
                                                    throw th4;
                                                }
                                            }
                                            file3.delete();
                                        }
                                        c2053ac.m524a();
                                    }
                                }
                            }
                            C2056af c2056af2 = NativeCrashHandler.this.f441i;
                            C2127f c2127f = NativeCrashHandler.this.f442j;
                            for (C2147z.c cVar : c2147z.f969a) {
                                C2146y c2146y = new C2146y(cVar);
                                if (c2056af2 != null) {
                                    c2146y.f869b = c2056af2.f506b.getAndIncrement();
                                }
                                if (NativeCrashHandler.this.f443k != null) {
                                    str = NativeCrashHandler.this.f443k.f898a;
                                    str2 = NativeCrashHandler.this.f443k.f899b;
                                } else {
                                    str = null;
                                    str2 = null;
                                }
                                if (c2127f != null) {
                                    C2126e c2126eM687a = c2127f.m687a();
                                    c2146y.f870c = new C2126e(cVar.f993r, cVar.f994s, cVar.f987l, cVar.f989n, cVar.f990o, c2126eM687a.f825a, c2126eM687a.f826b, null, c2126eM687a.f827c, c2126eM687a.f828d, c2126eM687a.f829e, cVar.f991p, null, null, cVar.f997v, str, str2, NativeCrashHandler.this.f444l);
                                }
                                NativeCrashHandler.this.f434b.m562a(c2146y);
                                c2056af2 = c2056af2;
                            }
                            for (C2147z.b bVar : c2147z.f970b) {
                                C2147z.d[] dVarArr = bVar.f975c;
                                if (dVarArr != null && dVarArr.length > 0) {
                                    ADLog.logInfo("-----------------------");
                                    ADLog.logInfo("Native Crash Log, pid: " + bVar.f973a + ", tid: " + bVar.f974b);
                                    for (C2147z.d dVar : bVar.f975c) {
                                        ADLog.logInfo(dVar.toString());
                                    }
                                    ADLog.logInfo("-----------------------");
                                }
                            }
                        }

                        public final String toString() {
                            return "ProcessCrashReportsRunnable";
                        }
                    }, 0L, -1L));
                }
                AgentConfiguration agentConfiguration2 = this.f429a;
                Context context2 = agentConfiguration2.context;
                String str = this.f431c;
                String str2 = agentConfiguration2.appKey;
                C2063am c2063am2 = Instrumentation.f398a;
                C2127f c2127f = new C2127f(context2, str, str2, c2063am2, c2116cl, Instrumentation.hybridAgentInfo, deviceMetricsCollector);
                String str3 = this.f429a.applicationName;
                if (str3 != null) {
                    if (C2124ct.m666a(str3)) {
                        throw new IllegalArgumentException("Application name cannot be the empty string");
                    }
                    if (!C2124ct.m674f(str3)) {
                        throw new IllegalArgumentException("Application name is not valid. Package naming convention could be found in http://developer.android.com/guide/topics/manifest/manifest-element.html");
                    }
                    c2127f.f846c = str3;
                }
                AgentConfiguration agentConfiguration3 = this.f429a;
                String str4 = agentConfiguration3.collectorURL;
                String str5 = agentConfiguration3.screenshotURL;
                CollectorChannelFactory collectorChannelFactory = agentConfiguration3.collectorChannelFactory;
                URL url = new URL(str4);
                C2113ci c2113ci = new C2113ci(new URL(url, "eumcollector/mobileMetrics?version=2"), new URL(url, "eumcollector/mobileAgentCount"), new URL(new URL(str5), "screenshots/v1/application/"), c2127f, collectorChannelFactory);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorM481a = Instrumentation.m481a();
                new C2099bv(c2063am2);
                C2058ah c2058ah = new C2058ah(this.f429a.context);
                C2132k c2132k = new C2132k(new C2060aj(new C2057ag(c2058ah, "beacons", new C2136o.a(), 200), c2063am2, 200), new C2060aj(new C2057ag(c2058ah, "crash_beacons", new C2054ad.a(), 4), c2063am2, 4), c2063am2, this.f430b);
                C2133l c2133l = new C2133l(c2113ci, c2056af, c2063am2, c2132k, scheduledThreadPoolExecutorM481a, this.f430b, c2127f);
                Long l = this.f430b.f902a.f914i;
                C2141t c2141t = new C2141t(l != null ? l.longValue() : C0740C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, c2063am2, Instrumentation.f399b);
                ADLog.logInfo("Starting ANRDetector with frequency:" + c2141t.f925d);
                C2063am c2063am3 = c2141t.f926e;
                Runnable runnable = c2141t.f931j;
                long j = c2141t.f925d;
                c2063am3.m562a(new C2063am.d(runnable, j, j));
                AgentConfiguration agentConfiguration4 = this.f429a;
                if (agentConfiguration4.autoInstrument) {
                    final C2079bb c2079bb2 = new C2079bb(c2063am2, agentConfiguration4.networkRequestCallback, this.f430b);
                    c2079bb2.f617a.m562a(new C2063am.d(new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.bb.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2079bb.this.m585a();
                        }

                        public final String toString() {
                            return "EndOngoingConnectionsRunnable";
                        }
                    }, 10000L, 10000L));
                    c2079bb = c2079bb2;
                } else {
                    c2079bb = null;
                }
                AgentConfiguration agentConfiguration5 = this.f429a;
                C2075ay c2075ay = agentConfiguration5.autoInstrument ? new C2075ay(c2063am2, agentConfiguration5.networkRequestCallback) : null;
                C2130i c2130i = new C2130i(c2063am2, c2132k, c2133l, c2056af, c2127f);
                C2110cf c2110cf = (this.f429a.autoInstrument || "Xamarin".equalsIgnoreCase(Instrumentation.hybridAgentInfo.f898a)) ? new C2110cf(c2063am2) : null;
                C2086bi c2086bi = new C2086bi(c2063am2, new C2084bg(c2063am2, this.f430b, c2127f), new C2091bn(scheduledThreadPoolExecutorM481a, new C2090bm(new File(this.f429a.context.getFilesDir(), "adeum-screenshots-tiles"), c2063am2, scheduledThreadPoolExecutorM481a), new C2087bj(c2113ci), this.f430b, c2127f), this.f430b, c2127f);
                if (Instrumentation.f404g != null) {
                    Instrumentation.f404g.f755c = c2086bi;
                }
                new C2093bp(c2063am2, this.f430b);
                C2069as c2069as = new C2069as(c2063am2);
                c2063am2.f539e = new C2076az(this.f429a);
                NetworkRequestCallback networkRequestCallback = this.f429a.networkRequestCallback;
                new C2109ce(c2063am2);
                Instrumentation.f405h = new Instrumentation(c2079bb, c2075ay, c2069as, c2127f, this.f432d, scheduledThreadPoolExecutorM481a, c2130i, c2056af, networkRequestCallback, this.f430b, Instrumentation.hybridAgentInfo);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f432d;
                if (scheduledThreadPoolExecutor == null) {
                    throw new IllegalArgumentException("Cannot start EventBus, executor is null");
                }
                c2063am2.f538d = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.execute(c2063am2.f536b);
                c2063am2.f540f = false;
                NativeCrashHandler nativeCrashHandler2 = Instrumentation.f400c;
                nativeCrashHandler2.f442j = c2127f;
                nativeCrashHandler2.f441i = c2056af;
                nativeCrashHandler2.m492a(c2116cl);
                C2144w c2144w = Instrumentation.f399b;
                if (c2144w != null) {
                    c2144w.f952f = c2127f;
                    c2144w.f951e = c2056af;
                    if (this.f430b.f903b.crashReportingEnabled) {
                        c2144w.m718a();
                    }
                }
                c2063am2.m562a(new C2104c());
                if (c2110cf == null) {
                    c2063am2.m562a(new C2111cg("Application", "App Start"));
                }
                WeakReference<Activity> weakReference = InstrumentationCallbacks.currentActivity;
                if (weakReference == null || (activity = weakReference.get()) == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getRootView() == null) {
                    return;
                }
                c2063am2.m562a(new C2082be(C2103bz.m622a(activity)));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while initializing AppDynamics agent", th);
                Instrumentation.disableInstrumentation(0L);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m480a(AgentConfiguration agentConfiguration) {
        m483a(agentConfiguration.appKey);
        try {
            if (!"https".equalsIgnoreCase(new URL(agentConfiguration.collectorURL).getProtocol())) {
                ADLog.logWarning("Collector URL insecure. HTTPS is recommended.");
            }
            if (agentConfiguration.context == null) {
                throw new IllegalArgumentException("Context cannot be null!");
            }
            if (!agentConfiguration.autoInstrument) {
                ADLog.logInfo("INFO: Automatic instrumentation has been disabled,");
            }
            try {
                String str = BuildInfo.applicationBuildId;
                if (str != null) {
                    return str;
                }
                throw new NullPointerException("buildId == null");
            } catch (Throwable th) {
                if (!agentConfiguration.autoInstrument) {
                    ADLog.logInfo("Auto Instrumentation disabled, ignoring lack of build id");
                    return null;
                }
                if (!agentConfiguration.compileTimeInstrumentationCheck) {
                    ADLog.logInfo("WARNING: Compile time instrumentation check is disabled.");
                    return null;
                }
                ADLog.logAppError("App not instrumented!", th);
                throw new IllegalStateException("Unable to start AppDynamics' android agent. Your application doesn't seem to be instrumented by AppDynamics's compile time instrumentation. Please ensure that you have configured your build system (ant/gradle/maven) to run AppDynamics' instrumentation. For more information please consult the documentation. Internal Exception: ".concat(String.valueOf(th)));
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("[" + agentConfiguration.collectorURL + "] is not a valid collector url.", e);
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.Instrumentation$2 */
    final class ThreadFactoryC20422 implements ThreadFactory {

        /* JADX INFO: renamed from: a */
        private /* synthetic */ String f424a;

        ThreadFactoryC20422(String str) {
            this.f424a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(this.f424a);
            return thread;
        }
    }

    Instrumentation(C2079bb c2079bb, C2075ay c2075ay, C2069as c2069as, C2127f c2127f, ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2, C2130i c2130i, C2056af c2056af, NetworkRequestCallback networkRequestCallback, C2138q c2138q, C2135n c2135n) {
        this.f412i = c2079bb;
        this.f413j = c2075ay;
        this.f414k = c2069as;
        this.f416s = c2127f;
        this.f417t = scheduledExecutorService;
        this.f418u = scheduledExecutorService2;
        this.f420w = c2130i;
        this.f421x = c2056af;
        this.f422y = networkRequestCallback;
        this.f415l = c2138q;
        hybridAgentInfo = c2135n;
        C2045b c2045b = new C2045b();
        this.f419v = c2045b;
        f398a.f535a.m656a(C2121cq.class, c2045b);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.Instrumentation$b */
    class C2045b implements C2063am.b {
        C2045b() {
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
        /* JADX INFO: renamed from: a */
        public final void mo484a(Object obj) {
            if (obj instanceof C2121cq) {
                Instrumentation.m482a(((C2121cq) obj).f815a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m483a(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("AppKey cannot be null or empty");
        }
        if (Pattern.matches("[a-zA-Z0-9]{1,}(-[A-Z]{3}){2,}", str)) {
            return;
        }
        throw new IllegalArgumentException("AppKey is malformed: " + str + ", it should look like: AD-AAA-BBB");
    }

    public static void reportMetric(String str, long j) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "reportMetric(name='%s', value=%d) called", str, Long.valueOf(j));
        if (initializationStarted) {
            try {
                f398a.m562a(new C2070at(C2124ct.m668b(str), j, new C2123cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting metric", th);
            }
        }
    }

    public static String getAgentIdentifier(Context context) {
        return new C2056af(context).m530a();
    }

    @Deprecated
    public static void reportError(Throwable th) {
        if (f406m) {
            return;
        }
        reportError(th, 1);
    }

    public static void reportError(Throwable th, int i) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "reportError(throwable='%s', severityLevel='%d') called", th, Integer.valueOf(i));
        if (initializationStarted) {
            try {
                f398a.m562a(new C2062al(th, i, null));
            } catch (Throwable th2) {
                ADLog.logAgentError("Exception while reporting error", th2);
            }
        }
    }

    public static void startTimer(String str) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "startTimer(name='%s') called", str);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2100bw(C2124ct.m668b(str), false, new C2123cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting timer", th);
            }
        }
    }

    public static void stopTimer(String str) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "stopTimer(name='%s') called", str);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2100bw(C2124ct.m668b(str), true, new C2123cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while stopping timer", th);
            }
        }
    }

    public static SessionFrame startSessionFrame(String str) {
        ADLog.log(1, "startSessionFrame(sessionFrameName='%s') called", str);
        if (initializationStarted) {
            try {
                return new C2097bt(f398a, C2124ct.m671c(str));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting Session Frame.", th);
            }
        }
        return C2097bt.f720a;
    }

    public static void startNextSession() {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("startNextSession() called");
        if (initializationStarted) {
            try {
                f398a.m562a(new C2095br());
                return;
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting next Session.", th);
                return;
            }
        }
        ADLog.logAgentError("startNexSession() is invoked before initialization.");
    }

    public static CallTracker beginCall(String str, String str2, Object... objArr) {
        return beginCall(false, str, str2, objArr);
    }

    public static CallTracker beginCall(boolean z, String str, String str2, Object... objArr) {
        ADLog.log(1, "beginCall(static='%s', className='%s', methodName='%s', args) called", z ? BooleanUtils.YES : BooleanUtils.f3980NO, str, str2);
        if (initializationStarted) {
            try {
                return new C2066ap(f398a, C2124ct.m671c(str), C2124ct.m671c(str2), z).withArguments(objArr);
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting to track info point", th);
            }
        }
        return C2066ap.f555a;
    }

    public static void endCall(CallTracker callTracker, Object obj) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "endCall(tracker=%s, returnValue=%s) called", callTracker, obj);
        if (callTracker != null) {
            try {
                if (obj != null) {
                    callTracker.reportCallEndedWithReturnValue(obj);
                } else {
                    callTracker.reportCallEnded();
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting info point", th);
            }
        }
    }

    public static void endCall(CallTracker callTracker) {
        if (f406m) {
            return;
        }
        endCall(callTracker, null);
    }

    public static HttpRequestTracker beginHttpRequest(URL url) {
        ADLog.log(1, "beginHttpRequest(url='%s') called", url);
        if (initializationStarted) {
            try {
                if (url == null) {
                    return new C2074ax();
                }
                return new C2078ba(f398a, url, f405h != null ? f405h.f422y : null);
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting to track HTTP request", th);
            }
        }
        return new C2074ax();
    }

    public static void leaveBreadcrumb(String str) {
        if (f406m) {
            return;
        }
        leaveBreadcrumb(str, 0);
    }

    public static void leaveBreadcrumb(String str, int i) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "leaveBreadcrumb(breadcrumb='%s', mode=%d) called", str, Integer.valueOf(i));
        if (!initializationStarted || str == null) {
            return;
        }
        try {
            if (str.isEmpty()) {
                return;
            }
            C2137p c2137p = new C2137p(str);
            C2144w c2144w = f399b;
            if (c2144w != null) {
                c2144w.f948b.m651a(c2137p);
            }
            NativeCrashHandler nativeCrashHandler = f400c;
            if (nativeCrashHandler != null && NativeCrashHandler.f433a) {
                C2147z.a aVar = new C2147z.a();
                aVar.f971a = c2137p.f874g.f818b;
                aVar.f972b = c2137p.f901i;
                String string = aVar.toString();
                try {
                    if (nativeCrashHandler.leaveBreadcrumb(string) != 0) {
                        ADLog.logInfo("Native crash handler failed to leave breadcrumb: ".concat(String.valueOf(string)));
                    }
                } catch (UnsatisfiedLinkError unused) {
                }
            }
            if (i != 0 && i != 1) {
                i = 0;
            }
            if (i == 1) {
                f398a.m562a(c2137p);
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while reporting breadcrumb", th);
        }
    }

    public static void unblockScreenshots() {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("unblockScreenshots() called");
        f410q = false;
    }

    public static void blockScreenshots() {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("blockScreenshots() called");
        f410q = true;
    }

    public static boolean screenshotsBlocked() {
        ADLog.logVerbose("screenshotsBlocked() called, current value: " + f410q);
        return f410q;
    }

    public static void takeScreenshot() {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("takeScreenshot() called");
        if (initializationStarted) {
            try {
                f398a.m562a(new C2088bk());
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while taking screenshot", th);
            }
        }
    }

    public static int createCrashReport(String str, String str2) {
        try {
            if (f399b == null) {
                ADLog.logAgentError("Didn't create crash report because crash report manager is null");
                return -1;
            }
            if ("Flutter".equals(hybridAgentInfo.f898a)) {
                C2144w c2144w = f399b;
                AbstractC2131j abstractC2131jM716a = c2144w.m716a(new C2050a(str, str2, new C2123cs(), c2144w.f948b));
                try {
                    StringWriter stringWriter = new StringWriter();
                    abstractC2131jM716a.mo693a(stringWriter);
                    c2144w.m719a(Collections.singletonList(stringWriter.toString()));
                } catch (Throwable th) {
                    ADLog.logAgentError("Error trying to convert crash report event to JSON", th);
                }
                return 0;
            }
            C2144w c2144w2 = f399b;
            C2123cs c2123cs = new C2123cs();
            ADLog.log(2, "Writing external crash report to disk for :%s", str2);
            c2144w2.m720b(new C2050a(str, str2, c2123cs, c2144w2.f948b));
            return 0;
        } catch (IOException e) {
            ADLog.logAgentError("Exception while reporting external crash", e);
            return -1;
        }
    }

    public static int createRawCrashReport(String str) {
        try {
            if (f399b == null) {
                ADLog.logAgentError("Didn't create crash report because crash report manager is null");
                return -1;
            }
            C2135n c2135n = hybridAgentInfo;
            if (c2135n != null && "Flutter".equals(c2135n.f898a)) {
                C2144w c2144w = f399b;
                AbstractC2131j abstractC2131jM716a = c2144w.m716a(new C2077b(str));
                try {
                    StringWriter stringWriter = new StringWriter();
                    abstractC2131jM716a.mo693a(stringWriter);
                    c2144w.m719a(Collections.singletonList(stringWriter.toString()));
                } catch (Throwable th) {
                    ADLog.logAgentError("Error trying to convert crash report event to JSON", th);
                }
                return 0;
            }
            C2144w c2144w2 = f399b;
            new C2123cs();
            ADLog.log(2, "Writing raw crash report to disk", "raw hybrid crash");
            c2144w2.m720b(new C2077b(str));
            return 0;
        } catch (IOException e) {
            ADLog.logAgentError("Exception while reporting external crash", e);
            return -1;
        }
    }

    public static void reportRawError(String str, int i) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "reportErrorForHybridStacktraces(severityLevel='%d') called", i);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2062al(null, i, str));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting error", th);
            }
        }
    }

    public static void setUserData(String str, String str2) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "setUserData(key='%s', value='%s') called", str, str2);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2115ck(C2124ct.m672d(str), C2124ct.m673e(str2), String.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataLong(String str, Long l) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "setUserDataLong(key='%s', value='%s') called", str, l);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2115ck(C2124ct.m672d(str), l, Long.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataBoolean(String str, Boolean bool) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "setUserDataBoolean(key='%s', value='%s') called", str, bool);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2115ck(C2124ct.m672d(str), bool, Boolean.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataDouble(String str, Double d) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "setUserDataDouble(key='%s', value='%s') called", str, d);
        if (initializationStarted) {
            try {
                String strM672d = C2124ct.m672d(str);
                if (d != null) {
                    if (d.isNaN()) {
                        ADLog.log(1, "Illegal value NaN for user data key '%s', clearing user data for key", strM672d);
                    } else if (d.isInfinite()) {
                        ADLog.log(1, "Illegal infinite value for user data key '%s', clearing user data for key", strM672d);
                    }
                    d = null;
                }
                f398a.m562a(new C2115ck(strM672d, d, Double.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataDate(String str, Date date) {
        if (f406m) {
            return;
        }
        ADLog.log(1, "setUserDataDate(key='%s') called", str, date);
        if (initializationStarted) {
            try {
                f398a.m562a(new C2115ck(C2124ct.m672d(str), date != null ? Long.valueOf(date.getTime()) : null, Date.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void clearAllUserData() {
        if (f406m || !initializationStarted) {
            return;
        }
        try {
            try {
                f398a.m562a(new C2114cj(String.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while clearing all string user data", th);
            }
            try {
                f398a.m562a(new C2114cj(Boolean.class));
            } catch (Throwable th2) {
                ADLog.logAgentError("Exception while clearing all boolean user data", th2);
            }
            try {
                f398a.m562a(new C2114cj(Date.class));
            } catch (Throwable th3) {
                ADLog.logAgentError("Exception while clearing all date user data", th3);
            }
            try {
                f398a.m562a(new C2114cj(Double.class));
            } catch (Throwable th4) {
                ADLog.logAgentError("Exception while clearing all double user data", th4);
            }
            try {
                f398a.m562a(new C2114cj(Long.class));
            } catch (Throwable th5) {
                ADLog.logAgentError("Exception while clearing all long user data", th5);
            }
        } catch (Throwable th6) {
            ADLog.logAgentError("Exception while clearing all user data", th6);
        }
    }

    public static void trackPageStart(String str, UUID uuid, long j) {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("TrackPageStart() called");
        if (initializationStarted) {
            try {
                f398a.m562a(new C2107cc(str, "Fragment Start", uuid, new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), null));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while tracking Page Start", th);
            }
        }
    }

    public static void trackPageEnd(String str, UUID uuid, long j, long j2) {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("TrackPageEnd() called");
        if (initializationStarted) {
            try {
                f398a.m562a(new C2107cc(str, "Fragment End", uuid, new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j2), j2)));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while tracking Page End", th);
            }
        }
    }

    public static void trackUIEvent(String str, String str2, String str3, long j, String str4, String str5, int i, String str6, String str7) {
        if (f406m) {
            return;
        }
        ADLog.logVerbose("trackUIEvent() called");
        if (initializationStarted) {
            try {
                f398a.m562a(new C2111cg(str, str2, new C2123cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), null, str4, str5, str7, str3, str6, i));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception on trackUIEvent()", th);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m482a(long j) {
        if (ADLog.isInfoLoggingEnabled()) {
            ADLog.logInfo("Agent disabled by collector until ".concat(String.valueOf(j)));
        }
        disableInstrumentation(j);
    }

    public static void shutdownAgent() {
        f406m = true;
        f398a.f540f = true;
        ADLog.setLoggingLevel(4);
        C2130i c2130i = f405h.f420w;
        c2130i.f861b = false;
        C2132k c2132k = c2130i.f860a;
        ArrayList arrayList = new ArrayList();
        c2132k.f878a.m546a(arrayList);
        c2132k.f879b.m546a(arrayList);
        blockScreenshots();
    }

    public static void restartAgent() {
        f406m = false;
        f398a.f540f = false;
        ADLog.setLoggingLevel(f407n);
        f405h.f420w.f861b = true;
        unblockScreenshots();
    }

    public static void disableInstrumentation(long j) {
        initializationStarted = false;
        C2063am c2063am = f398a;
        c2063am.f540f = true;
        c2063am.f538d = null;
        c2063am.f537c.clear();
        c2063am.f535a.m655a();
        C2063am.b bVar = c2063am.f541g;
        if (bVar == null) {
            ADLog.logInfo("Ignoring attempt to register null event listener");
        } else {
            c2063am.f535a.m656a(C2063am.d.class, bVar);
        }
        Instrumentation instrumentation = f405h;
        if (instrumentation != null) {
            if (j > 0) {
                instrumentation.f421x.f505a.mo532a("disable_agent_till", j);
            }
            if (!instrumentation.f417t.isShutdown()) {
                ADLog.logInfo("Shutting down executor pool.");
                instrumentation.f417t.shutdown();
            }
            if (!instrumentation.f418u.isShutdown()) {
                ADLog.logInfo("Shutting down IO executor pool");
                instrumentation.f418u.shutdown();
            }
            f405h = null;
        }
        final C2112ch c2112ch = f401d;
        final C2105ca c2105ca = f402e;
        final C2101bx c2101bx = f403f;
        final C2106cb c2106cb = f404g;
        f401d = null;
        f402e = null;
        f403f = null;
        f404g = null;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdynamics.eumagent.runtime.Instrumentation.3
            @Override // java.lang.Runnable
            public final void run() {
                C2112ch c2112ch2 = c2112ch;
                if (c2112ch2 != null) {
                    for (Map.Entry<View, ViewGroup.OnHierarchyChangeListener> entry : c2112ch2.f791a.entrySet()) {
                        ((ViewGroup) entry.getKey()).setOnHierarchyChangeListener(entry.getValue());
                    }
                    c2112ch2.f791a.clear();
                }
                C2105ca c2105ca2 = c2105ca;
                if (c2105ca2 != null) {
                    for (Map.Entry<View, LinkedHashSet<View.OnClickListener>> entry2 : c2105ca2.f747a.entrySet()) {
                        Iterator<View.OnClickListener> it = entry2.getValue().iterator();
                        while (it.hasNext()) {
                            entry2.getKey().setOnClickListener(it.next());
                        }
                    }
                    c2105ca2.f747a.clear();
                }
                C2101bx c2101bx2 = c2101bx;
                if (c2101bx2 != null) {
                    for (Map.Entry<AdapterView, AdapterView.OnItemClickListener> entry3 : c2101bx2.f734a.entrySet()) {
                        entry3.getKey().setOnItemClickListener(entry3.getValue());
                    }
                    c2101bx2.f734a.clear();
                }
                C2106cb c2106cb2 = c2106cb;
                if (c2106cb2 != null) {
                    for (Map.Entry<View, ArrayList<View.OnFocusChangeListener>> entry4 : c2106cb2.f753a.entrySet()) {
                        Iterator<View.OnFocusChangeListener> it2 = entry4.getValue().iterator();
                        while (it2.hasNext()) {
                            entry4.getKey().setOnFocusChangeListener(it2.next());
                        }
                    }
                    c2106cb2.f753a.clear();
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ ScheduledThreadPoolExecutor m481a() {
        return new ScheduledThreadPoolExecutor(1, new ThreadFactoryC20422("ADEum-Agent-IO"), new ThreadPoolExecutor.DiscardPolicy());
    }
}
