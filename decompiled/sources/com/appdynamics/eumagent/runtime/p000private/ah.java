package com.appdynamics.eumagent.runtime.p000private;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class ah extends SQLiteOpenHelper {
    private final Context a;

    public ah(Context context) {
        super(context, "com.appdynamics.eumagent.runtime.db.v2", (SQLiteDatabase.CursorFactory) null, 2);
        this.a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        onUpgrade(sQLiteDatabase, 0, 2);
        if (this.a.getDatabasePath("com.appdynamics.eumagent.runtime.db").exists()) {
            ADLog.logInfo("Migrating old beacon table");
            try {
                try {
                    SQLiteDatabase readableDatabase = new ai(this.a).getReadableDatabase();
                    List<o> listA = ai.a(readableDatabase);
                    Iterator<o> it = listA.iterator();
                    while (it.hasNext()) {
                        a(sQLiteDatabase, "beacons", it.next());
                    }
                    ADLog.log(2, "Migrated %d beacons", listA.size());
                    readableDatabase.close();
                } catch (Exception e) {
                    ADLog.logAgentError("Failed to migrate old beacons", e);
                }
                this.a.deleteDatabase("com.appdynamics.eumagent.runtime.db");
            } catch (Throwable th) {
                this.a.deleteDatabase("com.appdynamics.eumagent.runtime.db");
                throw th;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
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
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        ADLog.log(2, "SQLite Beacon downgrading from version %d to %d", Integer.valueOf(i), Integer.valueOf(i2));
        onUpgrade(sQLiteDatabase, 0, 2);
    }

    static boolean a(SQLiteDatabase sQLiteDatabase, String str, h hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(hVar.a));
        contentValues.put("data", hVar.a());
        try {
            return sQLiteDatabase.insertOrThrow(str, null, contentValues) != -1;
        } catch (SQLException e) {
            ADLog.logAgentError("Failed to add beacon", e);
            return false;
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, String str, int i) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("DELETE FROM " + str + " WHERE ROWID IN (SELECT ROWID FROM " + str + " ORDER BY timestamp DESC LIMIT -1 OFFSET " + i + ")");
        int iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
        sQLiteStatementCompileStatement.close();
        ADLog.log(1, "Dropped %d old beacons from db.", iExecuteUpdateDelete);
    }

    static List<o> a(SQLiteDatabase sQLiteDatabase, String str, int i, o.a aVar) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query(str, null, null, null, null, null, "timestamp DESC", i > 0 ? Integer.toString(i) : null);
        try {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                arrayList.add(aVar.a(cursorQuery.getLong(0), cursorQuery.getString(1)));
                cursorQuery.moveToNext();
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete(str, null, null);
    }
}
