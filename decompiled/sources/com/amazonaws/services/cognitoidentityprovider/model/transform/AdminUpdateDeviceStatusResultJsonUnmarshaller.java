package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminUpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller<AdminUpdateDeviceStatusResult, JsonUnmarshallerContext> {
    private static AdminUpdateDeviceStatusResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminUpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateDeviceStatusResult();
    }

    public static AdminUpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }
}
