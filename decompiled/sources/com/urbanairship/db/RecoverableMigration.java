package com.urbanairship.db;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.urbanairship.UALog;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
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
            UALog.d(e, "Migration (%d to %d) failed!", Integer.valueOf(this.startVersion), Integer.valueOf(this.endVersion));
        }
        if (e != null) {
            UALog.d("Attempting to recover (%d to %d) migration!", Integer.valueOf(this.startVersion), Integer.valueOf(this.endVersion));
            tryRecover(supportSQLiteDatabase, e);
        }
    }
}
