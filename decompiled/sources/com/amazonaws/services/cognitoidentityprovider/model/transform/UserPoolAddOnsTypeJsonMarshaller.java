package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class UserPoolAddOnsTypeJsonMarshaller {
    private static UserPoolAddOnsTypeJsonMarshaller instance;

    UserPoolAddOnsTypeJsonMarshaller() {
    }

    public void marshall(UserPoolAddOnsType userPoolAddOnsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (userPoolAddOnsType.getAdvancedSecurityMode() != null) {
            String advancedSecurityMode = userPoolAddOnsType.getAdvancedSecurityMode();
            awsJsonWriter.name("AdvancedSecurityMode");
            awsJsonWriter.value(advancedSecurityMode);
        }
        awsJsonWriter.endObject();
    }

    public static UserPoolAddOnsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolAddOnsTypeJsonMarshaller();
        }
        return instance;
    }
}
