package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ForgotPasswordResultJsonUnmarshaller implements Unmarshaller<ForgotPasswordResult, JsonUnmarshallerContext> {
    private static ForgotPasswordResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ForgotPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ForgotPasswordResult forgotPasswordResult = new ForgotPasswordResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetails")) {
                forgotPasswordResult.setCodeDeliveryDetails(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return forgotPasswordResult;
    }

    public static ForgotPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ForgotPasswordResultJsonUnmarshaller();
        }
        return instance;
    }
}
