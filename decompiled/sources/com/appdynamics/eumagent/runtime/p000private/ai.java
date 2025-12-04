package com.appdynamics.eumagent.runtime.p000private;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public final class ai extends SQLiteOpenHelper {
    public ai(Context context) {
        super(context, "com.appdynamics.eumagent.runtime.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE metrics (timestamp INTEGER, data TEXT NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE metric_stats (stat_name TEXT NOT NULL, stat_value INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS metrics");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS metric_stats");
        onCreate(sQLiteDatabase);
    }

    @Deprecated
    static List<o> a(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query("metrics", null, null, null, null, null, "timestamp DESC", null);
        try {
            try {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    arrayList.add(new o(cursorQuery.getLong(0), cursorQuery.getString(1)));
                    cursorQuery.moveToNext();
                }
            } catch (IllegalStateException e) {
                ADLog.logAgentError("Failed to read persisted beacons", e);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}
