package com.disney.id.android.extensions;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.disney.id.android.AgeBand;
import com.disney.id.android.EditableField;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDSCALPController;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aB\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tH\u0002\u001a \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0000\u001a.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\b\u0012\u0004\u0012\u00020\u00190\u000e\u001a\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00190\u000e\u001a\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b*\b\u0012\u0004\u0012\u00020\u00190\u000e\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006 "}, d2 = {"ageBands", "Lorg/json/JSONObject;", "Lcom/disney/id/android/OneIDSCALPController;", "getAgeBands", "(Lcom/disney/id/android/OneIDSCALPController;)Lorg/json/JSONObject;", "compliance", "getCompliance", "flattenAgeBandTypeFields", "", "", "", "fieldMap", "root", "defaultTypeKeys", "", "getAgeBand", "band", "getAgeBandFields", "mode", "getEditableConfigFields", "ageBand", "getProfileContent", "Lcom/disney/id/android/OneID;", "jsonProfile", "getProfileFields", "Lcom/disney/id/android/EditableField;", "editableFieldMap", "getUpdateFields", "toJson", "Lcom/google/gson/JsonElement;", "toProfileJSON", "toProfileMap", "OneID_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEditableFieldExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditableFieldExtensions.kt\ncom/disney/id/android/extensions/EditableFieldExtensionsKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,452:1\n215#2,2:453\n1855#3,2:455\n1238#3,4:477\n1855#3,2:521\n766#3:548\n857#3,2:549\n766#3:551\n857#3,2:552\n800#3,11:554\n766#3:565\n857#3,2:566\n800#3,11:568\n1549#3:579\n1620#3,3:580\n11065#4:457\n11400#4,3:458\n11065#4:481\n11400#4,3:482\n11065#4:485\n11400#4,3:486\n11065#4:489\n11400#4,3:490\n11065#4:523\n11400#4,3:524\n526#5:461\n511#5,6:462\n526#5:468\n511#5,6:469\n453#5:475\n403#5:476\n526#5:493\n511#5,6:494\n526#5:500\n511#5,6:501\n526#5:507\n511#5,6:508\n526#5:514\n511#5,6:515\n526#5:527\n511#5,6:528\n526#5:534\n511#5,6:535\n526#5:541\n511#5,6:542\n*S KotlinDebug\n*F\n+ 1 EditableFieldExtensions.kt\ncom/disney/id/android/extensions/EditableFieldExtensionsKt\n*L\n121#1:453,2\n144#1:455,2\n186#1:477,4\n298#1:521,2\n376#1:548\n376#1:549,2\n377#1:551\n377#1:552,2\n377#1:554,11\n378#1:565\n378#1:566,2\n378#1:568,11\n444#1:579\n444#1:580,3\n172#1:457\n172#1:458,3\n191#1:481\n191#1:482,3\n201#1:485\n201#1:486,3\n237#1:489\n237#1:490,3\n307#1:523\n307#1:524,3\n182#1:461\n182#1:462,6\n184#1:468\n184#1:469,6\n186#1:475\n186#1:476\n238#1:493\n238#1:494,6\n242#1:500\n242#1:501,6\n246#1:507\n246#1:508,6\n293#1:514\n293#1:515,6\n309#1:527\n309#1:528,6\n310#1:534\n310#1:535,6\n311#1:541\n311#1:542,6\n*E\n"})
/* loaded from: classes3.dex */
public final class EditableFieldExtensionsKt {
    private static final JSONObject getCompliance(OneIDSCALPController oneIDSCALPController) {
        JSONObject siteConfig$OneID_release = oneIDSCALPController.getSiteConfig$OneID_release();
        if (siteConfig$OneID_release != null) {
            return siteConfig$OneID_release.getJSONObject(Keys.COMPLIANCE.getValue());
        }
        return null;
    }

    private static final JSONObject getAgeBands(OneIDSCALPController oneIDSCALPController) {
        JSONObject compliance = getCompliance(oneIDSCALPController);
        if (compliance != null) {
            return compliance.getJSONObject(Keys.AGE_BANDS.getValue());
        }
        return null;
    }

    private static final JSONObject getAgeBand(OneIDSCALPController oneIDSCALPController, String str) {
        JSONObject ageBands = getAgeBands(oneIDSCALPController);
        if (ageBands != null) {
            return ageBands.getJSONObject(str);
        }
        return null;
    }

    private static final JSONObject getAgeBandFields(OneIDSCALPController oneIDSCALPController, String str, String str2) {
        JSONObject ageBand = getAgeBand(oneIDSCALPController, str);
        if (ageBand != null) {
            return ageBand.getJSONObject(str2);
        }
        return null;
    }

