package com.appdynamics.eumagent.runtime.p192private;

import android.graphics.Bitmap;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bn */
/* JADX INFO: loaded from: classes2.dex */
public final class C2091bn {

    /* JADX INFO: renamed from: a */
    final C2090bm f687a;

    /* JADX INFO: renamed from: b */
    final ScheduledThreadPoolExecutor f688b;

    /* JADX INFO: renamed from: c */
    final C2087bj f689c;

    /* JADX INFO: renamed from: d */
    private final C2138q f690d;

    /* JADX INFO: renamed from: e */
    private final C2127f f691e;

    public C2091bn(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, C2090bm c2090bm, C2087bj c2087bj, C2138q c2138q, C2127f c2127f) {
        this.f687a = c2090bm;
        this.f688b = scheduledThreadPoolExecutor;
        this.f689c = c2087bj;
        this.f690d = c2138q;
        this.f691e = c2127f;
        scheduledThreadPoolExecutor.schedule(new b(this, (byte) 0), 30L, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bn$a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a */
        private Bitmap[] f692a;

        /* JADX INFO: renamed from: b */
        private String[] f693b;

        a(String[] strArr, Bitmap[] bitmapArr) {
            this.f693b = strArr;
            this.f692a = bitmapArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ADLog.log(1, "Adding %d tiles to storage", this.f693b.length);
                HashSet hashSet = new HashSet();
                byte b = 0;
                int i = 0;
                while (true) {
                    Bitmap[] bitmapArr = this.f692a;
                    if (i < bitmapArr.length) {
                        Bitmap bitmap = bitmapArr[i];
                        if (!hashSet.contains(this.f693b[i])) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                            C2091bn.this.f687a.m615a(new C2089bl(this.f693b[i], byteArrayOutputStream.toByteArray()));
                            hashSet.add(this.f693b[i]);
                        } else {
                            ADLog.log(1, "Ignoring duplicate: %s", this.f693b[i]);
                        }
                        bitmap.recycle();
                        i++;
                    } else {
                        C2091bn c2091bn = C2091bn.this;
                        c2091bn.f688b.execute(new b(c2091bn, b));
                        return;
                    }
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to enqueue screenshots for upload", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bn$b */
    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(C2091bn c2091bn, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!C2091bn.m618a(C2091bn.this)) {
                    ADLog.logVerbose("Skipping tile upload because its not okay to upload now");
                    return;
                }
                ADLog.logVerbose("Checking which tiles need to be uploaded.");
                List<String> listM614a = C2091bn.this.f687a.m614a();
                if (listM614a != null && !listM614a.isEmpty()) {
                    Set<String> setM603a = C2091bn.this.f689c.m603a(listM614a);
                    if (setM603a != null) {
                        ADLog.log(1, "Found %d tiles to upload.", setM603a.size());
                        LinkedList linkedList = new LinkedList();
                        for (String str : listM614a) {
                            if (setM603a.contains(str)) {
                                linkedList.add(str);
                            } else {
                                C2091bn.this.f687a.m617b(str);
                            }
                        }
                        C2091bn c2091bn = C2091bn.this;
                        c2091bn.f688b.execute(c2091bn.new c(linkedList));
                        return;
                    }
                    return;
                }
                ADLog.logVerbose("No hashes found.");
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to upload tiles", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bn$c */
    class c implements Runnable {

        /* JADX INFO: renamed from: a */
        private List<String> f696a;

        c(List<String> list) {
            this.f696a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!C2091bn.m618a(C2091bn.this)) {
                ADLog.logVerbose("Skipping tile upload because its not okay to upload now");
                return;
            }
            if (this.f696a.isEmpty()) {
                ADLog.logVerbose("No tiles to upload");
            }
            try {
                List<String> list = this.f696a;
                ArrayList<List<String>> arrayList = new ArrayList();
                int size = list.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 16;
                    arrayList.add(new ArrayList(list.subList(i, Math.min(size, i2))));
                    i = i2;
                }
                for (List<String> list2 : arrayList) {
                    C2091bn c2091bn = C2091bn.this;
                    c2091bn.f689c.m604a(c2091bn.f687a, list2);
                }
                Iterator<String> it = this.f696a.iterator();
                while (it.hasNext()) {
                    C2091bn.this.f687a.m617b(it.next());
                }
            } catch (RuntimeException e) {
                ADLog.logAgentError("Failed to upload tiles", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m618a(C2091bn c2091bn) {
        C2126e c2126eM687a = c2091bn.f691e.m687a();
        if (c2126eM687a == null || "offline".equals(c2126eM687a.f831g) || "unknown".equals(c2126eM687a.f831g) || "unavailable".equals(c2126eM687a.f831g)) {
            return false;
        }
        if (c2091bn.f690d.f902a.f907b.booleanValue()) {
            return true;
        }
        return ("2g".equals(c2126eM687a.f831g) || "3g".equals(c2126eM687a.f831g) || "4g".equals(c2126eM687a.f831g) || "5g".equals(c2126eM687a.f831g) || "mobile".equals(c2126eM687a.f831g)) ? false : true;
    }
}
