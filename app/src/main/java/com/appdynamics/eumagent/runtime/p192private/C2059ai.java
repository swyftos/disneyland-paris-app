package com.appdynamics.eumagent.runtime.p192private;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ai */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class C2059ai extends SQLiteOpenHelper {
    public C2059ai(Context context) {
        super(context, "com.appdynamics.eumagent.runtime.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE metrics (timestamp INTEGER, data TEXT NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE metric_stats (stat_name TEXT NOT NULL, stat_value INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS metrics");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS metric_stats");
        onCreate(sQLiteDatabase);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    static List<C2136o> m543a(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query("metrics", null, null, null, null, null, "timestamp DESC", null);
        try {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                arrayList.add(new C2136o(cursorQuery.getLong(0), cursorQuery.getString(1)));
                cursorQuery.moveToNext();
            }
        } catch (IllegalStateException e) {
            ADLog.logAgentError("Failed to read persisted beacons", e);
        } finally {
            cursorQuery.close();
        }
        return arrayList;
    }
}
