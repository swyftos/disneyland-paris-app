package net.zetetic.database.sqlcipher;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import androidx.sqlite.p009db.SupportSQLiteOpenHelper;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.Logger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final SQLiteDatabaseHook mDatabaseHook;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final int mMinimumSupportedVersion;
    private final String mName;
    private final int mNewVersion;
    private byte[] mPassword;

    public void onBeforeDelete(SQLiteDatabase sQLiteDatabase) {
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, cursorFactory, i, 0, databaseErrorHandler);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, int i2, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, new byte[0], cursorFactory, i, i2, databaseErrorHandler, (SQLiteDatabaseHook) null, false);
    }

    public SQLiteOpenHelper(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i, int i2, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z) {
        this(context, str, getBytes(str2), cursorFactory, i, i2, databaseErrorHandler, sQLiteDatabaseHook, z);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, SQLiteDatabase.CursorFactory cursorFactory, int i, int i2, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z) {
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        this.mContext = context;
        this.mName = str;
        this.mPassword = bArr;
        this.mFactory = cursorFactory;
        this.mNewVersion = i;
        this.mErrorHandler = databaseErrorHandler;
        this.mDatabaseHook = sQLiteDatabaseHook;
        this.mEnableWriteAheadLogging = z;
        this.mMinimumSupportedVersion = Math.max(0, i2);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    /* JADX INFO: renamed from: getDatabaseName */
    public String getName() {
        return this.mName;
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                        if (z) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                    }
                    this.mEnableWriteAheadLogging = z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    private SQLiteDatabase getDatabaseLocked(boolean z) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z || !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase = this.mDatabase;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabaseOpenDatabase != null) {
                if (z && sQLiteDatabaseOpenDatabase.isReadOnly()) {
                    sQLiteDatabaseOpenDatabase.reopenReadWrite();
                }
            } else {
                String path = this.mName;
                if (path == null) {
                    sQLiteDatabaseOpenDatabase = SQLiteDatabase.create(null);
                } else {
                    try {
                        if (!path.startsWith("file:")) {
                            path = this.mContext.getDatabasePath(path).getPath();
                        }
                        String str = path;
                        File file = new File(new File(str).getParent());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(str, this.mPassword, this.mFactory, this.mEnableWriteAheadLogging ? 805306368 : 268435456, this.mErrorHandler, this.mDatabaseHook);
                    } catch (SQLiteException e) {
                        if (z) {
                            throw e;
                        }
                        Logger.m1917e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mFactory, 1, this.mErrorHandler, this.mDatabaseHook);
                    }
                }
            }
            onConfigure(sQLiteDatabaseOpenDatabase);
            int version = sQLiteDatabaseOpenDatabase.getVersion();
            if (version != this.mNewVersion) {
                if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabaseOpenDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
                if (version > 0 && version < this.mMinimumSupportedVersion) {
                    File file2 = new File(sQLiteDatabaseOpenDatabase.getPath());
                    onBeforeDelete(sQLiteDatabaseOpenDatabase);
                    sQLiteDatabaseOpenDatabase.close();
                    if (SQLiteDatabase.deleteDatabase(file2)) {
                        this.mIsInitializing = false;
                        SQLiteDatabase databaseLocked = getDatabaseLocked(z);
                        this.mIsInitializing = false;
                        if (sQLiteDatabaseOpenDatabase != this.mDatabase) {
                            sQLiteDatabaseOpenDatabase.close();
                        }
                        return databaseLocked;
                    }
                    throw new IllegalStateException("Unable to delete obsolete database " + this.mName + " with version " + version);
                }
                sQLiteDatabaseOpenDatabase.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(sQLiteDatabaseOpenDatabase);
                    } else {
                        int i = this.mNewVersion;
                        if (version > i) {
                            onDowngrade(sQLiteDatabaseOpenDatabase, version, i);
                        } else {
                            onUpgrade(sQLiteDatabaseOpenDatabase, version, i);
                        }
                    }
                    sQLiteDatabaseOpenDatabase.setVersion(this.mNewVersion);
                    sQLiteDatabaseOpenDatabase.setTransactionSuccessful();
                    sQLiteDatabaseOpenDatabase.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseOpenDatabase.endTransaction();
                    throw th;
                }
            }
            onOpen(sQLiteDatabaseOpenDatabase);
            if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                Logger.m1922w(TAG, "Opened " + this.mName + " in read-only mode");
            }
            this.mDatabase = sQLiteDatabaseOpenDatabase;
            this.mIsInitializing = false;
            return sQLiteDatabaseOpenDatabase;
        } catch (Throwable th2) {
            this.mIsInitializing = false;
            if (sQLiteDatabaseOpenDatabase != null && sQLiteDatabaseOpenDatabase != this.mDatabase) {
                sQLiteDatabaseOpenDatabase.close();
            }
            throw th2;
        }
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }

    private static byte[] getBytes(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        ByteBuffer byteBufferEncode = Charset.forName("UTF-8").encode(CharBuffer.wrap(str));
        byte[] bArr = new byte[byteBufferEncode.limit()];
        byteBufferEncode.get(bArr);
        return bArr;
    }
}
