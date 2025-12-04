package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import gherkin.GherkinLanguageConstants;
import org.junit.runner.Description;

/* loaded from: classes2.dex */
public final class ParcelableDescription implements Parcelable {
    public static final Parcelable.Creator<ParcelableDescription> CREATOR = new Parcelable.Creator<ParcelableDescription>() { // from class: androidx.test.orchestrator.junit.ParcelableDescription.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableDescription createFromParcel(Parcel parcel) {
            return new ParcelableDescription(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableDescription[] newArray(int i) {
            return new ParcelableDescription[i];
        }
    };
    private final String className;
    private final String displayName;
    private final String methodName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableDescription(Description description) {
        this.className = description.getClassName();
        this.methodName = description.getMethodName();
        this.displayName = description.getDisplayName();
    }

    public ParcelableDescription(String str) {
        String[] strArrSplit = str.split(GherkinLanguageConstants.COMMENT_PREFIX);
        if (strArrSplit.length > 0) {
            this.className = strArrSplit[0];
            this.methodName = strArrSplit.length > 1 ? strArrSplit[1] : "";
        } else {
            this.className = "";
            this.methodName = "";
        }
        this.displayName = String.format("%s(%s)", this.methodName, this.className);
    }

    private ParcelableDescription(Parcel parcel) {
        this.className = getNonNullString(parcel);
        this.methodName = getNonNullString(parcel);
        this.displayName = getNonNullString(parcel);
    }

    private String getNonNullString(Parcel parcel) {
        String string = parcel.readString();
        return string == null ? "" : string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeString(this.methodName);
        parcel.writeString(this.displayName);
    }

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
