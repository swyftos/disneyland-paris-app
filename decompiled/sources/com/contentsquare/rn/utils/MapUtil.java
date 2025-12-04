package com.contentsquare.rn.utils;

import android.util.Log;
import com.contentsquare.android.api.model.CustomVar;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class MapUtil {
    public static void convertAndAddToCustomVarList(ReadableMap readableMap, List<CustomVar> list) {
        try {
            list.add(new CustomVar(readableMap.getInt("index"), readableMap.getString("key"), readableMap.getString("value")));
        } catch (Exception e) {
            Log.e("CSLIB", e.toString());
        }
    }

    public static WritableArray convertListOfMapsToWritableArray(List<? extends Map<String, ? extends Object>> list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<? extends Map<String, ? extends Object>> it = list.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushMap(convertMapToWritableMap(it.next()));
        }
        return writableArrayCreateArray;
    }

    public static WritableMap convertMapToWritableMap(Map<String, ? extends Object> map) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                writableMapCreateMap.putString(entry.getKey(), (String) value);
            } else if (value instanceof Integer) {
                writableMapCreateMap.putInt(entry.getKey(), ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                writableMapCreateMap.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
            }
        }
        return writableMapCreateMap;
    }

    public static Object getValueForKey(ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str)) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()];
        if (i == 2) {
            return Boolean.valueOf(readableMap.getBoolean(str));
        }
        if (i == 3) {
            return Double.valueOf(readableMap.getDouble(str));
        }
        if (i == 4) {
            return readableMap.getString(str);
        }
        if (i == 5) {
            return readableMap.getMap(str);
        }
        if (i != 6) {
            return null;
        }
        return readableMap.getArray(str);
    }

    /* renamed from: com.contentsquare.rn.utils.MapUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
