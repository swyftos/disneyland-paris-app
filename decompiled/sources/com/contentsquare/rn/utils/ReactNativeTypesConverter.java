package com.contentsquare.rn.utils;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ReactNativeTypesConverter {
    public static List<String> readableArrayToStringList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                arrayList.add(readableArray.getString(i));
            } else if (i2 == 2) {
                arrayList.add(String.valueOf(readableArray.getDouble(i)));
            } else if (i2 == 3) {
                arrayList.add(String.valueOf(readableArray.getBoolean(i)));
            } else if (i2 == 4) {
                arrayList.add("");
            } else if (i2 == 5) {
                arrayList.add(readableArrayToStringList(readableArray.getArray(i)).toString());
            } else {
                throw new IllegalArgumentException("Unsupported type at index " + i);
            }
        }
        return arrayList;
    }

    /* renamed from: com.contentsquare.rn.utils.ReactNativeTypesConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Map<String, Object> readableMapToMap(ReadableMap readableMap, List<String> list, List<String> list2) {
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            ReadableType type = readableMap.getType(strNextKey);
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[type.ordinal()]) {
                case 1:
                    map.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 2:
                    if (list.contains(strNextKey)) {
                        map.put(strNextKey, Long.valueOf((long) readableMap.getDouble(strNextKey)));
                        break;
                    } else if (list2.contains(strNextKey)) {
                        map.put(strNextKey, Integer.valueOf((int) readableMap.getDouble(strNextKey)));
                        break;
                    } else {
                        map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
                        break;
                    }
                case 3:
                    map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
                    break;
                case 4:
                    map.put(strNextKey, null);
                    break;
                case 5:
                    map.put(strNextKey, readableArrayToList(readableMap.getArray(strNextKey), list, list2));
                    break;
                case 6:
                    map.put(strNextKey, readableMapToMap(readableMap.getMap(strNextKey), list, list2));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported type " + type);
            }
        }
        return map;
    }

    public static List<Object> readableArrayToList(ReadableArray readableArray, List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    arrayList.add(readableArray.getString(i));
                    break;
                case 2:
                    arrayList.add(Double.valueOf(readableArray.getDouble(i)));
                    break;
                case 3:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 4:
                    arrayList.add(null);
                    break;
                case 5:
                    arrayList.add(readableArrayToList(readableArray.getArray(i), list, list2));
                    break;
                case 6:
                    arrayList.add(readableMapToMap(readableArray.getMap(i), list, list2));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported type at index " + i);
            }
        }
        return arrayList;
    }
}
