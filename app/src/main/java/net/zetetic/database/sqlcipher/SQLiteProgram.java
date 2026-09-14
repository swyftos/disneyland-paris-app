package net.zetetic.database.sqlcipher;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import androidx.sqlite.p009db.SupportSQLiteProgram;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Object[] mBindArgs;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        String strTrim = str.trim();
        this.mSql = strTrim;
        int sqlStatementType = DatabaseUtils.getSqlStatementType(strTrim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.mReadOnly = false;
            this.mColumnNames = EMPTY_STRING_ARRAY;
            this.mNumParameters = 0;
        } else {
            boolean z = sqlStatementType == 1;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            sQLiteDatabase.getThreadSession().prepare(strTrim, sQLiteDatabase.getThreadDefaultConnectionFlags(z), cancellationSignal, sQLiteStatementInfo);
            this.mReadOnly = sQLiteStatementInfo.readOnly;
            this.mColumnNames = sQLiteStatementInfo.columnNames;
            this.mNumParameters = sQLiteStatementInfo.numParameters;
        }
        if (objArr != null && objArr.length > this.mNumParameters) {
            throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
        }
        int i = this.mNumParameters;
        if (i != 0) {
            Object[] objArr2 = new Object[i];
            this.mBindArgs = objArr2;
            if (objArr != null) {
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return;
            }
            return;
        }
        this.mBindArgs = null;
    }

    final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    String getSql() {
        return this.mSql;
    }

    final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    final String[] getColumnNames() {
        return this.mColumnNames;
    }

    protected final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    protected final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    protected final void onCorruption(SQLiteException sQLiteException) {
        this.mDatabase.onCorruption(sQLiteException);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void bindNull(int i) {
        bind(i, null);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        bind(i, Long.valueOf(j));
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        bind(i, Double.valueOf(d));
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        bind(i, str);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        }
        bind(i, bArr);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteProgram
    public void clearBindings() {
        Object[] objArr = this.mBindArgs;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    public void bindAllArgs(Object... objArr) {
        if (objArr != null) {
            for (int length = objArr.length; length != 0; length--) {
                bind(length, objArr[length - 1]);
            }
        }
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    protected void onAllReferencesReleased() {
        clearBindings();
    }

    private void bind(int i, Object obj) {
        if (i < 1 || i > this.mNumParameters) {
            throw new IllegalArgumentException("Cannot bind argument at index " + i + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
        }
        this.mBindArgs[i - 1] = obj;
    }
}
