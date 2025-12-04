package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.MessageTemplateType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class MessageTemplateTypeJsonMarshaller {
    private static MessageTemplateTypeJsonMarshaller instance;

    MessageTemplateTypeJsonMarshaller() {
    }

    public void marshall(MessageTemplateType messageTemplateType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (messageTemplateType.getSMSMessage() != null) {
            String sMSMessage = messageTemplateType.getSMSMessage();
            awsJsonWriter.name("SMSMessage");
            awsJsonWriter.value(sMSMessage);
        }
        if (messageTemplateType.getEmailMessage() != null) {
            String emailMessage = messageTemplateType.getEmailMessage();
            awsJsonWriter.name("EmailMessage");
            awsJsonWriter.value(emailMessage);
        }
        if (messageTemplateType.getEmailSubject() != null) {
            String emailSubject = messageTemplateType.getEmailSubject();
            awsJsonWriter.name("EmailSubject");
            awsJsonWriter.value(emailSubject);
        }
        awsJsonWriter.endObject();
    }

    public static MessageTemplateTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new MessageTemplateTypeJsonMarshaller();
        }
        return instance;
    }
}
