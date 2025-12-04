package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminEnableUserResultJsonUnmarshaller implements Unmarshaller<AdminEnableUserResult, JsonUnmarshallerContext> {
    private static AdminEnableUserResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminEnableUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminEnableUserResult();
    }

    public static AdminEnableUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminEnableUserResultJsonUnmarshaller();
        }
        return instance;
    }
}
