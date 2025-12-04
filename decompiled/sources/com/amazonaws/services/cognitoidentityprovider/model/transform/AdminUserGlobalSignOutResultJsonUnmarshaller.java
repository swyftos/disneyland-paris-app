package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminUserGlobalSignOutResultJsonUnmarshaller implements Unmarshaller<AdminUserGlobalSignOutResult, JsonUnmarshallerContext> {
    private static AdminUserGlobalSignOutResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminUserGlobalSignOutResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUserGlobalSignOutResult();
    }

    public static AdminUserGlobalSignOutResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUserGlobalSignOutResultJsonUnmarshaller();
        }
        return instance;
    }
}
