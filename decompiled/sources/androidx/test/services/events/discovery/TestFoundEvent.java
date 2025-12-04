package androidx.test.services.events.discovery;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.discovery.TestDiscoveryEvent;

/* loaded from: classes2.dex */
public class TestFoundEvent extends TestDiscoveryEvent {

    @NonNull
    public final TestCaseInfo testCase;

    public TestFoundEvent(@NonNull TestCaseInfo testCaseInfo) {
        Checks.checkNotNull(testCaseInfo, "testCase cannot be null");
        this.testCase = testCaseInfo;
    }

    TestFoundEvent(Parcel parcel) {
        this.testCase = new TestCaseInfo(parcel);
    }

    @Override // androidx.test.services.events.discovery.TestDiscoveryEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        this.testCase.writeToParcel(parcel, i);
    }

    @Override // androidx.test.services.events.discovery.TestDiscoveryEvent
    TestDiscoveryEvent.EventType instanceType() {
        return TestDiscoveryEvent.EventType.TEST_FOUND;
    }
}
