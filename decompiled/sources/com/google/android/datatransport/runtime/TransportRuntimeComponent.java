package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
abstract class TransportRuntimeComponent implements Closeable {

    interface Builder {
        TransportRuntimeComponent build();

        Builder setApplicationContext(Context context);
    }

    abstract EventStore getEventStore();

    abstract TransportRuntime getTransportRuntime();

    TransportRuntimeComponent() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        getEventStore().close();
    }
}
