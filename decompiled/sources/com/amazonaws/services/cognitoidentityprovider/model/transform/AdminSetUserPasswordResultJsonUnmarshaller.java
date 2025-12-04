package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminSetUserPasswordResultJsonUnmarshaller implements Unmarshaller<AdminSetUserPasswordResult, JsonUnmarshallerContext> {
    private static AdminSetUserPasswordResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminSetUserPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminSetUserPasswordResult();
    }

    public static AdminSetUserPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminSetUserPasswordResultJsonUnmarshaller();
        }
        return instance;
    }
}
