package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.FailureInfo;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
public class TestFailureEvent extends TestRunEventWithTestCase {

    @NonNull
    public final FailureInfo failure;

    public TestFailureEvent(@NonNull TestCaseInfo testCaseInfo, @NonNull FailureInfo failureInfo) {
        super(testCaseInfo);
        Checks.checkNotNull(failureInfo, "failure cannot be null");
        this.failure = failureInfo;
    }

    TestFailureEvent(Parcel parcel) {
        super(parcel);
        this.failure = new FailureInfo(parcel);
    }

    @Override // androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.TEST_FAILURE;
    }

    @Override // androidx.test.services.events.run.TestRunEventWithTestCase, androidx.test.services.events.run.TestRunEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, 0);
        this.failure.writeToParcel(parcel, 0);
    }
}
