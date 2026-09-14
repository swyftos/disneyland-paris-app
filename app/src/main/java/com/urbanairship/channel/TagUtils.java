package com.urbanairship.channel;

import com.urbanairship.UALog;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
abstract class TagUtils {
    static Set normalizeTags(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                UALog.m1741d("Null tag was removed from set.", new Object[0]);
            } else {
                String strTrim = str.trim();
                if (strTrim.length() <= 0 || strTrim.length() > 127) {
                    UALog.m1744e("Tag with zero or greater than max length was removed from set: %s", strTrim);
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
            for (Map.Entry<String, JsonValue> entry : jsonValue.optMap()) {
                HashSet hashSet = new HashSet();
                for (JsonValue jsonValue2 : entry.getValue().optList()) {
                    if (jsonValue2.isString()) {
                        hashSet.add(jsonValue2.getString());
                    }
                }
                map.put(entry.getKey(), hashSet);
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }
}
