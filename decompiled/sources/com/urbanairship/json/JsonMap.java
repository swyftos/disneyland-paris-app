package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.UALog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONStringer;

/* loaded from: classes5.dex */
public class JsonMap implements Iterable<Map.Entry<String, JsonValue>>, JsonSerializable {

    @NonNull
    public static final JsonMap EMPTY_MAP = new JsonMap(null);
    private final Map map;

    public JsonMap(@Nullable Map<String, JsonValue> map) {
        this.map = map == null ? new HashMap() : new HashMap(map);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean containsKey(@NonNull String str) {
        return this.map.containsKey(str);
    }

    public boolean containsValue(@NonNull JsonValue jsonValue) {
        return this.map.containsValue(jsonValue);
    }

    @NonNull
    public Set<Map.Entry<String, JsonValue>> entrySet() {
        return this.map.entrySet();
    }

    @Nullable
    public JsonValue get(@NonNull String str) {
        return (JsonValue) this.map.get(str);
    }

    @NonNull
    public JsonValue opt(@NonNull String str) {
        JsonValue jsonValue = get(str);
        return jsonValue != null ? jsonValue : JsonValue.NULL;
    }

    @NonNull
    public JsonValue require(@NonNull String str) throws JsonException {
        JsonValue jsonValue = get(str);
        if (jsonValue != null) {
            return jsonValue;
        }
        throw new JsonException("Expected value for key: " + str);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @NonNull
    public Set<String> keySet() {
        return this.map.keySet();
    }

    public int size() {
        return this.map.size();
    }

    @NonNull
    public Collection<JsonValue> values() {
        return new ArrayList(this.map.values());
    }

    @NonNull
    public Map<String, JsonValue> getMap() {
        return new HashMap(this.map);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JsonMap) {
            return this.map.equals(((JsonMap) obj).map);
        }
        if (obj instanceof JsonValue) {
            return this.map.equals(((JsonValue) obj).optMap().map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    @NonNull
    public String toString() {
        return toString(Boolean.FALSE);
    }

    @NonNull
    public String toString(@NonNull Boolean bool) {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            write(jSONStringer, bool);
            return jSONStringer.toString();
        } catch (StringIndexOutOfBoundsException | JSONException e) {
            UALog.e(e, "JsonMap - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List] */
    void write(JSONStringer jSONStringer, Boolean bool) {
        jSONStringer.object();
        Set<Map.Entry<String, JsonValue>> setEntrySet = entrySet();
        if (bool.booleanValue()) {
            ?? arrayList = new ArrayList(entrySet());
            Collections.sort(arrayList, new Comparator() { // from class: com.urbanairship.json.JsonMap.1
                @Override // java.util.Comparator
                public int compare(Map.Entry entry, Map.Entry entry2) {
                    return ((String) entry.getKey()).compareTo((String) entry2.getKey());
                }
            });
            setEntrySet = arrayList;
        }
        for (Map.Entry<String, JsonValue> entry : setEntrySet) {
            jSONStringer.key(entry.getKey());
            entry.getValue().write(jSONStringer, bool);
        }
        jSONStringer.endObject();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<String, JsonValue>> iterator() {
        return entrySet().iterator();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonValue.wrap((JsonSerializable) this);
    }

    public static class Builder {
        private final Map map;

        private Builder() {
            this.map = new HashMap();
        }

        @NonNull
        public Builder putAll(@NonNull JsonMap jsonMap) {
            for (Map.Entry<String, JsonValue> entry : jsonMap.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @Nullable JsonSerializable jsonSerializable) {
            if (jsonSerializable == null) {
                this.map.remove(str);
            } else {
                JsonValue jsonValue = jsonSerializable.toJsonValue();
                if (jsonValue.isNull()) {
                    this.map.remove(str);
                } else {
                    this.map.put(str, jsonValue);
                }
            }
            return this;
        }

        @NonNull
        public Builder putOpt(@NonNull String str, @Nullable Object obj) {
            put(str, JsonValue.wrapOpt(obj));
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @Nullable String str2) {
            if (str2 != null) {
                put(str, JsonValue.wrap(str2));
            } else {
                this.map.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, boolean z) {
            return put(str, JsonValue.wrap(z));
        }

        @NonNull
        public Builder put(@NonNull String str, int i) {
            return put(str, JsonValue.wrap(i));
        }

        @NonNull
        public Builder put(@NonNull String str, long j) {
            return put(str, JsonValue.wrap(j));
        }

        @NonNull
        public Builder put(@NonNull String str, double d) {
            return put(str, JsonValue.wrap(d));
        }

        @NonNull
        public Builder put(@NonNull String str, char c) {
            return put(str, JsonValue.wrap(c));
        }

        @NonNull
        public JsonMap build() {
            return new JsonMap(this.map);
        }
    }
}
