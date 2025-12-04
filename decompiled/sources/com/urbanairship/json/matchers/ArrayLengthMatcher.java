package com.urbanairship.json.matchers;

import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0014J\u0013\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/json/matchers/ArrayLengthMatcher;", "Lcom/urbanairship/json/ValueMatcher;", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "(Lcom/urbanairship/json/JsonPredicate;)V", "apply", "", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "ignoreCase", ExactValueMatcher.EQUALS_VALUE_KEY, "o", "", "hashCode", "", "toJsonValue", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ArrayLengthMatcher extends ValueMatcher {

    @NotNull
    public static final String ARRAY_LENGTH_KEY = "array_length";
    private final JsonPredicate predicate;

    public ArrayLengthMatcher(@NotNull JsonPredicate predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.predicate = predicate;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().putOpt(ARRAY_LENGTH_KEY, this.predicate).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NotNull JsonValue jsonValue, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        if (!jsonValue.isJsonList()) {
            return false;
        }
        JsonList jsonListOptList = jsonValue.optList();
        Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
        return this.predicate.apply((JsonSerializable) JsonValue.wrap(jsonListOptList.size()));
    }

    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !Intrinsics.areEqual(ArrayLengthMatcher.class, o.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.predicate, ((ArrayLengthMatcher) o).predicate);
    }

    public int hashCode() {
        return this.predicate.hashCode() * 31;
    }
}
