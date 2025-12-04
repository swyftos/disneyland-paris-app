package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CommonSchemaDataUtils {
    public static void addCommonSchemaData(List<TypedProperty> list, CommonSchemaLog commonSchemaLog) throws JSONException {
        Iterator<TypedProperty> it;
        if (list == null) {
            return;
        }
        try {
            Data data = new Data();
            commonSchemaLog.setData(data);
            MetadataExtension metadataExtension = new MetadataExtension();
            Iterator<TypedProperty> it2 = list.iterator();
            while (it2.hasNext()) {
                TypedProperty next = it2.next();
                try {
                    Object objValidateProperty = validateProperty(next);
                    Integer metadataType = getMetadataType(next);
                    String[] strArrSplit = next.getName().split("\\.", -1);
                    int length = strArrSplit.length - 1;
                    JSONObject properties = data.getProperties();
                    JSONObject metadata = metadataExtension.getMetadata();
                    int i = 0;
                    while (i < length) {
                        Iterator<TypedProperty> it3 = it2;
                        String str = strArrSplit[i];
                        JSONObject jSONObjectOptJSONObject = properties.optJSONObject(str);
                        if (jSONObjectOptJSONObject == null) {
                            if (properties.has(str)) {
                                AppCenterLog.warn("AppCenter", "Property key '" + str + "' already has a value, the old value will be overridden.");
                            }
                            JSONObject jSONObject = new JSONObject();
                            properties.put(str, jSONObject);
                            properties = jSONObject;
                        } else {
                            properties = jSONObjectOptJSONObject;
                        }
                        metadata = addIntermediateMetadata(metadata, str);
                        i++;
                        it2 = it3;
                    }
                    it = it2;
                    String str2 = strArrSplit[length];
                    if (properties.has(str2)) {
                        AppCenterLog.warn("AppCenter", "Property key '" + str2 + "' already has a value, the old value will be overridden.");
                    }
                    properties.put(str2, objValidateProperty);
                    addLeafMetadata(metadataType, metadata, str2);
                } catch (IllegalArgumentException e) {
                    it = it2;
                    AppCenterLog.warn("AppCenter", e.getMessage());
                }
                it2 = it;
            }
            JSONObject properties2 = data.getProperties();
            String strOptString = properties2.optString("baseType", null);
            JSONObject jSONObjectOptJSONObject2 = properties2.optJSONObject("baseData");
            if (strOptString == null && jSONObjectOptJSONObject2 != null) {
                AppCenterLog.warn("AppCenter", "baseData was set but baseType is missing.");
                properties2.remove("baseData");
                metadataExtension.getMetadata().optJSONObject("f").remove("baseData");
            }
            if (strOptString != null && jSONObjectOptJSONObject2 == null) {
                AppCenterLog.warn("AppCenter", "baseType was set but baseData is missing.");
                properties2.remove("baseType");
            }
            if (cleanUpEmptyObjectsInMetadata(metadataExtension.getMetadata())) {
                return;
            }
            if (commonSchemaLog.getExt() == null) {
                commonSchemaLog.setExt(new Extensions());
            }
            commonSchemaLog.getExt().setMetadata(metadataExtension);
        } catch (JSONException unused) {
        }
    }

    private static Object validateProperty(TypedProperty typedProperty) throws JSONException {
        Object objValueOf;
        String name = typedProperty.getName();
        if (name == null) {
            throw new IllegalArgumentException("Property key cannot be null.");
        }
        if (name.equals("baseType") && !(typedProperty instanceof StringTypedProperty)) {
            throw new IllegalArgumentException("baseType must be a string.");
        }
        if (name.startsWith("baseType.")) {
            throw new IllegalArgumentException("baseType must be a string.");
        }
        if (name.equals("baseData")) {
            throw new IllegalArgumentException("baseData must be an object.");
        }
        if (typedProperty instanceof StringTypedProperty) {
            objValueOf = ((StringTypedProperty) typedProperty).getValue();
        } else if (typedProperty instanceof LongTypedProperty) {
            objValueOf = Long.valueOf(((LongTypedProperty) typedProperty).getValue());
        } else if (typedProperty instanceof DoubleTypedProperty) {
            objValueOf = Double.valueOf(((DoubleTypedProperty) typedProperty).getValue());
        } else if (typedProperty instanceof DateTimeTypedProperty) {
            objValueOf = JSONDateUtils.toString(((DateTimeTypedProperty) typedProperty).getValue());
        } else if (typedProperty instanceof BooleanTypedProperty) {
            objValueOf = Boolean.valueOf(((BooleanTypedProperty) typedProperty).getValue());
        } else {
            throw new IllegalArgumentException("Unsupported property type: " + typedProperty.getType());
        }
        if (objValueOf != null) {
            return objValueOf;
        }
        throw new IllegalArgumentException("Value of property with key '" + name + "' cannot be null.");
    }

    private static Integer getMetadataType(TypedProperty typedProperty) {
        if (typedProperty instanceof LongTypedProperty) {
            return 4;
        }
        if (typedProperty instanceof DoubleTypedProperty) {
            return 6;
        }
        return typedProperty instanceof DateTimeTypedProperty ? 9 : null;
    }

    private static void addLeafMetadata(Integer num, JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("f");
        if (num == null) {
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.remove(str);
            }
        } else {
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put("f", jSONObjectOptJSONObject);
            }
            jSONObjectOptJSONObject.put(str, num);
        }
    }

    private static JSONObject addIntermediateMetadata(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("f");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObject.put("f", jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObjectOptJSONObject.put(str, jSONObject2);
        return jSONObject2;
    }

    private static boolean cleanUpEmptyObjectsInMetadata(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null && cleanUpEmptyObjectsInMetadata(jSONObjectOptJSONObject)) {
                itKeys.remove();
            }
        }
        return jSONObject.length() == 0;
    }
}
