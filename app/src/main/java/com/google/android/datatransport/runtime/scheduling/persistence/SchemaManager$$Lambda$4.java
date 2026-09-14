package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class SchemaManager$$Lambda$4 implements SchemaManager.Migration {
    private static final SchemaManager$$Lambda$4 instance = new SchemaManager$$Lambda$4();

    private SchemaManager$$Lambda$4() {
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$3(sQLiteDatabase);
    }
}
