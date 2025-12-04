package androidx.test.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ParcelableIBinder implements Parcelable {
    public static final Parcelable.Creator<ParcelableIBinder> CREATOR = new Parcelable.Creator<ParcelableIBinder>() { // from class: androidx.test.internal.util.ParcelableIBinder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableIBinder createFromParcel(Parcel parcel) {
            return new ParcelableIBinder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableIBinder[] newArray(int i) {
            return new ParcelableIBinder[i];
        }
    };
    private final IBinder iBinder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableIBinder(IBinder iBinder) {
        this.iBinder = (IBinder) Checks.checkNotNull(iBinder);
    }

    public IBinder getIBinder() {
        return this.iBinder;
    }

    protected ParcelableIBinder(Parcel parcel) {
        this.iBinder = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.iBinder);
    }
}
