package com.rnmaps.fabric;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JSONUtil {
    public static WritableMap convertJsonToWritable(JSONObject jSONObject) throws JSONException {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj == JSONObject.NULL) {
                writableMapCreateMap.putNull(next);
            } else if (obj instanceof Integer) {
                writableMapCreateMap.putInt(next, jSONObject.getInt(next));
            } else if (obj instanceof Long) {
                writableMapCreateMap.putDouble(next, ((Long) obj).doubleValue());
            } else if (obj instanceof Double) {
                writableMapCreateMap.putDouble(next, jSONObject.getDouble(next));
            } else if (obj instanceof Boolean) {
                writableMapCreateMap.putBoolean(next, jSONObject.getBoolean(next));
            } else if (obj instanceof String) {
                writableMapCreateMap.putString(next, jSONObject.getString(next));
            } else if (obj instanceof JSONObject) {
                writableMapCreateMap.putMap(next, convertJsonToWritable(jSONObject.getJSONObject(next)));
            } else if (obj instanceof JSONArray) {
                writableMapCreateMap.putArray(next, convertJsonArrayToWritable(jSONObject.getJSONArray(next)));
            }
        }
        return writableMapCreateMap;
    }

    public static WritableArray convertJsonArrayToWritable(JSONArray jSONArray) throws JSONException {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj == JSONObject.NULL) {
                writableArrayCreateArray.pushNull();
            } else if (obj instanceof Integer) {
                writableArrayCreateArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                writableArrayCreateArray.pushDouble(((Long) obj).doubleValue());
            } else if (obj instanceof Double) {
                writableArrayCreateArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                writableArrayCreateArray.pushString((String) obj);
            } else if (obj instanceof JSONObject) {
                writableArrayCreateArray.pushMap(convertJsonToWritable((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableArrayCreateArray.pushArray(convertJsonArrayToWritable((JSONArray) obj));
            }
        }
        return writableArrayCreateArray;
    }
}
