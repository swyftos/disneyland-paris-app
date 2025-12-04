package com.urbanairship.json.matchers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PresenceMatcher extends ValueMatcher {

    @NonNull
    public static final String IS_PRESENT_VALUE_KEY = "is_present";
    private final boolean isPresent;

    public PresenceMatcher(boolean z) {
        this.isPresent = z;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().putOpt(IS_PRESENT_VALUE_KEY, Boolean.valueOf(this.isPresent)).build().toJsonValue();
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NonNull JsonValue jsonValue, boolean z) {
        if (this.isPresent) {
            return !jsonValue.isNull();
        }
        return jsonValue.isNull();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.isPresent == ((PresenceMatcher) obj).isPresent;
    }

    public int hashCode() {
        return this.isPresent ? 1 : 0;
    }
}
