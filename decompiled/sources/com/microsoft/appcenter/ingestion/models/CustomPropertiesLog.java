package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.urbanairship.analytics.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class CustomPropertiesLog extends AbstractLog {
    public static final String TYPE = "customProperties";
    private Map properties;

    private static Map readProperties(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(CustomEvent.PROPERTIES);
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            map.put(jSONObject2.getString("name"), readPropertyValue(jSONObject2));
        }
        return map;
    }

    private static Object readPropertyValue(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("type");
        if (string.equals("clear")) {
            return null;
        }
        if (string.equals("boolean")) {
            return Boolean.valueOf(jSONObject.getBoolean("value"));
        }
        if (string.equals("number")) {
            Object obj = jSONObject.get("value");
            if (obj instanceof Number) {
                return obj;
            }
            throw new JSONException("Invalid value type");
        }
        if (string.equals(DateTimeTypedProperty.TYPE)) {
            return JSONDateUtils.toDate(jSONObject.getString("value"));
        }
        if (string.equals("string")) {
            return jSONObject.getString("value");
        }
        throw new JSONException("Invalid value type");
    }

    private static void writeProperties(JSONStringer jSONStringer, Map map) throws JSONException {
        if (map != null) {
            jSONStringer.key(CustomEvent.PROPERTIES).array();
            for (Map.Entry entry : map.entrySet()) {
                jSONStringer.object();
                JSONUtils.write(jSONStringer, "name", entry.getKey());
                writePropertyValue(jSONStringer, entry.getValue());
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            return;
        }
        throw new JSONException("Properties cannot be null");
    }

    private static void writePropertyValue(JSONStringer jSONStringer, Object obj) throws JSONException {
        if (obj == null) {
            JSONUtils.write(jSONStringer, "type", "clear");
            return;
        }
        if (obj instanceof Boolean) {
            JSONUtils.write(jSONStringer, "type", "boolean");
            JSONUtils.write(jSONStringer, "value", obj);
            return;
        }
        if (obj instanceof Number) {
            JSONUtils.write(jSONStringer, "type", "number");
            JSONUtils.write(jSONStringer, "value", obj);
        } else if (obj instanceof Date) {
            JSONUtils.write(jSONStringer, "type", DateTimeTypedProperty.TYPE);
            JSONUtils.write(jSONStringer, "value", JSONDateUtils.toString((Date) obj));
        } else {
            if (obj instanceof String) {
                JSONUtils.write(jSONStringer, "type", "string");
                JSONUtils.write(jSONStringer, "value", obj);
                return;
            }
            throw new JSONException("Invalid value type");
        }
    }

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getType() {
        return TYPE;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, Object> map) {
        this.properties = map;
    }

    @Override // com.microsoft.appcenter.ingestion.models.AbstractLog, com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        setProperties(readProperties(jSONObject));
    }

    @Override // com.microsoft.appcenter.ingestion.models.AbstractLog, com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        writeProperties(jSONStringer, getProperties());
    }

    @Override // com.microsoft.appcenter.ingestion.models.AbstractLog
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        CustomPropertiesLog customPropertiesLog = (CustomPropertiesLog) obj;
        Map map = this.properties;
        return map != null ? map.equals(customPropertiesLog.properties) : customPropertiesLog.properties == null;
    }

    @Override // com.microsoft.appcenter.ingestion.models.AbstractLog
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Map map = this.properties;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }
}
