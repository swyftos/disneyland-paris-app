package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class DeviceSecretVerifierConfigTypeJsonMarshaller {
    private static DeviceSecretVerifierConfigTypeJsonMarshaller instance;

    DeviceSecretVerifierConfigTypeJsonMarshaller() {
    }

    public void marshall(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (deviceSecretVerifierConfigType.getPasswordVerifier() != null) {
            String passwordVerifier = deviceSecretVerifierConfigType.getPasswordVerifier();
            awsJsonWriter.name("PasswordVerifier");
            awsJsonWriter.value(passwordVerifier);
        }
        if (deviceSecretVerifierConfigType.getSalt() != null) {
            String salt = deviceSecretVerifierConfigType.getSalt();
            awsJsonWriter.name("Salt");
            awsJsonWriter.value(salt);
        }
        awsJsonWriter.endObject();
    }

    public static DeviceSecretVerifierConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new DeviceSecretVerifierConfigTypeJsonMarshaller();
        }
        return instance;
    }
}
