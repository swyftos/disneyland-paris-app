package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.services.events.FailureInfo;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestAssumptionFailureEvent extends TestFailureEvent {
    public TestAssumptionFailureEvent(@NonNull TestCaseInfo testCaseInfo, @NonNull FailureInfo failureInfo) {
        super(testCaseInfo, failureInfo);
    }

    TestAssumptionFailureEvent(Parcel parcel) {
        super(parcel);
    }

    @Override // androidx.test.services.events.run.TestFailureEvent, androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.TEST_ASSUMPTION_FAILURE;
    }
}
