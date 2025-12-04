package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.PasswordPolicyType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class PasswordPolicyTypeJsonMarshaller {
    private static PasswordPolicyTypeJsonMarshaller instance;

    PasswordPolicyTypeJsonMarshaller() {
    }

    public void marshall(PasswordPolicyType passwordPolicyType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (passwordPolicyType.getMinimumLength() != null) {
            Integer minimumLength = passwordPolicyType.getMinimumLength();
            awsJsonWriter.name("MinimumLength");
            awsJsonWriter.value(minimumLength);
        }
        if (passwordPolicyType.getRequireUppercase() != null) {
            Boolean requireUppercase = passwordPolicyType.getRequireUppercase();
            awsJsonWriter.name("RequireUppercase");
            awsJsonWriter.value(requireUppercase.booleanValue());
        }
        if (passwordPolicyType.getRequireLowercase() != null) {
            Boolean requireLowercase = passwordPolicyType.getRequireLowercase();
            awsJsonWriter.name("RequireLowercase");
            awsJsonWriter.value(requireLowercase.booleanValue());
        }
        if (passwordPolicyType.getRequireNumbers() != null) {
            Boolean requireNumbers = passwordPolicyType.getRequireNumbers();
            awsJsonWriter.name("RequireNumbers");
            awsJsonWriter.value(requireNumbers.booleanValue());
        }
        if (passwordPolicyType.getRequireSymbols() != null) {
            Boolean requireSymbols = passwordPolicyType.getRequireSymbols();
            awsJsonWriter.name("RequireSymbols");
            awsJsonWriter.value(requireSymbols.booleanValue());
        }
        if (passwordPolicyType.getTemporaryPasswordValidityDays() != null) {
            Integer temporaryPasswordValidityDays = passwordPolicyType.getTemporaryPasswordValidityDays();
            awsJsonWriter.name("TemporaryPasswordValidityDays");
            awsJsonWriter.value(temporaryPasswordValidityDays);
        }
        awsJsonWriter.endObject();
    }

    public static PasswordPolicyTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new PasswordPolicyTypeJsonMarshaller();
        }
        return instance;
    }
}
