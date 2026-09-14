package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.ParcelFileDescriptor;
import androidx.sqlite.p009db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public void executeRaw() {
        acquireReference();
        try {
            try {
                getSession().executeRaw(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteStatement
    public void execute() {
        acquireReference();
        try {
            try {
                getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        acquireReference();
        try {
            try {
                int iExecuteForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
                return iExecuteForChangedRowCount;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteStatement
    public long executeInsert() {
        acquireReference();
        try {
            try {
                long jExecuteForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
                return jExecuteForLastInsertedRowId;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        acquireReference();
        try {
            try {
                long jExecuteForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
                return jExecuteForLong;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteStatement
    public String simpleQueryForString() {
        acquireReference();
        try {
            try {
                String strExecuteForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
                return strExecuteForString;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        acquireReference();
        try {
            try {
                ParcelFileDescriptor parcelFileDescriptorExecuteForBlobFileDescriptor = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), null);
                releaseReference();
                return parcelFileDescriptorExecuteForBlobFileDescriptor;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption(e);
                throw e;
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
