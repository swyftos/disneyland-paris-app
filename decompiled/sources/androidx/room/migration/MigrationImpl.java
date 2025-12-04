package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
final class MigrationImpl extends Migration {
    private final Function1 migrateCallback;

    public MigrationImpl(int i, int i2, Function1 function1) {
        super(i, i2);
        this.migrateCallback = function1;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
