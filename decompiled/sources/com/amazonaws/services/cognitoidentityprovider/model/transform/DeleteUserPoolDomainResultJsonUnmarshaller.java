package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class DeleteUserPoolDomainResultJsonUnmarshaller implements Unmarshaller<DeleteUserPoolDomainResult, JsonUnmarshallerContext> {
    private static DeleteUserPoolDomainResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public DeleteUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserPoolDomainResult();
    }

    public static DeleteUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }
}
