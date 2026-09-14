package com.urbanairship.automation.storage;

import androidx.annotation.RestrictTo;
import androidx.room.TypeConverter;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Converters {
    @TypeConverter
    public static List<String> stringArrayFromString(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            for (JsonValue jsonValue : JsonValue.parseString(str).optList()) {
                if (jsonValue.getString() != null) {
                    arrayList.add(jsonValue.optString());
                }
            }
            return arrayList;
        } catch (JsonException e) {
            UALog.m1746e(e, "Unable to parse string array from string: " + str, new Object[0]);
            return null;
        }
    }

    @TypeConverter
    public static String fromArrayList(List<String> list) {
        return JsonValue.wrapOpt(list).toString();
    }
}
