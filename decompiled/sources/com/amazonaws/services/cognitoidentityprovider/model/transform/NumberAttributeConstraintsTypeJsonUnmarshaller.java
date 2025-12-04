package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NumberAttributeConstraintsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class NumberAttributeConstraintsTypeJsonUnmarshaller implements Unmarshaller<NumberAttributeConstraintsType, JsonUnmarshallerContext> {
    private static NumberAttributeConstraintsTypeJsonUnmarshaller instance;

    NumberAttributeConstraintsTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public NumberAttributeConstraintsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        NumberAttributeConstraintsType numberAttributeConstraintsType = new NumberAttributeConstraintsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("MinValue")) {
                numberAttributeConstraintsType.setMinValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("MaxValue")) {
                numberAttributeConstraintsType.setMaxValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return numberAttributeConstraintsType;
    }

    public static NumberAttributeConstraintsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new NumberAttributeConstraintsTypeJsonUnmarshaller();
        }
        return instance;
    }
}
