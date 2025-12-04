package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.StringAttributeConstraintsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class StringAttributeConstraintsTypeJsonMarshaller {
    private static StringAttributeConstraintsTypeJsonMarshaller instance;

    StringAttributeConstraintsTypeJsonMarshaller() {
    }

    public void marshall(StringAttributeConstraintsType stringAttributeConstraintsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (stringAttributeConstraintsType.getMinLength() != null) {
            String minLength = stringAttributeConstraintsType.getMinLength();
            awsJsonWriter.name("MinLength");
            awsJsonWriter.value(minLength);
        }
        if (stringAttributeConstraintsType.getMaxLength() != null) {
            String maxLength = stringAttributeConstraintsType.getMaxLength();
            awsJsonWriter.name("MaxLength");
            awsJsonWriter.value(maxLength);
        }
        awsJsonWriter.endObject();
    }

    public static StringAttributeConstraintsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new StringAttributeConstraintsTypeJsonMarshaller();
        }
        return instance;
    }
}
