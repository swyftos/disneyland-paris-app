package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminUpdateUserAttributesResultJsonUnmarshaller implements Unmarshaller<AdminUpdateUserAttributesResult, JsonUnmarshallerContext> {
    private static AdminUpdateUserAttributesResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminUpdateUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateUserAttributesResult();
    }

    public static AdminUpdateUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }
}
