package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ResendConfirmationCodeResultJsonUnmarshaller implements Unmarshaller<ResendConfirmationCodeResult, JsonUnmarshallerContext> {
    private static ResendConfirmationCodeResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ResendConfirmationCodeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ResendConfirmationCodeResult resendConfirmationCodeResult = new ResendConfirmationCodeResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetails")) {
                resendConfirmationCodeResult.setCodeDeliveryDetails(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return resendConfirmationCodeResult;
    }

    public static ResendConfirmationCodeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ResendConfirmationCodeResultJsonUnmarshaller();
        }
        return instance;
    }
}
