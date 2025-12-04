package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public final class ParcelableResult implements Parcelable {
    public static final Parcelable.Creator<ParcelableResult> CREATOR = new Parcelable.Creator<ParcelableResult>() { // from class: androidx.test.orchestrator.junit.ParcelableResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableResult createFromParcel(Parcel parcel) {
            return new ParcelableResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableResult[] newArray(int i) {
            return new ParcelableResult[i];
        }
    };
    private final List failures;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableResult(List<ParcelableFailure> list) {
        this.failures = list;
    }

    public ParcelableResult(Result result) {
        this.failures = new ArrayList();
        Iterator<Failure> it = result.getFailures().iterator();
        while (it.hasNext()) {
            this.failures.add(new ParcelableFailure(it.next()));
        }
    }

    private ParcelableResult(Parcel parcel) {
        this.failures = new ArrayList();
        for (Object obj : parcel.readArray(ParcelableFailure[].class.getClassLoader())) {
            this.failures.add((ParcelableFailure) obj);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.failures.toArray());
    }

    public boolean wasSuccessful() {
        return this.failures.isEmpty();
    }

    public List<ParcelableFailure> getFailures() {
        return this.failures;
    }

    public int getFailureCount() {
        return this.failures.size();
    }
}
