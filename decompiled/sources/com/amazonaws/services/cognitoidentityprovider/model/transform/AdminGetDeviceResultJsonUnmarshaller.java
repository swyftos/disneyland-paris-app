package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class AdminGetDeviceResultJsonUnmarshaller implements Unmarshaller<AdminGetDeviceResult, JsonUnmarshallerContext> {
    private static AdminGetDeviceResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminGetDeviceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminGetDeviceResult adminGetDeviceResult = new AdminGetDeviceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Device")) {
                adminGetDeviceResult.setDevice(DeviceTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminGetDeviceResult;
    }

    public static AdminGetDeviceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminGetDeviceResultJsonUnmarshaller();
        }
        return instance;
    }
}
