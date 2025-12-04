package net.sqlcipher.database;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorRequeried(android.database.Cursor cursor) {
    }

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) throws Throwable {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, objArr);
        try {
            sQLiteQuery.bindArguments(objArr);
            if (cursorFactory == null) {
                this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            } else {
                this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            }
            this.mQuery = sQLiteQuery;
            try {
                return this.mCursor;
            } catch (Throwable th) {
                th = th;
                sQLiteQuery = null;
                if (sQLiteQuery != null) {
                    sQLiteQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    @Override // net.sqlcipher.database.SQLiteCursorDriver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public net.sqlcipher.Cursor query(net.sqlcipher.database.SQLiteDatabase.CursorFactory r5, java.lang.String[] r6) throws java.lang.Throwable {
        /*
            r4 = this;
            net.sqlcipher.database.SQLiteQuery r0 = new net.sqlcipher.database.SQLiteQuery
            net.sqlcipher.database.SQLiteDatabase r1 = r4.mDatabase
            java.lang.String r2 = r4.mSql
            r3 = 0
            r0.<init>(r1, r2, r3, r6)
            if (r6 != 0) goto Le
            r1 = r3
            goto Lf
        Le:
            int r1 = r6.length     // Catch: java.lang.Throwable -> L1a
        Lf:
            if (r3 >= r1) goto L1c
            int r2 = r3 + 1
            r3 = r6[r3]     // Catch: java.lang.Throwable -> L1a
            r0.bindString(r2, r3)     // Catch: java.lang.Throwable -> L1a
            r3 = r2
            goto Lf
        L1a:
            r4 = move-exception
            goto L3b
        L1c:
            if (r5 != 0) goto L2a
            net.sqlcipher.database.SQLiteCursor r5 = new net.sqlcipher.database.SQLiteCursor     // Catch: java.lang.Throwable -> L1a
            net.sqlcipher.database.SQLiteDatabase r6 = r4.mDatabase     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = r4.mEditTable     // Catch: java.lang.Throwable -> L1a
            r5.<init>(r6, r4, r1, r0)     // Catch: java.lang.Throwable -> L1a
            r4.mCursor = r5     // Catch: java.lang.Throwable -> L1a
            goto L34
        L2a:
            net.sqlcipher.database.SQLiteDatabase r6 = r4.mDatabase     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = r4.mEditTable     // Catch: java.lang.Throwable -> L1a
            net.sqlcipher.Cursor r5 = r5.newCursor(r6, r4, r1, r0)     // Catch: java.lang.Throwable -> L1a
            r4.mCursor = r5     // Catch: java.lang.Throwable -> L1a
        L34:
            r4.mQuery = r0     // Catch: java.lang.Throwable -> L1a
            net.sqlcipher.Cursor r4 = r4.mCursor     // Catch: java.lang.Throwable -> L39
            return r4
        L39:
            r4 = move-exception
            r0 = 0
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDirectCursorDriver.query(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String[]):net.sqlcipher.Cursor");
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void cursorClosed() {
        this.mCursor = null;
    }

    @Override // net.sqlcipher.database.SQLiteCursorDriver
    public void setBindArguments(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            this.mQuery.bindString(i2, strArr[i]);
            i = i2;
        }
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
