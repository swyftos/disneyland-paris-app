package com.urbanairship.channel;

import com.urbanairship.UALog;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
abstract class TagUtils {
    static Set normalizeTags(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                UALog.d("Null tag was removed from set.", new Object[0]);
            } else {
                String strTrim = str.trim();
                if (strTrim.length() <= 0 || strTrim.length() > 127) {
                    UALog.e("Tag with zero or greater than max length was removed from set: %s", strTrim);
                } else {
                    hashSet.add(strTrim);
                }
            }
        }
        return hashSet;
    }

    static Map convertToTagsMap(JsonValue jsonValue) {
        if (jsonValue == null || jsonValue.isNull()) {
            return null;
        }
        HashMap map = new HashMap();
        if (jsonValue.isJsonMap()) {
            Iterator<Map.Entry<String, JsonValue>> it = jsonValue.optMap().iterator();
            while (it.hasNext()) {
                Map.Entry<String, JsonValue> next = it.next();
                HashSet hashSet = new HashSet();
                Iterator<JsonValue> it2 = next.getValue().optList().iterator();
                while (it2.hasNext()) {
                    JsonValue next2 = it2.next();
                    if (next2.isString()) {
                        hashSet.add(next2.getString());
                    }
                }
                map.put(next.getKey(), hashSet);
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }
}
