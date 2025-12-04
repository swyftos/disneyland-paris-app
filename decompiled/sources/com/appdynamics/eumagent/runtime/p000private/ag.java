package com.appdynamics.eumagent.runtime.p000private;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class ag {
    public final SQLiteDatabase a;
    final String b;
    private final int c;
    private final o.a d;

    public ag(ah ahVar, String str, o.a aVar, int i) {
        this.d = aVar;
        this.a = ahVar.getWritableDatabase();
        this.c = i;
        this.b = str;
    }

    public final boolean a(List<h> list) throws SQLException {
        if (list.isEmpty()) {
            return true;
        }
        Iterator<h> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (ah.a(this.a, this.b, it.next())) {
                z = true;
            }
        }
        if (z) {
            ah.a(this.a, this.b, this.c);
        }
        return list.isEmpty() || z;
    }

    public final List<o> a(int i) {
        try {
            return ah.a(this.a, this.b, i, this.d);
        } catch (IllegalStateException e) {
            ADLog.logAgentError("Failed to read persisted beacons", e);
            ah.a(this.a, this.b);
            return new ArrayList();
        }
    }
}
