package com.urbanairship.json.matchers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ArrayContainsMatcher extends ValueMatcher {

    @NonNull
    public static final String ARRAY_CONTAINS_KEY = "array_contains";

    @NonNull
    public static final String INDEX_KEY = "index";
    private final Integer index;
    private final JsonPredicate predicate;

    public ArrayContainsMatcher(@NonNull JsonPredicate jsonPredicate, @Nullable Integer num) {
        this.predicate = jsonPredicate;
        this.index = num;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().putOpt(ARRAY_CONTAINS_KEY, this.predicate).putOpt("index", this.index).build().getJsonValue();
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NonNull JsonValue jsonValue, boolean z) {
        if (!jsonValue.isJsonList()) {
            return false;
        }
        JsonList jsonListOptList = jsonValue.optList();
        Integer num = this.index;
        if (num != null) {
            if (num.intValue() < 0 || this.index.intValue() >= jsonListOptList.size()) {
                return false;
            }
            return this.predicate.apply((JsonSerializable) jsonListOptList.get(this.index.intValue()));
        }
        Iterator<JsonValue> it = jsonListOptList.iterator();
        while (it.hasNext()) {
            if (this.predicate.apply((JsonSerializable) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayContainsMatcher arrayContainsMatcher = (ArrayContainsMatcher) obj;
        Integer num = this.index;
        if (num == null ? arrayContainsMatcher.index == null : num.equals(arrayContainsMatcher.index)) {
            return this.predicate.equals(arrayContainsMatcher.predicate);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.index;
        return ((num != null ? num.hashCode() : 0) * 31) + this.predicate.hashCode();
    }
}
