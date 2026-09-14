package com.appdynamics.eumagent.runtime.p192private;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.tagcommander.lib.p193serverside.ETCPurchaseStatus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bp */
/* JADX INFO: loaded from: classes2.dex */
public final class C2093bp implements C2063am.b {

    /* JADX INFO: renamed from: c */
    private final C2063am f704c;

    /* JADX INFO: renamed from: d */
    private final C2138q f705d;

    /* JADX INFO: renamed from: e */
    private int f706e;

    /* JADX INFO: renamed from: f */
    private int f707f;

    /* JADX INFO: renamed from: b */
    private final SparseArray<List<C2092bo>> f703b = new SparseArray<>();

    /* JADX INFO: renamed from: g */
    private View f708g = null;

    /* JADX INFO: renamed from: h */
    private C2123cs f709h = null;

    /* JADX INFO: renamed from: i */
    private String f710i = null;

    /* JADX INFO: renamed from: j */
    private String f711j = null;

    /* JADX INFO: renamed from: k */
    private long f712k = 0;

    /* JADX INFO: renamed from: a */
    long f702a = 0;

    public C2093bp(C2063am c2063am, C2138q c2138q) {
        this.f705d = c2138q;
        this.f704c = c2063am;
        c2063am.f535a.m656a(C2081bd.class, this);
        c2063am.f535a.m656a(C2082be.class, this);
        c2063am.m562a(new C2063am.d(new a(), 30000L, 30000L));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        int i = 0;
        if (obj instanceof C2081bd) {
            C2081bd c2081bd = (C2081bd) obj;
            C2138q c2138q = this.f705d;
            if (c2138q.m708a() && c2138q.f902a.f908c.booleanValue()) {
                int i2 = 1;
                if (this.f707f == 0 || this.f706e == 0) {
                    this.f706e = this.f708g.getWidth();
                    this.f707f = this.f708g.getHeight();
                    ADLog.log(1, "viewWidth: %d, viewHeight: %d", Integer.valueOf(this.f706e), Integer.valueOf(this.f707f));
                    if (this.f707f == 0 || this.f706e == 0) {
                        ADLog.logAgentError("View size is zero, even when a touch is happening");
                        return;
                    }
                }
                MotionEvent motionEvent = c2081bd.f641a;
                long eventTime = motionEvent.getEventTime();
                if (this.f709h == null) {
                    this.f709h = new C2123cs(eventTime, System.currentTimeMillis() - (SystemClock.uptimeMillis() - eventTime));
                }
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int actionMasked = motionEvent.getActionMasked();
                long j = eventTime - this.f709h.f817a;
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                while (i < pointerCount) {
                    int pointerId = motionEvent.getPointerId(i);
                    List<C2092bo> arrayList = this.f703b.get(pointerId);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.f703b.put(pointerId, arrayList);
                    }
                    motionEvent.getPointerCoords(i, pointerCoords);
                    C2092bo c2092bo = new C2092bo();
                    c2092bo.f698a = j;
                    c2092bo.f700c = pointerCoords.x / this.f706e;
                    c2092bo.f701d = pointerCoords.y / this.f707f;
                    String str = "moved";
                    if (i == actionIndex) {
                        if (actionMasked == 0) {
                            str = "began";
                        } else if (actionMasked == i2) {
                            str = "ended";
                        } else if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                str = ETCPurchaseStatus.CANCELED;
                            } else if (actionMasked == 5) {
                                str = "began";
                            } else if (actionMasked == 6 || actionMasked == 9) {
                                str = "ended";
                            }
                        }
                        c2092bo.f699b = str;
                    } else {
                        c2092bo.f699b = "moved";
                    }
                    arrayList.add(c2092bo);
                    this.f712k++;
                    i++;
                    i2 = 1;
                }
                if (actionMasked == 0) {
                    this.f710i = c2081bd.f642b;
                    this.f711j = c2081bd.f643c;
                    return;
                } else {
                    if (actionMasked == 1 || actionMasked == 3 || this.f712k >= 1000) {
                        m619a();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (obj instanceof C2082be) {
            this.f708g = ((C2082be) obj).f644a;
            this.f706e = 0;
            this.f707f = 0;
            m619a();
            this.f710i = null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m619a() {
        if (this.f710i == null && this.f711j == null) {
            ADLog.logVerbose("Current screenshot == null, no need to beaconize touches");
            return;
        }
        int size = this.f703b.size();
        if (size != 0) {
            ADLog.log(1, "Beaconizing %d tracks", size);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                List<C2092bo> listValueAt = this.f703b.valueAt(i);
                arrayList.add(listValueAt);
                if (ADLog.isVerboseLoggingEnabled()) {
                    ADLog.log(1, "Track #%d has %d points", Integer.valueOf(i), Integer.valueOf(listValueAt.size()));
                }
            }
            this.f704c.m562a(new C2094bq(this.f709h, arrayList, this.f710i, this.f711j));
        } else {
            ADLog.logVerbose("Not flushing touches because none recorded since last flush");
        }
        this.f703b.clear();
        this.f709h = null;
        this.f702a = SystemClock.uptimeMillis();
        this.f712k = 0L;
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bp$a */
    class a implements Runnable {
        a() {
        }

        public final String toString() {
            return "FlushTouchesRunnable";
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SystemClock.uptimeMillis() > C2093bp.this.f702a + 30000) {
                ADLog.logVerbose("Triggering periodic touch flush");
                C2093bp.this.m619a();
            } else {
                ADLog.logVerbose("Not triggering periodic touch flush, not enough time has passed");
            }
        }
    }
}
