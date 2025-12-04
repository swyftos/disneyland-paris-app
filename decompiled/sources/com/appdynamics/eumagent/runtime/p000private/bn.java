package com.appdynamics.eumagent.runtime.p000private;

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

/* loaded from: classes2.dex */
public final class bn {
    final bm a;
    final ScheduledThreadPoolExecutor b;
    final bj c;
    private final q d;
    private final f e;

    public bn(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, bm bmVar, bj bjVar, q qVar, f fVar) {
        this.a = bmVar;
        this.b = scheduledThreadPoolExecutor;
        this.c = bjVar;
        this.d = qVar;
        this.e = fVar;
        scheduledThreadPoolExecutor.schedule(new b(this, (byte) 0), 30L, TimeUnit.SECONDS);
    }

    class a implements Runnable {
        private Bitmap[] a;
        private String[] b;

        a(String[] strArr, Bitmap[] bitmapArr) {
            this.b = strArr;
            this.a = bitmapArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ADLog.log(1, "Adding %d tiles to storage", this.b.length);
                HashSet hashSet = new HashSet();
                byte b = 0;
                int i = 0;
                while (true) {
                    Bitmap[] bitmapArr = this.a;
                    if (i < bitmapArr.length) {
                        Bitmap bitmap = bitmapArr[i];
                        if (!hashSet.contains(this.b[i])) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                            bn.this.a.a(new bl(this.b[i], byteArrayOutputStream.toByteArray()));
                            hashSet.add(this.b[i]);
                        } else {
                            ADLog.log(1, "Ignoring duplicate: %s", this.b[i]);
                        }
                        bitmap.recycle();
                        i++;
                    } else {
                        bn bnVar = bn.this;
                        bnVar.b.execute(new b(bnVar, b));
                        return;
                    }
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Failed to enqueue screenshots for upload", th);
            }
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(bn bnVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!bn.a(bn.this)) {
                    ADLog.logVerbose("Skipping tile upload because its not okay to upload now");
                    return;
                }
                ADLog.logVerbose("Checking which tiles need to be uploaded.");
                List<String> listA = bn.this.a.a();
                if (listA != null && !listA.isEmpty()) {
                    Set<String> setA = bn.this.c.a(listA);
                    if (setA != null) {
                        ADLog.log(1, "Found %d tiles to upload.", setA.size());
                        LinkedList linkedList = new LinkedList();
                        for (String str : listA) {
                            if (setA.contains(str)) {
                                linkedList.add(str);
                            } else {
                                bn.this.a.b(str);
                            }
                        }
                        bn bnVar = bn.this;
                        bnVar.b.execute(bnVar.new c(linkedList));
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

    class c implements Runnable {
        private List<String> a;

        c(List<String> list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!bn.a(bn.this)) {
                ADLog.logVerbose("Skipping tile upload because its not okay to upload now");
                return;
            }
            if (this.a.isEmpty()) {
                ADLog.logVerbose("No tiles to upload");
            }
            try {
                List<String> list = this.a;
                ArrayList<List<String>> arrayList = new ArrayList();
                int size = list.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 16;
                    arrayList.add(new ArrayList(list.subList(i, Math.min(size, i2))));
                    i = i2;
                }
                for (List<String> list2 : arrayList) {
                    bn bnVar = bn.this;
                    bnVar.c.a(bnVar.a, list2);
                }
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    bn.this.a.b(it.next());
                }
            } catch (RuntimeException e) {
                ADLog.logAgentError("Failed to upload tiles", e);
            }
        }
    }

    static /* synthetic */ boolean a(bn bnVar) {
        e eVarA = bnVar.e.a();
        if (eVarA == null || "offline".equals(eVarA.g) || "unknown".equals(eVarA.g) || "unavailable".equals(eVarA.g)) {
            return false;
        }
        if (bnVar.d.a.b.booleanValue()) {
            return true;
        }
        return ("2g".equals(eVarA.g) || "3g".equals(eVarA.g) || "4g".equals(eVarA.g) || "5g".equals(eVarA.g) || "mobile".equals(eVarA.g)) ? false : true;
    }
}
