package com.urbanairship.android.layout.display;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class DisplayArgsLoader implements Parcelable {
    private final String id;
    private static final Map cached = new HashMap();
    public static final Parcelable.Creator<DisplayArgsLoader> CREATOR = new Parcelable.Creator() { // from class: com.urbanairship.android.layout.display.DisplayArgsLoader.1
        @Override // android.os.Parcelable.Creator
        public DisplayArgsLoader createFromParcel(Parcel parcel) {
            return new DisplayArgsLoader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DisplayArgsLoader[] newArray(int i) {
            return new DisplayArgsLoader[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DisplayArgsLoader(String str) {
        this.id = str;
    }

    private DisplayArgsLoader(Parcel parcel) {
        this.id = parcel.readString();
    }

    public static DisplayArgsLoader newLoader(@NonNull DisplayArgs displayArgs) {
        String string = UUID.randomUUID().toString();
        cached.put(string, displayArgs);
        return new DisplayArgsLoader(string);
    }

    public void dispose() {
        cached.remove(this.id);
    }

    @NonNull
    public DisplayArgs getDisplayArgs() throws LoadException {
        DisplayArgs displayArgs = (DisplayArgs) cached.get(this.id);
        if (displayArgs != null) {
            return displayArgs;
        }
        throw new LoadException("Layout args no longer available");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    public static class LoadException extends Exception {
        public LoadException(String str) {
            super(str);
        }
    }
}
