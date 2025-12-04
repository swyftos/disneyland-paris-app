package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CustomDomainConfigType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class CustomDomainConfigTypeJsonMarshaller {
    private static CustomDomainConfigTypeJsonMarshaller instance;

    CustomDomainConfigTypeJsonMarshaller() {
    }

    public void marshall(CustomDomainConfigType customDomainConfigType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (customDomainConfigType.getCertificateArn() != null) {
            String certificateArn = customDomainConfigType.getCertificateArn();
            awsJsonWriter.name("CertificateArn");
            awsJsonWriter.value(certificateArn);
        }
        awsJsonWriter.endObject();
    }

    public static CustomDomainConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CustomDomainConfigTypeJsonMarshaller();
        }
        return instance;
    }
}
