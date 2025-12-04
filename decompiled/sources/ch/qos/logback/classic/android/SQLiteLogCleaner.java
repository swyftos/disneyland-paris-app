package ch.qos.logback.classic.android;

import android.database.sqlite.SQLiteDatabase;
import ch.qos.logback.core.util.Duration;

/* loaded from: classes2.dex */
public interface SQLiteLogCleaner {
    void performLogCleanup(SQLiteDatabase sQLiteDatabase, Duration duration);
}
