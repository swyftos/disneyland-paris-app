package com.urbanairship.contacts;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.contacts.AnonChannel;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 $2\u00020\u0001:\u0001$Be\b\u0000\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u001b\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u001b\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003Jg\u0010\u001c\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0007H\u0016J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/urbanairship/contacts/AnonContactData;", "Lcom/urbanairship/json/JsonSerializable;", "tagGroups", "", "", "", "attributes", "Lcom/urbanairship/json/JsonValue;", "subscriptionLists", "Lcom/urbanairship/contacts/Scope;", "associatedChannels", "", "Lcom/urbanairship/contacts/AnonChannel;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "getAssociatedChannels", "()Ljava/util/List;", "getAttributes", "()Ljava/util/Map;", "isEmpty", "", "isEmpty$urbanairship_core_release", "()Z", "getSubscriptionLists", "getTagGroups", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AnonContactData implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List associatedChannels;
    private final Map attributes;
    private final Map subscriptionLists;
    private final Map tagGroups;

    public AnonContactData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnonContactData copy$default(AnonContactData anonContactData, Map map, Map map2, Map map3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = anonContactData.tagGroups;
        }
        if ((i & 2) != 0) {
            map2 = anonContactData.attributes;
        }
        if ((i & 4) != 0) {
            map3 = anonContactData.subscriptionLists;
        }
        if ((i & 8) != 0) {
            list = anonContactData.associatedChannels;
        }
        return anonContactData.copy(map, map2, map3, list);
    }

    @NotNull
    public final Map<String, Set<String>> component1() {
        return this.tagGroups;
    }

    @NotNull
    public final Map<String, JsonValue> component2() {
        return this.attributes;
    }

    @NotNull
    public final Map<String, Set<Scope>> component3() {
        return this.subscriptionLists;
    }

    @NotNull
    public final List<AnonChannel> component4() {
        return this.associatedChannels;
    }

    @NotNull
    public final AnonContactData copy(@NotNull Map<String, ? extends Set<String>> tagGroups, @NotNull Map<String, ? extends JsonValue> attributes, @NotNull Map<String, ? extends Set<? extends Scope>> subscriptionLists, @NotNull List<AnonChannel> associatedChannels) {
        Intrinsics.checkNotNullParameter(tagGroups, "tagGroups");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(subscriptionLists, "subscriptionLists");
        Intrinsics.checkNotNullParameter(associatedChannels, "associatedChannels");
        return new AnonContactData(tagGroups, attributes, subscriptionLists, associatedChannels);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnonContactData)) {
            return false;
        }
        AnonContactData anonContactData = (AnonContactData) other;
        return Intrinsics.areEqual(this.tagGroups, anonContactData.tagGroups) && Intrinsics.areEqual(this.attributes, anonContactData.attributes) && Intrinsics.areEqual(this.subscriptionLists, anonContactData.subscriptionLists) && Intrinsics.areEqual(this.associatedChannels, anonContactData.associatedChannels);
    }

    public int hashCode() {
        return (((((this.tagGroups.hashCode() * 31) + this.attributes.hashCode()) * 31) + this.subscriptionLists.hashCode()) * 31) + this.associatedChannels.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnonContactData(tagGroups=" + this.tagGroups + ", attributes=" + this.attributes + ", subscriptionLists=" + this.subscriptionLists + ", associatedChannels=" + this.associatedChannels + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AnonContactData(@NotNull Map<String, ? extends Set<String>> tagGroups, @NotNull Map<String, ? extends JsonValue> attributes, @NotNull Map<String, ? extends Set<? extends Scope>> subscriptionLists, @NotNull List<AnonChannel> associatedChannels) {
        Intrinsics.checkNotNullParameter(tagGroups, "tagGroups");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(subscriptionLists, "subscriptionLists");
        Intrinsics.checkNotNullParameter(associatedChannels, "associatedChannels");
        this.tagGroups = tagGroups;
        this.attributes = attributes;
        this.subscriptionLists = subscriptionLists;
        this.associatedChannels = associatedChannels;
    }

    public /* synthetic */ AnonContactData(Map map, Map map2, Map map3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final Map<String, Set<String>> getTagGroups() {
        return this.tagGroups;
    }

    @NotNull
    public final Map<String, JsonValue> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final Map<String, Set<Scope>> getSubscriptionLists() {
        return this.subscriptionLists;
    }

    @NotNull
    public final List<AnonChannel> getAssociatedChannels() {
        return this.associatedChannels;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("tag_groups", this.tagGroups), TuplesKt.to("attributes", this.attributes), TuplesKt.to("subscription_lists", this.subscriptionLists), TuplesKt.to("associated_channels", this.associatedChannels)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public final boolean isEmpty$urbanairship_core_release() {
        return this.attributes.isEmpty() && this.tagGroups.isEmpty() && this.associatedChannels.isEmpty() && this.subscriptionLists.isEmpty();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/contacts/AnonContactData$Companion;", "", "()V", "ASSOCIATED_CHANNELS_KEY", "", "ATTRIBUTES_KEY", "SUBSCRIPTION_LISTS", "TAG_GROUPS_KEY", "fromJson", "Lcom/urbanairship/contacts/AnonContactData;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnonContactData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnonContactData.kt\ncom/urbanairship/contacts/AnonContactData$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n453#2:76\n403#2:77\n453#2:94\n403#2:95\n1238#3,2:78\n1603#3,9:80\n1855#3:89\n1856#3:91\n1612#3:92\n1241#3:93\n1238#3,2:96\n1603#3,9:98\n1855#3:107\n1856#3:109\n1612#3:110\n1241#3:111\n1603#3,9:112\n1855#3:121\n1856#3:123\n1612#3:124\n1#4:90\n1#4:108\n1#4:122\n*S KotlinDebug\n*F\n+ 1 AnonContactData.kt\ncom/urbanairship/contacts/AnonContactData$Companion\n*L\n37#1:76\n37#1:77\n41#1:94\n41#1:95\n37#1:78,2\n38#1:80,9\n38#1:89\n38#1:91\n38#1:92\n37#1:93\n41#1:96,2\n42#1:98,9\n42#1:107\n42#1:109\n42#1:110\n41#1:111\n44#1:112,9\n44#1:121\n44#1:123\n44#1:124\n38#1:90\n42#1:108\n44#1:122\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AnonContactData fromJson(@NotNull JsonValue jsonValue) throws JsonException {
            Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
            Map<String, JsonValue> map = jsonValue.optMap().opt("tag_groups").optMap().getMap();
            Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                JsonList jsonListOptList = ((JsonValue) entry.getValue()).optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                ArrayList arrayList = new ArrayList();
                Iterator<JsonValue> it2 = jsonListOptList.iterator();
                while (it2.hasNext()) {
                    String string = it2.next().getString();
                    if (string != null) {
                        arrayList.add(string);
                    }
                }
                linkedHashMap.put(key, CollectionsKt.toSet(arrayList));
            }
            Map<String, JsonValue> map2 = jsonValue.optMap().opt("attributes").optMap().getMap();
            Intrinsics.checkNotNullExpressionValue(map2, "getMap(...)");
            Map<String, JsonValue> map3 = jsonValue.optMap().opt("subscription_lists").optMap().getMap();
            Intrinsics.checkNotNullExpressionValue(map3, "getMap(...)");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map3.size()));
            Iterator<T> it3 = map3.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it3.next();
                Object key2 = entry2.getKey();
                JsonList jsonListOptList2 = ((JsonValue) entry2.getValue()).optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList2, "optList(...)");
                ArrayList arrayList2 = new ArrayList();
                Iterator<JsonValue> it4 = jsonListOptList2.iterator();
                while (it4.hasNext()) {
                    Scope scopeFromJson = Scope.fromJson(it4.next());
                    if (scopeFromJson != null) {
                        arrayList2.add(scopeFromJson);
                    }
                }
                linkedHashMap2.put(key2, CollectionsKt.toSet(arrayList2));
            }
            JsonList jsonListOptList3 = jsonValue.optMap().opt("associated_channels").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList3, "optList(...)");
            ArrayList arrayList3 = new ArrayList();
            for (JsonValue jsonValue2 : jsonListOptList3) {
                AnonChannel.Companion companion = AnonChannel.INSTANCE;
                Intrinsics.checkNotNull(jsonValue2);
                AnonChannel anonChannelFromJson = companion.fromJson(jsonValue2);
                if (anonChannelFromJson != null) {
                    arrayList3.add(anonChannelFromJson);
                }
            }
            return new AnonContactData(linkedHashMap, map2, linkedHashMap2, arrayList3);
        }
    }
}
