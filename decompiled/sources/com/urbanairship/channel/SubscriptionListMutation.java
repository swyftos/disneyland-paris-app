package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
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
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class SubscriptionListMutation implements JsonSerializable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String ACTION_SUBSCRIBE = "subscribe";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String ACTION_UNSUBSCRIBE = "unsubscribe";
    private final String action;
    private final String listId;
    private final String timestamp;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SubscriptionListMutation(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        this.action = str;
        this.listId = str2;
        this.timestamp = str3;
    }

    @NonNull
    public static SubscriptionListMutation newSubscribeMutation(@NonNull String str, long j) {
        return new SubscriptionListMutation("subscribe", str, DateUtils.createIso8601TimeStamp(j));
    }

    @NonNull
    public static SubscriptionListMutation newUnsubscribeMutation(@NonNull String str, long j) {
        return new SubscriptionListMutation("unsubscribe", str, DateUtils.createIso8601TimeStamp(j));
    }

    @NonNull
    public static SubscriptionListMutation fromJsonValue(@NonNull JsonValue jsonValue) throws JsonException {
        JsonMap jsonMapOptMap = jsonValue.optMap();
        String string = jsonMapOptMap.opt("action").getString();
        String string2 = jsonMapOptMap.opt("list_id").getString();
        String string3 = jsonMapOptMap.opt("timestamp").getString();
        if (string == null || string2 == null) {
            throw new JsonException("Invalid subscription list mutation: " + jsonMapOptMap);
        }
        return new SubscriptionListMutation(string, string2, string3);
    }

    @NonNull
    public static List<SubscriptionListMutation> fromJsonList(@NonNull JsonList jsonList) {
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
        return JsonMap.newBuilder().put("action", this.action).put("list_id", this.listId).put("timestamp", this.timestamp).build().getJsonValue();
    }

    public static List<SubscriptionListMutation> collapseMutations(List<SubscriptionListMutation> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SubscriptionListMutation> arrayList2 = new ArrayList(list);
        Collections.reverse(arrayList2);
        HashSet hashSet = new HashSet();
        for (SubscriptionListMutation subscriptionListMutation : arrayList2) {
            if (!hashSet.contains(subscriptionListMutation.listId)) {
                arrayList.add(0, subscriptionListMutation);
                hashSet.add(subscriptionListMutation.listId);
            }
        }
        return arrayList;
    }

    public void apply(Set<String> set) {
        if (getAction().equals("subscribe")) {
            set.add(getListId());
        } else {
            set.remove(getListId());
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getAction() {
        return this.action;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getListId() {
        return this.listId;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubscriptionListMutation subscriptionListMutation = (SubscriptionListMutation) obj;
        return this.action.equals(subscriptionListMutation.action) && this.listId.equals(subscriptionListMutation.listId) && ObjectsCompat.equals(this.timestamp, subscriptionListMutation.timestamp);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.action, this.listId, this.timestamp);
    }

    public String toString() {
        return "SubscriptionListMutation{action='" + this.action + CoreConstants.SINGLE_QUOTE_CHAR + ", listId='" + this.listId + CoreConstants.SINGLE_QUOTE_CHAR + ", timestamp='" + this.timestamp + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
