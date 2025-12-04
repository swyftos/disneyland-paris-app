package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.test.services.events.internal.StackTrimmer;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public final class ParcelableFailure implements Parcelable {
    public static final Parcelable.Creator<ParcelableFailure> CREATOR = new Parcelable.Creator<ParcelableFailure>() { // from class: androidx.test.orchestrator.junit.ParcelableFailure.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableFailure createFromParcel(Parcel parcel) {
            return new ParcelableFailure(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableFailure[] newArray(int i) {
            return new ParcelableFailure[i];
        }
    };
    private final ParcelableDescription description;
    private final String trace;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableFailure(Failure failure) {
        this.description = new ParcelableDescription(failure.getDescription());
        this.trace = StackTrimmer.getTrimmedStackTrace(failure);
    }

    private ParcelableFailure(Parcel parcel) {
        this.description = (ParcelableDescription) parcel.readParcelable(ParcelableDescription.class.getClassLoader());
        this.trace = parcel.readString();
    }

    public ParcelableFailure(ParcelableDescription parcelableDescription, Throwable th) {
        this(parcelableDescription, th.getMessage());
    }

    public ParcelableFailure(ParcelableDescription parcelableDescription, String str) {
        this.description = parcelableDescription;
        this.trace = trimToLength(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.description, 0);
        parcel.writeString(this.trace);
    }

    private static String trimToLength(String str) {
        if (!str.endsWith("\n")) {
            str = str.concat("\n");
        }
        if (str.length() <= 16384) {
            return str;
        }
        Log.i("ParcelableFailure", String.format("Stack trace too long, trimmed to first %s characters.", 16383));
        return String.valueOf(str.substring(0, 16383)).concat("\n");
    }

    public String getTrace() {
        return this.trace;
    }

    public ParcelableDescription getDescription() {
        return this.description;
    }
}
