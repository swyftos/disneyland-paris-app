package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class UpdateUserAttributesResultJsonUnmarshaller implements Unmarshaller<UpdateUserAttributesResult, JsonUnmarshallerContext> {
    private static UpdateUserAttributesResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateUserAttributesResult updateUserAttributesResult = new UpdateUserAttributesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetailsList")) {
                updateUserAttributesResult.setCodeDeliveryDetailsList(new ListUnmarshaller(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateUserAttributesResult;
    }

    public static UpdateUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }
}
