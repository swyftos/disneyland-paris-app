package androidx.test.services.events.platform;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class TestPlatformEvent implements Parcelable {
    public static final Parcelable.Creator<TestPlatformEvent> CREATOR = new TestPlatformEventFactory();

    enum EventType {
        TEST_RUN_STARTED,
        TEST_RUN_ERROR,
        TEST_RUN_FINISHED,
        TEST_CASE_STARTED,
        TEST_CASE_ERROR,
        TEST_CASE_FINISHED
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    abstract EventType instanceType();

    TestPlatformEvent() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(instanceType().name());
    }
}
