package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class SMSMfaSettingsTypeJsonMarshaller {
    private static SMSMfaSettingsTypeJsonMarshaller instance;

    SMSMfaSettingsTypeJsonMarshaller() {
    }

    public void marshall(SMSMfaSettingsType sMSMfaSettingsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (sMSMfaSettingsType.getEnabled() != null) {
            Boolean enabled = sMSMfaSettingsType.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        if (sMSMfaSettingsType.getPreferredMfa() != null) {
            Boolean preferredMfa = sMSMfaSettingsType.getPreferredMfa();
            awsJsonWriter.name("PreferredMfa");
            awsJsonWriter.value(preferredMfa.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static SMSMfaSettingsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SMSMfaSettingsTypeJsonMarshaller();
        }
        return instance;
    }
}
