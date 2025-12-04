package com.urbanairship.contacts;

import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.TagGroupsMutation;
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
@SourceDebugExtension({"SMAP\nContactApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClientKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,563:1\n1855#2:564\n1856#2:592\n215#3:565\n216#3:573\n215#3:574\n216#3:582\n215#3:583\n216#3:591\n372#4,7:566\n372#4,7:575\n372#4,7:584\n1#5:593\n*S KotlinDebug\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClientKt\n*L\n541#1:564\n541#1:592\n542#1:565\n542#1:573\n545#1:574\n545#1:582\n548#1:583\n548#1:591\n543#1:566,7\n546#1:575,7\n549#1:584,7\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactApiClientKt {
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
