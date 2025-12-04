package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class am {
    public final cp<Class, b> a;
    public final a b;
    public final BlockingQueue<Object> c;
    public volatile ScheduledThreadPoolExecutor d = null;
    public an e;
    public boolean f;
    public final b g;

    public interface b {
        void a(Object obj);
    }

    public am() {
        b bVar = new b() { // from class: com.appdynamics.eumagent.runtime.private.am.1
            @Override // com.appdynamics.eumagent.runtime.private.am.b
            public final void a(Object obj) {
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    if (dVar.a != null) {
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = am.this.d;
                        if (scheduledThreadPoolExecutor == null) {
                            ADLog.log(1, "Executor is null, skipping scheduling for runnable: %s", am.this.g);
                            return;
                        }
                        if (dVar.b <= 0) {
                            if (dVar.c > 0) {
                                scheduledThreadPoolExecutor.schedule(new c(dVar.a), dVar.c, TimeUnit.MILLISECONDS);
                                return;
                            } else {
                                scheduledThreadPoolExecutor.execute(dVar.a);
                                return;
                            }
                        }
                        if (ADLog.isVerboseLoggingEnabled()) {
                            ADLog.logVerbose("Scheduling " + dVar.a + " to run every " + dVar.b + " ms.");
                        }
                        scheduledThreadPoolExecutor.scheduleAtFixedRate(new c(dVar.a), dVar.c, dVar.b, TimeUnit.MILLISECONDS);
                        return;
                    }
                    ADLog.logInfo("WARNING: No runnable in ScheduleRunnableEvent, skipping");
                }
            }
        };
        this.g = bVar;
        this.c = new ArrayBlockingQueue(1000);
        this.b = new a(this, (byte) 0);
        cp<Class, b> cpVar = new cp<>();
        this.a = cpVar;
        this.f = false;
        cpVar.a();
        cpVar.a(d.class, bVar);
    }

    public final void a(Object obj) {
        if (this.f) {
            ADLog.logVerbose("EventBus is shutdown; event ignored");
            return;
        }
        if (obj == null) {
            ADLog.logInfo("Ignoring attempt to post null event");
            return;
        }
        an anVar = this.e;
        if (anVar != null && anVar.a(obj)) {
            ADLog.log(1, "EventBus filtered event: %s", obj);
            return;
        }
        ADLog.log(1, "EventBus.post(%s)", obj.toString());
        if (!this.c.offer(obj)) {
            ADLog.log(2, "EventBus dropped event: %s", obj);
            return;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.d;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.execute(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public class a implements Runnable {
        private Collection<Object> a;

        private a() {
            this.a = new ArrayList();
        }

        /* synthetic */ a(am amVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            am.this.c.drainTo(this.a);
            if (this.a.size() == 0) {
                return;
            }
            ADLog.log(1, "Dispatching #%d events in EventBus", this.a.size());
            for (Object obj : this.a) {
                Collection<b> collectionA = am.this.a.a(obj.getClass());
                if (collectionA == null || collectionA.isEmpty()) {
                    ADLog.log(1, "No listener in EventBus for: %s", obj);
                } else {
                    for (b bVar : collectionA) {
                        try {
                            bVar.a(obj);
                        } catch (Throwable th) {
                            if (ADLog.isInfoLoggingEnabled()) {
                                ADLog.logAgentError(String.format("%s threw exception while handling event %s", bVar, obj), th);
                            }
                        }
                    }
                }
            }
            this.a.clear();
        }
    }

    public class d {
        public final Runnable a;
        public final long b;
        public final long c;

        public d(Runnable runnable, long j, long j2) {
            this.a = runnable;
            this.c = j;
            this.b = j2;
        }

        public String toString() {
            return "ScheduleRunnableEvent(" + this.a + ", delay: " + this.c + ", periodMs: " + this.b + ")";
        }
    }

    static class c implements Runnable {
        private final Runnable a;

        c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.run();
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to run scheduled runnable", th);
            }
        }

        public final String toString() {
            return "RunnableWrapper(" + this.a + ")";
        }
    }
}
