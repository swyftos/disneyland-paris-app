package com.urbanairship.actions;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;

/* loaded from: classes4.dex */
public class ActionValue implements JsonSerializable, Parcelable {

    @NonNull
    public static final Parcelable.Creator<ActionValue> CREATOR = new Parcelable.Creator() { // from class: com.urbanairship.actions.ActionValue.1
        @Override // android.os.Parcelable.Creator
        public ActionValue createFromParcel(Parcel parcel) {
            return new ActionValue((JsonValue) parcel.readParcelable(JsonValue.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public ActionValue[] newArray(int i) {
            return new ActionValue[i];
        }
    };
    private final JsonValue jsonValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActionValue(@Nullable JsonValue jsonValue) {
        this.jsonValue = jsonValue == null ? JsonValue.NULL : jsonValue;
    }

    @NonNull
    public static ActionValue wrap(@Nullable String str) {
        return new ActionValue(JsonValue.wrap(str));
    }

    @NonNull
    public static ActionValue wrap(int i) {
        return new ActionValue(JsonValue.wrap(i));
    }

    @NonNull
    public static ActionValue wrap(long j) {
        return new ActionValue(JsonValue.wrap(j));
    }

    @NonNull
    public static ActionValue wrap(char c) {
        return new ActionValue(JsonValue.wrap(c));
    }

    @NonNull
    public static ActionValue wrap(boolean z) {
        return new ActionValue(JsonValue.wrap(z));
    }

    @NonNull
    public static ActionValue wrap(@Nullable JsonSerializable jsonSerializable) {
        return new ActionValue(JsonValue.wrap(jsonSerializable));
    }

    @NonNull
    public static ActionValue wrap(@Nullable Object obj) throws ActionValueException {
        try {
            return new ActionValue(JsonValue.wrap(obj));
        } catch (JsonException e) {
            throw new ActionValueException("Invalid ActionValue object: " + obj, e);
        }
    }

    public ActionValue() {
        this.jsonValue = JsonValue.NULL;
    }

    @Nullable
    public String getString() {
        return this.jsonValue.getString();
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.jsonValue.getString(str);
    }

    public int getInt(int i) {
        return this.jsonValue.getInt(i);
    }

    public double getDouble(double d) {
        return this.jsonValue.getDouble(d);
    }

    public long getLong(long j) {
        return this.jsonValue.getLong(j);
    }

    public boolean getBoolean(boolean z) {
        return this.jsonValue.getBoolean(z);
    }

    @Nullable
    public JsonList getList() {
        return this.jsonValue.getList();
    }

    @Nullable
    public JsonMap getMap() {
        return this.jsonValue.getMap();
    }

    public boolean isNull() {
        return this.jsonValue.isNull();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ActionValue) {
            return this.jsonValue.equals(((ActionValue) obj).jsonValue);
        }
        return false;
    }

    public int hashCode() {
        return this.jsonValue.hashCode();
    }

    @NonNull
    public String toString() {
        return this.jsonValue.toString();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return this.jsonValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.jsonValue, i);
    }
}
