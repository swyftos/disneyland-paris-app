package com.urbanairship.channel;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.channel.LiveUpdateMutation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class AudienceUpdate implements JsonSerializable {
    private static final Companion Companion = new Companion(null);
    private final List attributes;
    private final List liveUpdates;
    private final List subscriptions;
    private final List tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudienceUpdate)) {
            return false;
        }
        AudienceUpdate audienceUpdate = (AudienceUpdate) obj;
        return Intrinsics.areEqual(this.tags, audienceUpdate.tags) && Intrinsics.areEqual(this.attributes, audienceUpdate.attributes) && Intrinsics.areEqual(this.subscriptions, audienceUpdate.subscriptions) && Intrinsics.areEqual(this.liveUpdates, audienceUpdate.liveUpdates);
    }

    public int hashCode() {
        List list = this.tags;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List list2 = this.attributes;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.subscriptions;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List list4 = this.liveUpdates;
        return iHashCode3 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "AudienceUpdate(tags=" + this.tags + ", attributes=" + this.attributes + ", subscriptions=" + this.subscriptions + ", liveUpdates=" + this.liveUpdates + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AudienceUpdate(List list, List list2, List list3, List list4) {
        this.tags = list;
        this.attributes = list2;
        this.subscriptions = list3;
        this.liveUpdates = list4;
    }

    public final List getTags() {
        return this.tags;
    }

    public final List getAttributes() {
        return this.attributes;
    }

    public final List getSubscriptions() {
        return this.subscriptions;
    }

    public final List getLiveUpdates() {
        return this.liveUpdates;
    }

    public AudienceUpdate(JsonMap json) throws JsonException {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JsonList jsonListOptList;
        JsonList jsonListOptList2;
        JsonList jsonListOptList3;
        JsonList jsonListOptList4;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue = json.get(FetchDeviceInfoAction.TAGS_KEY);
        ArrayList arrayList4 = null;
        if (jsonValue == null || (jsonListOptList4 = jsonValue.optList()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList4, 10));
            Iterator<JsonValue> it = jsonListOptList4.iterator();
            while (it.hasNext()) {
                TagGroupsMutation tagGroupsMutationFromJsonValue = TagGroupsMutation.fromJsonValue(it.next());
                Intrinsics.checkNotNullExpressionValue(tagGroupsMutationFromJsonValue, "fromJsonValue(...)");
                arrayList.add(tagGroupsMutationFromJsonValue);
            }
        }
        JsonValue jsonValue2 = json.get("attributes");
        if (jsonValue2 == null || (jsonListOptList3 = jsonValue2.optList()) == null) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList3, 10));
            Iterator<JsonValue> it2 = jsonListOptList3.iterator();
            while (it2.hasNext()) {
                AttributeMutation attributeMutationFromJsonValue = AttributeMutation.fromJsonValue(it2.next());
                Intrinsics.checkNotNullExpressionValue(attributeMutationFromJsonValue, "fromJsonValue(...)");
                arrayList2.add(attributeMutationFromJsonValue);
            }
        }
        JsonValue jsonValue3 = json.get("subscription_lists");
        if (jsonValue3 == null || (jsonListOptList2 = jsonValue3.optList()) == null) {
            arrayList3 = null;
        } else {
            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList2, 10));
            Iterator<JsonValue> it3 = jsonListOptList2.iterator();
            while (it3.hasNext()) {
                SubscriptionListMutation subscriptionListMutationFromJsonValue = SubscriptionListMutation.fromJsonValue(it3.next());
                Intrinsics.checkNotNullExpressionValue(subscriptionListMutationFromJsonValue, "fromJsonValue(...)");
                arrayList3.add(subscriptionListMutationFromJsonValue);
            }
        }
        JsonValue jsonValue4 = json.get("live_updates");
        if (jsonValue4 != null && (jsonListOptList = jsonValue4.optList()) != null) {
            arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
            for (JsonValue jsonValue5 : jsonListOptList) {
                LiveUpdateMutation.Companion companion = LiveUpdateMutation.INSTANCE;
                JsonMap jsonMapRequireMap = jsonValue5.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                arrayList4.add(companion.fromJson(jsonMapRequireMap));
            }
        }
        this(arrayList, arrayList2, arrayList3, arrayList4);
    }

    @Override // com.urbanairship.json.JsonSerializable
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(FetchDeviceInfoAction.TAGS_KEY, this.tags), TuplesKt.to("attributes", this.attributes), TuplesKt.to("subscription_lists", this.subscriptions), TuplesKt.to("live_updates", this.liveUpdates)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
