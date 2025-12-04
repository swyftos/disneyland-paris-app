package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.StringAttributeConstraintsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class StringAttributeConstraintsTypeJsonUnmarshaller implements Unmarshaller<StringAttributeConstraintsType, JsonUnmarshallerContext> {
    private static StringAttributeConstraintsTypeJsonUnmarshaller instance;

    StringAttributeConstraintsTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public StringAttributeConstraintsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        StringAttributeConstraintsType stringAttributeConstraintsType = new StringAttributeConstraintsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("MinLength")) {
                stringAttributeConstraintsType.setMinLength(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("MaxLength")) {
                stringAttributeConstraintsType.setMaxLength(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return stringAttributeConstraintsType;
    }

    public static StringAttributeConstraintsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StringAttributeConstraintsTypeJsonUnmarshaller();
        }
        return instance;
    }
}
