package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonMatcher;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.ValueMatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class VersionUtils {
    @NonNull
    public static JsonSerializable createVersionObject(long j) {
        return JsonMap.newBuilder().put(UAirship.shared().getPlatformType() == 1 ? "amazon" : "android", JsonMap.newBuilder().put("version", j).build()).build().getJsonValue();
    }

    @NonNull
    public static JsonPredicate createVersionPredicate(@NonNull ValueMatcher valueMatcher) {
        return JsonPredicate.newBuilder().addMatcher(JsonMatcher.newBuilder().setScope(UAirship.shared().getPlatformType() == 1 ? "amazon" : "android").setKey("version").setValueMatcher(valueMatcher).build()).build();
    }

    public static boolean isVersionNewer(String str, String str2) {
        try {
            return IvyVersionMatcher.newMatcher(String.format("]%s,)", str)).apply(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isVersionNewerOrEqualTo(String str, String str2) {
        try {
            return IvyVersionMatcher.newMatcher(String.format("[%s,)", str)).apply(str2);
        } catch (Exception unused) {
            return false;
        }
    }
}
