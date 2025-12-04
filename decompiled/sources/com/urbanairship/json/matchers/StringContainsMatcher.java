package com.urbanairship.json.matchers;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0014J\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/json/matchers/StringContainsMatcher;", "Lcom/urbanairship/json/ValueMatcher;", "expected", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "getExpected$urbanairship_core_release", "()Lcom/urbanairship/json/JsonValue;", "apply", "", "value", "ignoreCase", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringContainsMatcher extends ValueMatcher {

    @NotNull
    public static final String STRING_CONTAINS = "string_contains";
    private final JsonValue expected;

    public StringContainsMatcher(@NotNull JsonValue expected) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.expected = expected;
    }

    @NotNull
    /* renamed from: getExpected$urbanairship_core_release, reason: from getter */
    public final JsonValue getExpected() {
        return this.expected;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(STRING_CONTAINS, this.expected)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NotNull JsonValue value, boolean ignoreCase) {
        String string;
        Intrinsics.checkNotNullParameter(value, "value");
        String string2 = value.getString();
        if (string2 == null || (string = this.expected.getString()) == null) {
            return false;
        }
        return StringsKt.contains(string2, string, ignoreCase);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(StringContainsMatcher.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.json.matchers.StringContainsMatcher");
        return Intrinsics.areEqual(this.expected, ((StringContainsMatcher) other).expected);
    }

    public int hashCode() {
        return this.expected.hashCode();
    }
}
