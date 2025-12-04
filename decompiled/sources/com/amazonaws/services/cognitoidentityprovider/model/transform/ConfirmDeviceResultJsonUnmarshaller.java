package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ConfirmDeviceResultJsonUnmarshaller implements Unmarshaller<ConfirmDeviceResult, JsonUnmarshallerContext> {
    private static ConfirmDeviceResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ConfirmDeviceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ConfirmDeviceResult confirmDeviceResult = new ConfirmDeviceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserConfirmationNecessary")) {
                confirmDeviceResult.setUserConfirmationNecessary(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return confirmDeviceResult;
    }

    public static ConfirmDeviceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmDeviceResultJsonUnmarshaller();
        }
        return instance;
    }
}
