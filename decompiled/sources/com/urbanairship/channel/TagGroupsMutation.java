package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class TagGroupsMutation implements JsonSerializable {
    public final Map<String, Set<String>> addTags;
    public final Map<String, Set<String>> removeTags;
    public final Map<String, Set<String>> setTags;

    private TagGroupsMutation(Map map, Map map2, Map map3) {
        this.addTags = map == null ? Collections.emptyMap() : map;
        this.removeTags = map2 == null ? Collections.emptyMap() : map2;
        this.setTags = map3 == null ? Collections.emptyMap() : map3;
    }

    @NonNull
    public static TagGroupsMutation newAddTagsMutation(@NonNull String str, @NonNull Set<String> set) {
        HashMap map = new HashMap();
        map.put(str, new HashSet(set));
        return new TagGroupsMutation(map, null, null);
    }

    @NonNull
    public static TagGroupsMutation newRemoveTagsMutation(@NonNull String str, @NonNull Set<String> set) {
        HashMap map = new HashMap();
        map.put(str, new HashSet(set));
        return new TagGroupsMutation(null, map, null);
    }

    @NonNull
    public static TagGroupsMutation newSetTagsMutation(@NonNull String str, @NonNull Set<String> set) {
        HashMap map = new HashMap();
        map.put(str, new HashSet(set));
        return new TagGroupsMutation(null, null, map);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static List<TagGroupsMutation> collapseMutations(@Nullable List<TagGroupsMutation> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (TagGroupsMutation tagGroupsMutation : list) {
            Map<String, Set<String>> map4 = tagGroupsMutation.addTags;
            if (map4 != null) {
                for (Map.Entry<String, Set<String>> entry : map4.entrySet()) {
                    Set<String> value = entry.getValue();
                    String strTrim = entry.getKey().trim();
                    if (!strTrim.isEmpty() && value != null && !value.isEmpty()) {
                        Set set = (Set) map3.get(strTrim);
                        if (set != null) {
                            set.addAll(value);
                        } else {
                            Set set2 = (Set) map2.get(strTrim);
                            if (set2 != null) {
                                set2.removeAll(value);
                                if (set2.isEmpty()) {
                                    map2.remove(strTrim);
                                }
                            }
                            Set hashSet = (Set) map.get(strTrim);
                            if (hashSet == null) {
                                hashSet = new HashSet();
                                map.put(strTrim, hashSet);
                            }
                            hashSet.addAll(value);
                        }
                    }
                }
            }
            Map<String, Set<String>> map5 = tagGroupsMutation.removeTags;
            if (map5 != null) {
                for (Map.Entry<String, Set<String>> entry2 : map5.entrySet()) {
                    Set<String> value2 = entry2.getValue();
                    String strTrim2 = entry2.getKey().trim();
                    if (!strTrim2.isEmpty() && value2 != null && !value2.isEmpty()) {
                        Set set3 = (Set) map3.get(strTrim2);
                        if (set3 != null) {
                            set3.removeAll(value2);
                        } else {
                            Set set4 = (Set) map.get(strTrim2);
                            if (set4 != null) {
                                set4.removeAll(value2);
                                if (set4.isEmpty()) {
                                    map.remove(strTrim2);
                                }
                            }
                            Set hashSet2 = (Set) map2.get(strTrim2);
                            if (hashSet2 == null) {
                                hashSet2 = new HashSet();
                                map2.put(strTrim2, hashSet2);
                            }
                            hashSet2.addAll(value2);
                        }
                    }
                }
            }
            Map<String, Set<String>> map6 = tagGroupsMutation.setTags;
            if (map6 != null) {
                for (Map.Entry<String, Set<String>> entry3 : map6.entrySet()) {
                    Set<String> value3 = entry3.getValue();
                    String strTrim3 = entry3.getKey().trim();
                    if (!strTrim3.isEmpty()) {
                        map3.put(strTrim3, value3 == null ? new HashSet() : new HashSet(value3));
                        map2.remove(strTrim3);
                        map.remove(strTrim3);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!map3.isEmpty()) {
            arrayList.add(new TagGroupsMutation(null, null, map3));
        }
        if (!map.isEmpty() || !map2.isEmpty()) {
            arrayList.add(new TagGroupsMutation(map, map2, null));
        }
        return arrayList;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Map<String, Set<String>> map = this.addTags;
        if (map != null && !map.isEmpty()) {
            builderNewBuilder.put("add", JsonValue.wrapOpt(this.addTags));
        }
        Map<String, Set<String>> map2 = this.removeTags;
        if (map2 != null && !map2.isEmpty()) {
            builderNewBuilder.put(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, JsonValue.wrapOpt(this.removeTags));
        }
        Map<String, Set<String>> map3 = this.setTags;
        if (map3 != null && !map3.isEmpty()) {
            builderNewBuilder.put(AttributeMutation.ATTRIBUTE_ACTION_SET, JsonValue.wrapOpt(this.setTags));
        }
        return builderNewBuilder.build().toJsonValue();
    }

    @NonNull
    public static TagGroupsMutation fromJsonValue(@NonNull JsonValue jsonValue) {
        JsonMap jsonMapOptMap = jsonValue.optMap();
        return new TagGroupsMutation(TagUtils.convertToTagsMap(jsonMapOptMap.opt("add")), TagUtils.convertToTagsMap(jsonMapOptMap.opt(AttributeMutation.ATTRIBUTE_ACTION_REMOVE)), TagUtils.convertToTagsMap(jsonMapOptMap.opt(AttributeMutation.ATTRIBUTE_ACTION_SET)));
    }

    @NonNull
    public static List<TagGroupsMutation> fromJsonList(@NonNull JsonList jsonList) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = jsonList.iterator();
        while (it.hasNext()) {
            arrayList.add(fromJsonValue(it.next()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TagGroupsMutation tagGroupsMutation = (TagGroupsMutation) obj;
        Map<String, Set<String>> map = this.addTags;
        if (map == null ? tagGroupsMutation.addTags != null : !map.equals(tagGroupsMutation.addTags)) {
            return false;
        }
        Map<String, Set<String>> map2 = this.removeTags;
        if (map2 == null ? tagGroupsMutation.removeTags != null : !map2.equals(tagGroupsMutation.removeTags)) {
            return false;
        }
        Map<String, Set<String>> map3 = this.setTags;
        return map3 != null ? map3.equals(tagGroupsMutation.setTags) : tagGroupsMutation.setTags == null;
    }

    public int hashCode() {
        Map<String, Set<String>> map = this.addTags;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Set<String>> map2 = this.removeTags;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Set<String>> map3 = this.setTags;
        return iHashCode2 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        return "TagGroupsMutation{addTags=" + this.addTags + ", removeTags=" + this.removeTags + ", setTags=" + this.setTags + '}';
    }

    public void apply(@NonNull Map<String, Set<String>> map) {
        Map<String, Set<String>> map2 = this.addTags;
        if (map2 != null) {
            for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
                Set<String> hashSet = map.get(entry.getKey());
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    map.put(entry.getKey(), hashSet);
                }
                hashSet.addAll(entry.getValue());
            }
        }
        Map<String, Set<String>> map3 = this.removeTags;
        if (map3 != null) {
            for (Map.Entry<String, Set<String>> entry2 : map3.entrySet()) {
                Set<String> set = map.get(entry2.getKey());
                if (set != null) {
                    set.removeAll(entry2.getValue());
                }
            }
        }
        Map<String, Set<String>> map4 = this.setTags;
        if (map4 != null) {
            for (Map.Entry<String, Set<String>> entry3 : map4.entrySet()) {
                map.put(entry3.getKey(), entry3.getValue());
            }
        }
    }
}
