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
import androidx.media3.common.C;
import com.appdynamics.eumagent.runtime.crashes.NativeCrashHandler;
import com.appdynamics.eumagent.runtime.devicemetrics.DeviceMetricsCollector;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.ac;
import com.appdynamics.eumagent.runtime.p000private.ad;
import com.appdynamics.eumagent.runtime.p000private.af;
import com.appdynamics.eumagent.runtime.p000private.ag;
import com.appdynamics.eumagent.runtime.p000private.ah;
import com.appdynamics.eumagent.runtime.p000private.aj;
import com.appdynamics.eumagent.runtime.p000private.al;
import com.appdynamics.eumagent.runtime.p000private.am;
import com.appdynamics.eumagent.runtime.p000private.ap;
import com.appdynamics.eumagent.runtime.p000private.as;
import com.appdynamics.eumagent.runtime.p000private.at;
import com.appdynamics.eumagent.runtime.p000private.ax;
import com.appdynamics.eumagent.runtime.p000private.ay;
import com.appdynamics.eumagent.runtime.p000private.az;
import com.appdynamics.eumagent.runtime.p000private.ba;
import com.appdynamics.eumagent.runtime.p000private.bb;
import com.appdynamics.eumagent.runtime.p000private.be;
import com.appdynamics.eumagent.runtime.p000private.bg;
import com.appdynamics.eumagent.runtime.p000private.bi;
import com.appdynamics.eumagent.runtime.p000private.bj;
import com.appdynamics.eumagent.runtime.p000private.bk;
import com.appdynamics.eumagent.runtime.p000private.bm;
import com.appdynamics.eumagent.runtime.p000private.bn;
import com.appdynamics.eumagent.runtime.p000private.bp;
import com.appdynamics.eumagent.runtime.p000private.br;
import com.appdynamics.eumagent.runtime.p000private.bt;
import com.appdynamics.eumagent.runtime.p000private.bv;
import com.appdynamics.eumagent.runtime.p000private.bw;
import com.appdynamics.eumagent.runtime.p000private.bx;
import com.appdynamics.eumagent.runtime.p000private.bz;
import com.appdynamics.eumagent.runtime.p000private.c;
import com.appdynamics.eumagent.runtime.p000private.ca;
import com.appdynamics.eumagent.runtime.p000private.cb;
import com.appdynamics.eumagent.runtime.p000private.cc;
import com.appdynamics.eumagent.runtime.p000private.ce;
import com.appdynamics.eumagent.runtime.p000private.cf;
import com.appdynamics.eumagent.runtime.p000private.cg;
import com.appdynamics.eumagent.runtime.p000private.ch;
import com.appdynamics.eumagent.runtime.p000private.ci;
import com.appdynamics.eumagent.runtime.p000private.cj;
import com.appdynamics.eumagent.runtime.p000private.ck;
import com.appdynamics.eumagent.runtime.p000private.cl;
import com.appdynamics.eumagent.runtime.p000private.cq;
import com.appdynamics.eumagent.runtime.p000private.cs;
import com.appdynamics.eumagent.runtime.p000private.ct;
import com.appdynamics.eumagent.runtime.p000private.d;
import com.appdynamics.eumagent.runtime.p000private.e;
import com.appdynamics.eumagent.runtime.p000private.f;
import com.appdynamics.eumagent.runtime.p000private.i;
import com.appdynamics.eumagent.runtime.p000private.j;
import com.appdynamics.eumagent.runtime.p000private.k;
import com.appdynamics.eumagent.runtime.p000private.l;
import com.appdynamics.eumagent.runtime.p000private.n;
import com.appdynamics.eumagent.runtime.p000private.o;
import com.appdynamics.eumagent.runtime.p000private.p;
import com.appdynamics.eumagent.runtime.p000private.q;
import com.appdynamics.eumagent.runtime.p000private.r;
import com.appdynamics.eumagent.runtime.p000private.t;
import com.appdynamics.eumagent.runtime.p000private.w;
import com.appdynamics.eumagent.runtime.p000private.x;
import com.appdynamics.eumagent.runtime.p000private.y;
import com.appdynamics.eumagent.runtime.p000private.z;
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

