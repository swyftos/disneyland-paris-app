package androidx.test.internal.events.client;

import androidx.annotation.NonNull;
import androidx.test.services.events.discovery.TestDiscoveryEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface TestDiscoveryEventService {
    void send(@NonNull TestDiscoveryEvent testDiscoveryEvent) throws TestEventClientException;
}
