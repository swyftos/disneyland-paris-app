package com.appdynamics.eumagent.runtime.p000private;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appdynamics.eumagent.runtime.CrashReportCallback;
import com.appdynamics.eumagent.runtime.CrashReportSummary;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.x;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class w {
    final Thread.UncaughtExceptionHandler a;
    final am c;
    final CrashReportCallback d;
    public af e;
    public f f;
    public q h;
    private final Context i;
    private x j;
    public final a g = new a();
    public final cn<p> b = new cn<>();

    public w(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, am amVar, x xVar, CrashReportCallback crashReportCallback, q qVar) {
        this.i = context;
        this.a = uncaughtExceptionHandler;
        this.j = xVar;
        this.c = amVar;
        this.d = crashReportCallback;
        this.h = qVar;
    }

    public class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002b A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:14:0x001e, B:16:0x002b, B:19:0x0033, B:21:0x003b, B:22:0x004c, B:24:0x0054, B:25:0x005b, B:27:0x005f, B:32:0x0079, B:29:0x0068), top: B:44:0x001e, outer: #3, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:14:0x001e, B:16:0x002b, B:19:0x0033, B:21:0x003b, B:22:0x004c, B:24:0x0054, B:25:0x005b, B:27:0x005f, B:32:0x0079, B:29:0x0068), top: B:44:0x001e, outer: #3, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
            /*
                r7 = this;
                com.appdynamics.eumagent.runtime.private.w r0 = com.appdynamics.eumagent.runtime.p000private.w.this
                com.appdynamics.eumagent.runtime.private.q r1 = r0.h
                if (r1 == 0) goto L14
                com.appdynamics.eumagent.runtime.AgentConfiguration r1 = r1.b
                boolean r1 = r1.crashReportingEnabled
                if (r1 != 0) goto L14
                java.lang.Thread$UncaughtExceptionHandler r7 = r0.a
                if (r7 == 0) goto L13
                r7.uncaughtException(r8, r9)
            L13:
                return
            L14:
                r0.a(r8, r9)     // Catch: java.lang.Throwable -> L18
                goto L1e
            L18:
                r0 = move-exception
                java.lang.String r1 = "Exception trying to save exception"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r1, r0)     // Catch: java.lang.Throwable -> L8e
            L1e:
                com.appdynamics.eumagent.runtime.private.w r0 = com.appdynamics.eumagent.runtime.p000private.w.this     // Catch: java.lang.Throwable -> L31
                com.appdynamics.eumagent.runtime.private.am r0 = r0.c     // Catch: java.lang.Throwable -> L31
                com.appdynamics.eumagent.runtime.private.cq r1 = new com.appdynamics.eumagent.runtime.private.cq     // Catch: java.lang.Throwable -> L31
                r1.<init>()     // Catch: java.lang.Throwable -> L31
                boolean r2 = r0.f     // Catch: java.lang.Throwable -> L31
                if (r2 == 0) goto L33
                java.lang.String r0 = "EventBus is shutdown; event ignored"
                com.appdynamics.eumagent.runtime.logging.ADLog.logVerbose(r0)     // Catch: java.lang.Throwable -> L31
                goto L84
            L31:
                r0 = move-exception
                goto L7f
            L33:
                boolean r2 = com.appdynamics.eumagent.runtime.logging.ADLog.isVerboseLoggingEnabled()     // Catch: java.lang.Throwable -> L31
                r3 = 1000(0x3e8, double:4.94E-321)
                if (r2 == 0) goto L4c
                java.lang.String r2 = "EventBus.postBlocking(%s, %d)"
                java.lang.Long r5 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L31
                java.lang.Object[] r5 = new java.lang.Object[]{r1, r5}     // Catch: java.lang.Throwable -> L31
                java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch: java.lang.Throwable -> L31
                com.appdynamics.eumagent.runtime.logging.ADLog.logInfo(r2)     // Catch: java.lang.Throwable -> L31
            L4c:
                java.util.concurrent.BlockingQueue<java.lang.Object> r2 = r0.c     // Catch: java.lang.Throwable -> L31
                boolean r2 = r2.offer(r1)     // Catch: java.lang.Throwable -> L31
                if (r2 != 0) goto L5b
                java.lang.String r0 = "EventBus dropped event: %s"
                r2 = 2
                com.appdynamics.eumagent.runtime.logging.ADLog.log(r2, r0, r1)     // Catch: java.lang.Throwable -> L31
                goto L84
            L5b:
                java.util.concurrent.ScheduledThreadPoolExecutor r2 = r0.d     // Catch: java.lang.Throwable -> L31
                if (r2 != 0) goto L68
                java.lang.String r2 = "EventBus.postBlocking() called before initialization complete, not posting now"
                com.appdynamics.eumagent.runtime.logging.ADLog.logInfo(r2)     // Catch: java.lang.Throwable -> L31
                r0.a(r1)     // Catch: java.lang.Throwable -> L31
                goto L84
            L68:
                com.appdynamics.eumagent.runtime.private.am$a r0 = r0.b     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L78
                r5 = 0
                java.util.concurrent.ScheduledFuture r0 = r2.schedule(r0, r5, r1)     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L78
                r0.get(r3, r1)     // Catch: java.lang.Throwable -> L78
                goto L84
            L78:
                r0 = move-exception
                java.lang.String r1 = "Caught exception while trying to post event"
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r1, r0)     // Catch: java.lang.Throwable -> L31
                goto L84
            L7f:
                java.lang.String r1 = "Exception trying to notify agent of crash..."
                com.appdynamics.eumagent.runtime.logging.ADLog.logAgentError(r1, r0)     // Catch: java.lang.Throwable -> L8e
            L84:
                com.appdynamics.eumagent.runtime.private.w r7 = com.appdynamics.eumagent.runtime.p000private.w.this
                java.lang.Thread$UncaughtExceptionHandler r7 = r7.a
                if (r7 == 0) goto L8d
                r7.uncaughtException(r8, r9)
            L8d:
                return
            L8e:
                r0 = move-exception
                com.appdynamics.eumagent.runtime.private.w r7 = com.appdynamics.eumagent.runtime.p000private.w.this
                java.lang.Thread$UncaughtExceptionHandler r7 = r7.a
                if (r7 == 0) goto L98
                r7.uncaughtException(r8, r9)
            L98:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.private.w.a.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    public final j a(j jVar) {
        af afVar = this.e;
        if (afVar != null) {
            jVar.b = afVar.b.getAndIncrement();
        }
        f fVar = this.f;
        if (fVar != null) {
            jVar.c = fVar.a();
        }
        return jVar;
    }

    public final File a(Thread thread, Throwable th) {
        cs csVar = new cs();
        ADLog.log(2, "Writing crash report to disk from thread: [%s]", Thread.currentThread().getName());
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = (((runtime.totalMemory() - runtime.freeMemory()) >> 19) + 1) >> 1;
        ADLog.log(1, "usedMemory: %d MB", Long.valueOf(jFreeMemory));
        return b(new v(th, thread, csVar, this.b, jFreeMemory));
    }

    public final File b(j jVar) {
        File file;
        FileWriter fileWriter;
        File fileA = a(this.i);
        if (!fileA.exists()) {
            if (!fileA.mkdirs()) {
                ADLog.log(2, "Unable to create output directory %s. Crash reports not written", fileA);
                throw new IOException("Could not create output directory.");
            }
            ADLog.log(2, "Created output directory: %s", fileA);
        }
        String str = fileA + "/crash-" + System.currentTimeMillis();
        FileWriter fileWriter2 = null;
        try {
            file = new File(str);
            fileWriter = new FileWriter(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(jVar).b(new JsonWriter(fileWriter));
            fileWriter.flush();
            ADLog.log(2, "Completed writing contents to file %s", str);
            ct.a(fileWriter);
            return file;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            ct.a(fileWriter2);
            throw th;
        }
    }

    public final void a() throws Throwable {
        File fileA = a(this.i);
        if (!fileA.isDirectory()) {
            ADLog.log(1, "Crash Directory (%s) is not a directory, aborting read", fileA);
            return;
        }
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Contents of folder %s is = %s", fileA, Arrays.toString(fileA.list()));
        }
        File[] fileArrListFiles = fileA.listFiles(new FilenameFilter() { // from class: com.appdynamics.eumagent.runtime.private.w.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return str.startsWith("crash-");
            }
        });
        if (fileArrListFiles == null) {
            ADLog.log(1, "IO error while reading crash files from crash directory (%s), aborting read", fileA);
            return;
        }
        Arrays.sort(fileArrListFiles, ct.a);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            File file = fileArrListFiles[i];
            if (arrayList.size() >= 4) {
                int length2 = fileArrListFiles.length - 4;
                if (length2 > 0) {
                    ADLog.log(2, "Skipping %d crash reports", length2);
                }
            } else {
                ADLog.log(2, "Read contents of file %s", file);
                String strA = a(file, sb, cArr);
                if (strA == null || strA.isEmpty()) {
                    ADLog.log(2, "Failure reading contents of file %s. Deleting it immediately", file);
                    file.delete();
                } else {
                    arrayList.add(strA);
                }
                i++;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ADLog.log(2, "Deleting contents of crash reports folder %s", fileA);
        for (File file2 : fileA.listFiles()) {
            file2.delete();
        }
        a(arrayList);
    }

    public final void a(List<String> list) {
        LinkedList<x.a> linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(this.j.a(it.next()));
        }
        b(linkedList);
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            this.c.a(new ad(System.currentTimeMillis(), ((x.a) it2.next()).a));
        }
        ADLog.log(2, "Total number of reports sent = %d", linkedList.size());
        if (this.d != null) {
            final LinkedList linkedList2 = new LinkedList();
            for (x.a aVar : linkedList) {
                linkedList2.add(new CrashReportSummary(aVar.b, aVar.g, aVar.h));
            }
            if (linkedList2.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.w.2
                @Override // java.lang.Runnable
                public final void run() {
                    ADLog.log(2, "Notifying CrashReportCallback with %d crashes", linkedList2.size());
                    w.this.d.onCrashesReported(linkedList2);
                }
            });
        }
    }

    private static void b(List<x.a> list) {
        Integer num;
        String str;
        ArrayList<x.a> arrayList = new ArrayList();
        for (x.a aVar : list) {
            Integer num2 = aVar.e;
            if (num2 != null && num2.intValue() == 0 && "android.runtime.JavaProxyThrowable".equals(aVar.g) && (str = aVar.d) != null && str.startsWith("Thread[main") && aVar.f != null) {
                arrayList.add(aVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (x.a aVar2 : arrayList) {
            Iterator<x.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                x.a next = it.next();
                Integer num3 = next.e;
                if (num3 != null && 1 == num3.intValue() && (num = next.c) != null && num.intValue() == 1 && next.f != null && aVar2.f.longValue() >= next.f.longValue() && aVar2.f.longValue() - 1000 <= next.f.longValue()) {
                    arrayList2.add(aVar2);
                    break;
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            list.remove((x.a) it2.next());
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0013: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:8:0x0013 */
    private static String a(File file, StringBuilder sb, char[] cArr) throws Throwable {
        FileReader fileReader;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                fileReader = new FileReader(file);
                while (true) {
                    try {
                        int i = fileReader.read(cArr);
                        if (i != -1) {
                            sb.append(cArr, 0, i);
                        } else {
                            String string = sb.toString();
                            sb.setLength(0);
                            ct.a(fileReader);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        ADLog.logAgentError("Caught exception while trying to read a crash file", e);
                        sb.setLength(0);
                        ct.a(fileReader);
                        return null;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileReader = null;
            } catch (Throwable th) {
                th = th;
                sb.setLength(0);
                ct.a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            sb.setLength(0);
            ct.a(closeable2);
            throw th;
        }
    }

    private static File a(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + "/appdynamics/crash-reports");
    }
}
