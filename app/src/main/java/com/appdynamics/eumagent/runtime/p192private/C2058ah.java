package com.appdynamics.eumagent.runtime.p192private;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ah */
/* JADX INFO: loaded from: classes2.dex */
public final class C2058ah extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private final Context f515a;

    public C2058ah(Context context) {
        super(context, "com.appdynamics.eumagent.runtime.db.v2", (SQLiteDatabase.CursorFactory) null, 2);
        this.f515a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        onUpgrade(sQLiteDatabase, 0, 2);
        if (this.f515a.getDatabasePath("com.appdynamics.eumagent.runtime.db").exists()) {
            ADLog.logInfo("Migrating old beacon table");
            try {
                try {
                    SQLiteDatabase readableDatabase = new C2059ai(this.f515a).getReadableDatabase();
                    List<C2136o> listM543a = C2059ai.m543a(readableDatabase);
                    Iterator<C2136o> it = listM543a.iterator();
                    while (it.hasNext()) {
                        m542a(sQLiteDatabase, "beacons", it.next());
                    }
                    ADLog.log(2, "Migrated %d beacons", listM543a.size());
                    readableDatabase.close();
                } catch (Exception e) {
                    ADLog.logAgentError("Failed to migrate old beacons", e);
                }
            } finally {
                this.f515a.deleteDatabase("com.appdynamics.eumagent.runtime.db");
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ADLog.log(2, "SQLite DB upgrading from version %d to %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            ADLog.logVerbose("Setting up beacon table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS beacons");
            sQLiteDatabase.execSQL("CREATE TABLE beacons (timestamp INTEGER, data TEXT NOT NULL)");
        } else if (i != 1) {
            if (i == 2) {
                return;
            }
            ADLog.log(2, "Unknown upgrade: %d to %d, resetting DB", Integer.valueOf(i), Integer.valueOf(i2));
            ADLog.logVerbose("Setting up beacon table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS beacons");
            sQLiteDatabase.execSQL("CREATE TABLE beacons (timestamp INTEGER, data TEXT NOT NULL)");
        }
        ADLog.logVerbose("Setting up crash beacon table");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash_beacons");
        sQLiteDatabase.execSQL("CREATE TABLE crash_beacons (timestamp INTEGER, data TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ADLog.log(2, "SQLite Beacon downgrading from version %d to %d", Integer.valueOf(i), Integer.valueOf(i2));
        onUpgrade(sQLiteDatabase, 0, 2);
    }

    /* JADX INFO: renamed from: a */
    static boolean m542a(SQLiteDatabase sQLiteDatabase, String str, AbstractC2129h abstractC2129h) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(abstractC2129h.f859a));
        contentValues.put("data", abstractC2129h.mo692a());
        try {
            return sQLiteDatabase.insertOrThrow(str, null, contentValues) != -1;
        } catch (SQLException e) {
            ADLog.logAgentError("Failed to add beacon", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m541a(SQLiteDatabase sQLiteDatabase, String str, int i) {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("DELETE FROM " + str + " WHERE ROWID IN (SELECT ROWID FROM " + str + " ORDER BY timestamp DESC LIMIT -1 OFFSET " + i + ")");
        int iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
        sQLiteStatementCompileStatement.close();
        ADLog.log(1, "Dropped %d old beacons from db.", iExecuteUpdateDelete);
    }

    /* JADX INFO: renamed from: a */
    static List<C2136o> m539a(SQLiteDatabase sQLiteDatabase, String str, int i, C2136o.a aVar) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query(str, null, null, null, null, null, "timestamp DESC", i > 0 ? Integer.toString(i) : null);
        try {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                arrayList.add(aVar.mo525a(cursorQuery.getLong(0), cursorQuery.getString(1)));
                cursorQuery.moveToNext();
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m540a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete(str, null, null);
    }
}
