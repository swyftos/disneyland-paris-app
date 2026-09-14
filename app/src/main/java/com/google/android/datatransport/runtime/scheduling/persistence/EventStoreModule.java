package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Module;

/* JADX INFO: loaded from: classes3.dex */
@Module
public abstract class EventStoreModule {
    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    static String dbName() {
        return "com.google.android.datatransport.events";
    }
}
