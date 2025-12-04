package androidx.test.services.events.platform;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.TestStatus;
import androidx.test.services.events.TimeStamp;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public class TestCaseFinishedEvent extends TestPlatformEvent {

    @NonNull
    public final TestCaseInfo testCase;

    @NonNull
    public final TestStatus testStatus;

    @NonNull
    public final TimeStamp timeStamp;

    public TestCaseFinishedEvent(@NonNull TestCaseInfo testCaseInfo, @NonNull TestStatus testStatus, @NonNull TimeStamp timeStamp) {
        this.testCase = (TestCaseInfo) Checks.checkNotNull(testCaseInfo, "testCase cannot be null");
        this.testStatus = (TestStatus) Checks.checkNotNull(testStatus, "testStatus cannot be null");
        this.timeStamp = (TimeStamp) Checks.checkNotNull(timeStamp, "timeStamp cannot be null");
    }

    TestCaseFinishedEvent(Parcel parcel) {
        this.testCase = new TestCaseInfo(parcel);
        this.testStatus = new TestStatus(parcel);
        this.timeStamp = new TimeStamp(parcel);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.testCase.writeToParcel(parcel, i);
        this.testStatus.writeToParcel(parcel, i);
        this.timeStamp.writeToParcel(parcel, i);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent
    TestPlatformEvent.EventType instanceType() {
        return TestPlatformEvent.EventType.TEST_CASE_FINISHED;
    }
}
