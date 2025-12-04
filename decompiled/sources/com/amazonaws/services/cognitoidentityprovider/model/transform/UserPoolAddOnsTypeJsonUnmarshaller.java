package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class UserPoolAddOnsTypeJsonUnmarshaller implements Unmarshaller<UserPoolAddOnsType, JsonUnmarshallerContext> {
    private static UserPoolAddOnsTypeJsonUnmarshaller instance;

    UserPoolAddOnsTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public UserPoolAddOnsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UserPoolAddOnsType userPoolAddOnsType = new UserPoolAddOnsType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("AdvancedSecurityMode")) {
                userPoolAddOnsType.setAdvancedSecurityMode(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return userPoolAddOnsType;
    }

    public static UserPoolAddOnsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolAddOnsTypeJsonUnmarshaller();
        }
        return instance;
    }
}
