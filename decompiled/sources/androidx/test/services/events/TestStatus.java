package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public final class TestStatus implements Parcelable {
    public static final Parcelable.Creator<TestStatus> CREATOR = new Parcelable.Creator<TestStatus>() { // from class: androidx.test.services.events.TestStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestStatus createFromParcel(Parcel parcel) {
            return new TestStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestStatus[] newArray(int i) {
            return new TestStatus[i];
        }
    };

    @NonNull
    public Status status;

    public enum Status {
        CANCELLED,
        IGNORED,
        SKIPPED,
        ABORTED,
        PASSED,
        FAILED
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TestStatus(@NonNull Status status) {
        this.status = (Status) Checks.checkNotNull(status, "status cannot be null");
    }

    public TestStatus(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.status = Status.valueOf((String) Checks.checkNotNull(parcel.readString(), "status cannot be null"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.status.name());
    }
}
