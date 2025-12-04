package com.urbanairship.json;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.util.UAStringUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: classes5.dex */
public class JsonValue implements Parcelable, JsonSerializable {
    private final Object value;

    @NonNull
    public static final JsonValue NULL = new JsonValue(null);

    @NonNull
    public static final Parcelable.Creator<JsonValue> CREATOR = new Parcelable.Creator() { // from class: com.urbanairship.json.JsonValue.1
        @Override // android.os.Parcelable.Creator
        public JsonValue createFromParcel(Parcel parcel) {
            try {
                return JsonValue.parseString(parcel.readString());
            } catch (JsonException e) {
                UALog.e(e, "JsonValue - Unable to create JsonValue from parcel.", new Object[0]);
                return JsonValue.NULL;
            }
        }

        @Override // android.os.Parcelable.Creator
        public JsonValue[] newArray(int i) {
            return new JsonValue[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return this;
    }

    private JsonValue(Object obj) {
        this.value = obj;
    }

    @Nullable
    public Object getValue() {
        return this.value;
    }

    @Nullable
    public String getString() {
        if (this.value != null && isString()) {
            return (String) this.value;
        }
        return null;
    }

    @NonNull
    public String requireString() throws JsonException {
        String string = getString();
        if (string != null) {
            return string;
        }
        throw new JsonException("Expected string: " + this);
    }

    @NonNull
    public JsonMap requireMap() throws JsonException {
        JsonMap map = getMap();
        if (map != null) {
            return map;
        }
        throw new JsonException("Expected map: " + this);
    }

    @NonNull
    public JsonList requireList() throws JsonException {
        JsonList list = getList();
        if (list != null) {
            return list;
        }
        throw new JsonException("Expected list: " + this);
    }

    @NonNull
    public String getString(@NonNull String str) {
        String string = getString();
        return string == null ? str : string;
    }

    @NonNull
    public String optString() {
        return getString("");
    }

    @Nullable
    public String coerceString() {
        Object obj = this.value;
        if (obj == null || obj == NULL || (obj instanceof JsonMap) || (obj instanceof JsonList)) {
            return null;
        }
        if (isString()) {
            return (String) this.value;
        }
        if (isNumber()) {
            try {
                return JSONObject.numberToString((Number) this.value);
            } catch (JSONException e) {
                UALog.e(e, "JsonValue - Failed to coerce JSON Number into String.", new Object[0]);
                return null;
            }
        }
        return String.valueOf(this.value);
    }

    public int getInt(int i) {
        if (this.value == null) {
            return i;
        }
        if (isInteger()) {
            return ((Integer) this.value).intValue();
        }
        return isNumber() ? ((Number) this.value).intValue() : i;
    }

    @Nullable
    public Integer getInteger() {
        if (isInteger()) {
            return (Integer) this.value;
        }
        if (isNumber()) {
            return Integer.valueOf(((Number) this.value).intValue());
        }
        return null;
    }

    public float getFloat(float f) {
        if (this.value == null) {
            return f;
        }
        if (isFloat()) {
            return ((Float) this.value).floatValue();
        }
        return isNumber() ? ((Number) this.value).floatValue() : f;
    }

    public double getDouble(double d) {
        if (this.value == null) {
            return d;
        }
        if (isDouble()) {
            return ((Double) this.value).doubleValue();
        }
        return isNumber() ? ((Number) this.value).doubleValue() : d;
    }

    public long getLong(long j) {
        if (this.value == null) {
            return j;
        }
        if (isLong()) {
            return ((Long) this.value).longValue();
        }
        return isNumber() ? ((Number) this.value).longValue() : j;
    }

    @Nullable
    public Number getNumber() {
        if (this.value != null && isNumber()) {
            return (Number) this.value;
        }
        return null;
    }

    public boolean getBoolean(boolean z) {
        return (this.value != null && isBoolean()) ? ((Boolean) this.value).booleanValue() : z;
    }

    @Nullable
    public Boolean getBoolean() {
        if (this.value != null && isBoolean()) {
            return (Boolean) this.value;
        }
        return null;
    }

    @Nullable
    public JsonList getList() {
        if (this.value != null && isJsonList()) {
            return (JsonList) this.value;
        }
        return null;
    }

    @NonNull
    public JsonList optList() {
        JsonList list = getList();
        return list == null ? JsonList.EMPTY_LIST : list;
    }

    @Nullable
    public JsonMap getMap() {
        if (this.value != null && isJsonMap()) {
            return (JsonMap) this.value;
        }
        return null;
    }

    @NonNull
    public JsonMap optMap() {
        JsonMap map = getMap();
        return map == null ? JsonMap.EMPTY_MAP : map;
    }

    public boolean isNull() {
        return this.value == null;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public boolean isInteger() {
        return this.value instanceof Integer;
    }

    public boolean isDouble() {
        return this.value instanceof Double;
    }

    public boolean isFloat() {
        return this.value instanceof Float;
    }

    public boolean isLong() {
        return this.value instanceof Long;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isJsonMap() {
        return this.value instanceof JsonMap;
    }

    public boolean isJsonList() {
        return this.value instanceof JsonList;
    }

    @NonNull
    public static JsonValue parseString(@Nullable String str) throws JsonException {
        if (UAStringUtil.isEmpty(str)) {
            return NULL;
        }
        try {
            return wrap(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new JsonException("Unable to parse string", e);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof JsonValue)) {
            return false;
        }
        JsonValue jsonValue = (JsonValue) obj;
        if (this.value == null) {
            return jsonValue.isNull();
        }
        if (isNumber() && jsonValue.isNumber()) {
            return (isDouble() || jsonValue.isDouble()) ? Double.compare(getDouble(AudioStats.AUDIO_AMPLITUDE_NONE), jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE)) == 0 : (isFloat() || jsonValue.isFloat()) ? Float.compare(getFloat(BitmapDescriptorFactory.HUE_RED), jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED)) == 0 : getLong(0L) == jsonValue.getLong(0L);
        }
        return this.value.equals(jsonValue.value);
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return 527 + obj.hashCode();
        }
        return 17;
    }

    @NonNull
    public String toString() {
        return toString(Boolean.FALSE);
    }

    @NonNull
    public String toString(Boolean bool) {
        if (isNull()) {
            return "null";
        }
        try {
            Object obj = this.value;
            if (obj instanceof String) {
                return JSONObject.quote((String) obj);
            }
            if (obj instanceof Number) {
                return JSONObject.numberToString((Number) obj);
            }
            if (obj instanceof JsonMap) {
                return ((JsonMap) obj).toString(bool);
            }
            if (obj instanceof JsonList) {
                return ((JsonList) obj).toString();
            }
            return String.valueOf(obj);
        } catch (JSONException e) {
            UALog.e(e, "JsonValue - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }

    void write(JSONStringer jSONStringer, Boolean bool) throws JSONException {
        if (isNull()) {
            jSONStringer.value((Object) null);
            return;
        }
        Object obj = this.value;
        if (obj instanceof JsonList) {
            ((JsonList) obj).write(jSONStringer, bool);
        } else if (obj instanceof JsonMap) {
            ((JsonMap) obj).write(jSONStringer, bool);
        } else {
            jSONStringer.value(obj);
        }
    }

    @NonNull
    public static JsonValue wrap(@Nullable String str) {
        return wrapOpt(str);
    }

    @NonNull
    public static JsonValue wrap(char c) {
        return wrapOpt(Character.valueOf(c));
    }

    @NonNull
    public static JsonValue wrap(int i) {
        return wrapOpt(Integer.valueOf(i));
    }

    @NonNull
    public static JsonValue wrap(long j) {
        return wrapOpt(Long.valueOf(j));
    }

    @NonNull
    public static JsonValue wrap(boolean z) {
        return wrapOpt(Boolean.valueOf(z));
    }

    @NonNull
    public static JsonValue wrap(double d) {
        Double dValueOf = Double.valueOf(d);
        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
            return NULL;
        }
        return wrapOpt(Double.valueOf(d));
    }

    @NonNull
    public static JsonValue wrap(@Nullable JsonSerializable jsonSerializable) {
        return wrapOpt(jsonSerializable);
    }

    @NonNull
    public static JsonValue wrapOpt(@Nullable Object obj) {
        return wrap(obj, NULL);
    }

    @NonNull
    public static JsonValue wrap(@Nullable Object obj, @NonNull JsonValue jsonValue) {
        try {
            return wrap(obj);
        } catch (JsonException unused) {
            return jsonValue;
        }
    }

    @NonNull
    public static JsonValue wrap(@Nullable Object obj) throws JsonException {
        if (obj == null || obj == JSONObject.NULL) {
            return NULL;
        }
        if (obj instanceof JsonValue) {
            return (JsonValue) obj;
        }
        if ((obj instanceof JsonMap) || (obj instanceof JsonList) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
            return new JsonValue(obj);
        }
        if (obj instanceof JsonSerializable) {
            return ((JsonSerializable) obj).toJsonValue();
        }
        if ((obj instanceof Byte) || (obj instanceof Short)) {
            return new JsonValue(Integer.valueOf(((Number) obj).intValue()));
        }
        if (obj instanceof Character) {
            return new JsonValue(((Character) obj).toString());
        }
        if (obj instanceof Float) {
            return new JsonValue(Double.valueOf(((Number) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                throw new JsonException("Invalid Double value: " + d);
            }
            return new JsonValue(obj);
        }
        try {
            if (obj instanceof JSONArray) {
                return wrapJSONArray((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                return wrapJSONObject((JSONObject) obj);
            }
            if (obj instanceof Collection) {
                return wrapCollection((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return wrapArray(obj);
            }
            if (obj instanceof Map) {
                return wrapMap((Map) obj);
            }
            throw new JsonException("Illegal object: " + obj);
        } catch (JsonException e) {
            throw e;
        } catch (Exception e2) {
            throw new JsonException("Failed to wrap value.", e2);
        }
    }

    private static JsonValue wrapArray(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                arrayList.add(wrap(obj2));
            }
        }
        return new JsonValue(new JsonList(arrayList));
    }

    private static JsonValue wrapCollection(Collection collection) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(wrap(obj));
            }
        }
        return new JsonValue(new JsonList(arrayList));
    }

    private static JsonValue wrapMap(Map map) throws JsonException {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new JsonException("Only string map keys are accepted.");
            }
            if (entry.getValue() != null) {
                map2.put((String) entry.getKey(), wrap(entry.getValue()));
            }
        }
        return new JsonValue(new JsonMap(map2));
    }

    private static JsonValue wrapJSONArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jSONArray.isNull(i)) {
                arrayList.add(wrap(jSONArray.opt(i)));
            }
        }
        return new JsonValue(new JsonList(arrayList));
    }

    private static JsonValue wrapJSONObject(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject.isNull(next)) {
                map.put(next, wrap(jSONObject.opt(next)));
            }
        }
        return new JsonValue(new JsonMap(map));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(toString());
    }
}
