package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.am */
/* JADX INFO: loaded from: classes2.dex */
public class C2063am {

    /* JADX INFO: renamed from: a */
    public final C2120cp<Class, b> f535a;

    /* JADX INFO: renamed from: b */
    public final a f536b;

    /* JADX INFO: renamed from: c */
    public final BlockingQueue<Object> f537c;

    /* JADX INFO: renamed from: d */
    public volatile ScheduledThreadPoolExecutor f538d = null;

    /* JADX INFO: renamed from: e */
    public InterfaceC2064an f539e;

    /* JADX INFO: renamed from: f */
    public boolean f540f;

    /* JADX INFO: renamed from: g */
    public final b f541g;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.am$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo484a(Object obj);
    }

    public C2063am() {
        b bVar = new b() { // from class: com.appdynamics.eumagent.runtime.private.am.1
            @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
            /* JADX INFO: renamed from: a */
            public final void mo484a(Object obj) {
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    if (dVar.f546a != null) {
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = C2063am.this.f538d;
                        if (scheduledThreadPoolExecutor == null) {
                            ADLog.log(1, "Executor is null, skipping scheduling for runnable: %s", C2063am.this.f541g);
                            return;
                        }
                        if (dVar.f547b <= 0) {
                            if (dVar.f548c > 0) {
                                scheduledThreadPoolExecutor.schedule(new c(dVar.f546a), dVar.f548c, TimeUnit.MILLISECONDS);
                                return;
                            } else {
                                scheduledThreadPoolExecutor.execute(dVar.f546a);
                                return;
                            }
                        }
                        if (ADLog.isVerboseLoggingEnabled()) {
                            ADLog.logVerbose("Scheduling " + dVar.f546a + " to run every " + dVar.f547b + " ms.");
                        }
                        scheduledThreadPoolExecutor.scheduleAtFixedRate(new c(dVar.f546a), dVar.f548c, dVar.f547b, TimeUnit.MILLISECONDS);
                        return;
                    }
                    ADLog.logInfo("WARNING: No runnable in ScheduleRunnableEvent, skipping");
                }
            }
        };
        this.f541g = bVar;
        this.f537c = new ArrayBlockingQueue(1000);
        this.f536b = new a(this, (byte) 0);
        C2120cp<Class, b> c2120cp = new C2120cp<>();
        this.f535a = c2120cp;
        this.f540f = false;
        c2120cp.m655a();
        c2120cp.m656a(d.class, bVar);
    }

    /* JADX INFO: renamed from: a */
    public final void m562a(Object obj) {
        if (this.f540f) {
            ADLog.logVerbose("EventBus is shutdown; event ignored");
            return;
        }
        if (obj == null) {
            ADLog.logInfo("Ignoring attempt to post null event");
            return;
        }
        InterfaceC2064an interfaceC2064an = this.f539e;
        if (interfaceC2064an != null && interfaceC2064an.mo563a(obj)) {
            ADLog.log(1, "EventBus filtered event: %s", obj);
            return;
        }
        ADLog.log(1, "EventBus.post(%s)", obj.toString());
        if (!this.f537c.offer(obj)) {
            ADLog.log(2, "EventBus dropped event: %s", obj);
            return;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f538d;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.execute(this.f536b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.am$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a */
        private Collection<Object> f543a;

        private a() {
            this.f543a = new ArrayList();
        }

        /* synthetic */ a(C2063am c2063am, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2063am.this.f537c.drainTo(this.f543a);
            if (this.f543a.size() == 0) {
                return;
            }
            ADLog.log(1, "Dispatching #%d events in EventBus", this.f543a.size());
            for (Object obj : this.f543a) {
                Collection<b> collectionM654a = C2063am.this.f535a.m654a(obj.getClass());
                if (collectionM654a == null || collectionM654a.isEmpty()) {
                    ADLog.log(1, "No listener in EventBus for: %s", obj);
                } else {
                    for (b bVar : collectionM654a) {
                        try {
                            bVar.mo484a(obj);
                        } catch (Throwable th) {
                            if (ADLog.isInfoLoggingEnabled()) {
                                ADLog.logAgentError(String.format("%s threw exception while handling event %s", bVar, obj), th);
                            }
                        }
                    }
                }
            }
            this.f543a.clear();
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.am$d */
    public class d {

        /* JADX INFO: renamed from: a */
        public final Runnable f546a;

        /* JADX INFO: renamed from: b */
        public final long f547b;

        /* JADX INFO: renamed from: c */
        public final long f548c;

        public d(Runnable runnable, long j, long j2) {
            this.f546a = runnable;
            this.f548c = j;
            this.f547b = j2;
        }

        public String toString() {
            return "ScheduleRunnableEvent(" + this.f546a + ", delay: " + this.f548c + ", periodMs: " + this.f547b + ")";
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.am$c */
    static class c implements Runnable {

        /* JADX INFO: renamed from: a */
        private final Runnable f545a;

        c(Runnable runnable) {
            this.f545a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f545a.run();
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to run scheduled runnable", th);
            }
        }

        public final String toString() {
            return "RunnableWrapper(" + this.f545a + ")";
        }
    }
}
