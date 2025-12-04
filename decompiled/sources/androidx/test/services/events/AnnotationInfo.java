package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AnnotationInfo implements Parcelable {
    public static final Parcelable.Creator<AnnotationInfo> CREATOR = new Parcelable.Creator<AnnotationInfo>() { // from class: androidx.test.services.events.AnnotationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationInfo createFromParcel(Parcel parcel) {
            return new AnnotationInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationInfo[] newArray(int i) {
            return new AnnotationInfo[i];
        }
    };

    @NonNull
    public final String name;

    @NonNull
    public final List<AnnotationValue> values;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AnnotationInfo(@NonNull String str, @NonNull List<AnnotationValue> list) {
        Checks.checkNotNull(str, "annotationName cannot be null");
        Checks.checkNotNull(str, "annotationValues cannot be null");
        this.name = str;
        this.values = list;
    }

    private AnnotationInfo(Parcel parcel) {
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.values = arrayList;
        parcel.readTypedList(arrayList, AnnotationValue.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeTypedList(this.values);
    }
}
