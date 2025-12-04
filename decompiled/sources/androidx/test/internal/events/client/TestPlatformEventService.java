package androidx.test.internal.events.client;

import androidx.annotation.NonNull;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public interface TestPlatformEventService {
    void send(@NonNull TestPlatformEvent testPlatformEvent) throws TestEventClientException;
}
