package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bm */
/* JADX INFO: loaded from: classes2.dex */
public final class C2090bm implements C2063am.b {

    /* JADX INFO: renamed from: e */
    private static final Comparator<File> f681e = new Comparator<File>() { // from class: com.appdynamics.eumagent.runtime.private.bm.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() < file4.lastModified()) {
                return -1;
            }
            return file3.lastModified() > file4.lastModified() ? 1 : 0;
        }
    };

    /* JADX INFO: renamed from: a */
    private final File f682a;

    /* JADX INFO: renamed from: b */
    private long f683b = 0;

    /* JADX INFO: renamed from: c */
    private int f684c = -1;

    /* JADX INFO: renamed from: d */
    private LinkedHashMap<String, C2089bl> f685d = new LinkedHashMap<>();

    public C2090bm(File file, C2063am c2063am, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f682a = file;
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new a(this, (byte) 0), 60000L, 60000L, TimeUnit.MILLISECONDS);
        c2063am.f535a.m656a(C2121cq.class, this);
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m615a(C2089bl c2089bl) {
        C2089bl c2089blRemove = this.f685d.remove(c2089bl.f678a);
        if (c2089blRemove != null) {
            ADLog.logVerbose("Using old same tile");
            this.f685d.put(c2089blRemove.f678a, c2089blRemove);
            return;
        }
        this.f685d.put(c2089bl.f678a, c2089bl);
        int size = this.f685d.size();
        int iM610d = m610d();
        ADLog.log(1, "Tiles in memory: %d", this.f685d.size());
        ADLog.log(1, "Tiles on disk: %d", iM610d);
        int i = size + iM610d;
        if (i > 256) {
            int i2 = i - 256;
            for (String str : m609c()) {
                if (i2 <= 0) {
                    break;
                }
                m611d(str);
                i2--;
            }
            if (i2 <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (C2089bl c2089bl2 : this.f685d.values()) {
                if (i2 <= 0) {
                    break;
                }
                arrayList.add(c2089bl2.f678a);
                i2--;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m617b((String) it.next());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private synchronized void m606b(C2089bl c2089bl) {
        String str;
        if (c2089bl.f679b == null) {
            ADLog.logAgentError("Tile.bitmap == null");
            return;
        }
        if (!this.f682a.exists()) {
            this.f682a.mkdirs();
        }
        File file = new File(this.f682a, "tile-" + c2089bl.f678a + ".jpg");
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Storing tile to: %s", file.getAbsolutePath());
        }
        if (!file.exists()) {
            this.f684c++;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(c2089bl.f679b);
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                            e = e;
                            str = "Failed to close tile output stream";
                            ADLog.logAgentError(str, e);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        ADLog.logAgentError("Failed to put tile", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e = e3;
                                str = "Failed to close tile output stream";
                                ADLog.logAgentError(str, e);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                ADLog.logAgentError("Failed to close tile output stream", e4);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        file.setLastModified(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: a */
    final synchronized C2089bl m613a(String str) {
        if (this.f685d.containsKey(str)) {
            return this.f685d.get(str);
        }
        return m608c(str);
    }

    /* JADX INFO: renamed from: c */
    private synchronized C2089bl m608c(String str) {
        File file;
        file = new File(this.f682a, "tile-" + str + ".jpg");
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Reading tile at: %s", file.getAbsolutePath());
        }
        try {
        } catch (Exception e) {
            throw new RuntimeException("Failed to open tile input stream", e);
        }
        return new C2089bl(str, new FileInputStream(file));
    }

    /* JADX INFO: renamed from: a */
    final synchronized List<String> m614a() {
        List<String> listM609c;
        listM609c = m609c();
        listM609c.addAll(this.f685d.keySet());
        ADLog.log(1, "Total tiles returned: %d", listM609c.size());
        return listM609c;
    }

    /* JADX INFO: renamed from: c */
    private synchronized List<String> m609c() {
        File[] fileArrListFiles = this.f682a.listFiles();
        if (fileArrListFiles == null) {
            return new ArrayList();
        }
        Arrays.sort(fileArrListFiles, f681e);
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.isFile() && file.getName().startsWith("tile-") && file.getName().endsWith(".jpg")) {
                String name = file.getName();
                arrayList.add(name.substring(5, name.length() - 4));
            }
        }
        this.f684c = arrayList.size();
        ADLog.log(1, "Found %d tiles stored on disk", arrayList.size());
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    final synchronized void m617b(String str) {
        if (this.f685d.remove(str) != null) {
            this.f683b = SystemClock.uptimeMillis();
            ADLog.log(1, "Removing tile from memory: %s", str);
        } else {
            m611d(str);
        }
    }

    /* JADX INFO: renamed from: b */
    final synchronized void m616b() {
        try {
            LinkedHashMap<String, C2089bl> linkedHashMap = this.f685d;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                this.f685d.clear();
            }
            File[] fileArrListFiles = this.f682a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    try {
                        file.delete();
                    } catch (Exception e) {
                        ADLog.logAgentError("Error while deleting a tile during purge", e);
                    }
                }
                this.f684c = 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    private synchronized int m610d() {
        try {
            if (this.f684c == -1) {
                this.f684c = m609c().size();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f684c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public synchronized void m612e() {
        ADLog.logVerbose("Persisting all tiles now");
        Iterator<C2089bl> it = this.f685d.values().iterator();
        while (it.hasNext()) {
            m606b(it.next());
            it.remove();
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bm$a */
    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(C2090bm c2090bm, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (C2090bm.this.f683b + 60000 < SystemClock.uptimeMillis()) {
                ADLog.logVerbose("Persisting tiles due to lack of activity");
                C2090bm.this.m612e();
            } else {
                ADLog.logVerbose("Not persisting tiles, due to too much activity");
            }
        }
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        if (obj instanceof C2121cq) {
            m612e();
        }
    }

    /* JADX INFO: renamed from: d */
    private synchronized void m611d(String str) {
        this.f683b = SystemClock.uptimeMillis();
        this.f684c--;
        File file = new File(this.f682a, "tile-" + str + ".jpg");
        ADLog.log(1, "Deleting tile from disk: %s", file.getAbsolutePath());
        file.delete();
    }
}
