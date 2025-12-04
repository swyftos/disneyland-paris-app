package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetUICustomizationResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class GetUICustomizationResultJsonUnmarshaller implements Unmarshaller<GetUICustomizationResult, JsonUnmarshallerContext> {
    private static GetUICustomizationResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public GetUICustomizationResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetUICustomizationResult getUICustomizationResult = new GetUICustomizationResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UICustomization")) {
                getUICustomizationResult.setUICustomization(UICustomizationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getUICustomizationResult;
    }

    public static GetUICustomizationResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetUICustomizationResultJsonUnmarshaller();
        }
        return instance;
    }
}
