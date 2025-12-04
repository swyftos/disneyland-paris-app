package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class SoftwareTokenMfaSettingsTypeJsonMarshaller {
    private static SoftwareTokenMfaSettingsTypeJsonMarshaller instance;

    SoftwareTokenMfaSettingsTypeJsonMarshaller() {
    }

    public void marshall(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (softwareTokenMfaSettingsType.getEnabled() != null) {
            Boolean enabled = softwareTokenMfaSettingsType.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        if (softwareTokenMfaSettingsType.getPreferredMfa() != null) {
            Boolean preferredMfa = softwareTokenMfaSettingsType.getPreferredMfa();
            awsJsonWriter.name("PreferredMfa");
            awsJsonWriter.value(preferredMfa.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static SoftwareTokenMfaSettingsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaSettingsTypeJsonMarshaller();
        }
        return instance;
    }
}
