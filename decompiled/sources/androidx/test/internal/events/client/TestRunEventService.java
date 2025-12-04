package androidx.test.internal.events.client;

import androidx.annotation.NonNull;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public interface TestRunEventService {
    void send(@NonNull TestRunEvent testRunEvent) throws TestEventClientException;
}
