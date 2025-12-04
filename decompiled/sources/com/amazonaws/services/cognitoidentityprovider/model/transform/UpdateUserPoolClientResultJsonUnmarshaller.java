package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class UpdateUserPoolClientResultJsonUnmarshaller implements Unmarshaller<UpdateUserPoolClientResult, JsonUnmarshallerContext> {
    private static UpdateUserPoolClientResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateUserPoolClientResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateUserPoolClientResult updateUserPoolClientResult = new UpdateUserPoolClientResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserPoolClient")) {
                updateUserPoolClientResult.setUserPoolClient(UserPoolClientTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateUserPoolClientResult;
    }

    public static UpdateUserPoolClientResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateUserPoolClientResultJsonUnmarshaller();
        }
        return instance;
    }
}
