package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AddCustomAttributesResultJsonUnmarshaller implements Unmarshaller<AddCustomAttributesResult, JsonUnmarshallerContext> {
    private static AddCustomAttributesResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AddCustomAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AddCustomAttributesResult();
    }

    public static AddCustomAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AddCustomAttributesResultJsonUnmarshaller();
        }
        return instance;
    }
}
