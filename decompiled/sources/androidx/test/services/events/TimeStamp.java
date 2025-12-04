package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public final class TimeStamp implements Parcelable {
    public static final Parcelable.Creator<TimeStamp> CREATOR = new Parcelable.Creator<TimeStamp>() { // from class: androidx.test.services.events.TimeStamp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeStamp createFromParcel(Parcel parcel) {
            return new TimeStamp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeStamp[] newArray(int i) {
            return new TimeStamp[i];
        }
    };

    @NonNull
    public final Integer nanos;

    @NonNull
    public final Long seconds;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TimeStamp(@NonNull Long l, @NonNull Integer num) {
        this.seconds = (Long) Checks.checkNotNull(l, "seconds cannot be null");
        this.nanos = (Integer) Checks.checkNotNull(num, "nanos cannot be null");
    }

    public TimeStamp(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.seconds = (Long) Checks.checkNotNull(Long.valueOf(parcel.readLong()), "seconds cannot be null");
        this.nanos = (Integer) Checks.checkNotNull(Integer.valueOf(parcel.readInt()), "nanos cannot be null");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.seconds.longValue());
        parcel.writeInt(this.nanos.intValue());
    }
}
