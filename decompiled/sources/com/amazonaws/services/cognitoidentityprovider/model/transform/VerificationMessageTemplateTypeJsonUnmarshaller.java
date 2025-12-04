package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.VerificationMessageTemplateType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class VerificationMessageTemplateTypeJsonUnmarshaller implements Unmarshaller<VerificationMessageTemplateType, JsonUnmarshallerContext> {
    private static VerificationMessageTemplateTypeJsonUnmarshaller instance;

    VerificationMessageTemplateTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public VerificationMessageTemplateType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        VerificationMessageTemplateType verificationMessageTemplateType = new VerificationMessageTemplateType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("SmsMessage")) {
                verificationMessageTemplateType.setSmsMessage(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("EmailMessage")) {
                verificationMessageTemplateType.setEmailMessage(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("EmailSubject")) {
                verificationMessageTemplateType.setEmailSubject(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("EmailMessageByLink")) {
                verificationMessageTemplateType.setEmailMessageByLink(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("EmailSubjectByLink")) {
                verificationMessageTemplateType.setEmailSubjectByLink(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("DefaultEmailOption")) {
                verificationMessageTemplateType.setDefaultEmailOption(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return verificationMessageTemplateType;
    }

    public static VerificationMessageTemplateTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerificationMessageTemplateTypeJsonUnmarshaller();
        }
        return instance;
    }
}
