package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class JsonMatcher implements JsonSerializable, Predicate<JsonSerializable> {
    private final Boolean ignoreCase;
    private final String key;
    private final List scopeList;
    private final ValueMatcher value;

    private JsonMatcher(Builder builder) {
        this.key = builder.key;
        this.scopeList = builder.scope;
        this.value = builder.valueMatcher == null ? ValueMatcher.newIsPresentMatcher() : builder.valueMatcher;
        this.ignoreCase = builder.ignoreCase;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().putOpt("key", this.key).putOpt(Action.SCOPE_ATTRIBUTE, this.scopeList).put("value", this.value).putOpt("ignore_case", this.ignoreCase).build().getJsonValue();
    }

    @Override // com.urbanairship.Predicate
    public boolean apply(@Nullable JsonSerializable jsonSerializable) {
        JsonValue jsonValue = jsonSerializable == null ? JsonValue.NULL : jsonSerializable.getJsonValue();
        Iterator it = this.scopeList.iterator();
        while (it.hasNext()) {
            jsonValue = jsonValue.optMap().opt((String) it.next());
            if (jsonValue.isNull()) {
                break;
            }
        }
        if (this.key != null) {
            jsonValue = jsonValue.optMap().opt(this.key);
        }
        ValueMatcher valueMatcher = this.value;
        Boolean bool = this.ignoreCase;
        return valueMatcher.apply(jsonValue, bool != null && bool.booleanValue());
    }

    @NonNull
    public static JsonMatcher parse(@Nullable JsonValue jsonValue) throws JsonException {
        if (jsonValue == null || !jsonValue.isJsonMap() || jsonValue.optMap().isEmpty()) {
            throw new JsonException("Unable to parse empty JsonValue: " + jsonValue);
        }
        JsonMap jsonMapOptMap = jsonValue.optMap();
        if (!jsonMapOptMap.containsKey("value")) {
            throw new JsonException("JsonMatcher must contain a value matcher.");
        }
        Builder valueMatcher = newBuilder().setKey(jsonMapOptMap.opt("key").getString()).setValueMatcher(ValueMatcher.parse(jsonMapOptMap.get("value")));
        JsonValue jsonValueOpt = jsonMapOptMap.opt(Action.SCOPE_ATTRIBUTE);
        if (jsonValueOpt.isString()) {
            valueMatcher.setScope(jsonValueOpt.optString());
        } else if (jsonValueOpt.isJsonList()) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = jsonValueOpt.optList().getList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getString());
            }
            valueMatcher.setScope(arrayList);
        }
        if (jsonMapOptMap.containsKey("ignore_case")) {
            valueMatcher.setIgnoreCase(jsonMapOptMap.opt("ignore_case").getBoolean(false));
        }
        return valueMatcher.build();
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Boolean ignoreCase;
        private String key;
        private List scope;
        private ValueMatcher valueMatcher;

        private Builder() {
            this.scope = new ArrayList(1);
        }

        @NonNull
        public Builder setValueMatcher(@Nullable ValueMatcher valueMatcher) {
            this.valueMatcher = valueMatcher;
            return this;
        }

        @NonNull
        public Builder setScope(@Nullable List<String> list) {
            ArrayList arrayList = new ArrayList();
            this.scope = arrayList;
            if (list != null) {
                arrayList.addAll(list);
            }
            return this;
        }

        @NonNull
        public Builder setScope(@NonNull String str) {
            ArrayList arrayList = new ArrayList();
            this.scope = arrayList;
            arrayList.add(str);
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            this.key = str;
            return this;
        }

        Builder setIgnoreCase(boolean z) {
            this.ignoreCase = Boolean.valueOf(z);
            return this;
        }

        @NonNull
        public JsonMatcher build() {
            return new JsonMatcher(this);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonMatcher jsonMatcher = (JsonMatcher) obj;
        String str = this.key;
        if (str == null ? jsonMatcher.key != null : !str.equals(jsonMatcher.key)) {
            return false;
        }
        if (!this.scopeList.equals(jsonMatcher.scopeList)) {
            return false;
        }
        Boolean bool = this.ignoreCase;
        if (bool == null ? jsonMatcher.ignoreCase == null : bool.equals(jsonMatcher.ignoreCase)) {
            return this.value.equals(jsonMatcher.value);
        }
        return false;
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.scopeList.hashCode()) * 31) + this.value.hashCode()) * 31;
        Boolean bool = this.ignoreCase;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
