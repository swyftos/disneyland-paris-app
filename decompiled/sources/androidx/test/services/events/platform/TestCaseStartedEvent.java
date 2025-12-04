package androidx.test.services.events.platform;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.TimeStamp;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public final class TestCaseStartedEvent extends TestPlatformEvent {

    @NonNull
    public final TestCaseInfo testCase;

    @NonNull
    public final TimeStamp timeStamp;

    public TestCaseStartedEvent(@NonNull TestCaseInfo testCaseInfo, @NonNull TimeStamp timeStamp) {
        this.testCase = (TestCaseInfo) Checks.checkNotNull(testCaseInfo, "testCase cannot be null");
        this.timeStamp = (TimeStamp) Checks.checkNotNull(timeStamp, "timeStamp cannot be null");
    }

    public TestCaseStartedEvent(Parcel parcel) {
        this.testCase = new TestCaseInfo(parcel);
        this.timeStamp = new TimeStamp(parcel);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.testCase.writeToParcel(parcel, i);
        this.timeStamp.writeToParcel(parcel, i);
    }

    @Override // androidx.test.services.events.platform.TestPlatformEvent
    public TestPlatformEvent.EventType instanceType() {
        return TestPlatformEvent.EventType.TEST_CASE_STARTED;
    }
}
