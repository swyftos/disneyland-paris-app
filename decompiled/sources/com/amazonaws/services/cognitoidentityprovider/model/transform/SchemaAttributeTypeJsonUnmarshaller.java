package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SchemaAttributeType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class SchemaAttributeTypeJsonUnmarshaller implements Unmarshaller<SchemaAttributeType, JsonUnmarshallerContext> {
    private static SchemaAttributeTypeJsonUnmarshaller instance;

    SchemaAttributeTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public SchemaAttributeType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SchemaAttributeType schemaAttributeType = new SchemaAttributeType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("Name")) {
                schemaAttributeType.setName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AttributeDataType")) {
                schemaAttributeType.setAttributeDataType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("DeveloperOnlyAttribute")) {
                schemaAttributeType.setDeveloperOnlyAttribute(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Mutable")) {
                schemaAttributeType.setMutable(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Required")) {
                schemaAttributeType.setRequired(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NumberAttributeConstraints")) {
                schemaAttributeType.setNumberAttributeConstraints(NumberAttributeConstraintsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("StringAttributeConstraints")) {
                schemaAttributeType.setStringAttributeConstraints(StringAttributeConstraintsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return schemaAttributeType;
    }

    public static SchemaAttributeTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SchemaAttributeTypeJsonUnmarshaller();
        }
        return instance;
    }
}
