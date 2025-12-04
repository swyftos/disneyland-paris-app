package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public final class ErrorInfo implements Parcelable {
    public static final Parcelable.Creator<ErrorInfo> CREATOR = new Parcelable.Creator<ErrorInfo>() { // from class: androidx.test.services.events.ErrorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ErrorInfo createFromParcel(Parcel parcel) {
            return new ErrorInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ErrorInfo[] newArray(int i) {
            return new ErrorInfo[i];
        }
    };

    @Nullable
    public final String errorMessage;

    @Nullable
    public final String errorType;

    @NonNull
    public final String stackTrace;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ErrorInfo(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        this.errorMessage = str;
        this.errorType = str2;
        this.stackTrace = (String) Checks.checkNotNull(str3, "stackTrace cannot be null");
    }

    public ErrorInfo(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.errorMessage = parcel.readString();
        this.errorType = parcel.readString();
        this.stackTrace = (String) Checks.checkNotNull(parcel.readString(), "stackTrace cannot be null");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorType);
        parcel.writeString(this.stackTrace);
    }
}
