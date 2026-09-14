package com.urbanairship.p039db;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.p009db.SupportSQLiteDatabase;
import com.urbanairship.UALog;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class RecoverableMigration extends Migration {
    public abstract void tryMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

    public abstract void tryRecover(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull Exception exc);

    public RecoverableMigration(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            tryMigrate(supportSQLiteDatabase);
            e = null;
        } catch (Exception e) {
            e = e;
            UALog.m1742d(e, "Migration (%d to %d) failed!", Integer.valueOf(this.startVersion), Integer.valueOf(this.endVersion));
        }
        if (e != null) {
            UALog.m1741d("Attempting to recover (%d to %d) migration!", Integer.valueOf(this.startVersion), Integer.valueOf(this.endVersion));
            tryRecover(supportSQLiteDatabase, e);
        }
    }
}
