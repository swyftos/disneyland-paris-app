package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestStartedEvent extends TestRunEventWithTestCase {
    public TestStartedEvent(@NonNull TestCaseInfo testCaseInfo) {
        super(testCaseInfo);
    }

    TestStartedEvent(Parcel parcel) {
        super(parcel);
    }

    @Override // androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.TEST_STARTED;
    }
}
