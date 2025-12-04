package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SmsConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class SmsConfigurationTypeJsonMarshaller {
    private static SmsConfigurationTypeJsonMarshaller instance;

    SmsConfigurationTypeJsonMarshaller() {
    }

    public void marshall(SmsConfigurationType smsConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (smsConfigurationType.getSnsCallerArn() != null) {
            String snsCallerArn = smsConfigurationType.getSnsCallerArn();
            awsJsonWriter.name("SnsCallerArn");
            awsJsonWriter.value(snsCallerArn);
        }
        if (smsConfigurationType.getExternalId() != null) {
            String externalId = smsConfigurationType.getExternalId();
            awsJsonWriter.name("ExternalId");
            awsJsonWriter.value(externalId);
        }
        awsJsonWriter.endObject();
    }

    public static SmsConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SmsConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
