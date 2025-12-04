package androidx.test.services.events.platform;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.TestRunInfo;
import androidx.test.services.events.TimeStamp;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public class TestRunStartedEvent extends TestPlatformEvent {
    public final TestRunInfo testRun;
    public final TimeStamp timeStamp;

    public TestRunStartedEvent(@NonNull TestRunInfo testRunInfo, @NonNull TimeStamp timeStamp) {
        this.testRun = (TestRunInfo) Checks.checkNotNull(testRunInfo, "testRun cannot be null");
        this.timeStamp = (TimeStamp) Checks.checkNotNull(timeStamp, "timeStamp cannot be null");
    }

    public TestRunStartedEvent(Parcel parcel) {
        this.testRun = new TestRunInfo(parcel);
        this.timeStamp = new TimeStamp(parcel);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.testRun.writeToParcel(parcel, i);
        this.timeStamp.writeToParcel(parcel, i);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent
    TestPlatformEvent.EventType instanceType() {
        return TestPlatformEvent.EventType.TEST_RUN_STARTED;
    }
}
