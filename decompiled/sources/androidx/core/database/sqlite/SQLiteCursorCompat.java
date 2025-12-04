package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;

/* loaded from: classes.dex */
public final class SQLiteCursorCompat {
    public static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z) {
        Api28Impl.setFillWindowForwardOnly(sQLiteCursor, z);
    }

    static class Api28Impl {
        static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z) {
            sQLiteCursor.setFillWindowForwardOnly(z);
        }
    }
}
