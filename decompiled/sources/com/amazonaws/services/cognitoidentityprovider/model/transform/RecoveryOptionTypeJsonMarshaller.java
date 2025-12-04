package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RecoveryOptionType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class RecoveryOptionTypeJsonMarshaller {
    private static RecoveryOptionTypeJsonMarshaller instance;

    RecoveryOptionTypeJsonMarshaller() {
    }

    public void marshall(RecoveryOptionType recoveryOptionType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (recoveryOptionType.getPriority() != null) {
            Integer priority = recoveryOptionType.getPriority();
            awsJsonWriter.name("Priority");
            awsJsonWriter.value(priority);
        }
        if (recoveryOptionType.getName() != null) {
            String name = recoveryOptionType.getName();
            awsJsonWriter.name("Name");
            awsJsonWriter.value(name);
        }
        awsJsonWriter.endObject();
    }

    public static RecoveryOptionTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RecoveryOptionTypeJsonMarshaller();
        }
        return instance;
    }
}
