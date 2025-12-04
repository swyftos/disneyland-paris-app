package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.PasswordPolicyType;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolPolicyType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class UserPoolPolicyTypeJsonMarshaller {
    private static UserPoolPolicyTypeJsonMarshaller instance;

    UserPoolPolicyTypeJsonMarshaller() {
    }

    public void marshall(UserPoolPolicyType userPoolPolicyType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (userPoolPolicyType.getPasswordPolicy() != null) {
            PasswordPolicyType passwordPolicy = userPoolPolicyType.getPasswordPolicy();
            awsJsonWriter.name("PasswordPolicy");
            PasswordPolicyTypeJsonMarshaller.getInstance().marshall(passwordPolicy, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static UserPoolPolicyTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolPolicyTypeJsonMarshaller();
        }
        return instance;
    }
}
