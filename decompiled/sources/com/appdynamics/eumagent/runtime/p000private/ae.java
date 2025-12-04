package com.appdynamics.eumagent.runtime.p000private;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appdynamics.eumagent.runtime.logging.ADLog;

/* loaded from: classes2.dex */
public final class ae extends SQLiteOpenHelper {
    public ae(Context context) {
        super(context, "com.appdynamics.eumagent.runtime.db.metadata", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        onUpgrade(sQLiteDatabase, 0, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        ADLog.log(2, "SQLite MetaData DB upgrading from version %d to %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0) {
            if (i == 1) {
                return;
            } else {
                ADLog.log(2, "Unknown upgrade: %d to %d, resetting DB", Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
        ADLog.logVerbose("Setting up long table");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS longs");
        sQLiteDatabase.execSQL("CREATE TABLE longs (key VARCHAR(255) NOT NULL PRIMARY KEY, value BIGINT)");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS strings");
        sQLiteDatabase.execSQL("CREATE TABLE strings (key VARCHAR(255) NOT NULL PRIMARY KEY, value VARCHAR(255))");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS booleans");
        sQLiteDatabase.execSQL("CREATE TABLE booleans (key VARCHAR(255) NOT NULL PRIMARY KEY, value BOOLEAN)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        ADLog.log(2, "SQLite DB downgrading from version %d to %d", Integer.valueOf(i), Integer.valueOf(i2));
        onUpgrade(sQLiteDatabase, 0, 1);
    }

    public static String a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("strings", new String[]{"value"}, "key = ?", new String[]{str}, null, null, null, null);
        try {
            cursorQuery.moveToFirst();
            if (!cursorQuery.isAfterLast()) {
                return cursorQuery.getString(0);
            }
            cursorQuery.close();
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("longs", new String[]{"value"}, "key = ?", new String[]{str}, null, null, null, null);
        try {
            cursorQuery.moveToFirst();
            if (!cursorQuery.isAfterLast()) {
                return Long.valueOf(cursorQuery.getLong(0));
            }
            cursorQuery.close();
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    final synchronized boolean a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String str3) {
        try {
            if (sQLiteDatabase.update(str, contentValues, str2 + " = ?", new String[]{str3}) == 0) {
                sQLiteDatabase.insertOrThrow(str, null, contentValues);
            }
        } catch (SQLException e) {
            ADLog.logAgentError("Failed to write meta data: '" + str3 + "'", e);
            return false;
        }
        return true;
    }

    public static Boolean c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("booleans", new String[]{"value"}, "key = ?", new String[]{str}, null, null, null, null);
        try {
            cursorQuery.moveToFirst();
            if (!cursorQuery.isAfterLast()) {
                return Boolean.valueOf(cursorQuery.getInt(0) != 0);
            }
            cursorQuery.close();
            return null;
        } finally {
            cursorQuery.close();
        }
    }
}
