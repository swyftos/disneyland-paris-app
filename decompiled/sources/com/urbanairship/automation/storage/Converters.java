package com.urbanairship.automation.storage;

import androidx.annotation.RestrictTo;
import androidx.room.TypeConverter;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class Converters {
    @TypeConverter
    public static List<String> stringArrayFromString(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = JsonValue.parseString(str).optList().iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.getString() != null) {
                    arrayList.add(next.optString());
                }
            }
            return arrayList;
        } catch (JsonException e) {
            UALog.e(e, "Unable to parse string array from string: " + str, new Object[0]);
            return null;
        }
    }

    @TypeConverter
    public static String fromArrayList(List<String> list) {
        return JsonValue.wrapOpt(list).toString();
    }
}