/* loaded from: classes2.dex */
public class Instrumentation {
    public static final int LOGGING_LEVEL_INFO = 2;
    public static final int LOGGING_LEVEL_NONE = 4;
    public static final int LOGGING_LEVEL_VERBOSE = 1;
    public static final int MAX_USER_DATA_STRING_LENGTH = 2048;
    public static final int VALID_INTERACTION_CAPTURE_MODES = 7;
    static w b;
    static NativeCrashHandler c;
    public static n hybridAgentInfo;
    private static volatile String o;
    private static int p;
    private static volatile boolean q;
    private static ScheduledThreadPoolExecutor r;
    final bb i;
    final ay j;
    final as k;
    final q l;
    private f s;
    private ScheduledExecutorService t;
    private ScheduledExecutorService u;
    private b v;
    private i w;
    private af x;
    private NetworkRequestCallback y;
    static final am a = new am();
    static volatile ch d = null;
    static volatile ca e = null;
    static volatile bx f = null;
    static volatile cb g = null;
    public static volatile boolean initializationStarted = false;
    public static volatile boolean isTraceparentHeaderEnabled = false;
    static volatile Instrumentation h = null;
    private static boolean m = false;
    private static int n = 2;

    public static void changeAppKey(String str) {
        a(str);
        try {
            Instrumentation instrumentation = h;
            if (instrumentation == null) {
                ADLog.logInfo("Ignoring Instrumentation.changeAppKey() invoked before Instrumentation.start() called.");
                return;
            }
            instrumentation.s.b = str;
            String str2 = o;
            o = str;
            a.a(new d(str2, str));
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
        hybridAgentInfo = new n(str, str2);
        start(agentConfiguration);
    }

    public static synchronized void start(AgentConfiguration agentConfiguration) {
        final Activity activity;
        try {
            ADLog.setLoggingLevel(agentConfiguration.loggingLevel);
            n = agentConfiguration.loggingLevel;
            String strA = a(agentConfiguration);
            String str = o;
            if (str != null && !str.equals(agentConfiguration.appKey)) {
                throw new IllegalStateException("Instrumentation framework was already initialized with a different key");
            }
            if (ADLog.isInfoLoggingEnabled()) {
                ADLog.logInfo("Agent version = 24.12.0, agent build = 7eb5b59c4b1d293baef883eeaeed20a927213323, appBuildID = " + strA + ", starting up with configuration [" + agentConfiguration + "]");
            }
            if (ADLog.isVerboseLoggingEnabled()) {
                ADLog.logVerbose(String.format("start called from activity: %s, initializationStarted = %s, instance is null = %s", agentConfiguration.context.getClass().getName(), Boolean.valueOf(initializationStarted), Boolean.valueOf(h == null)));
            }
            if (h == null && !initializationStarted) {
                initializationStarted = true;
                int i = agentConfiguration.interactionCaptureMode;
                p = i;
                if (i != 0) {
                    if ((i & 7) == 0) {
                        ADLog.log(2, "Current interaction capture mode %d is not supported", i);
                    } else {
                        if ((i & 1) != 0) {
                            e = new ca(a);
                        }
                        if ((p & 2) != 0) {
                            g = new cb(a, null);
                        }
                        if ((p & 4) != 0) {
                            f = new bx(a);
                        }
                        if (e != null || f != null || g != null) {
                            if (ch.a()) {
                                d = new ch(e, f, g);
                            } else {
                                d = null;
                                ADLog.logAgentError("Fail to reflect mOnHierarchyChangeListener in ViewGroup class.");
                            }
                        }
                    }
                    WeakReference<Activity> weakReference = InstrumentationCallbacks.currentActivity;
                    if (weakReference != null && (activity = weakReference.get()) != null) {
                        activity.runOnUiThread(new Runnable() { // from class: com.appdynamics.eumagent.runtime.Instrumentation.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (Instrumentation.d == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                                    return;
                                }
                                Instrumentation.d.a(activity.getWindow().getDecorView());
                            }
                        });
                    }
                }
                r rVar = new r(agentConfiguration.context.getFilesDir());
                am amVar = a;
                q qVar = new q(rVar, agentConfiguration, amVar);
                isTraceparentHeaderEnabled = qVar.b.traceparentHeaderEnabled;
                if (agentConfiguration.crashReportingEnabled) {
                    w wVar = new w(agentConfiguration.context, Thread.getDefaultUncaughtExceptionHandler(), amVar, new x(), agentConfiguration.crashCallback, qVar);
                    b = wVar;
                    Thread.setDefaultUncaughtExceptionHandler(wVar.g);
                } else {
                    w wVar2 = b;
                    if (wVar2 != null) {
                        wVar2.h = qVar;
                    }
                    b = null;
                }
                if (r == null) {
                    r = new ScheduledThreadPoolExecutor(1, new AnonymousClass2("ADEum-Agent"), new ThreadPoolExecutor.DiscardPolicy());
                }
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = r;
                scheduledThreadPoolExecutor.execute(new a(agentConfiguration, qVar, strA, scheduledThreadPoolExecutor));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static class a implements Runnable {
        private final AgentConfiguration a;
        private final q b;
        private final String c;
        private final ScheduledThreadPoolExecutor d;

        public a(AgentConfiguration agentConfiguration, q qVar, String str, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            this.a = agentConfiguration;
            this.b = qVar;
            this.c = str;
            this.d = scheduledThreadPoolExecutor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            bb bbVar;
            Activity activity;
            try {
                af afVar = new af(this.a.context);
                if (afVar.a.b("disable_agent_till", -1L) > System.currentTimeMillis()) {
                    if (ADLog.isInfoLoggingEnabled()) {
                        ADLog.logInfo("Agent is disabled until = " + afVar.a.b("disable_agent_till", -1L) + ". Shutting down agent.");
                    }
                    Instrumentation.disableInstrumentation(0L);
                    return;
                }
                cl clVar = new cl();
                q qVar = this.b;
                Context context = this.a.context;
                am amVar = Instrumentation.a;
                DeviceMetricsCollector deviceMetricsCollector = new DeviceMetricsCollector(qVar, context, amVar);
                AgentConfiguration agentConfiguration = this.a;
                final NativeCrashHandler nativeCrashHandler = new NativeCrashHandler(agentConfiguration.context, this.c, amVar, agentConfiguration.loggingLevel, Instrumentation.hybridAgentInfo, deviceMetricsCollector);
                Instrumentation.c = nativeCrashHandler;
                if (NativeCrashHandler.a) {
                    try {
                        if (nativeCrashHandler.setupSignalHandler(nativeCrashHandler.c, nativeCrashHandler.d, Build.FINGERPRINT, "24.12.0", "7eb5b59c4b1d293baef883eeaeed20a927213323", Build.VERSION.RELEASE, nativeCrashHandler.e, nativeCrashHandler.g, nativeCrashHandler.h, 99, nativeCrashHandler.f) != 0) {
                            ADLog.logInfo("Failed to setup native crash handler");
                        }
                    } catch (UnsatisfiedLinkError unused) {
                    }
                    nativeCrashHandler.b.a(new am.d(new Runnable() { // from class: com.appdynamics.eumagent.runtime.crashes.NativeCrashHandler.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            String str;
                            String str2;
                            af afVar2;
                            z zVar = new z();
                            String str3 = NativeCrashHandler.this.c;
                            ac acVar = new ac();
                            zVar.a = new ArrayList();
                            zVar.b = new ArrayList();
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
                                    Arrays.sort(fileArrListFiles, ct.a);
                                    File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: com.appdynamics.eumagent.runtime.private.z.2
                                        @Override // java.io.FilenameFilter
                                        public final boolean accept(File file2, String str4) {
                                            return str4.startsWith("native_crash.") && str4.endsWith(".log");
                                        }
                                    });
                                    if (fileArrListFiles2 == null) {
                                        ADLog.log(1, "IO error while reading native crash log files from crash directory (%s), aborting read", file);
                                    } else {
                                        Arrays.sort(fileArrListFiles2, ct.a);
                                        int length = fileArrListFiles.length;
                                        int i = 0;
                                        while (true) {
                                            if (i >= length) {
                                                break;
                                            }
                                            File file2 = fileArrListFiles[i];
                                            try {
                                                z.c cVarA = z.a(z.a(file2));
                                                if (cVarA != null) {
                                                    acVar.a(cVarA.j);
                                                    zVar.a.add(cVarA);
                                                }
                                            } finally {
                                                try {
                                                    file2.delete();
                                                    i++;
                                                } finally {
                                                }
                                            }
                                            file2.delete();
                                            i++;
                                        }
                                        for (File file3 : fileArrListFiles2) {
                                            try {
                                                zVar.b.add(z.b(file3));
                                            } finally {
                                                try {
                                                } finally {
                                                }
                                            }
                                        }
                                        acVar.a();
                                    }
                                }
                            }
                            af afVar3 = NativeCrashHandler.this.i;
                            f fVar = NativeCrashHandler.this.j;
                            for (z.c cVar : zVar.a) {
                                y yVar = new y(cVar);
                                if (afVar3 != null) {
                                    yVar.b = afVar3.b.getAndIncrement();
                                }
                                if (NativeCrashHandler.this.k != null) {
                                    str = NativeCrashHandler.this.k.a;
                                    str2 = NativeCrashHandler.this.k.b;
                                } else {
                                    str = null;
                                    str2 = null;
                                }
                                if (fVar != null) {
                                    e eVarA = fVar.a();
                                    afVar2 = afVar3;
                                    yVar.c = new e(cVar.r, cVar.s, cVar.l, cVar.n, cVar.o, eVarA.a, eVarA.b, null, eVarA.c, eVarA.d, eVarA.e, cVar.p, null, null, cVar.v, str, str2, NativeCrashHandler.this.l);
                                } else {
                                    afVar2 = afVar3;
                                }
                                NativeCrashHandler.this.b.a(yVar);
                                afVar3 = afVar2;
                            }
                            for (z.b bVar : zVar.b) {
                                z.d[] dVarArr = bVar.c;
                                if (dVarArr != null && dVarArr.length > 0) {
                                    ADLog.logInfo("-----------------------");
                                    ADLog.logInfo("Native Crash Log, pid: " + bVar.a + ", tid: " + bVar.b);
                                    for (z.d dVar : bVar.c) {
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
                AgentConfiguration agentConfiguration2 = this.a;
                Context context2 = agentConfiguration2.context;
                String str = this.c;
                String str2 = agentConfiguration2.appKey;
                am amVar2 = Instrumentation.a;
                f fVar = new f(context2, str, str2, amVar2, clVar, Instrumentation.hybridAgentInfo, deviceMetricsCollector);
                String str3 = this.a.applicationName;
                if (str3 != null) {
                    if (ct.a(str3)) {
                        throw new IllegalArgumentException("Application name cannot be the empty string");
                    }
                    if (!ct.f(str3)) {
                        throw new IllegalArgumentException("Application name is not valid. Package naming convention could be found in http://developer.android.com/guide/topics/manifest/manifest-element.html");
                    }
                    fVar.c = str3;
                }
                AgentConfiguration agentConfiguration3 = this.a;
                String str4 = agentConfiguration3.collectorURL;
                String str5 = agentConfiguration3.screenshotURL;
                CollectorChannelFactory collectorChannelFactory = agentConfiguration3.collectorChannelFactory;
                URL url = new URL(str4);
                ci ciVar = new ci(new URL(url, "eumcollector/mobileMetrics?version=2"), new URL(url, "eumcollector/mobileAgentCount"), new URL(new URL(str5), "screenshots/v1/application/"), fVar, collectorChannelFactory);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = Instrumentation.a();
                new bv(amVar2);
                ah ahVar = new ah(this.a.context);
                k kVar = new k(new aj(new ag(ahVar, "beacons", new o.a(), 200), amVar2, 200), new aj(new ag(ahVar, "crash_beacons", new ad.a(), 4), amVar2, 4), amVar2, this.b);
                l lVar = new l(ciVar, afVar, amVar2, kVar, scheduledThreadPoolExecutorA, this.b, fVar);
                Long l = this.b.a.i;
                t tVar = new t(l != null ? l.longValue() : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, amVar2, Instrumentation.b);
                ADLog.logInfo("Starting ANRDetector with frequency:" + tVar.d);
                am amVar3 = tVar.e;
                Runnable runnable = tVar.j;
                long j = tVar.d;
                amVar3.a(new am.d(runnable, j, j));
                AgentConfiguration agentConfiguration4 = this.a;
                if (agentConfiguration4.autoInstrument) {
                    final bb bbVar2 = new bb(amVar2, agentConfiguration4.networkRequestCallback, this.b);
                    bbVar2.a.a(new am.d(new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.bb.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            bb.this.a();
                        }

                        public final String toString() {
                            return "EndOngoingConnectionsRunnable";
                        }
                    }, 10000L, 10000L));
                    bbVar = bbVar2;
                } else {
                    bbVar = null;
                }
                AgentConfiguration agentConfiguration5 = this.a;
                ay ayVar = agentConfiguration5.autoInstrument ? new ay(amVar2, agentConfiguration5.networkRequestCallback) : null;
                i iVar = new i(amVar2, kVar, lVar, afVar, fVar);
                cf cfVar = (this.a.autoInstrument || "Xamarin".equalsIgnoreCase(Instrumentation.hybridAgentInfo.a)) ? new cf(amVar2) : null;
                bi biVar = new bi(amVar2, new bg(amVar2, this.b, fVar), new bn(scheduledThreadPoolExecutorA, new bm(new File(this.a.context.getFilesDir(), "adeum-screenshots-tiles"), amVar2, scheduledThreadPoolExecutorA), new bj(ciVar), this.b, fVar), this.b, fVar);
                if (Instrumentation.g != null) {
                    Instrumentation.g.c = biVar;
                }
                new bp(amVar2, this.b);
                as asVar = new as(amVar2);
                amVar2.e = new az(this.a);
                NetworkRequestCallback networkRequestCallback = this.a.networkRequestCallback;
                new ce(amVar2);
                Instrumentation.h = new Instrumentation(bbVar, ayVar, asVar, fVar, this.d, scheduledThreadPoolExecutorA, iVar, afVar, networkRequestCallback, this.b, Instrumentation.hybridAgentInfo);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.d;
                if (scheduledThreadPoolExecutor == null) {
                    throw new IllegalArgumentException("Cannot start EventBus, executor is null");
                }
                amVar2.d = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.execute(amVar2.b);
                amVar2.f = false;
                NativeCrashHandler nativeCrashHandler2 = Instrumentation.c;
                nativeCrashHandler2.j = fVar;
                nativeCrashHandler2.i = afVar;
                nativeCrashHandler2.a(clVar);
                w wVar = Instrumentation.b;
                if (wVar != null) {
                    wVar.f = fVar;
                    wVar.e = afVar;
                    if (this.b.b.crashReportingEnabled) {
                        wVar.a();
                    }
                }
                amVar2.a(new c());
                if (cfVar == null) {
                    amVar2.a(new cg("Application", "App Start"));
                }
                WeakReference<Activity> weakReference = InstrumentationCallbacks.currentActivity;
                if (weakReference == null || (activity = weakReference.get()) == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getRootView() == null) {
                    return;
                }
                amVar2.a(new be(bz.a(activity)));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while initializing AppDynamics agent", th);
                Instrumentation.disableInstrumentation(0L);
            }
        }
    }

    private static String a(AgentConfiguration agentConfiguration) {
        a(agentConfiguration.appKey);
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
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("[" + agentConfiguration.collectorURL + "] is not a valid collector url.", e2);
        }
    }

    /* renamed from: com.appdynamics.eumagent.runtime.Instrumentation$2, reason: invalid class name */
    final class AnonymousClass2 implements ThreadFactory {
        private /* synthetic */ String a;

        AnonymousClass2(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(this.a);
            return thread;
        }
    }

    Instrumentation(bb bbVar, ay ayVar, as asVar, f fVar, ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2, i iVar, af afVar, NetworkRequestCallback networkRequestCallback, q qVar, n nVar) {
        this.i = bbVar;
        this.j = ayVar;
        this.k = asVar;
        this.s = fVar;
        this.t = scheduledExecutorService;
        this.u = scheduledExecutorService2;
        this.w = iVar;
        this.x = afVar;
        this.y = networkRequestCallback;
        this.l = qVar;
        hybridAgentInfo = nVar;
        b bVar = new b();
        this.v = bVar;
        a.a.a(cq.class, bVar);
    }

    class b implements am.b {
        b() {
        }

        @Override // com.appdynamics.eumagent.runtime.private.am.b
        public final void a(Object obj) {
            if (obj instanceof cq) {
                Instrumentation.a(((cq) obj).a);
            }
        }
    }

    private static void a(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("AppKey cannot be null or empty");
        }
        if (Pattern.matches("[a-zA-Z0-9]{1,}(-[A-Z]{3}){2,}", str)) {
            return;
        }
        throw new IllegalArgumentException("AppKey is malformed: " + str + ", it should look like: AD-AAA-BBB");
    }

    public static void reportMetric(String str, long j) {
        if (m) {
            return;
        }
        ADLog.log(1, "reportMetric(name='%s', value=%d) called", str, Long.valueOf(j));
        if (initializationStarted) {
            try {
                a.a(new at(ct.b(str), j, new cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting metric", th);
            }
        }
    }

    public static String getAgentIdentifier(Context context) {
        return new af(context).a();
    }

    @Deprecated
    public static void reportError(Throwable th) {
        if (m) {
            return;
        }
        reportError(th, 1);
    }

    public static void reportError(Throwable th, int i) {
        if (m) {
            return;
        }
        ADLog.log(1, "reportError(throwable='%s', severityLevel='%d') called", th, Integer.valueOf(i));
        if (initializationStarted) {
            try {
                a.a(new al(th, i, null));
            } catch (Throwable th2) {
                ADLog.logAgentError("Exception while reporting error", th2);
            }
        }
    }

    public static void startTimer(String str) {
        if (m) {
            return;
        }
        ADLog.log(1, "startTimer(name='%s') called", str);
        if (initializationStarted) {
            try {
                a.a(new bw(ct.b(str), false, new cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting timer", th);
            }
        }
    }

    public static void stopTimer(String str) {
        if (m) {
            return;
        }
        ADLog.log(1, "stopTimer(name='%s') called", str);
        if (initializationStarted) {
            try {
                a.a(new bw(ct.b(str), true, new cs()));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while stopping timer", th);
            }
        }
    }

    public static SessionFrame startSessionFrame(String str) {
        ADLog.log(1, "startSessionFrame(sessionFrameName='%s') called", str);
        if (initializationStarted) {
            try {
                return new bt(a, ct.c(str));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting Session Frame.", th);
            }
        }
        return bt.a;
    }

    public static void startNextSession() {
        if (m) {
            return;
        }
        ADLog.logVerbose("startNextSession() called");
        if (initializationStarted) {
            try {
                a.a(new br());
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
        ADLog.log(1, "beginCall(static='%s', className='%s', methodName='%s', args) called", z ? "yes" : "no", str, str2);
        if (initializationStarted) {
            try {
                return new ap(a, ct.c(str), ct.c(str2), z).withArguments(objArr);
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting to track info point", th);
            }
        }
        return ap.a;
    }

    public static void endCall(CallTracker callTracker, Object obj) {
        if (m) {
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
        if (m) {
            return;
        }
        endCall(callTracker, null);
    }

    public static HttpRequestTracker beginHttpRequest(URL url) {
        ADLog.log(1, "beginHttpRequest(url='%s') called", url);
        if (initializationStarted) {
            try {
                if (url == null) {
                    return new ax();
                }
                return new ba(a, url, h != null ? h.y : null);
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while starting to track HTTP request", th);
            }
        }
        return new ax();
    }

    public static void leaveBreadcrumb(String str) {
        if (m) {
            return;
        }
        leaveBreadcrumb(str, 0);
    }

    public static void leaveBreadcrumb(String str, int i) {
        if (m) {
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
            p pVar = new p(str);
            w wVar = b;
            if (wVar != null) {
                wVar.b.a(pVar);
            }
            NativeCrashHandler nativeCrashHandler = c;
            if (nativeCrashHandler != null && NativeCrashHandler.a) {
                z.a aVar = new z.a();
                aVar.a = pVar.g.b;
                aVar.b = pVar.i;
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
                a.a(pVar);
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while reporting breadcrumb", th);
        }
    }

    public static void unblockScreenshots() {
        if (m) {
            return;
        }
        ADLog.logVerbose("unblockScreenshots() called");
        q = false;
    }

    public static void blockScreenshots() {
        if (m) {
            return;
        }
        ADLog.logVerbose("blockScreenshots() called");
        q = true;
    }

    public static boolean screenshotsBlocked() {
        ADLog.logVerbose("screenshotsBlocked() called, current value: " + q);
        return q;
    }

    public static void takeScreenshot() {
        if (m) {
            return;
        }
        ADLog.logVerbose("takeScreenshot() called");
        if (initializationStarted) {
            try {
                a.a(new bk());
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while taking screenshot", th);
            }
        }
    }

    public static int createCrashReport(String str, String str2) {
        try {
            if (b == null) {
                ADLog.logAgentError("Didn't create crash report because crash report manager is null");
                return -1;
            }
            if ("Flutter".equals(hybridAgentInfo.a)) {
                w wVar = b;
                j jVarA = wVar.a(new com.appdynamics.eumagent.runtime.p000private.a(str, str2, new cs(), wVar.b));
                try {
                    StringWriter stringWriter = new StringWriter();
                    jVarA.a(stringWriter);
                    wVar.a(Collections.singletonList(stringWriter.toString()));
                } catch (Throwable th) {
                    ADLog.logAgentError("Error trying to convert crash report event to JSON", th);
                }
                return 0;
            }
            w wVar2 = b;
            cs csVar = new cs();
            ADLog.log(2, "Writing external crash report to disk for :%s", str2);
            wVar2.b(new com.appdynamics.eumagent.runtime.p000private.a(str, str2, csVar, wVar2.b));
            return 0;
        } catch (IOException e2) {
            ADLog.logAgentError("Exception while reporting external crash", e2);
            return -1;
        }
    }

    public static int createRawCrashReport(String str) {
        try {
            if (b == null) {
                ADLog.logAgentError("Didn't create crash report because crash report manager is null");
                return -1;
            }
            n nVar = hybridAgentInfo;
            if (nVar != null && "Flutter".equals(nVar.a)) {
                w wVar = b;
                j jVarA = wVar.a(new com.appdynamics.eumagent.runtime.p000private.b(str));
                try {
                    StringWriter stringWriter = new StringWriter();
                    jVarA.a(stringWriter);
                    wVar.a(Collections.singletonList(stringWriter.toString()));
                } catch (Throwable th) {
                    ADLog.logAgentError("Error trying to convert crash report event to JSON", th);
                }
                return 0;
            }
            w wVar2 = b;
            new cs();
            ADLog.log(2, "Writing raw crash report to disk", "raw hybrid crash");
            wVar2.b(new com.appdynamics.eumagent.runtime.p000private.b(str));
            return 0;
        } catch (IOException e2) {
            ADLog.logAgentError("Exception while reporting external crash", e2);
            return -1;
        }
    }

    public static void reportRawError(String str, int i) {
        if (m) {
            return;
        }
        ADLog.log(1, "reportErrorForHybridStacktraces(severityLevel='%d') called", i);
        if (initializationStarted) {
            try {
                a.a(new al(null, i, str));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting error", th);
            }
        }
    }

    public static void setUserData(String str, String str2) {
        if (m) {
            return;
        }
        ADLog.log(1, "setUserData(key='%s', value='%s') called", str, str2);
        if (initializationStarted) {
            try {
                a.a(new ck(ct.d(str), ct.e(str2), String.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataLong(String str, Long l) {
        if (m) {
            return;
        }
        ADLog.log(1, "setUserDataLong(key='%s', value='%s') called", str, l);
        if (initializationStarted) {
            try {
                a.a(new ck(ct.d(str), l, Long.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataBoolean(String str, Boolean bool) {
        if (m) {
            return;
        }
        ADLog.log(1, "setUserDataBoolean(key='%s', value='%s') called", str, bool);
        if (initializationStarted) {
            try {
                a.a(new ck(ct.d(str), bool, Boolean.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataDouble(String str, Double d2) {
        if (m) {
            return;
        }
        ADLog.log(1, "setUserDataDouble(key='%s', value='%s') called", str, d2);
        if (initializationStarted) {
            try {
                String strD = ct.d(str);
                if (d2 != null) {
                    if (d2.isNaN()) {
                        ADLog.log(1, "Illegal value NaN for user data key '%s', clearing user data for key", strD);
                    } else if (d2.isInfinite()) {
                        ADLog.log(1, "Illegal infinite value for user data key '%s', clearing user data for key", strD);
                    }
                    d2 = null;
                }
                a.a(new ck(strD, d2, Double.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void setUserDataDate(String str, Date date) {
        if (m) {
            return;
        }
        ADLog.log(1, "setUserDataDate(key='%s') called", str, date);
        if (initializationStarted) {
            try {
                a.a(new ck(ct.d(str), date != null ? Long.valueOf(date.getTime()) : null, Date.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while setting user data", th);
            }
        }
    }

    public static void clearAllUserData() {
        if (m || !initializationStarted) {
            return;
        }
        try {
            try {
                a.a(new cj(String.class));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while clearing all string user data", th);
            }
            try {
                a.a(new cj(Boolean.class));
            } catch (Throwable th2) {
                ADLog.logAgentError("Exception while clearing all boolean user data", th2);
            }
            try {
                a.a(new cj(Date.class));
            } catch (Throwable th3) {
                ADLog.logAgentError("Exception while clearing all date user data", th3);
            }
            try {
                a.a(new cj(Double.class));
            } catch (Throwable th4) {
                ADLog.logAgentError("Exception while clearing all double user data", th4);
            }
            try {
                a.a(new cj(Long.class));
            } catch (Throwable th5) {
                ADLog.logAgentError("Exception while clearing all long user data", th5);
            }
        } catch (Throwable th6) {
            ADLog.logAgentError("Exception while clearing all user data", th6);
        }
    }

    public static void trackPageStart(String str, UUID uuid, long j) {
        if (m) {
            return;
        }
        ADLog.logVerbose("TrackPageStart() called");
        if (initializationStarted) {
            try {
                a.a(new cc(str, "Fragment Start", uuid, new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), null));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while tracking Page Start", th);
            }
        }
    }

    public static void trackPageEnd(String str, UUID uuid, long j, long j2) {
        if (m) {
            return;
        }
        ADLog.logVerbose("TrackPageEnd() called");
        if (initializationStarted) {
            try {
                a.a(new cc(str, "Fragment End", uuid, new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j2), j2)));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while tracking Page End", th);
            }
        }
    }

    public static void trackUIEvent(String str, String str2, String str3, long j, String str4, String str5, int i, String str6, String str7) {
        if (m) {
            return;
        }
        ADLog.logVerbose("trackUIEvent() called");
        if (initializationStarted) {
            try {
                a.a(new cg(str, str2, new cs(SystemClock.uptimeMillis() - (System.currentTimeMillis() - j), j), null, str4, str5, str7, str3, str6, i));
            } catch (Throwable th) {
                ADLog.logAgentError("Exception on trackUIEvent()", th);
            }
        }
    }

    static void a(long j) {
        if (ADLog.isInfoLoggingEnabled()) {
            ADLog.logInfo("Agent disabled by collector until ".concat(String.valueOf(j)));
        }
        disableInstrumentation(j);
    }

    public static void shutdownAgent() {
        m = true;
        a.f = true;
        ADLog.setLoggingLevel(4);
        i iVar = h.w;
        iVar.b = false;
        k kVar = iVar.a;
        ArrayList arrayList = new ArrayList();
        kVar.a.a(arrayList);
        kVar.b.a(arrayList);
        blockScreenshots();
    }

    public static void restartAgent() {
        m = false;
        a.f = false;
        ADLog.setLoggingLevel(n);
        h.w.b = true;
        unblockScreenshots();
    }

    public static void disableInstrumentation(long j) {
        initializationStarted = false;
        am amVar = a;
        amVar.f = true;
        amVar.d = null;
        amVar.c.clear();
        amVar.a.a();
        am.b bVar = amVar.g;
        if (bVar == null) {
            ADLog.logInfo("Ignoring attempt to register null event listener");
        } else {
            amVar.a.a(am.d.class, bVar);
        }
        Instrumentation instrumentation = h;
        if (instrumentation != null) {
            if (j > 0) {
                instrumentation.x.a.a("disable_agent_till", j);
            }
            if (!instrumentation.t.isShutdown()) {
                ADLog.logInfo("Shutting down executor pool.");
                instrumentation.t.shutdown();
            }
            if (!instrumentation.u.isShutdown()) {
                ADLog.logInfo("Shutting down IO executor pool");
                instrumentation.u.shutdown();
            }
            h = null;
        }
        final ch chVar = d;
        final ca caVar = e;
        final bx bxVar = f;
        final cb cbVar = g;
        d = null;
        e = null;
        f = null;
        g = null;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdynamics.eumagent.runtime.Instrumentation.3
            @Override // java.lang.Runnable
            public final void run() {
                ch chVar2 = chVar;
                if (chVar2 != null) {
                    for (Map.Entry<View, ViewGroup.OnHierarchyChangeListener> entry : chVar2.a.entrySet()) {
                        ((ViewGroup) entry.getKey()).setOnHierarchyChangeListener(entry.getValue());
                    }
                    chVar2.a.clear();
                }
                ca caVar2 = caVar;
                if (caVar2 != null) {
                    for (Map.Entry<View, LinkedHashSet<View.OnClickListener>> entry2 : caVar2.a.entrySet()) {
                        Iterator<View.OnClickListener> it = entry2.getValue().iterator();
                        while (it.hasNext()) {
                            entry2.getKey().setOnClickListener(it.next());
                        }
                    }
                    caVar2.a.clear();
                }
                bx bxVar2 = bxVar;
                if (bxVar2 != null) {
                    for (Map.Entry<AdapterView, AdapterView.OnItemClickListener> entry3 : bxVar2.a.entrySet()) {
                        entry3.getKey().setOnItemClickListener(entry3.getValue());
                    }
                    bxVar2.a.clear();
                }
                cb cbVar2 = cbVar;
                if (cbVar2 != null) {
                    for (Map.Entry<View, ArrayList<View.OnFocusChangeListener>> entry4 : cbVar2.a.entrySet()) {
                        Iterator<View.OnFocusChangeListener> it2 = entry4.getValue().iterator();
                        while (it2.hasNext()) {
                            entry4.getKey().setOnFocusChangeListener(it2.next());
                        }
                    }
                    cbVar2.a.clear();
                }
            }
        });
    }

    static /* synthetic */ ScheduledThreadPoolExecutor a() {
        return new ScheduledThreadPoolExecutor(1, new AnonymousClass2("ADEum-Agent-IO"), new ThreadPoolExecutor.DiscardPolicy());
    }
}
