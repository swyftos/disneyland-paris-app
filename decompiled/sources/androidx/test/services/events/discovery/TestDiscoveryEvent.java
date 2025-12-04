package androidx.test.services.events.discovery;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class TestDiscoveryEvent implements Parcelable {
    public static final Parcelable.Creator<TestDiscoveryEvent> CREATOR = new TestDiscoveryEventFactory();

    enum EventType {
        STARTED,
        TEST_FOUND,
        FINISHED
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    abstract EventType instanceType();

    TestDiscoveryEvent() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(instanceType().name());
    }
}
