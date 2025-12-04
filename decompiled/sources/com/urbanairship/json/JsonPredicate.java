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

/* loaded from: classes5.dex */
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
            Iterator<JsonValue> it = jsonListOptList.iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.isJsonMap()) {
                    if (getPredicateType(next.optMap()) != null) {
                        builderNewBuilder.addPredicate(parse(next));
                    } else {
                        builderNewBuilder.addMatcher(JsonMatcher.parse(next));
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    @Override // com.urbanairship.Predicate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean apply(@androidx.annotation.Nullable com.urbanairship.json.JsonSerializable r6) {
        /*
            r5 = this;
            java.util.List r0 = r5.items
            int r0 = r0.size()
            r1 = 1
            if (r0 != 0) goto La
            return r1
        La:
            java.lang.String r0 = r5.type
            int r2 = r0.hashCode()
            r3 = 3555(0xde3, float:4.982E-42)
            r4 = 0
            if (r2 == r3) goto L34
            r3 = 96727(0x179d7, float:1.35543E-40)
            if (r2 == r3) goto L2a
            r3 = 109267(0x1aad3, float:1.53116E-40)
            if (r2 == r3) goto L20
            goto L3e
        L20:
            java.lang.String r2 = "not"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3e
            r0 = r4
            goto L3f
        L2a:
            java.lang.String r2 = "and"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3e
            r0 = r1
            goto L3f
        L34:
            java.lang.String r2 = "or"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3e
            r0 = 2
            goto L3f
        L3e:
            r0 = -1
        L3f:
            if (r0 == 0) goto L77
            if (r0 == r1) goto L5d
            java.util.List r5 = r5.items
            java.util.Iterator r5 = r5.iterator()
        L49:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L5c
            java.lang.Object r0 = r5.next()
            com.urbanairship.Predicate r0 = (com.urbanairship.Predicate) r0
            boolean r0 = r0.apply(r6)
            if (r0 == 0) goto L49
            return r1
        L5c:
            return r4
        L5d:
            java.util.List r5 = r5.items
            java.util.Iterator r5 = r5.iterator()
        L63:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L76
            java.lang.Object r0 = r5.next()
            com.urbanairship.Predicate r0 = (com.urbanairship.Predicate) r0
            boolean r0 = r0.apply(r6)
            if (r0 != 0) goto L63
            return r4
        L76:
            return r1
        L77:
            java.util.List r5 = r5.items
            java.lang.Object r5 = r5.get(r4)
            com.urbanairship.Predicate r5 = (com.urbanairship.Predicate) r5
            boolean r5 = r5.apply(r6)
            r5 = r5 ^ r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.json.JsonPredicate.apply(com.urbanairship.json.JsonSerializable):boolean");
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
        return str != null ? str.equals(jsonPredicate.type) : jsonPredicate.type == null;
    }

    public int hashCode() {
        List list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.type;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
