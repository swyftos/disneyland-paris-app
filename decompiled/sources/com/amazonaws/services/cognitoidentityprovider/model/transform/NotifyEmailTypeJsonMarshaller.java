package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NotifyEmailType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class NotifyEmailTypeJsonMarshaller {
    private static NotifyEmailTypeJsonMarshaller instance;

    NotifyEmailTypeJsonMarshaller() {
    }

    public void marshall(NotifyEmailType notifyEmailType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (notifyEmailType.getSubject() != null) {
            String subject = notifyEmailType.getSubject();
            awsJsonWriter.name("Subject");
            awsJsonWriter.value(subject);
        }
        if (notifyEmailType.getHtmlBody() != null) {
            String htmlBody = notifyEmailType.getHtmlBody();
            awsJsonWriter.name("HtmlBody");
            awsJsonWriter.value(htmlBody);
        }
        if (notifyEmailType.getTextBody() != null) {
            String textBody = notifyEmailType.getTextBody();
            awsJsonWriter.name("TextBody");
            awsJsonWriter.value(textBody);
        }
        awsJsonWriter.endObject();
    }

    public static NotifyEmailTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new NotifyEmailTypeJsonMarshaller();
        }
        return instance;
    }
}
