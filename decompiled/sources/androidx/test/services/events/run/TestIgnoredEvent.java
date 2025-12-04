package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestIgnoredEvent extends TestRunEventWithTestCase {
    public TestIgnoredEvent(@NonNull TestCaseInfo testCaseInfo) {
        super(testCaseInfo);
    }

    TestIgnoredEvent(Parcel parcel) {
        super(parcel);
    }

    @Override // androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.TEST_IGNORED;
    }
}
