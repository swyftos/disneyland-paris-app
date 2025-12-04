package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NumberAttributeConstraintsType;
import com.amazonaws.services.cognitoidentityprovider.model.SchemaAttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.StringAttributeConstraintsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class SchemaAttributeTypeJsonMarshaller {
    private static SchemaAttributeTypeJsonMarshaller instance;

    SchemaAttributeTypeJsonMarshaller() {
    }

    public void marshall(SchemaAttributeType schemaAttributeType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (schemaAttributeType.getName() != null) {
            String name = schemaAttributeType.getName();
            awsJsonWriter.name("Name");
            awsJsonWriter.value(name);
        }
        if (schemaAttributeType.getAttributeDataType() != null) {
            String attributeDataType = schemaAttributeType.getAttributeDataType();
            awsJsonWriter.name("AttributeDataType");
            awsJsonWriter.value(attributeDataType);
        }
        if (schemaAttributeType.getDeveloperOnlyAttribute() != null) {
            Boolean developerOnlyAttribute = schemaAttributeType.getDeveloperOnlyAttribute();
            awsJsonWriter.name("DeveloperOnlyAttribute");
            awsJsonWriter.value(developerOnlyAttribute.booleanValue());
        }
        if (schemaAttributeType.getMutable() != null) {
            Boolean mutable = schemaAttributeType.getMutable();
            awsJsonWriter.name("Mutable");
            awsJsonWriter.value(mutable.booleanValue());
        }
        if (schemaAttributeType.getRequired() != null) {
            Boolean required = schemaAttributeType.getRequired();
            awsJsonWriter.name("Required");
            awsJsonWriter.value(required.booleanValue());
        }
        if (schemaAttributeType.getNumberAttributeConstraints() != null) {
            NumberAttributeConstraintsType numberAttributeConstraints = schemaAttributeType.getNumberAttributeConstraints();
            awsJsonWriter.name("NumberAttributeConstraints");
            NumberAttributeConstraintsTypeJsonMarshaller.getInstance().marshall(numberAttributeConstraints, awsJsonWriter);
        }
        if (schemaAttributeType.getStringAttributeConstraints() != null) {
            StringAttributeConstraintsType stringAttributeConstraints = schemaAttributeType.getStringAttributeConstraints();
            awsJsonWriter.name("StringAttributeConstraints");
            StringAttributeConstraintsTypeJsonMarshaller.getInstance().marshall(stringAttributeConstraints, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static SchemaAttributeTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SchemaAttributeTypeJsonMarshaller();
        }
        return instance;
    }
}
