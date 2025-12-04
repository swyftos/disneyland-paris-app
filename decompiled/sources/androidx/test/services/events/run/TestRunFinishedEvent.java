package androidx.test.services.events.run;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.FailureInfo;
import androidx.test.services.events.run.TestRunEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TestRunFinishedEvent extends TestRunEvent {
    public final int count;

    @NonNull
    public final List<FailureInfo> failures;
    public final int ignoreCount;
    public final long runTime;

    public TestRunFinishedEvent(int i, int i2, long j, @NonNull List<FailureInfo> list) {
        Checks.checkNotNull(list, "failures cannot be null");
        this.count = i;
        this.ignoreCount = i2;
        this.runTime = j;
        this.failures = list;
    }

    TestRunFinishedEvent(Parcel parcel) {
        this.count = parcel.readInt();
        this.ignoreCount = parcel.readInt();
        this.runTime = parcel.readLong();
        this.failures = new ArrayList();
        for (Parcelable parcelable : parcel.readParcelableArray(FailureInfo[].class.getClassLoader())) {
            this.failures.add((FailureInfo) parcelable);
        }
    }

    @Override // androidx.test.services.events.run.TestRunEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.count);
        parcel.writeInt(this.ignoreCount);
        parcel.writeLong(this.runTime);
        parcel.writeParcelableArray((FailureInfo[]) this.failures.toArray(new FailureInfo[0]), i);
    }

    @Override // androidx.test.services.events.run.TestRunEvent
    TestRunEvent.EventType instanceType() {
        return TestRunEvent.EventType.FINISHED;
    }
}
