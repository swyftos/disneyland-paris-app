package com.appdynamics.eumagent.runtime.p192private;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appdynamics.eumagent.runtime.CrashReportCallback;
import com.appdynamics.eumagent.runtime.CrashReportSummary;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.w */
/* JADX INFO: loaded from: classes2.dex */
public final class C2144w {

    /* JADX INFO: renamed from: a */
    final Thread.UncaughtExceptionHandler f947a;

    /* JADX INFO: renamed from: c */
    final C2063am f949c;

    /* JADX INFO: renamed from: d */
    final CrashReportCallback f950d;

    /* JADX INFO: renamed from: e */
    public C2056af f951e;

    /* JADX INFO: renamed from: f */
    public C2127f f952f;

    /* JADX INFO: renamed from: h */
    public C2138q f954h;

    /* JADX INFO: renamed from: i */
    private final Context f955i;

    /* JADX INFO: renamed from: j */
    private C2145x f956j;

    /* JADX INFO: renamed from: g */
    public final a f953g = new a();

    /* JADX INFO: renamed from: b */
    public final C2118cn<C2137p> f948b = new C2118cn<>();

    public C2144w(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C2063am c2063am, C2145x c2145x, CrashReportCallback crashReportCallback, C2138q c2138q) {
        this.f955i = context;
        this.f947a = uncaughtExceptionHandler;
        this.f956j = c2145x;
        this.f949c = c2063am;
        this.f950d = crashReportCallback;
        this.f954h = c2138q;
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.w$a */
    public class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            C2144w c2144w = C2144w.this;
            C2138q c2138q = c2144w.f954h;
            if (c2138q == null || c2138q.f903b.crashReportingEnabled) {
                try {
                    try {
                        c2144w.m717a(thread, th);
                    } catch (Throwable th2) {
                        ADLog.logAgentError("Exception trying to save exception", th2);
                    }
                    try {
                        C2063am c2063am = C2144w.this.f949c;
                        C2121cq c2121cq = new C2121cq();
                        if (c2063am.f540f) {
                            ADLog.logVerbose("EventBus is shutdown; event ignored");
                        } else {
                            if (ADLog.isVerboseLoggingEnabled()) {
                                ADLog.logInfo(String.format("EventBus.postBlocking(%s, %d)", c2121cq, 1000L));
                            }
                            if (!c2063am.f537c.offer(c2121cq)) {
                                ADLog.log(2, "EventBus dropped event: %s", c2121cq);
                            } else {
                                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = c2063am.f538d;
                                if (scheduledThreadPoolExecutor == null) {
                                    ADLog.logInfo("EventBus.postBlocking() called before initialization complete, not posting now");
                                    c2063am.m562a(c2121cq);
                                } else {
                                    try {
                                        scheduledThreadPoolExecutor.schedule(c2063am.f536b, 0L, TimeUnit.NANOSECONDS).get(1000L, TimeUnit.MILLISECONDS);
                                    } catch (Throwable th3) {
                                        ADLog.logAgentError("Caught exception while trying to post event", th3);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        ADLog.logAgentError("Exception trying to notify agent of crash...", th4);
                    }
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = C2144w.this.f947a;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = C2144w.this.f947a;
                    if (uncaughtExceptionHandler2 != null) {
                        uncaughtExceptionHandler2.uncaughtException(thread, th);
                    }
                    throw th5;
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = c2144w.f947a;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC2131j m716a(AbstractC2131j abstractC2131j) {
        C2056af c2056af = this.f951e;
        if (c2056af != null) {
            abstractC2131j.f869b = c2056af.f506b.getAndIncrement();
        }
        C2127f c2127f = this.f952f;
        if (c2127f != null) {
            abstractC2131j.f870c = c2127f.m687a();
        }
        return abstractC2131j;
    }

    /* JADX INFO: renamed from: a */
    public final File m717a(Thread thread, Throwable th) {
        C2123cs c2123cs = new C2123cs();
        ADLog.log(2, "Writing crash report to disk from thread: [%s]", Thread.currentThread().getName());
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = (((runtime.totalMemory() - runtime.freeMemory()) >> 19) + 1) >> 1;
        ADLog.log(1, "usedMemory: %d MB", Long.valueOf(jFreeMemory));
        return m720b(new C2143v(th, thread, c2123cs, this.f948b, jFreeMemory));
    }

    /* JADX INFO: renamed from: b */
    public final File m720b(AbstractC2131j abstractC2131j) {
        File fileM713a = m713a(this.f955i);
        if (!fileM713a.exists()) {
            if (!fileM713a.mkdirs()) {
                ADLog.log(2, "Unable to create output directory %s. Crash reports not written", fileM713a);
                throw new IOException("Could not create output directory.");
            }
            ADLog.log(2, "Created output directory: %s", fileM713a);
        }
        String str = fileM713a + "/crash-" + System.currentTimeMillis();
        FileWriter fileWriter = null;
        try {
            File file = new File(str);
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                m716a(abstractC2131j).m695b(new JsonWriter(fileWriter2));
                fileWriter2.flush();
                ADLog.log(2, "Completed writing contents to file %s", str);
                C2124ct.m663a(fileWriter2);
                return file;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                C2124ct.m663a(fileWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m718a() throws Throwable {
        File fileM713a = m713a(this.f955i);
        if (!fileM713a.isDirectory()) {
            ADLog.log(1, "Crash Directory (%s) is not a directory, aborting read", fileM713a);
            return;
        }
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Contents of folder %s is = %s", fileM713a, Arrays.toString(fileM713a.list()));
        }
        File[] fileArrListFiles = fileM713a.listFiles(new FilenameFilter() { // from class: com.appdynamics.eumagent.runtime.private.w.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return str.startsWith("crash-");
            }
        });
        if (fileArrListFiles == null) {
            ADLog.log(1, "IO error while reading crash files from crash directory (%s), aborting read", fileM713a);
            return;
        }
        Arrays.sort(fileArrListFiles, C2124ct.f819a);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        for (File file : fileArrListFiles) {
            if (arrayList.size() >= 4) {
                int length = fileArrListFiles.length - 4;
                if (length <= 0) {
                    break;
                }
                ADLog.log(2, "Skipping %d crash reports", length);
                break;
            }
            ADLog.log(2, "Read contents of file %s", file);
            String strM714a = m714a(file, sb, cArr);
            if (strM714a == null || strM714a.isEmpty()) {
                ADLog.log(2, "Failure reading contents of file %s. Deleting it immediately", file);
                file.delete();
            } else {
                arrayList.add(strM714a);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ADLog.log(2, "Deleting contents of crash reports folder %s", fileM713a);
        for (File file2 : fileM713a.listFiles()) {
            file2.delete();
        }
        m719a(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public final void m719a(List<String> list) {
        LinkedList<C2145x.a> linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(this.f956j.m723a(it.next()));
        }
        m715b(linkedList);
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            this.f949c.m562a(new C2054ad(System.currentTimeMillis(), ((C2145x.a) it2.next()).f960a));
        }
        ADLog.log(2, "Total number of reports sent = %d", linkedList.size());
        if (this.f950d != null) {
            final LinkedList linkedList2 = new LinkedList();
            for (C2145x.a aVar : linkedList) {
                linkedList2.add(new CrashReportSummary(aVar.f961b, aVar.f966g, aVar.f967h));
            }
            if (linkedList2.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdynamics.eumagent.runtime.private.w.2
                @Override // java.lang.Runnable
                public final void run() {
                    ADLog.log(2, "Notifying CrashReportCallback with %d crashes", linkedList2.size());
                    C2144w.this.f950d.onCrashesReported(linkedList2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m715b(List<C2145x.a> list) {
        Integer num;
        String str;
        ArrayList<C2145x.a> arrayList = new ArrayList();
        for (C2145x.a aVar : list) {
            Integer num2 = aVar.f964e;
            if (num2 != null && num2.intValue() == 0 && "android.runtime.JavaProxyThrowable".equals(aVar.f966g) && (str = aVar.f963d) != null && str.startsWith("Thread[main") && aVar.f965f != null) {
                arrayList.add(aVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (C2145x.a aVar2 : arrayList) {
            for (C2145x.a aVar3 : list) {
                Integer num3 = aVar3.f964e;
                if (num3 != null && 1 == num3.intValue() && (num = aVar3.f962c) != null && num.intValue() == 1 && aVar3.f965f != null && aVar2.f965f.longValue() >= aVar3.f965f.longValue() && aVar2.f965f.longValue() - 1000 <= aVar3.f965f.longValue()) {
                    arrayList2.add(aVar2);
                    break;
                }
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            list.remove((C2145x.a) it.next());
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0013: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:8:0x0013 */
    /* JADX INFO: renamed from: a */
    private static String m714a(File file, StringBuilder sb, char[] cArr) throws Throwable {
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
                            C2124ct.m663a(fileReader);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        ADLog.logAgentError("Caught exception while trying to read a crash file", e);
                        sb.setLength(0);
                        C2124ct.m663a(fileReader);
                        return null;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileReader = null;
            } catch (Throwable th) {
                th = th;
                sb.setLength(0);
                C2124ct.m663a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            sb.setLength(0);
            C2124ct.m663a(closeable2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static File m713a(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + "/appdynamics/crash-reports");
    }
}
