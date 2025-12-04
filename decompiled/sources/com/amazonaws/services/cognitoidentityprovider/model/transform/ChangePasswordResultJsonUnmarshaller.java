package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class ChangePasswordResultJsonUnmarshaller implements Unmarshaller<ChangePasswordResult, JsonUnmarshallerContext> {
    private static ChangePasswordResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ChangePasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ChangePasswordResult();
    }

    public static ChangePasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChangePasswordResultJsonUnmarshaller();
        }
        return instance;
    }
}
