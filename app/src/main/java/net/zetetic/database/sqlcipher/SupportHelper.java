package net.zetetic.database.sqlcipher;

import androidx.annotation.Nullable;
import androidx.sqlite.p009db.SupportSQLiteDatabase;
import androidx.sqlite.p009db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes6.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    private SQLiteOpenHelper openHelper;

    public SupportHelper(SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z) {
        this(configuration, bArr, sQLiteDatabaseHook, z, 0);
    }

    public SupportHelper(final SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z, int i) {
        this.openHelper = new SQLiteOpenHelper(configuration.context, configuration.name, bArr, null, configuration.callback.version, i, null, sQLiteDatabaseHook, z) { // from class: net.zetetic.database.sqlcipher.SupportHelper.1
            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onCreate(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                configuration.callback.onUpgrade(sQLiteDatabase, i2, i3);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                configuration.callback.onDowngrade(sQLiteDatabase, i2, i3);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onOpen(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onConfigure(sQLiteDatabase);
            }
        };
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.openHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.openHelper.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.openHelper.getWritableDatabase();
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.openHelper.getReadableDatabase();
    }

    @Override // androidx.sqlite.p009db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.openHelper.close();
    }
}
