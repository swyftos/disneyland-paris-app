package androidx.test.services.events.discovery;

import androidx.test.services.events.discovery.TestDiscoveryEvent;

/* loaded from: classes2.dex */
public class TestDiscoveryFinishedEvent extends TestDiscoveryEvent {
    @Override // androidx.test.services.events.discovery.TestDiscoveryEvent
    TestDiscoveryEvent.EventType instanceType() {
        return TestDiscoveryEvent.EventType.FINISHED;
    }
}
