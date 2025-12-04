package com.urbanairship.contacts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
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
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ScopedSubscriptionListMutation implements JsonSerializable {
    public static final String ACTION_SUBSCRIBE = "subscribe";
    public static final String ACTION_UNSUBSCRIBE = "unsubscribe";
    private final String action;
    private final String listId;
    private final Scope scope;
    private final String timestamp;

    ScopedSubscriptionListMutation(String str, String str2, Scope scope, String str3) {
        this.action = str;
        this.listId = str2;
        this.scope = scope;
        this.timestamp = str3;
    }

    @NonNull
    public static ScopedSubscriptionListMutation newSubscribeMutation(@NonNull String str, @NonNull Scope scope, long j) {
        return new ScopedSubscriptionListMutation("subscribe", str, scope, DateUtils.createIso8601TimeStamp(j));
    }

    @NonNull
    public static ScopedSubscriptionListMutation newUnsubscribeMutation(@NonNull String str, @NonNull Scope scope, long j) {
        return new ScopedSubscriptionListMutation("unsubscribe", str, scope, DateUtils.createIso8601TimeStamp(j));
    }

    @NonNull
    public static ScopedSubscriptionListMutation fromJsonValue(@NonNull JsonValue jsonValue) throws JsonException {
        JsonMap jsonMapOptMap = jsonValue.optMap();
        String string = jsonMapOptMap.opt("action").getString();
        String string2 = jsonMapOptMap.opt("list_id").getString();
        String string3 = jsonMapOptMap.opt("timestamp").getString();
        Scope scopeFromJson = Scope.fromJson(jsonMapOptMap.opt(Action.SCOPE_ATTRIBUTE));
        if (string == null || string2 == null) {
            throw new JsonException("Invalid subscription list mutation: " + jsonMapOptMap);
        }
        return new ScopedSubscriptionListMutation(string, string2, scopeFromJson, string3);
    }

    @NonNull
    public static List<ScopedSubscriptionListMutation> fromJsonList(@NonNull JsonList jsonList) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = jsonList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(fromJsonValue(it.next()));
            } catch (JsonException e) {
                UALog.e(e, "Invalid subscription list mutation!", new Object[0]);
            }
        }
        return arrayList;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().put("action", this.action).put("list_id", this.listId).put(Action.SCOPE_ATTRIBUTE, this.scope).put("timestamp", this.timestamp).build().getJsonValue();
    }

    @NonNull
    public String getAction() {
        return this.action;
    }

    @NonNull
    public String getListId() {
        return this.listId;
    }

    @Nullable
    public String getTimestamp() {
        return this.timestamp;
    }

    @NonNull
    public Scope getScope() {
        return this.scope;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScopedSubscriptionListMutation scopedSubscriptionListMutation = (ScopedSubscriptionListMutation) obj;
        return ObjectsCompat.equals(this.action, scopedSubscriptionListMutation.action) && ObjectsCompat.equals(this.listId, scopedSubscriptionListMutation.listId) && ObjectsCompat.equals(this.scope, scopedSubscriptionListMutation.scope) && ObjectsCompat.equals(this.timestamp, scopedSubscriptionListMutation.timestamp);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.action, this.listId, this.timestamp, this.scope);
    }

    public String toString() {
        return "ScopedSubscriptionListMutation{action='" + this.action + CoreConstants.SINGLE_QUOTE_CHAR + ", listId='" + this.listId + CoreConstants.SINGLE_QUOTE_CHAR + ", scope=" + this.scope + ", timestamp='" + this.timestamp + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }

    public static List<ScopedSubscriptionListMutation> collapseMutations(List<ScopedSubscriptionListMutation> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ScopedSubscriptionListMutation> arrayList2 = new ArrayList(list);
        Collections.reverse(arrayList2);
        HashSet hashSet = new HashSet();
        for (ScopedSubscriptionListMutation scopedSubscriptionListMutation : arrayList2) {
            String str = scopedSubscriptionListMutation.getScope() + ":" + scopedSubscriptionListMutation.getListId();
            if (!hashSet.contains(str)) {
                arrayList.add(0, scopedSubscriptionListMutation);
                hashSet.add(str);
            }
        }
        return arrayList;
    }

    public void apply(Map<String, Set<Scope>> map) {
        Set<Scope> hashSet = map.get(this.listId);
        String str = this.action;
        str.hashCode();
        if (str.equals("subscribe")) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
                map.put(this.listId, hashSet);
            }
            hashSet.add(this.scope);
        } else if (str.equals("unsubscribe") && hashSet != null) {
            hashSet.remove(this.scope);
        }
        if (hashSet == null || hashSet.isEmpty()) {
            map.remove(this.listId);
        }
    }
}
