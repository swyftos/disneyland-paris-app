package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class UpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller<UpdateDeviceStatusResult, JsonUnmarshallerContext> {
    private static UpdateDeviceStatusResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateDeviceStatusResult();
    }

    public static UpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }
}
