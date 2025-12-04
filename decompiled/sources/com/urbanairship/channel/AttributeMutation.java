package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.DateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class AttributeMutation implements JsonSerializable {
    public static final String ATTRIBUTE_ACTION_REMOVE = "remove";
    public static final String ATTRIBUTE_ACTION_SET = "set";
    public final String action;
    public final String name;
    public final String timestamp;
    public final JsonValue value;

    AttributeMutation(String str, String str2, JsonValue jsonValue, String str3) {
        this.action = str;
        this.name = str2;
        this.value = jsonValue;
        this.timestamp = str3;
    }

    @NonNull
    public static AttributeMutation newSetAttributeMutation(@NonNull String str, @NonNull JsonValue jsonValue, long j) {
        if (jsonValue.isNull()) {
            throw new IllegalArgumentException("Invalid attribute value: " + jsonValue);
        }
        return new AttributeMutation(ATTRIBUTE_ACTION_SET, str, jsonValue, DateUtils.createIso8601TimeStamp(j));
    }

    @NonNull
    public static AttributeMutation newRemoveAttributeMutation(@NonNull String str, long j) {
        return new AttributeMutation(ATTRIBUTE_ACTION_REMOVE, str, null, DateUtils.createIso8601TimeStamp(j));
    }

    static AttributeMutation fromJsonValue(JsonValue jsonValue) throws JsonException {
        JsonMap jsonMapOptMap = jsonValue.optMap();
        String string = jsonMapOptMap.opt("action").getString();
        String string2 = jsonMapOptMap.opt("key").getString();
        JsonValue jsonValue2 = jsonMapOptMap.get("value");
        String string3 = jsonMapOptMap.opt("timestamp").getString();
        if (string == null || string2 == null || (jsonValue2 != null && !isValidValue(jsonValue2))) {
            throw new JsonException("Invalid attribute mutation: " + jsonMapOptMap);
        }
        return new AttributeMutation(string, string2, jsonValue2, string3);
    }

    @NonNull
    public static List<AttributeMutation> fromJsonList(@NonNull JsonList jsonList) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = jsonList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(fromJsonValue(it.next()));
            } catch (JsonException e) {
                UALog.e(e, "Invalid attribute.", new Object[0]);
            }
        }
        return arrayList;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().put("action", this.action).put("key", this.name).put("value", this.value).put("timestamp", this.timestamp).build().getJsonValue();
    }

    @NonNull
    public static List<AttributeMutation> collapseMutations(@NonNull List<AttributeMutation> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<AttributeMutation> arrayList2 = new ArrayList(list);
        Collections.reverse(arrayList2);
        HashSet hashSet = new HashSet();
        for (AttributeMutation attributeMutation : arrayList2) {
            if (!hashSet.contains(attributeMutation.name)) {
                arrayList.add(0, attributeMutation);
                hashSet.add(attributeMutation.name);
            }
        }
        return arrayList;
    }

    private static boolean isValidValue(JsonValue jsonValue) {
        return (jsonValue.isNull() || jsonValue.isJsonList() || jsonValue.isBoolean()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AttributeMutation attributeMutation = (AttributeMutation) obj;
        if (!this.action.equals(attributeMutation.action) || !this.name.equals(attributeMutation.name)) {
            return false;
        }
        JsonValue jsonValue = this.value;
        if (jsonValue == null ? attributeMutation.value == null : jsonValue.equals(attributeMutation.value)) {
            return this.timestamp.equals(attributeMutation.timestamp);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.action.hashCode() * 31) + this.name.hashCode()) * 31;
        JsonValue jsonValue = this.value;
        return ((iHashCode + (jsonValue != null ? jsonValue.hashCode() : 0)) * 31) + this.timestamp.hashCode();
    }

    public String toString() {
        return "AttributeMutation{action='" + this.action + CoreConstants.SINGLE_QUOTE_CHAR + ", name='" + this.name + CoreConstants.SINGLE_QUOTE_CHAR + ", value=" + this.value + ", timestamp='" + this.timestamp + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
