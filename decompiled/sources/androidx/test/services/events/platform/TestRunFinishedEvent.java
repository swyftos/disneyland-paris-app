package androidx.test.services.events.platform;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.TestRunInfo;
import androidx.test.services.events.TestStatus;
import androidx.test.services.events.TimeStamp;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public class TestRunFinishedEvent extends TestPlatformEvent {
    public final TestStatus runStatus;
    public final TestRunInfo testRun;
    public final TimeStamp timeStamp;

    public TestRunFinishedEvent(@NonNull TestRunInfo testRunInfo, @NonNull TestStatus testStatus, @NonNull TimeStamp timeStamp) {
        this.testRun = (TestRunInfo) Checks.checkNotNull(testRunInfo, "testRun cannot be null");
        this.runStatus = (TestStatus) Checks.checkNotNull(testStatus, "runStatus cannot be null");
        this.timeStamp = (TimeStamp) Checks.checkNotNull(timeStamp, "timeStamp cannot be null");
    }

    TestRunFinishedEvent(Parcel parcel) {
        this.testRun = new TestRunInfo(parcel);
        this.runStatus = new TestStatus(parcel);
        this.timeStamp = new TimeStamp(parcel);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.testRun.writeToParcel(parcel, i);
        this.runStatus.writeToParcel(parcel, i);
        this.timeStamp.writeToParcel(parcel, i);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent
    TestPlatformEvent.EventType instanceType() {
        return TestPlatformEvent.EventType.TEST_RUN_FINISHED;
    }
}
