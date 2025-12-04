package io.invertase.firebase.common;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class RCTConvertFirebase {
    private static String TAG = "RCTConvertFirebase";

    public static Map<String, Object> firebaseAppToMap(FirebaseApp firebaseApp) {
        String name = firebaseApp.getName();
        FirebaseOptions options = firebaseApp.getOptions();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map3.put("name", name);
        map3.put("automaticDataCollectionEnabled", Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
        map2.put("apiKey", options.getApiKey());
        map2.put("appId", options.getApplicationId());
        map2.put("projectId", options.getProjectId());
        map2.put("databaseURL", options.getDatabaseUrl());
        map2.put("gaTrackingId", options.getGaTrackingId());
        map2.put("messagingSenderId", options.getGcmSenderId());
        map2.put("storageBucket", options.getStorageBucket());
        map.put("options", map2);
        map.put("appConfig", map3);
        return map;
    }

    public static WritableMap firebaseAppToWritableMap(FirebaseApp firebaseApp) {
        return Arguments.makeNativeMap(firebaseAppToMap(firebaseApp));
    }

    public static FirebaseApp readableMapToFirebaseApp(ReadableMap readableMap, ReadableMap readableMap2, Context context) {
        FirebaseApp firebaseAppInitializeApp;
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        String string = readableMap2.getString("name");
        builder.setApiKey(readableMap.getString("apiKey"));
        builder.setApplicationId(readableMap.getString("appId"));
        builder.setProjectId(readableMap.getString("projectId"));
        builder.setDatabaseUrl(readableMap.getString("databaseURL"));
        if (readableMap.hasKey("gaTrackingId")) {
            builder.setGaTrackingId(readableMap.getString("gaTrackingId"));
        }
        builder.setStorageBucket(readableMap.getString("storageBucket"));
        builder.setGcmSenderId(readableMap.getString("messagingSenderId"));
        if (string.equals(FirebaseApp.DEFAULT_APP_NAME)) {
            firebaseAppInitializeApp = FirebaseApp.initializeApp(context, builder.build());
        } else {
            firebaseAppInitializeApp = FirebaseApp.initializeApp(context, builder.build(), string);
        }
        if (readableMap2.hasKey("automaticDataCollectionEnabled")) {
            firebaseAppInitializeApp.setDataCollectionDefaultEnabled(readableMap2.getBoolean("automaticDataCollectionEnabled"));
        }
        if (readableMap2.hasKey("automaticResourceManagement")) {
            firebaseAppInitializeApp.setAutomaticResourceManagementEnabled(readableMap2.getBoolean("automaticResourceManagement"));
        }
        return firebaseAppInitializeApp;
    }

    public static WritableMap mapPutValue(String str, @Nullable Object obj, WritableMap writableMap) {
        String name;
        if (obj == null) {
            writableMap.putNull(str);
            return writableMap;
        }
        name = obj.getClass().getName();
        switch (name) {
            case "java.lang.Integer":
                writableMap.putInt(str, ((Integer) obj).intValue());
                return writableMap;
            case "java.lang.Float":
                writableMap.putDouble(str, ((Float) obj).floatValue());
                return writableMap;
            case "java.lang.Boolean":
                writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
                return writableMap;
            case "java.lang.Long":
                writableMap.putDouble(str, ((Long) obj).longValue());
                return writableMap;
            case "java.lang.Double":
                writableMap.putDouble(str, ((Double) obj).doubleValue());
                return writableMap;
            case "java.lang.String":
                writableMap.putString(str, (String) obj);
                return writableMap;
            case "org.json.JSONObject$1":
                writableMap.putString(str, obj.toString());
                return writableMap;
            default:
                if (List.class.isAssignableFrom(obj.getClass())) {
                    writableMap.putArray(str, Arguments.makeNativeArray((List) obj));
                } else if (Map.class.isAssignableFrom(obj.getClass())) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        mapPutValue((String) entry.getKey(), entry.getValue(), writableMapCreateMap);
                    }
                    writableMap.putMap(str, writableMapCreateMap);
                } else {
                    Log.d(TAG, "utils:mapPutValue:unknownType:" + name);
                    writableMap.putNull(str);
                }
                return writableMap;
        }
    }

    public static WritableMap readableMapToWritableMap(ReadableMap readableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.merge(readableMap);
        return writableMapCreateMap;
    }

    public static Map<String, Object> toHashMap(ReadableMap readableMap) {
        return readableMap.toHashMap();
    }

    public static List<Object> toArrayList(ReadableArray readableArray) {
        return readableArray.toArrayList();
    }
}
