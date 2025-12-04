package androidx.test.services.events.run;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class TestRunEvent implements Parcelable {
    public static final Parcelable.Creator<TestRunEvent> CREATOR = new TestRunEventFactory();

    enum EventType {
        STARTED,
        TEST_STARTED,
        TEST_FINISHED,
        TEST_ASSUMPTION_FAILURE,
        TEST_FAILURE,
        TEST_IGNORED,
        FINISHED
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    abstract EventType instanceType();

    TestRunEvent() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(instanceType().name());
    }
}
