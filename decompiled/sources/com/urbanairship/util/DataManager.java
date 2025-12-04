package com.urbanairship.util;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import com.urbanairship.UALog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class DataManager {
    private final SQLiteOpenHelper openHelper;
    private final String path;

    @TargetApi(16)
    protected void onConfigure(@NonNull SQLiteDatabase sQLiteDatabase) {
    }

    protected abstract void onCreate(@NonNull SQLiteDatabase sQLiteDatabase);

    protected void onOpen(@NonNull SQLiteDatabase sQLiteDatabase) {
    }

    public DataManager(@NonNull Context context, @NonNull String str, @NonNull String str2, int i) {
        String strMigrateDatabase = migrateDatabase(context, str, str2);
        this.path = strMigrateDatabase;
        this.openHelper = new SQLiteOpenHelper(context, strMigrateDatabase, null, i) { // from class: com.urbanairship.util.DataManager.1
            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                DataManager.this.onCreate(sQLiteDatabase);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                UALog.d("Upgrading database %s from version %s to %s", sQLiteDatabase, Integer.valueOf(i2), Integer.valueOf(i3));
                DataManager.this.onUpgrade(sQLiteDatabase, i2, i3);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                UALog.d("Downgrading database %s from version %s to %s", sQLiteDatabase, Integer.valueOf(i2), Integer.valueOf(i3));
                DataManager.this.onDowngrade(sQLiteDatabase, i2, i3);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                super.onConfigure(sQLiteDatabase);
                DataManager.this.onConfigure(sQLiteDatabase);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                super.onOpen(sQLiteDatabase);
                DataManager.this.onOpen(sQLiteDatabase);
            }
        };
    }

    @Nullable
    protected SQLiteDatabase getWritableDatabase() {
        for (int i = 0; i < 3; i++) {
            try {
                return this.openHelper.getWritableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100L);
                UALog.e(e, "DataManager - Error opening writable database. Retrying...", new Object[0]);
            }
        }
        return null;
    }

    @Nullable
    protected SQLiteDatabase getReadableDatabase() {
        for (int i = 0; i < 3; i++) {
            try {
                return this.openHelper.getReadableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100L);
                UALog.e(e, "DataManager - Error opening readable database. Retrying...", new Object[0]);
            }
        }
        return null;
    }

    protected void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        UALog.d("onUpgrade not implemented yet.", new Object[0]);
    }

    protected void onDowngrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Unable to downgrade database");
    }

    public int delete(@NonNull String str, @Nullable String str2, @Nullable String[] strArr) {
        if (str2 == null) {
            str2 = "1";
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return -1;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return writableDatabase.delete(str, str2, strArr);
            } catch (Exception e) {
                UALog.e(e, "Unable to delete item from a database", new Object[0]);
            }
        }
        return -1;
    }

    @NonNull
    public List<ContentValues> bulkInsert(@NonNull String str, @NonNull ContentValues[] contentValuesArr) throws SQLException {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        if (writableDatabase == null) {
            return arrayList;
        }
        writableDatabase.beginTransaction();
        for (ContentValues contentValues : contentValuesArr) {
            try {
                writableDatabase.replaceOrThrow(str, null, contentValues);
            } catch (Exception e) {
                UALog.e(e, "Unable to insert into database", new Object[0]);
                writableDatabase.endTransaction();
                return Collections.emptyList();
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return arrayList;
    }

    public long insert(@NonNull String str, @Nullable ContentValues contentValues) {
        if (getWritableDatabase() == null) {
            return -1L;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return this.getWritableDatabase().replaceOrThrow(str, null, contentValues);
            } catch (Exception e) {
                UALog.e(e, "Unable to insert into database", new Object[0]);
            }
        }
        return -1L;
    }

    public int update(@NonNull String str, @Nullable ContentValues contentValues, @Nullable String str2, @Nullable String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return -1;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return writableDatabase.update(str, contentValues, str2, strArr);
            } catch (SQLException e) {
                UALog.e(e, "Update Failed", new Object[0]);
            }
        }
        return -1;
    }

    @Nullable
    public Cursor query(@NonNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3) {
        return query(str, strArr, str2, strArr2, str3, null);
    }

    @Nullable
    public Cursor query(@NonNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3, @Nullable String str4) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return readableDatabase.query(str, strArr, str2, strArr2, null, null, str3, str4);
            } catch (SQLException e) {
                UALog.e(e, "Query Failed", new Object[0]);
            }
        }
        return null;
    }

    @Nullable
    public Cursor rawQuery(@NonNull String str, @Nullable String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            try {
                return readableDatabase.rawQuery(str, strArr);
            } catch (SQLException e) {
                UALog.e(e, "Query failed", new Object[0]);
            }
        }
        return null;
    }

    public void close() {
        try {
            this.openHelper.close();
        } catch (Exception e) {
            UALog.e(e, "Failed to close the database.", new Object[0]);
        }
    }

    public boolean databaseExists(@NonNull Context context) {
        return context.getDatabasePath(this.path).exists();
    }

    public boolean deleteDatabase(@NonNull Context context) {
        try {
            return context.getDatabasePath(this.path).delete();
        } catch (Exception e) {
            UALog.e(e, "Failed to delete database: " + this.path, new Object[0]);
            return false;
        }
    }

    protected static String migrateDatabase(@NonNull Context context, String str, String str2) {
        String str3 = str + "_" + str2;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.urbanairship.databases");
        if (!file.exists() && !file.mkdirs()) {
            UALog.e("Failed to create UA no backup directory.", new Object[0]);
        }
        File file2 = new File(file, str3);
        File[] fileArr = {context.getDatabasePath(str3), new File(file, str2), context.getDatabasePath(str2)};
        if (file2.exists()) {
            return file2.getAbsolutePath();
        }
        for (int i = 0; i < 3; i++) {
            File file3 = fileArr[i];
            if (file3.exists()) {
                if (!file3.renameTo(file2)) {
                    return file3.getAbsolutePath();
                }
                File file4 = new File(file3.getAbsolutePath() + "-journal");
                if (file4.exists()) {
                    if (!file4.renameTo(new File(file2.getAbsolutePath() + "-journal"))) {
                        UALog.e("Failed to move the journal file: " + file4, new Object[0]);
                    }
                }
            }
        }
        return file2.getAbsolutePath();
    }
}
