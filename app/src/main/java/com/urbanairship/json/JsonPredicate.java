package com.urbanairship.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.Predicate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class JsonPredicate implements JsonSerializable, Predicate<JsonSerializable> {

    @NonNull
    public static final String AND_PREDICATE_TYPE = "and";

    @NonNull
    public static final String NOT_PREDICATE_TYPE = "not";

    @NonNull
    public static final String OR_PREDICATE_TYPE = "or";
    private final List items;
    private final String type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PredicateType {
    }

    private JsonPredicate(Builder builder) {
        this.items = builder.items;
        this.type = builder.type;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().put(this.type, JsonValue.wrapOpt(this.items)).build().toJsonValue();
    }

    @NonNull
    public static JsonPredicate parse(@Nullable JsonValue jsonValue) throws JsonException {
        if (jsonValue == null || !jsonValue.isJsonMap() || jsonValue.optMap().isEmpty()) {
            throw new JsonException("Unable to parse empty JsonValue: " + jsonValue);
        }
        JsonMap jsonMapOptMap = jsonValue.optMap();
        Builder builderNewBuilder = newBuilder();
        String predicateType = getPredicateType(jsonMapOptMap);
        if (predicateType != null) {
            builderNewBuilder.setPredicateType(predicateType);
            JsonValue jsonValueOpt = jsonMapOptMap.opt(predicateType);
            JsonList jsonListOptList = jsonValueOpt.optList();
            if (NOT_PREDICATE_TYPE.equals(predicateType) && jsonValueOpt.isJsonMap()) {
                jsonListOptList = new JsonList(Collections.singletonList(jsonValueOpt.optMap().toJsonValue()));
            }
            for (JsonValue jsonValue2 : jsonListOptList) {
                if (jsonValue2.isJsonMap()) {
                    if (getPredicateType(jsonValue2.optMap()) != null) {
                        builderNewBuilder.addPredicate(parse(jsonValue2));
                    } else {
                        builderNewBuilder.addMatcher(JsonMatcher.parse(jsonValue2));
                    }
                }
            }
        } else {
            builderNewBuilder.addMatcher(JsonMatcher.parse(jsonValue));
        }
        try {
            return builderNewBuilder.build();
        } catch (IllegalArgumentException e) {
            throw new JsonException("Unable to parse JsonPredicate.", e);
        }
    }

    private static String getPredicateType(JsonMap jsonMap) {
        if (jsonMap.containsKey(AND_PREDICATE_TYPE)) {
            return AND_PREDICATE_TYPE;
        }
        if (jsonMap.containsKey(OR_PREDICATE_TYPE)) {
            return OR_PREDICATE_TYPE;
        }
        if (jsonMap.containsKey(NOT_PREDICATE_TYPE)) {
            return NOT_PREDICATE_TYPE;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    @Override // com.urbanairship.Predicate
    public boolean apply(@Nullable JsonSerializable jsonSerializable) {
        byte b;
        if (this.items.size() == 0) {
            return true;
        }
        String str = this.type;
        int iHashCode = str.hashCode();
        if (iHashCode != 3555) {
            if (iHashCode != 96727) {
                if (iHashCode == 109267 && str.equals(NOT_PREDICATE_TYPE)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(AND_PREDICATE_TYPE)) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals(OR_PREDICATE_TYPE)) {
            b = 2;
        } else {
            b = -1;
        }
        if (b == 0) {
            return !((Predicate) this.items.get(0)).apply(jsonSerializable);
        }
        if (b == 1) {
            Iterator it = this.items.iterator();
            while (it.hasNext()) {
                if (!((Predicate) it.next()).apply(jsonSerializable)) {
                    return false;
                }
            }
            return true;
        }
        Iterator it2 = this.items.iterator();
        while (it2.hasNext()) {
            if (((Predicate) it2.next()).apply(jsonSerializable)) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private String type = JsonPredicate.OR_PREDICATE_TYPE;
        private final List items = new ArrayList();

        @NonNull
        public Builder setPredicateType(@NonNull String str) {
            this.type = str;
            return this;
        }

        @NonNull
        public Builder addMatcher(@NonNull JsonMatcher jsonMatcher) {
            this.items.add(jsonMatcher);
            return this;
        }

        @NonNull
        public Builder addPredicate(@NonNull JsonPredicate jsonPredicate) {
            this.items.add(jsonPredicate);
            return this;
        }

        @NonNull
        public JsonPredicate build() {
            if (this.type.equals(JsonPredicate.NOT_PREDICATE_TYPE) && this.items.size() > 1) {
                throw new IllegalArgumentException("`NOT` predicate type only supports a single matcher or predicate.");
            }
            if (this.items.isEmpty()) {
                throw new IllegalArgumentException("Predicate must contain at least 1 matcher or child predicate.");
            }
            return new JsonPredicate(this);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPredicate jsonPredicate = (JsonPredicate) obj;
        List list = this.items;
        if (list == null ? jsonPredicate.items != null : !list.equals(jsonPredicate.items)) {
            return false;
        }
        String str = this.type;
        if (str != null) {
            return str.equals(jsonPredicate.type);
        }
        return jsonPredicate.type == null;
    }

    public int hashCode() {
        List list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.type;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
