package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestRunStartedEvent extends TestRunEventWithTestCase {
    public TestRunStartedEvent(@NonNull TestCaseInfo testCaseInfo) {
        super(testCaseInfo);
    }

    TestRunStartedEvent(Parcel parcel) {
        super(parcel);
    }

    @Override // androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.STARTED;
    }
}
