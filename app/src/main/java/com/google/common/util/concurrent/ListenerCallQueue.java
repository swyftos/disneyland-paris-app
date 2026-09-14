package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
final class ListenerCallQueue {
    private static final LazyLogger logger = new LazyLogger(ListenerCallQueue.class);
    private final List listeners = Collections.synchronizedList(new ArrayList());

    interface Event {
        void call(Object obj);
    }

    ListenerCallQueue() {
    }

    public void addListener(Object obj, Executor executor) {
        Preconditions.checkNotNull(obj, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(obj, executor));
    }

    public void enqueue(Event event) {
        enqueueHelper(event, event);
    }

    private void enqueueHelper(Event event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            try {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    ((PerListenerQueue) it.next()).add(event, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dispatch() throws Exception {
        for (int i = 0; i < this.listeners.size(); i++) {
            ((PerListenerQueue) this.listeners.get(i)).dispatch();
        }
    }

    private static final class PerListenerQueue implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Object listener;
        final Queue waitQueue = Queues.newArrayDeque();
        final Queue labelQueue = Queues.newArrayDeque();

        PerListenerQueue(Object obj, Executor executor) {
            this.listener = Preconditions.checkNotNull(obj);
            this.executor = (Executor) Preconditions.checkNotNull(executor);
        }

        synchronized void add(Event event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        void dispatch() throws Exception {
            boolean z;
            synchronized (this) {
                try {
                    if (this.isThreadScheduled) {
                        z = false;
                    } else {
                        z = true;
                        this.isThreadScheduled = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (Exception e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.get().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x005e */
        /* JADX WARN: Code duplicated, block: B:28:0x0062  */
        /* JADX WARN: Code duplicated, block: B:38:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            r2.call(r9.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.logger.get().log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.listener + " " + r3, (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            boolean z;
            Throwable th;
            while (true) {
                boolean z2 = true;
                try {
                    synchronized (this) {
                        try {
                            Preconditions.checkState(this.isThreadScheduled);
                            Event event = (Event) this.waitQueue.poll();
                            Object objPoll = this.labelQueue.poll();
                            if (event == null) {
                                this.isThreadScheduled = false;
                                try {
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                }
                            }
                        } catch (Throwable th3) {
                            z = true;
                            th = th3;
                        }
                        while (true) {
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        boolean z3 = z;
                        th = th4;
                        z2 = z3;
                        if (z2) {
                            synchronized (this) {
                                this.isThreadScheduled = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (z2) {
                        synchronized (this) {
                            this.isThreadScheduled = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
