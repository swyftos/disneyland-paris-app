package com.appdynamics.eumagent.runtime.p000private;

import android.os.SystemClock;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
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

/* loaded from: classes2.dex */
public final class bm implements am.b {
    private static final Comparator<File> e = new Comparator<File>() { // from class: com.appdynamics.eumagent.runtime.private.bm.1
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
    private final File a;
    private long b = 0;
    private int c = -1;
    private LinkedHashMap<String, bl> d = new LinkedHashMap<>();

    public bm(File file, am amVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.a = file;
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new a(this, (byte) 0), 60000L, 60000L, TimeUnit.MILLISECONDS);
        amVar.a.a(cq.class, this);
    }

    final synchronized void a(bl blVar) {
        bl blVarRemove = this.d.remove(blVar.a);
        if (blVarRemove != null) {
            ADLog.logVerbose("Using old same tile");
            this.d.put(blVarRemove.a, blVarRemove);
            return;
        }
        this.d.put(blVar.a, blVar);
        int size = this.d.size();
        int iD = d();
        ADLog.log(1, "Tiles in memory: %d", this.d.size());
        ADLog.log(1, "Tiles on disk: %d", iD);
        int i = size + iD;
        if (i > 256) {
            int i2 = i - 256;
            for (String str : c()) {
                if (i2 <= 0) {
                    break;
                }
                d(str);
                i2--;
            }
            if (i2 <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (bl blVar2 : this.d.values()) {
                if (i2 <= 0) {
                    break;
                }
                arrayList.add(blVar2.a);
                i2--;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b((String) it.next());
            }
        }
    }

    private synchronized void b(bl blVar) {
        String str;
        if (blVar.b == null) {
            ADLog.logAgentError("Tile.bitmap == null");
            return;
        }
        if (!this.a.exists()) {
            this.a.mkdirs();
        }
        File file = new File(this.a, "tile-" + blVar.a + ".jpg");
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Storing tile to: %s", file.getAbsolutePath());
        }
        if (!file.exists()) {
            this.c++;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(blVar.b);
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
                                file.setLastModified(System.currentTimeMillis());
                            }
                        }
                        file.setLastModified(System.currentTimeMillis());
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
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e = e5;
                        str = "Failed to close tile output stream";
                        ADLog.logAgentError(str, e);
                        file.setLastModified(System.currentTimeMillis());
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e6) {
                e = e6;
            }
        }
        file.setLastModified(System.currentTimeMillis());
    }

    final synchronized bl a(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return c(str);
    }

    private synchronized bl c(String str) {
        File file;
        file = new File(this.a, "tile-" + str + ".jpg");
        if (ADLog.isVerboseLoggingEnabled()) {
            ADLog.log(1, "Reading tile at: %s", file.getAbsolutePath());
        }
        try {
        } catch (Exception e2) {
            throw new RuntimeException("Failed to open tile input stream", e2);
        }
        return new bl(str, new FileInputStream(file));
    }

    final synchronized List<String> a() {
        List<String> listC;
        listC = c();
        listC.addAll(this.d.keySet());
        ADLog.log(1, "Total tiles returned: %d", listC.size());
        return listC;
    }

    private synchronized List<String> c() {
        File[] fileArrListFiles = this.a.listFiles();
        if (fileArrListFiles == null) {
            return new ArrayList();
        }
        Arrays.sort(fileArrListFiles, e);
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.isFile() && file.getName().startsWith("tile-") && file.getName().endsWith(".jpg")) {
                arrayList.add(file.getName().substring(5, r4.length() - 4));
            }
        }
        this.c = arrayList.size();
        ADLog.log(1, "Found %d tiles stored on disk", arrayList.size());
        return arrayList;
    }

    final synchronized void b(String str) {
        if (this.d.remove(str) != null) {
            this.b = SystemClock.uptimeMillis();
            ADLog.log(1, "Removing tile from memory: %s", str);
        } else {
            d(str);
        }
    }

    final synchronized void b() {
        try {
            LinkedHashMap<String, bl> linkedHashMap = this.d;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                this.d.clear();
            }
            File[] fileArrListFiles = this.a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    try {
                        file.delete();
                    } catch (Exception e2) {
                        ADLog.logAgentError("Error while deleting a tile during purge", e2);
                    }
                }
                this.c = 0;
            }
        } finally {
        }
    }

    private synchronized int d() {
        try {
            if (this.c == -1) {
                this.c = c().size();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        ADLog.logVerbose("Persisting all tiles now");
        Iterator<bl> it = this.d.values().iterator();
        while (it.hasNext()) {
            b(it.next());
            it.remove();
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(bm bmVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (bm.this.b + 60000 < SystemClock.uptimeMillis()) {
                ADLog.logVerbose("Persisting tiles due to lack of activity");
                bm.this.e();
            } else {
                ADLog.logVerbose("Not persisting tiles, due to too much activity");
            }
        }
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        if (obj instanceof cq) {
            e();
        }
    }

    private synchronized void d(String str) {
        this.b = SystemClock.uptimeMillis();
        this.c--;
        File file = new File(this.a, "tile-" + str + ".jpg");
        ADLog.log(1, "Deleting tile from disk: %s", file.getAbsolutePath());
        file.delete();
    }
}
