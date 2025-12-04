package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AnnotationValue implements Parcelable {
    public static final Parcelable.Creator<AnnotationValue> CREATOR = new Parcelable.Creator<AnnotationValue>() { // from class: androidx.test.services.events.AnnotationValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationValue createFromParcel(Parcel parcel) {
            return new AnnotationValue(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationValue[] newArray(int i) {
            return new AnnotationValue[i];
        }
    };

    @NonNull
    public final String fieldName;

    @NonNull
    public final List<String> fieldValues;

    @NonNull
    public final String valueType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AnnotationValue(@NonNull String str, @NonNull List<String> list, @NonNull String str2) {
        Checks.checkNotNull(str, "fieldName cannot be null");
        Checks.checkNotNull(list, "fieldValues cannot be null");
        Checks.checkNotNull(str2, "valueType cannot be null");
        this.fieldName = str;
        this.fieldValues = list;
        this.valueType = str2;
    }

    private AnnotationValue(Parcel parcel) {
        this.fieldName = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.fieldValues = arrayList;
        parcel.readStringList(arrayList);
        this.valueType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fieldName);
        parcel.writeStringList(this.fieldValues);
        parcel.writeString(this.valueType);
    }
}
