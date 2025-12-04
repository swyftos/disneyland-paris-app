package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AttributeTypeJsonMarshaller {
    private static AttributeTypeJsonMarshaller instance;

    AttributeTypeJsonMarshaller() {
    }

    public void marshall(AttributeType attributeType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (attributeType.getName() != null) {
            String name = attributeType.getName();
            awsJsonWriter.name("Name");
            awsJsonWriter.value(name);
        }
        if (attributeType.getValue() != null) {
            String value = attributeType.getValue();
            awsJsonWriter.name("Value");
            awsJsonWriter.value(value);
        }
        awsJsonWriter.endObject();
    }

    public static AttributeTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeTypeJsonMarshaller();
        }
        return instance;
    }
}
