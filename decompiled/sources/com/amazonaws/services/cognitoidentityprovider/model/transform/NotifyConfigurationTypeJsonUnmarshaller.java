package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NotifyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.google.common.net.HttpHeaders;
import java.io.IOException;

/* loaded from: classes2.dex */
class NotifyConfigurationTypeJsonUnmarshaller implements Unmarshaller<NotifyConfigurationType, JsonUnmarshallerContext> {
    private static NotifyConfigurationTypeJsonUnmarshaller instance;

    NotifyConfigurationTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public NotifyConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        NotifyConfigurationType notifyConfigurationType = new NotifyConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals(HttpHeaders.FROM)) {
                notifyConfigurationType.setFrom(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ReplyTo")) {
                notifyConfigurationType.setReplyTo(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("SourceArn")) {
                notifyConfigurationType.setSourceArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("BlockEmail")) {
                notifyConfigurationType.setBlockEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NoActionEmail")) {
                notifyConfigurationType.setNoActionEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("MfaEmail")) {
                notifyConfigurationType.setMfaEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return notifyConfigurationType;
    }

    public static NotifyConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new NotifyConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
