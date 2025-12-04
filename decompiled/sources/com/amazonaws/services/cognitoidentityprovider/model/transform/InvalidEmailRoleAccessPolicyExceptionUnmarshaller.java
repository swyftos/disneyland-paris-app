package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidEmailRoleAccessPolicyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidEmailRoleAccessPolicyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidEmailRoleAccessPolicyExceptionUnmarshaller() {
        super(InvalidEmailRoleAccessPolicyException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidEmailRoleAccessPolicyException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidEmailRoleAccessPolicyException invalidEmailRoleAccessPolicyException = (InvalidEmailRoleAccessPolicyException) super.unmarshall(jsonErrorResponse);
        invalidEmailRoleAccessPolicyException.setErrorCode("InvalidEmailRoleAccessPolicyException");
        return invalidEmailRoleAccessPolicyException;
    }
}
