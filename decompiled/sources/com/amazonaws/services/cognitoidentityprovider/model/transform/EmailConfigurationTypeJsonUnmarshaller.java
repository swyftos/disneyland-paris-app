package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.EmailConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.google.common.net.HttpHeaders;
import java.io.IOException;

/* loaded from: classes2.dex */
class EmailConfigurationTypeJsonUnmarshaller implements Unmarshaller<EmailConfigurationType, JsonUnmarshallerContext> {
    private static EmailConfigurationTypeJsonUnmarshaller instance;

    EmailConfigurationTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public EmailConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        EmailConfigurationType emailConfigurationType = new EmailConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("SourceArn")) {
                emailConfigurationType.setSourceArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ReplyToEmailAddress")) {
                emailConfigurationType.setReplyToEmailAddress(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("EmailSendingAccount")) {
                emailConfigurationType.setEmailSendingAccount(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals(HttpHeaders.FROM)) {
                emailConfigurationType.setFrom(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ConfigurationSet")) {
                emailConfigurationType.setConfigurationSet(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return emailConfigurationType;
    }

    public static EmailConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EmailConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
