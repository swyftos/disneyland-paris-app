package com.urbanairship.json.matchers;

import androidx.annotation.RestrictTo;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0013\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/json/matchers/ExactValueMatcher;", "Lcom/urbanairship/json/ValueMatcher;", "expected", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "apply", "", "value", "ignoreCase", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "equalsIgnoreCase", "valueOne", "valueTwo", "hashCode", "", "toJsonValue", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ExactValueMatcher extends ValueMatcher {

    @NotNull
    public static final String EQUALS_VALUE_KEY = "equals";
    private final JsonValue expected;

    public ExactValueMatcher(@NotNull JsonValue expected) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.expected = expected;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(EQUALS_VALUE_KEY, this.expected)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NotNull JsonValue value, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (ignoreCase) {
            return equalsIgnoreCase(value, this.expected);
        }
        return Intrinsics.areEqual(value, this.expected);
    }

    private final boolean equalsIgnoreCase(JsonValue valueOne, JsonValue valueTwo) {
        if (valueOne.isString() && valueTwo.isString()) {
            return StringsKt.equals(valueOne.optString(), valueTwo.optString(), true);
        }
        if (valueOne.isJsonList() && valueTwo.isJsonList()) {
            JsonList jsonListOptList = valueOne.optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            JsonList jsonListOptList2 = valueTwo.optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList2, "optList(...)");
            if (jsonListOptList.size() != jsonListOptList2.size()) {
                return false;
            }
            int size = jsonListOptList.size();
            for (int i = 0; i < size; i++) {
                JsonValue jsonValue = jsonListOptList.get(i);
                Intrinsics.checkNotNullExpressionValue(jsonValue, "get(...)");
                JsonValue jsonValue2 = jsonListOptList2.get(i);
                Intrinsics.checkNotNullExpressionValue(jsonValue2, "get(...)");
                if (!equalsIgnoreCase(jsonValue, jsonValue2)) {
                    return false;
                }
            }
            return true;
        }
        if (valueOne.isJsonMap() && valueTwo.isJsonMap()) {
            JsonMap jsonMapOptMap = valueOne.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            JsonMap jsonMapOptMap2 = valueTwo.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
            if (jsonMapOptMap.size() != jsonMapOptMap2.size()) {
                return false;
            }
            Iterator<Map.Entry<String, JsonValue>> it = jsonMapOptMap.iterator();
            while (it.hasNext()) {
                Map.Entry<String, JsonValue> next = it.next();
                Intrinsics.checkNotNull(next);
                String key = next.getKey();
                JsonValue value = next.getValue();
                JsonValue jsonValue3 = jsonMapOptMap2.get(key);
                if (jsonValue3 == null) {
                    return false;
                }
                Intrinsics.checkNotNull(value);
                if (!equalsIgnoreCase(value, jsonValue3)) {
                    return false;
                }
            }
            return true;
        }
        return Intrinsics.areEqual(valueOne, valueTwo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(ExactValueMatcher.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.expected, ((ExactValueMatcher) other).expected);
    }

    public int hashCode() {
        return this.expected.hashCode();
    }
}
