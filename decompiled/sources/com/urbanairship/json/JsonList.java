package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.UALog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONStringer;

/* loaded from: classes5.dex */
public class JsonList implements Iterable<JsonValue>, JsonSerializable {

    @NonNull
    public static final JsonList EMPTY_LIST = new JsonList(null);
    private final List list;

    public JsonList(@Nullable List<JsonValue> list) {
        this.list = list == null ? new ArrayList() : new ArrayList(list);
    }

    public boolean contains(@NonNull JsonValue jsonValue) {
        return this.list.contains(jsonValue);
    }

    @NonNull
    public JsonValue get(int i) {
        return (JsonValue) this.list.get(i);
    }

    public int indexOf(@NonNull JsonValue jsonValue) {
        return this.list.indexOf(jsonValue);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<JsonValue> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(@NonNull JsonValue jsonValue) {
        return this.list.indexOf(jsonValue);
    }

    public int size() {
        return this.list.size();
    }

    @NonNull
    public List<JsonValue> getList() {
        return new ArrayList(this.list);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JsonList) {
            return this.list.equals(((JsonList) obj).list);
        }
        return false;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NonNull
    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            write(jSONStringer, Boolean.FALSE);
            return jSONStringer.toString();
        } catch (StringIndexOutOfBoundsException | JSONException e) {
            UALog.e(e, "JsonList - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }

    void write(JSONStringer jSONStringer, Boolean bool) {
        jSONStringer.array();
        Iterator<JsonValue> it = iterator();
        while (it.hasNext()) {
            it.next().write(jSONStringer, bool);
        }
        jSONStringer.endArray();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonValue.wrap((JsonSerializable) this);
    }
}
