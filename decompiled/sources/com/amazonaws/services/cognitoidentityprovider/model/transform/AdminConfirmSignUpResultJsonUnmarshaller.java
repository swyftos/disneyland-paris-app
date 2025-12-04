package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class AdminConfirmSignUpResultJsonUnmarshaller implements Unmarshaller<AdminConfirmSignUpResult, JsonUnmarshallerContext> {
    private static AdminConfirmSignUpResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminConfirmSignUpResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminConfirmSignUpResult();
    }

    public static AdminConfirmSignUpResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminConfirmSignUpResultJsonUnmarshaller();
        }
        return instance;
    }
}
