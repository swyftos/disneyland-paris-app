package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class JSONUtils {
    public static Integer readInteger(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    public static Long readLong(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    public static Boolean readBoolean(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static Map<String, String> readMap(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        HashMap map = new HashMap(jSONObjectOptJSONObject.length());
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObjectOptJSONObject.getString(next));
        }
        return map;
    }

    public static <M extends Model> List<M> readArray(JSONObject jSONObject, String str, ModelFactory<M> modelFactory) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        List<M> listCreateList = modelFactory.createList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            Model modelCreate = modelFactory.create();
            modelCreate.read(jSONObject2);
            listCreateList.add(modelCreate);
        }
        return listCreateList;
    }

    public static List<String> readStringArray(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.getString(i));
        }
        return arrayList;
    }

    public static void write(JSONStringer jSONStringer, String str, Object obj) throws JSONException {
        if (obj != null) {
            jSONStringer.key(str).value(obj);
        }
    }

    public static void writeMap(JSONStringer jSONStringer, String str, Map<String, String> map) throws JSONException {
        if (map != null) {
            jSONStringer.key(str).object();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONStringer.key(entry.getKey()).value(entry.getValue());
            }
            jSONStringer.endObject();
        }
    }

    public static void writeArray(JSONStringer jSONStringer, String str, List<? extends Model> list) throws JSONException {
        if (list != null) {
            jSONStringer.key(str).array();
            for (Model model : list) {
                jSONStringer.object();
                model.write(jSONStringer);
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
        }
    }

    public static void writeStringArray(JSONStringer jSONStringer, String str, List<String> list) throws JSONException {
        if (list != null) {
            jSONStringer.key(str).array();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONStringer.value(it.next());
            }
            jSONStringer.endArray();
        }
    }
}
