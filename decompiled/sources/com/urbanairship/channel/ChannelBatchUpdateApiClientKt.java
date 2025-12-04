package com.urbanairship.channel;

import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\u0004"}, d2 = {"tagsPayload", "Lcom/urbanairship/json/JsonMap;", "", "Lcom/urbanairship/channel/TagGroupsMutation;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelBatchUpdateApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelBatchUpdateApiClient.kt\ncom/urbanairship/channel/ChannelBatchUpdateApiClientKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1855#2:117\n1856#2:145\n215#3:118\n216#3:126\n215#3:127\n216#3:135\n215#3:136\n216#3:144\n372#4,7:119\n372#4,7:128\n372#4,7:137\n1#5:146\n*S KotlinDebug\n*F\n+ 1 ChannelBatchUpdateApiClient.kt\ncom/urbanairship/channel/ChannelBatchUpdateApiClientKt\n*L\n94#1:117\n94#1:145\n95#1:118\n95#1:126\n98#1:127\n98#1:135\n101#1:136\n101#1:144\n96#1:119,7\n99#1:128,7\n102#1:137,7\n*E\n"})
/* loaded from: classes5.dex */
public final class ChannelBatchUpdateApiClientKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonMap tagsPayload(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TagGroupsMutation tagGroupsMutation = (TagGroupsMutation) it.next();
            Map<String, Set<String>> addTags = tagGroupsMutation.addTags;
            Intrinsics.checkNotNullExpressionValue(addTags, "addTags");
            for (Map.Entry<String, Set<String>> entry : addTags.entrySet()) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                Object linkedHashSet = linkedHashMap.get(key);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    linkedHashMap.put(key, linkedHashSet);
                }
                Set<String> value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                ((Set) linkedHashSet).addAll(value);
            }
            Map<String, Set<String>> removeTags = tagGroupsMutation.removeTags;
            Intrinsics.checkNotNullExpressionValue(removeTags, "removeTags");
            for (Map.Entry<String, Set<String>> entry2 : removeTags.entrySet()) {
                String key2 = entry2.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                Object linkedHashSet2 = linkedHashMap2.get(key2);
                if (linkedHashSet2 == null) {
                    linkedHashSet2 = new LinkedHashSet();
                    linkedHashMap2.put(key2, linkedHashSet2);
                }
                Set<String> value2 = entry2.getValue();
                Intrinsics.checkNotNullExpressionValue(value2, "<get-value>(...)");
                ((Set) linkedHashSet2).addAll(value2);
            }
            Map<String, Set<String>> setTags = tagGroupsMutation.setTags;
            Intrinsics.checkNotNullExpressionValue(setTags, "setTags");
            for (Map.Entry<String, Set<String>> entry3 : setTags.entrySet()) {
                String key3 = entry3.getKey();
                Intrinsics.checkNotNullExpressionValue(key3, "<get-key>(...)");
                Object linkedHashSet3 = linkedHashMap3.get(key3);
                if (linkedHashSet3 == null) {
                    linkedHashSet3 = new LinkedHashSet();
                    linkedHashMap3.put(key3, linkedHashSet3);
                }
                Set<String> value3 = entry3.getValue();
                Intrinsics.checkNotNullExpressionValue(value3, "<get-value>(...)");
                ((Set) linkedHashSet3).addAll(value3);
            }
        }
        if (linkedHashMap.isEmpty() && linkedHashMap2.isEmpty() && linkedHashMap3.isEmpty()) {
            return null;
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        Pair pair = TuplesKt.to("add", linkedHashMap);
        if (linkedHashMap2.isEmpty()) {
            linkedHashMap2 = null;
        }
        Pair pair2 = TuplesKt.to(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, linkedHashMap2);
        if (linkedHashMap3.isEmpty()) {
            linkedHashMap3 = null;
        }
        return JsonExtensionsKt.jsonMapOf(pair, pair2, TuplesKt.to(AttributeMutation.ATTRIBUTE_ACTION_SET, linkedHashMap3));
    }
}
