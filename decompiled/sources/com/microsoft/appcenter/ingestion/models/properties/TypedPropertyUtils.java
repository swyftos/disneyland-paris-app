package com.microsoft.appcenter.ingestion.models.properties;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TypedPropertyUtils {
    public static TypedProperty create(@NonNull String str) throws JSONException {
        if ("boolean".equals(str)) {
            return new BooleanTypedProperty();
        }
        if (DateTimeTypedProperty.TYPE.equals(str)) {
            return new DateTimeTypedProperty();
        }
        if (DoubleTypedProperty.TYPE.equals(str)) {
            return new DoubleTypedProperty();
        }
        if (LongTypedProperty.TYPE.equals(str)) {
            return new LongTypedProperty();
        }
        if ("string".equals(str)) {
            return new StringTypedProperty();
        }
        throw new JSONException("Unsupported type: " + str);
    }

    public static List<TypedProperty> read(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(CommonProperties.TYPED_PROPERTIES);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            TypedProperty typedPropertyCreate = create(jSONObject2.getString("type"));
            typedPropertyCreate.read(jSONObject2);
            arrayList.add(typedPropertyCreate);
        }
        return arrayList;
    }
}
