package com.urbanairship.json.matchers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import com.urbanairship.util.IvyVersionMatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class VersionMatcher extends ValueMatcher {

    @NonNull
    public static final String ALTERNATE_VERSION_KEY = "version";

    @NonNull
    public static final String VERSION_KEY = "version_matches";
    private final IvyVersionMatcher versionMatcher;

    public VersionMatcher(@NonNull IvyVersionMatcher ivyVersionMatcher) {
        this.versionMatcher = ivyVersionMatcher;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().putOpt(VERSION_KEY, this.versionMatcher).build().getJsonValue();
    }

    @Override // com.urbanairship.json.ValueMatcher
    protected boolean apply(@NonNull JsonValue jsonValue, boolean z) {
        return jsonValue.isString() && this.versionMatcher.apply(jsonValue.getString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.versionMatcher.equals(((VersionMatcher) obj).versionMatcher);
    }

    public int hashCode() {
        return this.versionMatcher.hashCode();
    }
}
