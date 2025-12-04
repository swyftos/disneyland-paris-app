package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class GetDeviceResultJsonUnmarshaller implements Unmarshaller<GetDeviceResult, JsonUnmarshallerContext> {
    private static GetDeviceResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public GetDeviceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetDeviceResult getDeviceResult = new GetDeviceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Device")) {
                getDeviceResult.setDevice(DeviceTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getDeviceResult;
    }

    public static GetDeviceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetDeviceResultJsonUnmarshaller();
        }
        return instance;
    }
}
