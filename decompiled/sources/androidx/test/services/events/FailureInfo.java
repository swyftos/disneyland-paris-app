package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public final class FailureInfo implements Parcelable {
    public static final Parcelable.Creator<FailureInfo> CREATOR = new Parcelable.Creator<FailureInfo>() { // from class: androidx.test.services.events.FailureInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailureInfo createFromParcel(Parcel parcel) {
            return new FailureInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailureInfo[] newArray(int i) {
            return new FailureInfo[i];
        }
    };

    @Nullable
    public final String failureMessage;

    @Nullable
    public final String failureType;

    @NonNull
    public final String stackTrace;

    @NonNull
    public final TestCaseInfo testCase;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FailureInfo(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull TestCaseInfo testCaseInfo) {
        Checks.checkNotNull(str3, "stackTrace cannot be null");
        Checks.checkNotNull(testCaseInfo, "testCase cannot be null");
        this.failureMessage = str;
        this.failureType = str2;
        this.stackTrace = str3;
        this.testCase = testCaseInfo;
    }

    public FailureInfo(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.failureMessage = parcel.readString();
        this.failureType = parcel.readString();
        this.stackTrace = parcel.readString();
        this.testCase = (TestCaseInfo) parcel.readParcelable(TestCaseInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.failureMessage);
        parcel.writeString(this.failureType);
        parcel.writeString(this.stackTrace);
        parcel.writeParcelable(this.testCase, i);
    }
}
