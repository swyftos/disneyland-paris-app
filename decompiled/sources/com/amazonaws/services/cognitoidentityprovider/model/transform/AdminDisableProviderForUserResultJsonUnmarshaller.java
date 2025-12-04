package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminDisableProviderForUserResultJsonUnmarshaller implements Unmarshaller<AdminDisableProviderForUserResult, JsonUnmarshallerContext> {
    private static AdminDisableProviderForUserResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminDisableProviderForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDisableProviderForUserResult();
    }

    public static AdminDisableProviderForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDisableProviderForUserResultJsonUnmarshaller();
        }
        return instance;
    }
}
