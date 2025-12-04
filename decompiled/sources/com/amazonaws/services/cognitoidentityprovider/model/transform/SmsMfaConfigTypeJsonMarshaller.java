package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SmsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.SmsMfaConfigType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class SmsMfaConfigTypeJsonMarshaller {
    private static SmsMfaConfigTypeJsonMarshaller instance;

    SmsMfaConfigTypeJsonMarshaller() {
    }

    public void marshall(SmsMfaConfigType smsMfaConfigType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (smsMfaConfigType.getSmsAuthenticationMessage() != null) {
            String smsAuthenticationMessage = smsMfaConfigType.getSmsAuthenticationMessage();
            awsJsonWriter.name("SmsAuthenticationMessage");
            awsJsonWriter.value(smsAuthenticationMessage);
        }
        if (smsMfaConfigType.getSmsConfiguration() != null) {
            SmsConfigurationType smsConfiguration = smsMfaConfigType.getSmsConfiguration();
            awsJsonWriter.name("SmsConfiguration");
            SmsConfigurationTypeJsonMarshaller.getInstance().marshall(smsConfiguration, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static SmsMfaConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SmsMfaConfigTypeJsonMarshaller();
        }
        return instance;
    }
}
