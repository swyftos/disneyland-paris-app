package androidx.test.services.events;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import gherkin.GherkinLanguageConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TestCaseInfo implements Parcelable {
    public static final Parcelable.Creator<TestCaseInfo> CREATOR = new Parcelable.Creator<TestCaseInfo>() { // from class: androidx.test.services.events.TestCaseInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestCaseInfo createFromParcel(Parcel parcel) {
            return new TestCaseInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TestCaseInfo[] newArray(int i) {
            return new TestCaseInfo[i];
        }
    };

    @NonNull
    public final List<AnnotationInfo> classAnnotations;

    @NonNull
    public final String className;

    @NonNull
    public final List<AnnotationInfo> methodAnnotations;

    @NonNull
    public final String methodName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TestCaseInfo(@NonNull Parcel parcel) {
        Checks.checkNotNull(parcel, "source cannot be null");
        this.className = (String) Checks.checkNotNull(parcel.readString(), "className cannot be null");
        this.methodName = (String) Checks.checkNotNull(parcel.readString(), "methodName cannot be null");
        ArrayList arrayList = new ArrayList();
        this.methodAnnotations = arrayList;
        Parcelable.Creator<AnnotationInfo> creator = AnnotationInfo.CREATOR;
        parcel.readTypedList(arrayList, creator);
        ArrayList arrayList2 = new ArrayList();
        this.classAnnotations = arrayList2;
        parcel.readTypedList(arrayList2, creator);
    }

    public TestCaseInfo(@NonNull String str, @NonNull String str2, @NonNull List<AnnotationInfo> list, @NonNull List<AnnotationInfo> list2) {
        this.className = (String) Checks.checkNotNull(str, "className cannot be null");
        this.methodName = (String) Checks.checkNotNull(str2, "methodName cannot be null");
        this.classAnnotations = (List) Checks.checkNotNull(list2, "classAnnotations cannot be null");
        this.methodAnnotations = (List) Checks.checkNotNull(list, "methodAnnotations cannot be null");
    }

    @NonNull
    public String getClassAndMethodName() {
        String str = this.className;
        String str2 = this.methodName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeString(this.methodName);
        parcel.writeTypedList(this.methodAnnotations);
        parcel.writeTypedList(this.classAnnotations);
    }
}
