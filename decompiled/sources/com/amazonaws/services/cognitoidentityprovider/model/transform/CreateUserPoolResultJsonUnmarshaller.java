package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class CreateUserPoolResultJsonUnmarshaller implements Unmarshaller<CreateUserPoolResult, JsonUnmarshallerContext> {
    private static CreateUserPoolResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public CreateUserPoolResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateUserPoolResult createUserPoolResult = new CreateUserPoolResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserPool")) {
                createUserPoolResult.setUserPool(UserPoolTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createUserPoolResult;
    }

    public static CreateUserPoolResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateUserPoolResultJsonUnmarshaller();
        }
        return instance;
    }
}
