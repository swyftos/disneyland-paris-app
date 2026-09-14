package com.microsoft.appcenter.utils.storage;

import android.database.sqlite.SQLiteQueryBuilder;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public class SQLiteUtils {
    @NonNull
    public static SQLiteQueryBuilder newSQLiteQueryBuilder() {
        return new SQLiteQueryBuilder();
    }
}