    public static /* synthetic */ JSONObject getUpdateFields$default(OneIDSCALPController oneIDSCALPController, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = AgeBand.ADULT.getValue();
        }
        return getUpdateFields(oneIDSCALPController, str);
    }

    @Nullable
    public static final JSONObject getUpdateFields(@NotNull OneIDSCALPController oneIDSCALPController, @NotNull String ageBand) {
        Intrinsics.checkNotNullParameter(oneIDSCALPController, "<this>");
        Intrinsics.checkNotNullParameter(ageBand, "ageBand");
        return getAgeBandFields(oneIDSCALPController, ageBand, ConfigEditMode.UPDATE.getValue());
    }

    private static final Map flattenAgeBandTypeFields(OneIDSCALPController oneIDSCALPController, Map map, String str, List list) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Function2 function2 = new Function2() { // from class: com.disney.id.android.extensions.EditableFieldExtensionsKt$flattenAgeBandTypeFields$mapNestedFields$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (Map) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String prefix, Map fields) {
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                Intrinsics.checkNotNullParameter(fields, "fields");
                Map map2 = linkedHashMap;
                for (Map.Entry entry : fields.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    Map map3 = value instanceof Map ? (Map) value : null;
                    if (map3 != null) {
                        Keys keys = Keys.EDITABLE;
                        Object obj = map3.get(keys.getValue());
                        String upperCase = keys.getValue().toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        boolean zAreEqual = Intrinsics.areEqual(obj, upperCase);
                        boolean zAreEqual2 = Intrinsics.areEqual(str2, Keys.TYPE.getValue());
                        if (zAreEqual && !zAreEqual2) {
                            String str3 = prefix + InstructionFileId.DOT + str2;
                            Object obj2 = map3.get(Keys.REQUIRED.getValue());
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                            map2.put(str3, (Boolean) obj2);
                        }
                    }
                }
            }
        };
        boolean z = false;
        Map map2 = null;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if (Intrinsics.areEqual(str2, Keys.DEFAULT.getValue())) {
                Map map3 = value instanceof Map ? (Map) value : null;
                if (map3 != null) {
                    Intrinsics.checkNotNull(map3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    map2 = map3;
                }
                z = true;
            } else {
                String str3 = str + InstructionFileId.DOT + str2;
                Map map4 = value instanceof Map ? (Map) value : null;
                if (map4 != null) {
                    Intrinsics.checkNotNull(map4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    function2.invoke(str3, map4);
                }
            }
        }
        if (linkedHashMap.isEmpty() && z) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str4 = str + InstructionFileId.DOT + ((String) it.next());
                if (map2 != null) {
                    function2.invoke(str4, map2);
                }
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, Object> getEditableConfigFields(@NotNull OneIDSCALPController oneIDSCALPController, @NotNull String ageBand) {
        Intrinsics.checkNotNullParameter(oneIDSCALPController, "<this>");
        Intrinsics.checkNotNullParameter(ageBand, "ageBand");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        IgnoreKeys[] ignoreKeysArrValues = IgnoreKeys.values();
        ArrayList arrayList = new ArrayList(ignoreKeysArrValues.length);
        for (IgnoreKeys ignoreKeys : ignoreKeysArrValues) {
            arrayList.add(ignoreKeys.getValue());
        }
        JSONObject updateFields = getUpdateFields(oneIDSCALPController, ageBand);
        Map<String, Object> map = updateFields != null ? JSONExtensionsKt.toMap(updateFields) : null;
        if (map == null || map.isEmpty()) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!arrayList.contains(entry.getKey()) && !Intrinsics.areEqual(entry.getKey(), Keys.ADDRESSES.getValue()) && !Intrinsics.areEqual(entry.getKey(), Keys.PHONES.getValue())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object value = entry2.getValue();
            Map map2 = value instanceof Map ? (Map) value : null;
            Object obj = map2 != null ? map2.get(Keys.EDITABLE.getValue()) : null;
            String upperCase = Keys.EDITABLE.getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(obj, upperCase)) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            Object key = entry3.getKey();
            Object value2 = entry3.getValue();
            Map map3 = value2 instanceof Map ? (Map) value2 : null;
            Object obj2 = map3 != null ? map3.get(Keys.REQUIRED.getValue()) : null;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) obj2;
            bool.booleanValue();
            linkedHashMap4.put(key, bool);
        }
        AddressType[] addressTypeArrValues = AddressType.values();
        ArrayList arrayList2 = new ArrayList(addressTypeArrValues.length);
        for (AddressType addressType : addressTypeArrValues) {
            arrayList2.add(addressType.getType());
        }
        Keys keys = Keys.ADDRESSES;
        Object obj3 = map.get(keys.getValue());
        Map map4 = obj3 instanceof Map ? (Map) obj3 : null;
        Object obj4 = map4 != null ? map4.get(Keys.TYPE.getValue()) : null;
        Map map5 = obj4 instanceof Map ? (Map) obj4 : null;
        Map linkedHashMap5 = new LinkedHashMap();
        if (map5 != null) {
            String lowerCase = keys.getValue().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap5 = flattenAgeBandTypeFields(oneIDSCALPController, map5, lowerCase, arrayList2);
        }
        PhoneType[] phoneTypeArrValues = PhoneType.values();
        ArrayList arrayList3 = new ArrayList(phoneTypeArrValues.length);
        for (PhoneType phoneType : phoneTypeArrValues) {
            arrayList3.add(phoneType.getType());
        }
        Keys keys2 = Keys.PHONES;
        Object obj5 = map.get(keys2.getValue());
        Map map6 = obj5 instanceof Map ? (Map) obj5 : null;
        Object obj6 = map6 != null ? map6.get(Keys.TYPE.getValue()) : null;
        Map map7 = obj6 instanceof Map ? (Map) obj6 : null;
        Map linkedHashMap6 = new LinkedHashMap();
        if (map7 != null) {
            String lowerCase2 = keys2.getValue().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            linkedHashMap6 = flattenAgeBandTypeFields(oneIDSCALPController, map7, lowerCase2, arrayList3);
        }
        linkedHashMap.putAll(MapsKt.plus(MapsKt.plus(linkedHashMap4, linkedHashMap5), linkedHashMap6));
        return MapsKt.toMap(linkedHashMap);
    }

    @NotNull
    public static final Map<String, Object> getProfileContent(@NotNull OneID oneID, @NotNull JSONObject jsonProfile) {
        Intrinsics.checkNotNullParameter(oneID, "<this>");
        Intrinsics.checkNotNullParameter(jsonProfile, "jsonProfile");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Map<String, Object> map = JSONExtensionsKt.toMap(jsonProfile);
            IgnoreKeys[] ignoreKeysArrValues = IgnoreKeys.values();
            ArrayList arrayList = new ArrayList(ignoreKeysArrValues.length);
            for (IgnoreKeys ignoreKeys : ignoreKeysArrValues) {
                arrayList.add(ignoreKeys.getValue());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!arrayList.contains(entry.getKey())) {
                    String key = entry.getKey();
                    String value = Keys.ADDRESSES.getValue();
                    Locale locale = Locale.ROOT;
                    String lowerCase = value.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(key, lowerCase)) {
                        String key2 = entry.getKey();
                        String lowerCase2 = Keys.PHONES.getValue().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (!Intrinsics.areEqual(key2, lowerCase2)) {
                            linkedHashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            linkedHashMap.putAll(linkedHashMap2);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                String key3 = entry2.getKey();
                String lowerCase3 = Keys.ADDRESSES.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (Intrinsics.areEqual(key3, lowerCase3)) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry<String, Object> entry3 : map.entrySet()) {
                String key4 = entry3.getKey();
                String lowerCase4 = Keys.PHONES.getValue().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (Intrinsics.areEqual(key4, lowerCase4)) {
                    linkedHashMap4.put(entry3.getKey(), entry3.getValue());
                }
            }
            Function2 function2 = new Function2() { // from class: com.disney.id.android.extensions.EditableFieldExtensionsKt$getProfileContent$flatten$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (Map) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(String rootKey, Map fields) {
                    Intrinsics.checkNotNullParameter(rootKey, "rootKey");
                    Intrinsics.checkNotNullParameter(fields, "fields");
                    String lowerCase5 = Keys.TYPE.getValue().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    Object obj = fields.get(rootKey);
                    List list = obj instanceof List ? (List) obj : null;
                    if (list != null) {
                        ArrayList<Map> arrayList2 = new ArrayList();
                        for (Object obj2 : list) {
                            if (obj2 instanceof Map) {
                                arrayList2.add(obj2);
                            }
                        }
                        Map map2 = linkedHashMap;
                        for (Map map3 : arrayList2) {
                            Object obj3 = map3.get(lowerCase5);
                            String str = obj3 instanceof String ? (String) obj3 : null;
                            if (str != null) {
                                for (Map.Entry entry4 : map3.entrySet()) {
                                    String str2 = (String) entry4.getKey();
                                    Object value2 = entry4.getValue();
                                    if (!Intrinsics.areEqual(str2, lowerCase5)) {
                                        String upperCase = str.toUpperCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                        map2.put(rootKey + InstructionFileId.DOT + upperCase + InstructionFileId.DOT + str2, value2);
                                    }
                                }
                            }
                        }
                    }
                }
            };
            function2.invoke(Keys.ADDRESSES.getValue(), linkedHashMap3);
            function2.invoke(Keys.PHONES.getValue(), linkedHashMap4);
            return MapsKt.toMap(linkedHashMap);
        } catch (JSONException unused) {
            return MapsKt.toMap(linkedHashMap);
        }
    }

    @NotNull
    public static final List<EditableField> getProfileFields(@NotNull OneID oneID, @NotNull JSONObject jsonProfile, @NotNull final Map<String, ? extends Object> editableFieldMap) {
        Intrinsics.checkNotNullParameter(oneID, "<this>");
        Intrinsics.checkNotNullParameter(jsonProfile, "jsonProfile");
        Intrinsics.checkNotNullParameter(editableFieldMap, "editableFieldMap");
        final ArrayList arrayList = new ArrayList();
        Map<String, Object> profileContent = getProfileContent(oneID, jsonProfile);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : profileContent.entrySet()) {
            if (editableFieldMap.keySet().contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        for (String str : editableFieldMap.keySet()) {
            if (!mutableMap.containsKey(str)) {
                Object NULL = JSONObject.NULL;
                Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
                mutableMap.put(str, NULL);
            }
        }
        String value = Keys.ADDRESSES.getValue();
        String value2 = Keys.PHONES.getValue();
        IgnoreKeys[] ignoreKeysArrValues = IgnoreKeys.values();
        ArrayList arrayList2 = new ArrayList(ignoreKeysArrValues.length);
        for (IgnoreKeys ignoreKeys : ignoreKeysArrValues) {
            arrayList2.add(ignoreKeys.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : mutableMap.entrySet()) {
            if (!arrayList2.contains(entry2.getKey())) {
                if (!StringsKt.contains$default((CharSequence) entry2.getKey(), (CharSequence) (value + InstructionFileId.DOT), false, 2, (Object) null)) {
                    if (!StringsKt.contains$default((CharSequence) entry2.getKey(), (CharSequence) (value2 + InstructionFileId.DOT), false, 2, (Object) null)) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry3 : mutableMap.entrySet()) {
            if (StringsKt.contains$default((CharSequence) entry3.getKey(), (CharSequence) (value + InstructionFileId.DOT), false, 2, (Object) null)) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry entry4 : mutableMap.entrySet()) {
            if (StringsKt.contains$default((CharSequence) entry4.getKey(), (CharSequence) (value2 + InstructionFileId.DOT), false, 2, (Object) null)) {
                linkedHashMap4.put(entry4.getKey(), entry4.getValue());
            }
        }
        for (Map.Entry entry5 : linkedHashMap2.entrySet()) {
            String str2 = (String) entry5.getKey();
            Object value3 = entry5.getValue();
            Object obj = editableFieldMap.get(str2);
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            arrayList.add(new EditableField(str2, value3, bool != null ? bool.booleanValue() : false));
        }
        Function2 function2 = new Function2() { // from class: com.disney.id.android.extensions.EditableFieldExtensionsKt$getProfileFields$addSubFields$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((String) obj2, (Map) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(String root, Map fieldMap) {
                Intrinsics.checkNotNullParameter(root, "root");
                Intrinsics.checkNotNullParameter(fieldMap, "fieldMap");
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                for (String str3 : fieldMap.keySet()) {
                    List listSplit$default = StringsKt.split$default((CharSequence) str3, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
                    if (listSplit$default.size() >= 3) {
                        String str4 = (String) listSplit$default.get(0);
                        Locale locale = Locale.ROOT;
                        String lowerCase = str4.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = root.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                            String lowerCase3 = ((String) listSplit$default.get(1)).toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                            Object obj2 = editableFieldMap.get(str3);
                            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                            boolean zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
                            Object obj3 = fieldMap.get(str3);
                            if (obj3 == null) {
                                obj3 = JSONObject.NULL;
                            }
                            EditableField editableField = new EditableField(str3, obj3, zBooleanValue);
                            if (!linkedHashMap5.containsKey(lowerCase3)) {
                                linkedHashMap5.put(lowerCase3, new ArrayList());
                            }
                            List list = (List) linkedHashMap5.get(lowerCase3);
                            if (list != null) {
                                list.add(editableField);
                            }
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry6 : linkedHashMap5.entrySet()) {
                    arrayList3.add(new EditableField((String) entry6.getKey(), (List) entry6.getValue(), false, 4, null));
                }
                arrayList.add(new EditableField(root, arrayList3, false, 4, null));
            }
        };
        if (!linkedHashMap3.isEmpty()) {
            function2.invoke(value, linkedHashMap3);
        }
        if (!linkedHashMap4.isEmpty()) {
            function2.invoke(value2, linkedHashMap4);
        }
        return CollectionsKt.toList(arrayList);
    }

    @NotNull
    public static final Map<String, Object> toProfileMap(@NotNull List<EditableField> list) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<EditableField> arrayList2 = new ArrayList();
        for (Object obj : list) {
            EditableField editableField = (EditableField) obj;
            if (!Intrinsics.areEqual(editableField.getId(), Keys.ADDRESSES.getValue()) && !Intrinsics.areEqual(editableField.getId(), Keys.PHONES.getValue())) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((EditableField) obj2).getId(), Keys.ADDRESSES.getValue())) {
                arrayList3.add(obj2);
            }
        }
        EditableField editableField2 = (EditableField) CollectionsKt.firstOrNull((List) arrayList3);
        ArrayList arrayList4 = null;
        Object value = editableField2 != null ? editableField2.getValue() : null;
        List list2 = value instanceof List ? (List) value : null;
        if (list2 != null) {
            arrayList = new ArrayList();
            for (Object obj3 : list2) {
                if (obj3 instanceof EditableField) {
                    arrayList.add(obj3);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj4 : list) {
            if (Intrinsics.areEqual(((EditableField) obj4).getId(), Keys.PHONES.getValue())) {
                arrayList5.add(obj4);
            }
        }
        EditableField editableField3 = (EditableField) CollectionsKt.firstOrNull((List) arrayList5);
        Object value2 = editableField3 != null ? editableField3.getValue() : null;
        List list3 = value2 instanceof List ? (List) value2 : null;
        if (list3 != null) {
            arrayList4 = new ArrayList();
            for (Object obj5 : list3) {
                if (obj5 instanceof EditableField) {
                    arrayList4.add(obj5);
                }
            }
        }
        for (EditableField editableField4 : arrayList2) {
            linkedHashMap.put(editableField4.getName(), editableField4.getValue());
        }
        Function2 function2 = new Function2() { // from class: com.disney.id.android.extensions.EditableFieldExtensionsKt$toProfileMap$mapComplexField$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7) {
                invoke((String) obj6, (List) obj7);
                return Unit.INSTANCE;
            }

            public final void invoke(String rootKey, List fields) {
                Intrinsics.checkNotNullParameter(rootKey, "rootKey");
                Intrinsics.checkNotNullParameter(fields, "fields");
                ArrayList arrayList6 = new ArrayList();
                Iterator it = fields.iterator();
                while (it.hasNext()) {
                    EditableField editableField5 = (EditableField) it.next();
                    Object value3 = editableField5.getValue();
                    List list4 = value3 instanceof List ? (List) value3 : null;
                    if (list4 != null) {
                        ArrayList<EditableField> arrayList7 = new ArrayList();
                        for (Object obj6 : list4) {
                            if (obj6 instanceof EditableField) {
                                arrayList7.add(obj6);
                            }
                        }
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (EditableField editableField6 : arrayList7) {
                            linkedHashMap2.put(editableField6.getName(), editableField6.getValue());
                        }
                        linkedHashMap2.put(Keys.TYPE.getValue(), editableField5.getName());
                        arrayList6.add(MapsKt.toMap(linkedHashMap2));
                    }
                }
                linkedHashMap.put(rootKey, CollectionsKt.toList(arrayList6));
            }
        };
        if (arrayList != null) {
            function2.invoke(Keys.ADDRESSES.getValue(), arrayList);
        }
        if (arrayList4 != null) {
            function2.invoke(Keys.PHONES.getValue(), arrayList4);
        }
        return linkedHashMap;
    }

    @Nullable
    public static final JSONObject toProfileJSON(@NotNull List<EditableField> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Map<String, Object> profileMap = toProfileMap(list);
        if (profileMap.isEmpty()) {
            return null;
        }
        return new JSONObject(profileMap);
    }

    @Nullable
    public static final JsonElement toJson(@NotNull List<EditableField> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((EditableField) it.next()).toJSONObject$OneID_release());
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(JSONExtensionsKt.toMap((JSONObject) it2.next()));
        }
        return new GsonBuilder().serializeNulls().create().toJsonTree(arrayList2, new TypeToken<List<? extends Map<String, ? extends Object>>>() { // from class: com.disney.id.android.extensions.EditableFieldExtensionsKt$toJson$jsonType$1
        }.getType());
    }
}
