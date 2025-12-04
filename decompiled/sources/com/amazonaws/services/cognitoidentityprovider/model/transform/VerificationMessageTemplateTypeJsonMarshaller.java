package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.VerificationMessageTemplateType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class VerificationMessageTemplateTypeJsonMarshaller {
    private static VerificationMessageTemplateTypeJsonMarshaller instance;

    VerificationMessageTemplateTypeJsonMarshaller() {
    }

    public void marshall(VerificationMessageTemplateType verificationMessageTemplateType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (verificationMessageTemplateType.getSmsMessage() != null) {
            String smsMessage = verificationMessageTemplateType.getSmsMessage();
            awsJsonWriter.name("SmsMessage");
            awsJsonWriter.value(smsMessage);
        }
        if (verificationMessageTemplateType.getEmailMessage() != null) {
            String emailMessage = verificationMessageTemplateType.getEmailMessage();
            awsJsonWriter.name("EmailMessage");
            awsJsonWriter.value(emailMessage);
        }
        if (verificationMessageTemplateType.getEmailSubject() != null) {
            String emailSubject = verificationMessageTemplateType.getEmailSubject();
            awsJsonWriter.name("EmailSubject");
            awsJsonWriter.value(emailSubject);
        }
        if (verificationMessageTemplateType.getEmailMessageByLink() != null) {
            String emailMessageByLink = verificationMessageTemplateType.getEmailMessageByLink();
            awsJsonWriter.name("EmailMessageByLink");
            awsJsonWriter.value(emailMessageByLink);
        }
        if (verificationMessageTemplateType.getEmailSubjectByLink() != null) {
            String emailSubjectByLink = verificationMessageTemplateType.getEmailSubjectByLink();
            awsJsonWriter.name("EmailSubjectByLink");
            awsJsonWriter.value(emailSubjectByLink);
        }
        if (verificationMessageTemplateType.getDefaultEmailOption() != null) {
            String defaultEmailOption = verificationMessageTemplateType.getDefaultEmailOption();
            awsJsonWriter.name("DefaultEmailOption");
            awsJsonWriter.value(defaultEmailOption);
        }
        awsJsonWriter.endObject();
    }

    public static VerificationMessageTemplateTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new VerificationMessageTemplateTypeJsonMarshaller();
        }
        return instance;
    }
}
