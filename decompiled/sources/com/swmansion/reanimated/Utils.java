package com.swmansion.reanimated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Utils {
    public static boolean isChromeDebugger = false;

    public static Map<String, Integer> processMapping(ReadableMap readableMap) {
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, Integer.valueOf(readableMap.getInt(strNextKey)));
        }
        return map;
    }

    public static int[] processIntArray(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        return iArr;
    }

    public static String simplifyStringNumbersList(String str) {
        return str.replace(",", "").replace("[", "").replace("]", "");
    }

    public static float convertToFloat(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).floatValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return obj instanceof Double ? ((Double) obj).floatValue() : BitmapDescriptorFactory.HUE_RED;
    }

    public static Runnable combineRunnables(final Runnable... runnableArr) {
        return new Runnable() { // from class: com.swmansion.reanimated.Utils.1
            @Override // java.lang.Runnable
            public void run() {
                for (Runnable runnable : runnableArr) {
                    runnable.run();
                }
            }
        };
    }
}
