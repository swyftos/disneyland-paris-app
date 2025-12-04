package com.urbanairship.wallet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;

/* loaded from: classes5.dex */
public class Pass implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<Pass> CREATOR = new Parcelable.Creator() { // from class: com.urbanairship.wallet.Pass.1
        @Override // android.os.Parcelable.Creator
        public Pass createFromParcel(Parcel parcel) {
            return new Pass(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Pass[] newArray(int i) {
            return new Pass[i];
        }
    };
    private final String id;
    private final Uri publicUri;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Pass(Uri uri, String str) {
        this.publicUri = uri;
        this.id = str;
    }

    protected Pass(@NonNull Parcel parcel) {
        this.publicUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.id = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.publicUri, i);
        parcel.writeString(this.id);
    }

    public void requestToSavePass(@NonNull Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW").setData(this.publicUri).setFlags(268435456));
    }

    @NonNull
    public Uri getPublicUri() {
        return this.publicUri;
    }

    @Nullable
    public String getId() {
        return this.id;
    }

    static Pass parsePass(JsonValue jsonValue) {
        String string = jsonValue.optMap().opt("id").getString();
        String string2 = jsonValue.optMap().opt("publicUrl").optMap().opt("path").getString();
        if (!UAStringUtil.isEmpty(string2)) {
            return new Pass(Uri.parse(string2), string);
        }
        UALog.e("Pass - unable to parse URI from %s", jsonValue);
        return null;
    }
}
