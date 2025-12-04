package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminResetUserPasswordResultJsonUnmarshaller implements Unmarshaller<AdminResetUserPasswordResult, JsonUnmarshallerContext> {
    private static AdminResetUserPasswordResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminResetUserPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminResetUserPasswordResult();
    }

    public static AdminResetUserPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminResetUserPasswordResultJsonUnmarshaller();
        }
        return instance;
    }
}
