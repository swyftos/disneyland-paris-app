package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TestRunInfo implements Parcelable {
    public static final Parcelable.Creator<TestRunInfo> CREATOR = new Parcelable.Creator<TestRunInfo>() { // from class: androidx.test.services.events.TestRunInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestRunInfo createFromParcel(Parcel parcel) {
            return new TestRunInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestRunInfo[] newArray(int i) {
            return new TestRunInfo[i];
        }
    };

    @NonNull
    public final List<TestCaseInfo> testCases;

    @NonNull
    public final String testRunName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TestRunInfo(@NonNull String str, @NonNull List<TestCaseInfo> list) {
        this.testRunName = (String) Checks.checkNotNull(str, "testRunName cannot be null");
        this.testCases = (List) Checks.checkNotNull(list, "testCases cannot be null");
    }

    public TestRunInfo(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.testRunName = (String) Checks.checkNotNull(parcel.readString(), "className cannot be null");
        ArrayList arrayList = new ArrayList();
        this.testCases = arrayList;
        parcel.readTypedList(arrayList, TestCaseInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.testRunName);
        parcel.writeTypedList(this.testCases);
    }
}
