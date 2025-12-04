package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class AdminCreateUserResultJsonUnmarshaller implements Unmarshaller<AdminCreateUserResult, JsonUnmarshallerContext> {
    private static AdminCreateUserResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminCreateUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminCreateUserResult adminCreateUserResult = new AdminCreateUserResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("User")) {
                adminCreateUserResult.setUser(UserTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminCreateUserResult;
    }

    public static AdminCreateUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminCreateUserResultJsonUnmarshaller();
        }
        return instance;
    }
}
