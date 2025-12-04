package com.urbanairship.db;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RetryingSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final boolean allowDataLoss;
    private final SupportSQLiteOpenHelper delegateOpenHelper;
    private final Object lock = new Object();

    public RetryingSQLiteOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, boolean z) {
        this.delegateOpenHelper = supportSQLiteOpenHelper;
        this.allowDataLoss = z;
    }

    public static class Factory implements SupportSQLiteOpenHelper.Factory {
        private final boolean allowDataLoss;
        private final SupportSQLiteOpenHelper.Factory factoryDelegate;

        public Factory(@NonNull SupportSQLiteOpenHelper.Factory factory, boolean z) {
            this.factoryDelegate = factory;
            this.allowDataLoss = z;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
        @NonNull
        public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper.Configuration configuration) {
            return new RetryingSQLiteOpenHelper(this.factoryDelegate.create(configuration), this.allowDataLoss);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.delegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.delegateOpenHelper.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    public SupportSQLiteDatabase getWritableDatabase() {
        SupportSQLiteDatabase databaseWithRetries;
        synchronized (this.lock) {
            databaseWithRetries = getDatabaseWithRetries(true);
        }
        return databaseWithRetries;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    public SupportSQLiteDatabase getReadableDatabase() {
        SupportSQLiteDatabase databaseWithRetries;
        synchronized (this.lock) {
            databaseWithRetries = getDatabaseWithRetries(false);
        }
        return databaseWithRetries;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegateOpenHelper.close();
    }

    private SupportSQLiteDatabase getDatabaseWithRetries(boolean z) {
        File parentFile;
        synchronized (this.lock) {
            String databaseName = getDatabaseName();
            if (databaseName != null && (parentFile = new File(getDatabaseName()).getParentFile()) != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            for (int i = 0; i < 4; i++) {
                try {
                    return this.getDatabase(z);
                } catch (Exception unused) {
                    this.tryClose();
                    SystemClock.sleep(350L);
                }
            }
            try {
                return this.getDatabase(z);
            } catch (Exception e) {
                this.tryClose();
                if (databaseName == null || !this.allowDataLoss) {
                    throw new RuntimeException(e);
                }
                if (getOpenException(e) != null) {
                    this.tryDeleteDatabase();
                }
                return this.getDatabase(z);
            }
        }
    }

    private static SQLiteException getOpenException(Exception exc) {
        if (exc.getCause() instanceof SQLiteCantOpenDatabaseException) {
            return (SQLiteCantOpenDatabaseException) exc.getCause();
        }
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            return (SQLiteCantOpenDatabaseException) exc;
        }
        if (exc.getCause() instanceof SQLiteDatabaseLockedException) {
            return (SQLiteDatabaseLockedException) exc.getCause();
        }
        if (exc instanceof SQLiteDatabaseLockedException) {
            return (SQLiteDatabaseLockedException) exc;
        }
        return null;
    }

    private SupportSQLiteDatabase getDatabase(boolean z) {
        if (z) {
            return this.delegateOpenHelper.getWritableDatabase();
        }
        return this.delegateOpenHelper.getReadableDatabase();
    }

    private void tryClose() {
        try {
            close();
        } catch (Exception unused) {
        }
    }

    private void tryDeleteDatabase() {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            try {
                new File(databaseName).delete();
            } catch (Exception unused) {
            }
        }
    }
}
